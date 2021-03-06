package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.QuestionnaireQuestion;
import com.briup.apps.poll.bean.QuestionnaireQuestionExample;
import com.briup.apps.poll.dao.QuestionnaireQuestionMapper;
import com.briup.apps.poll.service.IQuestionnaireQuestionService;

@Service
public class QuestionnaireQuestionServiceImpl implements IQuestionnaireQuestionService{
	@Autowired
	private QuestionnaireQuestionMapper questionnaireQuestionMapper;
	/**
	 * 查询所有数据
	 */
	@Override
	public List<QuestionnaireQuestion> findAll() throws Exception {
		QuestionnaireQuestionExample example = new QuestionnaireQuestionExample();
		return questionnaireQuestionMapper.selectByExample(example);
	}
	/**
	 * 根据id查询数据
	 */
	@Override
	public QuestionnaireQuestion findById(long id) throws Exception {
		
		return questionnaireQuestionMapper.selectByPrimaryKey(id);
	}
	/**
	 * 根据id删除数据
	 */
	@Override
	public void deleteById(long id) throws Exception {
		questionnaireQuestionMapper.deleteByPrimaryKey(id);
	}
	/**
	 * 插入或更新数据
	 */
	@Override
	public void saveOrUpdate(QuestionnaireQuestion qq) throws Exception {
		if(qq.getId()!=null){
			questionnaireQuestionMapper.updateByPrimaryKey(qq);
		}else{
			questionnaireQuestionMapper.insert(qq);
		}
	}
	/**
	 * 批量删除数据
	 */
	@Override
	public void batchDelete(long[] ids) throws Exception {
		for(long id : ids){
			questionnaireQuestionMapper.deleteByPrimaryKey(id);
		}
	}
	
}
