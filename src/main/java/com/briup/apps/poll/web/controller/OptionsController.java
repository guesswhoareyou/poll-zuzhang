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
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/options")
@Api(description="选项相关接口")
public class OptionsController {
	@Autowired
	private IOptionsService optionsService;
	@GetMapping("findALLOptions")
	@ApiOperation(value="查询所有数据",notes="不需要输入")
	public MsgResponse findAllOptions(){
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
	@ApiOperation(value="根据id查询数据",notes="需要输入id")
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
	@ApiOperation(value="关键字查询")
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
	@ApiOperation(value="插入或更新数据",notes="插入不需要输入id，更新需要输入id")
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
	@ApiOperation(value="根据id删除数据",notes="需要输入id")
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
	@ApiOperation(value="批量删除数据",notes="输入多个id")
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