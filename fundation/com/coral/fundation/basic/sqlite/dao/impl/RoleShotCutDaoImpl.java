package com.coral.fundation.basic.sqlite.dao.impl;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import com.coral.fundation.DBean;
import com.coral.fundation.basic.dao.IRoleShotCutDao;
import com.coral.fundation.model.RoleShotCut;

/**
 * <p>Title: com.coral.fundation.basic.sqlite.dao.impl.RoleShotCutDaoImpl</p>
 * <p>Description: RoleShotCutDaoImpl interface </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-08-09 11:20 </p>
 */
public class RoleShotCutDaoImpl implements IRoleShotCutDao {

	public RoleShotCut create(RoleShotCut entity) throws Exception {
		DBean db = new DBean();
		PreparedStatement ps = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Insert into RoleShotCut(");
		sb.append("roleShotCutId,");
		sb.append("roleId,");
		sb.append("shotCutId");
		sb.append(") values(");
		for (int i = 0; i < 3; i++) {
			sb.append(i == 0 ? "?" : ",?");
		}
		sb.append(")");
		try {
			Connection con = db.getMySQLConnection();
			ps = con.prepareStatement(sb.toString());
			int pos = 1;
			ps.setString(pos++, entity.getRoleShotCutId());
			ps.setString(pos++, entity.getRoleId());
			ps.setString(pos++, entity.getShotCutId());
			ps.execute();
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.closeAll(null, ps, db);
		}
		return entity;
	}

	public void update(RoleShotCut entity) throws Exception {
		DBean db = new DBean();
		PreparedStatement ps = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Update RoleShotCut set ");
		sb.append("roleId=?,");
		sb.append("shotCutId=?");
		sb.append(" where roleShotCutId = ?");
		try {
			Connection con = db.getSQLiteConnection();
			ps = con.prepareStatement(sb.toString());
			int pos = 1;
			ps.setString(pos++, entity.getRoleId());
			ps.setString(pos++, entity.getShotCutId());
			ps.setString(pos++, entity.getRoleShotCutId());
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
		sb.append("delete from RoleShotCut ");
		sb.append("where roleShotCutId = ?");
		try {
			Connection con = db.getSQLiteConnection();
			ps = con.prepareStatement(sb.toString());
			ps.setString(1, entityId);
			ps.execute();
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.closeAll(null, ps, db);
		}
	}

	public RoleShotCut load(String entityId) throws Exception {
		RoleShotCut entity = null;
		DBean db = new DBean();
		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Select * from RoleShotCut ");
		sb.append("where roleShotCutId = ?");
		try {
			Connection con = db.getSQLiteConnection();
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

	public List<RoleShotCut> loadAll() throws Exception {
		List<RoleShotCut> entities = new ArrayList<RoleShotCut>();
		DBean db = new DBean();
		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Select * from RoleShotCut ");
		try {
			Connection con = db.getSQLiteConnection();
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

	public RoleShotCut fillEntity(ResultSet rs) throws Exception {
		RoleShotCut entity = new RoleShotCut();
		entity.setRoleShotCutId(rs.getString("roleShotCutId"));
		entity.setRoleId(rs.getString("roleId"));
		entity.setShotCutId(rs.getString("shotCutId"));
		return entity;
	}
}

