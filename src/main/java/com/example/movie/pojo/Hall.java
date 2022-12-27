package com.example.movie.pojo;

import lombok.Data;

@Data
public class Hall {
    private Integer id;//编号
    private String name;//名称
    private String seats;//座位
    private Integer status;//0可以使用 1不可以使用
}
