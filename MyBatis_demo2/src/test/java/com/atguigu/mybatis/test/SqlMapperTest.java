package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.SelectMapper;
import com.atguigu.mybatis.mapper.SqlMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class SqlMapperTest {
    @Test
    public void testGetUserByIdToMap(){
        SqlSession sqlSession= SqlSessionUtils.getSqlSession();
        SqlMapper mapper = sqlSession.getMapper(SqlMapper.class);
        List<User> list = mapper.getUserByLike("a");
        System.out.println(list);

    }

    @Test
    public void testGetUserByTableName(){
        SqlSession sqlSession= SqlSessionUtils.getSqlSession();
        SqlMapper mapper = sqlSession.getMapper(SqlMapper.class);
        List<User> list = mapper.getUserByTableName("t_user");
        System.out.println(list);

    }
}
