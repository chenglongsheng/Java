package com.atguigu.java;

import org.junit.Test;

import java.util.List;

/**
 * 如何自定义泛结构：泛型类、泛型接口；泛型方法
 * <p>
 * 1.自定义泛型类、泛型接口
 *
 * @author chenglongsheng
 * @create 2021-05-12 17:13
 */
public class GenericTest1 {

    @Test
    public void test1() {
        // 如果定义了泛型类，实例化没有指明类的泛型，则认为此泛型类型为Object类型
        Order order = new Order();

        order.setOrderT(123);
        order.setOrderT("ABC");


        Order<String> order1 = new Order<String>("OrderAA", 1001, "order:AA");

        order1.setOrderT("AA:hello");
    }

    @Test
    public void test2() {
        SubOrder subOrder = new SubOrder();
        // 由于子类在继承带泛型的父类时，指明了泛型类型，则实例化子类对象时，不再需要指明泛型。
        subOrder.setOrderT(5555);

        SubOrder1<String> subOrder1 = new SubOrder1<String>();

        subOrder1.setOrderT("order1:S");
    }

    @Test
    public void test3() {
        Order<String> order = new Order<>();
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5};
        // 泛型方法在调用时，指明泛型参数的类型
        List<Integer> list = order.copyFromArrayToList(arr);
        System.out.println(list);
    }
}
