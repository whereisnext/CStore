package com.coral.store.basic.dao.impl;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import com.coral.fundation.DBean;
import com.coral.store.basic.dao.IProductDao;
import com.coral.store.model.Product;

/**
 * <p>Title: com.coral.store.basic.dao.impl.ProductDaoImpl</p>
 * <p>Description: ProductDaoImpl interface </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-07-28 14:41 </p>
 */
public class ProductDaoImpl implements IProductDao {

	public Product create(Product entity) throws Exception {
		DBean db = new DBean();
		PreparedStatement ps = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Insert into Product(");
		sb.append("productId,");
		sb.append("productCode,");
		sb.append("productName,");
		sb.append("brand,");
		sb.append("unit,");
		sb.append("spec,");
		sb.append("color,");
		sb.append("buyPrice,");
		sb.append("mark,");
		sb.append("supplierId,");
		sb.append("supplierName");
		sb.append(") values(");
		for (int i = 0; i < 11; i++) {
			sb.append(i == 0 ? "?" : ",?");
		}
		sb.append(")");
		try {
			Connection con = db.getConnection();
			ps = con.prepareStatement(sb.toString());
			int pos = 1;
			ps.setString(pos++, entity.getProductId());
			ps.setString(pos++, entity.getProductCode());
			ps.setString(pos++, entity.getProductName());
			ps.setString(pos++, entity.getBrand());
			ps.setString(pos++, entity.getUnit());
			ps.setString(pos++, entity.getSpec());
			ps.setString(pos++, entity.getColor());
			ps.setString(pos++, entity.getBuyPrice());
			ps.setString(pos++, entity.getMark());
			ps.setString(pos++, entity.getSupplierId());
			ps.setString(pos++, entity.getSupplierName());
			ps.execute();
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.closeAll(null, ps, db);
		}
		return entity;
	}

	public void update(Product entity) throws Exception {
		DBean db = new DBean();
		PreparedStatement ps = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Update Product set ");
		sb.append("productCode=?,");
		sb.append("productName=?,");
		sb.append("brand=?,");
		sb.append("unit=?,");
		sb.append("spec=?,");
		sb.append("color=?,");
		sb.append("buyPrice=?,");
		sb.append("mark=?,");
		sb.append("supplierId=?,");
		sb.append("supplierName=?");
		sb.append(" where productId = ?");
		try {
			Connection con = db.getConnection();
			ps = con.prepareStatement(sb.toString());
			int pos = 1;
			ps.setString(pos++, entity.getProductCode());
			ps.setString(pos++, entity.getProductName());
			ps.setString(pos++, entity.getBrand());
			ps.setString(pos++, entity.getUnit());
			ps.setString(pos++, entity.getSpec());
			ps.setString(pos++, entity.getColor());
			ps.setString(pos++, entity.getBuyPrice());
			ps.setString(pos++, entity.getMark());
			ps.setString(pos++, entity.getSupplierId());
			ps.setString(pos++, entity.getSupplierName());
			ps.setString(pos++, entity.getProductId());
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
		sb.append("delete from Product ");
		sb.append("where productId = ?");
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

	public Product load(String entityId) throws Exception {
		Product entity = null;
		DBean db = new DBean();
		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Select * from Product ");
		sb.append("where productId = ?");
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

	public List<Product> loadAll() throws Exception {
		List<Product> entities = new ArrayList<Product>();
		DBean db = new DBean();
		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();
		sb.append("Select * from Product ");
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

	public Product fillEntity(ResultSet rs) throws Exception {
		Product entity = new Product();
		entity.setProductId(rs.getString("productId"));
		entity.setProductCode(rs.getString("productCode"));
		entity.setProductName(rs.getString("productName"));
		entity.setBrand(rs.getString("brand"));
		entity.setUnit(rs.getString("unit"));
		entity.setSpec(rs.getString("spec"));
		entity.setColor(rs.getString("color"));
		entity.setBuyPrice(rs.getString("buyPrice"));
		entity.setMark(rs.getString("mark"));
		entity.setSupplierId(rs.getString("supplierId"));
		entity.setSupplierName(rs.getString("supplierName"));
		return entity;
	}
}

