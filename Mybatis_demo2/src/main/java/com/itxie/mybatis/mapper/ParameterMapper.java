package com.itxie.mybatis.mapper;

import com.itxie.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ParameterMapper {
    /**
     * y验证登录(使用@Param)
     */
    User checkLoginByParam(@Param("username") String username,@Param("password") String password);

    /**
     * 添加用户信息
     */
    int insertUser(User user);

    /**
     * 验证登录通过map
     */
    User checkLoginByMap(Map<String,Object> map);

    /**
     * 验证登录
     * @param username
     * @param password
     * @return
     */
    User checkLogin(String username,String password);

    /**
     * 根据用户名查询用户信息
     *
     * @param username
     * @return
     */
    User getUserByUsername(String username);

    /**
     * 查询所有员工信息
     */
    List<User> getAllUser();
}
