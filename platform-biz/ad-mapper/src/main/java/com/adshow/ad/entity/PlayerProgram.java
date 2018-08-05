package com.adshow.ad.entity;

import com.adshow.core.common.entity.BaseEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhaoxianbin@163.com
 * @since 2018-08-03
 */
@TableName("ad_player_program")
public class PlayerProgram extends BaseEntity<PlayerProgram> {

    private static final long serialVersionUID = 1L;

    /**
     * 节目ID
     */
    @TableField("program_id")
    private String programId;
    /**
     * 对应发布任务ID
     */
    @TableField("task_id")
    private String taskId;
    /**
     * 播放端ID
     */
    @TableField("player_id")
    private String playerId;
    /**
     * 播放端名称
     */
    @TableField("player_name")
    private String playerName;
    /**
     * 节目名称
     */
    @TableField("program_name")
    private String programName;
    /**
     * 节目分辨率
     */
    @TableField("program_resolution")
    private String programResolution;
    /**
     * 终端的节目状态 0-未下载 1-正在下载 2-下载完成 3-节目删除
     */
    @TableField("program_status")
    private Integer programStatus;
    /**
     * 节目场景数
     */
    @TableField("program_scenecount")
    private Integer programScenecount;
    /**
     * 节目时长
     */
    @TableField("program_playtimecount")
    private Integer programPlaytimecount;
    /**
     * 所属机构ID
     */
    @TableField("group_id")
    private Integer groupId;
    /**
     * 所属机构名
     */
    @TableField("group_name")
    private String groupName;
    /**
     * 过期时间
     */
    @TableField("expiration_time")
    private Date expirationTime;
    /**
     * 接收时间
     */
    @TableField("accept_time")
    private Date acceptTime;
    /**
     * 结束时间
     */
    @TableField("finish_time")
    private Date finishTime;
    /**
     * 删除时间
     */
    @TableField("delete_time")
    private Date deleteTime;
    /**
     * 优先级
     */
    @TableField("program_priority")
    private Integer programPriority;
    /**
     * 节目大小
     */
    @TableField("program_size")
    private Long programSize;
    /**
     * 节目当前下载的大小
     */
    @TableField("downlosize")
    private Long downlosize;
    /**
     * 下载数据回传时间
     */
    @TableField("program_retime")
    private Date programRetime;
    /**
     * (定时)发布时间
     */
    @TableField("publish_time")
    private Date publishTime;
    /**
     * 发布播放方式
     */
    @TableField("publish_type")
    private String publishType;
    /**
     * 是否独占
     */
    @TableField("program_exclusive")
    private Boolean programExclusive;
    /**
     * 分发服务器ID
     */
    @TableField("server_id")
    private String serverId;
    /**
     * 分发服务器任务ID
     */
    @TableField("server_task_id")
    private String serverTaskId;


    public String getProgramId() {
        return programId;
    }

    public PlayerProgram setProgramId(String programId) {
        this.programId = programId;
        return this;
    }

    public String getTaskId() {
        return taskId;
    }

    public PlayerProgram setTaskId(String taskId) {
        this.taskId = taskId;
        return this;
    }

    public String getPlayerId() {
        return playerId;
    }

    public PlayerProgram setPlayerId(String playerId) {
        this.playerId = playerId;
        return this;
    }

    public String getPlayerName() {
        return playerName;
    }

    public PlayerProgram setPlayerName(String playerName) {
        this.playerName = playerName;
        return this;
    }

    public String getProgramName() {
        return programName;
    }

    public PlayerProgram setProgramName(String programName) {
        this.programName = programName;
        return this;
    }

    public String getProgramResolution() {
        return programResolution;
    }

    public PlayerProgram setProgramResolution(String programResolution) {
        this.programResolution = programResolution;
        return this;
    }

    public Integer getProgramStatus() {
        return programStatus;
    }

    public PlayerProgram setProgramStatus(Integer programStatus) {
        this.programStatus = programStatus;
        return this;
    }

    public Integer getProgramScenecount() {
        return programScenecount;
    }

    public PlayerProgram setProgramScenecount(Integer programScenecount) {
        this.programScenecount = programScenecount;
        return this;
    }

    public Integer getProgramPlaytimecount() {
        return programPlaytimecount;
    }

    public PlayerProgram setProgramPlaytimecount(Integer programPlaytimecount) {
        this.programPlaytimecount = programPlaytimecount;
        return this;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public PlayerProgram setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }

    public String getGroupName() {
        return groupName;
    }

    public PlayerProgram setGroupName(String groupName) {
        this.groupName = groupName;
        return this;
    }

    public Date getExpirationTime() {
        return expirationTime;
    }

    public PlayerProgram setExpirationTime(Date expirationTime) {
        this.expirationTime = expirationTime;
        return this;
    }

    public Date getAcceptTime() {
        return acceptTime;
    }

    public PlayerProgram setAcceptTime(Date acceptTime) {
        this.acceptTime = acceptTime;
        return this;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public PlayerProgram setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
        return this;
    }

    public Date getDeleteTime() {
        return deleteTime;
    }

    public PlayerProgram setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
        return this;
    }

    public Integer getProgramPriority() {
        return programPriority;
    }

    public PlayerProgram setProgramPriority(Integer programPriority) {
        this.programPriority = programPriority;
        return this;
    }

    public Long getProgramSize() {
        return programSize;
    }

    public PlayerProgram setProgramSize(Long programSize) {
        this.programSize = programSize;
        return this;
    }

    public Long getDownlosize() {
        return downlosize;
    }

    public PlayerProgram setDownlosize(Long downlosize) {
        this.downlosize = downlosize;
        return this;
    }

    public Date getProgramRetime() {
        return programRetime;
    }

    public PlayerProgram setProgramRetime(Date programRetime) {
        this.programRetime = programRetime;
        return this;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public PlayerProgram setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
        return this;
    }

    public String getPublishType() {
        return publishType;
    }

    public PlayerProgram setPublishType(String publishType) {
        this.publishType = publishType;
        return this;
    }

    public Boolean getProgramExclusive() {
        return programExclusive;
    }

    public PlayerProgram setProgramExclusive(Boolean programExclusive) {
        this.programExclusive = programExclusive;
        return this;
    }

    public String getServerId() {
        return serverId;
    }

    public PlayerProgram setServerId(String serverId) {
        this.serverId = serverId;
        return this;
    }

    public String getServerTaskId() {
        return serverTaskId;
    }

    public PlayerProgram setServerTaskId(String serverTaskId) {
        this.serverTaskId = serverTaskId;
        return this;
    }

    @Override
    public String toString() {
        return "PlayerProgram{" +
        "programId=" + programId +
        ", taskId=" + taskId +
        ", playerId=" + playerId +
        ", playerName=" + playerName +
        ", programName=" + programName +
        ", programResolution=" + programResolution +
        ", programStatus=" + programStatus +
        ", programScenecount=" + programScenecount +
        ", programPlaytimecount=" + programPlaytimecount +
        ", groupId=" + groupId +
        ", groupName=" + groupName +
        ", expirationTime=" + expirationTime +
        ", acceptTime=" + acceptTime +
        ", finishTime=" + finishTime +
        ", deleteTime=" + deleteTime +
        ", programPriority=" + programPriority +
        ", programSize=" + programSize +
        ", downlosize=" + downlosize +
        ", programRetime=" + programRetime +
        ", publishTime=" + publishTime +
        ", publishType=" + publishType +
        ", programExclusive=" + programExclusive +
        ", serverId=" + serverId +
        ", serverTaskId=" + serverTaskId +
        "}";
    }
}
