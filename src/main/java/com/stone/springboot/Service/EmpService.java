package com.stone.springboot.Service;

import com.stone.springboot.bean.Emp;
import com.stone.springboot.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

/**
 * @author stone
 * @date 2019/7/11 14:24
 * description
 */
@CacheConfig(cacheNames = "emp",cacheManager = "empCacheManager") //抽取缓存的公共配置
@Service
public class EmpService {

    @Autowired
    EmpMapper empMapper;

    /**
     * @param id
     * @return
     * @Cacheable 将方法的运行结果进行缓存，下一次再调方法之前先去缓存中查找，如果没有再调用方法
     */
    @Cacheable(/*cacheNames = "emp",*/ key = "#id")
    public Emp selectEmp(Integer id) {
        System.out.println("查询" + id + "号员工");
        return empMapper.selectEmp(id);
    }

    /**
     * @param emp
     * @return 测试步骤：
     * 1.查询1号员工
     * 2.更新1号员工
     * 3.查询1号员工
     * @CachePut 先调用方法，更新数据库数据后将结果进行缓存，注意key要与select方法保持一致
     */
    @CachePut(/*cacheNames = "emp", */key = "#emp.id")
    public Emp updateEmp(Emp emp) {
        System.out.println("updateEmp:" + emp);
        empMapper.updateEmp(emp);
        return emp;
    }

    /**
     * @param id allEntries = true 清除指定缓存中所有的数据
     * @CacheEvict 清除缓存
     */
    @CacheEvict(/*cacheNames = "emp", */key = "#id")
    public void deleteEmp(Integer id) {
        System.out.println("deleteEmp:" + id);
        //empMapper.deleteEmp(id);
    }

    /**
     * @CachePut 所标注的方法一定会被执行
     * @param lastName
     * @return
     */
    @Caching(
            cacheable = {
                    @Cacheable(/*cacheNames = "emp", */key = "#lastName")
            },
            put = {
                    @CachePut(/*cacheNames = "emp",*/ key = "#result.id"),
                    @CachePut(/*cacheNames = "emp", */key = "#result.email")
            }
    )
    public Emp selectEmpByLastName(String lastName) {
        return empMapper.selectEmpByLastName(lastName);
    }
}
