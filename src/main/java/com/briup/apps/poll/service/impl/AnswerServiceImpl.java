package com.briup.apps.poll.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.briup.apps.poll.bean.Answer;
import com.briup.apps.poll.bean.AnswerExample;
import com.briup.apps.poll.bean.extend.AnswerVM;
import com.briup.apps.poll.dao.AnswerMapper;
import com.briup.apps.poll.dao.extend.AnswerVMMapper;
import com.briup.apps.poll.service.IAnswerService;

@Service
public class AnswerServiceImpl implements IAnswerService {
	@Autowired
	private AnswerMapper answerMapper;
	@Autowired
    private AnswerVMMapper  answerVMMapper;
	@Override
	public List<Answer> findAll() throws Exception {
		// TODO Auto-generated method stub
		AnswerExample example = new AnswerExample();
		return answerMapper.selectByExample(example);
	}
	
	@Override
	public List<AnswerVM> findAllAnswerVM() throws Exception {
		// TODO Auto-generated method stub
		return answerVMMapper.selectAll();
	}
	
	@Override
	public Answer findById(long id) throws Exception {
		// TODO Auto-generated method stub
		return answerMapper.selectByPrimaryKey(id);
	}

	
	
	
	
	@Override
	public List<Answer> querry(String keywords) throws Exception {
		// TODO Auto-generated method stub
		AnswerExample example = new AnswerExample();
		// 添加一个条件name属性中包含keywords关键字
		example.createCriteria().andCheckesLike(keywords);
		return answerMapper.selectByExample(example);
	}

	@Override
	public void saveOrUpdate(Answer answer) throws Exception {
		// TODO Auto-generated method stub
		if (answer.getId() != null) {
			answerMapper.updateByPrimaryKey(answer);
		} else {
			answerMapper.insert(answer);
		}
	}
	@Override
	public void deleteById(long id) throws Exception {
		// TODO Auto-generated method stub
		answerMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void batchDelete(List<Long> ids) throws Exception {
		// TODO Auto-generated method stub
      
	}
  
	@Override
	public void saveOrUpdateAnswerVM(AnswerVM answerVM) throws Exception {
		// TODO Auto-generated method stub
		
	}


}
	

