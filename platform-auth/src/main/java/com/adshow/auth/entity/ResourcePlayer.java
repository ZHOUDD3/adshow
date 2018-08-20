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
@TableName("sys_resource_player")
public class ResourcePlayer extends BaseEntity<ResourcePlayer> {

    private static final long serialVersionUID = 1L;

    @TableField("del_flag")
    private Integer delFlag;
    @TableField("player_id")
    private String playerId;
    @TableField("resource_id")
    private String resourceId;


    public Integer getDelFlag() {
        return delFlag;
    }

    public ResourcePlayer setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    public String getPlayerId() {
        return playerId;
    }

    public ResourcePlayer setPlayerId(String playerId) {
        this.playerId = playerId;
        return this;
    }

    public String getResourceId() {
        return resourceId;
    }

    public ResourcePlayer setResourceId(String resourceId) {
        this.resourceId = resourceId;
        return this;
    }


    @Override
    public String toString() {
        return "ResourcePlayer{" +
        "delFlag=" + delFlag +
        ", playerId=" + playerId +
        ", resourceId=" + resourceId +
        "}";
    }
}
