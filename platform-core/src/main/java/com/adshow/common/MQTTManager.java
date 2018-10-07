package com.adshow.common;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MqttDefaultFilePersistence;

@Slf4j
public class MQTTManager {

    private static final String TAG = MQTTManager.class.getCanonicalName();

    public static final String URL = "tcp://localhost:1883";

    public static final String userName = "device";

    public static final String password = "wab123";

    public static final String clientId = "server";

    public static final String TOPIC_PROGRAM_DEPLOY = "/s/dev/%s/deploy";

    public static final String PUB_TOPIC_RUNNING = "/d/status/running";

    private static MQTTManager mInstance = null;

    private MqttCallback mCallback;

    private MqttClient client;

    private MqttConnectOptions conOpt;

    private boolean clean = true;

    private MQTTManager() {
        mCallback = new MQTTCallbackBus();
        if (!isConnected()) {
            connect(URL, userName, password, clientId);
        }
    }

    public static MQTTManager getInstance() {
        if (null == mInstance) {
            mInstance = new MQTTManager();
        }
        return mInstance;
    }


    public static void release() {
        try {
            if (mInstance != null) {
                mInstance.disConnect();
                mInstance = null;
            }
        } catch (Exception e) {

        }
    }


    private boolean connect(String brokerUrl, String userName, String password, String clientId) {
        boolean flag = false;
        String tmpDir = System.getProperty("java.io.tmpdir");
        MqttDefaultFilePersistence dataStore = new MqttDefaultFilePersistence(tmpDir);

        try {
            conOpt = new MqttConnectOptions();
            conOpt.setMqttVersion(MqttConnectOptions.MQTT_VERSION_3_1_1);
            conOpt.setCleanSession(clean);
            if (password != null) {
                conOpt.setPassword(password.toCharArray());
            }
            if (userName != null) {
                conOpt.setUserName(userName);
            }

            client = new MqttClient(brokerUrl, clientId, dataStore);
            client.setCallback(mCallback);
            flag = doConnect();
        } catch (MqttException e) {
            log.error("error during connect: ", e.getMessage());
        }

        return flag;
    }


    private boolean doConnect() {
        boolean flag = false;
        if (client != null) {
            try {
                client.connect(conOpt);
                log.debug("error during connect: ", "Connected to " + client.getServerURI() + " with client ID " + client.getClientId());
                flag = true;
            } catch (Exception e) {
            }
        }
        return flag;
    }


    public boolean publish(String topicName, int qos, byte[] payload) {
        if (!isConnected()) {
            connect(URL, userName, password, clientId);
        }
        boolean flag = false;
        if (client != null && client.isConnected()) {
            log.debug("Publishing to topic \"" + topicName + "\" qos " + qos);
            MqttMessage message = new MqttMessage(payload);
            message.setQos(qos);
            try {
                client.publish(topicName, message);
                flag = true;
            } catch (MqttException e) {

            }
        }
        return flag;
    }


    public boolean subscribe(String topicName, int qos) {
        if (!isConnected()) {
            connect(URL, userName, password, clientId);
        }
        boolean flag = false;
        if (client != null && client.isConnected()) {
            log.debug("Subscribing to topic \"" + topicName + "\" qos " + qos);
            try {
                client.subscribe(topicName, qos);
                flag = true;
            } catch (MqttException e) {

            }
        }
        return flag;
    }


    public void disConnect() throws MqttException {
        if (client != null && client.isConnected()) {
            client.disconnect();
        }
    }


    public boolean isConnected() {
        return client != null && client.isConnected();
    }
}
