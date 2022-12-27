package com.example.movie.service.impl;

import com.example.movie.dao.AdminMapper;
import com.example.movie.pojo.Admin;
import com.example.movie.pojo.Result;
import com.example.movie.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

//添加一个注解让spring容器自动对service进行加载
@Service
public class AdminServiceImpl implements AdminService {

    @Resource //将类自动加载成资源然后进行调用，我们没有进行创建
    private AdminMapper adminMapper;

    //我们可以将mapper中的方法直接调用过来
    @Override
    public List<Admin> findAll() {
        return adminMapper.findAll();
    }

    //现在在service中进行逻辑判断
    @Override
    public Result<Admin> login(Admin admin) {
        //如果前端没有数据传来，不需要去数据库判断，前端传入为空，登录失败
        if(admin == null){
            return Result.fail("登录失败");
        }else{
            //前端不为空，根据前端信息查找后端得登录Admin
            Admin loginAdmin = adminMapper.findAdmin(admin);
            //成功，返回对象
            if (loginAdmin != null){
                return Result.success(loginAdmin);
            }else{
                //数据库中没找到对象返回，即loginAdmin为空
                return Result.fail(("登录失败"));
            }
        }
    }

}
