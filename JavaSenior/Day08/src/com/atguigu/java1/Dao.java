package com.atguigu.java1;

import java.util.List;

/**
 * Dao:data(base) access object  数据访问对象
 *
 * @author chenglongsheng
 * @create 2021-05-14 9:40
 */
public class Dao<E> { // 表的共性操作的DAO
    // 添加数据
    public void add(E e) {

    }

    // 删除数据
    public boolean remove(int index) {
        return false;
    }

    // 修改数据
    public void update(int index, E e) {

    }

    // 查询单条数据
    public E getIndex(int index) {
        return null;
    }

    // 查询多条数据
    public List<E> getForList(int index) {
        return null;
    }

    public <E> E getValue() {
        return null;
    }
}
