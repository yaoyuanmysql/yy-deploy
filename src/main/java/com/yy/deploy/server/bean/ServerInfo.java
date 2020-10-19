package com.yy.deploy.server.bean;

import lombok.Data;

/**
 *
 * 服务器信息实体
 * @author yuanyao@wistronits.com
 * create on 2020-08-03 14:01
 */
@Data
public class ServerInfo {

    private String id;
    private String serverName;
    private String serverIp;
    private String serverLoginName;
    private String serverLoginPassword;

}
