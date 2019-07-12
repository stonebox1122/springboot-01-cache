package com.stone.springboot;

import com.stone.springboot.bean.Emp;
import com.stone.springboot.mapper.EmpMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot01CacheApplicationTests {

    @Autowired
    EmpMapper empMapper;

    @Autowired
    RedisTemplate<Object, Emp> empRedisTemplate;

    @Test
    public void contextLoads() {
        System.out.println(empMapper.selectEmp(1));
    }

    @Test
    public void test02(){
        Emp emp = empMapper.selectEmp(1);
        empRedisTemplate.opsForValue().set("emp-01",emp);
    }

}
