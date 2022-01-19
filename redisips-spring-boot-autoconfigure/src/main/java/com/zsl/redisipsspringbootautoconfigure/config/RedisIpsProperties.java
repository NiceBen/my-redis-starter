package com.zsl.redisipsspringbootautoconfigure.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

// 我们选择加载以 redisips 开头的内容
@Component
@ConfigurationProperties(prefix = "redisips")
public class RedisIpsProperties {

    // 设置默认地址和端口
    private String host = "127.0.0.1";
//    private String host = "10.7.142.169";

    private int port = 6379;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
