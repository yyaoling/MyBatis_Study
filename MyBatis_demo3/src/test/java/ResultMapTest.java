import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class ResultMapTest {
    /**
     * 解决字段名和属性名不一致的情况
     * 1.为字段起别名（即查询的时候给数据库字段起别名），保持和属性名的一致
     * 2.设置全局配置，将自动映射为驼峰
     * <setting name="mapUnderscoreToCamelCase" value="true"/>
     * 3.通过resultMap设置自定义的映射关系
     */
    @Test
    public void testGetAllEmp()
    {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> list=mapper.getAllEmp();
        list.forEach(emp -> System.out.println(emp));
    }

    /**
     * 1.处理多对一的映射关系
     * 2.级联属性赋值
     * association处理多对一的映射关系
     * property：需要处理多对一的映射关系的属性名
     * javaType 该属性 的类型
     * 3.通过分布查询解决多对一的映射关系
     */
    @Test
    public void testGetEmpAndDept()
    {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp =mapper.getEmpAndDeptByStepOne(1);
        //可以开启懒加载之后  只执行第一步  没有执行第二步
        System.out.println(emp.getEmpName());
    }
}
