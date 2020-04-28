package com.jianer.springbootjwt.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.Serializable;

/**
 * @author 杨兴健
 * @Date 2020/4/27 17:38
 */
public class UserInfo implements Serializable {
    private int id;

    @NotNull(message = "用户名不可以为空")
    private String name;

    @NotNull(message = "密码不可以为空")
    private String password;
    private boolean gender;
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public UserInfo setId(int id) {
        this.id = id;
        return this;
    }

    public UserInfo setName(String name) {
        this.name = name;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserInfo setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getGender() {
        return gender ? "男" : "女";
    }

    public UserInfo setGender(boolean gender) {
        this.gender = gender;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserInfo{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", gender=").append(getGender());
        sb.append('}');
        return sb.toString();
    }
}
