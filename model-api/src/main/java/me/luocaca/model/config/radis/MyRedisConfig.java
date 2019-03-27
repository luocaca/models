package me.luocaca.model.config.radis;

import me.luocaca.model.entity.Department;
import me.luocaca.model.entity.Employee;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import javax.swing.*;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

@Configuration

public class MyRedisConfig {

    //Employee
    @Bean
    public RedisTemplate<Object, Employee> employeeRedisTemplate(RedisConnectionFactory redisConnectionFactory) {


        RedisTemplate<Object, Employee> redisTemplate = new RedisTemplate<>();

        redisTemplate.setConnectionFactory(redisConnectionFactory);

        Jackson2JsonRedisSerializer<Employee> jsonRedisSerializer = new Jackson2JsonRedisSerializer<Employee>(Employee.class);

        //设置默认序列号方式，json
        redisTemplate.setDefaultSerializer(jsonRedisSerializer);

        return redisTemplate;

    }


    //RedisTemplate<Object, Employee> empRedisTemplate
    @Primary  // 有多个cacheManager需要制定一个默认的
    @Bean
    public RedisCacheManager employeeCacheManager(RedisConnectionFactory factory) {
        RedisCacheManager cacheManager = RedisCacheManager.create(factory);
        return cacheManager;
    }



    // Department
    @Bean
    public RedisTemplate<Object, Department> deptRedisTemplate(
            RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException {
        RedisTemplate<Object, Department> template = new RedisTemplate<Object, Department>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<Department> jsonRedisSerializer = new Jackson2JsonRedisSerializer<Department>(Department.class);
        template.setDefaultSerializer(jsonRedisSerializer);
        return template;
    }

    // Department
    @Bean
    public RedisCacheManager departmentCacheManager(RedisConnectionFactory factory) {
        RedisCacheManager cacheManager = RedisCacheManager.create(factory);
        return cacheManager;
    }














}
