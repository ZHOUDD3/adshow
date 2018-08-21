package com.adshow.config;

import io.moquette.server.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqttConfig {

  @Bean
  public Server mqttServer(){
    return new Server();
  }
  
}
