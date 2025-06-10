package com.itheima;

import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest //SpringBoot单元测试的注解-当前测试类中的测试方法运行时，会启动springboot项目-IOC容器

class SpringbootMybaticsQuickstartApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testFindAll() {
        List<User> userList = userMapper.findAll();
        userList.forEach(System.out::println);
    }

    //测试删除操作
    @Test
    public void testDeleteById() {
        Integer i = userMapper.deleteById(4);
        System.out.println("执行完毕后影响的记录数 " + i);
    }

    //测试新增用户
    @Test
    public void testInsert() {
        User user = new User(null,"gaoyuanyuan","666888","高圆圆",18);
        userMapper.insert(user);
    }

    //更新新增用户
    @Test
    public void testUpdate() {
        User user = new User(1,"zhouyu","666888","周瑜",20);
        userMapper.update(user);
    }

    //更新新增用户
    @Test
    public void testFindByUsernameAndPassword() {
        User user = userMapper.findByUsernameAndPassword("zhouyu", "666888");
        System.out.println(user);
    }
}
