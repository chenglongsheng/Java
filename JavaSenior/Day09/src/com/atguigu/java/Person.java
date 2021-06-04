package com.atguigu.java;

import java.io.Serializable;

/**
 * @author chenglongsheng
 * @create 2021-06-04 11:04
 */
public class Person implements Serializable {
    public static final long serialVersionUID = 34235423784742L;
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
