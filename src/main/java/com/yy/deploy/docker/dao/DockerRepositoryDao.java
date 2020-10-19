package com.yy.deploy.docker.dao;

import com.yy.deploy.docker.bean.DockerRepositoryInfo;

import java.util.List;

/**
 * @author yuanyao@wistronits.com
 * create on 2020-08-06 18:04
 */
public interface DockerRepositoryDao {


    /**
     * 新增仓库信息
     * @param repositoryInfo
     */
    void addRepository(DockerRepositoryInfo repositoryInfo);

    /**
     * 插叙仓库列表
     * @return
     */
    List<DockerRepositoryInfo> getRepositoryList();

    /**
     * 根据名称查询仓库
     * @param repositoryName
     * @return
     */
    DockerRepositoryInfo getRepositoryByName(String repositoryName);
}
