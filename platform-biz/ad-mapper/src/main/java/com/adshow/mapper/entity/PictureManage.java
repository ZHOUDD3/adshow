package com.adshow.mapper.entity;

import java.io.Serializable;

/**
 * ad_picture_manage
 * @author 
 */
public class PictureManage implements Serializable {

    /**
     * 像素大小
     */
    private String pixelSize;

    /**
     * 图片类型（*.mp3）
     */
    private String type;

    private static final long serialVersionUID = 1L;


    public String getPixelSize() {
        return pixelSize;
    }

    public void setPixelSize(String pixelSize) {
        this.pixelSize = pixelSize;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}