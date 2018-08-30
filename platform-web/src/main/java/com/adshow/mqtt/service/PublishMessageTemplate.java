package com.adshow.mqtt.service;

import com.adshow.mqtt.MessageContext;
import com.adshow.mqtt.RequestFuture;
import com.adshow.mqtt.protocol.Packet;
import com.adshow.mqtt.protocol.PacketUtils;
import io.moquette.server.Server;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.handler.codec.mqtt.MqttMessageBuilders;
import io.netty.handler.codec.mqtt.MqttPublishMessage;
import io.netty.handler.codec.mqtt.MqttQoS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PublishMessageTemplate {

    @Autowired
    private MessageContext msgContext;

    @Autowired
    private Server mqttBroker;

    @Autowired
    private PacketUtils packetUtils;

    public void sendTo(String topic, Packet<?> packet) {
        byte[] bytes = packetUtils.serialize(packet);
        ByteBuf buf = ByteBufAllocator.DEFAULT.buffer().writeBytes(bytes);
        MqttPublishMessage pm = MqttMessageBuilders.publish().topicName(topic).qos(MqttQoS.AT_MOST_ONCE).payload(buf).build();
        mqttBroker.internalPublish(pm, "SERVER_SELF");
    }

    public <T> RequestFuture<T> sendRequest(String topic, Packet<?> request, Class<T> responseBodyType) {
        RequestFuture<T> future = new RequestFuture<>(request, responseBodyType);
        sendTo(topic, request);
        msgContext.add(future);
        return future;
    }

}
