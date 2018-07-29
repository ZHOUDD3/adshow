package com.adshow.web;

import com.adshow.common.StorageProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.adshow")
@ComponentScan("com.adshow")
public class SpringBootVuejsApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(SpringBootVuejsApplication.class, args);
		StorageProperties.FILE_ROOT_PATH = context.getEnvironment().getProperty("module.file.rootPath");
		StorageProperties.FFMPEG_PATH = context.getEnvironment().getProperty("ffmpeg.file.path");
	}
}
