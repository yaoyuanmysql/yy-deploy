package com.yy.deploy.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 本地服务器配置
 *
 * @author yuanyao@wistronits.com
 * create on 2020-08-25 16:50
 */
@Configuration
@ConfigurationProperties(prefix = "server")
public class ServerConfig {

    private String cmdUrl;
    private String cmdUserName;
    private String cmdPassword;

    public String getCmdUrl() {
        return cmdUrl;
    }

    public void setCmdUrl(String cmdUrl) {
        this.cmdUrl = cmdUrl;
    }

    public String getCmdUserName() {
        return cmdUserName;
    }

    public void setCmdUserName(String cmdUserName) {
        this.cmdUserName = cmdUserName;
    }

    public String getCmdPassword() {
        return cmdPassword;
    }

    public void setCmdPassword(String cmdPassword) {
        this.cmdPassword = cmdPassword;
    }
}
