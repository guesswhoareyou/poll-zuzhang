package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Options;
import com.briup.apps.poll.bean.OptionsExample;
import com.briup.apps.poll.bean.Question;
import com.briup.apps.poll.bean.QuestionExample;
import com.briup.apps.poll.bean.extend.QuestionVM;
import com.briup.apps.poll.dao.OptionsMapper;
import com.briup.apps.poll.dao.QuestionMapper;
import com.briup.apps.poll.dao.extend.QuestionVMMapper;
import com.briup.apps.poll.service.IQuestionService;

@Service
public class QuestionServiceImpl implements IQuestionService {
   
	@Autowired
    private QuestionMapper questionMapper;
	@Autowired
	private QuestionVMMapper questionVMMapper;
	@Autowired
	private OptionsMapper optionsMapper;
	
	//查询所有
	@Override
	public List<Question> findAll() throws Exception {
		QuestionExample example=new QuestionExample();
		return questionMapper.selectByExample(example);
	}
	
	@Override
	public List<QuestionVM> findAllQuestionVM() throws Exception {
		return questionVMMapper.selectAll();
	}
    /**
     * 保存修改包含选项。
     * */
	@Override
	public void saveOrUpdateQuestionVM(QuestionVM questionvm) throws Exception {
		
		List<Options> options=questionvm.getOptions();
		Question question=new Question();
		question.setId(questionvm.getId());
		question.setName(questionvm.getName());
		question.setQuestiontype(questionvm.getQuestionType());
		//options 问题选项
		if(question.getId()==null) {
		//1.判断修改还是保存
		if(question.getQuestiontype().equals("简答题")) {
			questionMapper.insert(question);
		}else {
			questionMapper.insert(question);
			long questionId=question.getId();
			if(options !=null) {
			for(Options option :options) {
				//为Options设置ID
				option.setQuestionId(questionId);
				//保存选项
				optionsMapper.insert(option);
			}
			 	
			}
		}
	}else {
		//修改题目信息
		questionMapper.updateByPrimaryKey(question);
		//修改选项
		//删除题目选项
		OptionsExample example=new OptionsExample();
		example.createCriteria().andIdEqualTo(question.getId());
		optionsMapper.deleteByExample(example);
		//重新添加选项
		long questionId=question.getId();
		if(options !=null) {
		for(Options option :options) {
			//为Option设置questionID
			option.setQuestionId(questionId);
			//保存选项
			optionsMapper.insert(option);
		}
		
	}
		
		
		}
	}
	
    //通过ID删除
	@Override
	public void deleteById(long id) throws Exception {
	questionMapper.deleteByPrimaryKey(id);
		
	}
	
	
    //批量删除
	@Override
	public void batchDelete(long[] ids) throws Exception {
		//增强for循环
		for(long id:ids) {
			questionMapper.deleteByPrimaryKey(id);
		}

}
	 //查询ID
	@Override
	public QuestionVM findById(long id) throws Exception {
		
		return questionVMMapper.selectById(id);

	}
   
 
	//关键字查询
	@Override
	public List<Question> queryQuestion(String keywords) throws Exception {
		QuestionExample example=new QuestionExample();
		//添加了一个条件，name属性中包含keywords关键字
		example.createCriteria().andNameLike(keywords);
		return questionMapper.selectByExample(example);
	}
	


	}
