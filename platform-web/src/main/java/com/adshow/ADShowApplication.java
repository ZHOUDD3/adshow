package com.adshow;

import com.adshow.common.StorageProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@Slf4j
@SpringBootApplication
public class ADShowApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ADShowApplication.class, args);
        StorageProperties.FILE_ROOT_PATH = context.getEnvironment().getProperty("module.file.rootPath");
        StorageProperties.FFMPEG_PATH = context.getEnvironment().getProperty("ffmpeg.file.path");
    }
}
