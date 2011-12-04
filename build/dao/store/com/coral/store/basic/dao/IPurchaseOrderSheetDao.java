package com.coral.store.basic.dao;

import java.sql.*;
import java.util.List;
import com.coral.store.model.PurchaseOrderSheet;

/**
 * <p>Title: com.coral.store.basic.dao.IPurchaseOrderSheetDao</p>
 * <p>Description: IPurchaseOrderSheetDao interface </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-09-02 12:02 </p>
 */
public interface IPurchaseOrderSheetDao {

	public PurchaseOrderSheet create(PurchaseOrderSheet entity) throws Exception;

	public void update(PurchaseOrderSheet entity) throws Exception;

	public void remove(String entityId) throws Exception;

	public PurchaseOrderSheet load(String entityId) throws Exception;

	public List<PurchaseOrderSheet> loadAll() throws Exception;

	public PurchaseOrderSheet fillEntity(ResultSet rs) throws Exception;
}

