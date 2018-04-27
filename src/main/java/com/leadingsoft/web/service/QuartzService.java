package com.leadingsoft.web.service;

import java.util.ArrayList;
import java.util.List;

import org.pentaho.di.core.exception.KettleException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leadingsoft.core.dto.BootTablePage;
import com.leadingsoft.core.mapper.KQuartzDao;
import com.leadingsoft.core.model.KQuartz;

@Service
public class QuartzService {

	
	@Autowired
	private KQuartzDao kQuartzDao; 
	
	/**
	 * @Title getList
	 * @Description 获取定时策略列表
	 * @return 
	 * @throws KettleException
	 * @return List<KQuartz>
	 */
	public List<KQuartz> getList(Integer uId){
		List<KQuartz> resultList = new ArrayList<KQuartz>();
		KQuartz kQuartz = new KQuartz();
		kQuartz.setDelFlag(1);
		kQuartz.setAddUser(uId);
		resultList.addAll(kQuartzDao.template(kQuartz));		
		return resultList;
	}
	
	/**
	 * @Title getList
	 * @Description 获取分页列表
	 * @param start 起始行数
	 * @param size 每页行数
	 * @param uId 用户ID
	 * @return
	 * @throws KettleException
	 * @return BootTablePage
	 */
	public BootTablePage getList(Integer start, Integer size, Integer uId){
		KQuartz kQuartz = new KQuartz();
		kQuartz.setDelFlag(1);
		kQuartz.setAddUser(uId);
		List<KQuartz> kQuartzList = kQuartzDao.template(kQuartz, start, size);
		long allCount = kQuartzDao.templateCount(kQuartz);
		BootTablePage bootTablePage = new BootTablePage();
		bootTablePage.setRows(kQuartzList);
		bootTablePage.setTotal(allCount);
		return bootTablePage;
	}	
}