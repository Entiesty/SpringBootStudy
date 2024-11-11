package com.example.springbootstudy.main;

import com.example.springbootstudy.aspect.validator.UserValidator;
import com.example.springbootstudy.config.AopConfig;
import com.example.springbootstudy.intercept.MyInterceptor;
import com.example.springbootstudy.pojo.User;
import com.example.springbootstudy.proxy.ProxyBean;
import com.example.springbootstudy.service.HelloService;
import com.example.springbootstudy.service.UserService;
import com.example.springbootstudy.service.impl.HelloServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopTest {
    public static void main(String[] args) {
        testMultiAspects();
    }

    public static void testProxy() {
        HelloService helloService = new HelloServiceImpl();
        HelloService proxyBean = (HelloService)ProxyBean.getProxy(helloService,new MyInterceptor());
        proxyBean.sayHello("张三");
        System.out.println("#################测试异常#################");
        proxyBean.sayHello(null);
    }
    public static void testAop() {
        try (var ctx = new AnnotationConfigApplicationContext(AopConfig.class)) {
            var userService = ctx.getBean(UserService.class);
            User user = new User();
            user.setId(1L);
            user.setUserName("用户名1");
            user.setNote("备注1");
            userService.printUser(user);
            System.out.println("#################测试异常#################");
            userService.printUser(null);
        }
    }
    public static void testIntroduction() {
        try(var ctx = new AnnotationConfigApplicationContext(AopConfig.class)) {
            var userService = ctx.getBean(UserService.class);
            User user = new User();
            user.setId(1L);
            user.setUserName("用户名1");
            user.setNote("备注1");
            var userValidator = (UserValidator) userService;
            if(userValidator.validate(user)) {
                userService.printUser(user);
            }
        }
    }
    public static void testMultiAspects() {
        try(var ctx = new AnnotationConfigApplicationContext(AopConfig.class)) {
            var userService = ctx.getBean(UserService.class);
            userService.multiAspects();
        }
    }
}
