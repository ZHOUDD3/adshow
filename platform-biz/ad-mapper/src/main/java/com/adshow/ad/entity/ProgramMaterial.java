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
    private Integer positionX;
    /**
     * 素材在节目中的位置y（%）
     */
    @TableField("position_y")
    private Integer positionY;
    /**
     * 素材在节目中的宽度（%）
     */
    @TableField("width")
    private Integer width;
    /**
     * 素材在节目中的高度（%）
     */
    @TableField("height")
    private Integer height;
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

    public Integer getPositionX() {
        return positionX;
    }

    public ProgramMaterial setPositionX(Integer positionX) {
        this.positionX = positionX;
        return this;
    }

    public Integer getPositionY() {
        return positionY;
    }

    public ProgramMaterial setPositionY(Integer positionY) {
        this.positionY = positionY;
        return this;
    }

    public Integer getWidth() {
        return width;
    }

    public ProgramMaterial setWidth(Integer width) {
        this.width = width;
        return this;
    }

    public Integer getHeight() {
        return height;
    }

    public ProgramMaterial setHeight(Integer height) {
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
}
