package com.itxie.mybatis.mapper;

import com.itxie.mybatis.pojo.User;

import java.util.List;

public interface ParameterMapper {
    /**
     * 根据用户名查询用户信息
     * @param user
     * @return
     */
    User getUserByUsername(String username);

    /**
     * 查询所有员工信息
     */
    List<User> getAllUser();
}
