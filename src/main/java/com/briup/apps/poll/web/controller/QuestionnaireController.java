package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.briup.apps.poll.bean.Questionnaire;
import com.briup.apps.poll.service.IQuestionnaireService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;

@Api(description="问卷问题相关接口")
@RequestMapping("/questionnaire")
@RestController
public class QuestionnaireController {
	@Autowired
	private IQuestionnaireService questionnaireService;
	
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
	@GetMapping("findById")
	public MsgResponse findById (@RequestParam long id ){
		try {
			Questionnaire questionnaire = questionnaireService.findById(id);
			return MsgResponse.success("success",questionnaire);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	} 
	
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

