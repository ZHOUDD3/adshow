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
@TableName("ad_music")
public class Music extends BaseEntity<Music> {

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
     * 音乐播放类型（*.mp3）
     */
    @TableField("type")
    private String type;
    /**
     * 时长
     */
    @TableField("time_length")
    private Integer timeLength;


    public String getName() {
        return name;
    }

    public Music setName(String name) {
        this.name = name;
        return this;
    }

    public String getAliasName() {
        return aliasName;
    }

    public Music setAliasName(String aliasName) {
        this.aliasName = aliasName;
        return this;
    }

    public String getPhysicalPath() {
        return physicalPath;
    }

    public Music setPhysicalPath(String physicalPath) {
        this.physicalPath = physicalPath;
        return this;
    }

    public Long getSize() {
        return size;
    }

    public Music setSize(Long size) {
        this.size = size;
        return this;
    }

    public String getNote() {
        return note;
    }

    public Music setNote(String note) {
        this.note = note;
        return this;
    }

    public String getType() {
        return type;
    }

    public Music setType(String type) {
        this.type = type;
        return this;
    }

    public Integer getTimeLength() {
        return timeLength;
    }

    public Music setTimeLength(Integer timeLength) {
        this.timeLength = timeLength;
        return this;
    }

    @Override
    public String toString() {
        return "Music{" +
        "name=" + name +
        ", aliasName=" + aliasName +
        ", physicalPath=" + physicalPath +
        ", size=" + size +
        ", note=" + note +
        ", type=" + type +
        ", timeLength=" + timeLength +
        "}";
    }
}
