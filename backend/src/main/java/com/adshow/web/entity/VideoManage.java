package com.adshow.web.entity;

import java.io.Serializable;
import java.util.Date;

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
    private Integer timeLength;

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

    public Integer getTimeLength() {
        return timeLength;
    }

    public void setTimeLength(Integer timeLength) {
        this.timeLength = timeLength;
    }

    public Long getFinishSize() {
        return finishSize;
    }

    public void setFinishSize(Long finishSize) {
        this.finishSize = finishSize;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", resolution=").append(resolution);
        sb.append(", type=").append(type);
        sb.append(", timeLength=").append(timeLength);
        sb.append(", finishSize=").append(finishSize);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}