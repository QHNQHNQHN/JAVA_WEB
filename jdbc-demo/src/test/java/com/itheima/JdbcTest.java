package com.itheima;

import com.itheima.pojo.User;
import com.mysql.cj.jdbc.Driver;
import org.junit.jupiter.api.Test;

import java.sql.*;

public class JdbcTest {

    //JDBC入门程序
    @Test
    public void testUpdate() throws Exception {
        //1.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获取数据库连接
        String url = "jdbc:mysql://localhost:3306/web01";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        //3.获取SQL语句执行对象
        Statement statement = connection.createStatement();
        //4.执行SQL
        int i = statement.executeUpdate("update user set age = 25 where id =1");//DML
        System.out.println("SQL执行完毕影响的记录数为：" + i);
        //5.释放资源
        statement.close();
        connection.close();
    }

    @Test
    public void testSelect() throws Exception {
        //1.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获取数据库连接
        String url = "jdbc:mysql://localhost:3306/web01";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        //3.执行查询
        //预编译SQL
        //? 为占位符，没有将参数值进行写死
        String sql ="select id, username, password, name, age from user where username = ? and password = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        // 1表示第一个占位符，2表示第二个占位符，
        stmt.setString(1, "daqiao");
        stmt.setString(2, "123456");
        //封装查询返回的结果
        ResultSet rs = stmt.executeQuery();
        //4.处理结果集
        while (rs.next()) {
            User user = new User(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("name"),
                    rs.getInt("age")
            );
            System.out.println(user);
        }
        //5.释放资源
        rs.close();
        stmt.close();
        connection.close();
    }
}
