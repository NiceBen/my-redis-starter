package com.zsl.redisipsspringbootautoconfigure.config;

import com.zsl.redisipsspringbootautoconfigure.model.World;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomConfiguration {

    @Bean
    public World world() {
        return new World();
    }
}
