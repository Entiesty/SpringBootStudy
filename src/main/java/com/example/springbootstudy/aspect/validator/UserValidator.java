package com.example.springbootstudy.aspect.validator;

import com.example.springbootstudy.pojo.User;

public interface UserValidator {
    boolean validate(User user);
}
