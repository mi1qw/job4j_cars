package com.example.car.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("car.storage")
public class StorageConfig {

    /**
     * Folder location for storing files.
     */
    private String location = "upload-dir";
}
