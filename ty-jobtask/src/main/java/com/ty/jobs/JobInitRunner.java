package com.ty.jobs;

import com.dangdang.ddframe.job.api.JobType;
import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.JobTypeConfiguration;
import com.dangdang.ddframe.job.config.dataflow.DataflowJobConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.lite.api.JobScheduler;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.reg.base.CoordinatorRegistryCenter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JobInitRunner implements CommandLineRunner {

    private final CoordinatorRegistryCenter regCenter;

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("任务初始化。。。");
        jobInit();
    }

    public void jobInit() {
        addJob(createLiteJobConfiguration("SimpleJob", "0/5 * * * * ?", 10, MySimpleJob.class, JobType.SIMPLE));
    }

    private void addJob(LiteJobConfiguration jobConfiguration) {
        new JobScheduler(regCenter, jobConfiguration).init();
    }

    private LiteJobConfiguration createLiteJobConfiguration(String JobName, String cron, int shardingCount, Class c, JobType type) {
        JobCoreConfiguration coreConfig = JobCoreConfiguration.newBuilder(JobName, cron, shardingCount).build();
        JobTypeConfiguration jobConfig = new SimpleJobConfiguration(coreConfig, c.getCanonicalName());
        if (type.compareTo(JobType.DATAFLOW) == 0) {
            jobConfig = new DataflowJobConfiguration(coreConfig, c.getCanonicalName(), true);
        }
        return LiteJobConfiguration.newBuilder(jobConfig).build();
    }

}
