package com.adshow.core.common.vo.mqtt;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class RunningStatus extends DeviceReportStatus {

    private Date bootTime;

    private Date shutdownTime;

}
