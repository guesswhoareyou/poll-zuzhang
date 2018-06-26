package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Course;

public interface ICourseService {
	
//	查找课程
	List<Course> findAll() throws Exception;

//	通过ID删除课程
	Course findById(long id) throws Exception;

//	通过关键字查找
	List<Course> querry(String keywords) throws Exception;

//	保存和更新
	void saveOrUpdate(Course course) throws Exception;

//	通过i的删除
	void deleteById(long id) throws Exception;
//批量删除
	void batchDelete(List<Long> ids) throws Exception;
}
