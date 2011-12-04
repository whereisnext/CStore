package com.coral.fundation.basic.dao.impl;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import com.coral.fundation.DBean;
import com.coral.fundation.basic.dao.IWorkflowProcessDao;
import com.coral.fundation.model.WorkflowProcess;

/**
 * <p>Title: com.coral.fundation.basic.dao.impl.WorkflowProcessDaoImpl</p>
 * <p>Description: WorkflowProcessDaoImpl interface </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-09-02 12:02 </p>
 */
public class WorkflowProcessDaoImpl implements IWorkflowProcessDao {

	public WorkflowProcess create(WorkflowProcess entity) throws Exception {
		DBean db = new DBean();
		PreparedStatement ps = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Insert into WorkflowProcess(");
		sb.append("workflowProcessId,");
		sb.append("nextProcessId,");
		sb.append("failProcessId,");
		sb.append("status,");
		sb.append("statusLabel,");
		sb.append("failStatusLabel,");
		sb.append("roleId,");
		sb.append("abstractWorkflowProcess");
		sb.append(") values(");
		for (int i = 0; i < 8; i++) {
			sb.append(i == 0 ? "?" : ",?");
		}
		sb.append(")");
		try {
			Connection con = db.getConnection();
			ps = con.prepareStatement(sb.toString());
			int pos = 1;
			ps.setString(pos++, entity.getWorkflowProcessId());
			ps.setString(pos++, entity.getNextProcessId());
			ps.setString(pos++, entity.getFailProcessId());
			ps.setString(pos++, entity.getStatus());
			ps.setString(pos++, entity.getStatusLabel());
			ps.setString(pos++, entity.getFailStatusLabel());
			ps.setString(pos++, entity.getRoleId());
			ps.setString(pos++, entity.getAbstractWorkflowProcess());
			ps.execute();
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.closeAll(null, ps, db);
		}
		return entity;
	}

	public void update(WorkflowProcess entity) throws Exception {
		DBean db = new DBean();
		PreparedStatement ps = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Update WorkflowProcess set ");
		sb.append("nextProcessId=?,");
		sb.append("failProcessId=?,");
		sb.append("status=?,");
		sb.append("statusLabel=?,");
		sb.append("failStatusLabel=?,");
		sb.append("roleId=?,");
		sb.append("abstractWorkflowProcess=?");
		sb.append(" where workflowProcessId = ?");
		try {
			Connection con = db.getConnection();
			ps = con.prepareStatement(sb.toString());
			int pos = 1;
			ps.setString(pos++, entity.getNextProcessId());
			ps.setString(pos++, entity.getFailProcessId());
			ps.setString(pos++, entity.getStatus());
			ps.setString(pos++, entity.getStatusLabel());
			ps.setString(pos++, entity.getFailStatusLabel());
			ps.setString(pos++, entity.getRoleId());
			ps.setString(pos++, entity.getAbstractWorkflowProcess());
			ps.setString(pos++, entity.getWorkflowProcessId());
			ps.execute();
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.closeAll(null, ps, db);
		}
	}

	public void remove(String entityId) throws Exception {
		DBean db = new DBean();
		PreparedStatement ps = null;
		StringBuffer sb = new StringBuffer();
		sb.append("delete from WorkflowProcess ");
		sb.append("where workflowProcessId = ?");
		try {
			Connection con = db.getConnection();
			ps = con.prepareStatement(sb.toString());
			ps.setString(1, entityId);
			ps.execute();
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.closeAll(null, ps, db);
		}
	}

	public WorkflowProcess load(String entityId) throws Exception {
		WorkflowProcess entity = null;
		DBean db = new DBean();
		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Select * from WorkflowProcess ");
		sb.append("where workflowProcessId = ?");
		try {
			Connection con = db.getConnection();
			ps = con.prepareStatement(sb.toString());
			ps.setString(1, entityId);
			rs = ps.executeQuery();
			if (rs.next()) {
				entity = fillEntity(rs);
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.closeAll(null, ps, db);
		}
		return entity;
	}

	public List<WorkflowProcess> loadAll() throws Exception {
		List<WorkflowProcess> entities = new ArrayList<WorkflowProcess>();
		DBean db = new DBean();
		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Select * from WorkflowProcess ");
		try {
			Connection con = db.getConnection();
			ps = con.prepareStatement(sb.toString());
			rs = ps.executeQuery();
			while (rs.next()) {
				entities.add(fillEntity(rs));
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.closeAll(null, ps, db);
		}
		return entities;
	}

	public WorkflowProcess fillEntity(ResultSet rs) throws Exception {
		WorkflowProcess entity = new WorkflowProcess();
		entity.setWorkflowProcessId(rs.getString("workflowProcessId"));
		entity.setNextProcessId(rs.getString("nextProcessId"));
		entity.setFailProcessId(rs.getString("failProcessId"));
		entity.setStatus(rs.getString("status"));
		entity.setStatusLabel(rs.getString("statusLabel"));
		entity.setFailStatusLabel(rs.getString("failStatusLabel"));
		entity.setRoleId(rs.getString("roleId"));
		entity.setAbstractWorkflowProcess(rs.getString("abstractWorkflowProcess"));
		return entity;
	}
}

