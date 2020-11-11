package com.github.lkqm.spring.huaweicloud.obs;

import com.obs.services.BasicObsCredentialsProvider;
import com.obs.services.IObsCredentialsProvider;
import com.obs.services.ObsClient;
import com.obs.services.ObsConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ObsAutoConfiguration
 */
@Configuration
@ConditionalOnProperty(prefix = ObsProperties.PREFIX, name = "enabled", havingValue = "true", matchIfMissing = true)
public class ObsAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    @ConfigurationProperties(ObsProperties.PREFIX)
    public ObsProperties obsProperties() {
        return new ObsProperties();
    }

    @Bean(destroyMethod = "close")
    @ConditionalOnMissingBean
    public ObsClient obsClient(IObsCredentialsProvider provider, ObsProperties properties, ObsConfiguration config) {
        String endpoint = properties.getEndpoint();
        if (endpoint == null || endpoint.length() == 0) {
            throw new IllegalArgumentException("'endpoint' can't be empty");
        }

        config.setEndPoint(endpoint);
        return new ObsClient(provider, config);
    }

    @Bean
    @ConditionalOnMissingBean
    public IObsCredentialsProvider obsCredentialsProvider(ObsProperties properties) {
        return new BasicObsCredentialsProvider(properties.getAccessKeyId(), properties.getAccessKeySecret(),
                properties.getSecurityToken());
    }

    @Bean
    @ConditionalOnMissingBean
    public ObsConfiguration obsConfiguration(ObsProperties properties) {
        ObsConfiguration config = properties.getConfig();
        if (config == null) {
            config = new ObsConfiguration();
        }
        return config;
    }

}
