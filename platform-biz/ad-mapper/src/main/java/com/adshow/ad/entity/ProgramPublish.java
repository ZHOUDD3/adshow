package com.adshow.ad.entity;

import java.util.Date;

import com.adshow.core.common.entity.BaseEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 
 * </p>
 *
 * @author wmz
 * @since 2018-10-09
 */
@TableName("ad_program_publish")
public class ProgramPublish extends BaseEntity<ProgramPublish> {

    private static final long serialVersionUID = 1L;

    /**
     * 发布单号
     */
    @TableField("publish_id")
    private String publishId;
    /**
     * 节目ID
     */
    @TableField("program_id")
    private String programId;
    /**
     * 素材名称
     */
    @TableField("program_name")
    private String programName;
    /**
     * 节目对应的素材ID
     */
    @TableField("player_ids")
    private String playerIds;
    /**
     * 结束日期
     */
    @TableField("end_date")
    private Integer endDate;
    /**
     * 所属机构
     */
    @TableField("group")
    private String group;
    /**
     * 审核是否通过
     */
    @TableField("passed")
    private boolean passed;
    /**
     * 审核意见
     */
    @TableField("note")
    private String note;




    public String getPublishId() {
        return publishId;
    }

    public ProgramPublish setPublishId(String publishId) {
        this.publishId = publishId;
        return this;
    }

    public String getProgramId() {
        return programId;
    }

    public ProgramPublish setProgramId(String programId) {
        this.programId = programId;
        return this;
    }

    public String getProgramName() {
        return programName;
    }

    public ProgramPublish setProgramName(String programName) {
        this.programName = programName;
        return this;
    }

    public String getPlayerIds() {
        return playerIds;
    }

    public ProgramPublish setPlayerIds(String playerIds) {
        this.playerIds = playerIds;
        return this;
    }

    public Integer getEndDate() {
        return endDate;
    }

    public ProgramPublish setEndDate(Integer endDate) {
        this.endDate = endDate;
        return this;
    }

    public String getGroup() {
        return group;
    }

    public ProgramPublish setGroup(String group) {
        this.group = group;
        return this;
    }


    @Override
    public String toString() {
        return "ProgramPublish{" +
        "publishId=" + publishId +
        ", programId=" + programId +
        ", programName=" + programName +
        ", playerIds=" + playerIds +
        ", endDate=" + endDate +
        ", group=" + group +
        "}";
    }

    public boolean getPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
