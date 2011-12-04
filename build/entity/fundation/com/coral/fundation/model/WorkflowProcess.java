package com.coral.fundation.model;


/**
 * <p>Title: com.coral.fundation.model.WorkflowProcess</p>
 * <p>Description: WorkflowProcess entity </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-09-02 12:02 </p>
 */
public class WorkflowProcess implements java.io.Serializable  {

	private String workflowProcessId;
	private String nextProcessId;
	private String failProcessId;
	private String status;
	private String statusLabel;
	private String failStatusLabel;
	private String roleId;
	private String abstractWorkflowProcess;

	public String getWorkflowProcessId() {
		return workflowProcessId;
	}
	public void setWorkflowProcessId(String workflowProcessId) {
		this.workflowProcessId=workflowProcessId;
	}

	public String getNextProcessId() {
		return nextProcessId;
	}
	public void setNextProcessId(String nextProcessId) {
		this.nextProcessId=nextProcessId;
	}

	public String getFailProcessId() {
		return failProcessId;
	}
	public void setFailProcessId(String failProcessId) {
		this.failProcessId=failProcessId;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status=status;
	}

	public String getStatusLabel() {
		return statusLabel;
	}
	public void setStatusLabel(String statusLabel) {
		this.statusLabel=statusLabel;
	}

	public String getFailStatusLabel() {
		return failStatusLabel;
	}
	public void setFailStatusLabel(String failStatusLabel) {
		this.failStatusLabel=failStatusLabel;
	}

	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId=roleId;
	}

	public String getAbstractWorkflowProcess() {
		return abstractWorkflowProcess;
	}
	public void setAbstractWorkflowProcess(String abstractWorkflowProcess) {
		this.abstractWorkflowProcess=abstractWorkflowProcess;
	}

}

