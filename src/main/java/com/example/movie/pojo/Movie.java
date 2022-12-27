package com.example.movie.pojo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Movie {
    private Integer id;
    private String name;
    private String img;
    private String description;
    private String director;
    private String writer;
    private String actor;
    private String type;
    private String area;
    private String language;
    private Timestamp showtime;
    private String length;
    private double grade;
    private Integer status;
    private String link;
}
