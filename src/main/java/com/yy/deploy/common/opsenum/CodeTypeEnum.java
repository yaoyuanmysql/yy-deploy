package com.yy.deploy.common.opsenum;

/**
 * @author yuanyao@wistronits.com
 * create on 2020-08-25 14:52
 */
public enum CodeTypeEnum {

    /**
     * git类型
     */
    GIT("git"),

    /**
     * svn类型
     */
    SVN("svn");


    private String codeType;


    CodeTypeEnum(String codeType) {
        this.codeType = codeType;
    }

    public String getCodeType() {
        return codeType;
    }

    public CodeTypeEnum getCodeTypeEnum(String codeType) {
        for (CodeTypeEnum codeTypeEnum : CodeTypeEnum.values()) {
            if (codeTypeEnum.codeType.equals(codeType)) {
                return codeTypeEnum;
            }
        }
        return null;
    }
}
