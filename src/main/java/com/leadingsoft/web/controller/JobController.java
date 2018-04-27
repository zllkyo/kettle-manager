package com.leadingsoft.web.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.leadingsoft.common.toolkit.Constant;
import com.leadingsoft.core.dto.BootTablePage;
import com.leadingsoft.core.dto.ResultDto;
import com.leadingsoft.core.model.KJob;
import com.leadingsoft.core.model.KUser;
import com.leadingsoft.web.service.JobService;
import com.leadingsoft.web.utils.JsonUtils;


@RestController
@RequestMapping("/job/")
public class JobController {

	@Autowired
	private JobService jobService;
	
	
	@RequestMapping("getSimpleList.shtml")
	public String getSimpleList(HttpServletRequest request){
		KUser kUser = (KUser) request.getSession().getAttribute(Constant.SESSION_ID);
		return JsonUtils.objectToJson(jobService.getList(kUser.getuId()));
	}
	
	
	@RequestMapping("getList.shtml")
	public String getList(Integer offset, Integer limit, HttpServletRequest request){
		KUser kUser = (KUser) request.getSession().getAttribute(Constant.SESSION_ID);
		BootTablePage list = jobService.getList(offset, limit, kUser.getuId());				
		return JsonUtils.objectToJson(list);
	}
	
	@RequestMapping("delete.shtml")
	public String delete(Integer jobId){
		jobService.delete(jobId);
		return ResultDto.success();
	}	
	
	@RequestMapping("uploadJob.shtml")
	public String uploadJob(MultipartFile jobFile, HttpServletRequest request){
		KUser kUser = (KUser) request.getSession().getAttribute(Constant.SESSION_ID);
		try {
			String saveFilePath = jobService.saveFile(kUser.getuId(), jobFile);
			return ResultDto.success(saveFilePath);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}	
	}
	
	
	@RequestMapping("insert.shtml")
	public String insert(KJob kJob, String customerQuarz, HttpServletRequest request){
		KUser kUser = (KUser) request.getSession().getAttribute(Constant.SESSION_ID);
		Integer uId = kUser.getuId();		
		if (jobService.check(kJob.getJobRepositoryId(), kJob.getJobPath(), uId)){
			try {
				jobService.insert(kJob, uId, customerQuarz);
				return ResultDto.success();
			} catch (SQLException e) {
				e.printStackTrace();
				return ResultDto.fail("添加作业失败");
			}				
		}else{
			return ResultDto.fail("该作业已经添加过了");
		}
	}
	
	
	@RequestMapping("getJob.shtml")
	public String getJob(Integer jobId){
		return ResultDto.success(jobService.getJob(jobId));
	}
	
	@RequestMapping("update.shtml")
	public String update(KJob kJob, String customerQuarz, HttpServletRequest request){
		KUser kUser = (KUser) request.getSession().getAttribute(Constant.SESSION_ID);
		try{
			jobService.update(kJob, customerQuarz, kUser.getuId());	
			return ResultDto.success();	
		}catch(Exception e){
			return ResultDto.success(e.toString());
		}	
	}
	
	@RequestMapping("start.shtml")
	public String start(Integer jobId){
		jobService.start(jobId);
		return ResultDto.success();
	}
	
	@RequestMapping("stop.shtml")
	public String stop(Integer jobId){
		jobService.stop(jobId);
		return ResultDto.success();
	}
	
}
