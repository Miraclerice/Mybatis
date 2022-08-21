package com.itxie.mybatis.test;

import com.itxie.mybatis.mapper.EmpMapper;
import com.itxie.mybatis.pojo.Emp;
import com.itxie.mybatis.pojo.EmpExample;
import com.sun.org.omg.CORBA.StructMemberSeqHelper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MBGTest {
    @Test
    public void testMBG(){
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
            //查询所有数据
            /*List<Emp> list = mapper.selectByExample(null);
            list.forEach(System.out::println);*/
            //根据条件查询
            /*EmpExample empExample = new EmpExample();
            empExample.createCriteria().andEmpNameEqualTo("张三").andAgeGreaterThanOrEqualTo(20);
            empExample.or().andDidIsNotNull();
            List<Emp> list = mapper.selectByExample(empExample);
            list.forEach(System.out::println);*/
            //mapper.updateByPrimaryKey(new Emp(1,"admin",22,null,"456@qq.com",3));//全修改
            mapper.updateByPrimaryKeySelective(new Emp(1,"admin",22,null,"45678@qq.com",3));//选择性修改，为null不修改
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
