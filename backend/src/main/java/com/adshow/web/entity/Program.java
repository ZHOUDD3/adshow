package com.adshow.web.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * ad_program
 * @author 
 */
public class Program implements Serializable {
    /**
     * ID
     */
    private String id;

    /**
     * 节目GUID
     */
    private String programId;

    /**
     * 节目名称
     */
    private String name;

    /**
     * 节目类型 1-普通节目 2-直播节目
     */
    private Byte type;

    /**
     * 节目时长
     */
    private Integer programDuration;

    /**
     * 节目分辨率
     */
    private String resolution;

    /**
     * 节目描述
     */
    private String programDescription;

    /**
     * 视频ids
     */
    private String videoIds;

    /**
     * 背景音乐ids
     */
    private String musicIds;

    /**
     * 字幕ids
     */
    private String textIds;

    /**
     * 天气是否显示
     */
    private String weather;

    /**
     * 日期是否显示
     */
    private String dateShow;

    /**
     * 节目预览图
     */
    private String previewimage;

    /**
     * 模板图片
     */
    private String templateImage;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建者ID
     */
    private String createUser;

    /**
     * 更新者ID
     */
    private String updateUser;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Integer getProgramDuration() {
        return programDuration;
    }

    public void setProgramDuration(Integer programDuration) {
        this.programDuration = programDuration;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getProgramDescription() {
        return programDescription;
    }

    public void setProgramDescription(String programDescription) {
        this.programDescription = programDescription;
    }

    public String getVideoIds() {
        return videoIds;
    }

    public void setVideoIds(String videoIds) {
        this.videoIds = videoIds;
    }

    public String getMusicIds() {
        return musicIds;
    }

    public void setMusicIds(String musicIds) {
        this.musicIds = musicIds;
    }

    public String getTextIds() {
        return textIds;
    }

    public void setTextIds(String textIds) {
        this.textIds = textIds;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getDateShow() {
        return dateShow;
    }

    public void setDateShow(String dateShow) {
        this.dateShow = dateShow;
    }

    public String getPreviewimage() {
        return previewimage;
    }

    public void setPreviewimage(String previewimage) {
        this.previewimage = previewimage;
    }

    public String getTemplateImage() {
        return templateImage;
    }

    public void setTemplateImage(String templateImage) {
        this.templateImage = templateImage;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
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
        Program other = (Program) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProgramId() == null ? other.getProgramId() == null : this.getProgramId().equals(other.getProgramId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getProgramDuration() == null ? other.getProgramDuration() == null : this.getProgramDuration().equals(other.getProgramDuration()))
            && (this.getResolution() == null ? other.getResolution() == null : this.getResolution().equals(other.getResolution()))
            && (this.getProgramDescription() == null ? other.getProgramDescription() == null : this.getProgramDescription().equals(other.getProgramDescription()))
            && (this.getVideoIds() == null ? other.getVideoIds() == null : this.getVideoIds().equals(other.getVideoIds()))
            && (this.getMusicIds() == null ? other.getMusicIds() == null : this.getMusicIds().equals(other.getMusicIds()))
            && (this.getTextIds() == null ? other.getTextIds() == null : this.getTextIds().equals(other.getTextIds()))
            && (this.getWeather() == null ? other.getWeather() == null : this.getWeather().equals(other.getWeather()))
            && (this.getDateShow() == null ? other.getDateShow() == null : this.getDateShow().equals(other.getDateShow()))
            && (this.getPreviewimage() == null ? other.getPreviewimage() == null : this.getPreviewimage().equals(other.getPreviewimage()))
            && (this.getTemplateImage() == null ? other.getTemplateImage() == null : this.getTemplateImage().equals(other.getTemplateImage()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProgramId() == null) ? 0 : getProgramId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getProgramDuration() == null) ? 0 : getProgramDuration().hashCode());
        result = prime * result + ((getResolution() == null) ? 0 : getResolution().hashCode());
        result = prime * result + ((getProgramDescription() == null) ? 0 : getProgramDescription().hashCode());
        result = prime * result + ((getVideoIds() == null) ? 0 : getVideoIds().hashCode());
        result = prime * result + ((getMusicIds() == null) ? 0 : getMusicIds().hashCode());
        result = prime * result + ((getTextIds() == null) ? 0 : getTextIds().hashCode());
        result = prime * result + ((getWeather() == null) ? 0 : getWeather().hashCode());
        result = prime * result + ((getDateShow() == null) ? 0 : getDateShow().hashCode());
        result = prime * result + ((getPreviewimage() == null) ? 0 : getPreviewimage().hashCode());
        result = prime * result + ((getTemplateImage() == null) ? 0 : getTemplateImage().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
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
        sb.append(", name=").append(name);
        sb.append(", type=").append(type);
        sb.append(", programDuration=").append(programDuration);
        sb.append(", resolution=").append(resolution);
        sb.append(", programDescription=").append(programDescription);
        sb.append(", videoIds=").append(videoIds);
        sb.append(", musicIds=").append(musicIds);
        sb.append(", textIds=").append(textIds);
        sb.append(", weather=").append(weather);
        sb.append(", dateShow=").append(dateShow);
        sb.append(", previewimage=").append(previewimage);
        sb.append(", templateImage=").append(templateImage);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createUser=").append(createUser);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}