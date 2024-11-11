package com.example.springbootstudy.main;

import com.example.springbootstudy.config.AppConfig;
import com.example.springbootstudy.pojo.BusinessPerson;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IoCTest {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class)) {
            var person = ctx.getBean(BusinessPerson.class);
            person.service();
        }
    }
}
