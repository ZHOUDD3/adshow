package com.adshow.mqtt.core;

import com.adshow.mqtt.core.MqttMessageHandler.TopicHandler;
import io.moquette.interception.messages.InterceptPublishMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.type.MethodMetadata;
import org.springframework.core.type.StandardAnnotationMetadata;
import org.springframework.core.type.StandardMethodMetadata;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.annotation.PostConstruct;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Component
public class TopicMessageDeliver {

    @Autowired
    private ApplicationContext context;

    private AntPathMatcher pathMatcher = new AntPathMatcher();

    private Map<String, TopicHandlerMethodContext> topicHandlers = new HashMap<>();

    private ExecutorService executor;


    public static class MqttThreadFactory implements ThreadFactory {
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;

        public MqttThreadFactory(String poolNamePrefix) {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() :
                    Thread.currentThread().getThreadGroup();
            namePrefix = poolNamePrefix + "-thread-";
        }

        public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r,
                    namePrefix + threadNumber.getAndIncrement(),
                    0);
            if (t.isDaemon())
                t.setDaemon(false);
            if (t.getPriority() != Thread.NORM_PRIORITY)
                t.setPriority(Thread.NORM_PRIORITY);
            return t;
        }
    }


    @PostConstruct
    private void init() {
        executor = Executors.newCachedThreadPool(new MqttThreadFactory("mqttHandlerWorker"));

        Map<String, Object> beans = context.getBeansWithAnnotation(MqttMessageHandler.class);

        for (Object instance : beans.values()) {
            StandardAnnotationMetadata s = new StandardAnnotationMetadata(instance.getClass());
            //Map<String, Object> handlerMeta = s.getAnnotationAttributes(MqttMessageHandler.class.getName());
            //handlerMeta.get("value");

            Set<MethodMetadata> methods = s.getAnnotatedMethods(TopicHandler.class.getName());
            for (MethodMetadata t : methods) {
                StandardMethodMetadata m = (StandardMethodMetadata) t;
                Map<String, Object> methodMeta = m.getAnnotationAttributes(TopicHandler.class.getName());
                String topic = (String) methodMeta.get("value");
                Method h = m.getIntrospectedMethod();
                h.setAccessible(true);
                log.info("Found topic handler method: {}, meta={}", h, methodMeta);
                TopicHandlerMethodContext context = new TopicHandlerMethodContext(instance, h);
                topicHandlers.put(topic, context);
            }
        }
    }

    public void deliver(InterceptPublishMessage publishMessage) {
        String topicName = publishMessage.getTopicName();

        for (String topic : topicHandlers.keySet()) {
            if (pathMatcher.match(topic, topicName)) {
                Map<String, String> map = pathMatcher.extractUriTemplateVariables(topic, topicName);
                TopicHandlerMethodContext methodContext = topicHandlers.get(topic);
                executor.submit(new Runnable() {
                    @Override
                    public void run() {
                        methodContext.process(publishMessage, map);
                    }
                });

                return;
            }
        }

        log.warn("No handler method for topic: {}", topicName);
    }

}
