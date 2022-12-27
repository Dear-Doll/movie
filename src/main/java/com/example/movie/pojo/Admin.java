package com.example.movie.pojo;

import lombok.*;

//通过以下注解可以省去写方法的过程，由lombok进行处理
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
//@Data可以代替以上五个注解，可以只写这个
public class Admin {
    private Integer id;
    private String name;
    private String pwd;
    private String tel;
    private String status;
}
