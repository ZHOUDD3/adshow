package com.adshow.ad.entity;

import java.io.Serializable;
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
 * @since 2018-08-11
 */
@TableName("ad_player")
public class Player extends BaseEntity<Player> {

    private static final long serialVersionUID = 1L;

    /**
     * 终端名称
     */
    @TableField("name")
    private String name;
    /**
     * 子网掩码
     */
    @TableField("subnet_mask")
    private String subnetMask;
    /**
     * 默认网关
     */
    @TableField("default_ipgateway")
    private String defaultIpgateway;
    /**
     * DNS服务器
     */
    @TableField("dns_server")
    private String dnsServer;
    /**
     * 是否注册
     */
    @TableField("is_register")
    private Integer isRegister;
    /**
     * 所属公司
     */
    @TableField("group_id")
    private String groupId;
    /**
     * 机器码
     */
    @TableField("machine_id")
    private String machineId;
    /**
     * 安全码
     */
    @TableField("security_id")
    private String securityId;
    /**
     * 终端状态
     */
    @TableField("statue")
    private String statue;
    /**
     * 状态改变时间
     */
    @TableField("statue_change_time")
    private Date statueChangeTime;
    /**
     * 在线时长
     */
    @TableField("online_time")
    private Integer onlineTime;
    /**
     * 屏幕宽度
     */
    @TableField("width")
    private Integer width;
    /**
     * 屏幕高度
     */
    @TableField("height")
    private Integer height;
    /**
     * 分辨率
     */
    @TableField("resolution")
    private String resolution;
    /**
     * 备注
     */
    @TableField("note")
    private String note;
    /**
     * MAC地址
     */
    @TableField("mac_ip")
    private String macIp;
    /**
     * 磁盘空间
     */
    @TableField("diskspace")
    private Long diskspace;
    /**
     * 终端对应城市ID
     */
    @TableField("city_id")
    private String cityId;
    /**
     * 终端对应城市名称
     */
    @TableField("city_name")
    private String cityName;
    /**
     * 终端版本
     */
    @TableField("soft_version")
    private String softVersion;
    /**
     * 经度
     */
    @TableField("longitude")
    private Double longitude;
    /**
     * 纬度
     */
    @TableField("latitude")
    private Double latitude;
    /**
     * 地址
     */
    @TableField("address")
    private String address;
    /**
     * 设备类型
     */
    @TableField("debice_type")
    private String debiceType;
    /**
     * 品牌
     */
    @TableField("device_brand")
    private String deviceBrand;
    /**
     * 系统版本
     */
    @TableField("os_version")
    private String osVersion;


    public String getName() {
        return name;
    }

    public Player setName(String name) {
        this.name = name;
        return this;
    }

    public String getSubnetMask() {
        return subnetMask;
    }

    public Player setSubnetMask(String subnetMask) {
        this.subnetMask = subnetMask;
        return this;
    }

    public String getDefaultIpgateway() {
        return defaultIpgateway;
    }

    public Player setDefaultIpgateway(String defaultIpgateway) {
        this.defaultIpgateway = defaultIpgateway;
        return this;
    }

    public String getDnsServer() {
        return dnsServer;
    }

    public Player setDnsServer(String dnsServer) {
        this.dnsServer = dnsServer;
        return this;
    }

    public Integer getIsRegister() {
        return isRegister;
    }

    public Player setIsRegister(Integer isRegister) {
        this.isRegister = isRegister;
        return this;
    }

    public String getGroupId() {
        return groupId;
    }

    public Player setGroupId(String groupId) {
        this.groupId = groupId;
        return this;
    }

    public String getMachineId() {
        return machineId;
    }

    public Player setMachineId(String machineId) {
        this.machineId = machineId;
        return this;
    }

    public String getSecurityId() {
        return securityId;
    }

    public Player setSecurityId(String securityId) {
        this.securityId = securityId;
        return this;
    }

    public String getStatue() {
        return statue;
    }

    public Player setStatue(String statue) {
        this.statue = statue;
        return this;
    }

    public Date getStatueChangeTime() {
        return statueChangeTime;
    }

    public Player setStatueChangeTime(Date statueChangeTime) {
        this.statueChangeTime = statueChangeTime;
        return this;
    }

    public Integer getOnlineTime() {
        return onlineTime;
    }

    public Player setOnlineTime(Integer onlineTime) {
        this.onlineTime = onlineTime;
        return this;
    }

    public Integer getWidth() {
        return width;
    }

    public Player setWidth(Integer width) {
        this.width = width;
        return this;
    }

    public Integer getHeight() {
        return height;
    }

    public Player setHeight(Integer height) {
        this.height = height;
        return this;
    }

    public String getResolution() {
        return resolution;
    }

    public Player setResolution(String resolution) {
        this.resolution = resolution;
        return this;
    }

    public String getNote() {
        return note;
    }

    public Player setNote(String note) {
        this.note = note;
        return this;
    }

    public String getMacIp() {
        return macIp;
    }

    public Player setMacIp(String macIp) {
        this.macIp = macIp;
        return this;
    }

    public Long getDiskspace() {
        return diskspace;
    }

    public Player setDiskspace(Long diskspace) {
        this.diskspace = diskspace;
        return this;
    }

    public String getCityId() {
        return cityId;
    }

    public Player setCityId(String cityId) {
        this.cityId = cityId;
        return this;
    }

    public String getCityName() {
        return cityName;
    }

    public Player setCityName(String cityName) {
        this.cityName = cityName;
        return this;
    }

    public String getSoftVersion() {
        return softVersion;
    }

    public Player setSoftVersion(String softVersion) {
        this.softVersion = softVersion;
        return this;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Player setLongitude(Double longitude) {
        this.longitude = longitude;
        return this;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Player setLatitude(Double latitude) {
        this.latitude = latitude;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Player setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getDebiceType() {
        return debiceType;
    }

    public Player setDebiceType(String debiceType) {
        this.debiceType = debiceType;
        return this;
    }

    public String getDeviceBrand() {
        return deviceBrand;
    }

    public Player setDeviceBrand(String deviceBrand) {
        this.deviceBrand = deviceBrand;
        return this;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public Player setOsVersion(String osVersion) {
        this.osVersion = osVersion;
        return this;
    }


    @Override
    public String toString() {
        return "Player{" +
        "name=" + name +
        ", subnetMask=" + subnetMask +
        ", defaultIpgateway=" + defaultIpgateway +
        ", dnsServer=" + dnsServer +
        ", isRegister=" + isRegister +
        ", groupId=" + groupId +
        ", machineId=" + machineId +
        ", securityId=" + securityId +
        ", statue=" + statue +
        ", statueChangeTime=" + statueChangeTime +
        ", onlineTime=" + onlineTime +
        ", width=" + width +
        ", height=" + height +
        ", resolution=" + resolution +
        ", note=" + note +
        ", macIp=" + macIp +
        ", diskspace=" + diskspace +
        ", cityId=" + cityId +
        ", cityName=" + cityName +
        ", softVersion=" + softVersion +
        ", longitude=" + longitude +
        ", latitude=" + latitude +
        ", address=" + address +
        ", debiceType=" + debiceType +
        ", deviceBrand=" + deviceBrand +
        ", osVersion=" + osVersion +
        "}";
    }
}
