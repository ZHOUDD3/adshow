package com.adshow.auth.entity;

import com.adshow.core.common.entity.BaseEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhaoxianbin@163.com
 * @since 2018-07-30
 */
@TableName("sys_role_permission")
public class RolePermission extends BaseEntity<RolePermission> {

    private static final long serialVersionUID = 1L;

    @TableField("del_flag")
    private Integer delFlag;
    @TableField("permission_id")
    private String permissionId;
    @TableField("role_id")
    private String roleId;


    public Integer getDelFlag() {
        return delFlag;
    }

    public RolePermission setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
        return this;
    }


    public String getPermissionId() {
        return permissionId;
    }

    public RolePermission setPermissionId(String permissionId) {
        this.permissionId = permissionId;
        return this;
    }

    public String getRoleId() {
        return roleId;
    }

    public RolePermission setRoleId(String roleId) {
        this.roleId = roleId;
        return this;
    }

    @Override
    public String toString() {
        return "RolePermission{" +
        "delFlag=" + delFlag +
        ", permissionId=" + permissionId +
        ", roleId=" + roleId +
        "}";
    }
}
