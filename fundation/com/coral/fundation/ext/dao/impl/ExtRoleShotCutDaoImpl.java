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
import com.coral.fundation.basic.dao.impl.ShotCutDaoImpl;
import com.coral.fundation.ext.dao.IExtRoleShotCutDao;
import com.coral.fundation.model.ShotCut;

/**
 * @author coral.ma
 *
 */
public class ExtRoleShotCutDaoImpl extends ShotCutDaoImpl implements IExtRoleShotCutDao {
	
	public List<ShotCut> loadShotCutByRole(String roleId) {
		List<ShotCut> shotCutList = new ArrayList<ShotCut>();
		DBean db = new DBean();
		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Select s.* from ShotCut s, RoleShotCut rs ");
		sb.append("where s.shotCutId = rs.shotCutId and rs.roleId = ?");
		try {
			Connection con = db.getConnection();
			ps = con.prepareStatement(sb.toString());
			ps.setString(1, roleId);
			rs = ps.executeQuery();
			while (rs.next()) {
				shotCutList.add(fillEntity(rs));
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.closeAll(null, ps, db);
		}
		return shotCutList;
	}
}
