package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Questionnaire;
import com.briup.apps.poll.bean.QuestionnaireQuestion;
import com.briup.apps.poll.bean.extend.QuestionnaireQuestionVM;
import com.briup.apps.poll.service.IQuestionnaireQuestionService;
import com.briup.apps.poll.service.IQuestionnaireService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(description="问卷-问题相关接口")
@RestController
@RequestMapping("/questionnaireQuestion")
public class QuestionnaireQuestionController {
	@Autowired
	private IQuestionnaireQuestionService questionnaireQuestionService;
	@Autowired 
	private IQuestionnaireService questionnaireService;
	
	
	@PostMapping("saveOrUpdateQuestionnaire")
	@ApiOperation(value="保存或修改问卷信息",notes="如果问卷参数中包含id执行操作,执行修改操作")
	public MsgResponse saveOrUpdateQuestionnaire(Questionnaire questionnaire,long[] questionIds){
		try{
			questionnaireService.saveOrUpdate(questionnaire,questionIds);
			return MsgResponse.success("保存或修改成功", null);
		}catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	
	
	
	
	@ApiOperation(value="查询所有数据",notes="不需要输入")
	@GetMapping("findAllQuestionnaireQuestion")
	public MsgResponse findAllQuestionnaireQuestion(){
		try {
			List<QuestionnaireQuestion> list = questionnaireQuestionService.findAll();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value = "查询所有问卷和问题数据", notes = "不需要输入")
	@GetMapping("findAllQQ")
	public MsgResponse findAllQQ() {
		try {
			List<QuestionnaireQuestionVM> list = questionnaireQuestionService.findAllQuestionnaireQuestionVM();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="根据id查询数据",notes="需要输入id")
	@GetMapping("findById")
	public MsgResponse findById(@RequestParam long id){
		try {
			QuestionnaireQuestion qq = questionnaireQuestionService.findById(id);
			return MsgResponse.success("success", qq);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="根据id查询所有问卷和问题数据",notes="需要输入id")
	@GetMapping("findQQById")
	public MsgResponse findQQById(@RequestParam long id){
		try {
			QuestionnaireQuestionVM qq = questionnaireQuestionService.selectById(id);
			return MsgResponse.success("success", qq);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
		
	@ApiOperation(value="根据id删除数据",notes="需要输入id")
	@GetMapping("deleteById")
	public MsgResponse deleteById(long id){
		try {
			questionnaireQuestionService.deleteById(id);
			return MsgResponse.success("success", "删除成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="插入或更新数据",notes="插入不需要输入id，更新需要输入id")
	@PostMapping("saveOrUpdate")
	public MsgResponse saveOrUpdate(QuestionnaireQuestion qq){
		try {
			questionnaireQuestionService.saveOrUpdate(qq);
			return MsgResponse.success("succss", "更新成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="批量删除数据",notes="输入多个id")
	@GetMapping("batchDelete")
	public MsgResponse batchDelete(long[] ids){
		try {
			questionnaireQuestionService.batchDelete(ids);
			return MsgResponse.success("success", "批量删除成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
}
