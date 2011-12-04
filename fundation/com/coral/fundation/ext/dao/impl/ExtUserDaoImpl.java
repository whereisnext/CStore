/**
 * 
 */
package com.coral.fundation.ext.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.coral.fundation.DBean;
import com.coral.fundation.basic.dao.impl.UserDaoImpl;
import com.coral.fundation.ext.dao.IExtUserDao;
import com.coral.fundation.model.User;

/**
 * @author coral.ma
 *
 */
public class ExtUserDaoImpl extends UserDaoImpl implements IExtUserDao {

	public User login(String userName, String password) {
		User entity = null;
		DBean db = new DBean();
		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Select * from User ");
		sb.append("where userName = ? and password = ?");
		try {
			Connection con = db.getConnection();
			ps = con.prepareStatement(sb.toString());
			ps.setString(1, userName);
			ps.setString(2, password);
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

}
