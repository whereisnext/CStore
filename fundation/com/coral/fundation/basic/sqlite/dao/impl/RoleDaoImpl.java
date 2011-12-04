package com.coral.fundation.basic.sqlite.dao.impl;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import com.coral.fundation.DBean;
import com.coral.fundation.basic.dao.IRoleDao;
import com.coral.fundation.model.Role;

/**
 * <p>Title: com.coral.fundation.basic.sqlite.dao.impl.RoleDaoImpl</p>
 * <p>Description: RoleDaoImpl interface </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-08-09 11:20 </p>
 */
public class RoleDaoImpl implements IRoleDao {

	public Role create(Role entity) throws Exception {
		DBean db = new DBean();
		PreparedStatement ps = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Insert into Role(");
		sb.append("roleId,");
		sb.append("roleName");
		sb.append(") values(");
		for (int i = 0; i < 2; i++) {
			sb.append(i == 0 ? "?" : ",?");
		}
		sb.append(")");
		try {
			Connection con = db.getMySQLConnection();
			ps = con.prepareStatement(sb.toString());
			int pos = 1;
			ps.setString(pos++, entity.getRoleId());
			ps.setString(pos++, entity.getRoleName());
			ps.execute();
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.closeAll(null, ps, db);
		}
		return entity;
	}

	public void update(Role entity) throws Exception {
		DBean db = new DBean();
		PreparedStatement ps = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Update Role set ");
		sb.append("roleName=?");
		sb.append(" where roleId = ?");
		try {
			Connection con = db.getSQLiteConnection();
			ps = con.prepareStatement(sb.toString());
			int pos = 1;
			ps.setString(pos++, entity.getRoleName());
			ps.setString(pos++, entity.getRoleId());
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
		sb.append("delete from Role ");
		sb.append("where roleId = ?");
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

	public Role load(String entityId) throws Exception {
		Role entity = null;
		DBean db = new DBean();
		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Select * from Role ");
		sb.append("where roleId = ?");
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

	public List<Role> loadAll() throws Exception {
		List<Role> entities = new ArrayList<Role>();
		DBean db = new DBean();
		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Select * from Role ");
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

	public Role fillEntity(ResultSet rs) throws Exception {
		Role entity = new Role();
		entity.setRoleId(rs.getString("roleId"));
		entity.setRoleName(rs.getString("roleName"));
		return entity;
	}
}

