package com.adshow.web.module.videomanager.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * ad_player_program
 * @author 
 */
public class PlayerProgram implements Serializable {
    /**
     * ID自增
     */
    private Integer id;

    /**
     * 节目ID
     */
    private String programId;

    /**
     * 对应发布任务ID
     */
    private String taskId;

    /**
     * 播放端ID
     */
    private String playerId;

    /**
     * 播放端名称
     */
    private String playerName;

    /**
     * 节目名称
     */
    private String programName;

    /**
     * 节目分辨率
     */
    private String programResolution;

    /**
     * 终端的节目状态 0-未下载 1-正在下载 2-下载完成 3-节目删除
     */
    private Byte programStatus;

    /**
     * 节目场景数
     */
    private Integer programScenecount;

    /**
     * 节目时长
     */
    private Integer programPlaytimecount;

    /**
     * 所属机构ID
     */
    private Integer groupId;

    /**
     * 所属机构名
     */
    private String groupName;

    /**
     * 过期时间
     */
    private Date expirationTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 接收时间
     */
    private Date acceptTime;

    /**
     * 结束时间
     */
    private Date finishTime;

    /**
     * 删除时间
     */
    private Date deleteTime;

    /**
     * 优先级
     */
    private Integer programPriority;

    /**
     * 节目大小
     */
    private Long programSize;

    /**
     * 节目当前下载的大小
     */
    private Long downloadSize;

    /**
     * 下载数据回传时间
     */
    private Date programRetime;

    /**
     * (定时)发布时间
     */
    private Date publishTime;

    /**
     * 发布播放方式
     */
    private String publishType;

    /**
     * 是否独占
     */
    private Boolean programExclusive;

    /**
     * 分发服务器ID
     */
    private String serverId;

    /**
     * 分发服务器任务ID
     */
    private String serverTaskId;

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

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getProgramResolution() {
        return programResolution;
    }

    public void setProgramResolution(String programResolution) {
        this.programResolution = programResolution;
    }

    public Byte getProgramStatus() {
        return programStatus;
    }

    public void setProgramStatus(Byte programStatus) {
        this.programStatus = programStatus;
    }

    public Integer getProgramScenecount() {
        return programScenecount;
    }

    public void setProgramScenecount(Integer programScenecount) {
        this.programScenecount = programScenecount;
    }

    public Integer getProgramPlaytimecount() {
        return programPlaytimecount;
    }

