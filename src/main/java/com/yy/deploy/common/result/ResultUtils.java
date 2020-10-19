package com.yy.deploy.common.result;

import com.yy.deploy.common.query.PageBean;

/**
 * 返回工具类
 *
 * @author yuanyao@wistronits.com
 * create on 2018/12/19 17:09
 * @see ResultUtils
 */
public class ResultUtils {

    /**
     * ResultUtils
     *
     * @param resultCode resultCode
     * @param msg        msg
     * @param data       data
     * @return resultCode
     */
    public static Result success(String resultCode, String msg, Object data) {
        Result<Object> result = new Result<>();
        result.setCode(resultCode);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    /**
     * 分页
     * @param pageBean 分页
     * @return  result
     */
    public static Result pageSuccess(PageBean pageBean) {
        Result<Object> result = new Result<>();
        result.setCode(ResultCode.SUCCESS);
        result.setMsg("请求成功");
        // TODO: 2019/1/7  是否需要校验？
        result.setData(pageBean.getData());
        result.setPageNum(pageBean.getPageNum());
        result.setSize(pageBean.getSize());
        result.setTotalCount(pageBean.getTotalCount());
        result.setTotalPage(pageBean.getTotalPage());
        return result;
    }

    /**
     * success
     *
     * @param data data
     * @return Result
     */
    public static Result success(Object data) {
        return new Result<>(ResultCode.SUCCESS, "请求成功", data);
    }

    /**
     * success
     *
     * @param msg msg
     * @return Result
     */
    public static Result success(String successCode, String msg) {
        return new Result<>(successCode, msg, null);
    }

    /**
     * success
     *
     * @return Result
     */
    public static Result success() {
        return new Result<>(ResultCode.SUCCESS, "请求成功",null);
    }

    /**
     * warn
     *
     * @param resultCode resultCode
     * @param msg        msg
     * @return Result
     */
    public static Result warn(String resultCode, String msg) {
        Result<Object> result = new Result<>(resultCode);
        result.setMsg(msg);
        return result;
    }

    /**
     * warn
     *
     * @param resultCode resultCode
     * @return Result
     */
    public static Result warn(String resultCode) {
        return new Result(resultCode);
    }

}
