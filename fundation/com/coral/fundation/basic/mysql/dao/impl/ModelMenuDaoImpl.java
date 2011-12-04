package com.coral.fundation.basic.mysql.dao.impl;

import java.sql.*;
import com.coral.fundation.DBean;
import com.coral.fundation.basic.dao.IModelMenuDao;
import com.coral.fundation.model.ModelMenu;

/**
 * <p>Title: com.coral.fundation.basic.dao.impl.ModelMenuDaoImpl</p>
 * <p>Description: ModelMenuDaoImpl interface </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-07-20 17:28 </p>
 */
public class ModelMenuDaoImpl implements IModelMenuDao {

	public ModelMenu create(ModelMenu entity) throws Exception {
		DBean db = new DBean();
		PreparedStatement ps = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Insert into ModelMenu(");
		sb.append("menuId,");
		sb.append("menuName,");
		sb.append("parentMenuId,");
		sb.append("viewName,");
		sb.append("orderIndex");
		sb.append(") values(");
		for (int i = 0; i < 5; i++) {
			sb.append(i == 0 ? "?" : ",?");
		}
		sb.append(")");
		try {
			Connection con = db.getMySQLConnection();
			ps = con.prepareStatement(sb.toString());
			int pos = 1;
			ps.setLong(pos++, entity.getMenuId());
			ps.setString(pos++, entity.getMenuName());
			ps.setLong(pos++, entity.getParentMenuId());
			ps.setString(pos++, entity.getViewName());
			ps.setLong(pos++, entity.getOrderIndex());
			ps.execute();
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.closeAll(null, ps, db);
		}
		return entity;
	}

	public void update(ModelMenu entity) throws Exception {
		DBean db = new DBean();
		PreparedStatement ps = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Update ModelMenu set ");
		sb.append("menuName=?,");
		sb.append("parentMenuId=?,");
		sb.append("viewName=?,");
		sb.append("orderIndex=?");
		sb.append(" where menuId = ?");
		try {
			Connection con = db.getMySQLConnection();
			ps = con.prepareStatement(sb.toString());
			int pos = 1;
			ps.setString(pos++, entity.getMenuName());
			ps.setLong(pos++, entity.getParentMenuId());
			ps.setString(pos++, entity.getViewName());
			ps.setLong(pos++, entity.getOrderIndex());
			ps.setLong(pos++, entity.getMenuId());
			ps.execute();
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.closeAll(null, ps, db);
		}
	}

	public void remove(Long entityId) throws Exception {
		DBean db = new DBean();
		PreparedStatement ps = null;
		StringBuffer sb = new StringBuffer();
		sb.append("delete from ModelMenu ");
		sb.append("where menuId = ?");
		try {
			Connection con = db.getMySQLConnection();
			ps = con.prepareStatement(sb.toString());
			ps.setLong(1, entityId);
			ps.execute();
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.closeAll(null, ps, db);
		}
	}

	public ModelMenu load(Long entityId) throws Exception {
		ModelMenu entity = null;
		DBean db = new DBean();
		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Select * from ModelMenu ");
		sb.append("where menuId = ?");
		try {
			Connection con = db.getMySQLConnection();
			ps = con.prepareStatement(sb.toString());
			ps.setLong(1, entityId);
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

	public ModelMenu fillEntity(ResultSet rs) throws Exception {
		ModelMenu entity = new ModelMenu();
		entity.setMenuId(rs.getLong("menuId"));
		entity.setMenuName(rs.getString("menuName"));
		entity.setParentMenuId(rs.getLong("parentMenuId"));
		entity.setViewName(rs.getString("viewName"));
		entity.setOrderIndex(rs.getLong("orderIndex"));
		return entity;
	}
}

