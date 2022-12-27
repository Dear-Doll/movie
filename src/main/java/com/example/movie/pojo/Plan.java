package com.example.movie.pojo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Plan {
    private Integer id;
    private Timestamp playtime;
    private double price;
    private String seats;
    private Integer status;
    private Integer hall_id;
    private Integer movie_id;
}
