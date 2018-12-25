package com.ty.configuration;

import com.dangdang.ddframe.job.event.JobEventConfiguration;
import com.dangdang.ddframe.job.event.rdb.JobEventRdbConfiguration;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author MOFAN889
 * @ProjectName com.ty.configuration
 * @Description: TODO
 * @date 2018/12/24 17:20
 */
public class JobEventConfig {

    @Resource
    private DataSource dataSource;

    @Bean
    public JobEventConfiguration jobEventConfiguration() {
        return new JobEventRdbConfiguration(dataSource);
    }

}
