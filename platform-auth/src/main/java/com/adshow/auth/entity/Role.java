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
@TableName("sys_role")
public class Role extends BaseEntity<Role> {

    private static final long serialVersionUID = 1L;

    @TableField("name")
    private String name;
    @TableField("del_flag")
    private Integer delFlag;
    @TableField("default_role")
    private Boolean defaultRole;

    @TableField(exist=false)
    @ApiModelProperty(value = "角色拥有的权限")
    private List<Permission> permissions;

    public String getName() {
        return name;
    }

    public Role setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public Role setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    public Boolean getDefaultRole() {
        return defaultRole;
    }

    public Role setDefaultRole(Boolean defaultRole) {
        this.defaultRole = defaultRole;
        return this;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "Role{" +
        "name=" + name +
        ", delFlag=" + delFlag +
        ", defaultRole=" + defaultRole +
        "}";
    }
}
