package com.briup.apps.poll.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Options;
import com.briup.apps.poll.dao.OptionsMapper;
import com.briup.apps.poll.service.Test;
@Service
public class TestImpl implements Test{
	@Autowired
	private OptionsMapper mapper;
	@Override
	public void saveOptions(Options options) throws Exception {
		mapper.insert(options);
	}

}
