package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Survey;
import com.briup.apps.poll.bean.extend.SurveyVM;
import com.briup.apps.poll.service.ISurveyService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
	@Api(description = "课调相关接口")
	@RestController
	@RequestMapping("/Survey")
	public class SurveyController {

		@Autowired
		private ISurveyService surveyService;
		@ApiOperation(value="保存或修改调查",
				notes="当ID不为空表示修改，否则表示更新")
		@PostMapping("saveOrUpdateSurveyVM")
		public MsgResponse saveOrUpdateSurveyVM(SurveyVM surveyVM){
			try {
		        surveyService.saveOrUpdateSurveyVM(surveyVM);
				return MsgResponse.success("success", surveyVM);
			} catch (Exception e) {
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
		}
		@ApiOperation(value="保存或修改调查")
		@PostMapping("saveOrUpdateSurvey")
		public MsgResponse saveOrUpdateSurvey(Survey survey){
			try {
		        surveyService.saveOrUpdate(survey);
				return MsgResponse.success("success", survey);
			} catch (Exception e) {
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
		}
        @ApiOperation(value="查询所有的课调信息",notes="单表")
		@GetMapping("findAllSurvey")
		public MsgResponse findAllSurvey() {
			try {
				List<Survey> list = surveyService.findAll();
				return MsgResponse.success("success", list);
			} catch (Exception e) {
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
		}
		@ApiOperation(value="查询所有的课调信息",notes="每个课调信息中包含该课调班级，题目等信息")
		@GetMapping("fidAllSurveyVM")
		public MsgResponse findAllSurveyVM(){
			try {
				List<SurveyVM> list=surveyService.findAllSurveyVM();
				return MsgResponse.success("success", list);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
		}
	}
	
	

