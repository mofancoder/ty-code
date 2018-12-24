package com.ty.configuration;

import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class ZkConfig {

    private String zkHost = "127.0.0.1:2181";

    private String namespace = "gome-job";

    @Bean(name = "zkConfig")
    public ZookeeperConfiguration zkConfiguration() {
        ZookeeperConfiguration zk = new ZookeeperConfiguration(zkHost, namespace);
        zk.setBaseSleepTimeMilliseconds(1000);
        zk.setMaxSleepTimeMilliseconds(3000);
        zk.setMaxRetries(3);
        return zk;
    }

    @Bean(initMethod = "init")
    public ZookeeperRegistryCenter regCenter(ZookeeperConfiguration zkConfig) {
        return new ZookeeperRegistryCenter(zkConfig);
    }

}
