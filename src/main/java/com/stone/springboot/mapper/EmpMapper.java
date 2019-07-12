package com.stone.springboot.mapper;

import com.stone.springboot.bean.Emp;
import org.apache.ibatis.annotations.*;

/**
 * @author stone
 * @date 2019/7/11 14:12
 * description
 */
@Mapper
public interface EmpMapper {

    @Select("select id,last_name,email,gender,d_id from emp where id=#{id}")
    public Emp selectEmp(Integer id);

    @Insert("insert into emp(last_name,email,gender,d_id) values(#{lastName},#{email},#{gender},#{dId}")
    public void insertEmp(Emp emp);

    @Delete("delete from emp where id=#{id}")
    public void deleteEmp(Integer id);

    @Update("update emp set last_name=#{lastName},email=#{email},gender=#{gender},d_id=#{dId} where id=#{id}")
    public void updateEmp(Emp emp);

    @Select("select id,last_name,email,gender,d_id from emp where last_name=#{lastName}")
    public Emp selectEmpByLastName(String lastName);
}
