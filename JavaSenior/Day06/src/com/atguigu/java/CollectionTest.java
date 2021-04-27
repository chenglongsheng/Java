package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * 向collection接口的实现类的对象中添加数据obj时，要求obj所在类要重写equals方法
 *
 * @author chenglongsheng
 * @create 2021-04-26 22:00
 */
public class CollectionTest {

    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add("adasd");
        coll.add(354);
        coll.add("hi");
        coll.add(new String("Tom"));
        coll.add(new Person("Anny", 23));
        Person p = new Person("Jeny", 20);
        coll.add(p);

        // contains()判断集合中有无obj
        System.out.println(coll.contains(new String("Tom")));
        System.out.println(coll.contains(123));
        System.out.println(coll.contains(new Person("Anny", 23)));//false->true  重写equals方法
        System.out.println(coll.contains(p));//true

        Collection coll1 = Arrays.asList(123, 354);//true
        System.out.println(coll.containsAll(coll1));//判断coll1中所有元素是否都存在于当前集合中
    }

    @Test
    public void test2(){
        // remove()从当前集合中移除元素
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(789);
        System.out.println(coll);
        coll.remove(456);
        System.out.println(coll);
    }
}
