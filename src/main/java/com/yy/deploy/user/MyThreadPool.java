package com.yy.deploy.user;

import cn.hutool.http.HttpUtil;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自定义线程池
 *
 * @author yuanyao@wistronits.com
 * create on 2020/6/4 3:38 下午
 */
//@Order(1)
@Component
public class MyThreadPool implements ApplicationRunner {

    /**
     * 定时任务线程池
     */
    private ScheduledExecutorService executorService;
    private ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;

    public static boolean aBoolean = true;


    /**
     * 消息处理线程池
     */
    public static ExecutorService msgHandlerThreadExecutor;



    @Override
    public void run(ApplicationArguments args) throws Exception {

        // 初始化服务定时任务线程池  因为服务定时任务只是用来扫描空闲连接、所以数量不需要调整、不做配置
        scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(10, new ThreadFactory() {
            private final AtomicInteger index = new AtomicInteger(0);

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "抓取xml文件线程" + index.incrementAndGet());
            }
        });

//        for (int i = 0; i < 10 ; i++) {
//            scheduledThreadPoolExecutor.scheduleAtFixedRate(new Runnable() {
//                private final AtomicInteger index = new AtomicInteger(0);
//
//                @Override
//                public void run() {
//                    String s = HttpUtil.get("http://39.99.172.119:4200/group1/M00/00/05/rBo5aF8zqmeAJcbQAAACbzaso9k607.xml");
//                    System.out.println(Thread.currentThread().getName()+"当前执行了："+index.incrementAndGet()+"次");
//                }
//            },0, 3, TimeUnit.SECONDS);
//        }


    }

    /**
     * 线程池关闭
     */
    public void shutdown() {
        this.executorService.shutdown();
//        msgHandlerThreadExecutor.shutdown();
    }
}
