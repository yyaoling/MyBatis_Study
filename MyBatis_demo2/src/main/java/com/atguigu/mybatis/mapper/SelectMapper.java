package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface SelectMapper {
    /**
     * 根据id查询用户信息
     */
    User getUserById(@Param("id")Integer id);

    /**
     * 根据id查询用户信息为一个map集合
     */
    Map<String,Object> getUserByIdToMap(@Param("id") Integer id);

    /**
     * 查询所有用户信息为map集合
     */
    @MapKey("id")
    Map<String,Object> getAllUserToMap();
}

