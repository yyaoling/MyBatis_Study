import com.atguigu.mybatis.mapper.CacheMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

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
    public void testCache(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CacheMapper cacheMapper1 = sqlSession.getMapper(CacheMapper.class);
        Emp emp1=  cacheMapper1.getEmpByEid(1);
        System.out.println(emp1);

        CacheMapper cacheMapper2 = sqlSession.getMapper(CacheMapper.class);
        Emp emp2=  cacheMapper2.getEmpByEid(1);
        System.out.println(emp2);
    }
}
