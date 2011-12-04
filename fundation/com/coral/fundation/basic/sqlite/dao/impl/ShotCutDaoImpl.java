package com.coral.fundation.basic.sqlite.dao.impl;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import com.coral.fundation.DBean;
import com.coral.fundation.basic.dao.IShotCutDao;
import com.coral.fundation.model.ShotCut;

/**
 * <p>Title: com.coral.fundation.basic.sqlite.dao.impl.ShotCutDaoImpl</p>
 * <p>Description: ShotCutDaoImpl interface </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-08-09 11:20 </p>
 */
public class ShotCutDaoImpl implements IShotCutDao {

	public ShotCut create(ShotCut entity) throws Exception {
		DBean db = new DBean();
		PreparedStatement ps = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Insert into ShotCut(");
		sb.append("shotCutId,");
		sb.append("shotCutName,");
		sb.append("viewName");
		sb.append(") values(");
		for (int i = 0; i < 3; i++) {
			sb.append(i == 0 ? "?" : ",?");
		}
		sb.append(")");
		try {
			Connection con = db.getMySQLConnection();
			ps = con.prepareStatement(sb.toString());
			int pos = 1;
			ps.setString(pos++, entity.getShotCutId());
			ps.setString(pos++, entity.getShotCutName());
			ps.setString(pos++, entity.getViewName());
			ps.execute();
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.closeAll(null, ps, db);
		}
		return entity;
	}

	public void update(ShotCut entity) throws Exception {
		DBean db = new DBean();
		PreparedStatement ps = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Update ShotCut set ");
		sb.append("shotCutName=?,");
		sb.append("viewName=?");
		sb.append(" where shotCutId = ?");
		try {
			Connection con = db.getSQLiteConnection();
			ps = con.prepareStatement(sb.toString());
			int pos = 1;
			ps.setString(pos++, entity.getShotCutName());
			ps.setString(pos++, entity.getViewName());
			ps.setString(pos++, entity.getShotCutId());
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
		sb.append("delete from ShotCut ");
		sb.append("where shotCutId = ?");
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

	public ShotCut load(String entityId) throws Exception {
		ShotCut entity = null;
		DBean db = new DBean();
		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Select * from ShotCut ");
		sb.append("where shotCutId = ?");
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

	public List<ShotCut> loadAll() throws Exception {
		List<ShotCut> entities = new ArrayList<ShotCut>();
		DBean db = new DBean();
		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Select * from ShotCut ");
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

	public ShotCut fillEntity(ResultSet rs) throws Exception {
		ShotCut entity = new ShotCut();
		entity.setShotCutId(rs.getString("shotCutId"));
		entity.setShotCutName(rs.getString("shotCutName"));
		entity.setViewName(rs.getString("viewName"));
		return entity;
	}
}

