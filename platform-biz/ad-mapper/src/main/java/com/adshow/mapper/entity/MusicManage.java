package com.adshow.mapper.entity;

import java.io.Serializable;

/**
 * ad_music_manage
 * @author 
 */
public class MusicManage extends FileBaseManager implements Serializable {

    /**
     * 音乐播放类型（*.mp3）
     */
    private String type;

    /**
     * 时长
     */
    private Integer timeLength;

    private static final long serialVersionUID = 1L;


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

}