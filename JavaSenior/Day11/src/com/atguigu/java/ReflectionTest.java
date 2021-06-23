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

        Person p1 = new Person("TOm", 12);
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
        age.set(p, 10);
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
        name.set(p1, "Hanmeimei");
        System.out.println(p1);

        // 调用私有方法
        Method showNation = personClass.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        showNation.invoke(p1, "中国");// 相当于p1.showNation("中国")


    }

    /*
        java.lang.Class理解
        1.类的加载过程：
        程序经过javac.exe命令以后，会生成一个或多个字节码文件(.class结尾)。
        接着使用java.exe命令对某个字节码文件进行解释运行。
        相当于将某个字节码文件加载到内存中。
        此过程就称为类的加载。
        加载到内存中的类，就称为运行时类，此运行时类，就作为Class类的一个实例。

        2.换句话说，Class的实例就对应着一个运行时类。
        3.加载到内存中的运行时类，会缓存一定的时间。
        在此时间之内，可以通过不同的方式来获取此运行时类。
    */
    // 获取Class的实例的方法
    @Test
    public void test3() throws ClassNotFoundException {
        // 方式一：调用运行类的属性（.class）
        Class clazz1 = Person.class;
        System.out.println(clazz1);

        // 方式二：调用运行时类的对象
        Person p1 = new Person();
        Class clazz2 = p1.getClass();
        System.out.println(clazz2);

        // 方式三：调用Class的静态方法：forName(String ClassPath)
        // 可以在运行时报错
        Class clazz3 = Class.forName("com.atguigu.java.Person");
//        Class clazz3 = Class.forName("java.lang.String");
        System.out.println(clazz3);

        System.out.println(clazz1 == clazz2);
        System.out.println(clazz1 == clazz3);

        // 方式四：使用类的加载器：ClassLoader
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class clazz4 = classLoader.loadClass("com.atguigu.java.Person");
        System.out.println(clazz4);
        System.out.println(clazz1 == clazz4);

    }

}
