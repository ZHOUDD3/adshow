package com.adshow.auth.entity;

import com.adshow.core.common.entity.BaseEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModelProperty;

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
    @TableField("email")
    private String email;
    @TableField("mobile")
    private String mobile;
    @TableField("nick_name")
    private String nickName;
    @TableField("password")
    private String password;
    @TableField("sex")
    private Integer sex;
    @TableField("status")
    private Integer status;
    @TableField("type")
    private Integer type;
    @TableField("username")
    private String username;
    @TableField("del_flag")
    private Integer delFlag;

    @TableField(exist=false)
    @ApiModelProperty(value = "用户拥有角色")
    private List<Role> roles;

    @TableField(exist=false)
    @ApiModelProperty(value = "用户拥有的权限")
    private List<Permission> permissions;

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
}
