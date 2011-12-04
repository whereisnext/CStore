package com.coral.store.basic.dao.impl;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import com.coral.fundation.DBean;
import com.coral.store.basic.dao.IStockDao;
import com.coral.store.model.Stock;
import com.coral.fundation.utils.DateUtils;

/**
 * <p>Title: com.coral.store.basic.dao.impl.StockDaoImpl</p>
 * <p>Description: StockDaoImpl interface </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-09-02 12:02 </p>
 */
public class StockDaoImpl implements IStockDao {

	public Stock create(Stock entity) throws Exception {
		DBean db = new DBean();
		PreparedStatement ps = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Insert into Stock(");
		sb.append("stockId,");
		sb.append("supplierName,");
		sb.append("productName,");
		sb.append("number,");
		sb.append("spec,");
		sb.append("color,");
		sb.append("averagePrice,");
		sb.append("mark,");
		sb.append("warehouseLocation,");
		sb.append("weight,");
		sb.append("insertDate");
		sb.append(") values(");
		for (int i = 0; i < 11; i++) {
			sb.append(i == 0 ? "?" : ",?");
		}
		sb.append(")");
		try {
			Connection con = db.getConnection();
			ps = con.prepareStatement(sb.toString());
			int pos = 1;
			ps.setString(pos++, entity.getStockId());
			ps.setString(pos++, entity.getSupplierName());
			ps.setString(pos++, entity.getProductName());
			ps.setString(pos++, entity.getNumber());
			ps.setString(pos++, entity.getSpec());
			ps.setString(pos++, entity.getColor());
			ps.setString(pos++, entity.getAveragePrice());
			ps.setString(pos++, entity.getMark());
			ps.setString(pos++, entity.getWarehouseLocation());
			ps.setLong(pos++, entity.getWeight());
			ps.setDate(pos++, DateUtils.toSqlDate(entity.getInsertDate()));
			ps.execute();
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.closeAll(null, ps, db);
		}
		return entity;
	}

	public void update(Stock entity) throws Exception {
		DBean db = new DBean();
		PreparedStatement ps = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Update Stock set ");
		sb.append("supplierName=?,");
		sb.append("productName=?,");
		sb.append("number=?,");
		sb.append("spec=?,");
		sb.append("color=?,");
		sb.append("averagePrice=?,");
		sb.append("mark=?,");
		sb.append("warehouseLocation=?,");
		sb.append("weight=?,");
		sb.append("insertDate=?");
		sb.append(" where stockId = ?");
		try {
			Connection con = db.getConnection();
			ps = con.prepareStatement(sb.toString());
			int pos = 1;
			ps.setString(pos++, entity.getSupplierName());
			ps.setString(pos++, entity.getProductName());
			ps.setString(pos++, entity.getNumber());
			ps.setString(pos++, entity.getSpec());
			ps.setString(pos++, entity.getColor());
			ps.setString(pos++, entity.getAveragePrice());
			ps.setString(pos++, entity.getMark());
			ps.setString(pos++, entity.getWarehouseLocation());
			ps.setLong(pos++, entity.getWeight());
			ps.setDate(pos++, DateUtils.toSqlDate(entity.getInsertDate()));
			ps.setString(pos++, entity.getStockId());
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
		sb.append("delete from Stock ");
		sb.append("where stockId = ?");
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

	public Stock load(String entityId) throws Exception {
		Stock entity = null;
		DBean db = new DBean();
		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Select * from Stock ");
		sb.append("where stockId = ?");
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

	public List<Stock> loadAll() throws Exception {
		List<Stock> entities = new ArrayList<Stock>();
		DBean db = new DBean();
		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Select * from Stock ");
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

	public Stock fillEntity(ResultSet rs) throws Exception {
		Stock entity = new Stock();
		entity.setStockId(rs.getString("stockId"));
		entity.setSupplierName(rs.getString("supplierName"));
		entity.setProductName(rs.getString("productName"));
		entity.setNumber(rs.getString("number"));
		entity.setSpec(rs.getString("spec"));
		entity.setColor(rs.getString("color"));
		entity.setAveragePrice(rs.getString("averagePrice"));
		entity.setMark(rs.getString("mark"));
		entity.setWarehouseLocation(rs.getString("warehouseLocation"));
		entity.setWeight(rs.getLong("weight"));
		entity.setInsertDate(rs.getDate("insertDate"));
		return entity;
	}
}

