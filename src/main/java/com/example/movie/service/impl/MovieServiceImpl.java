package com.example.movie.service.impl;

import com.example.movie.dao.MovieMapper;
import com.example.movie.pojo.Movie;
import com.example.movie.pojo.Result;
import com.example.movie.service.MovieService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@Service
public class MovieServiceImpl implements MovieService {
    @Resource
    MovieMapper movieMapper;

    @Override
    public List<Movie> findAll() {
        return movieMapper.findAll();
    }

    @Override
    public Result<Movie> addMovie(Movie movie) {
        if (Objects.nonNull(movie)) {
            //从数据库返回信息来看，现实的是数据库中有几条信息受影响
            int n = movieMapper.save(movie);
            if(n>0){
                //因为不可能有对象返回，所以这里对象给了一个null，查询操作才有数据返回
                return  Result.success("影片添加成功",null);
            }else{
                //没有数据被修改，
                return Result.fail("影片添加失败");
            }
        }
        return Result.fail("没有从Controller中受到一个有效的信息");
    }
}
