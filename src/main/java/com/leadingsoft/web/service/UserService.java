package com.leadingsoft.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leadingsoft.common.toolkit.MD5Utils;
import com.leadingsoft.core.dto.BootTablePage;
import com.leadingsoft.core.mapper.KUserDao;
import com.leadingsoft.core.model.KUser;

@Service
public class UserService {

	@Autowired
	private KUserDao kUserDao;
		
	/**
	 * @Title login
	 * @Description 登陆
	 * @param kUser 用户信息对象
	 * @return
	 * @return KUser
	 */
	public KUser login(KUser kUser){		
		KUser template = new KUser();
		template.setDelFlag(1);
		template.setuAccount(kUser.getuAccount());
		KUser user = kUserDao.templateOne(template);
		if (null != user){
			if (user.getuPassword().equals(MD5Utils.Encrypt(kUser.getuPassword(), true))){
				return user;
			}
			return null;
		}
		return null;
	}
	
	/**
	 * @Title isAdmin
	 * @Description 用户是否为管理员
	 * @param uId 用户ID
	 * @return
	 * @return boolean
	 */
	public boolean isAdmin(Integer uId){
		KUser kUser = kUserDao.unique(uId);
		if ("admin".equals(kUser.getuAccount())){
			return true;
		}else {
			return false;	
		}
	}
	
	/**
	 * @Title getList
	 * @Description 获取用户分页列表
	 * @param start 其实行数
	 * @param size 每页显示行数
	 * @return 
	 * @return BootTablePage
	 */
	public BootTablePage getList(Integer start, Integer size){
		KUser template = new KUser();
		template.setDelFlag(1);
		List<KUser> kUserList = kUserDao.template(template, start, size);
		long allCount = kUserDao.templateCount(template);
		BootTablePage bootTablePage = new BootTablePage();
		bootTablePage.setRows(kUserList);
		bootTablePage.setTotal(allCount);
		return bootTablePage;
	}
	
	/**
	 * @Title delete
	 * @Description 删除用户
	 * @param uId 用户ID
	 * @return void
	 */
	public void delete(Integer uId){
		KUser kUser = kUserDao.unique(uId);
		kUser.setDelFlag(0);
		kUserDao.updateById(kUser);
	}
	
	/**
	 * @Title insert
	 * @Description 插入一个用户
	 * @param kUser
	 * @return void
	 */
	public void insert(KUser kUser){	
	}	
}