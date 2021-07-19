package com.mycompany.myapp.config;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

@Configuration
public class JedisConfiguration {

    @Bean
    public Jedis getJedis() {
        return new Jedis("192.168.1.139", 6379);
    }
}
