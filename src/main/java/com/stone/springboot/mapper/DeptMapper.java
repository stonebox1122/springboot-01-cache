package com.stone.springboot.mapper;

import com.stone.springboot.bean.Dept;
import org.apache.ibatis.annotations.*;

/**
 * @author stone
 * @date 2019/7/11 14:12
 * description
 */
@Mapper
public interface DeptMapper {

    @Select("select id,dept_name from dept where id=#{id}")
    public Dept selectDept(Integer id);

    @Insert("insert into dept(dept_name) values(#{deptName)")
    public void insertDept(Dept dept);

    @Delete("delete from dept where id=#{id}")
    public void deleteDept(Integer id);

    @Update("update emp set dept_name=#{deptName}")
    public void updateDept(Dept dept);

}
