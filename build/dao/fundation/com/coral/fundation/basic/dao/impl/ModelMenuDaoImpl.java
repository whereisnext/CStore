package com.coral.fundation.basic.dao.impl;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import com.coral.fundation.DBean;
import com.coral.fundation.basic.dao.IModelMenuDao;
import com.coral.fundation.model.ModelMenu;

/**
 * <p>Title: com.coral.fundation.basic.dao.impl.ModelMenuDaoImpl</p>
 * <p>Description: ModelMenuDaoImpl interface </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-09-02 12:02 </p>
 */
public class ModelMenuDaoImpl implements IModelMenuDao {

	public ModelMenu create(ModelMenu entity) throws Exception {
		DBean db = new DBean();
		PreparedStatement ps = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Insert into ModelMenu(");
		sb.append("modelMenuId,");
		sb.append("menuId,");
		sb.append("menuName,");
		sb.append("parentMenuId,");
		sb.append("viewName,");
		sb.append("icon,");
		sb.append("orderIndex,");
		sb.append("abstractModelMenu");
		sb.append(") values(");
		for (int i = 0; i < 8; i++) {
			sb.append(i == 0 ? "?" : ",?");
		}
		sb.append(")");
		try {
			Connection con = db.getConnection();
			ps = con.prepareStatement(sb.toString());
			int pos = 1;
			ps.setString(pos++, entity.getModelMenuId());
			ps.setLong(pos++, entity.getMenuId());
			ps.setString(pos++, entity.getMenuName());
			ps.setLong(pos++, entity.getParentMenuId());
			ps.setString(pos++, entity.getViewName());
			ps.setString(pos++, entity.getIcon());
			ps.setLong(pos++, entity.getOrderIndex());
			ps.setString(pos++, entity.getAbstractModelMenu());
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
		sb.append("menuId=?,");
		sb.append("menuName=?,");
		sb.append("parentMenuId=?,");
		sb.append("viewName=?,");
		sb.append("icon=?,");
		sb.append("orderIndex=?,");
		sb.append("abstractModelMenu=?");
		sb.append(" where modelMenuId = ?");
		try {
			Connection con = db.getConnection();
			ps = con.prepareStatement(sb.toString());
			int pos = 1;
			ps.setLong(pos++, entity.getMenuId());
			ps.setString(pos++, entity.getMenuName());
			ps.setLong(pos++, entity.getParentMenuId());
			ps.setString(pos++, entity.getViewName());
			ps.setString(pos++, entity.getIcon());
			ps.setLong(pos++, entity.getOrderIndex());
			ps.setString(pos++, entity.getAbstractModelMenu());
			ps.setString(pos++, entity.getModelMenuId());
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
		sb.append("delete from ModelMenu ");
		sb.append("where modelMenuId = ?");
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

	public ModelMenu load(String entityId) throws Exception {
		ModelMenu entity = null;
		DBean db = new DBean();
		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Select * from ModelMenu ");
		sb.append("where modelMenuId = ?");
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

	public List<ModelMenu> loadAll() throws Exception {
		List<ModelMenu> entities = new ArrayList<ModelMenu>();
		DBean db = new DBean();
		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Select * from ModelMenu ");
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

	public ModelMenu fillEntity(ResultSet rs) throws Exception {
		ModelMenu entity = new ModelMenu();
		entity.setModelMenuId(rs.getString("modelMenuId"));
		entity.setMenuId(rs.getLong("menuId"));
		entity.setMenuName(rs.getString("menuName"));
		entity.setParentMenuId(rs.getLong("parentMenuId"));
		entity.setViewName(rs.getString("viewName"));
		entity.setIcon(rs.getString("icon"));
		entity.setOrderIndex(rs.getLong("orderIndex"));
		entity.setAbstractModelMenu(rs.getString("abstractModelMenu"));
		return entity;
	}
}

