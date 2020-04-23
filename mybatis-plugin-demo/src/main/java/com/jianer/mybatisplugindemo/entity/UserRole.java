package com.jianer.mybatisplugindemo.entity;

import java.io.Serializable;

/**
 * (UserRole)实体类
 *
 * @author makejava
 * @since 2020-04-23 21:29:46
 */
public class UserRole implements Serializable {
    private static final long serialVersionUID = -22560473752534457L;
    /**
    * 用户编号
    */
    private Integer uid;
    /**
    * 角色编号
    */
    private Integer rid;


    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

}