package com.coral.store.basic.dao;

import java.sql.*;
import java.util.List;
import com.coral.store.model.SaleOrderProduct;

/**
 * <p>Title: com.coral.store.basic.dao.ISaleOrderProductDao</p>
 * <p>Description: ISaleOrderProductDao interface </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-09-02 12:02 </p>
 */
public interface ISaleOrderProductDao {

	public SaleOrderProduct create(SaleOrderProduct entity) throws Exception;

	public void update(SaleOrderProduct entity) throws Exception;

	public void remove(String entityId) throws Exception;

	public SaleOrderProduct load(String entityId) throws Exception;

	public List<SaleOrderProduct> loadAll() throws Exception;

	public SaleOrderProduct fillEntity(ResultSet rs) throws Exception;
}

