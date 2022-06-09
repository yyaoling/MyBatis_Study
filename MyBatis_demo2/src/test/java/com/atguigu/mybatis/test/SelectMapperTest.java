package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.SelectMapper;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class SelectMapperTest {
    /**
     * MyBatis的各种查询功能
     * 1.若查询出的数据只有一条，可以通过实体类对象接收
     *
     */
    @Test
    public void testGetUserByIdToMap(){
        SqlSession sqlSession=SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getAllUserToMap());

    }
}
