package com.stone.springboot.config;

import com.stone.springboot.bean.Emp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.net.UnknownHostException;

/**
 * @author stone
 * @date 2019/7/12 10:15
 * description
 */
@Configuration
public class MyRedisConfig {

    /**
     * 将对象转换为Json字符串保存到Redis中
     * @param redisConnectionFactory
     * @return
     * @throws UnknownHostException
     */
    @Bean
    public RedisTemplate<Object, Emp> empRedisTemplate(
            RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException {
        RedisTemplate<Object, Emp> template = new RedisTemplate<Object, Emp>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<Emp> serializer = new Jackson2JsonRedisSerializer<>(Emp.class);
        template.setDefaultSerializer(serializer);
        return template;
    }

    /**
     * 将默认情况下使用对象序列化保存对象修改为使用Json保存对象到Redis
     * @param empRedisTemplate
     * @return
     */
    @Primary
    @Bean
    public RedisCacheManager empCacheManager(RedisTemplate<Object, Emp> empRedisTemplate){
        RedisCacheManager cacheManager = new RedisCacheManager(empRedisTemplate);
        // 默认会将cacheNames作为key的前缀
        cacheManager.setUsePrefix(true);
        return cacheManager;
    }

}
