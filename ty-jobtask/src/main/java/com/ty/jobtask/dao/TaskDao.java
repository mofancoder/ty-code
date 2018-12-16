package com.ty.jobtask.dao;

import com.ty.jobtask.bean.JobTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 继承JpaRepository,该接口本身已经实现了创建（save）、更新（save）、删除（delete）、查询（findAll、findOne）等基本操作的函数
 **/
public interface TaskDao extends JpaRepository<JobTask, Long>, JpaSpecificationExecutor<JobTask> {

}
