package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Grade;
import com.briup.apps.poll.bean.GradeExample;
import com.briup.apps.poll.bean.extend.GradeVM;
import com.briup.apps.poll.dao.GradeMapper;
import com.briup.apps.poll.dao.extend.GradeVMMapper;
import com.briup.apps.poll.service.IGradeService;

@Service
public class GradeServiceImpl implements IGradeService {
	@Autowired
	private GradeMapper gradeMapper;
	@Autowired
	private GradeVMMapper gradeVMMapper;
	// @Override
	// public List<Grade> findAll() throws Exception {
	// // TODO Auto-generated method stub
	// GradeExample example=new GradeExample();
	// return gradeMapper.selectByExample(example);
	// }
	//
	// @Override
	// public Grade findById(long id) throws Exception {
	// // TODO Auto-generated method stub
	// return gradeMapper.selectByPrimaryKey(id);
	// }

	// @Override
	// public List<Grade> query(String Keywords) throws Exception {
	// // TODO Auto-generated method stub
	// GradeExample example=new GradeExample();
	// example.createCriteria().andNameLike(Keywords);
	// return gradeMapper.selectByExample(example);
	// }
	/**
	 * 保存或更新年级信息，id为空时保存信息，id不为空时修改信息
	 */
	@Override
	public void saveOrUpdate(Grade grade) throws Exception {
		if (grade.getId() != null) {
			gradeMapper.updateByPrimaryKey(grade);
		} else {
			gradeMapper.insert(grade);
		}
	}
	/**
	 *  根据id删除年级信息，删除时会删除包含的班级信息
	 */
	@Override
	public void deleteById(long id) throws Exception {
		gradeMapper.deleteByPrimaryKey(id);
	}
	/**
	 *  根据id批量删除年级信息，删除时会删除包含的班级信息
	 */
	@Override
	public void batchDelete(long[] ids) throws Exception {
		for (long id : ids) {
			gradeMapper.deleteByPrimaryKey(id);
		}
	}
	/**
	 * 查询所有年级信息，并包含所属学校信息
	 */
	@Override
	public List<GradeVM> findAllGradeVM() throws Exception {
		return gradeVMMapper.selectAll();
	}
	/**
	 * 根据id查询年级信息，包含所属学校信息
	 */
	@Override
	public GradeVM selectById(long id) throws Exception {
		return gradeVMMapper.selectById(id);
	}
	/**
	 * 根据name属性关键字查询年级信息，包含所属学校信息
	 */
	@Override
	public List<GradeVM> selectByKeyWords(String keyWords) {
		return gradeVMMapper.selectByKeyWords(keyWords);
	}

}
