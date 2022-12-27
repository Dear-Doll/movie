package com.example.movie.service.impl;

import com.example.movie.dao.UserMapper;
import com.example.movie.pojo.User;
import com.example.movie.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public User userLogin(User user) {
        return userMapper.userLogin(user);
    }

    @Override
    public int userReg(User user) {
        return userMapper.userReg(user);
    }
}
