package com.adshow.mapper.entity;

import java.io.Serializable;

/**
 * ad_subtitle_manage
 * @author 
 */
public class SubtitleManage implements Serializable {

    /**
     * 字幕内容
     */
    private String content;

    /**
     * 字幕类型（1.静态字幕 2.滚动字幕）
     */
    private Integer type;

    /**
     * 字体
     */
    private String font;

    /**
     * 字体大小
     */
    private Integer fontSize;

    /**
     * 字体颜色
     */
    private String fontColor;

    /**
     * 字体背景颜色
     */
    private String backColor;

    /**
     * 字体背景透明度
     */
    private String backTransparency;

    /**
     * 滚动速度和类型（1.快 2.适中  3.慢）
     */
    private Integer scrollSpeed;

    private static final long serialVersionUID = 1L;


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getFont() {
        return font;
    }

    public void setFont(String font) {
        this.font = font;
    }

    public Integer getFontSize() {
        return fontSize;
    }

    public void setFontSize(Integer fontSize) {
        this.fontSize = fontSize;
    }

    public String getFontColor() {
        return fontColor;
    }

    public void setFontColor(String fontColor) {
        this.fontColor = fontColor;
    }

    public String getBackColor() {
        return backColor;
    }

    public void setBackColor(String backColor) {
        this.backColor = backColor;
    }

    public String getBackTransparency() {
        return backTransparency;
    }

    public void setBackTransparency(String backTransparency) {
        this.backTransparency = backTransparency;
    }

    public Integer getScrollSpeed() {
        return scrollSpeed;
    }

    public void setScrollSpeed(Integer scrollSpeed) {
        this.scrollSpeed = scrollSpeed;
    }

}