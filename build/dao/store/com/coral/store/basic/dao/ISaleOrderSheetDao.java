package com.coral.store.basic.dao;

import java.sql.*;
import java.util.List;
import com.coral.store.model.SaleOrderSheet;

/**
 * <p>Title: com.coral.store.basic.dao.ISaleOrderSheetDao</p>
 * <p>Description: ISaleOrderSheetDao interface </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-09-02 12:02 </p>
 */
public interface ISaleOrderSheetDao {

	public SaleOrderSheet create(SaleOrderSheet entity) throws Exception;

	public void update(SaleOrderSheet entity) throws Exception;

	public void remove(String entityId) throws Exception;

	public SaleOrderSheet load(String entityId) throws Exception;

	public List<SaleOrderSheet> loadAll() throws Exception;

	public SaleOrderSheet fillEntity(ResultSet rs) throws Exception;
}

