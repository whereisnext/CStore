package com.coral.fundation.basic.sqlite.dao.impl;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import com.coral.fundation.DBean;
import com.coral.fundation.basic.dao.IUserDao;
import com.coral.fundation.model.User;
import com.coral.fundation.utils.DateUtils;

/**
 * <p>Title: com.coral.fundation.basic.sqlite.dao.impl.UserDaoImpl</p>
 * <p>Description: UserDaoImpl interface </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-08-09 11:20 </p>
 */
public class UserDaoImpl implements IUserDao {

	public User create(User entity) throws Exception {
		DBean db = new DBean();
		PreparedStatement ps = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Insert into User(");
		sb.append("userId,");
		sb.append("userName,");
		sb.append("password,");
		sb.append("roleName,");
		sb.append("insertDate");
		sb.append(") values(");
		for (int i = 0; i < 5; i++) {
			sb.append(i == 0 ? "?" : ",?");
		}
		sb.append(")");
		try {
			Connection con = db.getMySQLConnection();
			ps = con.prepareStatement(sb.toString());
			int pos = 1;
			ps.setString(pos++, entity.getUserId());
			ps.setString(pos++, entity.getUserName());
			ps.setString(pos++, entity.getPassword());
			ps.setString(pos++, entity.getRoleName());
			ps.setDate(pos++, DateUtils.toSqlDate(entity.getInsertDate()));
			ps.execute();
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.closeAll(null, ps, db);
		}
		return entity;
	}

	public void update(User entity) throws Exception {
		DBean db = new DBean();
		PreparedStatement ps = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Update User set ");
		sb.append("userName=?,");
		sb.append("password=?,");
		sb.append("roleName=?,");
		sb.append("insertDate=?");
		sb.append(" where userId = ?");
		try {
			Connection con = db.getSQLiteConnection();
			ps = con.prepareStatement(sb.toString());
			int pos = 1;
			ps.setString(pos++, entity.getUserName());
			ps.setString(pos++, entity.getPassword());
			ps.setString(pos++, entity.getRoleName());
			ps.setDate(pos++, DateUtils.toSqlDate(entity.getInsertDate()));
			ps.setString(pos++, entity.getUserId());
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
		sb.append("delete from User ");
		sb.append("where userId = ?");
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

	public User load(String entityId) throws Exception {
		User entity = null;
		DBean db = new DBean();
		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Select * from User ");
		sb.append("where userId = ?");
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

	public List<User> loadAll() throws Exception {
		List<User> entities = new ArrayList<User>();
		DBean db = new DBean();
		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Select * from User ");
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

	public User fillEntity(ResultSet rs) throws Exception {
		User entity = new User();
		entity.setUserId(rs.getString("userId"));
		entity.setUserName(rs.getString("userName"));
		entity.setPassword(rs.getString("password"));
		entity.setRoleName(rs.getString("roleName"));
		entity.setInsertDate(rs.getDate("insertDate"));
		return entity;
	}
}

