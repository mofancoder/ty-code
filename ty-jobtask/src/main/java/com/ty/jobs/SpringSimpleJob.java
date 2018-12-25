package com.ty.jobs;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

/**
 * @author MOFAN889
 * @ProjectName com.ty.jobs
 * @Description: TODO
 * @date 2018/12/24 17:27
 */
public class SpringSimpleJob implements SimpleJob {

    @Override
    public void execute(final ShardingContext shardingContext){
        System.out.println("当前分片："+shardingContext.getShardingItem()+"---"+shardingContext.getShardingParameter());
    }

}
