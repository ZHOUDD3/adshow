package com.adshow.web.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * ad_subtitle_manage
 * @author 
 */
public class SubtitleManage implements Serializable {
    /**
     * id
     */
    private Integer id;

    /**
     * uuid
     */
    private String uuid;

    /**
     * 存储名称
     */
    private String name;

    /**
     * 实际名称
     */
    private String aliasName;

    /**
     * 本地路径
     */
    private String physicalPath;

    /**
     * 视频大小
     */
    private Long size;

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

    /**
     * 备注
     */
    private String note;

    /**
     * 字幕内容
     */
    private String content;

    /**
     * 字幕类型（1.静态字幕 2.滚动字幕）
     */
    private Integer type;

    /**
     * 字体
     */
    private String font;

    /**
     * 字体大小
     */
    private Integer fontSize;

    /**
     * 字体颜色
     */
    private String fontColor;

    /**
     * 字体背景颜色
     */
    private String backColor;

    /**
     * 字体背景透明度
     */
    private String backTransparency;

    /**
     * 滚动速度和类型（1.快 2.适中  3.慢）
     */
    private Integer scrollSpeed;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    public String getPhysicalPath() {
        return physicalPath;
    }

    public void setPhysicalPath(String physicalPath) {
        this.physicalPath = physicalPath;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getFont() {
        return font;
    }

    public void setFont(String font) {
        this.font = font;
    }

    public Integer getFontSize() {
        return fontSize;
    }

    public void setFontSize(Integer fontSize) {
        this.fontSize = fontSize;
    }

    public String getFontColor() {
        return fontColor;
    }

    public void setFontColor(String fontColor) {
        this.fontColor = fontColor;
    }

    public String getBackColor() {
        return backColor;
    }

    public void setBackColor(String backColor) {
        this.backColor = backColor;
    }

    public String getBackTransparency() {
        return backTransparency;
    }

    public void setBackTransparency(String backTransparency) {
        this.backTransparency = backTransparency;
    }

    public Integer getScrollSpeed() {
        return scrollSpeed;
    }

    public void setScrollSpeed(Integer scrollSpeed) {
        this.scrollSpeed = scrollSpeed;
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
        SubtitleManage other = (SubtitleManage) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getAliasName() == null ? other.getAliasName() == null : this.getAliasName().equals(other.getAliasName()))
            && (this.getPhysicalPath() == null ? other.getPhysicalPath() == null : this.getPhysicalPath().equals(other.getPhysicalPath()))
            && (this.getSize() == null ? other.getSize() == null : this.getSize().equals(other.getSize()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
            && (this.getNote() == null ? other.getNote() == null : this.getNote().equals(other.getNote()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getFont() == null ? other.getFont() == null : this.getFont().equals(other.getFont()))
            && (this.getFontSize() == null ? other.getFontSize() == null : this.getFontSize().equals(other.getFontSize()))
            && (this.getFontColor() == null ? other.getFontColor() == null : this.getFontColor().equals(other.getFontColor()))
            && (this.getBackColor() == null ? other.getBackColor() == null : this.getBackColor().equals(other.getBackColor()))
            && (this.getBackTransparency() == null ? other.getBackTransparency() == null : this.getBackTransparency().equals(other.getBackTransparency()))
            && (this.getScrollSpeed() == null ? other.getScrollSpeed() == null : this.getScrollSpeed().equals(other.getScrollSpeed()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getAliasName() == null) ? 0 : getAliasName().hashCode());
        result = prime * result + ((getPhysicalPath() == null) ? 0 : getPhysicalPath().hashCode());
        result = prime * result + ((getSize() == null) ? 0 : getSize().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getNote() == null) ? 0 : getNote().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getFont() == null) ? 0 : getFont().hashCode());
        result = prime * result + ((getFontSize() == null) ? 0 : getFontSize().hashCode());
        result = prime * result + ((getFontColor() == null) ? 0 : getFontColor().hashCode());
        result = prime * result + ((getBackColor() == null) ? 0 : getBackColor().hashCode());
        result = prime * result + ((getBackTransparency() == null) ? 0 : getBackTransparency().hashCode());
        result = prime * result + ((getScrollSpeed() == null) ? 0 : getScrollSpeed().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", uuid=").append(uuid);
        sb.append(", name=").append(name);
        sb.append(", aliasName=").append(aliasName);
        sb.append(", physicalPath=").append(physicalPath);
        sb.append(", size=").append(size);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createUser=").append(createUser);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", note=").append(note);
        sb.append(", content=").append(content);
        sb.append(", type=").append(type);
        sb.append(", font=").append(font);
        sb.append(", fontSize=").append(fontSize);
        sb.append(", fontColor=").append(fontColor);
        sb.append(", backColor=").append(backColor);
        sb.append(", backTransparency=").append(backTransparency);
        sb.append(", scrollSpeed=").append(scrollSpeed);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}