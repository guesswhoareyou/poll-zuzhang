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
	
	@ApiOperation (value="保存或修改问卷信息",
			notes="如果问卷参数中包含id执行更新操作，否则执行修改操作")
	@PostMapping("saveOrUpdateQuestionnaire")
	public MsgResponse saveOrUpdateQuestionnaire(Questionnaire questionnaire,long[] questionIds){
		try{
			questionnaireService.saveOrUpdate(questionnaire, questionIds);
			return MsgResponse.success("保存或修改成功", null);
		}catch (Exception e){
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}	
	}
	
	
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


    @ApiOperation(value="根据ID删除问卷信息", notes="删除问卷的同时会把问卷和问题的关系解除掉，而问题保留")
	@GetMapping("deleteQuestionnaireById")
	public  MsgResponse deleteQuestionnaireById(long id){
    	try{
    		questionnaireService.deleteById(id);
    		return MsgResponse.success("删除成功", null);
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
