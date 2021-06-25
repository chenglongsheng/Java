package com.atguigu.connection;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
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

    /*
    方式四：使用DriverManager替换Driver
     */
    @Test
    public void testConnection4() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {

        // 提供连接的三个基本信息
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "123456";

        /*
        加载Driver时，Driver实现类中静态代码块
        static {
            try {
                DriverManager.registerDriver(new Driver());
            } catch (SQLException var1) {
                throw new RuntimeException("Can't register driver!");
                }
        }
        自动注册。可以省略

         */
        Class.forName("com.mysql.jdbc.Driver");
//        Driver driver = (Driver) clazz.newInstance();

        // 注册驱动
//        DriverManager.registerDriver(driver);

        // 获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);

    }

    /*
    方式五：将数据库连接需要的4个基本信息声明在配置文件中，通过读取配置文件的方式，获取连接
    实现数据和代码分离：解耦
    如果需要修改配置信息，可以避免程序重新打包
     */
    @Test
    public void testConnection5() throws IOException, ClassNotFoundException, SQLException {

        // 读取配置文件
        InputStream is = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");

        Properties pros = new Properties();
        pros.load(is);
        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");

        // 加载驱动
        Class.forName(driverClass);

        // 获取连接
        Connection conn = DriverManager.getConnection(url, user, password);

        System.out.println(conn);

    }

}
