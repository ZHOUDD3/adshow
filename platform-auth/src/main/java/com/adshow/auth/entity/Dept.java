package com.adshow.auth.entity;

import com.adshow.core.common.entity.BaseEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * 部门表
 * </p>
 *
 * @author zhaoxianbin@163.com
 * @since 2018-07-30
 */
@TableName("sys_dept")
public class Dept extends BaseEntity<Dept> {

    private static final long serialVersionUID = 1L;

    /**
     * 排序
     */
    @TableField("num")
    private Integer num;
    /**
     * 父部门id
     */
    @TableField("pid")
    private Integer pid;
    /**
     * 父级ids
     */
    @TableField("pids")
    private String pids;
    /**
     * 简称
     */
    @TableField("simplename")
    private String simplename;
    /**
     * 全称
     */
    @TableField("fullname")
    private String fullname;
    /**
     * 提示
     */
    @TableField("tips")
    private String tips;


    public Integer getNum() {
        return num;
    }

    public Dept setNum(Integer num) {
        this.num = num;
        return this;
    }

    public Integer getPid() {
        return pid;
    }

    public Dept setPid(Integer pid) {
        this.pid = pid;
        return this;
    }

    public String getPids() {
        return pids;
    }

    public Dept setPids(String pids) {
        this.pids = pids;
        return this;
    }

    public String getSimplename() {
        return simplename;
    }

    public Dept setSimplename(String simplename) {
        this.simplename = simplename;
        return this;
    }

    public String getFullname() {
        return fullname;
    }

    public Dept setFullname(String fullname) {
        this.fullname = fullname;
        return this;
    }

    public String getTips() {
        return tips;
    }

    public Dept setTips(String tips) {
        this.tips = tips;
        return this;
    }


    @Override
    public String toString() {
        return "Dept{" +
        "num=" + num +
        ", pid=" + pid +
        ", pids=" + pids +
        ", simplename=" + simplename +
        ", fullname=" + fullname +
        ", tips=" + tips +
        "}";
    }
}
