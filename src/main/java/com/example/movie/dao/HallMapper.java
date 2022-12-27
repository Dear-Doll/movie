package com.example.movie.dao;

import com.example.movie.pojo.Hall;
import org.apache.ibatis.annotations.Mapper;

/**
 * 我们在BaseMapper<Hall,Integer>使用的叫泛型，泛型中我们一旦将T和K进行具体的定义之后，
 * 凡是有T的地方就会自动变成Hall，凡是有K的地方自动变成Integer
 * 为了让我们程序执行过程中保证数据类型一致
 */
@Mapper
public interface HallMapper extends BaseMapper<Hall,Integer> {
    //父接口中已经有的方法，子接口就不写了
    //子接口只写自己独特具有的方法

}
