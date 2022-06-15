import com.atguigu.mybatis.mapper.CacheMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class CacheMapperTest {
    //一级缓存失效的四种情况

    /**
     * 一级缓存失效的四种情况
     * 1.不同的SqlSession对应不同的一级缓存
     * 2.同一个SqlSession但是查询条件不同
     * 3.同一个SqlSession但是两次查询期间执行了任何一次增删改查操作
     * 4.同一个SqlSession两次查询期间手动清除了缓存
     */
    @Test
    public void testOneCache(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CacheMapper cacheMapper1 = sqlSession.getMapper(CacheMapper.class);
        Emp emp1=  cacheMapper1.getEmpByEid(1);
        System.out.println(emp1);

        CacheMapper cacheMapper2 = sqlSession.getMapper(CacheMapper.class);
        Emp emp2=  cacheMapper2.getEmpByEid(1);
        System.out.println(emp2);
    }

    /**
     * 二级缓存
     * 两次查询之间执行了任意的增删改查会使一级和二级缓存同时失效
     * 缓存查询顺序 先查询二级缓存在查询一级缓存之后是数据库中
     * 二级缓存中有多个SqlSession 每个SqlSession提交或者关闭之后数据才会在二级缓存中
     */
    @Test
    public void testTwoCache(){

        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            //获取SqlSessionFactoryBuilder
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            //获取sqlSessionFactoryBuilder
            SqlSessionFactory sqlSessionFactory= sqlSessionFactoryBuilder.build(is);
            //获取SqlSession
            SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
            CacheMapper cacheMapper1 = sqlSession1.getMapper(CacheMapper.class);
            Emp emp1=  cacheMapper1.getEmpByEid(1);
            System.out.println(emp1);
            sqlSession1.close();

            SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
            CacheMapper cacheMapper2 = sqlSession2.getMapper(CacheMapper.class);
            Emp emp2=  cacheMapper2.getEmpByEid(1);
            System.out.println(emp2);
            sqlSession2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
