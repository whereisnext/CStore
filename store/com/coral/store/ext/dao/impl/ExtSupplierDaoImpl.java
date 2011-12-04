/**
 * 
 */
package com.coral.store.ext.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.coral.fundation.DBean;
import com.coral.store.basic.dao.impl.SupplierDaoImpl;
import com.coral.store.ext.IExtSupplierDao;
import com.coral.store.model.Supplier;

/**
 * @author coral.ma
 *
 */
public class ExtSupplierDaoImpl extends SupplierDaoImpl implements IExtSupplierDao {

	public List<Supplier> abstractQuery(String condition, String pinyinCondition) throws Exception {
		List<Supplier> entities = new ArrayList<Supplier>();
		DBean db = new DBean();
		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Select * from Supplier where abstractSupplier like ? or supplierPinYin like ?");
		try {
			Connection con = db.getConnection();
			ps = con.prepareStatement(sb.toString());
			ps.setString(1, condition);
			ps.setString(2, pinyinCondition);
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

}
