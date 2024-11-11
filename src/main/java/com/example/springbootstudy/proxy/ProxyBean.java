package com.example.springbootstudy.proxy;

import com.example.springbootstudy.intercept.Interceptor;
import com.example.springbootstudy.invoke.Invocation;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**** imports ****/
public class ProxyBean implements MethodInterceptor {

    // 拦截器
    private Interceptor interceptor = null;
    // 目标对象
    private Object target = null;

    /**
     * 生成代理对象
     * @param target 目标对象
     * @param interceptor 拦截器
     * @return 代理对象
     */
    public static Object getProxy(Object target, Interceptor interceptor) {
        var proxyBean = new ProxyBean();
        // 创建增强者
        var enhancer = new Enhancer();
        // 设置代理的类
        enhancer.setSuperclass(target.getClass());
        // 设置代理对象可以下挂到哪些接口下
        enhancer.setInterfaces(target.getClass().getInterfaces());
        // 保存目标对象
        proxyBean.target = target;
        // 保存拦截器
        proxyBean.interceptor = interceptor;
        // 回调proxyBean对象的intercept()方法
        enhancer.setCallback(proxyBean); // ①
        // 创建动态代理对象
        var proxy = enhancer.create();
        return proxy;
    }

    /**
     * 代理对象逻辑
     * @param proxy 代理对象
     * @param method 拦截方法
     * @param args 方法参数
     * @param mproxy 方法代理
     * @return 返回目标方法返回对象
     */
    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy mproxy)
            throws Throwable {
        // 回调对象
        var invocation = new Invocation(args, method, this.target, this.interceptor);
        Object result = null;
        if (this.interceptor.useAround()) { // 是否启用环绕通知
            result = this.interceptor.around(invocation);
        } else {

            result = invocation.proceed();
        }
        // 返回结果
        return result;
    }

}