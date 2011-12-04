package com.coral.fundation.service;

import com.coral.fundation.basic.dao.IWorkflowProcessDao;
import com.coral.cstore.utils.StrUtils;
import com.coral.fundation.IDGenerater;
import com.coral.fundation.Log;
import com.coral.fundation.bean.BeanUtils;
import com.coral.fundation.utils.SqlUtils;
import com.coral.fundation.utils.FoundationUtils;
import java.util.List;
import com.coral.fundation.model.WorkflowProcess;
/**
 * <p>Title: com.coral.fundation.service.WorkflowProcessDS</p>
 * <p>Description: WorkflowProcessDS entity </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-09-02 12:02 </p>
 */
public class WorkflowProcessDS {

	IWorkflowProcessDao workflowProcessDao = BeanUtils.getBean("workflowProcessDao", IWorkflowProcessDao.class);

	public WorkflowProcess createWorkflowProcess(WorkflowProcess workflowProcess) {
		try {
			workflowProcess.setWorkflowProcessId(IDGenerater.generate());
			FoundationUtils.abstractWorkflowProcess(workflowProcess);
			workflowProcessDao.create(workflowProcess);
		} catch (Exception e) {
			Log.error("Create WorkflowProcess error.", this.getClass(),e.getCause());
		}
		return workflowProcess;
	}

	public WorkflowProcess updateWorkflowProcess(WorkflowProcess workflowProcess) {
		try {
			FoundationUtils.abstractWorkflowProcess(workflowProcess);
			workflowProcessDao.update(workflowProcess);
		} catch (Exception e) {
			Log.error("Update WorkflowProcess error.", this.getClass(),e.getCause());
		}
		return workflowProcess;
	}

	public String deleteWorkflowProcess(WorkflowProcess workflowProcess) {
		deleteWorkflowProcess(workflowProcess.getWorkflowProcessId());
		return StrUtils.empty;
	}

	public String deleteWorkflowProcess(String workflowProcessId) {
		try {
			workflowProcessDao.remove(workflowProcessId);
		} catch (Exception e) {
			Log.error("Delete WorkflowProcess error.", this.getClass(),e.getCause());
		}
		return StrUtils.empty;
	}

	public WorkflowProcess loadWorkflowProcess(String workflowProcessId) {
		WorkflowProcess workflowProcess= null;
		try {
			workflowProcess = workflowProcessDao.load(workflowProcessId);
		} catch (Exception e) {
			Log.error("load WorkflowProcess error.", this.getClass(),e.getCause());
		}
		return workflowProcess;
	}

	public List<WorkflowProcess> loadAllWorkflowProcess() {
		List<WorkflowProcess> workflowProcessList = null;
		try {
			workflowProcessList = workflowProcessDao.loadAll();
		} catch (Exception e) {
			Log.error("load WorkflowProcess error.", this.getClass(),e.getCause());
		}
		return workflowProcessList;
	}
}

