package com.itheima;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ResponseController {
    //方式一：基于HttpServletResponse设置响应数据
    @RequestMapping("/response")
    public void response(HttpServletResponse response) throws IOException {
        //1.设置响应状态码
        response.setStatus(401);
        //2.设置响应头
        response.setHeader("name", "itheima");
        //3.设置相应体
        response.getWriter().write("<h1>hello response</h1>");
    }

    //方式二：基于ResponseEntity,Spring中提供的方式
    @RequestMapping("/response2")
    public ResponseEntity<String> response2() {
        return ResponseEntity
                .status(401)//1.设置响应状态码
                .header("name", "javaweb")//2.设置响应头
                .body("<h1>hello response</h1>");//3.设置相应体
    }
}
