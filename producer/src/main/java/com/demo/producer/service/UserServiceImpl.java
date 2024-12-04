package com.demo.producer.service;

import com.demo.common.model.User;
import com.demo.common.service.UserService;

/**
 * @author zhaocc
 * @version 1.0
 * @date 2024-12-04 19:36
 */
public class UserServiceImpl implements UserService {
    @Override
    public User getUser() {
        return User.builder().id(1).name("张三").age(20).build();
    }
}
