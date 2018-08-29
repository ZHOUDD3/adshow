package com.adshow.mqtt;

import com.adshow.mqtt.auth.ValidAuthenticator;
import io.moquette.server.Server;
import io.moquette.server.config.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;

@Slf4j
@Component
public class MqttStartup {

    @Value("classpath:mqtt/moquette.conf")
    Resource config;

    @Autowired
    private ValidAuthenticator camaraAuthenticator;

    @Autowired
    private Server mqttBroker;

    @Autowired
    private ServerInterceptHandler handler;

    @PostConstruct
    public void start() throws Exception {
        startBroker();
    }

    @PreDestroy
    public void stop() throws Exception {
        mqttBroker.stopServer();
        log.info("MQTT Broker stopped");
    }

    private void startBroker() throws IOException {
        IResourceLoader fileResourceLoader = new FileResourceLoader(config.getFile());
        final IConfig config = new ResourceLoaderConfig(fileResourceLoader);
        mqttBroker.startServer(config, null, null, camaraAuthenticator, null);
        mqttBroker.addInterceptHandler(handler);
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				mqttBroker.stopServer();
				log.info("MQTT Broker stoped");
			}
		});
        log.info("MQTT Broker started");
    }

}
