package com.atguigu.java;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author chenglongsheng
 * @create 2021-06-15 22:05
 */
public class ReflectionTest {

    /*
    反射之前，对于Person的操作
     */
    @Test
    public void test1() {

        Person p1 = new Person("TOm",12);
        p1.age = 10;
        System.out.println(p1.toString());

        p1.show();

        // 在Person类外部，不可以通过Person类的对象调用其内部私有结构。
        // 比如：name、showNation()以及私有的构造器


    }

    // 反射之后的操作
    @Test
    public void test2() throws Exception {

        Class personClass = Person.class;
        // 1.通过反射，创建Person类的对象
        Constructor constructor = personClass.getConstructor(String.class, int.class);
        Object obj = constructor.newInstance("TOm", 12);
        Person p = (Person) obj;
        System.out.println(p.toString());
        // 2.通过反射，调用对象指定的属性、方法
        // 调用属性
        Field age = personClass.getDeclaredField("age");
        age.set(p,10);
        System.out.println(p.toString());

        // 调用方法
        Method show = personClass.getDeclaredMethod("show");
        show.invoke(p);

        System.out.println("*****************");

        // 通过反射，可以调用Person类的私有结构的。比如：私有的构造器、方法和属性
        // 调用私有构造器
        Constructor cons1 = personClass.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p1 = (Person) cons1.newInstance("Jerry");
        System.out.println(p1);

        // 调用私有属性
        Field name = personClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"Hanmeimei");
        System.out.println(p1);

        // 调用私有方法
        Method showNation = personClass.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        showNation.invoke(p1,"中国");// 相当于p1.showNation("中国")

    }

}
