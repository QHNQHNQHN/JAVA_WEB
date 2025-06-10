package com.itheima.controller;


import cn.hutool.core.io.IoUtil;
import com.itheima.pojo.User;
import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

//用户信息Controller
@RestController
//ResponseBody -> 作用：将Controller返回值直接作为响应体的数据直接响应；返回值是对象/集合 --> json --> 响应
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/list")
    public List<User> list() throws Exception {
        //1.调用service，获取数据
        List<User> userList = userService.findAll();
        //3.返回数据，转换为json格式
        return userList;
    }
/*
    @RequestMapping("/list")
    public List<User> list() throws Exception {
        //1.加载并读取user.txt文件，获取用户数据
        //借助Hutool中的工具类
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("user.txt");
        ArrayList<String> lines = IoUtil.readLines(in, StandardCharsets.UTF_8, new ArrayList<>());

        //2.解析用户信息，封装为User对象 --> list集合
        //因为获取的String是一行一行的数据
        List<User> userList = lines.stream().map(line -> {
            String[] parts = line.split(",");
            Integer id = Integer.parseInt(parts[0]);
            String username = parts[1];
            String password = parts[2];
            String name = parts[3];
            Integer age = Integer.parseInt(parts[4]);
            LocalDateTime updateTime = LocalDateTime.parse(parts[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            return new User(id, username, password, name, age, updateTime);
        }).toList();

        //3.返回数据，转换为json格式
        return userList;
    }
*/
}
