package com.fintecher.cn.elasticjobdemo.elasticjob;

import com.dangdang.ddframe.job.executor.ShardingContexts;
import com.dangdang.ddframe.job.lite.api.listener.ElasticJobListener;

import java.util.Date;

/**
 * @Author: qijigui
 * @CreateDate: 2019/4/11 16:16
 * @Description:
 */
public class MyElasticJobListener implements ElasticJobListener {


    @Override
    public void beforeJobExecuted(ShardingContexts shardingContexts) {
        System.out.println("任务开始时间" + new Date());

    }

    @Override
    public void afterJobExecuted(ShardingContexts shardingContexts) {
        System.out.println("任务结束时间" + new Date());
    }
}
