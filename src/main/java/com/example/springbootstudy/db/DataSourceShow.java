package com.example.springbootstudy.db;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class DataSourceShow implements ApplicationContextAware {
    @Override
    public void setApplicationContext(@NonNull ApplicationContext applicationContext) throws BeansException {
        var dataSource = applicationContext.getBean(DataSource.class);
        System.out.println("----------------");
        System.out.println(dataSource.getClass().getName());
        System.out.println("----------------");
    }
}
