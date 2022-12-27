package com.example.movie.dao;

import com.example.movie.pojo.User;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper {
    public int userReg(User user);
    public User userLogin(User user);
}

