package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Survey;
import com.briup.apps.poll.bean.extend.SurveyVM;

public interface ISurveyService {
//	查找
	List<Survey> findAll() throws Exception;
    List<SurveyVM> findAllSurveyVM() throws Exception;
//	通过ID删除课程
	Survey findById(long id) throws Exception;

//	通过关键字查找
	List<Survey> querry(String keywords) throws Exception;

//	保存和更新
	void saveOrUpdate(Survey survey) throws Exception;
	void saveOrUpdateSurveyVM(SurveyVM surveyVM) throws Exception;
//	通过i的删除
	void deleteById(long id) throws Exception;
//批量删除
	void batchDelete(List<Long> ids) throws Exception;
}
