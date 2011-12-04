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
import com.coral.store.basic.dao.impl.ProductDaoImpl;
import com.coral.store.ext.IExtProductDao;
import com.coral.store.model.Product;
import com.coral.store.model.Supplier;

/**
 * @author coral.ma
 *
 */
public class ExtProductDaoImpl extends ProductDaoImpl implements IExtProductDao {

	public List<Product> loadSupplierProducts(String supplierId) throws Exception {
		List<Product> productList = new ArrayList<Product>();
		DBean db = new DBean();
		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Select * from Product ");
		sb.append("where supplierId = ?");
		try {
			Connection con = db.getMySQLConnection();
			ps = con.prepareStatement(sb.toString());
			ps.setString(1, supplierId);
			rs = ps.executeQuery();
			while (rs.next()) {
				productList.add(fillEntity(rs));
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.closeAll(null, ps, db);
		}
		return productList;
	}
	
	public List<Product> abstractQuery(String condition, String pinyinCondition) throws Exception {
		List<Product> entities = new ArrayList<Product>();
		DBean db = new DBean();
		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Select * from Product where abstractProduct like ? or productPinYin like ?");
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
