package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Answer;
import com.briup.apps.poll.bean.AnswerExample;
import com.briup.apps.poll.bean.Survey;
import com.briup.apps.poll.bean.SurveyExample;
import com.briup.apps.poll.bean.extend.SurveyVM;
import com.briup.apps.poll.dao.AnswerMapper;
import com.briup.apps.poll.dao.SurveyMapper;
import com.briup.apps.poll.dao.extend.SurveyVMMapper;
import com.briup.apps.poll.service.ISurveyService;
@Service
public class SurveyServiceImpl implements ISurveyService{
@Autowired
private SurveyMapper surveyMapper;
@Autowired
private SurveyVMMapper surveyVMMapper;
@Autowired
private AnswerMapper answerMapper;
	@Override
	public List<Survey> findAll() throws Exception {
		// TODO Auto-generated method stub
		SurveyExample example = new SurveyExample();
		return surveyMapper.selectByExample(example);
	}

	@Override
	public Survey findById(long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Survey> querry(String keywords) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveOrUpdate(Survey survey) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(long id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void batchDelete(List<Long> ids) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SurveyVM> findAllSurveyVM() throws Exception {
		// TODO Auto-generated method stub
		return surveyVMMapper.selectAll();
	}
/*
 * 保存或修改课调
 * */
	@Override
	public void saveOrUpdateSurveyVM(SurveyVM surveyVM) throws Exception {
		// TODO Auto-generated method stub
		//List<Answers> answer=SurveyVM.getAnswer();
		List<Answer> answer=surveyVM.getAnswer();
		Survey survey=new Survey();
		survey.setId(surveyVM.getId());
		survey.setStatus(surveyVM.getStatus());
		survey.setCode(surveyVM.getCode());
		survey.setSurveydate(surveyVM.getSurveyDate());
		//判断保存还是修改
		if(survey.getId()==null){
			//2.1保存
			surveyMapper.insert(survey);
		}else{
			//2.2修改
			surveyMapper.updateByPrimaryKey(survey);
			AnswerExample example=new AnswerExample();
			example.createCriteria().andSurveyIdEqualTo(survey.getId());
			answerMapper.deleteByExample(example);
			long surveyId=survey.getId();
			for(Answer answers:answer){
				//为每个answers设置survey_id
				answers.setSurveyId(surveyId);
				answerMapper.insert(answers);
				
			}
		}
		//1.判断保存还是修改
	}

}
