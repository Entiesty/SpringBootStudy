package com.example.springbootstudy.invoke;

import com.example.springbootstudy.intercept.Interceptor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invocation {
    private Object[] params;
    private Method method;
    private Object target;
    private Interceptor interceptor;

    public Object proceed() throws InvocationTargetException, IllegalAccessException {
        Object retObj = null;
        boolean exceptionFlag = false;
        this.interceptor.before();

        try {

            retObj = method.invoke(target, params);
        } catch (Exception ex) {
            exceptionFlag = true;
        }
        if (exceptionFlag) {
            this.interceptor.afterThrowing();
        } else {
            this.interceptor.afterReturning();
        }

        this.interceptor.after();
        return retObj;
    }
}
