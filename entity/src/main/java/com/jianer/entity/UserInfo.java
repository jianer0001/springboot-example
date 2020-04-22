package com.jianer.entity;

import java.io.Serializable;

/**
 * @author 杨兴健
 * @Date 2020/4/22 19:35
 */
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private int age;

    public int getId() {
        return id;
    }

    public UserInfo setId(int id) {
        this.id = id;
        return this;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserInfo{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }
}
