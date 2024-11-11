package com.example.springbootstudy.life;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class BeanPostProcessorExample implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(@NonNull Object bean,@NonNull String beanName)
            throws BeansException {
        System.out.println("BeanPostProcessor调用" + "postProcessBeforeInitialization()方法，参数【"
        + bean.getClass().getSimpleName() + "】【" + beanName + "】");

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(@NonNull Object bean,@NonNull String beanName)
            throws BeansException {
        System.out.println("BeanPostProcessor调用" + "postProcessAfterInitialization()方法，参数【"
                + bean.getClass().getSimpleName() + "】【" + beanName + "】");

        return bean;
    }
}
