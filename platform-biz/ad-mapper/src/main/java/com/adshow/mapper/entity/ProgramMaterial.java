package com.adshow.mapper.entity;

import java.io.Serializable;

/**
 * ad_program_material
 * @author 
 */
public class ProgramMaterial implements Serializable {
    /**
     * ID自增
     */
    private Integer id;

    /**
     * 节目ID
     */
    private String programId;

    /**
     * 节目对应的素材ID
     */
    private String materialId;

    /**
     * 素材在节目中的位置（x*y）
     */
    private String materialPosition;

    /**
     * 素材在节目中的显示大小（w*l）
     */
    private String materialSize;

    /**
     * 素材在节目中显示的时间（数组）
     */
    private String materialInterval;

    /**
     * 素材在节目中的图层顺序
     */
    private String materialOder;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId;
    }

    public String getMaterialPosition() {
        return materialPosition;
    }

    public void setMaterialPosition(String materialPosition) {
        this.materialPosition = materialPosition;
    }

    public String getMaterialSize() {
        return materialSize;
    }

    public void setMaterialSize(String materialSize) {
        this.materialSize = materialSize;
    }

    public String getMaterialInterval() {
        return materialInterval;
    }

    public void setMaterialInterval(String materialInterval) {
        this.materialInterval = materialInterval;
    }

    public String getMaterialOder() {
        return materialOder;
    }

    public void setMaterialOder(String materialOder) {
        this.materialOder = materialOder;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ProgramMaterial other = (ProgramMaterial) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProgramId() == null ? other.getProgramId() == null : this.getProgramId().equals(other.getProgramId()))
            && (this.getMaterialId() == null ? other.getMaterialId() == null : this.getMaterialId().equals(other.getMaterialId()))
            && (this.getMaterialPosition() == null ? other.getMaterialPosition() == null : this.getMaterialPosition().equals(other.getMaterialPosition()))
            && (this.getMaterialSize() == null ? other.getMaterialSize() == null : this.getMaterialSize().equals(other.getMaterialSize()))
            && (this.getMaterialInterval() == null ? other.getMaterialInterval() == null : this.getMaterialInterval().equals(other.getMaterialInterval()))
            && (this.getMaterialOder() == null ? other.getMaterialOder() == null : this.getMaterialOder().equals(other.getMaterialOder()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProgramId() == null) ? 0 : getProgramId().hashCode());
        result = prime * result + ((getMaterialId() == null) ? 0 : getMaterialId().hashCode());
        result = prime * result + ((getMaterialPosition() == null) ? 0 : getMaterialPosition().hashCode());
        result = prime * result + ((getMaterialSize() == null) ? 0 : getMaterialSize().hashCode());
        result = prime * result + ((getMaterialInterval() == null) ? 0 : getMaterialInterval().hashCode());
        result = prime * result + ((getMaterialOder() == null) ? 0 : getMaterialOder().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", programId=").append(programId);
        sb.append(", materialId=").append(materialId);
        sb.append(", materialPosition=").append(materialPosition);
        sb.append(", materialSize=").append(materialSize);
        sb.append(", materialInterval=").append(materialInterval);
        sb.append(", materialOder=").append(materialOder);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}