    public void setProgramPlaytimecount(Integer programPlaytimecount) {
        this.programPlaytimecount = programPlaytimecount;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Date getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Date expirationTime) {
        this.expirationTime = expirationTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getAcceptTime() {
        return acceptTime;
    }

    public void setAcceptTime(Date acceptTime) {
        this.acceptTime = acceptTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    public Integer getProgramPriority() {
        return programPriority;
    }

    public void setProgramPriority(Integer programPriority) {
        this.programPriority = programPriority;
    }

    public Long getProgramSize() {
        return programSize;
    }

    public void setProgramSize(Long programSize) {
        this.programSize = programSize;
    }

    public Long getDownloadSize() {
        return downloadSize;
    }

    public void setDownloadSize(Long downloadSize) {
        this.downloadSize = downloadSize;
    }

    public Date getProgramRetime() {
        return programRetime;
    }

    public void setProgramRetime(Date programRetime) {
        this.programRetime = programRetime;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public String getPublishType() {
        return publishType;
    }

    public void setPublishType(String publishType) {
        this.publishType = publishType;
    }

    public Boolean getProgramExclusive() {
        return programExclusive;
    }

    public void setProgramExclusive(Boolean programExclusive) {
        this.programExclusive = programExclusive;
    }

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    public String getServerTaskId() {
        return serverTaskId;
    }

    public void setServerTaskId(String serverTaskId) {
        this.serverTaskId = serverTaskId;
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
        PlayerProgram other = (PlayerProgram) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProgramId() == null ? other.getProgramId() == null : this.getProgramId().equals(other.getProgramId()))
            && (this.getTaskId() == null ? other.getTaskId() == null : this.getTaskId().equals(other.getTaskId()))
            && (this.getPlayerId() == null ? other.getPlayerId() == null : this.getPlayerId().equals(other.getPlayerId()))
            && (this.getPlayerName() == null ? other.getPlayerName() == null : this.getPlayerName().equals(other.getPlayerName()))
            && (this.getProgramName() == null ? other.getProgramName() == null : this.getProgramName().equals(other.getProgramName()))
            && (this.getProgramResolution() == null ? other.getProgramResolution() == null : this.getProgramResolution().equals(other.getProgramResolution()))
            && (this.getProgramStatus() == null ? other.getProgramStatus() == null : this.getProgramStatus().equals(other.getProgramStatus()))
            && (this.getProgramScenecount() == null ? other.getProgramScenecount() == null : this.getProgramScenecount().equals(other.getProgramScenecount()))
            && (this.getProgramPlaytimecount() == null ? other.getProgramPlaytimecount() == null : this.getProgramPlaytimecount().equals(other.getProgramPlaytimecount()))
            && (this.getGroupId() == null ? other.getGroupId() == null : this.getGroupId().equals(other.getGroupId()))
            && (this.getGroupName() == null ? other.getGroupName() == null : this.getGroupName().equals(other.getGroupName()))
            && (this.getExpirationTime() == null ? other.getExpirationTime() == null : this.getExpirationTime().equals(other.getExpirationTime()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getAcceptTime() == null ? other.getAcceptTime() == null : this.getAcceptTime().equals(other.getAcceptTime()))
            && (this.getFinishTime() == null ? other.getFinishTime() == null : this.getFinishTime().equals(other.getFinishTime()))
            && (this.getDeleteTime() == null ? other.getDeleteTime() == null : this.getDeleteTime().equals(other.getDeleteTime()))
            && (this.getProgramPriority() == null ? other.getProgramPriority() == null : this.getProgramPriority().equals(other.getProgramPriority()))
            && (this.getProgramSize() == null ? other.getProgramSize() == null : this.getProgramSize().equals(other.getProgramSize()))
            && (this.getDownloadSize() == null ? other.getDownloadSize() == null : this.getDownloadSize().equals(other.getDownloadSize()))
            && (this.getProgramRetime() == null ? other.getProgramRetime() == null : this.getProgramRetime().equals(other.getProgramRetime()))
            && (this.getPublishTime() == null ? other.getPublishTime() == null : this.getPublishTime().equals(other.getPublishTime()))
            && (this.getPublishType() == null ? other.getPublishType() == null : this.getPublishType().equals(other.getPublishType()))
            && (this.getProgramExclusive() == null ? other.getProgramExclusive() == null : this.getProgramExclusive().equals(other.getProgramExclusive()))
            && (this.getServerId() == null ? other.getServerId() == null : this.getServerId().equals(other.getServerId()))
            && (this.getServerTaskId() == null ? other.getServerTaskId() == null : this.getServerTaskId().equals(other.getServerTaskId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProgramId() == null) ? 0 : getProgramId().hashCode());
        result = prime * result + ((getTaskId() == null) ? 0 : getTaskId().hashCode());
        result = prime * result + ((getPlayerId() == null) ? 0 : getPlayerId().hashCode());
        result = prime * result + ((getPlayerName() == null) ? 0 : getPlayerName().hashCode());
        result = prime * result + ((getProgramName() == null) ? 0 : getProgramName().hashCode());
        result = prime * result + ((getProgramResolution() == null) ? 0 : getProgramResolution().hashCode());
        result = prime * result + ((getProgramStatus() == null) ? 0 : getProgramStatus().hashCode());
        result = prime * result + ((getProgramScenecount() == null) ? 0 : getProgramScenecount().hashCode());
        result = prime * result + ((getProgramPlaytimecount() == null) ? 0 : getProgramPlaytimecount().hashCode());
        result = prime * result + ((getGroupId() == null) ? 0 : getGroupId().hashCode());
        result = prime * result + ((getGroupName() == null) ? 0 : getGroupName().hashCode());
        result = prime * result + ((getExpirationTime() == null) ? 0 : getExpirationTime().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getAcceptTime() == null) ? 0 : getAcceptTime().hashCode());
        result = prime * result + ((getFinishTime() == null) ? 0 : getFinishTime().hashCode());
        result = prime * result + ((getDeleteTime() == null) ? 0 : getDeleteTime().hashCode());
        result = prime * result + ((getProgramPriority() == null) ? 0 : getProgramPriority().hashCode());
        result = prime * result + ((getProgramSize() == null) ? 0 : getProgramSize().hashCode());
        result = prime * result + ((getDownloadSize() == null) ? 0 : getDownloadSize().hashCode());
        result = prime * result + ((getProgramRetime() == null) ? 0 : getProgramRetime().hashCode());
        result = prime * result + ((getPublishTime() == null) ? 0 : getPublishTime().hashCode());
        result = prime * result + ((getPublishType() == null) ? 0 : getPublishType().hashCode());
        result = prime * result + ((getProgramExclusive() == null) ? 0 : getProgramExclusive().hashCode());
        result = prime * result + ((getServerId() == null) ? 0 : getServerId().hashCode());
        result = prime * result + ((getServerTaskId() == null) ? 0 : getServerTaskId().hashCode());
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
        sb.append(", taskId=").append(taskId);
        sb.append(", playerId=").append(playerId);
        sb.append(", playerName=").append(playerName);
        sb.append(", programName=").append(programName);
        sb.append(", programResolution=").append(programResolution);
        sb.append(", programStatus=").append(programStatus);
        sb.append(", programScenecount=").append(programScenecount);
        sb.append(", programPlaytimecount=").append(programPlaytimecount);
        sb.append(", groupId=").append(groupId);
        sb.append(", groupName=").append(groupName);
        sb.append(", expirationTime=").append(expirationTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", acceptTime=").append(acceptTime);
        sb.append(", finishTime=").append(finishTime);
        sb.append(", deleteTime=").append(deleteTime);
        sb.append(", programPriority=").append(programPriority);
        sb.append(", programSize=").append(programSize);
        sb.append(", downloadSize=").append(downloadSize);
        sb.append(", programRetime=").append(programRetime);
        sb.append(", publishTime=").append(publishTime);
        sb.append(", publishType=").append(publishType);
        sb.append(", programExclusive=").append(programExclusive);
        sb.append(", serverId=").append(serverId);
        sb.append(", serverTaskId=").append(serverTaskId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}