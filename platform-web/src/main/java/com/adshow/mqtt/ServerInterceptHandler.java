package com.adshow.mqtt;

import com.adshow.mqtt.core.TopicMessageDeliver;
import com.adshow.palyer.service.IPlayerService;
import io.moquette.interception.InterceptHandler;
import io.moquette.interception.messages.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ServerInterceptHandler implements InterceptHandler {

    @Autowired
    private TopicMessageDeliver topicMessageDeliver;

    @Autowired
    private IPlayerService playerService;

    @Override
    public void onConnect(InterceptConnectMessage connectMessage) {
        String id = connectMessage.getClientID();
        log.info("device[" + id + "] connected...");
    }

    @Override
    public void onDisconnect(InterceptDisconnectMessage disconnectMessage) {
        String id = disconnectMessage.getClientID();
        log.info("device[" + id + "] disconnected...");
    }

    @Override
    public void onConnectionLost(InterceptConnectionLostMessage connectionLostMessage) {
        String id = connectionLostMessage.getClientID();
        log.info("device[" + id + "] lost...");
    }

    @Override
    public void onPublish(InterceptPublishMessage publishMessage) {
        log.trace("receive a mqtt message: client[{}], topic[{}]", publishMessage.getClientID(), publishMessage.getTopicName());
        topicMessageDeliver.deliver(publishMessage);
    }

    @Override
    public void onSubscribe(InterceptSubscribeMessage subscribeMessage) {
        log.trace("subscribe message: client[{}], topic[{}]", subscribeMessage.getClientID(), subscribeMessage.getTopicFilter());
    }

    @Override
    public void onUnsubscribe(InterceptUnsubscribeMessage unsubscribeMessage) {
        log.trace("unsubscribe message: client[{}], topic[{}]", unsubscribeMessage.getClientID(), unsubscribeMessage.getTopicFilter());
    }

    @Override
    public void onMessageAcknowledged(InterceptAcknowledgedMessage acknowledgedMessage) {
        log.trace("acknowledge message: msg[{}], topic[{}]", acknowledgedMessage.getMsg(), acknowledgedMessage.getTopic());
    }

    @Override
    public String getID() {
        return this.getClass().getName();
    }

    @Override
    public Class<?>[] getInterceptedMessageTypes() {
        return null;
    }

}
