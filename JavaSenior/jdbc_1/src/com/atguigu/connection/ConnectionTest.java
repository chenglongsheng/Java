package com.atguigu.connection;

import org.junit.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author chenglongsheng
 * @create 2021-06-25 22:19
 */
public class ConnectionTest {

    /*
    方式一：
     */
    @Test
    public void testConnection1() throws SQLException {

        Driver driver = new com.mysql.jdbc.Driver();

        /*
        jdbc:mysql:协议
        localhost:ip端口号
        test:数据库名称
         */
        String url = "jdbc:mysql://localhost:3306/test";

        // 将用户名和密码封装在properties
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "123456");

        Connection conn = driver.connect(url, info);

        System.out.println(conn);

    }

}
