package com.zsl.redisipsspringbootautoconfigure.config;


import com.zsl.redisipsspringbootautoconfigure.model.World;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

@Configuration
@ConditionalOnMissingBean(Jedis.class)
@ConditionalOnClass(Jedis.class)       // 先前由于这个判断，导致没有成功
@EnableConfigurationProperties(RedisIpsProperties.class)
public class RedisIpsConfiguration {

    @Bean(name = "jedisIps")
    @ConditionalOnMissingBean(name = "jedisIps")
    public Jedis jedis(RedisIpsProperties redisIpsProperties) {
        System.out.println("Jedis 正在注入 IOC ...");
        return new Jedis(redisIpsProperties.getHost(), redisIpsProperties.getPort());
    }

    @Bean("world2")
    public World world() {
        return new World();
    }
}
