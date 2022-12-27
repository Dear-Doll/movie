package com.example.movie.service;

import com.example.movie.pojo.User;

public interface UserService {
    public int userReg(User user);
    public User userLogin(User user);
}
