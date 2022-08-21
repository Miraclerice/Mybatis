package com.itxie.mybatis.mapper;

import com.itxie.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SqlMapper {

    /**
     * 根据用户名模糊查询用户信息（模糊查询）
     */
    List<User> getUserByLike(@Param("username") String username);

    /**
     * 批量删除
     */
    int deleteMore(@Param("ids") String ids);

    /**
     * 查询指定表中数据
     */
    List<User> getUserByTableName(@Param("tablename") String tablename);

    /**
     * 添加用户信息
     */
    void insertUser(User user);
}
