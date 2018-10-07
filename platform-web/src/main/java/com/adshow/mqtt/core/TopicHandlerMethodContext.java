package com.adshow.mqtt.core;

import com.adshow.core.common.vo.mqtt.DeviceReportStatus;
import com.adshow.mqtt.core.MqttMessageHandler.MqttMessageParam;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import io.moquette.interception.messages.InterceptPublishMessage;
import io.netty.buffer.ByteBuf;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
public class TopicHandlerMethodContext {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private Object instance;
    private Method method;

    public TopicHandlerMethodContext(Object instance, Method method) {
        this.instance = instance;
        this.method = method;
    }

    public Object process(InterceptPublishMessage message, Map<String, String> pathVariables) {
        try {
            Parameter[] ps = method.getParameters();
            List<Object> args = new ArrayList<>();
            for (Parameter p : ps) {
                Object arg = extractArg(p, message, pathVariables);
                args.add(arg);
            }

            Object object = method.invoke(instance, args.toArray());
            log.trace("invoke message process method, service:{}, name:{}, data:{}", instance.getClass().getName(), method.getClass().getName(), args);
            return object;
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            log.error("invoke message process method error", e);
        }
        return null;
    }

    private Object extractArg(Parameter p, InterceptPublishMessage message, Map<String, String> pathVariables) {
        if (p.getType().equals(InterceptPublishMessage.class)) {
            return message;
        }
        if (p.getType().equals(ByteBuf.class)) {
            return message.getPayload();
        }
        if (DeviceReportStatus.class.isAssignableFrom(p.getType())) {
            byte[] payloadBytes = new byte[message.getPayload().readableBytes()];
            message.getPayload().getBytes(0, payloadBytes);
            String temp = new String(payloadBytes);
            return new Gson().fromJson(temp, p.getType());
        }

        if (p.getType().equals(String.class)) {
            MqttMessageParam paramAnnotation = p.getDeclaredAnnotation(MqttMessageParam.class);
            if (paramAnnotation != null) {
                switch (paramAnnotation.value()) {
                    case clientId:
                        return message.getClientID();
                    case username:
                        return message.getUsername();
                }
            }

            PathVariable pathAnnotation = p.getDeclaredAnnotation(PathVariable.class);
            if (pathAnnotation != null) {
                String pathVariable = pathAnnotation.value();
                if (pathVariable == null) {
                    pathVariable = p.getName();
                }
                return pathVariables.get(pathVariable);
            }
        }

        return null;
    }

}
