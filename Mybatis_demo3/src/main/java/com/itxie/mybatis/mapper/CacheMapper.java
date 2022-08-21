package com.itxie.mybatis.mapper;

import com.itxie.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

/**
 * 缓存
 */
public interface CacheMapper {

    Emp getEmpByEid(@Param("eid") Integer eid);

    void insertEmp(Emp emp);
}
