package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Question;

public interface IQuestionService {
    /**
     * 查询所有
     * */
	List<Question> findAll() throws Exception;
    /**
     * 通过id查询
     * */
    Question findById(long id) throws Exception;
    /**
     * 关键字查询
     * */
    List<Question> query(String keywords) throws Exception;
    /**
     * 保存或更新
     * */
    void saveOrUpdate(Question question) throws Exception;
    /**
     * 通过ID删除
     * */
    void deleteById(long id) throws Exception;
    /**
     * 批量删除
     * */
    void batchDelete(List<Long> ids) throws Exception;
    
    
    

}
