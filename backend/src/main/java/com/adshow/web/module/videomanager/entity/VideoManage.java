package com.adshow.web.module.videomanager.entity;

import java.io.Serializable;
import java.util.Arrays;

/**
 * ad_video_manage
 * @author 
 */
public class VideoManage implements Serializable {
    /**
     * 视频ID
     */
    private Integer id;

    /**
     * 视频名称
     */
    private String name;

    private String aliasName;

    /**
     * 本地路径
     */
    private String physicalPath;

    /**
     * 虚拟路径
     */
    private String virtualPath;

    /**
     * 视频宽高
     */
    private String widthHeight;

    /**
     * 文件类型
     */
    private String type;

    /**
     * 压缩包名称
     */
    private String zipname;

    /**
     * 视频大小
     */
    private Long size;

    /**
     * 上传时间
     */
    private String uploadTime;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 创建机构
     */
    private String groupId;

    /**
     * 修改人
     */
    private String updateUser;

    /**
     * 修改机构
     */
    private String updateGroup;

    /**
     * 修改日期
     */
    private String updateTime;

    /**
     * 备注
     */
    private String note;

    private Integer timeLength;

    /**
     * 断点续传
     */
    private Long finishSize;

    /**
     * 位图数据
     */
    private byte[] bitmapData;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getVirtualPath() {
        return virtualPath;
    }

    public void setVirtualPath(String virtualPath) {
        this.virtualPath = virtualPath;
    }

    public String getWidthHeight() {
        return widthHeight;
    }

    public void setWidthHeight(String widthHeight) {
        this.widthHeight = widthHeight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getZipname() {
        return zipname;
    }

    public void setZipname(String zipname) {
        this.zipname = zipname;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getUpdateGroup() {
        return updateGroup;
    }

    public void setUpdateGroup(String updateGroup) {
        this.updateGroup = updateGroup;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getTimeLength() {
        return timeLength;
    }

    public void setTimeLength(Integer timeLength) {
        this.timeLength = timeLength;
    }

    public Long getFinishSize() {
        return finishSize;
    }

    public void setFinishSize(Long finishSize) {
        this.finishSize = finishSize;
    }

    public byte[] getBitmapData() {
        return bitmapData;
    }

    public void setBitmapData(byte[] bitmapData) {
        this.bitmapData = bitmapData;
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
        VideoManage other = (VideoManage) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getAliasName() == null ? other.getAliasName() == null : this.getAliasName().equals(other.getAliasName()))
            && (this.getPhysicalPath() == null ? other.getPhysicalPath() == null : this.getPhysicalPath().equals(other.getPhysicalPath()))
            && (this.getVirtualPath() == null ? other.getVirtualPath() == null : this.getVirtualPath().equals(other.getVirtualPath()))
            && (this.getWidthHeight() == null ? other.getWidthHeight() == null : this.getWidthHeight().equals(other.getWidthHeight()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getZipname() == null ? other.getZipname() == null : this.getZipname().equals(other.getZipname()))
            && (this.getSize() == null ? other.getSize() == null : this.getSize().equals(other.getSize()))
            && (this.getUploadTime() == null ? other.getUploadTime() == null : this.getUploadTime().equals(other.getUploadTime()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getGroupId() == null ? other.getGroupId() == null : this.getGroupId().equals(other.getGroupId()))
            && (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
            && (this.getUpdateGroup() == null ? other.getUpdateGroup() == null : this.getUpdateGroup().equals(other.getUpdateGroup()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getNote() == null ? other.getNote() == null : this.getNote().equals(other.getNote()))
            && (this.getTimeLength() == null ? other.getTimeLength() == null : this.getTimeLength().equals(other.getTimeLength()))
            && (this.getFinishSize() == null ? other.getFinishSize() == null : this.getFinishSize().equals(other.getFinishSize()))
            && (Arrays.equals(this.getBitmapData(), other.getBitmapData()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getAliasName() == null) ? 0 : getAliasName().hashCode());
        result = prime * result + ((getPhysicalPath() == null) ? 0 : getPhysicalPath().hashCode());
        result = prime * result + ((getVirtualPath() == null) ? 0 : getVirtualPath().hashCode());
        result = prime * result + ((getWidthHeight() == null) ? 0 : getWidthHeight().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getZipname() == null) ? 0 : getZipname().hashCode());
        result = prime * result + ((getSize() == null) ? 0 : getSize().hashCode());
        result = prime * result + ((getUploadTime() == null) ? 0 : getUploadTime().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getGroupId() == null) ? 0 : getGroupId().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getUpdateGroup() == null) ? 0 : getUpdateGroup().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getNote() == null) ? 0 : getNote().hashCode());
        result = prime * result + ((getTimeLength() == null) ? 0 : getTimeLength().hashCode());
        result = prime * result + ((getFinishSize() == null) ? 0 : getFinishSize().hashCode());
        result = prime * result + (Arrays.hashCode(getBitmapData()));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", aliasName=").append(aliasName);
        sb.append(", physicalPath=").append(physicalPath);
        sb.append(", virtualPath=").append(virtualPath);
        sb.append(", widthHeight=").append(widthHeight);
        sb.append(", type=").append(type);
        sb.append(", zipname=").append(zipname);
        sb.append(", size=").append(size);
        sb.append(", uploadTime=").append(uploadTime);
        sb.append(", createUser=").append(createUser);
        sb.append(", groupId=").append(groupId);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", updateGroup=").append(updateGroup);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", note=").append(note);
        sb.append(", timeLength=").append(timeLength);
        sb.append(", finishSize=").append(finishSize);
        sb.append(", bitmapData=").append(bitmapData);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}