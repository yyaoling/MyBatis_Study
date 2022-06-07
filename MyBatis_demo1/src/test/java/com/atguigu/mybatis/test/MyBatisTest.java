package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.UserMapper;
import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {
    @Test
    public void testMyBatis() throws IOException {
        //加载核心配置文件
        InputStream is= Resources.getResourceAsStream("mybatis-config.xml");
        //获取SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //获取sqlSessionFactoryBuilder
        SqlSessionFactory sqlSessionFactory= sqlSessionFactoryBuilder.build(is);
        //获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获取mapper接口对象   接口实现类的对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int result = mapper.insertUser();
        //提交事务
        sqlSession.commit();
        System.out.println("result:"+result);
    }

    @Test
    public void testCRUD() throws IOException {
        //加载核心配置文件
        InputStream is= Resources.getResourceAsStream("mybatis-config.xml");
        //获取SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //获取sqlSessionFactoryBuilder
        SqlSessionFactory sqlSessionFactory= sqlSessionFactoryBuilder.build(is);
        //获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获取mapper接口对象   接口实现类的对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //修改功能
        //mapper.updateUser();
        //mapper.deleteUser();
        List<User> users = mapper.getAllUser();
        users.forEach(user -> System.out.println(user));
    }
}
