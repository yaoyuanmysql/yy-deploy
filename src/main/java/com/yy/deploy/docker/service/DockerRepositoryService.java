package com.yy.deploy.docker.service;

import com.yy.deploy.docker.bean.DockerImageInfo;
import com.yy.deploy.docker.bean.DockerRepositoryInfo;

import java.util.List;

/**
 * @author yuanyao@wistronits.com
 * create on 2020-08-05 22:11
 */
public interface DockerRepositoryService {


    /**
     * 获取仓库中的镜像信息
     * @param repositoryInfo
     * @return
     */
    List<DockerImageInfo> getDockerRepository(DockerRepositoryInfo repositoryInfo);

    /**
     * 获取仓库中的镜像信息
     * @param repositoryName
     * @return
     */
    List<DockerImageInfo> getDockerRepository(String repositoryName);

    /**
     * 新增仓库信息
     * @param repositoryInfo
     */
    void addRepository(DockerRepositoryInfo repositoryInfo);

    /**
     * 获取仓库列表
     * @return
     */
    List<DockerRepositoryInfo> getRepositoryList();


    List<DockerImageInfo> getImagesByName(String imagesName,String storageName);

}
