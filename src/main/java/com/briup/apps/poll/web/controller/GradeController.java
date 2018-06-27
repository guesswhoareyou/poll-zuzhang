package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Grade;
import com.briup.apps.poll.bean.extend.GradeVM;
import com.briup.apps.poll.service.IGradeService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;

@Api(description="年级相关接口")
@RestController
@RequestMapping("/grade")
public class GradeController {
	@Autowired
	private IGradeService gradeService;
	@GetMapping("findAllGrade")
	public MsgResponse findAllGrade(){
		try{
			List<Grade> list=gradeService.findAll();
			return MsgResponse.success("success", list);
		}catch(Exception e){
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}	
	}
	
	@GetMapping("findAllGradeVM")
	public MsgResponse findAllGradeVM(){
		try{
			List<GradeVM> list=gradeService.findAllGradeVM();
			return MsgResponse.success("success", list);
		}catch(Exception e){
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
			
	}
	
	@PostMapping("findGradeById")
	public MsgResponse findGradeById(@RequestParam long id){
		//@Requestparam需要初始化默认值
		try{
			Grade grade=gradeService.findById(id);
			return MsgResponse.success("success",grade );
			//return course;
		}catch(Exception e){
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@PostMapping("queryGrade")
	public MsgResponse queryGrade(@RequestParam String Keywords){
		try{
			List<Grade> list=gradeService.query(Keywords);
			return MsgResponse.success("success", list);
		}catch(Exception e){
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
		
	}
	@PostMapping("saveOrUpdateGrade")
	public MsgResponse saveOrUpdateGrade(Grade grade){
		try{
			gradeService.saveOrUpdate(grade);
			return MsgResponse.success("success",grade );
		}catch(Exception e){
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@PostMapping("deleteGradeById")
	public MsgResponse deleteGradeById(@RequestParam long id){
		try{
			gradeService.deleteById(id);
			return MsgResponse.success("success", id);
		}catch(Exception e){
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@PostMapping("batchDeleteGrade")
	public MsgResponse batchDeleteGrade(List<Long> ids){
		try{
			gradeService.batchDelete(ids);
			return MsgResponse.success("success", ids);
		}catch(Exception e){
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
		
}
