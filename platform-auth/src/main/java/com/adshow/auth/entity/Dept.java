package com.adshow.auth.entity;

import com.adshow.core.common.entity.BaseEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.math.BigDecimal;

/**
 *
 * @author zhaoxianbin@163.com
 * @since 2018-07-30
 */
@TableName("sys_dept")
public class Dept extends BaseEntity<Dept> {

    private static final long serialVersionUID = 1L;

    @TableField("name")
    private String name;

    @TableField("parent_id")
    private String parentId;

    @TableField("is_parent")
    private Boolean parent;

    @TableField("sort_order")
    private BigDecimal sortOrder;

    @TableField("status")
    private Integer status;

    @TableField(exist=false)
    private String parentName;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Boolean isParent() {
        return parent;
    }

    public void setParent(Boolean parent) {
        this.parent = parent;
    }

    public BigDecimal getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(BigDecimal sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }
}
