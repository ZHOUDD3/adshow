package com.adshow.ad.param;

import com.adshow.ad.entity.Player;
import com.adshow.ad.entity.PlayerProgram;
import com.adshow.ad.entity.ProgramMaterial;
import com.adshow.ad.entity.Subtitle;
import com.adshow.core.common.entity.BaseEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhaoxianbin@163.com
 * @since 2018-08-03
 */
public class ProgramParam  {

    private static final long serialVersionUID = 1L;

    /**
     * 节目GUID
     */
    private String programId;
    /**
     * 节目名称
     */
    @TableField("name")
    private String name;
    /**
     * 节目类型 1-普通节目 2-直播节目
     */
    @TableField("type")
    private Integer type;
    /**
     * 节目时长
     */
    @TableField("program_duration")
    private Integer programDuration;
    /**
     * 节目分辨率
     */
    @TableField("resolution")
    private String resolution;
    /**
     * 节目描述
     */
    @TableField("program_description")
    private String programDescription;
    /**
     * 视频ids
     */
    @TableField("video_ids")
    private String videoIds;
    /**
     * 背景音乐ids
     */
    @TableField("music_ids")
    private String musicIds;
    /**
     * 字幕ids
     */
    @TableField("text_ids")
    private String textIds;
    /**
     * 天气是否显示
     */
    @TableField("weather")
    private String weather;
    /**
     * 日期是否显示
     */
    @TableField("date_show")
    private String dateShow;
    /**
     * 节目预览图
     */
    @TableField("previewImage")
    private String previewImage;
    /**
     * 模板图片
     */
    @TableField("template_image")
    private String templateImage;

    /**
     * 素材列表
     */
    private List<ProgramMaterial> materials;

    /**
     * 字幕列表
     */
    private List<Subtitle> subtitles;

    /**
     * 设备ids
     */
    private List<Player> playIds;

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
     * 结束时段（0~24）
     */

    public String getProgramId() {
        return programId;
    }

    public ProgramParam setProgramId(String programId) {
        this.programId = programId;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProgramParam setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public ProgramParam setType(Integer type) {
        this.type = type;
        return this;
    }

    public Integer getProgramDuration() {
        return programDuration;
    }

    public ProgramParam setProgramDuration(Integer programDuration) {
        this.programDuration = programDuration;
        return this;
    }

    public String getResolution() {
        return resolution;
    }

    public ProgramParam setResolution(String resolution) {
        this.resolution = resolution;
        return this;
    }

    public String getProgramDescription() {
        return programDescription;
    }

    public ProgramParam setProgramDescription(String programDescription) {
        this.programDescription = programDescription;
        return this;
    }

    public String getVideoIds() {
        return videoIds;
    }

    public ProgramParam setVideoIds(String videoIds) {
        this.videoIds = videoIds;
        return this;
    }

    public String getMusicIds() {
        return musicIds;
    }

    public ProgramParam setMusicIds(String musicIds) {
        this.musicIds = musicIds;
        return this;
    }

    public String getTextIds() {
        return textIds;
    }

    public ProgramParam setTextIds(String textIds) {
        this.textIds = textIds;
        return this;
    }

    public String getWeather() {
        return weather;
    }

    public ProgramParam setWeather(String weather) {
        this.weather = weather;
        return this;
    }

    public String getDateShow() {
        return dateShow;
    }

    public ProgramParam setDateShow(String dateShow) {
        this.dateShow = dateShow;
        return this;
    }

    public String getPreviewImage() {
        return previewImage;
    }

    public ProgramParam setPreviewImage(String previewImage) {
        this.previewImage = previewImage;
        return this;
    }

    public String getTemplateImage() {
        return templateImage;
    }

    public ProgramParam setTemplateImage(String templateImage) {
        this.templateImage = templateImage;
        return this;
    }

    @Override
    public String toString() {
        return "Program{" +
        "programId=" + programId +
        ", name=" + name +
        ", type=" + type +
        ", programDuration=" + programDuration +
        ", resolution=" + resolution +
        ", programDescription=" + programDescription +
        ", videoIds=" + videoIds +
        ", musicIds=" + musicIds +
        ", textIds=" + textIds +
        ", weather=" + weather +
        ", dateShow=" + dateShow +
        ", previewImage=" + previewImage +
        ", templateImage=" + templateImage +
        "}";
    }

    public List<ProgramMaterial> getMaterials() {
        return materials;
    }

    public void setMaterials(List<ProgramMaterial> materials) {
        this.materials = materials;
    }

    public List<Player> getPlayIds() {
        return playIds;
    }

    public void setPlayIds(List<Player> playIds) {
        this.playIds = playIds;
    }

    public Integer getStartDate() {
        return startDate;
    }

    public void setStartDate(Integer startDate) {
        this.startDate = startDate;
    }

    public Integer getEndDate() {
        return endDate;
    }

    public void setEndDate(Integer endDate) {
        this.endDate = endDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public List<Subtitle> getSubtitles() {
        return subtitles;
    }

    public void setSubtitles(List<Subtitle> subtitles) {
        this.subtitles = subtitles;
    }
}
