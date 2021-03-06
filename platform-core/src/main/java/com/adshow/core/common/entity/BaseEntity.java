package com.adshow.core.common.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;

public abstract class BaseEntity<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId("id")
    private String id;

    /**
     * 创建者ID
     */
    @TableId("create_user")
    private Integer createUser;


    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableId("create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableId("update_time")
    private Date updateTime;

    /**
     * 更新者ID
     */
    @TableId("update_user")
    private Integer updateUser;

    /**
     * 保留字段
     */
    @TableId("version")
    private Integer version;

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    protected Serializable getPrimaryKeyValue() {
        return this.id;
    }

    public boolean isEmpty() {
        Field fields[] = this.getClass().getDeclaredFields();
        try {
            for (Field f : fields) {
                f.setAccessible(true);
                if (f.get(this) != null) {
                    return false;
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return true;
    }

}