package com.adshow.ad.entity;

import com.adshow.core.common.entity.BaseEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhaoxianbin@163.com
 * @since 2018-08-03
 */
@TableName("ad_video")
public class Video extends BaseEntity<Video> {

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
    @JsonIgnore
    @TableField("physical_path")
    private String physicalPath;
    /**
     * 大小
     */
    @TableField("size")
    private Long size;
    /**
     * 备注
     */
    @TableField("note")
    private String note;
    /**
     * 视频分辨率
     */
    @TableField("resolution")
    private String resolution;
    /**
     * 播放类型（*.mp4）
     */
    @TableField("type")
    private String type;
    /**
     * 视频时长
     */
    @TableField("time_length")
    private Integer timeLength;
    /**
     * 断点续传
     */
    @TableField("finish_size")
    private Long finishSize;


    public String getName() {
        return name;
    }

    public Video setName(String name) {
        this.name = name;
        return this;
    }

    public String getAliasName() {
        return aliasName;
    }

    public Video setAliasName(String aliasName) {
        this.aliasName = aliasName;
        return this;
    }

    public String getPhysicalPath() {
        return physicalPath;
    }

    public Video setPhysicalPath(String physicalPath) {
        this.physicalPath = physicalPath;
        return this;
    }

    public Long getSize() {
        return size;
    }

    public Video setSize(Long size) {
        this.size = size;
        return this;
    }

    public String getNote() {
        return note;
    }

    public Video setNote(String note) {
        this.note = note;
        return this;
    }

    public String getResolution() {
        return resolution;
    }

    public Video setResolution(String resolution) {
        this.resolution = resolution;
        return this;
    }

    public String getType() {
        return type;
    }

    public Video setType(String type) {
        this.type = type;
        return this;
    }

    public Integer getTimeLength() {
        return timeLength;
    }

    public Video setTimeLength(Integer timeLength) {
        this.timeLength = timeLength;
        return this;
    }

    public Long getFinishSize() {
        return finishSize;
    }

    public Video setFinishSize(Long finishSize) {
        this.finishSize = finishSize;
        return this;
    }

    @Override
    public String toString() {
        return "Video{" +
        "name=" + name +
        ", aliasName=" + aliasName +
        ", physicalPath=" + physicalPath +
        ", size=" + size +
        ", note=" + note +
        ", resolution=" + resolution +
        ", type=" + type +
        ", timeLength=" + timeLength +
        ", finishSize=" + finishSize +
        "}";
    }
}
