package com.briup.apps.poll.web.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.briup.apps.poll.bean.Question;
import com.briup.apps.poll.bean.extend.QuestionVM;
import com.briup.apps.poll.service.IQuestionService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="题库相关接口")
@RestController
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	private IQuestionService questionService;
	//查询所有
	@ApiOperation(value = "查询所有问题.",notes="单表")
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
	
	//查询所有多表
	@ApiOperation(value = "查询问题，选项.",notes="多表")
	@GetMapping("findAllQuestionVM")
	public MsgResponse findAllQuestionVM(){
		try {
			List<QuestionVM> list=questionService.findAllQuestionVM();
			return MsgResponse.success("success",list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	//保存或更新
	@ApiOperation(value = "保存或修改问题.")
	@PostMapping("saveOrUpdateQuestion")
	public MsgResponse saveOrUpdateQuestion(QuestionVM questionvm){
		try {
			questionService.saveOrUpdateQuestionVM(questionvm);
			return MsgResponse.success("保存成功", null);
		} catch (Exception e) {
			return MsgResponse.error(e.getMessage());
		}
		
	}
	
	
	//单个Id删除
	@ApiOperation(value = "通过ID删除.")
	@GetMapping("deleteQuestionById")
	public MsgResponse deleteQuestionById(long id){
		try {
			 questionService.deleteById(id);
			 return MsgResponse.success("删除成功",null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
		
	}



	//id查询
	@ApiOperation(value = "ID查询.")
	@GetMapping("findByIdQuestionVM")
	public MsgResponse findByIdQuestionVM(long id){
		try {
			QuestionVM questionvm=questionService.findById(id);
			return MsgResponse.success("查询成功",questionvm);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	//批量删除 post
	@ApiOperation(value = "批量删除")
	@PostMapping("batchQuestionDelete")
	public MsgResponse batchQuestionDelete(long[] ids){
		try {
			 questionService.batchDelete(ids);
			 return MsgResponse.success("批量删除成功",null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
		
	}
	
	
	//查询关键字
	@ApiOperation(value = "关键字查询(未实现)")
	@GetMapping("queryQuestion")
	public MsgResponse queryQuestion(String keywords){
		try {
			List<Question> list=questionService.queryQuestion(keywords);
			return MsgResponse.success("success",list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	

}

