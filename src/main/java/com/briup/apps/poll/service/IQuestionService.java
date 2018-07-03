package com.briup.apps.poll.service;

import java.util.List;


import com.briup.apps.poll.bean.Question;
import com.briup.apps.poll.bean.extend.QuestionVM;

public interface IQuestionService {
    /**
     * 查询所有
     * */
	List<Question> findAll() throws Exception;
	List<QuestionVM> findAllQuestionVM() throws Exception; 
    /**
     * 保存或更新
     * */
	void saveOrUpdateQuestionVM(QuestionVM questionvm) throws Exception;
    /**
     * 通过ID删除
     * */
    void deleteById(long id) throws Exception;
    /**
     * 通过id查询
     * */
    QuestionVM findById(long id) throws Exception; 
    /**
     * 关键字查询
     * */
    List<Question> queryQuestion(String keywords) throws Exception; 
    /**
     * 批量删除
     * */
    void batchDelete(long[] ids) throws Exception;

}
