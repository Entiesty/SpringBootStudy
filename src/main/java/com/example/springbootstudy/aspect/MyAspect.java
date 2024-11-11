package com.example.springbootstudy.aspect;

import com.example.springbootstudy.aspect.impl.UserValidatorImpl;
import com.example.springbootstudy.aspect.validator.UserValidator;
import com.example.springbootstudy.pojo.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
    private static final String aopExp =
            "execution( * com.example.springbootstudy.service.impl.UserServiceImpl.printUser(..))";

    @DeclareParents(value = "com.example.springbootstudy.service.impl.UserServiceImpl+",
    defaultImpl = UserValidatorImpl.class)
    public UserValidator userValidator;

    @Pointcut(aopExp)
    public void pointCut() {
    }

    @Around("pointCut()")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("around before......");
        jp.proceed();
        System.out.println("around after......");
    }

    @Before("pointCut() && args(user)")
    public void beforeParam(JoinPoint jp, User user) {
        System.out.println("传参前置通知，before......");
    }

    @Before("pointCut()")
    public void before() {
        System.out.println("before......");
    }

    @After("pointCut()")
    public void after() {
        System.out.println("after......");
    }

    @AfterReturning("pointCut()")
    public void afterReturning() {
        System.out.println("afterReturning......");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing() {
        System.out.println("afterThrowing......");
    }
}
