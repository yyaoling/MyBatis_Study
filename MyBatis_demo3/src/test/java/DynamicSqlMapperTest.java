import com.atguigu.mybatis.mapper.DeptMapper;
import com.atguigu.mybatis.mapper.DynamicSqlMapper;
import com.atguigu.mybatis.pojo.Dept;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class DynamicSqlMapperTest {
    /**
     * 动态Sql:
     * 1.if 根据标签中test属性所对应的表达式决定标签中的内容是否需要拼接到Sql中
     * 2.where 当where标签中有内容时 会自动生成where 并将内容前多余的and或者or去掉
     * 3.trim标签
     * prefix | suffix:将trim标签中内容前面或后面添加指定内容
     * suffixOverrides | prefixOverrides:将trim标签中内容前面或者后面去掉指定内容
     * 4.choose when otherwise 相当于if...else if ...else
     *
     */
    @Test
    public void testGetEmpByCondition(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
        List<Emp> emps = mapper.getEmpByCondition(new Emp(null,null,23,"男","123@qq.com"));
        System.out.println(emps);
    }

    @Test
    public void testGetEmpByChoose(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
        List<Emp> emps = mapper.getEmpByChoose(new Emp(null,null,23,"男","123@qq.com"));
        System.out.println(emps);
    }
}
