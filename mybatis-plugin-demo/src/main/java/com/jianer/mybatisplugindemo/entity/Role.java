package com.jianer.mybatisplugindemo.entity;

import java.io.Serializable;

/**
 * (Role)实体类
 *
 * @author makejava
 * @since 2020-04-23 22:46:39
 */
public class Role implements Serializable {
    private static final long serialVersionUID = 978831223369857775L;
    /**
    * 编号
    */
    private Integer id;
    /**
    * 角色名称
    */
    private String roleName;
    /**
    * 角色描述
    */
    private String roleDesc;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

}