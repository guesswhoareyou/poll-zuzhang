package com.briup.apps.poll.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Options;
import com.briup.apps.poll.service.Test;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/test")
@Api(description="test")
public class TestController {
	@Autowired
	private Test test;
	@PostMapping("saveOptions")
	public MsgResponse save(Options options) {
		try {
			test.saveOptions(options);
			return MsgResponse.success("success", null);
		} catch (Exception e) {
			return MsgResponse.error(e.getMessage());
		}
		
	}
}
