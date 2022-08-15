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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParameterMapperTest {
    /**
     * mybatis获取参数值的两种方式：${}和#{}
     * ${}本质字符串拼接
     * #{}本质占位符赋值
     *
     * Mybatis获取参数值
     * 1.mapper接口方法的参数为单个的字面量类型
     * 可以通过${}和#{}以任意的名称获取参数值，但是需要注意${}的单引号问题
     * 2.mapper接口方法的参数为多个时
     * 此时Mybatis会将这些参数放在一个map集合中，以两种方式进行存储
     * a.以arg0,arg1...为键，以参数位置
     * b.以param1,param2...为键。以参数为值
     * 可以通过${}和#{}以键的方式获取参数值，但是需要注意${}的单引号问题
     * 3.若mapper接口方法的参数有多个时，可以手动将这些参数放在一个map中存储
     * 可以通过${}和#{}以键的方式获取参数值，但是需要注意${}的单引号问题
     * 4.mapper接口方法的参数是实体类类型的参数
     * 可以通过${}和#{}以属性的方式访问属性值即可，但是需要注意${}的单引号问题
     * 5.使用@Param注解命名参数
     * 此时Mybatis会将这些参数放在一个map集合中，以两种方式进行存储
     * a.以@Param注解的值为键，以参数为值
     * b.以param1,param2...为键，以参数为值
     * 可以通过${}和#{}以属性的方式访问属性值即可，但是需要注意${}的单引号问题
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

    @Test
    public void testCheckLogin() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.checkLogin("admin", "123456");
        System.out.println(user);
    }

    @Test
    public void testCheckLoginByMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        Map<String,Object> map = new HashMap<>();
        map.put("username","admin");
        map.put("password","123456");
        User user = mapper.checkLoginByMap(map);
        System.out.println(user);
    }

    @Test
    public void testInsertUser() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        int result = mapper.insertUser(new User(null, "赵薇", "123654", 52, "女", "12365@qq.com"));
        System.out.println(result);
    }

    @Test
    public void testCheckLoginByParam() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.checkLoginByParam("赵薇","123654");
        System.out.println(user);
    }
}
