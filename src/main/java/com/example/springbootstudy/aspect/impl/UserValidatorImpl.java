package com.example.springbootstudy.aspect.impl;

import com.example.springbootstudy.aspect.validator.UserValidator;
import com.example.springbootstudy.pojo.User;

public class UserValidatorImpl implements UserValidator {
    @Override
    public boolean validate(User user) {
        System.out.println("引入新的接口：" + UserValidator.class.getSimpleName());
        return user != null;
    }
}
