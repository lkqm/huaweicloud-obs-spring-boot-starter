package com.github.lkqm.spring.huaweicloud.obs;

import com.obs.services.ObsConfiguration;
import java.io.Serializable;
import lombok.Data;

/**
 * ObsProperties
 */
@Data
public class ObsProperties implements Serializable {

    public static final String PREFIX = "huaweicloud.obs";

    /**
     * 服务地址
     */
    private String endpoint;

    /**
     * 访问标识
     */
    private String accessKeyId;

    /**
     * 访问密钥
     */
    private String accessKeySecret;

    /**
     * 会话token
     */
    private String securityToken;

    /**
     * 其他配置
     */
    private ObsConfiguration config;

}