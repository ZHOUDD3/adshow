package com.adshow.mqtt;

import com.adshow.mqtt.exception.MqttOpException;
import com.adshow.mqtt.protocol.Packet.Head.Type;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Slf4j
@Component
public class MessageContext {

    private ConcurrentMap<Long, RequestFuture<?>> reqCache = new ConcurrentHashMap<>();

    private long timeout = 10l * 1000 * 1000000;// nano

    @Scheduled(fixedRate = 5000)
    public void checkExpire() {
        long start = System.nanoTime();
        for (Entry<Long, RequestFuture<?>> entry : reqCache.entrySet()) {
            RequestFuture<?> req = entry.getValue();
            long aliveTime = System.nanoTime() - req.getBuildNanoTime();
            if (req != null && aliveTime > timeout) {
                req = reqCache.remove(entry.getKey());
                // check again in case of anyone else removed it
                if (req != null) {
                    req.fail(new MqttOpException(Type.RESPONSE_TIMEOUT, "Request timeout"));
                    log.debug("--- {} timeout after {}ns.", req, aliveTime);
                }
            }
        }
        long duration = System.nanoTime() - start;
        log.trace("@@@ TimeoutChecker finished in {}ns.", duration);
    }

    public void add(RequestFuture<?> req) {
        long id = req.getRequest().getHead().getId();
        if (reqCache.putIfAbsent(id, req) != null) {
            throw new IllegalArgumentException("Request with same id " + req.getRequest().getHead().getId()
                    + " already exists");
        }
    }

    public RequestFuture<?> remove(long id) {
        return reqCache.remove(id);
    }
}
