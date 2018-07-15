package com.adshow.entity;

import java.util.List;

public class ResultInfo<T>   {

    /**
     * 是否成功
     */
    private boolean success ;
    /**
     * 返回数据
     */
    private List<T> data;

    /**
     * 结果信息编号，对应字典
     */
    private String resultCode;

    /**
     * 返回的消息
     */
    private String resultMsg;

    /**
     * 返回值，类型为T
     */
    private T t;

    public ResultInfo() {
        this.success = true;
    }

    public ResultInfo(boolean success) {
        this.success = success;
    }

    /**
     * 是否成功
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * 设置是否成功
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * 结果信息编号，对应字典
     */
    public String getResultCode() {
        return resultCode;
    }

    /**
     * 结果信息编号，对应字典
     */
    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    /**
     * 返回的消息
     */
    public String getResultMsg() {
        return resultMsg;
    }

    /**
     * 返回的消息
     */
    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    /**
     * 返回值，类型为T
     */
    public T getT() {
        return t;
    }

    /**
     * 返回值，类型为T
     */
    public void setT(T t) {
        this.t = t;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResultInfo that = (ResultInfo) o;

        if (success != that.success) return false;
        if (resultCode != null ? !resultCode.equals(that.resultCode) : that.resultCode != null) return false;
        if (t != null ? !t.equals(that.t) : that.t != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (success ? 1 : 0);
        result = 31 * result + (resultCode != null ? resultCode.hashCode() : 0);
        result = 31 * result + (t != null ? t.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RemoteResult{" +
                "resultCode='" + resultCode + '\'' +
                ", success=" + success +
                ", t=" + t +
                '}';
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}