package com.adshow.ad.entity;

import com.adshow.core.common.entity.BaseEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhaoxianbin@163.com
 * @since 2018-08-03
 */
@TableName("ad_program_material")
public class ProgramMaterial extends BaseEntity<ProgramMaterial> {

    private static final long serialVersionUID = 1L;

    /**
     * 节目ID
     */
    @TableField("program_id")
    private String programId;
    /**
     * 节目对应的素材ID
     */
    @TableField("material_id")
    private String materialId;
    /**
     * 素材在节目中的位置x（%）
     */
    @TableField("position_x")
    private Double positionX;
    /**
     * 素材在节目中的位置y（%）
     */
    @TableField("position_y")
    private Double positionY;
    /**
     * 素材在节目中的宽度（%）
     */
    @TableField("width")
    private Double width;
    /**
     * 素材在节目中的高度（%）
     */
    @TableField("height")
    private Double height;
    /**
     * 素材在节目中的图层顺序
     */
    @TableField("material_oder")
    private Integer materialOder;
    /**
     * 节目类型 0-视频 1-音乐 2-图片 3-字幕
     */
    @TableField("type")
    private String type;
    /**
     * 素材名称
     */
    @TableField("material_name")
    private String materialName;
    /**
     * 素材名称
     */
    @TableField("mute")
    private boolean mute;
    /**
     * 素材名称
     */
    @TableField("loop_time")
    private int loopTime;
    /**
     * 素材名称
     */
    @TableField("material_interval")
    private int materialInterval;


    public String getProgramId() {
        return programId;
    }

    public ProgramMaterial setProgramId(String programId) {
        this.programId = programId;
        return this;
    }

    public String getMaterialId() {
        return materialId;
    }

    public ProgramMaterial setMaterialId(String materialId) {
        this.materialId = materialId;
        return this;
    }

    public Double getPositionX() {
        return positionX;
    }

    public ProgramMaterial setPositionX(Double positionX) {
        this.positionX = positionX;
        return this;
    }

    public Double getPositionY() {
        return positionY;
    }

    public ProgramMaterial setPositionY(Double positionY) {
        this.positionY = positionY;
        return this;
    }

    public Double getWidth() {
        return width;
    }

    public ProgramMaterial setWidth(Double width) {
        this.width = width;
        return this;
    }

    public Double getHeight() {
        return height;
    }

    public ProgramMaterial setHeight(Double height) {
        this.height = height;
        return this;
    }

    public Integer getMaterialOder() {
        return materialOder;
    }

    public ProgramMaterial setMaterialOder(Integer materialOder) {
        this.materialOder = materialOder;
        return this;
    }

    public String getType() {
        return type;
    }

    public ProgramMaterial setType(String type) {
        this.type = type;
        return this;
    }

    public String getMaterialName() {
        return materialName;
    }

    public ProgramMaterial setMaterialName(String materialName) {
        this.materialName = materialName;
        return this;
    }


    @Override
    public String toString() {
        return "ProgramMaterial{" +
                "programId=" + programId +
                ", materialId=" + materialId +
                ", positionX=" + positionX +
                ", positionY=" + positionY +
                ", width=" + width +
                ", height=" + height +
                ", materialOder=" + materialOder +
                ", type=" + type +
                ", materialName=" + materialName +
                "}";
    }



    public int getLoopTime() {
        return loopTime;
    }

    public void setLoopTime(int loopTime) {
        this.loopTime = loopTime;
    }

    public boolean isMute() {
        return mute;
    }

    public void setMute(boolean mute) {
        this.mute = mute;
    }

    public int getMaterialInterval() {
        return materialInterval;
    }

    public void setMaterialInterval(int materialInterval) {
        this.materialInterval = materialInterval;
    }
}
