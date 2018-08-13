package com.adshow.ad.entity;

import java.util.Date;

import com.adshow.core.common.entity.BaseEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.Version;

/**
 * <p>
 * 
 * </p>
 *
 * @author wmz
 * @since 2018-08-13
 */
@TableName("ad_player_status")
public class PlayerStatus extends BaseEntity<PlayerStatus> {

    private static final long serialVersionUID = 1L;

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
    @TableField("resolution")
    private String resolution;
    /**
     * 终端的在线状态 0-离线 1-在线 
     */
    @TableField("status")
    private Integer status;
    /**
     * 节目时长
     */
    @TableField("program_duration")
    private Integer programDuration;
    /**
     * 创建时间
     */
    @TableField("start_date")
    private Date startDate;
    /**
     * 过期时间
     */
    @TableField("end_date")
    private Date endDate;
    /**
     * 开始时段（0~24）
     */
    @TableField("start_time")
    private Date startTime;
    /**
     * 结束时段（0~24）
     */
    @TableField("end_time")
    private Date endTime;
    /**
     * 节目大小
     */
    @TableField("size")
    private Long size;
    /**
     * 磁盘空间
     */
    @TableField("diskspace")
    private Long diskspace;
    /**
     * 剩余空间
     */
    @TableField("remainingspace")
    private Long remainingspace;


    public String getPlayerId() {
        return playerId;
    }

    public PlayerStatus setPlayerId(String playerId) {
        this.playerId = playerId;
        return this;
    }

    public String getPlayerName() {
        return playerName;
    }

    public PlayerStatus setPlayerName(String playerName) {
        this.playerName = playerName;
        return this;
    }

    public String getProgramName() {
        return programName;
    }

    public PlayerStatus setProgramName(String programName) {
        this.programName = programName;
        return this;
    }

    public String getResolution() {
        return resolution;
    }

    public PlayerStatus setResolution(String resolution) {
        this.resolution = resolution;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public PlayerStatus setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public Integer getProgramDuration() {
        return programDuration;
    }

    public PlayerStatus setProgramDuration(Integer programDuration) {
        this.programDuration = programDuration;
        return this;
    }

    public Date getStartDate() {
        return startDate;
    }

    public PlayerStatus setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public Date getEndDate() {
        return endDate;
    }

    public PlayerStatus setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }

    public Date getStartTime() {
        return startTime;
    }

    public PlayerStatus setStartTime(Date startTime) {
        this.startTime = startTime;
        return this;
    }

    public Date getEndTime() {
        return endTime;
    }

    public PlayerStatus setEndTime(Date endTime) {
        this.endTime = endTime;
        return this;
    }

    public Long getSize() {
        return size;
    }

    public PlayerStatus setSize(Long size) {
        this.size = size;
        return this;
    }

    public Long getDiskspace() {
        return diskspace;
    }

    public PlayerStatus setDiskspace(Long diskspace) {
        this.diskspace = diskspace;
        return this;
    }

    public Long getRemainingspace() {
        return remainingspace;
    }

    public PlayerStatus setRemainingspace(Long remainingspace) {
        this.remainingspace = remainingspace;
        return this;
    }


    @Override
    public String toString() {
        return "PlayerStatus{" +
        "playerId=" + playerId +
        ", playerName=" + playerName +
        ", programName=" + programName +
        ", resolution=" + resolution +
        ", status=" + status +
        ", programDuration=" + programDuration +
        ", startDate=" + startDate +
        ", endDate=" + endDate +
        ", startTime=" + startTime +
        ", endTime=" + endTime +
        ", size=" + size +
        ", diskspace=" + diskspace +
        ", remainingspace=" + remainingspace +
        "}";
    }
}
