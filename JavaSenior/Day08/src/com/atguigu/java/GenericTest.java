package com.atguigu.java;

import org.junit.Test;

import java.util.*;

/**
 * 泛型的使用
 * 1.jdk 5.0新增的特性
 * 总结：
 *  （1）集合接口或集合类在jdk5.0时都修改为带泛型的结构
 *  （2）在实例化集合类时，可以指明具体的泛型类型
 *  （3）指明完以后在集合类或接口中凡是定义类或接口时，内部结构（比如：方法、构造器、属性等）使用到类的泛型的位置，都指定为实例化泛型类型。
 *      比如：add(E e) ---> 实例化以后：add(Integer e)
 *  （4）注意点：泛型的类型必须是类，不能是基本数据类型。需要用到基本数据类型的位置，拿包装类替换
 *  （5）如果实例化时，没有指明泛型的类型。默认类型为Object
 *
 *
 * @author chenglongsheng
 * @create 2021-05-11 16:40
 */
public class GenericTest {

    // 在集合中使用泛型之前的情况
    @Test
    public void test1() {
        ArrayList list = new ArrayList();

        // 需求：存放学生的成绩
        list.add(78);
        list.add(89);
        list.add(67);
        list.add(76);

        // 问题一：类型不安全
        list.add("Tom");

        for (Object score : list) {

            // 问题二：强转时，可能出现
            // java.lang.ClassCastException: java.lang.String cannot be cast to java.lang.Integer
            int stuScore = 0;
            try {
                stuScore = (int) score;
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(stuScore);
        }
    }

    // 在集合中使用泛型之前的情况
    @Test
    public void test2() {
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(34);
        list.add(78);
        list.add(56);
        list.add(90);
        // 编译时进行类型检查，保证数据安全
//        list.add("er");

        // 方式一
//        for (Integer score : list) {
//            // 避免了强转
//            int stuScore = score;
//            System.out.println(stuScore);
//        }

        // 方式二
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            int stuScore = iterator.next();
            System.out.println(stuScore);
        }

    }

    @Test
    public void test3() {

        HashMap<String, Integer> map = new HashMap<>();

        map.put("Jerry",89);
        map.put("Jack",89);
        map.put("Tom",90);

        Set<Map.Entry<String, Integer>> entry = map.entrySet();
    }

}
