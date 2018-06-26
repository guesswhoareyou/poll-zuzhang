package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Clazz;
import com.briup.apps.poll.service.IClazzService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;

@Api(description="班级相关接口")
@RestController
@RequestMapping("/clazz")
public class ClazzController {
	@Autowired
	private IClazzService clazzService;
	@GetMapping("findAllClazz")
	public MsgResponse findAllCourse(){
		try{
			List<Clazz> list=clazzService.findAll();
			return MsgResponse.success("success", list);
		}catch(Exception e){
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
			
	}
	
	@PostMapping("findClazzById")
	public MsgResponse findClazzById(@RequestParam long id){
		//@Requestparam需要初始化默认值
		try{
			Clazz clazz=clazzService.findById(id);
			return MsgResponse.success("success",clazz );
			//return course;
		}catch(Exception e){
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@PostMapping("queryClazz")
	public MsgResponse queryCourse(@RequestParam String Keywords){
		try{
			List<Clazz> list=clazzService.query(Keywords);
			return MsgResponse.success("success", list);
		}catch(Exception e){
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
		
	}
	@PostMapping("saveOrUpdateClazz")
	public MsgResponse saveOrUpdateCourse(Clazz clazz){
		try{
			clazzService.saveOrUpdate(clazz);
			return MsgResponse.success("success",clazz );
		}catch(Exception e){
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@PostMapping("deleteClazzById")
	public MsgResponse deleteCourseById(@RequestParam long id){
		try{
			clazzService.deleteById(id);
			return MsgResponse.success("success", id);
		}catch(Exception e){
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@GetMapping("batchDeleteClazz")
	public MsgResponse batchDeleteClazz(List<Long> ids){
		try{
			clazzService.batchDelete(ids);
			return MsgResponse.success("success", ids);
		}catch(Exception e){
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}
