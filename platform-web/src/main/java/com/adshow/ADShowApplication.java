package com.adshow;

import com.adshow.common.StorageProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;


@SpringBootApplication
public class ADShowApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ADShowApplication.class, args);
        StorageProperties.FILE_ROOT_PATH = context.getEnvironment().getProperty("module.file.rootPath");
        StorageProperties.FFMPEG_PATH = context.getEnvironment().getProperty("ffmpeg.file.path");
    }
}
