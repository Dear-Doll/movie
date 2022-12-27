package com.example.movie.service;

import com.example.movie.pojo.Admin;
import com.example.movie.pojo.Result;

import java.util.List;

public interface AdminService {
    public List<Admin> findAll();
    public Result<Admin> login(Admin admin);
}


