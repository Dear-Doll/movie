package com.example.movie.controller;

import com.example.movie.pojo.Plan;
import com.example.movie.pojo.Result;
import com.example.movie.service.PlanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/plan")
@CrossOrigin
@Slf4j
public class PlanController {
    @Resource
    PlanService planService;
    @PostMapping("/addPlan")
    public Result<Plan> addPlan(@RequestBody Plan plan) {
        log.info("输出接收的值：" + plan);
        Result<Plan> result = planService.addPlan(plan);
        log.info("传递给页面的值：" + result);
        return result;
    }
}
