package com.yy.deploy.deploy.service.impl;

import com.yy.deploy.deploy.service.DeployService;
import org.springframework.stereotype.Service;

/**
 * @author yuanyao@wistronits.com
 * create on 2020-08-06 21:40
 */
@Service
public class DeployServiceImpl implements DeployService {


    @Override
    public void startDelpoy() {
        /*
         * 1 - 拿到镜像信息包括版本
         * 2 - 连接到指定服务器
         * 3 - 检查环境
         *     - docker环境是否正常
         *     - 当前要启动的容器版本是否冲突
         * 4 - 执行启动命令
         */
    }
}
