package com.atguigu.java;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
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
    public void test1() {

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

    /*
    Instant
    类似java.util.Date
     */

    @Test
    public void test2() {
        Instant instant = Instant.now();
        System.out.println(instant);
        // 时间偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        // 获取自1970年1月1日0时0分0秒（UTC）开始的毫秒数
        long milli = instant.toEpochMilli();
        System.out.println(milli);

        // 通过给定的毫秒数，获取Instant实例-->Date(long millis)
        Instant instant1 = Instant.ofEpochMilli(1618925531763L);
        System.out.println(instant1);
    }

    /*
    DateTimeFormatter
     */
    @Test
    public void test3() {
        //方式一：预定义的标准格式。如，ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        // 格式化：日期-->字符串
        LocalDateTime localDateTime = LocalDateTime.now();
        String str1 = formatter.format(localDateTime);
//        System.out.println(localDateTime);
        System.out.println(str1);

        // 解析：字符串-->日期
        TemporalAccessor parse = formatter.parse("2021-04-22T19:46:37.916");
        System.out.println(parse);

        // 方式二：本地化相关的格式。如：ofLocalizedDateTime(FormatStyle.LONG)
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        String str2 = formatter1.format(localDateTime);
        System.out.println(str2);

        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        // 格式化
        String str3 = formatter2.format(LocalDate.now());
        System.out.println(str3);

        // 方式三：自定义的格式。如：ofPattern(“yyyy-MM-dd hh:mm:ss”)
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        // 格式化
        String str4 = formatter3.format(LocalDateTime.now());
        System.out.println(str4);//2021-04-22 08:14:36

        TemporalAccessor accessor = formatter3.parse("2021-04-22 08:14:36");
        System.out.println(accessor);
    }
}
