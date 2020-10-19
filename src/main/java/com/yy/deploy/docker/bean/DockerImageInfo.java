package com.yy.deploy.docker.bean;

import lombok.Data;

import java.util.List;

/**
 * @author yuanyao@wistronits.com
 * create on 2020-08-05 22:14
 */
@Data
public class DockerImageInfo {

    private String imageName;

    private List<String> versionList;
}
