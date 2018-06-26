package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Grade;

public interface IGradeService  {
	List<Grade> findAll() throws Exception;
	Grade findById(long id) throws Exception;
	 List<Grade> query (String Keywords) throws Exception;
	 //保存和更新操作合并
	 void saveOrUpdate (Grade grade) throws Exception;
	 void deleteById(long id) throws Exception;
	 //批量删除
	 void batchDelete(List<Long> ids) throws Exception;
}
