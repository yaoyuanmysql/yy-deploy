package com.yy.deploy.docker.controller;

import cn.hutool.core.collection.CollectionUtil;
import com.yy.deploy.docker.bean.DockerImageInfo;
import com.yy.deploy.docker.bean.DockerRepositoryInfo;
import com.yy.deploy.docker.service.DockerRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * docker控制器
 *
 * @author yuanyao@wistronits.com
 * create on 2020-08-05 22:08
 */
@RestController
@RequestMapping("/repository")
public class DockerRepositoryController {

    @Autowired
    private DockerRepositoryService repositoryService;

    /**
     * 查看已有仓库列表
     */
    @GetMapping("/list")
    public ResponseEntity getRepositoryList() {
        List<DockerRepositoryInfo> repositoryInfos = this.repositoryService.getRepositoryList();
        return new ResponseEntity(repositoryInfos, HttpStatus.OK);
    }


    /**
     * 新增仓库
     */
    @PostMapping("/info")
    private ResponseEntity addRepository(@RequestBody @Validated DockerRepositoryInfo repositoryInfo) {
        this.repositoryService.addRepository(repositoryInfo);
        return new ResponseEntity(HttpStatus.OK);
    }


    /**
     * 查看仓库中的镜像 REPOSITORY
     */
    @PostMapping("/images/list")
    private ResponseEntity getDockerRepository(@RequestBody DockerRepositoryInfo repositoryInfo) {
        List<DockerImageInfo> imageInfos = repositoryService.getDockerRepository(repositoryInfo);
        return new ResponseEntity(imageInfos, HttpStatus.OK);
    }

    /**
     * 根据仓库名称获取镜像名称
     *
     * @param repositoryName
     * @return
     */
    @GetMapping("/images/list/{repositoryName}")
    private ResponseEntity getDockerRepository(@PathVariable("repositoryName") String repositoryName) {
        List<DockerImageInfo> imageInfos = repositoryService.getDockerRepository(repositoryName);
        return new ResponseEntity(imageInfos, HttpStatus.OK);
    }

    @GetMapping("/images/search/{imagesName}/{storageName}")
    private ResponseEntity getImagesByName(@PathVariable("imagesName") String imagesName, @PathVariable("storageName") String storageName) {
        List<DockerImageInfo> imageInfos = this.repositoryService.getImagesByName(imagesName,storageName);
        return new ResponseEntity(imageInfos, HttpStatus.OK);
    }


}
