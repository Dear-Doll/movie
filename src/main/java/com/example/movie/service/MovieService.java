package com.example.movie.service;

import com.example.movie.pojo.Movie;
import com.example.movie.pojo.Result;
import org.springframework.stereotype.Service;

import java.util.List;
public interface MovieService {
    List<Movie> findAll();

    Result<Movie> addMovie(Movie movie);
}
