package com.adshow.auth.entity;

import com.adshow.core.common.entity.BaseEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.Version;

/**
 * <p>
 * 
 * </p>
 *
 * @author wmz
 * @since 2018-08-13
 */
@TableName("sys_user_resource")
public class UserResource extends BaseEntity<UserResource> {

    private static final long serialVersionUID = 1L;

    @TableField("del_flag")
    private Integer delFlag;
    @TableField("resource_id")
    private String resourceId;
    @TableField("user_id")
    private String userId;


    public Integer getDelFlag() {
        return delFlag;
    }

    public UserResource setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    public String getResourceId() {
        return resourceId;
    }

    public UserResource setResourceId(String resourceId) {
        this.resourceId = resourceId;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public UserResource setUserId(String userId) {
        this.userId = userId;
        return this;
    }


    @Override
    public String toString() {
        return "UserResource{" +
        "delFlag=" + delFlag +
        ", resourceId=" + resourceId +
        ", userId=" + userId +
        "}";
    }
}
