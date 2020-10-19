//package com.yy.deploy.common.result;
//
//import com.alibaba.druid.util.StringUtils;
//import lombok.Getter;
//import lombok.extern.slf4j.Slf4j;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Locale;
//import java.util.Map;
//import java.util.ResourceBundle;
//
///**
// * 国际化工具类
// *
// * @author yuanyao@wistronits.com
// * create on 2019/1/3 10:42
// */
//@Slf4j
//@Getter
//public class I18nUtils {
//
//    private static final String REOURCES_PATH = "i18n/resource";
//
//    private static final String COMMON_REOURCES_PATH = "i18n/common/resource";
//
//    private static List<String> msgResources = Arrays.asList(REOURCES_PATH, COMMON_REOURCES_PATH);
//
//    /**
//     * 获取配置文件中指定key和指定环境中的数据
//     * 如果不传语言环境 则读取默认配置中的数据
//     *
//     * @param environment 语言
//     * @param key         key
//     * @return 值
//     */
//    public static String getString(String environment, String key) {
//        Locale locale = getLocale(environment);
//        return getMessage(key, null, locale);
//    }
//
//    /**
//     * 获取配置文件中指定key和指定环境中的数据
//     * 如果不传语言环境 则读取默认配置中的数据
//     *
//     * @param key        key
//     * @param contextMap 上下文
//     * @return 值
//     */
//    public static String getString(String key, Map contextMap) {
//        String environment = RequestInfoUtils.getLanguage();
//        Locale locale = getLocale(environment);
//        return getMessage(key, contextMap, locale);
//    }
//
//    public static Locale getLocale(String environment) {
//        Locale locale;
//        if (StringUtils.equalsIgnoreCase(environment, "cn")) {
//            locale = Locale.CHINA;
//        } else if (StringUtils.equalsIgnoreCase(environment, "us")) {
//            locale = Locale.US;
//        } else {
//            locale = Locale.CHINA;
//        }
//        return locale;
//    }
//
//
//    public static String getMessage(String msgKey, Map mapParams, Locale locale) {
//        if (StringUtils.isEmpty(msgKey)) {
//            return "";
//        }
//        if (null == locale) {
//            locale = getLocale(null);
//        }
//        String resultMsg = msgKey;
//        for (String msgResource : msgResources) {
//            ResourceBundle bundle = ResourceBundle.getBundle(msgResource, locale);
//            String result = null;
//            try {
//                result = bundle.getString(msgKey);
//            } catch (Exception e) {
//                log.debug("Resource is not found for " + msgKey + " in " + msgResource);
//            }
//            if (StringUtils.isNotBlank(result)) {
//                resultMsg = result;
//                break;
//            }
//        }
//        return StringUtil.replaceParams(resultMsg, mapParams);
//
//
//    }
//
//    /**
//     * 获取配置文件中指定key和指定环境中的数据
//     * 如果不传语言环境 则读取默认配置中的数据
//     *
//     * @param key key
//     * @return 值
//     */
//    public static String getSystemString(String key) {
//        String environment = RequestInfoUtils.getLanguage();
//        Locale locale = getLocale(environment);
//        return getMessage(key, null, locale);
//    }
//
////    public static Integer getInteger(String key) {
////        Locale locale = getLocal();
////        if (locale == null) {
////            String string = ResourceBundle.getBundle(REOURCES_PATH).getString(key);
////            try {
////                int i = Integer.parseInt(string);
////                return i;
////            } catch (Exception e) {
////                log.info("获取配置Sting转int失败");
////            }
////            return null;
////        }else {
////            String string = ResourceBundle.getBundle(REOURCES_PATH, locale).getString(key);
////            try {
////                int i = Integer.parseInt(string);
////                return i;
////            } catch (Exception e) {
////                log.info("获取配置Sting转int失败");
////            }
////            return null;
////        }
////    }
//
//}
