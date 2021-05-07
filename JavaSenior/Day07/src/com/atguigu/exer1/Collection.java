package com.atguigu.exer1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author chenglongsheng
 * @create 2021-05-07 10:34
 */
public class Collection {
    @Test
    public void test2(){
        List list = new ArrayList();
        list.add( new Integer(1));
        list.add( new Integer(2));
        list.add( new Integer(2));
        list.add( new Integer(2));
        list.add( new Integer(3));
        list.add( new Integer(4));
        List list1 = duplicateList(list);
        for(Object integer : list1) {
            System.out.println(integer);
        }
    }

    private static List duplicateList(List list) {
        HashSet set = new HashSet();
        set.addAll(list);
        return new ArrayList(set);
    }

    @Test
    public void test1(){
        HashSet set = new HashSet();
        Person p1 = new Person(1001,"AA");
        Person p2 = new Person(1002,"BB");
        set.add(p1);
        set.add(p2);
        System.out.println(set);

        p1.name = "CC";// hashcode改变了
        set.remove(p1);
        System.out.println(set);// 比较hashcode判断是否添加数据

        set.add(new Person(1001,"CC"));
        System.out.println(set);
        set.add(new Person(1001,"AA"));
        System.out.println(set);
    }
}
