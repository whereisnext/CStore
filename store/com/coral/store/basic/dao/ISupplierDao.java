package com.coral.store.basic.dao;

import java.sql.*;
import java.util.List;
import com.coral.store.model.Supplier;

/**
 * <p>Title: com.coral.store.basic.dao.ISupplierDao</p>
 * <p>Description: ISupplierDao interface </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-07-28 14:33 </p>
 */
public interface ISupplierDao {

	public Supplier create(Supplier entity) throws Exception;

	public void update(Supplier entity) throws Exception;

	public void remove(String entityId) throws Exception;

	public Supplier load(String entityId) throws Exception;

	public List<Supplier> loadAll() throws Exception;

	public Supplier fillEntity(ResultSet rs) throws Exception;
}

