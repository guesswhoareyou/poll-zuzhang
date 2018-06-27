package com.briup.apps.poll.web.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Answer;
import com.briup.apps.poll.bean.extend.AnswerVM;
import com.briup.apps.poll.service.IAnswerService;
import com.briup.apps.poll.util.MsgResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "答题相关接口")
@RestController
@RequestMapping("/answer")
public class AnswerController {
	@Autowired
	private IAnswerService answerService;
	
	@ApiOperation(value="查询答题页面",notes="答题页面以及携带的survey信息")
	@GetMapping("findAllVM")
	 public MsgResponse findAllVM(){
		try {
			List<AnswerVM> list=answerService.findAllAnswerVM();
			return  MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error( e.getMessage());
			// TODO: handle exception
		}
		
	}
	@ApiOperation(value="查询答题页面",notes="单表")
	@GetMapping("findAllAnswer")
	public MsgResponse findAllAnswer() {
		try {
			List<Answer> list = answerService.findAll();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation("根据ID查询答题信息")
	@GetMapping("findById")
	public MsgResponse findById(@RequestParam long id) {
		try {
			Answer answer = answerService.findById(id);
			return MsgResponse.success("success", answer);
		} catch (Exception e) {
			e.printStackTrace();
			//返回失败信息
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation("通过关键字查询答题信息")
	@GetMapping("findByKeywords")
	public MsgResponse quary(@RequestParam String Keywords) {
		try {
			List<Answer> list = answerService.querry(Keywords);
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="保存或修改答题页面",notes="当id不为空时表示修改，否则表示更新")
	@PostMapping("saveOrUpdateAnswer")
	public MsgResponse saveOrUpdateAnswer(Answer answerVM){
		try {
			answerService.saveOrUpdate(answerVM);
			return MsgResponse.success("保存成功",null);
		} catch (Exception e){
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
			// TODO: handle exception
		}
		 
	}
	
	@ApiOperation("如果ID不为空  则更新答题信息")
	@GetMapping("saveOrupdate")
	public MsgResponse saveOrupdate(Answer answer) {
		try {
			answerService.saveOrUpdate(answer);
			return MsgResponse.success("success", answer);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation("通过ID删除答题信息")
	@GetMapping("deleteById")
	public MsgResponse deleteById(@RequestParam long id) {
		try {
			answerService.deleteById(id);
			return MsgResponse.success("success", id);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation("批量删除答题信息")
	@GetMapping("batchDelete")
	public MsgResponse batchDelete(@RequestParam List<Long> ids) {
		try {
			answerService.batchDelete(ids);
			return MsgResponse.success("success", ids);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
}
