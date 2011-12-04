package com.coral.store.basic.dao.impl;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import com.coral.fundation.DBean;
import com.coral.store.basic.dao.ISupplierDao;
import com.coral.store.model.Supplier;
import com.coral.fundation.utils.DateUtils;

/**
 * <p>Title: com.coral.store.basic.dao.impl.SupplierDaoImpl</p>
 * <p>Description: SupplierDaoImpl interface </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-09-02 12:02 </p>
 */
public class SupplierDaoImpl implements ISupplierDao {

	public Supplier create(Supplier entity) throws Exception {
		DBean db = new DBean();
		PreparedStatement ps = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Insert into Supplier(");
		sb.append("supplierId,");
		sb.append("supplierName,");
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
		sb.append("status,");
		sb.append("supplierPinYin,");
		sb.append("abstractSupplier,");
		sb.append("insertDate");
		sb.append(") values(");
		for (int i = 0; i < 19; i++) {
			sb.append(i == 0 ? "?" : ",?");
		}
		sb.append(")");
		try {
			Connection con = db.getConnection();
			ps = con.prepareStatement(sb.toString());
			int pos = 1;
			ps.setString(pos++, entity.getSupplierId());
			ps.setString(pos++, entity.getSupplierName());
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
			ps.setString(pos++, entity.getStatus());
			ps.setString(pos++, entity.getSupplierPinYin());
			ps.setString(pos++, entity.getAbstractSupplier());
			ps.setDate(pos++, DateUtils.toSqlDate(entity.getInsertDate()));
			ps.execute();
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.closeAll(null, ps, db);
		}
		return entity;
	}

	public void update(Supplier entity) throws Exception {
		DBean db = new DBean();
		PreparedStatement ps = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Update Supplier set ");
		sb.append("supplierName=?,");
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
		sb.append("status=?,");
		sb.append("supplierPinYin=?,");
		sb.append("abstractSupplier=?,");
		sb.append("insertDate=?");
		sb.append(" where supplierId = ?");
		try {
			Connection con = db.getConnection();
			ps = con.prepareStatement(sb.toString());
			int pos = 1;
			ps.setString(pos++, entity.getSupplierName());
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
			ps.setString(pos++, entity.getStatus());
			ps.setString(pos++, entity.getSupplierPinYin());
			ps.setString(pos++, entity.getAbstractSupplier());
			ps.setDate(pos++, DateUtils.toSqlDate(entity.getInsertDate()));
			ps.setString(pos++, entity.getSupplierId());
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
		sb.append("delete from Supplier ");
		sb.append("where supplierId = ?");
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

	public Supplier load(String entityId) throws Exception {
		Supplier entity = null;
		DBean db = new DBean();
		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Select * from Supplier ");
		sb.append("where supplierId = ?");
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

	public List<Supplier> loadAll() throws Exception {
		List<Supplier> entities = new ArrayList<Supplier>();
		DBean db = new DBean();
		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Select * from Supplier ");
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

	public Supplier fillEntity(ResultSet rs) throws Exception {
		Supplier entity = new Supplier();
		entity.setSupplierId(rs.getString("supplierId"));
		entity.setSupplierName(rs.getString("supplierName"));
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
		entity.setStatus(rs.getString("status"));
		entity.setSupplierPinYin(rs.getString("supplierPinYin"));
		entity.setAbstractSupplier(rs.getString("abstractSupplier"));
		entity.setInsertDate(rs.getDate("insertDate"));
		return entity;
	}
}

