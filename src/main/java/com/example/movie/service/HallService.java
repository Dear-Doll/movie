package com.example.movie.service;

import com.example.movie.pojo.Admin;
import com.example.movie.pojo.Hall;
import com.example.movie.pojo.Movie;
import com.example.movie.pojo.Result;

import java.util.List;

public interface HallService {
    public Result<Hall> addHall(Hall hall);

    public List<Hall> findAll();
}
