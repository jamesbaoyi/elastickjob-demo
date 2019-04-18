package com.fintecher.cn.elasticjobdemo.service;

import com.dangdang.ddframe.rdb.sharding.api.ShardingValue;
import com.dangdang.ddframe.rdb.sharding.api.strategy.table.SingleKeyTableShardingAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @Author: qijigui
 * @CreateDate: 2019/4/18 16:30
 * @Description:
 */
@Component
public class TableShardingAlgorithm implements SingleKeyTableShardingAlgorithm<String> {

    @Override
    public String doEqualSharding(Collection<String> tableNames, ShardingValue<String> shardingValue) {
        for (String each : tableNames) {
            if (each.endsWith("0") && shardingValue.getValue().contains("军")) {
                return "user_0";
            } else
                return "user_1";
        }
        return null;
    }

    @Override
    public Collection<String> doInSharding(Collection<String> collection, ShardingValue<String> shardingValue) {
        return null;
    }

    @Override
    public Collection<String> doBetweenSharding(Collection<String> collection, ShardingValue<String> shardingValue) {
        return null;
    }

}
