package me.luocaca.model.config.radis;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * Jedis 缓存配置
 */
@Configuration
@EnableCaching//启用缓存，这个注解很重要
public class MyCacheConfig {


    @Bean("myKeyGenerator")
    public KeyGenerator keyGenerator() {
        return (target, method, params) -> method.getName() + "[" + Arrays.asList(params) + "]";
    }


}
