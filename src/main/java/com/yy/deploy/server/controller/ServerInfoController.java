package com.yy.deploy.server.controller;

import cn.hutool.core.bean.BeanUtil;
import com.yy.deploy.server.bean.ServerInfo;
import com.yy.deploy.server.service.ServerInfoService;
import com.yy.deploy.server.vo.ServerInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 服务器信息控制器
 *
 * @author yuanyao@wistronits.com
 * create on 2020-08-03 11:14
 */
@RestController
@RequestMapping("/server")
public class ServerInfoController {

    @Autowired
    private ServerInfoService serverInfoService;

    /**
     * 获取服务器基本信息
     * @return
     */
    @PostMapping("/info/list")
    private ResponseEntity getServerInfo() {
        List<ServerInfo> serverInfoList = serverInfoService.getServerInfo();
        List<ServerInfoVo> vos = serverInfoList.stream().map(serverInfo -> {
            ServerInfoVo serverInfoVo = new ServerInfoVo();
            BeanUtil.copyProperties(serverInfo, serverInfoVo);
            return serverInfoVo;
        }).collect(Collectors.toList());

        return new ResponseEntity(vos, HttpStatus.OK);
    }

    /**
     * 新增服务器基础信息
     * @param serverInfo
     * @return
     */
    @PostMapping("/info")
    private ResponseEntity addServerInfo(@RequestBody ServerInfo serverInfo){
        serverInfoService.addServerInfo(serverInfo);
        return new ResponseEntity(HttpStatus.OK);
    }


}
