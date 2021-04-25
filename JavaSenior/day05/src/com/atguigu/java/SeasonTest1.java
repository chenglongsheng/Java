package com.atguigu.java;

/**
 * 使用关键字enum定义枚举类
 * 默认继承于ava.lang.Enum
 *
 * @author chenglongsheng
 * @create 2021-04-25 16:34
 */
public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 spring = Season1.SPRING;
        System.out.println(spring);

//        enum 的父类并非Object，而是java.lang.Enum
        System.out.println(Season1.class.getSuperclass());
    }
}

enum Season1 {
    //提供枚举类的对象，多个对象之间用","隔开，结尾用";"
    SPRING("春天", "1"),
    SUMMER("夏天", "2"),
    AUTUMN("秋天", "3"),
    WINTER("冬天", "4");

    // 声明Season对象的属性
    private final String seasonName;
    private final String seasonDesc;


    // 私有化类的构造器，并给对象属性赋值
    Season1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    // 述求

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }
}
