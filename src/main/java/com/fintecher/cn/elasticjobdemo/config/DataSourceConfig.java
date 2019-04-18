package com.fintecher.cn.elasticjobdemo.config;

import com.dangdang.ddframe.rdb.sharding.api.ShardingDataSourceFactory;
import com.dangdang.ddframe.rdb.sharding.api.rule.DataSourceRule;
import com.dangdang.ddframe.rdb.sharding.api.rule.ShardingRule;
import com.dangdang.ddframe.rdb.sharding.api.rule.TableRule;
import com.dangdang.ddframe.rdb.sharding.api.strategy.database.DatabaseShardingStrategy;
import com.dangdang.ddframe.rdb.sharding.api.strategy.table.TableShardingStrategy;
import com.dangdang.ddframe.rdb.sharding.keygen.DefaultKeyGenerator;
import com.dangdang.ddframe.rdb.sharding.keygen.KeyGenerator;
import com.fintecher.cn.elasticjobdemo.service.DatabaseShardingAlgorithm;
import com.fintecher.cn.elasticjobdemo.service.TableShardingAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: qijigui
 * @CreateDate: 2019/4/18 14:54
 * @Description:
 */
@Configuration
public class DataSourceConfig {

    @Autowired
    private Database1Config database1Config;

    @Autowired
    private Database2Config database2Config;

    @Autowired
    private DatabaseShardingAlgorithm databaseShardingAlgorithm;

    @Autowired
    private TableShardingAlgorithm tableShardingAlgorithm;

    @Bean
    public DataSource getDataSource() throws SQLException {
        return buildDataSource();
    }

    private DataSource buildDataSource() throws SQLException {
        //设置从库数据源集合
        Map<String, DataSource> slaveDataSourceMap = new HashMap<>();
        slaveDataSourceMap.put(database1Config.getDatabaseName(), database1Config.createDataSource());
        slaveDataSourceMap.put(database2Config.getDatabaseName(), database2Config.createDataSource());

        //设置默认数据库
        DataSourceRule dataSourceRule = new DataSourceRule(slaveDataSourceMap, database1Config.getDatabaseName());

        //分表设置
        TableRule orderTableRules = TableRule.builder("user").actualTables(Arrays.asList("user_0", "user_1")).dataSourceRule(dataSourceRule).build();

        //分库分表策略
        ShardingRule shardingRule = ShardingRule.builder()
                .dataSourceRule(dataSourceRule)
                .tableRules(Arrays.asList(orderTableRules))
                .databaseShardingStrategy(new DatabaseShardingStrategy("id", databaseShardingAlgorithm))
                .tableShardingStrategy(new TableShardingStrategy("name", tableShardingAlgorithm))
                .build();

        //获取数据源对象
//        DataSource dataSource = MasterSlaveDataSourceFactory.createDataSource("masterSlave", database0Config.getDatabaseName()
//                , database0Config.createDataSource(), slaveDataSourceMap, MasterSlaveLoadBalanceStrategyType.getDefaultStrategyType());

        DataSource dataSource = ShardingDataSourceFactory.createDataSource(shardingRule);


        return dataSource;
    }


    @Bean
    public KeyGenerator keyGenerator() {
        return new DefaultKeyGenerator();
    }

}
