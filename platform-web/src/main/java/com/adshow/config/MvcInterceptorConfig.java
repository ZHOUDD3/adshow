package com.adshow.config;

import com.adshow.core.common.ratelimiter.RateLimiterInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.TimeUnit;

/**
 *
 */
@Configuration
public class MvcInterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private IgnoredUrlsProperties ignoredUrlsProperties;

    @Value("${module.file.mediaType}")
    private String[] mediaTypes;

    @Value("${module.file.rootPath}")
    private String filePath;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // 注册拦截器
        InterceptorRegistration ir = registry.addInterceptor(new RateLimiterInterceptor());
        // 配置拦截的路径
        ir.addPathPatterns("/**");
        // 配置不拦截的路径
        ir.excludePathPatterns(ignoredUrlsProperties.getUrls());
    }

    @Override
    public  void  addResourceHandlers(ResourceHandlerRegistry registry){

        registry.addResourceHandler(mediaTypes)
                .addResourceLocations("file:"+filePath);

    }



}
