package com.example.springbootstudy.pojo;

import com.example.springbootstudy.def.Animal;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Cat implements Animal {
    @Override
    public void use() {
        System.out.println("猫【" + Cat.class.getSimpleName() + "】是看门用的。");
    }
}
