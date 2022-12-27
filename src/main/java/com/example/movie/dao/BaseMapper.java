package com.example.movie.dao;

import com.example.movie.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 封装一些常用方法，每个对象都需要操纵的方法
 * 因为接口和接口是可以直接继承的，所以当前的接口作为一个父接口
     * 让其余的接口对其进行继承，重复的方法就不写了，只写单独的方法
 * T:表示我么要处理的实体类 Admin
 * K：表示主键字段的数据类型 Integer
 */
@Mapper
public interface BaseMapper<T,K> {
    //添加信息
    public int save(T t);
    //修改信息
    public int update(T t);
    //根据主键删除信息
    public int delete(K k);
    //根据主键查询单个信息
    public T findOne(K k);
    //查询所以信息
    public List<T> findAll();
    //分页查询信息
    public List<T> findByPage(@Param("start") Integer start,
                              @Param("rows") Integer rows);
    //查询表中总记录条数
    public Integer findTotals();

}
