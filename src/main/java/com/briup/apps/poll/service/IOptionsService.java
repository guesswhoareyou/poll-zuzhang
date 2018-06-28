package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Options;
import com.briup.apps.poll.bean.extend.OptionsVM;

public interface IOptionsService {

	List<Options> findAll() throws Exception;

	Options findById(long id) throws Exception;

	List<Options> query(String keyWords) throws Exception;

	void saveOrUpdate(Options options) throws Exception;

	void deleteById(long id) throws Exception;

	void batchDelete(Long[] ids) throws Exception;

	List<Options> findByKeyWords(String keyWords) throws Exception;
	
	List<OptionsVM> findAllOptionsVM() throws Exception;





}
