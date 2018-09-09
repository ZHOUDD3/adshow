package com.adshow.ad.entity;

import java.util.Date;

import com.adshow.core.common.entity.BaseEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.Version;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 
 * </p>
 *
 * @author wmz
 * @since 2018-08-13
 */
@TableName("ad_player_program")
public class PlayerProgram extends BaseEntity<PlayerProgram> {

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
     * 节目ID
     */
    @TableField("program_id")
    private String programId;
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
     * 终端的节目状态 0-未下载 1-正在下载 2-下载完成 3-节目删除
     */
    @TableField("status")
    private Integer status;
    /**
     * 节目时长
     */
    @TableField("program_duration")
    private Integer programDuration;
    /**
     * 过期时间
     */
    @TableField("start_date")
    private Integer startDate;
    /**
     * 创建时间
     */
    @TableField("end_date")
    private Integer endDate;
    /**
     * 开始时段（0~24）
     */
    @TableField("start_time")
    private String startTime;
    /**
     * 结束时段（0~24）
     */
    @TableField("end_time")
    private String endTime;
    /**
     * 优先级
     */
    @TableField("priority")
    private Integer priority;
    /**
     * 节目大小
     */
    @TableField("size")
    private Long size;
    /**
     * 节目当前下载的大小
     */
    @TableField("download_size")
    private Long downloadSize;


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

    public String getProgramId() {
        return programId;
    }

    public PlayerProgram setProgramId(String programId) {
        this.programId = programId;
        return this;
    }

    public String getProgramName() {
        return programName;
    }

    public PlayerProgram setProgramName(String programName) {
        this.programName = programName;
        return this;
    }

    public String getResolution() {
        return resolution;
    }

    public PlayerProgram setResolution(String resolution) {
        this.resolution = resolution;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public PlayerProgram setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public Integer getProgramDuration() {
        return programDuration;
    }

    public PlayerProgram setProgramDuration(Integer programDuration) {
        this.programDuration = programDuration;
        return this;
    }

    public Integer getStartDate() {
        return startDate;
    }

    public PlayerProgram setStartDate(Integer startDate) {
        this.startDate = startDate;
        return this;
    }

    public Integer getEndDate() {
        return endDate;
    }

    public PlayerProgram setEndDate(Integer endDate) {
        this.endDate = endDate;
        return this;
    }

    public String getStartTime() {
        return startTime;
    }

    public PlayerProgram setStartTime(String startTime) {
        this.startTime = startTime;
        return this;
    }

    public String getEndTime() {
        return endTime;
    }

    public PlayerProgram setEndTime(String endTime) {
        this.endTime = endTime;
        return this;
    }

    public Integer getPriority() {
        return priority;
    }

    public PlayerProgram setPriority(Integer priority) {
        this.priority = priority;
        return this;
    }

    public Long getSize() {
        return size;
    }

    public PlayerProgram setSize(Long size) {
        this.size = size;
        return this;
    }

    public Long getDownloadSize() {
        return downloadSize;
    }

    public PlayerProgram setDownloadSize(Long downloadSize) {
        this.downloadSize = downloadSize;
        return this;
    }


    @Override
    public String toString() {
        return "PlayerProgram{" +
        "playerId=" + playerId +
        ", playerName=" + playerName +
        ", programId=" + programId +
        ", programName=" + programName +
        ", resolution=" + resolution +
        ", status=" + status +
        ", programDuration=" + programDuration +
        ", startDate=" + startDate +
        ", endDate=" + endDate +
        ", startTime=" + startTime +
        ", endTime=" + endTime +
        ", priority=" + priority +
        ", size=" + size +
        ", downloadSize=" + downloadSize +
        "}";
    }
}
