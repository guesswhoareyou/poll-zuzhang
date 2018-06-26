package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Clazz;

public interface IClazzService {
	List<Clazz> findAll() throws Exception;
	Clazz findById(long id) throws Exception;
	 List<Clazz> query (String Keywords) throws Exception;
	 //保存和更新操作合并
	 void saveOrUpdate (Clazz clazz) throws Exception;
	 void deleteById(long id) throws Exception;
	 //批量
	 void batchDelete(List<Long> ids) throws Exception;
}
