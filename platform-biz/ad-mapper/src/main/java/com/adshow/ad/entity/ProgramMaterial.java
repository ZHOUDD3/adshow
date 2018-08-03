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
     * 素材在节目中的位置（x*y）
     */
    @TableField("material_position")
    private String materialPosition;
    /**
     * 素材在节目中的显示大小（w*l）
     */
    @TableField("material_size")
    private String materialSize;
    /**
     * 素材在节目中显示的时间（数组）
     */
    @TableField("material_interval")
    private String materialInterval;
    /**
     * 素材在节目中的图层顺序
     */
    @TableField("material_oder")
    private String materialOder;


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

    public String getMaterialPosition() {
        return materialPosition;
    }

    public ProgramMaterial setMaterialPosition(String materialPosition) {
        this.materialPosition = materialPosition;
        return this;
    }

    public String getMaterialSize() {
        return materialSize;
    }

    public ProgramMaterial setMaterialSize(String materialSize) {
        this.materialSize = materialSize;
        return this;
    }

    public String getMaterialInterval() {
        return materialInterval;
    }

    public ProgramMaterial setMaterialInterval(String materialInterval) {
        this.materialInterval = materialInterval;
        return this;
    }

    public String getMaterialOder() {
        return materialOder;
    }

    public ProgramMaterial setMaterialOder(String materialOder) {
        this.materialOder = materialOder;
        return this;
    }

    @Override
    public String toString() {
        return "ProgramMaterial{" +
        "programId=" + programId +
        ", materialId=" + materialId +
        ", materialPosition=" + materialPosition +
        ", materialSize=" + materialSize +
        ", materialInterval=" + materialInterval +
        ", materialOder=" + materialOder +
        "}";
    }
}
