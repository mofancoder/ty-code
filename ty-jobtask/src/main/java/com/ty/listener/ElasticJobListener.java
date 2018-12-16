package com.ty.listener;

import com.dangdang.ddframe.job.executor.ShardingContexts;
import com.dangdang.ddframe.job.lite.api.listener.AbstractDistributeOnceElasticJobListener;
import com.ty.jobtask.bean.JobTask;
import com.ty.jobtask.dao.TaskDao;

import javax.annotation.Resource;

public class ElasticJobListener extends AbstractDistributeOnceElasticJobListener {

    @Resource
    private TaskDao taskDao;

    public ElasticJobListener(long startedTimeoutMilliseconds, long completedTimeoutMilliseconds) {
        super(startedTimeoutMilliseconds, completedTimeoutMilliseconds);
    }

    @Override
    public void doBeforeJobExecutedAtLastStarted(ShardingContexts shardingContexts) {

    }

    @Override
    public void doAfterJobExecutedAtLastCompleted(ShardingContexts shardingContexts) {
        //任务执行完成后更新状态为已执行
        JobTask jobTask = taskDao.getOne(Long.valueOf(shardingContexts.getJobParameter()));
        jobTask.setStatus(1);
        taskDao.save(jobTask);
    }
}
