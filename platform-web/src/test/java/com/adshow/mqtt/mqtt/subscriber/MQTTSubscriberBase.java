package com.adshow.mqtt.mqtt.subscriber;

import com.adshow.mqtt.mqtt.publisher.MQTTPublisherBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface MQTTSubscriberBase {

    public static final Logger logger = LoggerFactory.getLogger(MQTTPublisherBase.class);

    public void subscribeMessage(String topic);

    public void disconnect();
}
