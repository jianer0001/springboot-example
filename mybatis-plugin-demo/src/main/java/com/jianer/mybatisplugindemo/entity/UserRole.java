package com.jianer.mybatisplugindemo.entity;

import java.io.Serializable;

/**
 * (UserRole)实体类
 *
 * @author makejava
 * @since 2020-04-23 22:46:40
 */
public class UserRole implements Serializable {
    private static final long serialVersionUID = 668386379535180128L;
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