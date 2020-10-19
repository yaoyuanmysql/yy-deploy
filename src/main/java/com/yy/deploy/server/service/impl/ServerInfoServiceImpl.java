package com.yy.deploy.server.service.impl;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.HashUtil;
import com.yy.deploy.server.bean.ServerInfo;
import com.yy.deploy.server.dao.ServerInfoDao;
import com.yy.deploy.server.service.ServerInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yuanyao@wistronits.com
 * create on 2020-08-03 14:40
 */
@Slf4j
@Service
public class ServerInfoServiceImpl implements ServerInfoService {

    @Autowired
    private ServerInfoDao serverInfoDao;

    @Override
    public List<ServerInfo> getServerInfo() {
        List<ServerInfo> serverInfos = serverInfoDao.getServerInfoList();

        // 触发采集任务逻辑


        return serverInfos;
    }

    @Override
    public void addServerInfo(ServerInfo serverInfo) {

        // 密码编码 yy就相当于私钥
        serverInfo.setServerLoginPassword(Base64.encode(serverInfo.getServerLoginPassword()) + "yy");

        // 解码 Base64.decodeStr(str)；

        // 保存
        serverInfoDao.addServerInfo(serverInfo);
    }

}
