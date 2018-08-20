package com.adshow.mqtt.message;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
public class DownloadStatus extends DeviceReportStatus {

    private String programId;

    private Date beginTime;

    private Date endTime;

    /**
     * 完整性检查
     */
    private boolean checksum;
}
