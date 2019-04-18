package com.fintecher.cn.elasticjobdemo.config;

import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: qijigui
 * @CreateDate: 2019/4/11 16:06
 * @Description:
 */
@Configuration
public class ElasticRegCenterConfig {

    @Bean(initMethod = "init")
    public ZookeeperRegistryCenter registryCenter(@Value("${regCenter.serverList}") final String serverList,
                                                  @Value("${regCenter.namespace}") final String namespace) {
        return new ZookeeperRegistryCenter(new ZookeeperConfiguration(serverList, namespace));
    }

}
