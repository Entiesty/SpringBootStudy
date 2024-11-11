package com.example.springbootstudy.pojo;

import com.example.springbootstudy.def.Animal;
import com.example.springbootstudy.def.Person;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class BusinessPerson implements Person, BeanNameAware, BeanFactoryAware, ApplicationContextAware,
        InitializingBean, DisposableBean {
    @Qualifier("dog")
    private final Animal animal;

    public BusinessPerson(@Qualifier("dog") Animal animal) {
        System.out.println("延迟依赖注入");
        this.animal = animal;
    }
    @Override
    public void service() {
        this.animal.use();
    }
    @Override
    public void setBeanName(@NonNull String name) {
        System.out.println("【" + this.getClass().getSimpleName() + "】调用BeanNameAware的setBeanName方法");
    }
    @Override
    public void setBeanFactory(@NonNull BeanFactory beanFactory) throws BeansException {
        System.out.println("【" + this.getClass().getSimpleName() + "】调用BeanFactoryAware的setBeanFactory方法");
    }
    @Override
    public void destroy() throws Exception {
        System.out.println("【" + this.getClass().getSimpleName() + "】DisposableBean()方法");
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("【" + this.getClass().getSimpleName() + "】调用InitializingBean的afterPropertiesSet方法");
    }
    @Override
    public void setApplicationContext(@NonNull ApplicationContext applicationContext) throws BeansException {
        System.out.println("【" + this.getClass().getSimpleName() + "】调用ApplicationContextAware的setApplicationContext方法");

    }
    @PostConstruct
    public void init() {
        System.out.println("【" + this.getClass().getSimpleName() + "】注解@PostConstruct自定义的初始化方法");
    }

    @PreDestroy
    public void destory1() {
        System.out.println("【" + this.getClass().getSimpleName() + "】注解@PreDestory自定义的销毁方法");
    }
}
