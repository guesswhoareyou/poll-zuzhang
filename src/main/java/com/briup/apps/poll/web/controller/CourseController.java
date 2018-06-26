package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Course;
import com.briup.apps.poll.service.ICourseService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;

@Api(description = "课程相关接口")
@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private ICourseService courseService;

	@GetMapping("findAllCourse")
	public MsgResponse findAllCourse() {
		try {
			List<Course> list = courseService.findAll();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@GetMapping("findById")
	public MsgResponse findById(@RequestParam long id ) {
		try {
			 Course course = courseService.findById(id);
			return MsgResponse.success("success", course);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	} 
	
	@GetMapping("findBykeywords")
	public MsgResponse query( @RequestParam String keywords){
		try{
			List<Course> list = courseService.query(keywords);
			return MsgResponse.success("success", list);
		}catch(Exception e){
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@GetMapping("saveOrUpdate")
	public  MsgResponse saveOrUpdate(Course course ){
		
		try{
			courseService.saveOrUpdate(course);
			return MsgResponse.success("success", course);
		}catch(Exception e){
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
	}
}
	@PostMapping("batchDelete")
	public MsgResponse batchDelete(@RequestParam List<Long> ids){
		try{
			courseService.batchDelete(ids);
			return MsgResponse.success("success", ids);
		}catch(Exception e){
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}
