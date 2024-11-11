package com.example.springbootstudy.intercept;

import com.example.springbootstudy.invoke.Invocation;

public class MyInterceptor implements Interceptor{
    @Override
    public void before() {
        System.out.println("before......");
    }
    @Override
    public boolean useAround() {
        return true;
    }
    @Override
    public void after() {
        System.out.println("after......");
    }
    @Override
    public Object around(Invocation invocation) throws Throwable {
        System.out.println("around before");
        Object obj = invocation.proceed();
        System.out.println("around after");

        return obj;
    }
    @Override
    public void afterReturning() {
        System.out.println("afterReturning");
    }
    @Override
    public void afterThrowing() {
        System.out.println("afterThrowing");
    }
}
