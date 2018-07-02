package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Questionnaire;
import com.briup.apps.poll.bean.extend.QuestionnaireVM;

public interface IQuestionnaireService {
	/*查询所有问卷问题*/
	List<Questionnaire> findAll() throws Exception;
	/*通过id查询问卷问题*/
	QuestionnaireVM findById(long id) throws Exception;
	/*通过关键字查询问卷问题*/
	List<Questionnaire> Query(String keywords) throws Exception;
	/*保存和更新问卷问题信息*/
	void saveOrUpdate(Questionnaire questionnaire) throws Exception;
	/*通过id删除问卷问题*/
	void deleteById(long id) throws Exception;
	/*通过id批量删除问卷信息*/
	void batchDelete(List<Long> ids) throws Exception;

	
}
