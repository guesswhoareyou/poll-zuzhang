package com.briup.apps.poll.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.briup.apps.poll.bean.Questionnaire;
import com.briup.apps.poll.bean.QuestionnaireExample;
import com.briup.apps.poll.bean.QuestionnaireQuestion;
import com.briup.apps.poll.bean.QuestionnaireQuestionExample;
import com.briup.apps.poll.bean.extend.QuestionnaireVM;
import com.briup.apps.poll.dao.QuestionnaireMapper;
import com.briup.apps.poll.dao.QuestionnaireQuestionMapper;
import com.briup.apps.poll.dao.extend.QuestionnaireVMMapper;
import com.briup.apps.poll.service.IQuestionnaireService;

@Service
public class QuestionnaireServiceImpl implements IQuestionnaireService{
	@Autowired
	private QuestionnaireMapper questionnaireMapper;
	@Autowired
	private QuestionnaireVMMapper questionnaireVMMapper;
	@Autowired
	private QuestionnaireQuestionMapper questionnairequestionMapper;
	//查看所有的问卷问题
		@Override
		public List<Questionnaire> findAll() throws Exception {
			QuestionnaireExample example=new QuestionnaireExample();
			return questionnaireMapper.selectByExampleWithBLOBs(example);
		}
		
		//通过id查看问卷问题信息
		@Override
		public QuestionnaireVM findById(long id) throws Exception{
			return questionnaireVMMapper.selectById(id);
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

	@Override
	public void saveOrUpdate(Questionnaire questionnaire, long[] questionIds) throws Exception {
		// 判断是什么操作
		if(questionnaire.getId()==null){
			//1,1保存
			//1,1,1 保存问卷信息{id:null;name:'',description:''}
			questionnaireMapper.insert(questionnaire);
			long questionnaireId= questionnaire.getId();
			//1,1,2维护问卷和问题的关系
			for(long questionId:questionIds){
				QuestionnaireQuestion questionnairequestion=new QuestionnaireQuestion();
				questionnairequestion.setQuestionId(questionId);
				questionnairequestion.setQuestionnaireId(questionnaireId);
				questionnairequestionMapper.insert(questionnairequestion);
			}
		}else{
			//1.2修改
			//1.2.1修改问卷信息
			questionnaireMapper.updateByPrimaryKey(questionnaire);
			long questionnaireId=questionnaire.getId();
			//1.2.2删除问卷下所有的问卷问题关系
			QuestionnaireQuestionExample example=new QuestionnaireQuestionExample();
			example.createCriteria().andQuestionnaireIdEqualTo(questionnaireId);
			questionnairequestionMapper.deleteByExample(example);
			//1.2.1保存新的问卷问题关系
			for(long questionId:questionIds){
				QuestionnaireQuestion questionnairequestion=new QuestionnaireQuestion();
				questionnairequestion.setQuestionId(questionId);
				questionnairequestion.setQuestionnaireId(questionnaireId);
				questionnairequestionMapper.insert(questionnairequestion);
			}
			
		}
		
	}
	}
	
