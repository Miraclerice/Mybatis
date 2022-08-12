package com.itxie.mybatis.mapper;

public interface UserMapper {

    /**
     * Mybatis面向接口编程的两个一致
     * 1.映射文件的namespace要与mapper接口的全类名要保持一致
     * 2.映射文件中的SQL语句要和mapper接口中方法名一致
     */

    /**
     * 添加用户信息
     */
    int insertUser();
}
