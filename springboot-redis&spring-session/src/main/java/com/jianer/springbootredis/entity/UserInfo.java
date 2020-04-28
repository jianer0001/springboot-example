package com.jianer.springbootredis.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author 杨兴健
 * @Date 2020/4/25 10:32
 */
public class UserInfo implements Serializable {
    private String name;
    private int age;
    private LocalDateTime birthday;

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

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public UserInfo setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserInfo{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", birthday=").append(birthday);
        sb.append('}');
        return sb.toString();
    }
}
