package com.itxie.mybatis.test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itxie.mybatis.mapper.EmpMapper;
import com.itxie.mybatis.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class PageHelperTest {
    /**
     * limit index,pageSize
     * index:当前页的起始索引
     * pageSize:每页显示的条数
     * pageNum:当前页页码
     * index = (pageNum-1)*pageSize
     *
     * 使用Mybatis的分页插件实现分页功能：
     * 1.需要在查询功能之前开启分页
     * PageHelper
     *  public static <E> Page<E> startPage(int pageNum, int pageSize) {
     *         return startPage(pageNum, pageSize, DEFAULT_COUNT);
     *     }
     *
     *  2.在查询功能之后获取分页相关信息
     *  PageInfo<Emp> page = new PageInfo<>(lis,5);
     *  lis表示分页数据
     *  5表示当前导航分页的数据
     */
    @Test
    public void testPageHelper(){
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
            //Page<Object> page = PageHelper.startPage(2, 4);
            PageHelper.startPage(6,4);
            List<Emp> lis = mapper.selectByExample(null);
            PageInfo<Emp> page = new PageInfo<>(lis,5);
            //lis.forEach(System.out::println);
            System.out.println(page);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
