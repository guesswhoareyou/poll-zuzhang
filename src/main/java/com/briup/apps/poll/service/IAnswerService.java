package com.briup.apps.poll.service;

import java.util.List;
import com.briup.apps.poll.bean.Answer;
public interface IAnswerService {
void saveOrUpdate(Answer Answer) throws Exception;
	Answer findById(long id) throws Exception;
	//通过surveyId查询Answer
	List<Answer> findAnswerBySurveyId(long id) throws Exception;

}



