package com.example.springbootstudy.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyAspect2 {
    private static final String exp =
            "execution(* com.example.springbootstudy.service.impl.UserServiceImpl.multiAspects(..))";

    @Pointcut(exp)
    public void multiAspects() {
    }

    @Before("multiAspects()")
    public void before() {
        System.out.println("MyAspect2 before......");
    }

    @After("multiAspects()")
    public void after() {
        System.out.println("MyAspect2 after......");
    }

    @AfterReturning("multiAspects()")
    public void afterReturning() {
        System.out.println("MyAspect2 afterReturning......");
    }
}
