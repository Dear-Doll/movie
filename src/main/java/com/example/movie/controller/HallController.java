package com.example.movie.controller;

import com.example.movie.pojo.Admin;
import com.example.movie.pojo.Hall;
import com.example.movie.pojo.Movie;
import com.example.movie.pojo.Result;
import com.example.movie.service.HallService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.awt.print.Pageable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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

    /**
     * mapper集合是以键值对的形式进行元素存储的，string是键，object是值
     * object是Java中所有的类的父类
     * @param pageNum 当前页数
     * @param pageSize 每页多少数据
     * @return
     */
    @GetMapping("findByPage")
    public Map<String, Object> findByPage(Integer pageNum,Integer pageSize){
        //Map是个接口，接口不能创建对象，hushmap是map的子类，类可以创建对象
        //创建一个集合对象用于存储我们要传给前端的值
        HashMap<String,Object> map = new HashMap<>();
        pageNum = pageNum == null ? 1 :pageNum; //如果为空显示第一页，不为空显示当前页
        pageSize = pageSize == null ? 2 : pageSize;
        log.info("pageNum = "+ pageNum + ",pageSize = "+pageSize);
        //调用service
        List<Hall> hallList = hallService.findByPage(pageNum,pageSize);
        Integer totals = hallService.findTotals();
        //计算总页数，总数对每页数据条数求余，余0的话，商是几，就是几页
        //如果求余不为0，在商的基础上加一就是页数
        Integer totalPage = totals % pageSize == 0 ? totals/pageSize : totals/pageSize+1;
        //将算出来的信息存储到map集合中，controller会将map数据转换成伪json数据，传递给页面
        map.put("hallList",hallList);
        map.put("totals",totals);
        map.put("totalPage",totalPage);
        map.put("pageNum",pageNum);
        return map;
    }
}
