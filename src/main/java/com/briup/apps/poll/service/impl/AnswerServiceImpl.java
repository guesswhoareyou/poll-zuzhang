package com.briup.apps.poll.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.briup.apps.poll.bean.Answer;
import com.briup.apps.poll.bean.AnswerExample;
import com.briup.apps.poll.dao.AnswerMapper;
import com.briup.apps.poll.service.IAnswerService;
@Service
public class AnswerServiceImpl implements IAnswerService {
	@Autowired
	private AnswerMapper AnswerMapper;
	
	@Override
	public void saveOrUpdate(Answer Answer) throws Exception {
		if(Answer.getId()!=null){
			AnswerMapper.updateByPrimaryKey(Answer);
		} else {
			AnswerMapper.insert(Answer);
		}
	}

	@Override
	public List<Answer> findAnswerBySurveyId(long id) throws Exception {
		AnswerExample example = new AnswerExample();
		example.createCriteria().andSurveyIdEqualTo(id);
		return AnswerMapper.selectByExample(example);
	}

	@Override
	public Answer findById(long id) throws Exception {
		return AnswerMapper.selectByPrimaryKey(id);
	}

}



	

