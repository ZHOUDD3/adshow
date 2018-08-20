package com.adshow.mqtt.message;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
public class PlayStatus extends DeviceReportStatus {

    private String programId;

    private Date beginTime;

    private Date endTime;

}
