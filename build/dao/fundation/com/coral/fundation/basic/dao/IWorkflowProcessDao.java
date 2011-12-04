package com.coral.fundation.basic.dao;

import java.sql.*;
import java.util.List;
import com.coral.fundation.model.WorkflowProcess;

/**
 * <p>Title: com.coral.fundation.basic.dao.IWorkflowProcessDao</p>
 * <p>Description: IWorkflowProcessDao interface </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-09-02 12:02 </p>
 */
public interface IWorkflowProcessDao {

	public WorkflowProcess create(WorkflowProcess entity) throws Exception;

	public void update(WorkflowProcess entity) throws Exception;

	public void remove(String entityId) throws Exception;

	public WorkflowProcess load(String entityId) throws Exception;

	public List<WorkflowProcess> loadAll() throws Exception;

	public WorkflowProcess fillEntity(ResultSet rs) throws Exception;
}

