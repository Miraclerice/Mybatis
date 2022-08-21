package com.itxie.mybatis.test;

import com.itxie.mybatis.mapper.SelectMapper;
import com.itxie.mybatis.pojo.User;
import com.itxie.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class SelectMapperTest {

    /**
     * Mybatis的各种查询功能
     * 1.若查询出的数据只有一条，可以通过实体类对象和list集合接收
     * 1)可以通过实体类对象接收
     * 2)可以通过List集合接收
     * 3)可以通过Map集合接收
     * 2.若查询出的数据有多条，可以通过list集合接收，一定不能通过实体类对象接收，此时会抛出异常TooManyResultsException
     * 1)可以通过实体类类型的List集合接收
     * 2)可以通过map类型的list集合接收
     * 3)可以在mapper接口的方法上加@MapKey注解，此时可以将每条数据转换的map集合作为2值，以某个字段作为键的，放在同一个map集合
     *
     *
     * Mybatis中设置了默认的类型别名
     * java.lang.Integer-->int,integer
     * int --> _int,_integer
     * Map --> map
     * String --> string
     */

    @Test
    public void testGetUserById() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        User user = mapper.getUserById(8);
        System.out.println(user);
    }

    @Test
    public void testGetAllUser() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<User> allUser = mapper.getAllUser();
        allUser.forEach(System.out::println);
    }

    @Test
    public void testCount() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Integer count = mapper.getCount();
        System.out.println(count);
    }

    @Test
    public void testGetUserByIdToMap() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> userMap = mapper.getUserByIdToMap  (8);
        System.out.println(userMap);
    }

    @Test
    public void testGetAllUserToMap() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getAllUserToMap());
    }

}
