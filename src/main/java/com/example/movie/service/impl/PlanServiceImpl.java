package com.example.movie.service.impl;

import com.example.movie.dao.PlanMapper;
import com.example.movie.pojo.Plan;
import com.example.movie.pojo.Result;
import com.example.movie.service.PlanService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

@Service
public class PlanServiceImpl implements PlanService {
    @Resource
    PlanMapper planMapper;
    @Override
    public Result<Plan> addPlan(Plan plan) {
        if (Objects.nonNull(plan)) {
            //从数据库返回信息来看，现实的是数据库中有几条信息受影响
            int n = planMapper.save(plan);
            if(n>0){
                //因为不可能有对象返回，所以这里对象给了一个null，查询操作才有数据返回
                return  Result.success("添加信息成功",null);
            }else{
                //没有数据被修改，
                return Result.fail("添加失败");
            }
        }
        return Result.fail("没有从Controller中受到一个有效的信息");
    }
}
