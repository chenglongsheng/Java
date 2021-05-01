package com.atguigu.java1;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author chenglongsheng
 * @create 2021-04-29 14:50
 */
public class SetTest {

    /*
    1.无序性：存储的数据在底层数组中并非按照索引顺序添加，而是根据数据的哈希值决定的

    2.不可重复性：保证添加的元素按照equals()判断时，不能返回true。即:相同元素只能添加一个

    添加元素HashSet为例
    向HashSet中添加元素a，首先调用元素a所在类的hashCode()，计算元素a的哈希值，
    此哈希值接着通过某种算法计算出在HashSet底层数组中的存放位置（索引位置），
    判断数组此位置上是否已经有元素：
        如果数组此位置上没有其他元素，则元素a添加成功。             （1）
        如果此位置上有其他元素b（或以链表存在的多个元素），则比较元素a和元素b的hash值：
            如果哈希值不相同，则元素a添加成功                      （2）
            如果哈希值不相同，进而需要调用元素a所在类的equals方法：
                equals()返回true，元素a添加失败
                equals()返回false，元素a添加成功                  （3）

    对于添加成功情况（2）（3）而言：元素a 与已经存在指定索引位置上数据一链表方式储存
    jdk7：元素a放到数组中，指向原来的元素
    jdk8：原来的元素放到数组中，指向元素a
     */
    @Test
    public void test1() {
        Set set = new HashSet();
        set.add(123);
        set.add(456);
        set.add(new User("Tom", 90));
        set.add(new User("Tom", 90));
        set.add("AA");
        set.add("CC");

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test2() {
        /*
        LinkedHashSet使用
        对于需要频繁遍历操作，LinkedHashSet效率高于HashSet
         */
        Set set = new LinkedHashSet();
        set.add(123);
        set.add(456);
        set.add(new User("Tom", 90));
        set.add(new User("Tom", 90));
        set.add("AA");
        set.add("CC");

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
