package com.example.movie.dao;

import com.example.movie.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper //这个注解是一个映射器，一般用于我们需要对数据库语句进行处理的mybatis的接口中，这是告诉我们的系统
        //我们需要将这个接口进行自动加载
        //alt+enter     选择[mybatis]Generate mapper of xml
        //没有mybatis可以在包里新建一个file命名为Mapper，然后将文件头部信息粘贴进去即可
public interface AdminMapper {
    /**
     * 查询管理员方法，这是一个抽象方法，在接口中写抽象方法可以没有abstract修饰
     * 接口中还可以写静态常量，以及1.8以后可以写static和default
     * 修饰的可以有实现体的方法
     * 在抽象类中写抽象方法必须有abstract
     * @return 因为可以返回多条数据所以使用List集合
     */
    //当前这个方法是我们需要到数据库里面查询数据时候使用的接口
    //那么数据库的sql语句我们需要将其写在xml文件中，也就是说，在接口中提供了解决数据库查询数据的问题，
    //具体的解决方法在xml文件中，之前的web项目中，我们对于数据库的处理一般写在接口的实现类中，现在直接写在xml文件中
    public List<Admin> findAll();
    //现在有一个需要进行管理员信息插入的操作：addAdmin
    public Boolean addAdmin(List<Admin> list);
    //修改信息的操作：updataAdmin
//    public Boolean updataAdmin();
    //删除操作：deleteById
//    public Boolean deleteById(int id);
    //查询单个：findById
//    public  List<Admin> findById(int id);
    //通过名称查询
    public Admin findAdmin(Admin admin);
}
