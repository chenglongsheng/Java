package com.atguigu.java;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * jdk8中日期时间API的测试
 *
 * @author chenglongsheng
 * @create 2021-04-20 20:45
 */
public class JDK8DateTimeTest {

    @Test
    public void testDate() {
        //偏移量
        Date date1 = new Date(2020 - 1900, 9 - 1, 8);
        System.out.println(date1);
    }

    /*
    LocalDate、LocalTime、LocalDateTime
     */

    @Test
    public void test1(){

        // now() 获取当前的日期、时间、日期+时间
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        //of() 设置指定的年月日时分秒
        LocalDateTime localDateTime1 = localDateTime.of(2020, 9, 01, 12, 12, 9, 1);
        System.out.println(localDateTime1);

        // getXXX() 获取
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getMinute());

        // 体现不可变性
        // withXXX():设置相关属性
        LocalDate localDate1 = localDate.withDayOfMonth(22);
        System.out.println(localDate);
        System.out.println(localDate1);
    }
}
