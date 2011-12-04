package com.coral.store.basic.dao;

import java.sql.*;
import java.util.List;
import com.coral.store.model.Stock;

/**
 * <p>Title: com.coral.store.basic.dao.IStockDao</p>
 * <p>Description: IStockDao interface </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-09-02 12:02 </p>
 */
public interface IStockDao {

	public Stock create(Stock entity) throws Exception;

	public void update(Stock entity) throws Exception;

	public void remove(String entityId) throws Exception;

	public Stock load(String entityId) throws Exception;

	public List<Stock> loadAll() throws Exception;

	public Stock fillEntity(ResultSet rs) throws Exception;
}

