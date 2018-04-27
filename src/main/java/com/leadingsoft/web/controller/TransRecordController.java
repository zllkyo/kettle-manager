package com.leadingsoft.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leadingsoft.common.toolkit.Constant;
import com.leadingsoft.core.dto.BootTablePage;
import com.leadingsoft.core.dto.ResultDto;
import com.leadingsoft.core.model.KUser;
import com.leadingsoft.web.service.TransRecordService;
import com.leadingsoft.web.utils.JsonUtils;

@RestController
@RequestMapping("/trans/record/")
public class TransRecordController {

	@Autowired
	private TransRecordService transRecordService;
	
	@RequestMapping("getList.shtml")
	public String getList(Integer offset, Integer limit, Integer transId, HttpServletRequest request){
		KUser kUser = (KUser) request.getSession().getAttribute(Constant.SESSION_ID);
		BootTablePage list = transRecordService.getList(offset, limit, kUser.getuId(), transId);				
		return JsonUtils.objectToJson(list);
	}
	
	@RequestMapping("getLogContent.shtml")
	public String getLogContent(Integer recordId){
		try {
			String logContent = transRecordService.getLogContent(recordId);
			return ResultDto.success(logContent.replace("\r\n", "<br/>"));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} 
	}
}
