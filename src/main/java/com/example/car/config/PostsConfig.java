package com.example.car.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("car.posts")
public class PostsConfig {
    /**
     * Size of page Posts.
     */
    private int pageSize = 20;
}
