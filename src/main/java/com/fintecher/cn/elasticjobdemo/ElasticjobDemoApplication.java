package com.fintecher.cn.elasticjobdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement(proxyTargetClass = true)
@EnableConfigurationProperties
public class ElasticjobDemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(ElasticjobDemoApplication.class, args);
    }

}
