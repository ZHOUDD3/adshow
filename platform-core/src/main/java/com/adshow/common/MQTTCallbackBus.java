package com.adshow.common;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

@Slf4j
public class MQTTCallbackBus implements MqttCallback {

    @Override
    public void connectionLost(Throwable cause) {
        log.error("connectionLost", cause);
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) {
        //Log.d(TAG, "messageArrived: " + topic + "====" + message.toString());
        //EventBus.getDefault().post(message);
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        log.info("deliveryComplete");
    }

}
