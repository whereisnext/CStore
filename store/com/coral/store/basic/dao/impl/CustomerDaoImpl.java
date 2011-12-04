package com.coral.store.basic.dao.impl;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import com.coral.fundation.DBean;
import com.coral.store.basic.dao.ICustomerDao;
import com.coral.store.model.Customer;
import com.coral.fundation.utils.DateUtils;

/**
 * <p>Title: com.coral.store.basic.dao.impl.CustomerDaoImpl</p>
 * <p>Description: CustomerDaoImpl interface </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-07-29 10:56 </p>
 */
public class CustomerDaoImpl implements ICustomerDao {

	public Customer create(Customer entity) throws Exception {
		DBean db = new DBean();
		PreparedStatement ps = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Insert into Customer(");
		sb.append("customerId,");
		sb.append("customerName,");
		sb.append("contectPerson,");
		sb.append("district,");
		sb.append("postcode,");
		sb.append("address,");
		sb.append("mobile,");
		sb.append("phone,");
		sb.append("fax,");
		sb.append("url,");
		sb.append("email,");
		sb.append("accountBank,");
		sb.append("accountNumber,");
		sb.append("accountPerson,");
		sb.append("mark,");
		sb.append("customerPinYin,");
		sb.append("abstractCustomer,");
		sb.append("insertDate");
		sb.append(") values(");
		for (int i = 0; i < 18; i++) {
			sb.append(i == 0 ? "?" : ",?");
		}
		sb.append(")");
		try {
			Connection con = db.getConnection();
			ps = con.prepareStatement(sb.toString());
			int pos = 1;
			ps.setString(pos++, entity.getCustomerId());
			ps.setString(pos++, entity.getCustomerName());
			ps.setString(pos++, entity.getContectPerson());
			ps.setString(pos++, entity.getDistrict());
			ps.setString(pos++, entity.getPostcode());
			ps.setString(pos++, entity.getAddress());
			ps.setString(pos++, entity.getMobile());
			ps.setString(pos++, entity.getPhone());
			ps.setString(pos++, entity.getFax());
			ps.setString(pos++, entity.getUrl());
			ps.setString(pos++, entity.getEmail());
			ps.setString(pos++, entity.getAccountBank());
			ps.setString(pos++, entity.getAccountNumber());
			ps.setString(pos++, entity.getAccountPerson());
			ps.setString(pos++, entity.getMark());
			ps.setString(pos++, entity.getCustomerPinYin());
			ps.setString(pos++, entity.getAbstractCustomer());
			ps.setDate(pos++, DateUtils.toSqlDate(entity.getInsertDate()));
			ps.execute();
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.closeAll(null, ps, db);
		}
		return entity;
	}

	public void update(Customer entity) throws Exception {
		DBean db = new DBean();
		PreparedStatement ps = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Update Customer set ");
		sb.append("customerName=?,");
		sb.append("contectPerson=?,");
		sb.append("district=?,");
		sb.append("postcode=?,");
		sb.append("address=?,");
		sb.append("mobile=?,");
		sb.append("phone=?,");
		sb.append("fax=?,");
		sb.append("url=?,");
		sb.append("email=?,");
		sb.append("accountBank=?,");
		sb.append("accountNumber=?,");
		sb.append("accountPerson=?,");
		sb.append("mark=?,");
		sb.append("customerPinYin=?,");
		sb.append("abstractCustomer=?,");
		sb.append("insertDate=?");
		sb.append(" where customerId = ?");
		try {
			Connection con = db.getConnection();
			ps = con.prepareStatement(sb.toString());
			int pos = 1;
			ps.setString(pos++, entity.getCustomerName());
			ps.setString(pos++, entity.getContectPerson());
			ps.setString(pos++, entity.getDistrict());
			ps.setString(pos++, entity.getPostcode());
			ps.setString(pos++, entity.getAddress());
			ps.setString(pos++, entity.getMobile());
			ps.setString(pos++, entity.getPhone());
			ps.setString(pos++, entity.getFax());
			ps.setString(pos++, entity.getUrl());
			ps.setString(pos++, entity.getEmail());
			ps.setString(pos++, entity.getAccountBank());
			ps.setString(pos++, entity.getAccountNumber());
			ps.setString(pos++, entity.getAccountPerson());
			ps.setString(pos++, entity.getMark());
			ps.setString(pos++, entity.getCustomerPinYin());
			ps.setString(pos++, entity.getAbstractCustomer());
			ps.setDate(pos++, DateUtils.toSqlDate(entity.getInsertDate()));
			ps.setString(pos++, entity.getCustomerId());
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
		sb.append("delete from Customer ");
		sb.append("where customerId = ?");
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

	public Customer load(String entityId) throws Exception {
		Customer entity = null;
		DBean db = new DBean();
		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Select * from Customer ");
		sb.append("where customerId = ?");
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

	public List<Customer> loadAll() throws Exception {
		List<Customer> entities = new ArrayList<Customer>();
		DBean db = new DBean();
		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Select * from Customer ");
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

	public Customer fillEntity(ResultSet rs) throws Exception {
		Customer entity = new Customer();
		entity.setCustomerId(rs.getString("customerId"));
		entity.setCustomerName(rs.getString("customerName"));
		entity.setContectPerson(rs.getString("contectPerson"));
		entity.setDistrict(rs.getString("district"));
		entity.setPostcode(rs.getString("postcode"));
		entity.setAddress(rs.getString("address"));
		entity.setMobile(rs.getString("mobile"));
		entity.setPhone(rs.getString("phone"));
		entity.setFax(rs.getString("fax"));
		entity.setUrl(rs.getString("url"));
		entity.setEmail(rs.getString("email"));
		entity.setAccountBank(rs.getString("accountBank"));
		entity.setAccountNumber(rs.getString("accountNumber"));
		entity.setAccountPerson(rs.getString("accountPerson"));
		entity.setMark(rs.getString("mark"));
		entity.setCustomerPinYin(rs.getString("customerPinYin"));
		entity.setAbstractCustomer(rs.getString("abstractCustomer"));
		entity.setInsertDate(rs.getDate("insertDate"));
		return entity;
	}
}

