package com.example.movie.controller;

import com.example.movie.pojo.Hall;
import com.example.movie.pojo.Movie;
import com.example.movie.pojo.Result;
import com.example.movie.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/movie")
@CrossOrigin
@Slf4j
public class MovieController {
    @Resource
    MovieService movieService;
    @GetMapping("/findAllMovie")
    public List<Movie> findAllMovie(){
        List<Movie> movies = movieService.findAll();
        return movies;
    }

    @PostMapping("/addMovie")
    public Result<Movie> addMovie(@RequestBody Movie movie) {
        log.info("输出接收的值：" + movie);
        Result<Movie> result = movieService.addMovie(movie);
        log.info("传递给页面的值：" + result);
        return result;
    }
}
