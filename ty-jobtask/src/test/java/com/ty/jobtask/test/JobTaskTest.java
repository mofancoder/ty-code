package com.ty.jobtask.test;

import com.ty.jobtask.bean.JobTask;
import com.ty.jobtask.dao.TaskDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class JobTaskTest {

    @Resource
    private TaskDao taskDao;

    @Test
    public void addTask(){
        Long unixTime = System.currentTimeMillis() + 60000;
        JobTask task = new JobTask("test-msg-1", 0, unixTime);
        taskDao.save(task);
        unixTime += 60000;
        task = new JobTask("test-msg-2", 0, unixTime);
        taskDao.save(task);
        unixTime += 60000;
        task = new JobTask("test-msg-3", 0, unixTime);
        taskDao.save(task);
        unixTime += 60000;
        task = new JobTask("test-msg-4", 0, unixTime);
        taskDao.save(task);
    }
}
