package com.itxie.mybatis.test;

import com.itxie.mybatis.mapper.ParameterMapper;
import com.itxie.mybatis.pojo.User;
import com.itxie.mybatis.utils.SqlSessionUtils;
import com.mysql.cj.jdbc.Driver;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

public class ParameterMapperTest {
    /**
     * mybatis获取参数值的两种方式：${}和#{}
     * ${}本质字符串拼接
     * #{}本质占位符赋值
     *
     * Mybatis获取参数值
     */
    @Test
    public void testGetUserByUsername(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.getUserByUsername("admin");
        System.out.println(user);
    }
    
    @Test
    public void testGetAllUser() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        List<User> list = mapper.getAllUser();
        list.forEach(System.out::println);
    }

    @Test
    public void testJDBC() throws Exception {
        String username = "admin";
        Class.forName("");
        Connection connection = DriverManager.getConnection("", "", "");
        //PreparedStatement ps = connection.prepareStatement("select * from table_user where username = '" + username + "'");
        PreparedStatement ps = connection.prepareStatement("select * from table_user where username = ?");
        ps.setString(1,username);
    }
}
