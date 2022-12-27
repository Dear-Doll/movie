package com.example.movie.service;


import com.example.movie.pojo.Plan;
import com.example.movie.pojo.Result;

public interface PlanService {
    public Result<Plan> addPlan(Plan plan);
}
