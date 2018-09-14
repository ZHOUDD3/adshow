package com.adshow.core.common.Param;

import java.io.Serializable;

/**
 * @Author martin
 * @Date 2018/9/14
 */
public class ImgEntity implements Serializable {
    /**
     * 图片路径
     */
    private String imgPath;
    /**
     * 图片在节目中所占尺寸百分比
     */
    private Integer[] size;
    /**
     * 图片在节目中所占位置百分比
     */
    private Integer[] location;

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public Integer[] getSize() {
        return size;
    }

    public void setSize(Integer[] size) {
        this.size = size;
    }

    public Integer[] getLocation() {
        return location;
    }

    public void setLocation(Integer[] location) {
        this.location = location;
    }
}
