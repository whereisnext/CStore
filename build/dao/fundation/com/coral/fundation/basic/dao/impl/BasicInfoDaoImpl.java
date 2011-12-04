package com.coral.fundation.basic.dao.impl;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import com.coral.fundation.DBean;
import com.coral.fundation.basic.dao.IBasicInfoDao;
import com.coral.fundation.model.BasicInfo;

/**
 * <p>Title: com.coral.fundation.basic.dao.impl.BasicInfoDaoImpl</p>
 * <p>Description: BasicInfoDaoImpl interface </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-09-02 12:02 </p>
 */
public class BasicInfoDaoImpl implements IBasicInfoDao {

	public BasicInfo create(BasicInfo entity) throws Exception {
		DBean db = new DBean();
		PreparedStatement ps = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Insert into BasicInfo(");
		sb.append("basicInfoId,");
		sb.append("companyName,");
		sb.append("phone,");
		sb.append("fax,");
		sb.append("district,");
		sb.append("deliverAddress,");
		sb.append("deliverPostcode,");
		sb.append("url,");
		sb.append("email,");
		sb.append("accountBank,");
		sb.append("accountNumber,");
		sb.append("accountPerson");
		sb.append(") values(");
		for (int i = 0; i < 12; i++) {
			sb.append(i == 0 ? "?" : ",?");
		}
		sb.append(")");
		try {
			Connection con = db.getConnection();
			ps = con.prepareStatement(sb.toString());
			int pos = 1;
			ps.setString(pos++, entity.getBasicInfoId());
			ps.setString(pos++, entity.getCompanyName());
			ps.setString(pos++, entity.getPhone());
			ps.setString(pos++, entity.getFax());
			ps.setString(pos++, entity.getDistrict());
			ps.setString(pos++, entity.getDeliverAddress());
			ps.setString(pos++, entity.getDeliverPostcode());
			ps.setString(pos++, entity.getUrl());
			ps.setString(pos++, entity.getEmail());
			ps.setString(pos++, entity.getAccountBank());
			ps.setString(pos++, entity.getAccountNumber());
			ps.setString(pos++, entity.getAccountPerson());
			ps.execute();
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.closeAll(null, ps, db);
		}
		return entity;
	}

	public void update(BasicInfo entity) throws Exception {
		DBean db = new DBean();
		PreparedStatement ps = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Update BasicInfo set ");
		sb.append("companyName=?,");
		sb.append("phone=?,");
		sb.append("fax=?,");
		sb.append("district=?,");
		sb.append("deliverAddress=?,");
		sb.append("deliverPostcode=?,");
		sb.append("url=?,");
		sb.append("email=?,");
		sb.append("accountBank=?,");
		sb.append("accountNumber=?,");
		sb.append("accountPerson=?");
		sb.append(" where basicInfoId = ?");
		try {
			Connection con = db.getConnection();
			ps = con.prepareStatement(sb.toString());
			int pos = 1;
			ps.setString(pos++, entity.getCompanyName());
			ps.setString(pos++, entity.getPhone());
			ps.setString(pos++, entity.getFax());
			ps.setString(pos++, entity.getDistrict());
			ps.setString(pos++, entity.getDeliverAddress());
			ps.setString(pos++, entity.getDeliverPostcode());
			ps.setString(pos++, entity.getUrl());
			ps.setString(pos++, entity.getEmail());
			ps.setString(pos++, entity.getAccountBank());
			ps.setString(pos++, entity.getAccountNumber());
			ps.setString(pos++, entity.getAccountPerson());
			ps.setString(pos++, entity.getBasicInfoId());
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
		sb.append("delete from BasicInfo ");
		sb.append("where basicInfoId = ?");
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

	public BasicInfo load(String entityId) throws Exception {
		BasicInfo entity = null;
		DBean db = new DBean();
		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Select * from BasicInfo ");
		sb.append("where basicInfoId = ?");
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

	public List<BasicInfo> loadAll() throws Exception {
		List<BasicInfo> entities = new ArrayList<BasicInfo>();
		DBean db = new DBean();
		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Select * from BasicInfo ");
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

	public BasicInfo fillEntity(ResultSet rs) throws Exception {
		BasicInfo entity = new BasicInfo();
		entity.setBasicInfoId(rs.getString("basicInfoId"));
		entity.setCompanyName(rs.getString("companyName"));
		entity.setPhone(rs.getString("phone"));
		entity.setFax(rs.getString("fax"));
		entity.setDistrict(rs.getString("district"));
		entity.setDeliverAddress(rs.getString("deliverAddress"));
		entity.setDeliverPostcode(rs.getString("deliverPostcode"));
		entity.setUrl(rs.getString("url"));
		entity.setEmail(rs.getString("email"));
		entity.setAccountBank(rs.getString("accountBank"));
		entity.setAccountNumber(rs.getString("accountNumber"));
		entity.setAccountPerson(rs.getString("accountPerson"));
		return entity;
	}
}

