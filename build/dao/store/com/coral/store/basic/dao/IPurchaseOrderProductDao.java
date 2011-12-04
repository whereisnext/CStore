package com.coral.store.basic.dao;

import java.sql.*;
import java.util.List;
import com.coral.store.model.PurchaseOrderProduct;

/**
 * <p>Title: com.coral.store.basic.dao.IPurchaseOrderProductDao</p>
 * <p>Description: IPurchaseOrderProductDao interface </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-09-02 12:02 </p>
 */
public interface IPurchaseOrderProductDao {

	public PurchaseOrderProduct create(PurchaseOrderProduct entity) throws Exception;

	public void update(PurchaseOrderProduct entity) throws Exception;

	public void remove(String entityId) throws Exception;

	public PurchaseOrderProduct load(String entityId) throws Exception;

	public List<PurchaseOrderProduct> loadAll() throws Exception;

	public PurchaseOrderProduct fillEntity(ResultSet rs) throws Exception;
}

