package com.zsl.mockbusinesspro;

import com.zsl.redisipsspringbootautoconfigure.config.RedisIpsProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import redis.clients.jedis.Jedis;

@ComponentScan("com.zsl")
@SpringBootApplication
public class MockBusinessProApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MockBusinessProApplication.class, args);

        Jedis jedisIps = (Jedis) context.getBean("jedisIps");
        jedisIps.set("key", "jedisIps");
        String value = jedisIps.get("key");
        System.out.println("jedis获取成功 :" + value);
    }

//    @Bean(name = "jedisIps")
//    public Jedis jedis(RedisIpsProperties redisIpsProperties) {
//        System.out.println("Jedis 正在注入 IOC ...");
//        return new Jedis(redisIpsProperties.getHost(), redisIpsProperties.getPort());
//    }

}
