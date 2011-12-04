package com.coral.store.basic.dao.impl;

import java.sql.*;
import com.coral.fundation.DBean;
import com.coral.store.basic.dao.IOrderSheetDao;
import com.coral.store.model.OrderSheet;
import com.coral.fundation.utils.DateUtils;

/**
 * <p>Title: com.coral.store.basic.dao.impl.OrderSheetDaoImpl</p>
 * <p>Description: OrderSheetDaoImpl interface </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-07-21 16:28 </p>
 */
public class OrderSheetDaoImpl implements IOrderSheetDao {

	public OrderSheet create(OrderSheet entity) throws Exception {
		DBean db = new DBean();
		PreparedStatement ps = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Insert into OrderSheet(");
		sb.append("orderId,");
		sb.append("orderNo,");
		sb.append("customerName,");
		sb.append("receivePerson,");
		sb.append("mobile,");
		sb.append("phone,");
		sb.append("deliverAddress,");
		sb.append("deliverPostcode,");
		sb.append("mark,");
		sb.append("orderPinYin,");
		sb.append("abstractOrder,");
		sb.append("insertDate");
		sb.append(") values(");
		for (int i = 0; i < 12; i++) {
			sb.append(i == 0 ? "?" : ",?");
		}
		sb.append(")");
		try {
			Connection con = db.getConnection();
			ps = con.prepareStatement(sb.toString());
			int pos = 1;
			ps.setString(pos++, entity.getOrderId());
			ps.setString(pos++, entity.getOrderNo());
			ps.setString(pos++, entity.getCustomerName());
			ps.setString(pos++, entity.getReceivePerson());
			ps.setString(pos++, entity.getMobile());
//			ps.setString(pos++, entity.getPhone());
			ps.setString(pos++, entity.getDeliverAddress());
			ps.setString(pos++, entity.getDeliverPostcode());
			ps.setString(pos++, entity.getMark());
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

	public void update(OrderSheet entity) throws Exception {
		DBean db = new DBean();
		PreparedStatement ps = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Update OrderSheet set ");
		sb.append("orderNo=?,");
		sb.append("customerName=?,");
		sb.append("receivePerson=?,");
		sb.append("mobile=?,");
		sb.append("phone=?,");
		sb.append("deliverAddress=?,");
		sb.append("deliverPostcode=?,");
		sb.append("mark=?,");
		sb.append("orderPinYin=?,");
		sb.append("abstractOrder=?,");
		sb.append("insertDate=?");
		sb.append(" where orderId = ?");
		try {
			Connection con = db.getConnection();
			ps = con.prepareStatement(sb.toString());
			int pos = 1;
			ps.setString(pos++, entity.getOrderNo());
			ps.setString(pos++, entity.getCustomerName());
			ps.setString(pos++, entity.getReceivePerson());
			ps.setString(pos++, entity.getMobile());
//			ps.setString(pos++, entity.getPhone());
			ps.setString(pos++, entity.getDeliverAddress());
			ps.setString(pos++, entity.getDeliverPostcode());
			ps.setString(pos++, entity.getMark());
			ps.setString(pos++, entity.getOrderPinYin());
			ps.setString(pos++, entity.getAbstractOrder());
			ps.setDate(pos++, DateUtils.toSqlDate(entity.getInsertDate()));
			ps.setString(pos++, entity.getOrderId());
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
		sb.append("delete from OrderSheet ");
		sb.append("where orderId = ?");
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

	public OrderSheet load(String entityId) throws Exception {
		OrderSheet entity = null;
		DBean db = new DBean();
		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Select * from OrderSheet ");
		sb.append("where orderId = ?");
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

	public OrderSheet fillEntity(ResultSet rs) throws Exception {
		OrderSheet entity = new OrderSheet();
		entity.setOrderId(rs.getString("orderId"));
		entity.setOrderNo(rs.getString("orderNo"));
		entity.setCustomerName(rs.getString("customerName"));
		entity.setReceivePerson(rs.getString("receivePerson"));
		entity.setMobile(rs.getString("mobile"));
//		entity.setPhone(rs.getString("phone"));
		entity.setDeliverAddress(rs.getString("deliverAddress"));
		entity.setDeliverPostcode(rs.getString("deliverPostcode"));
		entity.setMark(rs.getString("mark"));
		entity.setOrderPinYin(rs.getString("orderPinYin"));
		entity.setAbstractOrder(rs.getString("abstractOrder"));
		entity.setInsertDate(rs.getDate("insertDate"));
		return entity;
	}
}

