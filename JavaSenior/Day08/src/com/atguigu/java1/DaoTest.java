package com.atguigu.java1;

import org.junit.Test;

import java.util.List;

/**
 * @author chenglongsheng
 * @create 2021-05-14 9:58
 */
public class DaoTest {
    @Test
    public void test1() {
        CustomerDao dao1 = new CustomerDao();
        dao1.add(new Customer());
        List<Customer> list =  dao1.getForList(10);


        StudentDAO dao2 = new StudentDAO();
        Student student = dao2.getIndex(1);
    }
}
