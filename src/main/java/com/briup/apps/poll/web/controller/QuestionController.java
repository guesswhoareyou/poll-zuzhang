package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Question;
import com.briup.apps.poll.bean.extend.QuestionVM;
import com.briup.apps.poll.service.IQuestionService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;

@Api(description = "问题相关接口")
@RestController
@RequestMapping("/question")
public class QuestionController {
@Autowired
private IQuestionService questionService;

@GetMapping("findAllQuestion")
public MsgResponse findAllQuestion() {
	try {
		List<Question> list = questionService.findAll();
		return MsgResponse.success("success", list);
	} catch (Exception e) {
		e.printStackTrace();
		return MsgResponse.error(e.getMessage());
	}
}
@GetMapping("findAllQuestionVM")
public MsgResponse findAllQuestionVM() {
	try {
		List<QuestionVM> list = questionService.findAllVM();
		return MsgResponse.success("success", list);
	} catch (Exception e) {
		e.printStackTrace();
		return MsgResponse.error(e.getMessage());
	}
}
}
