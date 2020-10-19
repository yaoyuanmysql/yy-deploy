package com.yy.deploy.docker.bean;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author yuanyao@wistronits.com
 * create on 2020-08-05 22:12
 */
@Data
public class DockerRepositoryInfo {

    private int id;
    /**
     * NotEmpty 用在集合上面(不能注释枚举)
     *
     * NotBlank用在String上面 " "也不行
     *
     * NotNull用在所有类型上面
     */
    @NotBlank(message = "仓库名称不能为空")
    private String repositoryName;

    @NotBlank(message = "仓库ip不能为空")
    private String repositoryIp;

    @NotNull(message = "仓库端口不能为空")
    private Integer repositoryPort;

    private String repositoryLoginName;

    private String repositoryLoginPassword;
}
