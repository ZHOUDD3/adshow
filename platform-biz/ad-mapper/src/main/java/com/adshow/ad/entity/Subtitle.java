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
@TableName("ad_subtitle")
public class Subtitle extends BaseEntity<Subtitle> {

    private static final long serialVersionUID = 1L;

    /**
     * 存储名称
     */
    @TableField("name")
    private String name;
    /**
     * 实际名称
     */
    @TableField("alias_name")
    private String aliasName;
    /**
     * 本地路径
     */
    @TableField("physical_path")
    private String physicalPath;
    /**
     * 视频大小
     */
    @TableField("size")
    private Long size;
    /**
     * 备注
     */
    @TableField("note")
    private String note;
    /**
     * 字幕内容
     */
    @TableField("content")
    private String content;
    /**
     * 字幕类型（1.静态字幕 2.滚动字幕）
     */
    @TableField("type")
    private Integer type;
    /**
     * 字体
     */
    @TableField("font")
    private String font;
    /**
     * 字体大小
     */
    @TableField("font_size")
    private Integer fontSize;
    /**
     * 字体颜色
     */
    @TableField("font_color")
    private String fontColor;
    /**
     * 字体背景颜色
     */
    @TableField("back_color")
    private String backColor;
    /**
     * 字体背景透明度
     */
    @TableField("back_transparency")
    private String backTransparency;
    /**
     * 滚动速度和类型（1.快 2.适中  3.慢）
     */
    @TableField("scroll_speed")
    private Integer scrollSpeed;


    public String getName() {
        return name;
    }

    public Subtitle setName(String name) {
        this.name = name;
        return this;
    }

    public String getAliasName() {
        return aliasName;
    }

    public Subtitle setAliasName(String aliasName) {
        this.aliasName = aliasName;
        return this;
    }

    public String getPhysicalPath() {
        return physicalPath;
    }

    public Subtitle setPhysicalPath(String physicalPath) {
        this.physicalPath = physicalPath;
        return this;
    }

    public Long getSize() {
        return size;
    }

    public Subtitle setSize(Long size) {
        this.size = size;
        return this;
    }

    public String getNote() {
        return note;
    }

    public Subtitle setNote(String note) {
        this.note = note;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Subtitle setContent(String content) {
        this.content = content;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public Subtitle setType(Integer type) {
        this.type = type;
        return this;
    }

    public String getFont() {
        return font;
    }

    public Subtitle setFont(String font) {
        this.font = font;
        return this;
    }

    public Integer getFontSize() {
        return fontSize;
    }

    public Subtitle setFontSize(Integer fontSize) {
        this.fontSize = fontSize;
        return this;
    }

    public String getFontColor() {
        return fontColor;
    }

    public Subtitle setFontColor(String fontColor) {
        this.fontColor = fontColor;
        return this;
    }

    public String getBackColor() {
        return backColor;
    }

    public Subtitle setBackColor(String backColor) {
        this.backColor = backColor;
        return this;
    }

    public String getBackTransparency() {
        return backTransparency;
    }

    public Subtitle setBackTransparency(String backTransparency) {
        this.backTransparency = backTransparency;
        return this;
    }

    public Integer getScrollSpeed() {
        return scrollSpeed;
    }

    public Subtitle setScrollSpeed(Integer scrollSpeed) {
        this.scrollSpeed = scrollSpeed;
        return this;
    }

    @Override
    public String toString() {
        return "Subtitle{" +
        "name=" + name +
        ", aliasName=" + aliasName +
        ", physicalPath=" + physicalPath +
        ", size=" + size +
        ", note=" + note +
        ", content=" + content +
        ", type=" + type +
        ", font=" + font +
        ", fontSize=" + fontSize +
        ", fontColor=" + fontColor +
        ", backColor=" + backColor +
        ", backTransparency=" + backTransparency +
        ", scrollSpeed=" + scrollSpeed +
        "}";
    }
}
