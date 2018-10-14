package com.adshow.mqtt.mqtt;

import com.adshow.core.common.vo.mqtt.PlayStatus;
import com.adshow.mqtt.mqtt.publisher.MQTTPublisher;
import com.adshow.mqtt.mqtt.publisher.MQTTPublisherBase;
import com.adshow.mqtt.mqtt.subscriber.MQTTSubscriber;
import com.adshow.mqtt.mqtt.subscriber.MQTTSubscriberBase;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.Date;

public class MqttTest {

    MQTTPublisherBase publisher = new MQTTPublisher();

    MQTTSubscriberBase subscriber = new MQTTSubscriber();

    @BeforeEach
    public void beforePublish() {
        subscriber.subscribeMessage("/d/status/play");
    }

    @Test
    public void testPublish() throws InterruptedException {
        PlayStatus status = new PlayStatus();
//        status.setProgramId("program1");
//        status.setBeginTime(new Date());
//        status.setEndTime(new Date());
        publisher.publishMessage("/d/status/play", JSON.toJSONString(status));
        Thread.sleep(60 * 1000);
    }

}
