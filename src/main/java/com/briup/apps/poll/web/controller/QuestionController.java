package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Question;
import com.briup.apps.poll.service.IQuestionService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;

@Api(description="问卷相关接口")
@RestController
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	private IQuestionService questionService;
	//查询所有
	@GetMapping("findAllQuestion")
	public MsgResponse findAllQuestion(){
		try {
			List<Question> list=questionService.findAll();
			return MsgResponse.success("success",list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	//id查询
	@GetMapping("findByIdQuestion")
	public MsgResponse findByIdQuestion(long id){
		try {
			questionService.deleteById(id);
			return MsgResponse.success("success",id);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	//查询关键字
	@GetMapping("queryQuestion")
	public MsgResponse queryQuestion(String keywords){
		try {
			List<Question> list=questionService.query(keywords);
			return MsgResponse.success("success",list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	//保存或更新
	@PostMapping("saveOrUpdateQuestion")
	public MsgResponse saveOrUpdateQuestion(Question question){
		try {
			 questionService.saveOrUpdate(question);
			 return MsgResponse.success("success",question);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
		
	}
	
	//Id删除
	@GetMapping("deleteQuestionById")
	public MsgResponse deleteQuestionById(long id){
		try {
			 questionService.deleteById(id);
			 return MsgResponse.success("success",id);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
		
	}
	
	//批量删除
	@GetMapping("batchQuestionDelete")
	public MsgResponse batchQuestionDelete( long ids){
		try {
			 questionService.deleteById(ids);
			 return MsgResponse.success("success",ids);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
		
	}

}
