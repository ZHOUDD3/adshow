package com.adshow.ad.entity;

import com.adshow.core.common.entity.BaseEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhaoxianbin@163.com
 * @since 2018-08-03
 */
@TableName("ad_picture")
public class Picture extends BaseEntity<Picture> {

    private static final long serialVersionUID = 1L;

    /**
     * 存储名称
     */
    @TableField("name")
    private String name;
    /**
     * 实际名称
     */
    @TableField("alias_name")
    private String aliasName;
    /**
     * 本地路径
     */
    @TableField("physical_path")
    private String physicalPath;
    /**
     * 视频大小
     */
    @TableField("size")
    private Long size;
    /**
     * 备注
     */
    @TableField("note")
    private String note;
    /**
     * 像素大小
     */
    @TableField("pixel_size")
    private String pixelSize;
    /**
     * 图片类型（*.mp3）
     */
    @TableField("type")
    private String type;


    public String getName() {
        return name;
    }

    public Picture setName(String name) {
        this.name = name;
        return this;
    }

    public String getAliasName() {
        return aliasName;
    }

    public Picture setAliasName(String aliasName) {
        this.aliasName = aliasName;
        return this;
    }

    public String getPhysicalPath() {
        return physicalPath;
    }

    public Picture setPhysicalPath(String physicalPath) {
        this.physicalPath = physicalPath;
        return this;
    }

    public Long getSize() {
        return size;
    }

    public Picture setSize(Long size) {
        this.size = size;
        return this;
    }

    public String getNote() {
        return note;
    }

    public Picture setNote(String note) {
        this.note = note;
        return this;
    }

    public String getPixelSize() {
        return pixelSize;
    }

    public Picture setPixelSize(String pixelSize) {
        this.pixelSize = pixelSize;
        return this;
    }

    public String getType() {
        return type;
    }

    public Picture setType(String type) {
        this.type = type;
        return this;
    }

    @Override
    public String toString() {
        return "Picture{" +
        "name=" + name +
        ", aliasName=" + aliasName +
        ", physicalPath=" + physicalPath +
        ", size=" + size +
        ", note=" + note +
        ", pixelSize=" + pixelSize +
        ", type=" + type +
        "}";
    }
}
