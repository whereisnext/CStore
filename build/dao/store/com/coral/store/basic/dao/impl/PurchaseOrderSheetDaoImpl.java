package com.coral.store.basic.dao.impl;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import com.coral.fundation.DBean;
import com.coral.store.basic.dao.IPurchaseOrderSheetDao;
import com.coral.store.model.PurchaseOrderSheet;
import com.coral.fundation.utils.DateUtils;
import com.coral.fundation.utils.DateUtils;

/**
 * <p>Title: com.coral.store.basic.dao.impl.PurchaseOrderSheetDaoImpl</p>
 * <p>Description: PurchaseOrderSheetDaoImpl interface </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-09-02 12:02 </p>
 */
public class PurchaseOrderSheetDaoImpl implements IPurchaseOrderSheetDao {

	public PurchaseOrderSheet create(PurchaseOrderSheet entity) throws Exception {
		DBean db = new DBean();
		PreparedStatement ps = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Insert into PurchaseOrderSheet(");
		sb.append("purchaseOrderSheetId,");
		sb.append("purchaseOrderNo,");
		sb.append("saleOrderNo,");
		sb.append("supplierName,");
		sb.append("receivePerson,");
		sb.append("mobile,");
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
		for (int i = 0; i < 17; i++) {
			sb.append(i == 0 ? "?" : ",?");
		}
		sb.append(")");
		try {
			Connection con = db.getConnection();
			ps = con.prepareStatement(sb.toString());
			int pos = 1;
			ps.setString(pos++, entity.getPurchaseOrderSheetId());
			ps.setString(pos++, entity.getPurchaseOrderNo());
			ps.setString(pos++, entity.getSaleOrderNo());
			ps.setString(pos++, entity.getSupplierName());
			ps.setString(pos++, entity.getReceivePerson());
			ps.setString(pos++, entity.getMobile());
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

	public void update(PurchaseOrderSheet entity) throws Exception {
		DBean db = new DBean();
		PreparedStatement ps = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Update PurchaseOrderSheet set ");
		sb.append("purchaseOrderNo=?,");
		sb.append("saleOrderNo=?,");
		sb.append("supplierName=?,");
		sb.append("receivePerson=?,");
		sb.append("mobile=?,");
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
		sb.append(" where purchaseOrderSheetId = ?");
		try {
			Connection con = db.getConnection();
			ps = con.prepareStatement(sb.toString());
			int pos = 1;
			ps.setString(pos++, entity.getPurchaseOrderNo());
			ps.setString(pos++, entity.getSaleOrderNo());
			ps.setString(pos++, entity.getSupplierName());
			ps.setString(pos++, entity.getReceivePerson());
			ps.setString(pos++, entity.getMobile());
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
			ps.setString(pos++, entity.getPurchaseOrderSheetId());
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
		sb.append("delete from PurchaseOrderSheet ");
		sb.append("where purchaseOrderSheetId = ?");
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

	public PurchaseOrderSheet load(String entityId) throws Exception {
		PurchaseOrderSheet entity = null;
		DBean db = new DBean();
		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Select * from PurchaseOrderSheet ");
		sb.append("where purchaseOrderSheetId = ?");
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

	public List<PurchaseOrderSheet> loadAll() throws Exception {
		List<PurchaseOrderSheet> entities = new ArrayList<PurchaseOrderSheet>();
		DBean db = new DBean();
		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Select * from PurchaseOrderSheet ");
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

	public PurchaseOrderSheet fillEntity(ResultSet rs) throws Exception {
		PurchaseOrderSheet entity = new PurchaseOrderSheet();
		entity.setPurchaseOrderSheetId(rs.getString("purchaseOrderSheetId"));
		entity.setPurchaseOrderNo(rs.getString("purchaseOrderNo"));
		entity.setSaleOrderNo(rs.getString("saleOrderNo"));
		entity.setSupplierName(rs.getString("supplierName"));
		entity.setReceivePerson(rs.getString("receivePerson"));
		entity.setMobile(rs.getString("mobile"));
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

