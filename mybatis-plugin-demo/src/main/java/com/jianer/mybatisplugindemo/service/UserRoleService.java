package com.jianer.mybatisplugindemo.service;

import com.jianer.mybatisplugindemo.entity.UserRole;
import java.util.List;

/**
 * (UserRole)表服务接口
 *
 * @author makejava
 * @since 2020-04-23 22:46:40
 */
public interface UserRoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param uid 主键
     * @return 实例对象
     */
    UserRole queryById(Integer uid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<UserRole> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param userRole 实例对象
     * @return 实例对象
     */
    UserRole insert(UserRole userRole);

    /**
     * 修改数据
     *
     * @param userRole 实例对象
     * @return 实例对象
     */
    UserRole update(UserRole userRole);

    /**
     * 通过主键删除数据
     *
     * @param uid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer uid);

}