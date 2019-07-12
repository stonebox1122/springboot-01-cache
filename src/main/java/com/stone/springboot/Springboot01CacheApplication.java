package com.stone.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 一.搭建基本环境
 * 1.在数据库中创建表
 * 2.创建javabean封装表
 * 3.整合MyBatis操作数据库
 *      1.配置数据源
 *      2.使用注解版的MyBatis
 *          1）、@MapperScan指定需要扫描的mapper接口所在的包
 *
 * 二.快速体验缓存
 * 1.开启基于注解的缓存@EnableCaching
 * 2.标注缓存注解即可@Cacheable @CacheEvict @CachePut
 *
 * 三.整合redis作为缓存
 * 1.安装redis
 * 2.引入redis的starter
 * 3.配置redis
 * 4.使用redis
 */
@EnableCaching
@MapperScan("com.stone.springboot.mapper")
@SpringBootApplication
public class Springboot01CacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot01CacheApplication.class, args);
    }

}
