/**
 * 
 */
package com.coral.fundation.ext.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.coral.fundation.DBean;
import com.coral.fundation.basic.dao.impl.ModelMenuDaoImpl;
import com.coral.fundation.ext.dao.IExtRoleModelMenuDao;
import com.coral.fundation.model.ModelMenu;

/**
 * @author coral.ma
 *
 */
public class ExtRoleModelMenuDaoImpl extends ModelMenuDaoImpl implements IExtRoleModelMenuDao {
	

	public List<ModelMenu> loadFirstLevelModelMenuByRole(String ruleId) {
		List<ModelMenu> menus = new ArrayList<ModelMenu>();
		DBean db = new DBean();
		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Select m.* from RoleMenu rm, ModelMenu m ");
		sb.append("where rm.menuId=m.menuId and m.parentMenuId=0 and rm.roleId = ? order by orderIndex");
		try {
			Connection con = db.getConnection();
			ps = con.prepareStatement(sb.toString());
			ps.setString(1, ruleId);
			rs = ps.executeQuery();
			while (rs.next()) {
				menus.add(fillEntity(rs));
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.closeAll(null, ps, db);
		}
		return menus;
	}
	
	public List<ModelMenu> loadSubLevelModelMenuByRole(String ruleId, Long parentMenuId) {
		List<ModelMenu> menus = new ArrayList<ModelMenu>();
		DBean db = new DBean();
		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Select m.* from RoleMenu rm, ModelMenu m ");
		sb.append("where rm.menuId=m.menuId and m.parentMenuId=? and rm.roleId = ? order by orderIndex");
		try {
			Connection con = db.getConnection();
			ps = con.prepareStatement(sb.toString());
			ps.setLong(1, parentMenuId);
			ps.setString(2, ruleId);
			rs = ps.executeQuery();
			while (rs.next()) {
				menus.add(fillEntity(rs));
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.closeAll(null, ps, db);
		}
		return menus;
	}
	
	public List<ModelMenu> loadFirstLevelModelMenu() {
		List<ModelMenu> menus = new ArrayList<ModelMenu>();
		DBean db = new DBean();
		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Select m.* from ModelMenu m ");
		sb.append("where m.parentMenuId=0 order by menuId");
		try {
			Connection con = db.getConnection();
			ps = con.prepareStatement(sb.toString());
			rs = ps.executeQuery();
			while (rs.next()) {
				menus.add(fillEntity(rs));
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.closeAll(null, ps, db);
		}
		return menus;
	}
	
	public List<ModelMenu> loadSubLevelModelMenu(Long parentMenuId) {
		List<ModelMenu> menus = new ArrayList<ModelMenu>();
		DBean db = new DBean();
		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Select m.* from ModelMenu m ");
		sb.append("where m.parentMenuId=? order by menuId");
		try {
			Connection con = db.getConnection();
			ps = con.prepareStatement(sb.toString());
			ps.setLong(1, parentMenuId);
			rs = ps.executeQuery();
			while (rs.next()) {
				menus.add(fillEntity(rs));
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.closeAll(null, ps, db);
		}
		return menus;
	}
	
	
}
