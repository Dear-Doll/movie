package com.example.movie.controller;

import com.example.movie.pojo.Hall;
import com.example.movie.pojo.Movie;
import com.example.movie.pojo.Result;
import com.example.movie.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/movie")
@CrossOrigin
@Slf4j
public class MovieController {
    @Resource
    MovieService movieService;
    @GetMapping("/findAllMovie")
    public List<Movie> findAllMovie(){
        List<Movie> movies = movieService.findAll();
        return movies;
    }

    @PostMapping("/addMovie")
    public Result<Movie> addMovie(@RequestParam("file") MultipartFile file,Movie movie) throws IOException {
        /**
         * FilenameUtils:是一个用来处理文件名称的类,这是一个包的引用
         * 可以使用alt + 回车,选择maven导包
         * 获取到文件的扩展名信息,也就是文件的后缀名,我们在上只拿到了我们上传的图片是什么后缀名的
         * getOriginalFilename:获取到最初始的文件名称
         */
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        //因为我们上传的文件名称可能相同,所以我们需要对文件名称进行更改,现在使用一个uuid的技术
        //uuid是一个唯一的识别码,使用uuid能够保证我们生成的字符串不相同,在这里我们使用到文件中保证文件名称不重复
        String newFileName = UUID.randomUUID()+"."+extension;
        //产生一个新的文件夹,来存储我们上传的图片
        File saveDir = new File("D:\\Servlet_app\\movie\\src\\main\\resources\\upload");
        //使用常用类File,去自动产生一个文件夹存储上传的文件.
        //首先我们判断文件夹是否存在,如果不存在就创建一个
        //mkdirs:创建我们需要的文件目录以及父目录
        //mkdir:创建我们所需要的文件目录
        if(!saveDir.exists()){
            saveDir.mkdirs();
        }
        //创建一个对象里面包含了存储文件地址和新文件的名称
        File uploadFile = new File(saveDir,newFileName);
        //将文件进行上传
        file.transferTo(uploadFile);
        //因为以上做的事情都是在对文件上传进行处理，从前端传过来的信息里面并不包括文件地址，
        // 因为我们是上传了文件进来，但是在数据库里面只能存储文件地址而不能存储文件本身
        //对movie信息中的图片地址的信息进行赋值
        movie.setImg(saveDir+newFileName);
        log.info("文件地址信息："+movie.getImg());
        return movieService.addMovie(movie);//将电影信息写入到数据库中
    }
}
