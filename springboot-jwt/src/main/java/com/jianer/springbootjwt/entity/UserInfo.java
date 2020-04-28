package com.jianer.springbootjwt.entity;

import java.io.Serializable;

/**
 * @author 杨兴健
 * @Date 2020/4/27 17:38
 */
public class UserInfo implements Serializable {
    private String name;
    private int age;
    private boolean gender;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserInfo{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", gender=").append(gender);
        sb.append('}');
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public UserInfo setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public UserInfo setAge(int age) {
        this.age = age;
        return this;
    }

    public boolean isGender() {
        return gender;
    }

    public UserInfo setGender(boolean gender) {
        this.gender = gender;
        return this;
    }
}
