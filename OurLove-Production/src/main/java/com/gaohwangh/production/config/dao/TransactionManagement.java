package com.gaohwangh.production.config.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @Author: GH
 * @Date: 2019/7/16 19:24
 * @Version 1.0
 * <p>
 * <p>
 * 事务配置
 */
@Configuration
public class TransactionManagement {

    /**
     *  dataSource 框架会自动为我们注入
     *  为事务指定数据源
     * @param dataSource
     * @return
     */
    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
       return new DataSourceTransactionManager(dataSource);
    }
}
