package com.adshow.auth.entity;

import com.adshow.core.common.entity.BaseEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 
 * </p>
 *
 * @author wmz
 * @since 2018-10-09
 */
@TableName("sys_user_player")
public class UserPlayer extends BaseEntity<UserPlayer> {

    private static final long serialVersionUID = 1L;

    @TableField("del_flag")
    private Integer delFlag;
    @TableField("player_id")
    private String playerId;
    @TableField("user_id")
    private String userId;


    public Integer getDelFlag() {
        return delFlag;
    }

    public UserPlayer setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    public String getPlayerId() {
        return playerId;
    }

    public UserPlayer setPlayerId(String playerId) {
        this.playerId = playerId;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public UserPlayer setUserId(String userId) {
        this.userId = userId;
        return this;
    }


    @Override
    public String toString() {
        return "UserPlayer{" +
        "delFlag=" + delFlag +
        ", playerId=" + playerId +
        ", userId=" + userId +
        "}";
    }
}
