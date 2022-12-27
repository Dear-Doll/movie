package com.example.movie.controller;

import com.example.movie.pojo.Admin;
import com.example.movie.pojo.Result;
import com.example.movie.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@RestController //将返回值信息以键值对的形式，json数据格式进行传输
@RequestMapping("/admin") //当我们在浏览器地址栏里面输入响应信息的时候使用
@ControllerAdvice //允许前后端分离的时候的跨域操作
@Slf4j //日志打印信息的时候使用
public class AdminController {
    //因为controller层信息执行的时候需要由service的支持，所以我们需要对service信息进行自动的加载
    @Resource
    private AdminService adminService;
    //http://localhost:9999/movie/admin/adminList
    //需要写一个方法对前端传过来的信息进行接收以及将信息返回到前端去
    //查询所有的管理员信息的方法
    @GetMapping("/adminList")
    public List<Admin> findAdminList(){
        List<Admin> admins = adminService.findAll();
        adminService.findAll();
        log.info("测试是否收到了"+admins);
        return admins;
    }

    @PostMapping("/login")
    public Result<Admin> login(@RequestBody Admin admin){
        log.info("从页面传过来的对象的值："+admin.getName()+","+admin.getPwd());
        //从service层获取数据库对象，将对象传入login方法中，通过login方法调用mapper中的findAdmin
        Result<Admin> result = adminService.login(admin);
        log.info("从数据库查到的对象信息"+result);
        return result;
    }
}
