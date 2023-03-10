package com.example.movie.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


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
    //时间格式化注解
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date showtime;
    private String length;
    private double grade;
    private Integer status;
    private String link;
}
