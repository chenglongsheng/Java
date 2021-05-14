package com.atguigu.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenglongsheng
 * @create 2021-05-14 8:35
 */
public class SubOrder extends Order<Integer> { // SubOrder普通类
    public static <E> List<E> copyFromArrayToList(E[] arr) {
        ArrayList<E> list = new ArrayList<>();

        for (E e : arr) {
            list.add(e);
        }
        return list;
    }
}
