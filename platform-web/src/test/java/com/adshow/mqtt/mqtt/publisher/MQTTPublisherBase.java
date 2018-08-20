package com.adshow.mqtt.mqtt.publisher;


public interface MQTTPublisherBase {

    public void publishMessage(String topic, String message);

    public void disconnect();

}
