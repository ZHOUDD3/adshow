package com.adshow.mqtt.config;

public abstract class MQTTConfig {

    protected final String broker = "localhost";
    protected final int qos = 2;
    protected Boolean hasSSL = false;
    protected Integer port = 1883;
    protected final String userName = "device";
    protected final String password = "wab123";
    protected final String TCP = "tcp://";
    protected final String SSL = "ssl://";


    protected abstract void config(String broker, Integer port, Boolean ssl, Boolean withUserNamePass);

    protected abstract void config();
}
