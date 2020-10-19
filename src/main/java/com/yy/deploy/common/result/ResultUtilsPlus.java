//package com.yy.deploy.common.result;
//
//import com.fiberhome.filink.bean.PageBean;
//import com.fiberhome.filink.bean.ResultCodePlus;
//import com.fiberhome.filink.bean.ResultPlus;
//
//import java.util.Map;
//
///**
// * 返回工具类升级版 错误码由int类型修改为string
// *
// * @author yuanyao@wistronits.com
// * create on 2018/12/19 17:09
// */
//public class ResultUtilsPlus {
//
//    /**
//     * ResultPlusUtils
//     *
//     * @param msgKey     消息key
//     * @param contextMap 上下文
//     * @param data       data
//     * @return ResultPlusCode
//     */
//    public static ResultPlus<Object> success(String msgKey, Map contextMap, Object data) {
//        String msg = I18nUtils.getString(msgKey, contextMap);
//        return new ResultPlus<>(ResultCodePlus.SUCCESS, msg, data);
//    }
//
//    /**
//     * success
//     *
//     * @param data data
//     * @return ResultPlus
//     */
//    public static ResultPlus success(Object data) {
//        String msg = I18nUtils.getSystemString(ResultCodePlus.SUCCESS);
//        return new ResultPlus(ResultCodePlus.SUCCESS, msg, data);
//    }
//
//    /**
//     * success
//     *
//     * @param msgKey 消息key
//     * @param data   data
//     * @return ResultPlus
//     */
//    public static ResultPlus<Object> success(String msgKey, Object data) {
//        return success(msgKey, null, data);
//    }
//
//    /**
//     * success
//     *
//     * @return ResultPlus
//     */
//    public static ResultPlus success() {
//        return success(null);
//    }
//
//    /**
//     * 分页
//     *
//     * @param pageBean 分页
//     * @return ResultPlus
//     */
//    public static ResultPlus pageSuccess(PageBean pageBean) {
//        ResultPlus resultPlus = success();
//        resultPlus.setData(pageBean.getData());
//        resultPlus.setPageNum(pageBean.getPageNum());
//        resultPlus.setSize(pageBean.getSize());
//        resultPlus.setTotalCount(pageBean.getTotalCount());
//        resultPlus.setTotalPage(pageBean.getTotalPage());
//        return resultPlus;
//    }
//
//
//    /**
//     * success
//     *
//     * @param successCode successCode
//     * @param msg         msg
//     * @return ResultPlus
//     */
//    @Deprecated
//    public static ResultPlus success(String successCode, String msg) {
//        return new ResultPlus<>(successCode, msg, null);
//    }
//
//
//    /**
//     * warn
//     * @see ResultUtilsPlus#warn(String)
//     *
//     * @param ResultPlusCode ResultPlusCode
//     * @param msg            msg
//     * @return ResultPlus
//     */
//    @Deprecated
//    public static ResultPlus warn(String ResultPlusCode, String msg) {
//        return new ResultPlus<>(ResultPlusCode, msg, null);
//    }
//
//    /**
//     * warn
//     *
//     * @param ResultPlusCode ResultPlusCode
//     * @return ResultPlus
//     */
//    public static ResultPlus warn(String ResultPlusCode) {
//        String systemString = I18nUtils.getSystemString(ResultPlusCode);
//        return new ResultPlus(ResultPlusCode, systemString, null);
//    }
//
//    /**
//     * warn
//     *
//     * @param ResultPlusCode ResultPlusCode
//     * @param contextMap     上下文填充数据
//     * @return ResultPlus
//     */
//    public static ResultPlus warn(String ResultPlusCode, Map contextMap) {
//        String systemString = I18nUtils.getString(ResultPlusCode, contextMap);
//        return new ResultPlus(ResultPlusCode, systemString, null);
//    }
//
//}
