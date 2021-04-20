package com.atguigu.java;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * jdk 8之前的日期时间的API测试
 *
 * 1.System类中currentTimeMillis();
 * 2.java.util.Date和子类java.sql.Date
 * 3.SimpleDateFormat
 * 4.Calendar
 *
 * @author chenglongsheng
 * @create 2021-04-20 8:57
 */
public class DayTimeTest {
    /*
    SimpleDateFormat的使用：SimpleDateFormat对日期Date类的格式化和解析

    1.两个操作
    1.1格式化：日期-->字符串
    1.2解析；格式化的逆过程，字符串-->日期

    2.SimpleDateFormat的实例化
     */

    @Test
    public void testSimpleDateFormat() throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat();

        Date date = new Date();
        System.out.println(date);

        String format = sdf.format(date);

        System.out.println(format);

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String format1 = sdf1.format(date);
        System.out.println(format1);

        // 要求字符串必须是符合SimpleDateFormat识别的格式，否则抛异常
        Date date2 = sdf1.parse("2020-03-13 15:45:56");
        System.out.println(date2);
    }

    @Test
    public void testExercise() throws ParseException {
        String birth = "2020-09-09";
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf1.parse(birth);
        java.sql.Date birthDate = new java.sql.Date(date.getTime());
        System.out.println(birthDate);
    }
}
