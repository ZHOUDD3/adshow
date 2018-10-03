package com.adshow.ad.entity;

import com.adshow.core.common.entity.BaseEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author wmz
 * @since 2018-10-03
 */
@TableName("ad_subtitle")
public class Subtitle extends BaseEntity<Subtitle> {

    private static final long serialVersionUID = 1L;

    /**
     * 节目ID
     */
    @TableField("program_id")
    private String programId;
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
     * 字幕背景颜色
     */
    @TableField("back_color")
    private String backColor;
    /**
     * 字体背景透明度
     */
    @TableField("back_transparency")
    private Integer backTransparency;
    /**
     * 滚动速度和类型（1.快 2.适中  3.慢）
     */
    @TableField("scroll_speed")
    private Integer scrollSpeed;
    /**
     * 素材在节目中的位置x（%）
     */
    @TableField("position_x")
    private Integer positionX;
    /**
     * 素材在节目中的位置y（%）
     */
    @TableField("position_y")
    private Integer positionY;
    /**
     * 素材在节目中的宽度（%）
     */
    @TableField("width")
    private Integer width;
    /**
     * 素材在节目中的高度（%）
     */
    @TableField("height")
    private Integer height;
    /**
     * 素材在节目中的图层顺序
     */
    @TableField("load_oder")
    private Integer loadOder;


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

    public Integer getBackTransparency() {
        return backTransparency;
    }

    public Subtitle setBackTransparency(Integer backTransparency) {
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

    public Integer getPositionX() {
        return positionX;
    }

    public Subtitle setPositionX(Integer positionX) {
        this.positionX = positionX;
        return this;
    }

    public Integer getPositionY() {
        return positionY;
    }

    public Subtitle setPositionY(Integer positionY) {
        this.positionY = positionY;
        return this;
    }

    public Integer getWidth() {
        return width;
    }

    public Subtitle setWidth(Integer width) {
        this.width = width;
        return this;
    }

    public Integer getHeight() {
        return height;
    }

    public Subtitle setHeight(Integer height) {
        this.height = height;
        return this;
    }

    public Integer getLoadOder() {
        return loadOder;
    }

    public Subtitle setLoadOder(Integer loadOder) {
        this.loadOder = loadOder;
        return this;
    }


    @Override
    public String toString() {
        return "Subtitle{" +
                "content=" + content +
                ", type=" + type +
                ", font=" + font +
                ", fontSize=" + fontSize +
                ", fontColor=" + fontColor +
                ", backColor=" + backColor +
                ", backTransparency=" + backTransparency +
                ", scrollSpeed=" + scrollSpeed +
                ", positionX=" + positionX +
                ", positionY=" + positionY +
                ", width=" + width +
                ", height=" + height +
                ", loadOder=" + loadOder +
                "}";
    }

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }
}
