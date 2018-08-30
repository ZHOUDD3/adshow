package com.adshow.mqtt.message;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class HardwareStatus extends DeviceReportStatus {

    private String osVersion;

    private Integer cupNum;

    private Double memorySize;

    private double longitude;

    private double latitude;
}
