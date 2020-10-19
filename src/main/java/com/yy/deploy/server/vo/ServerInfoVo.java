package com.yy.deploy.server.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yuanyao@wistronits.com
 * create on 2020-08-03 14:51
 */
@Data
public class ServerInfoVo implements Serializable {

    private String id;

    private String serverName;

    private String serverIp;
}
