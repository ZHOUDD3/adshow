package com.adshow.auth.entity;

import com.adshow.core.common.entity.BaseEntity;
import com.adshow.mybatis.annotations.QueryCondition;
import com.adshow.mybatis.annotations.QueryTypeEnum;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author zhaoxianbin@163.com
 * @since 2018-07-30
 */
@TableName("sys_user")
public class User extends BaseEntity<User> {

    private static final long serialVersionUID = 1L;

    @TableField("address")
    private String address;
    @TableField("avatar")
    private String avatar;
    @TableField("description")
    private String description;
    @QueryCondition(column = "email", value = QueryTypeEnum.LIKE)
    @TableField("email")
    private String email;
    @QueryCondition(column = "mobile", value = QueryTypeEnum.LIKE)
    @TableField("mobile")
    private String mobile;
    @TableField("nick_name")
    private String nickName;
    @TableField("password")
    private String password;
    @QueryCondition(column = "sex", value = QueryTypeEnum.EQ)
    @TableField("sex")
    private Integer sex;
    @QueryCondition(column = "status", value = QueryTypeEnum.EQ)
    @TableField("status")
    private Integer status;
    @QueryCondition(column = "type", value = QueryTypeEnum.EQ)
    @TableField("type")
    private Integer type;
    @QueryCondition(column = "username", value = QueryTypeEnum.LIKE)
    @TableField("username")
    private String username;
    @TableField("del_flag")
    private Integer delFlag;
    @TableField("role_id")
    private Integer roleId;
    @TableField("group_id")
    private Integer groupId;

    @TableField(exist=false)
    @ApiModelProperty(value = "用户拥有角色")
    private List<Role> roles;

    @TableField(exist=false)
    @ApiModelProperty(value = "用户拥有的权限")
    private List<Permission> permissions;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @QueryCondition(column = "create_time", value = QueryTypeEnum.GE)
    @TableField(exist=false)
    private Date createTimeStart;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @QueryCondition(column = "create_time", value = QueryTypeEnum.LE)
    @TableField(exist=false)
    private Date createTimeEnd;

    public Date getCreateTimeStart() {
        return createTimeStart;
    }

    public void setCreateTimeStart(Date createTimeStart) {
        this.createTimeStart = createTimeStart;
    }

    public Date getCreateTimeEnd() {
        return createTimeEnd;
    }

    public void setCreateTimeEnd(Date createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
    }

    public String getAddress() {
        return address;
    }

    public User setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getAvatar() {
        return avatar;
    }

    public User setAvatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public User setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public User setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getNickName() {
        return nickName;
    }

    public User setNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public Integer getSex() {
        return sex;
    }

    public User setSex(Integer sex) {
        this.sex = sex;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public User setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public User setType(Integer type) {
        this.type = type;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public User setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "User{" +
                "address=" + address +
                ", avatar=" + avatar +
                ", description=" + description +
                ", email=" + email +
                ", mobile=" + mobile +
                ", nickName=" + nickName +
                ", password=" + password +
                ", sex=" + sex +
                ", status=" + status +
                ", type=" + type +
                ", username=" + username +
                ", delFlag=" + delFlag +
                "}";
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }
}
