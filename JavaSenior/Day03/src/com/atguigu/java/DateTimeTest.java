package com.atguigu.java;

import org.junit.Test;

import java.util.Date;

/**
 * @author chenglongsheng
 * @create 2021-04-16 22:08
 */
public class DateTimeTest {

    /*
    java.sql.Date
     */
    @Test
    public void test2() {
        java.sql.Date date3 = new java.sql.Date(1618583031998L);
        System.out.println(date3);

        //强转
        Date date4 = new java.sql.Date(23423424235345L);
        java.sql.Date date5 = (java.sql.Date) date4;
        System.out.println(date5.toString());
    }

    /*
    java.util.Date
    java.sql.Date
     */
    @Test
    public void test1() {
        Date date1 = new Date();
        System.out.println(date1.toString());//显示时间
        System.out.println(date1.getTime());//获取时间戳

        Date date2 = new Date(1618583031998L);
        System.out.println(date2.toString());
    }

    @Test
    public void test() {
        //返回当前时间与1970年1月1日0时0分0秒之间乙毫秒为单位的时间差，称时间戳
        long time = System.currentTimeMillis();
        System.out.println(time);
    }

}
