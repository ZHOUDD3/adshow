package com.adshow.mqtt.handler;

import com.adshow.mqtt.MessageContext;
import com.adshow.mqtt.RequestFuture;
import com.adshow.mqtt.core.CmdMessageDeliver;
import com.adshow.mqtt.core.MqttMessageHandler;
import com.adshow.mqtt.core.MqttMessageHandler.MqttMessageParam;
import com.adshow.mqtt.core.MqttMessageHandler.MqttMessageParam.ParamType;
import com.adshow.mqtt.core.MqttMessageHandler.TopicHandler;
import com.adshow.mqtt.message.*;
import com.adshow.mqtt.protocol.Packet;
import com.adshow.mqtt.protocol.Packet.Head;
import com.adshow.mqtt.protocol.Packet.Head.Type;
import com.adshow.mqtt.protocol.PacketUtils;
import com.fasterxml.jackson.core.JsonParser;
import io.netty.buffer.ByteBuf;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;

@Slf4j
@MqttMessageHandler
public class TopicMessageHandler {

    @Autowired
    private PacketUtils packetUtils;

    @Autowired
    private MessageContext messageContext;

    @Autowired
    private CmdMessageDeliver codeMessageDeliver;

    @TopicHandler("/s/{model}")
    public void msgProcess(@MqttMessageParam(ParamType.clientId) String clientId, @MqttMessageParam(ParamType.username) String username, ByteBuf payload, @PathVariable("model") String model) {
        try {
            byte[] payloadBytes = new byte[payload.readableBytes()];
            payload.getBytes(0, payloadBytes);
            log.info("receive raw message: {}", new String(payloadBytes, "utf-8"));
            JsonParser parser = packetUtils.createParser(payloadBytes);
            Head head = packetUtils.parseHead(parser);
            log.info("receive a packet, head : {}", head);
            int code = head.getCode();
            int type = head.getType();
            if (Type.isResponse(type)) {
                handleGenericResponse(head, parser);
                return;
            }
            codeMessageDeliver.deliver(code, type, model, clientId, username, head, parser);
        } catch (IOException e) {
            log.error("deserialize payload error", e);
        } finally {
            payload.release();
        }
    }


    //向播放器下发命令: 重启, 关机, 升级, 亮度调节, 音量调节
    @TopicHandler("/s/command")
    public void sendCommand(@MqttMessageParam(ParamType.clientId) String clientId, @MqttMessageParam(ParamType.username) String username, ByteBuf payload) {

    }

    //每播放完一个广告,把播放开始时间,播放结束时间发送回服务器存档
    @TopicHandler("/d/status/play")
    public void reportPlayStatus(@MqttMessageParam(ParamType.clientId) String clientId, @MqttMessageParam(ParamType.username) String username, PlayStatus playStatus) {
        log.debug("received message: " + playStatus);
    }

    //每下载完一个广告,把下载开始时间,下载结束时间发送回服务器存档
    @TopicHandler("/d/status/download")
    public void reportDownloadStatus(@MqttMessageParam(ParamType.clientId) String clientId, @MqttMessageParam(ParamType.username) String username, DownloadStatus downloadStatus) {
        log.debug("received message: " + downloadStatus);
    }

    //定时上报设备的基本信息
    @TopicHandler("/d/status/hardware")
    public void reportSystemStatus(@MqttMessageParam(ParamType.clientId) String clientId, @MqttMessageParam(ParamType.username) String username, HardwareStatus hardwareStatus) {
        log.debug("received message: " + hardwareStatus);
    }

    @TopicHandler("/d/status/network")
    public void reportNetworkStatus(@MqttMessageParam(ParamType.clientId) String clientId, @MqttMessageParam(ParamType.username) String username, NetworkStatus networkStatus) {
        log.debug("received message: " + networkStatus);
    }

    @TopicHandler("/d/status/running")
    public void reportRunningStatus(@MqttMessageParam(ParamType.clientId) String clientId, @MqttMessageParam(ParamType.username) String username, RunningStatus runningStatus) {
        log.debug("received message: " + runningStatus);
    }


    @SuppressWarnings({"rawtypes", "unchecked"})
    private void handleGenericResponse(Head h, JsonParser parser) throws IOException {
        RequestFuture<?> req = messageContext.remove(h.getId());
        if (req == null) {
            log.error("No request found for a response, maybe timeout, just discard it. Head : {}", h);
            return;
        }
        try {
            Object body = packetUtils.parseBody(parser, req.getResponseBodyType());
            Packet response = new Packet<>(h, body);
            req.setResponse(response);
        } catch (Exception e) {
            log.error("parseBody error, head: {}", h, e);
            req.fail(e);
        }
    }

}
