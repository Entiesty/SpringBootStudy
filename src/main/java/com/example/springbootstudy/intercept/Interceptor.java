package com.example.springbootstudy.intercept;

import com.example.springbootstudy.invoke.Invocation;

public interface Interceptor {
    void before();
    void after();
    Object around(Invocation invocation) throws Throwable;
    void afterReturning();
    void afterThrowing();
    default boolean useAround() {
        return false;
    }
}
