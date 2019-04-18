package com.fintecher.cn.elasticjobdemo.service;

import com.dangdang.ddframe.rdb.sharding.api.ShardingValue;
import com.dangdang.ddframe.rdb.sharding.api.strategy.database.SingleKeyDatabaseShardingAlgorithm;
import com.fintecher.cn.elasticjobdemo.config.Database1Config;
import com.fintecher.cn.elasticjobdemo.config.Database2Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @Author: qijigui
 * @CreateDate: 2019/4/18 16:29
 * @Description:
 */
@Component
public class DatabaseShardingAlgorithm implements SingleKeyDatabaseShardingAlgorithm<Long> {

    @Autowired
    private Database2Config database2Config;

    @Autowired
    private Database1Config database1Config;

    @Override
    public String doEqualSharding(Collection<String> collection, ShardingValue<Long> shardingValue) {
        Long value = shardingValue.getValue();
        if (value <= 20L)
            return database1Config.getDatabaseName();
        else
            return database2Config.getDatabaseName();
    }

    @Override
    public Collection<String> doInSharding(Collection<String> collection, ShardingValue<Long> shardingValue) {
        return null;
    }

    @Override
    public Collection<String> doBetweenSharding(Collection<String> collection, ShardingValue<Long> shardingValue) {
        return null;
    }

}
