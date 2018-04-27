package com.leadingsoft.core.model;

public class KTransMonitor implements Comparable<KTransMonitor>{
	//监控转换ID
	private Integer monitorId ;
	//添加人
	private Integer addUser ;
	//失败次数
	private Integer monitorFail ;
	//监控状态（是否启动，1:启动；2:停止）
	private Integer monitorStatus ;
	//成功次数
	private Integer monitorSuccess ;
	//监控的转换的ID
	private Integer monitorTrans ;
	//运行状态（起始时间-结束时间,起始时间-结束时间……）
	private String runStatus ;
	
	public KTransMonitor() {
	}
	
	public Integer getMonitorId(){
		return  monitorId;
	}
	public void setMonitorId(Integer monitorId){
		this.monitorId = monitorId;
	}
	public Integer getAddUser(){
		return  addUser;
	}
	public void setAddUser(Integer addUser){
		this.addUser = addUser;
	}
	public Integer getMonitorFail(){
		return  monitorFail;
	}
	public void setMonitorFail(Integer monitorFail){
		this.monitorFail = monitorFail;
	}
	public Integer getMonitorStatus(){
		return  monitorStatus;
	}
	public void setMonitorStatus(Integer monitorStatus){
		this.monitorStatus = monitorStatus;
	}
	public Integer getMonitorSuccess(){
		return  monitorSuccess;
	}
	public void setMonitorSuccess(Integer monitorSuccess){
		this.monitorSuccess = monitorSuccess;
	}
	public Integer getMonitorTrans(){
		return  monitorTrans;
	}
	public void setMonitorTrans(Integer monitorTrans){
		this.monitorTrans = monitorTrans;
	}
	public String getRunStatus(){
		return  runStatus;
	}
	public void setRunStatus(String runStatus){
		this.runStatus = runStatus;
	}

	@Override
	public int compareTo(KTransMonitor o) {
		return this.getMonitorSuccess() - o.getMonitorSuccess();
	}

	@Override
	public String toString() {
		return "KTransMonitor [monitorId=" + monitorId + ", addUser=" + addUser + ", monitorFail=" + monitorFail
				+ ", monitorStatus=" + monitorStatus + ", monitorSuccess=" + monitorSuccess + ", monitorTrans="
				+ monitorTrans + ", runStatus=" + runStatus + "]";
	}
}