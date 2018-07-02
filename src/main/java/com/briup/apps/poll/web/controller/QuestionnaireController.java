package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.briup.apps.poll.bean.Questionnaire;
import com.briup.apps.poll.bean.extend.QuestionnaireVM;
import com.briup.apps.poll.service.IQuestionnaireService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="问卷相关接口")
@RequestMapping("/questionnaire")
@RestController
public class QuestionnaireController {
	@Autowired
	private IQuestionnaireService questionnaireService;
	
	
	@ApiOperation(value="通过id查找问卷", notes="问卷下具有问题信息")
	@GetMapping("findQuestionnaireVMById")
	public MsgResponse findQuestionnaireVMById (long id ){
		try {
			QuestionnaireVM questionnaireVM = questionnaireService.findById(id);
			return MsgResponse.success("success",questionnaireVM);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	} 
@ApiOperation(value="查询所有问卷", notes="单表")
	@GetMapping("findAllQuestionnaire")
	public MsgResponse findAllQuestionnaire(){
		try{
			List<Questionnaire> list = questionnaireService.findAll();
			return MsgResponse.success("success", list);
		}catch (Exception e){
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

@ApiOperation(value="通过关键字查找问卷", notes="单表")
	@GetMapping("findBykeywords")
	public MsgResponse query( @RequestParam String keywords){
		try{
			List<Questionnaire> list = questionnaireService.Query(keywords);
			return MsgResponse.success("success", list);
		}catch(Exception e){
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
@ApiOperation(value="保存或更新问卷", notes="单表")
	@GetMapping("saveOrUpdate")
	public  MsgResponse saveOrUpdate(Questionnaire questionnaire ){
		
		try{
			questionnaireService.saveOrUpdate(questionnaire);
			return MsgResponse.success("success", questionnaire);
		}catch(Exception e){
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
	}
	}
@ApiOperation(value="通过id批量删除问卷", notes="单表")
		@PostMapping("batchDelete")
		public MsgResponse batchDelete(@RequestParam List<Long> ids){
			try{
				questionnaireService.batchDelete(ids);
				return MsgResponse.success("success", ids);
			}catch(Exception e){
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
		}
}

