package com.briup.apps.poll.web.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Options;
import com.briup.apps.poll.service.IOptionsService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/options")
@Api(description="选项相关接口")
public class OptionsController {
	@Autowired
	private IOptionsService optionsService;
	@GetMapping("findALLOptions")
	public MsgResponse findAllCourse(){
		try {
			List<Options> list=optionsService.findAll();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}

	}
	@GetMapping("findById")
	public  MsgResponse findById(long id){
		try {
			Options course=optionsService.findById(id);
			return MsgResponse.success("success", course);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@GetMapping("findByKeyWords")
	public MsgResponse findByKeyWords(String keyWords){
		try {
			List<Options> list=optionsService.query(keyWords);
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@GetMapping("saveOrUpdate")
	public MsgResponse saveOrUpdate(Options options){
		try {
			optionsService.saveOrUpdate(options);
			return MsgResponse.success("success", options);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@GetMapping("deleteById")
	public MsgResponse deleteById(long id){
		try {
			optionsService.deleteById(id);
			return MsgResponse.success("success", "删除成功！");
		} catch (Exception e) {
			// TODO: handle exception	
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@GetMapping("batchDelete")
	public MsgResponse batchDelete(Long[] ids){
		try {
			optionsService.batchDelete(ids);
			return MsgResponse.success("success", "批量删除成功！");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
}