package com.example.movie.service.impl;

import com.example.movie.dao.HallMapper;
import com.example.movie.pojo.Admin;
import com.example.movie.pojo.Hall;
import com.example.movie.pojo.Movie;
import com.example.movie.pojo.Result;
import com.example.movie.service.HallService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@Service
public class HallServiceImpl implements HallService {

    @Resource
    HallMapper hallMapper;
    @Override
    public Result<Hall> addHall(Hall hall) {
        if (Objects.nonNull(hall)) {
            //从数据库返回信息来看，现实的是数据库中有几条信息受影响
            int n = hallMapper.save(hall);
            if(n>0){
                //因为不可能有对象返回，所以这里对象给了一个null，查询操作才有数据返回
                return  Result.success("添加信息成功",null);
            }else{
                //没有数据被修改，
                return Result.fail("添加失败");
            }
        }
        return Result.fail("没有从Controller中受到一个有效的信息");
    }

    @Override
    public List<Hall> findAll() {
        return hallMapper.findAll();
    }

    @Override
    public List<Hall> findByPage(Integer pageNum, Integer pageSize) {
        int start = (pageNum-1)*pageSize;
        int rows = pageSize;
        return hallMapper.findByPage(start,rows);
    }

    @Override
    public Integer findTotals() {
        return hallMapper.findTotals();
    }
}
