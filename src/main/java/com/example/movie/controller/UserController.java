package com.example.movie.controller;


import com.example.movie.pojo.User;
import com.example.movie.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.jws.soap.SOAPBinding;
import java.util.List;


@RestController //将返回值信息以键值对的形式,json数据格式进行传输
@RequestMapping("/user")//当我们在浏览器的地址栏里面输入响应信息的时候使用
@CrossOrigin//允许前段后分离的时候的跨域操作
@Slf4j //日志打印信息的时候使用
public class UserController {
    @Resource
    private UserService userService;
    @PostMapping("/userreg")
    private int UserReg(@RequestBody User user){
        log.info("从页面得到的数据值："+user.getUsername()+" "+user.getPassword()+" "+user.getTruename()+" "+user.getUsersex()+" "+user.getUsertel());
        userService.userReg(user);
        return 1;
    }
    @PostMapping("/userlogin")
    private User UserLogin(@RequestBody User user){
        log.info("从页面得到的数据值："+user.getUsername()+" "+user.getPassword());
        User userLogin =userService.userLogin(user);
        log.info("查询到的数据："+user.getUsername()+" "+user.getPassword());
        return userLogin;
    }

}
