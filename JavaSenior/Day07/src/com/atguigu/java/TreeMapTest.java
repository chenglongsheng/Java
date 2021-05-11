package com.atguigu.java;

import org.junit.Test;

import java.util.*;

/**
 * 向TreeMap中添加key-value，要求key必须是同一个类创建的对象
 * 按照key进行排序，自然排序、定制排序
 *
 * @author chenglongsheng
 * @create 2021-05-11 9:17
 */
public class TreeMapTest {

    @Test
    public void test2() {
        // 定制排序
        TreeMap map = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User) {
                    User u1 = (User) o1;
                    User u2 = (User) o2;
                    return Integer.compare(u1.getAge(), u2.getAge());
                }
                throw new RuntimeException("输入的数据类型不符！");
            }
        });
        User u1 = new User("Jerry", 23);
        User u2 = new User("Jack", 25);
        User u3 = new User("Tom", 20);
        User u4 = new User("Rose", 19);

        map.put(u1, 98);
        map.put(u2, 97);
        map.put(u3, 93);
        map.put(u4, 90);

        Set set = map.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }
    }

    @Test
    public void test1() {
        // 自然排序
        TreeMap map = new TreeMap();
        User u1 = new User("Jerry", 23);
        User u2 = new User("Jack", 25);
        User u3 = new User("Tom", 20);
        User u4 = new User("Rose", 19);

        map.put(u1, 98);
        map.put(u2, 97);
        map.put(u3, 93);
        map.put(u4, 90);

        Set set = map.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }
    }

}
