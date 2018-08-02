package com.adshow.auth.entity;

import com.adshow.core.common.entity.BaseEntity;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.util.Map;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhaoxianbin@163.com
 * @since 2018-07-30
 */
@TableName("sys_log")
public class Log extends BaseEntity<Log> {

    private static final long serialVersionUID = 1L;

    @TableField("del_flag")
    private Integer delFlag;
    @TableField("cost_time")
    private Integer costTime;
    @TableField("ip")
    private String ip;
    @TableField("ip_info")
    private String ipInfo;
    @TableField("name")
    private String name;
    @TableField("request_param")
    private String requestParam;
    @TableField("request_type")
    private String requestType;
    @TableField("request_url")
    private String requestUrl;
    @TableField("username")
    private String username;

    public Integer getDelFlag() {
        return delFlag;
    }

    public Log setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    public Integer getCostTime() {
        return costTime;
    }

    public Log setCostTime(Integer costTime) {
        this.costTime = costTime;
        return this;
    }

    public String getIp() {
        return ip;
    }

    public Log setIp(String ip) {
        this.ip = ip;
        return this;
    }

    public String getIpInfo() {
        return ipInfo;
    }

    public Log setIpInfo(String ipInfo) {
        this.ipInfo = ipInfo;
        return this;
    }

    public String getName() {
        return name;
    }

    public Log setName(String name) {
        this.name = name;
        return this;
    }

    public String getRequestParam() {
        return requestParam;
    }

    public Log setRequestParam(String requestParam) {
        this.requestParam = requestParam;
        return this;
    }

    public String getRequestType() {
        return requestType;
    }

    public Log setRequestType(String requestType) {
        this.requestType = requestType;
        return this;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public Log setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public Log setUsername(String username) {
        this.username = username;
        return this;
    }

    /**
     * 转换请求参数为Json
     * @param paramMap
     */
    public void setMapToParams(Map<String, String[]> paramMap) {

        this.requestParam = JSON.toJSONString(paramMap);
    }

    @Override
    public String toString() {
        return "Log{" +
        "delFlag=" + delFlag +
        ", costTime=" + costTime +
        ", ip=" + ip +
        ", ipInfo=" + ipInfo +
        ", name=" + name +
        ", requestParam=" + requestParam +
        ", requestType=" + requestType +
        ", requestUrl=" + requestUrl +
        ", username=" + username +
        "}";
    }
}
