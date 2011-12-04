package com.coral.store.basic.dao.impl;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import com.coral.fundation.DBean;
import com.coral.store.basic.dao.IPurchaseOrderProductDao;
import com.coral.store.model.PurchaseOrderProduct;
import com.coral.fundation.utils.DateUtils;

/**
 * <p>Title: com.coral.store.basic.dao.impl.PurchaseOrderProductDaoImpl</p>
 * <p>Description: PurchaseOrderProductDaoImpl interface </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-09-02 12:02 </p>
 */
public class PurchaseOrderProductDaoImpl implements IPurchaseOrderProductDao {

	public PurchaseOrderProduct create(PurchaseOrderProduct entity) throws Exception {
		DBean db = new DBean();
		PreparedStatement ps = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Insert into PurchaseOrderProduct(");
		sb.append("purchaseOrderProductId,");
		sb.append("purchaseOrderSheetId,");
		sb.append("supplierName,");
		sb.append("productName,");
		sb.append("spec,");
		sb.append("color,");
		sb.append("number,");
		sb.append("totalSalePrice,");
		sb.append("mark,");
		sb.append("insertDate");
		sb.append(") values(");
		for (int i = 0; i < 10; i++) {
			sb.append(i == 0 ? "?" : ",?");
		}
		sb.append(")");
		try {
			Connection con = db.getConnection();
			ps = con.prepareStatement(sb.toString());
			int pos = 1;
			ps.setString(pos++, entity.getPurchaseOrderProductId());
			ps.setString(pos++, entity.getPurchaseOrderSheetId());
			ps.setString(pos++, entity.getSupplierName());
			ps.setString(pos++, entity.getProductName());
			ps.setString(pos++, entity.getSpec());
			ps.setString(pos++, entity.getColor());
			ps.setString(pos++, entity.getNumber());
			ps.setString(pos++, entity.getTotalSalePrice());
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

	public void update(PurchaseOrderProduct entity) throws Exception {
		DBean db = new DBean();
		PreparedStatement ps = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Update PurchaseOrderProduct set ");
		sb.append("purchaseOrderSheetId=?,");
		sb.append("supplierName=?,");
		sb.append("productName=?,");
		sb.append("spec=?,");
		sb.append("color=?,");
		sb.append("number=?,");
		sb.append("totalSalePrice=?,");
		sb.append("mark=?,");
		sb.append("insertDate=?");
		sb.append(" where purchaseOrderProductId = ?");
		try {
			Connection con = db.getConnection();
			ps = con.prepareStatement(sb.toString());
			int pos = 1;
			ps.setString(pos++, entity.getPurchaseOrderSheetId());
			ps.setString(pos++, entity.getSupplierName());
			ps.setString(pos++, entity.getProductName());
			ps.setString(pos++, entity.getSpec());
			ps.setString(pos++, entity.getColor());
			ps.setString(pos++, entity.getNumber());
			ps.setString(pos++, entity.getTotalSalePrice());
			ps.setString(pos++, entity.getMark());
			ps.setDate(pos++, DateUtils.toSqlDate(entity.getInsertDate()));
			ps.setString(pos++, entity.getPurchaseOrderProductId());
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
		sb.append("delete from PurchaseOrderProduct ");
		sb.append("where purchaseOrderProductId = ?");
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

	public PurchaseOrderProduct load(String entityId) throws Exception {
		PurchaseOrderProduct entity = null;
		DBean db = new DBean();
		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Select * from PurchaseOrderProduct ");
		sb.append("where purchaseOrderProductId = ?");
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

	public List<PurchaseOrderProduct> loadAll() throws Exception {
		List<PurchaseOrderProduct> entities = new ArrayList<PurchaseOrderProduct>();
		DBean db = new DBean();
		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Select * from PurchaseOrderProduct ");
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

	public PurchaseOrderProduct fillEntity(ResultSet rs) throws Exception {
		PurchaseOrderProduct entity = new PurchaseOrderProduct();
		entity.setPurchaseOrderProductId(rs.getString("purchaseOrderProductId"));
		entity.setPurchaseOrderSheetId(rs.getString("purchaseOrderSheetId"));
		entity.setSupplierName(rs.getString("supplierName"));
		entity.setProductName(rs.getString("productName"));
		entity.setSpec(rs.getString("spec"));
		entity.setColor(rs.getString("color"));
		entity.setNumber(rs.getString("number"));
		entity.setTotalSalePrice(rs.getString("totalSalePrice"));
		entity.setMark(rs.getString("mark"));
		entity.setInsertDate(rs.getDate("insertDate"));
		return entity;
	}
}

