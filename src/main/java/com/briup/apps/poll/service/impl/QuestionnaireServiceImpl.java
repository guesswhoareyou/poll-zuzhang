package com.briup.apps.poll.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.briup.apps.poll.bean.Questionnaire;
import com.briup.apps.poll.bean.QuestionnaireExample;
import com.briup.apps.poll.dao.QuestionnaireMapper;
import com.briup.apps.poll.service.IQuestionnaireService;

@Service
public class QuestionnaireServiceImpl implements IQuestionnaireService{

	@Autowired
	private QuestionnaireMapper questionnaireMapper;
	//查看所有的问卷问题
	@Override
	public List<Questionnaire> findAll() throws Exception {
		QuestionnaireExample example=new QuestionnaireExample();
		return questionnaireMapper.selectByExample(example);
	}
	//通过id查看问卷问题信息
	@Override
	public Questionnaire findById(long id) throws Exception {
		return questionnaireMapper.selectByPrimaryKey(id);
	}
	//通过关键字搜寻问卷问题
	@Override
	public List<Questionnaire> Query(String keywords) throws Exception {
		QuestionnaireExample example=new QuestionnaireExample();
		example.createCriteria().andNameLike(keywords);
		return questionnaireMapper.selectByExampleWithBLOBs(example);
	}
	//更新和添加问卷问题信息
	@Override
	public void saveOrUpdate(Questionnaire questionnaire) throws Exception {

		if(questionnaire.getId()!=null){
			questionnaireMapper.updateByPrimaryKey(questionnaire);
		}else {
			questionnaireMapper.insert(questionnaire);
		}
	}
	//通过id删除问卷问题信息
	@Override
	public void deleteById(long id) throws Exception {
		questionnaireMapper.deleteByPrimaryKey(id);
	}
	//通过id批量删除问卷问题
	@Override
	public void batchDelete(List<Long> ids) throws Exception {
		for(long id:ids){
			questionnaireMapper.deleteByPrimaryKey(id);
		}
	}
	}
	
