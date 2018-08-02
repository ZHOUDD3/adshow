package com.adshow.auth.entity;

import com.adshow.core.common.entity.BaseEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhaoxianbin@163.com
 * @since 2018-07-30
 */
@TableName("sys_permission")
public class Permission extends BaseEntity<Permission> {

    private static final long serialVersionUID = 1L;

    @TableField("del_flag")
    private Integer delFlag;
    @TableField("description")
    private String description;
    @TableField("name")
    private String name;
    @TableField("parent_id")
    private String parentId;
    @TableField("type")
    private Integer type;
    @TableField("sort_order")
    private BigDecimal sortOrder;
    @TableField("component")
    private String component;
    @TableField("path")
    private String path;
    @TableField("title")
    private String title;
    @TableField("icon")
    private String icon;
    @TableField("level")
    private Integer level;
    @TableField("button_type")
    private String buttonType;
    @TableField("status")
    private Integer status;

    @TableField(exist=false)
    @ApiModelProperty(value = "子菜单/权限")
    private List<Permission> children;

    @TableField(exist=false)
    @ApiModelProperty(value = "页面拥有的权限类型")
    private List<String> permTypes;

    @TableField(exist=false)
    @ApiModelProperty(value = "节点展开 前端所需")
    private Boolean expand = true;

    @TableField(exist=false)
    @ApiModelProperty(value = "是否勾选 前端所需")
    private Boolean checked = false;

    @TableField(exist=false)
    @ApiModelProperty(value = "是否选中 前端所需")
    private Boolean selected = false;

    public Integer getDelFlag() {
        return delFlag;
    }

    public Permission setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Permission setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getName() {
        return name;
    }

    public Permission setName(String name) {
        this.name = name;
        return this;
    }

    public String getParentId() {
        return parentId;
    }

    public Permission setParentId(String parentId) {
        this.parentId = parentId;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public Permission setType(Integer type) {
        this.type = type;
        return this;
    }

    public BigDecimal getSortOrder() {
        return sortOrder;
    }

    public Permission setSortOrder(BigDecimal sortOrder) {
        this.sortOrder = sortOrder;
        return this;
    }

    public String getComponent() {
        return component;
    }

    public Permission setComponent(String component) {
        this.component = component;
        return this;
    }

    public String getPath() {
        return path;
    }

    public Permission setPath(String path) {
        this.path = path;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Permission setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getIcon() {
        return icon;
    }

    public Permission setIcon(String icon) {
        this.icon = icon;
        return this;
    }

    public Integer getLevel() {
        return level;
    }

    public Permission setLevel(Integer level) {
        this.level = level;
        return this;
    }

    public String getButtonType() {
        return buttonType;
    }

    public Permission setButtonType(String buttonType) {
        this.buttonType = buttonType;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public Permission setStatus(Integer status) {
        this.status = status;
        return this;
    }


    public List<Permission> getChildren() {
        return children;
    }

    public void setChildren(List<Permission> children) {
        this.children = children;
    }

    public List<String> getPermTypes() {
        return permTypes;
    }

    public void setPermTypes(List<String> permTypes) {
        this.permTypes = permTypes;
    }

    public Boolean getExpand() {
        return expand;
    }

    public void setExpand(Boolean expand) {
        this.expand = expand;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    @Override
    public String toString() {
        return "Permission{" +
        "delFlag=" + delFlag +
        ", description=" + description +
        ", name=" + name +
        ", parentId=" + parentId +
        ", type=" + type +
        ", sortOrder=" + sortOrder +
        ", component=" + component +
        ", path=" + path +
        ", title=" + title +
        ", icon=" + icon +
        ", level=" + level +
        ", buttonType=" + buttonType +
        ", status=" + status +
        "}";
    }
}
