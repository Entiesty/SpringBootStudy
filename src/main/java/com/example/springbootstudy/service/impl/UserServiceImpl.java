package com.example.springbootstudy.service.impl;

import com.example.springbootstudy.pojo.User;
import com.example.springbootstudy.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void printUser(User user) {
        if(user == null) {
            throw new RuntimeException("检查用户参数是否为空......");
        }
        System.out.println("id = " + user.getId());
        System.out.println("\tusername = " + user.getUserName());
        System.out.println("\tnote = " + user.getNote());
    }

    @Override
    public void multiAspects() {
        System.out.println("测试多个切面顺序");
    }
}
