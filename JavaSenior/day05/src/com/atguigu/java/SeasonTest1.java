package com.atguigu.java;

/**
 * 使用关键字enum定义枚举类
 * 默认继承于ava.lang.Enum
 * <p>
 * 一、枚举类的使用
 * 1.枚举类的理解：类的对象只有有限个，确定的。我们称此类为枚举类
 * 2.当需要定义一组常量时，强烈建议使用枚举类
 * 3.如果枚举类中只有一个对象，则可以作为单例模式的实现方式。
 * <p>
 * 二、如何定义枚举类
 * 方式一：jdk5.0之前，自定义枚举类
 * 方式二：jdk5.0，可以使用enum关键字定义枚举类
 * <p>
 * 三、Enum类中的常用方法：
 * values()方法：返回枚举类型的对象数组。该方法可以很方便地遍历所有的枚举值。
 * valueOf(String str)：可以把一个字符串转为对应的枚举类对象。要求字符串必须是枚举类对象的“名字”。如不是，会有运行时异常：IllegalArgumentException。
 * toString()：返回当前枚举类对象常量的名称
 * <p>
 * 四、使用enum关键字定义的枚举类实现接口的情况
 * 情况一：实现接口，在enum类中实现抽象方法
 * 情况二：让枚举类的对象分别实现接口中的抽象方法
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

        System.out.println("**********************");

        //values()
        Season1[] values = Season1.values();

        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }

        System.out.println("**********************");

        //状态
        Thread.State[] values1 = Thread.State.values();
        for (int i = 0; i < values1.length; i++) {
            System.out.println(values1[i]);
        }

        System.out.println("**********************");

        //valueOf(String str)
        Season1 winter = Season1.valueOf("WINTER");
        System.out.println(winter);
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
