package com.atguigu.java1;

import org.junit.Test;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author chenglongsheng
 * @create 2021-05-07 8:25
 */
public class TreeSetTest {
    /*
    1.向TreeSet中添加的对象要求是相同类的对象
    2.两种排序：自然排序（实现Comparable接口） 和定制排序

    3.自然排序中，比较两个对象是否相同的标准：compareTo()返回0，不再是equals()
     */
    @Test
    public void test1() {
        TreeSet set = new TreeSet();

//        set.add(12);
//        set.add(45);
//        set.add(6);
//        set.add(90);
//        set.add(-87);

        set.add(new User("Jerry", 34));
        set.add(new User("Tom", 56));
        set.add(new User("Jin", 34));
        set.add(new User("Jack", 94));
        set.add(new User("An", 14));
        set.add(new User("Mike", 34));
        set.add(new User("Mike", 57));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
