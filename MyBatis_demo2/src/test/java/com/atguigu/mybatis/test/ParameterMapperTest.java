package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.ParameterMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParameterMapperTest {
    /**
     * MyBatis获取参数的两种方式  ${}  #{}
     * ${}本质是字符串拼接
     * #{}本质是占位符赋值
     *
     * 1.mapper 接口方法的参数为单个的字面量类型
     * ${}使用时  要加上单引号即: '${username}'
     *
     * 2.mapper接口方法的参数为多个时
     * 此时MyBatis会将这些参数放在一个map集合中，以两种方式进行存储
     * a>以arg0、arg1。。。为键值，以参数为值
     * b>以param1,param2。。为键,以参数为值
     *
     * 3.若mapper接口方法的参数有多个时，可以手动将这些参数放在一个map中存储
     *
     * 4.mapper 接口方法的参数是实体类型类型的参数
     *
     * 5.命名参数
     */
    @Test
    public  void testCheckLoginByParam(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user  = mapper.checkLoginByParam("admin","admin");
        System.out.println(user);
    }
    /**
     * 添加用户信息
     */
    @Test
    public  void testInsertUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        int result =  mapper.insertUser(new User(null,"马武","123",23,"男","123@qq.com"));
        System.out.println(result);
    }

    @Test
    public  void testCheckLoginByMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        Map<String,Object> map = new HashMap<>();
        map.put("username","admin");
        map.put("password","admin");
        User user  = mapper.checkLoginByMap(map);
        System.out.println(user);
    }
    @Test
    public  void testCheckLogin(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user  = mapper.checkLogin("admin","admin");
        System.out.println(user);
    }


    @Test
    public  void testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        List<User> list = mapper.getAllUser();
        list.forEach(user->System.out.println(user));
    }

    @Test
    public void testJDBC(){

    }
}
