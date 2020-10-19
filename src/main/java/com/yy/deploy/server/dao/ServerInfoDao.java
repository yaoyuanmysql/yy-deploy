package com.yy.deploy.server.dao;

import com.yy.deploy.server.bean.ServerInfo;

import java.util.List;

/**
 * @author yuanyao@wistronits.com
 * create on 2020-08-03 14:40
 */
public interface ServerInfoDao {

    List<ServerInfo> getServerInfoList();

    int addServerInfo(ServerInfo serverInfo);
}
