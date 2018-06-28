package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.QuestionnaireQuestion;
import com.briup.apps.poll.bean.QuestionnaireQuestionExample;
import com.briup.apps.poll.bean.extend.QuestionnaireQuestionVM;
import com.briup.apps.poll.dao.QuestionnaireQuestionMapper;
import com.briup.apps.poll.dao.extend.QuestionnaireQuestionVMMappre;
import com.briup.apps.poll.service.IQuestionnaireQuestionService;

@Service
public class QuestionnaireQuestionServiceImpl implements IQuestionnaireQuestionService{
	@Autowired
	private QuestionnaireQuestionMapper questionnaireQuestionMapper;
	@Autowired
	private QuestionnaireQuestionVMMappre questionnaireQuestionVMMappre;
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
	/**
	 * 查询所有问卷和问题
	 */
	@Override
	public List<QuestionnaireQuestionVM> findAllQuestionnaireQuestionVM() throws Exception {

		return questionnaireQuestionVMMappre.selectAll();
	}
	/**
	 * 根据id查询问卷和问题
	 */
	@Override
	public QuestionnaireQuestionVM selectById(long id) throws Exception {
		
		return questionnaireQuestionVMMappre.selectById(id);
	}

}
