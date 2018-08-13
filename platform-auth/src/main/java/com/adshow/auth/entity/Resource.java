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
@TableName("sys_resource")
public class Resource extends BaseEntity<Resource> {

    private static final long serialVersionUID = 1L;

    @TableField("name")
    private String name;
    @TableField("del_flag")
    private Integer delFlag;
    @TableField("default_role")
    private Boolean defaultRole;


    public String getName() {
        return name;
    }

    public Resource setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public Resource setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    public Boolean getDefaultRole() {
        return defaultRole;
    }

    public Resource setDefaultRole(Boolean defaultRole) {
        this.defaultRole = defaultRole;
        return this;
    }


    @Override
    public String toString() {
        return "Resource{" +
        "name=" + name +
        ", delFlag=" + delFlag +
        ", defaultRole=" + defaultRole +
        "}";
    }
}
