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
import com.coral.store.basic.dao.impl.CustomerDaoImpl;
import com.coral.store.ext.IExtCustomerDao;
import com.coral.store.model.Customer;

/**
 * @author coral.ma
 *
 */
public class ExtCustomerDaoImpl extends CustomerDaoImpl implements IExtCustomerDao {

	public List<Customer> abstractQuery(String condition, String pinyinCondition)
			throws Exception {
		List<Customer> entities = new ArrayList<Customer>();
		DBean db = new DBean();
		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Select * from Customer where abstractCustomer like ? or customerPinYin like ?");
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
