package com.yy.deploy.docker.service.impl;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yy.deploy.docker.bean.DockerImageInfo;
import com.yy.deploy.docker.bean.DockerRepositoryInfo;
import com.yy.deploy.docker.dao.DockerRepositoryDao;
import com.yy.deploy.docker.service.DockerRepositoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * docker 仓库service
 * @author yuanyao@wistronits.com
 * create on 2020-08-05 22:18
 */
@SuppressWarnings("all")
@Slf4j
@Service
public class DockerRepositoryServiceImpl implements DockerRepositoryService {

    @Autowired
    private DockerRepositoryDao repositoryDao;


    @Override
    public List<DockerImageInfo> getDockerRepository(DockerRepositoryInfo repositoryInfo) {
        // 获取仓库中的镜像列表 还不知道能否实现
        // 如果不能实现、试试私有仓库中的镜像列表

        // 私有仓库通过访问 ip:5000/v2/search 可以拿到镜像信息

        // 打分支  docker tag docker.io/redis:5.0.3 10.5.24.236:5000/redis:test-0.1
        // 上传 docker push 10.5.24.236:5000/redis

        // 通过tag/list才能看到多个版本
        // http://39.99.186.219:5000/v2/fipole/pro/filink-station-server/tags/list

        String s;
        try {
            s = HttpUtil.get("http://" + repositoryInfo.getRepositoryIp() + ":" + repositoryInfo.getRepositoryPort() + "/v2/_catalog");
        } catch (Exception c) {
            c.printStackTrace();
            log.error("连接失败、请检查ip、端口或者登录名密码");
            return null;
        }

        JSONObject jsonObject = JSONObject.parseObject(s, JSONObject.class);
        Object repositories = jsonObject.get("repositories");
        if (repositories instanceof JSONArray) {
            JSONArray repositories1 = (JSONArray) repositories;
            List<DockerImageInfo> imageInfos = repositories1.stream().map(image -> {

                DockerImageInfo dockerImageInfo = new DockerImageInfo();
                dockerImageInfo.setImageName(image.toString());

                // 获取对应镜像的版本  也可以通过点击发起请求获取。
                String imagesVersion = HttpUtil.get("http://" + repositoryInfo.getRepositoryIp() + ":" +
                        repositoryInfo.getRepositoryPort() + "/v2/" + image.toString() + "/tags/list");
                JSONObject version = JSONObject.parseObject(imagesVersion, JSONObject.class);

                // 获取每个镜像的版本
                List<String> tags = (List<String>) version.get("tags");
                dockerImageInfo.setVersionList(tags);;
                return dockerImageInfo;

            }).collect(Collectors.toList());
            return imageInfos;

        }

        return null;
    }

    /**
     * 获取仓库中的镜像
     * repo_url=https://registry.hub.docker.com/v1/repositories
     * image_name=$1
     *
     * curl -s ${repo_url}/${image_name}/tags | json_reformat | grep name | awk '{print $2}' | sed -e 's/"//g'
     * @param imagesName
     * @param storageName
     * @return
     */
    @Override
    public List<DockerImageInfo> getImagesByName(String imagesName, String storageName) {
        // 获取仓库信息
        DockerRepositoryInfo repository = this.repositoryDao.getRepositoryByName(storageName);
        if (repository == null) {
            return null;
        }

        // 是空返回全部
        if (" ".equals(imagesName)) {
            return this.getDockerRepository(repository);
        }

        // TODO: 2020-08-13 后续研究有没有直接拿到想要的镜像api
        // 获取该仓库所有镜像
        String s = HttpUtil.get("http://" + repository.getRepositoryIp() + ":" +
                repository.getRepositoryPort() + "/v2/_catalog");
        JSONObject version = JSONObject.parseObject(s, JSONObject.class);
        Object repositories = version.get("repositories");
        if (repositories instanceof JSONArray) {
            JSONArray repositories1 = (JSONArray) repositories;
            List<DockerImageInfo> imageInfos = new ArrayList<>();
            for (Object image : repositories1) {
                if (image.toString().contains(imagesName)) {
                    DockerImageInfo dockerImageInfo = new DockerImageInfo();
                    dockerImageInfo.setImageName(image.toString());

                    // 获取对应镜像的版本  也可以通过点击发起请求获取。
                    String imagesVersion = HttpUtil.get("http://" + repository.getRepositoryIp() + ":" +
                            repository.getRepositoryPort() + "/v2/" + image.toString() + "/tags/list");
                    JSONObject imageVersion = JSONObject.parseObject(imagesVersion, JSONObject.class);

                    // 获取每个镜像的版本
                    List<String> tags = (List<String>) imageVersion.get("tags");
                    dockerImageInfo.setVersionList(tags);
                    imageInfos.add(dockerImageInfo);

                }
            }
            return imageInfos;
        }

        return null;
    }

    /**
     * 根据仓库名称获取对应的仓库镜像信息
     * @param repositoryName
     * @return
     */
    @Override
    public List<DockerImageInfo> getDockerRepository(String repositoryName) {
        // 查询对应仓库信息
        DockerRepositoryInfo repositoryInfo = this.repositoryDao.getRepositoryByName(repositoryName);
        return this.getDockerRepository(repositoryInfo);
    }

    @Override
    public void addRepository(DockerRepositoryInfo repositoryInfo) {

        this.repositoryDao.addRepository(repositoryInfo);
    }

    @Override
    public List<DockerRepositoryInfo> getRepositoryList() {
        return this.repositoryDao.getRepositoryList();
    }




}
