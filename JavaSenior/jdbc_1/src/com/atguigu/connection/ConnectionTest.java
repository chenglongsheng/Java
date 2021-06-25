package com.atguigu.connection;

import org.junit.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
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

    /*
    方式二：对方式一的迭代
    不出现第三方api,更好的移植性
     */
    @Test
    public void testConnection2() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        // 1.或取Driver实现类对象，使用反射
        Class clazz = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();

        // 2.提供要连接的数据库
        String url = "jdbc:mysql://localhost:3306/test";

        // 3.提供连接需要的用户名和密码
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "123456");

        // 4.获取连接
        Connection conn = driver.connect(url, info);

        System.out.println(conn);
    }

    /*
    方式三：使用DriverManager替换Driver
     */
    @Test
    public void testConnection3() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {

        Class clazz = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();

        // 注册驱动
        DriverManager.registerDriver(driver);

        // 提供连接的三个基本信息
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "123456";

        // 获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);

    }

}
