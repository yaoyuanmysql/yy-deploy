package com.yy.deploy.common.result;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 返回结果封装 二期升级版
 * 错误码由数字修改为字符串
 *
 * @author yuanyao@wistronits.com
 * create on 2018/12/19 17:09
 */
public class Result<T> {

    private String code;
    private String msg;
    @JsonInclude(value= JsonInclude.Include.NON_NULL)
    private T data;
    @JsonInclude(value= JsonInclude.Include.NON_NULL)
    private Integer pageNum;

    /*** 总页数*/
    @JsonInclude(value= JsonInclude.Include.NON_NULL)
    private Integer totalPage;

    /*** 总记录数*/
    @JsonInclude(value= JsonInclude.Include.NON_NULL)
    private Integer totalCount;

    /*** 每页显示记录数*/
    @JsonInclude(value= JsonInclude.Include.NON_NULL)
    private Integer size;

    /**
     * Result
     */
    public Result() {
    }

    /**
     * Result
     * @param resultCode resultCode
     * @param data data
     */
    public Result(String resultCode, T data) {
        this(resultCode);
        this.data = data;
    }

    /**
     * Result
     * @param resultCode resultCode
     * @param data data
     * @param msg 消息
     */
    public Result(String resultCode, String msg, T data) {
        this(resultCode);
        this.msg = msg;
        this.data = data;
    }

    /**
     * Result
     * @param resultCode resultCode
     */
    public Result(String resultCode) {
        this.code = resultCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
