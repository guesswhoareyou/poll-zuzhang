package com.briup.apps.poll.dao.extend; 

import java.util.List;

import com.briup.apps.poll.bean.Question;
import com.briup.apps.poll.bean.extend.QuestionVM;

public interface QuestionVMMapper {
	
	List<QuestionVM> selectAll();

    QuestionVM selectById(long id) ;
	
    List<Question> queryQuestion(String keywords);

}
