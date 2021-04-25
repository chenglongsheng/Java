package com.atguigu.java;

/**
 * 自定义枚举类
 *
 * @author chenglongsheng
 * @create 2021-04-25 15:11
 */
public class SeasonTest {
    public static void main(String[] args) {
        System.out.println(Season.AUTUMN.getSeasonDesc().toString());
        System.out.println(Season.AUTUMN.getSeasonName().toString());
    }
}

class Season {
    // 声明自定义枚举类的属性  private final 修饰
    private final String seasonName;
    private final String seasonDesc;

    // 私有化类的构造器，并给对象赋值
    private Season(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    // 实例化有限个对象，public static final修饰
    public static final Season SPRING = new Season("春天", "1");
    public static final Season SUMMER = new Season("夏天", "2");
    public static final Season AUTUMN = new Season("秋天", "3");
    public static final Season WINTER = new Season("冬天", "4");

    // 述求1：获取
    public String getSeasonDesc() {
        return seasonDesc;
    }

    public String getSeasonName() {
        return seasonName;
    }

    // 述求2：打印
    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}
