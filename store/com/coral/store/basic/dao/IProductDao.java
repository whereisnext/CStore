package com.coral.store.basic.dao;

import java.sql.*;
import java.util.List;
import com.coral.store.model.Product;

/**
 * <p>Title: com.coral.store.basic.dao.IProductDao</p>
 * <p>Description: IProductDao interface </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-07-28 14:41 </p>
 */
public interface IProductDao {

	public Product create(Product entity) throws Exception;

	public void update(Product entity) throws Exception;

	public void remove(String entityId) throws Exception;

	public Product load(String entityId) throws Exception;

	public List<Product> loadAll() throws Exception;

	public Product fillEntity(ResultSet rs) throws Exception;
}

