package com.itxie.mybatis.mapper;

import com.itxie.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {

    /**
     * Mybatis面向接口编程的两个一致
     * 1.映射文件的namespace要与mapper接口的全类名要保持一致
     * 2.映射文件中的SQL语句要和mapper接口中方法名一致
     *
     * 表-实体类-mapper接口-映射文件
     */

    /**
     * 添加用户信息
     */
    int insertUser();

    /**
     * 修改用户信息
     */
    void updateUser();

    /**
     * 删除用户信息
     */
    void deleteUser();

    /**
     * 根据id查询用户信息
     */
    User getUserById();

    /**
     * 获取所有用户信息
     */
    List<User> getAllUser();
}
