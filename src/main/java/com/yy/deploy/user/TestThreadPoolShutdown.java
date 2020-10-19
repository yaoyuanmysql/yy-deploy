package com.yy.deploy.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author yuanyao@wistronits.com
 * create on 2020-08-11 14:30
 */
@RestController
@RequestMapping
public class TestThreadPoolShutdown {

    @GetMapping("/start")
    public void startThread() {
        System.out.println("开始关闭定时任务线程池");
        MyThreadPool.aBoolean = false;
//        MyThreadPool.executorService.shutdown();
    }
}
