package com.yy.deploy.server.service;

import com.yy.deploy.server.bean.ServerInfo;

import java.util.List;

/**
 * @author yuanyao@wistronits.com
 * create on 2020-08-03 14:39
 */
public interface ServerInfoService {

    List<ServerInfo> getServerInfo();

    void addServerInfo(ServerInfo serverInfo);
}
