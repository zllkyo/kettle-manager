package com.leadingsoft.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leadingsoft.common.toolkit.Constant;
import com.leadingsoft.core.dto.BootTablePage;
import com.leadingsoft.core.model.KUser;
import com.leadingsoft.web.service.JobMonitorService;
import com.leadingsoft.web.utils.JsonUtils;

@RestController
@RequestMapping("/job/monitor/")
public class JobMonitorController {
	
	@Autowired
	private JobMonitorService jobMonitorService;
	
	@RequestMapping("getList.shtml")
	public String getList(Integer offset, Integer limit, HttpServletRequest request){
		KUser kUser = (KUser) request.getSession().getAttribute(Constant.SESSION_ID);
		BootTablePage list = jobMonitorService.getList(offset, limit, kUser.getuId());				
		return JsonUtils.objectToJson(list);
	}
	
	@RequestMapping("getAllMonitorJob.shtml")
	public String getAllMonitorJob(HttpServletRequest request){
		KUser kUser = (KUser) request.getSession().getAttribute(Constant.SESSION_ID);
		return JsonUtils.objectToJson(jobMonitorService.getAllMonitorJob(kUser.getuId()));
	}
	
	@RequestMapping("getAllSuccess.shtml")
	public String getAllSuccess(HttpServletRequest request){
		KUser kUser = (KUser) request.getSession().getAttribute(Constant.SESSION_ID);
		return JsonUtils.objectToJson(jobMonitorService.getAllSuccess(kUser.getuId()));
	}
	
	@RequestMapping("getAllFail.shtml")
	public String getAllFail(HttpServletRequest request){
		KUser kUser = (KUser) request.getSession().getAttribute(Constant.SESSION_ID);
		return JsonUtils.objectToJson(jobMonitorService.getAllFail(kUser.getuId()));
	}
}
