package com.example.springbootstudy.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyAspect3 {
    private static final String exp =
            "execution(* com.example.springbootstudy.service.impl.UserServiceImpl.multiAspects(..))";

    @Pointcut(exp)
    public void multiAspects() {
    }

    @Before("multiAspects()")
    public void before() {
        System.out.println("MyAspect3 before......");
    }

    @After("multiAspects()")
    public void after() {
        System.out.println("MyAspect3 after......");
    }

    @AfterReturning("multiAspects()")
    public void afterReturning() {
        System.out.println("MyAspect3 afterReturning......");
    }
}
