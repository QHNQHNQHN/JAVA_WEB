package com.itheima;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {
    @RequestMapping("/request")
    public String request(HttpServletRequest request){
        //1.获取请求方式
        String method = request.getMethod();
        System.out.println("请求方式：" + method); // GET
        //2.获取请求url地址
        String url = request.getRequestURL().toString();  // http://localhost:8080/request
        System.out.println("请求url地址："+url);
        String uri = request.getRequestURI(); //  /request
        System.out.println("请求url地址："+uri);
        //3.获取请求协议
        String protocol = request.getProtocol();// HTTP/1.1
        System.out.println("请求协议："+protocol);
        //4.获取请求参数-name
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        System.out.println("name:" + name + ",age:" + age);
        //5.获取请求头-Accept
        String accept = request.getHeader("Accept");
        System.out.println("Accept:" + accept);

        return "OK";
    }
}
