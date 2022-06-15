package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {
    /**
     * 分布查询的第二部
     */
    Dept getEmpAndDeptByStepTwo(@Param("did") Integer did);
}
