package com.jianer.mybatisplugindemo.entity;

import java.io.Serializable;

/**
 * (Account)实体类
 *
 * @author makejava
 * @since 2020-04-23 21:29:39
 */
public class Account implements Serializable {
    private static final long serialVersionUID = 598485728231838219L;
    /**
    * 编号
    */
    private Integer id;
    /**
    * 用户编号
    */
    private Integer uid;
    /**
    * 金额
    */
    private Double money;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

}