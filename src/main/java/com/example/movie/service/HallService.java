package com.example.movie.service;

import com.example.movie.pojo.Admin;
import com.example.movie.pojo.Hall;
import com.example.movie.pojo.Movie;
import com.example.movie.pojo.Result;

import java.util.List;

public interface HallService {
    public Result<Hall> addHall(Hall hall);

    public List<Hall> findAll();

    //分页查询的service方法
    //pageNum当前页 pageSize每页显示记录数
    public List<Hall> findByPage(Integer pageNum,Integer pageSize);

    //查询总数据条数的方法
    public Integer findTotals();
}
