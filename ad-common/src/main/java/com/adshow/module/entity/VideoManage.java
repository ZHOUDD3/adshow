package com.adshow.module.entity;

import java.io.Serializable;

/**
 * ad_video_manage
 * @author 
 */
public class VideoManage extends FileBaseManager implements Serializable {

    /**
     * 视频分辨率
     */
    private String resolution;

    /**
     * 播放类型（*.mp4）
     */
    private String type;

    /**
     * 视频时长
     */
    private Double timeLength;

    /**
     * 断点续传
     */
    private Long finishSize;

    private static final long serialVersionUID = 1L;



    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getTimeLength() {
        return timeLength;
    }

    public void setTimeLength(Double timeLength) {
        this.timeLength = timeLength;
    }

    public Long getFinishSize() {
        return finishSize;
    }

    public void setFinishSize(Long finishSize) {
        this.finishSize = finishSize;
    }

}