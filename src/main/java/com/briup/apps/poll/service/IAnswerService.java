package com.briup.apps.poll.service;

import java.util.List;
import com.briup.apps.poll.bean.Answer;
public interface IAnswerService {
//	查找
	List<Answer> findAll() throws Exception;

//	通过ID删除
	Answer findById(long id) throws Exception;

//	通过关键字查找
	List<Answer> querry(String keywords) throws Exception;

//	保存和更新
	void saveOrUpdate(Answer answer) throws Exception;

//	通过i的删除
	void deleteById(long id) throws Exception;
//批量删除
	void batchDelete(List<Long> ids) throws Exception;


}



