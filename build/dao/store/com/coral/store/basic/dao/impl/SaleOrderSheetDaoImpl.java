package com.coral.store.basic.dao.impl;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import com.coral.fundation.DBean;
import com.coral.store.basic.dao.ISaleOrderSheetDao;
import com.coral.store.model.SaleOrderSheet;
import com.coral.fundation.utils.DateUtils;
import com.coral.fundation.utils.DateUtils;

/**
 * <p>Title: com.coral.store.basic.dao.impl.SaleOrderSheetDaoImpl</p>
 * <p>Description: SaleOrderSheetDaoImpl interface </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-09-02 12:02 </p>
 */
public class SaleOrderSheetDaoImpl implements ISaleOrderSheetDao {

	public SaleOrderSheet create(SaleOrderSheet entity) throws Exception {
		DBean db = new DBean();
		PreparedStatement ps = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Insert into SaleOrderSheet(");
		sb.append("saleOrderSheetId,");
		sb.append("saleOrderNo,");
		sb.append("customerName,");
		sb.append("receivePerson,");
		sb.append("mobile,");
		sb.append("fax,");
		sb.append("district,");
		sb.append("deliverAddress,");
		sb.append("deliverPostcode,");
		sb.append("deliverDate,");
		sb.append("mark,");
		sb.append("totalPrice,");
		sb.append("status,");
		sb.append("salesmanId,");
		sb.append("creatorId,");
		sb.append("orderPinYin,");
		sb.append("abstractOrder,");
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
			ps.setString(pos++, entity.getSaleOrderSheetId());
			ps.setString(pos++, entity.getSaleOrderNo());
			ps.setString(pos++, entity.getCustomerName());
			ps.setString(pos++, entity.getReceivePerson());
			ps.setString(pos++, entity.getMobile());
			ps.setString(pos++, entity.getFax());
			ps.setString(pos++, entity.getDistrict());
			ps.setString(pos++, entity.getDeliverAddress());
			ps.setString(pos++, entity.getDeliverPostcode());
			ps.setDate(pos++, DateUtils.toSqlDate(entity.getDeliverDate()));
			ps.setString(pos++, entity.getMark());
			ps.setString(pos++, entity.getTotalPrice());
			ps.setString(pos++, entity.getStatus());
			ps.setString(pos++, entity.getSalesmanId());
			ps.setString(pos++, entity.getCreatorId());
			ps.setString(pos++, entity.getOrderPinYin());
			ps.setString(pos++, entity.getAbstractOrder());
			ps.setDate(pos++, DateUtils.toSqlDate(entity.getInsertDate()));
			ps.execute();
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.closeAll(null, ps, db);
		}
		return entity;
	}

	public void update(SaleOrderSheet entity) throws Exception {
		DBean db = new DBean();
		PreparedStatement ps = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Update SaleOrderSheet set ");
		sb.append("saleOrderNo=?,");
		sb.append("customerName=?,");
		sb.append("receivePerson=?,");
		sb.append("mobile=?,");
		sb.append("fax=?,");
		sb.append("district=?,");
		sb.append("deliverAddress=?,");
		sb.append("deliverPostcode=?,");
		sb.append("deliverDate=?,");
		sb.append("mark=?,");
		sb.append("totalPrice=?,");
		sb.append("status=?,");
		sb.append("salesmanId=?,");
		sb.append("creatorId=?,");
		sb.append("orderPinYin=?,");
		sb.append("abstractOrder=?,");
		sb.append("insertDate=?");
		sb.append(" where saleOrderSheetId = ?");
		try {
			Connection con = db.getConnection();
			ps = con.prepareStatement(sb.toString());
			int pos = 1;
			ps.setString(pos++, entity.getSaleOrderNo());
			ps.setString(pos++, entity.getCustomerName());
			ps.setString(pos++, entity.getReceivePerson());
			ps.setString(pos++, entity.getMobile());
			ps.setString(pos++, entity.getFax());
			ps.setString(pos++, entity.getDistrict());
			ps.setString(pos++, entity.getDeliverAddress());
			ps.setString(pos++, entity.getDeliverPostcode());
			ps.setDate(pos++, DateUtils.toSqlDate(entity.getDeliverDate()));
			ps.setString(pos++, entity.getMark());
			ps.setString(pos++, entity.getTotalPrice());
			ps.setString(pos++, entity.getStatus());
			ps.setString(pos++, entity.getSalesmanId());
			ps.setString(pos++, entity.getCreatorId());
			ps.setString(pos++, entity.getOrderPinYin());
			ps.setString(pos++, entity.getAbstractOrder());
			ps.setDate(pos++, DateUtils.toSqlDate(entity.getInsertDate()));
			ps.setString(pos++, entity.getSaleOrderSheetId());
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
		sb.append("delete from SaleOrderSheet ");
		sb.append("where saleOrderSheetId = ?");
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

	public SaleOrderSheet load(String entityId) throws Exception {
		SaleOrderSheet entity = null;
		DBean db = new DBean();
		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Select * from SaleOrderSheet ");
		sb.append("where saleOrderSheetId = ?");
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

	public List<SaleOrderSheet> loadAll() throws Exception {
		List<SaleOrderSheet> entities = new ArrayList<SaleOrderSheet>();
		DBean db = new DBean();
		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Select * from SaleOrderSheet ");
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

	public SaleOrderSheet fillEntity(ResultSet rs) throws Exception {
		SaleOrderSheet entity = new SaleOrderSheet();
		entity.setSaleOrderSheetId(rs.getString("saleOrderSheetId"));
		entity.setSaleOrderNo(rs.getString("saleOrderNo"));
		entity.setCustomerName(rs.getString("customerName"));
		entity.setReceivePerson(rs.getString("receivePerson"));
		entity.setMobile(rs.getString("mobile"));
		entity.setFax(rs.getString("fax"));
		entity.setDistrict(rs.getString("district"));
		entity.setDeliverAddress(rs.getString("deliverAddress"));
		entity.setDeliverPostcode(rs.getString("deliverPostcode"));
		entity.setDeliverDate(rs.getDate("deliverDate"));
		entity.setMark(rs.getString("mark"));
		entity.setTotalPrice(rs.getString("totalPrice"));
		entity.setStatus(rs.getString("status"));
		entity.setSalesmanId(rs.getString("salesmanId"));
		entity.setCreatorId(rs.getString("creatorId"));
		entity.setOrderPinYin(rs.getString("orderPinYin"));
		entity.setAbstractOrder(rs.getString("abstractOrder"));
		entity.setInsertDate(rs.getDate("insertDate"));
		return entity;
	}
}

