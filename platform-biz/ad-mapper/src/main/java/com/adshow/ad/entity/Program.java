package com.adshow.ad.entity;

import com.adshow.core.common.entity.BaseEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhaoxianbin@163.com
 * @since 2018-08-03
 */
@TableName("ad_program")
public class Program extends BaseEntity<Program> {

    private static final long serialVersionUID = 1L;

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



    public String getName() {
        return name;
    }

    public Program setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public Program setType(Integer type) {
        this.type = type;
        return this;
    }

    public Integer getProgramDuration() {
        return programDuration;
    }

    public Program setProgramDuration(Integer programDuration) {
        this.programDuration = programDuration;
        return this;
    }

    public String getResolution() {
        return resolution;
    }

    public Program setResolution(String resolution) {
        this.resolution = resolution;
        return this;
    }

    public String getProgramDescription() {
        return programDescription;
    }

    public Program setProgramDescription(String programDescription) {
        this.programDescription = programDescription;
        return this;
    }

    public String getVideoIds() {
        return videoIds;
    }

    public Program setVideoIds(String videoIds) {
        this.videoIds = videoIds;
        return this;
    }

    public String getMusicIds() {
        return musicIds;
    }

    public Program setMusicIds(String musicIds) {
        this.musicIds = musicIds;
        return this;
    }

    public String getTextIds() {
        return textIds;
    }

    public Program setTextIds(String textIds) {
        this.textIds = textIds;
        return this;
    }

    public String getWeather() {
        return weather;
    }

    public Program setWeather(String weather) {
        this.weather = weather;
        return this;
    }

    public String getDateShow() {
        return dateShow;
    }

    public Program setDateShow(String dateShow) {
        this.dateShow = dateShow;
        return this;
    }

    public String getPreviewImage() {
        return previewImage;
    }

    public Program setPreviewImage(String previewImage) {
        this.previewImage = previewImage;
        return this;
    }

    public String getTemplateImage() {
        return templateImage;
    }

    public Program setTemplateImage(String templateImage) {
        this.templateImage = templateImage;
        return this;
    }

    @Override
    public String toString() {
        return "Program{" +
        "programId="  +
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
}
