package com.itxie.mybatis;

import com.itxie.mybatis.mapper.DeptMapper;
import com.itxie.mybatis.mapper.EmpMapper;
import com.itxie.mybatis.pojo.Dept;
import com.itxie.mybatis.pojo.Emp;
import com.itxie.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class ResultMapTest {

    /**
     * 解决字段名和属性名不一致的情况:
     * 1）为字段起别名,保持与属性一致
     * 2）设置全局配置，将_自动映射为驼峰
     * <setting name="mapUnderscoreToCamelCase" value="true"/>
     * 3)通过resultMap来设置自定义映射关系
     * <resultMap id="empResultMap" type="Emp">
     * <id property="eid" column="eid"></id><!--主键-->
     * <result property="empName" column="emp_name"></result>
     * <result property="age" column="age"></result>
     * <result property="sex" column="sex"></result>
     * <result property="email" column="email"></result>
     * </resultMap>
     * <p>
     * <p>
     * <p>
     * 处理多对一的映射关系：
     * 1）级联属性赋值
     * <resultMap id="empAndResultMapOne"  type="Emp">
     * <id property="eid" column="eid"></id>
     * <result property="empName" column="emp_name"></result>
     * <result property="age" column="age"></result>
     * <result property="sex" column="sex"></result>
     * <result property="email" column="email"></result>
     * <result property="dept.did" column="did"></result>
     * <result property="dept.deptName" column="dept_name"></result>
     * </resultMap>
     * 2）使用association标签
     * 3）分步查询
     * <p>
     * 处理一对多的映射关系
     * 1）collection
     * 2）分步查询
     */


    @Test
    public void testgetAllEmp() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> list = mapper.getAllEmp();
        list.forEach(System.out::println);
    }

    @Test
    public void testgetEmpAndDept() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDept(4);
        System.out.println(emp);
    }

    @Test
    public void testgetEmpAndDeptByStepOne() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDeptByStepOne(2);
        System.out.println(emp.getEmpName());
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(emp.getDept());
    }

    @Test
    public void testGetDeptAndEmp() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.getDeptAndEmp(2);
        System.out.println(dept);
    }

    @Test
    public void testGetDeptAndEmpByStep() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.getDeptAndEmpByStepOne(2);
        System.out.println(dept.getDeptName());
    }
}
