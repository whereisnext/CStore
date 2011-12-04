package com.coral.fundation.basic.sqlite.dao.impl;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import com.coral.fundation.DBean;
import com.coral.fundation.basic.dao.IRoleMenuDao;
import com.coral.fundation.model.RoleMenu;

/**
 * <p>Title: com.coral.fundation.basic.sqlite.dao.impl.RoleMenuDaoImpl</p>
 * <p>Description: RoleMenuDaoImpl interface </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-08-09 11:20 </p>
 */
public class RoleMenuDaoImpl implements IRoleMenuDao {

	public RoleMenu create(RoleMenu entity) throws Exception {
		DBean db = new DBean();
		PreparedStatement ps = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Insert into RoleMenu(");
		sb.append("roleMenuId,");
		sb.append("roleId,");
		sb.append("menuId");
		sb.append(") values(");
		for (int i = 0; i < 3; i++) {
			sb.append(i == 0 ? "?" : ",?");
		}
		sb.append(")");
		try {
			Connection con = db.getMySQLConnection();
			ps = con.prepareStatement(sb.toString());
			int pos = 1;
			ps.setString(pos++, entity.getRoleMenuId());
			ps.setString(pos++, entity.getRoleId());
			ps.setString(pos++, entity.getMenuId());
			ps.execute();
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.closeAll(null, ps, db);
		}
		return entity;
	}

	public void update(RoleMenu entity) throws Exception {
		DBean db = new DBean();
		PreparedStatement ps = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Update RoleMenu set ");
		sb.append("roleId=?,");
		sb.append("menuId=?");
		sb.append(" where roleMenuId = ?");
		try {
			Connection con = db.getSQLiteConnection();
			ps = con.prepareStatement(sb.toString());
			int pos = 1;
			ps.setString(pos++, entity.getRoleId());
			ps.setString(pos++, entity.getMenuId());
			ps.setString(pos++, entity.getRoleMenuId());
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
		sb.append("delete from RoleMenu ");
		sb.append("where roleMenuId = ?");
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

	public RoleMenu load(String entityId) throws Exception {
		RoleMenu entity = null;
		DBean db = new DBean();
		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Select * from RoleMenu ");
		sb.append("where roleMenuId = ?");
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

	public List<RoleMenu> loadAll() throws Exception {
		List<RoleMenu> entities = new ArrayList<RoleMenu>();
		DBean db = new DBean();
		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Select * from RoleMenu ");
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

	public RoleMenu fillEntity(ResultSet rs) throws Exception {
		RoleMenu entity = new RoleMenu();
		entity.setRoleMenuId(rs.getString("roleMenuId"));
		entity.setRoleId(rs.getString("roleId"));
		entity.setMenuId(rs.getString("menuId"));
		return entity;
	}
}

