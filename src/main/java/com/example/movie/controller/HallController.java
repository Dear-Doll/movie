package com.example.movie.controller;

import com.example.movie.pojo.Admin;
import com.example.movie.pojo.Hall;
import com.example.movie.pojo.Movie;
import com.example.movie.pojo.Result;
import com.example.movie.service.HallService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/hall")
@CrossOrigin
@Slf4j
public class HallController {
    @Resource
    HallService hallService;

    @GetMapping("/findUsableHall")
    public List<Hall> findUsableHall(){
        List<Hall> halls = hallService.findAll();
        return halls;
    }

    @PostMapping("/addHall")
    public Result<Hall> addHall(@RequestBody Hall hall){
        log.info("输出接收的值："+hall);
        Result<Hall> result = hallService.addHall(hall);
        log.info("传递给页面的值："+result);
        return result;
    }
}
