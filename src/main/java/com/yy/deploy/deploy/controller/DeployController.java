package com.yy.deploy.deploy.controller;

import com.yy.deploy.deploy.service.DeployService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuanyao@wistronits.com
 * create on 2020-08-06 21:38
 */
@RestController
@RequestMapping("/deploy")
public class DeployController {

    @Autowired
    private DeployService deployService;

    /**
     * 开始部署
     */
    @PostMapping("/start")
    private void startDelpoy() {
        deployService.startDelpoy();

    }


}
