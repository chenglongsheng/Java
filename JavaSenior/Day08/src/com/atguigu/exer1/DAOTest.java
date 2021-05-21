package com.atguigu.exer1;

import org.junit.Test;

import java.util.List;

/**
 * 定义一个测试类：
 * 创建 DAO 类的对象， 分别调用其 save、get、update、list、delete 方
 * 法来操作 User 对象，
 * 使用 Junit 单元测试类进行测试。
 *
 * @author chenglongsheng
 * @create 2021-05-19 18:10
 */
public class DAOTest {

    @Test
    public void test1() {
        DAO<User> dao = new DAO<>();

        dao.save("1001", new User(1001, 34, "周杰伦"));
        dao.save("1002", new User(1002, 32, "昆凌"));
        dao.save("1003", new User(1003, 34, "蔡依林"));

        dao.update("1003", new User(1001, 30, "方文山"));

        dao.delete("1002");

        List<User> list = dao.list();
        list.forEach(System.out::println);
    }

}
