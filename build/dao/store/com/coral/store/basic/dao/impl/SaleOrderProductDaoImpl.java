package com.coral.store.basic.dao.impl;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import com.coral.fundation.DBean;
import com.coral.store.basic.dao.ISaleOrderProductDao;
import com.coral.store.model.SaleOrderProduct;
import com.coral.fundation.utils.DateUtils;

/**
 * <p>Title: com.coral.store.basic.dao.impl.SaleOrderProductDaoImpl</p>
 * <p>Description: SaleOrderProductDaoImpl interface </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-09-02 12:02 </p>
 */
public class SaleOrderProductDaoImpl implements ISaleOrderProductDao {

	public SaleOrderProduct create(SaleOrderProduct entity) throws Exception {
		DBean db = new DBean();
		PreparedStatement ps = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Insert into SaleOrderProduct(");
		sb.append("saleOrderProductId,");
		sb.append("saleOrderSheetId,");
		sb.append("productName,");
		sb.append("number,");
		sb.append("spec,");
		sb.append("color,");
		sb.append("salePrice,");
		sb.append("mark,");
		sb.append("insertDate");
		sb.append(") values(");
		for (int i = 0; i < 9; i++) {
			sb.append(i == 0 ? "?" : ",?");
		}
		sb.append(")");
		try {
			Connection con = db.getConnection();
			ps = con.prepareStatement(sb.toString());
			int pos = 1;
			ps.setString(pos++, entity.getSaleOrderProductId());
			ps.setString(pos++, entity.getSaleOrderSheetId());
			ps.setString(pos++, entity.getProductName());
			ps.setString(pos++, entity.getNumber());
			ps.setString(pos++, entity.getSpec());
			ps.setString(pos++, entity.getColor());
			ps.setString(pos++, entity.getSalePrice());
			ps.setString(pos++, entity.getMark());
			ps.setDate(pos++, DateUtils.toSqlDate(entity.getInsertDate()));
			ps.execute();
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.closeAll(null, ps, db);
		}
		return entity;
	}

	public void update(SaleOrderProduct entity) throws Exception {
		DBean db = new DBean();
		PreparedStatement ps = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Update SaleOrderProduct set ");
		sb.append("saleOrderSheetId=?,");
		sb.append("productName=?,");
		sb.append("number=?,");
		sb.append("spec=?,");
		sb.append("color=?,");
		sb.append("salePrice=?,");
		sb.append("mark=?,");
		sb.append("insertDate=?");
		sb.append(" where saleOrderProductId = ?");
		try {
			Connection con = db.getConnection();
			ps = con.prepareStatement(sb.toString());
			int pos = 1;
			ps.setString(pos++, entity.getSaleOrderSheetId());
			ps.setString(pos++, entity.getProductName());
			ps.setString(pos++, entity.getNumber());
			ps.setString(pos++, entity.getSpec());
			ps.setString(pos++, entity.getColor());
			ps.setString(pos++, entity.getSalePrice());
			ps.setString(pos++, entity.getMark());
			ps.setDate(pos++, DateUtils.toSqlDate(entity.getInsertDate()));
			ps.setString(pos++, entity.getSaleOrderProductId());
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
		sb.append("delete from SaleOrderProduct ");
		sb.append("where saleOrderProductId = ?");
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

	public SaleOrderProduct load(String entityId) throws Exception {
		SaleOrderProduct entity = null;
		DBean db = new DBean();
		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Select * from SaleOrderProduct ");
		sb.append("where saleOrderProductId = ?");
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

	public List<SaleOrderProduct> loadAll() throws Exception {
		List<SaleOrderProduct> entities = new ArrayList<SaleOrderProduct>();
		DBean db = new DBean();
		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Select * from SaleOrderProduct ");
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

	public SaleOrderProduct fillEntity(ResultSet rs) throws Exception {
		SaleOrderProduct entity = new SaleOrderProduct();
		entity.setSaleOrderProductId(rs.getString("saleOrderProductId"));
		entity.setSaleOrderSheetId(rs.getString("saleOrderSheetId"));
		entity.setProductName(rs.getString("productName"));
		entity.setNumber(rs.getString("number"));
		entity.setSpec(rs.getString("spec"));
		entity.setColor(rs.getString("color"));
		entity.setSalePrice(rs.getString("salePrice"));
		entity.setMark(rs.getString("mark"));
		entity.setInsertDate(rs.getDate("insertDate"));
		return entity;
	}
}

