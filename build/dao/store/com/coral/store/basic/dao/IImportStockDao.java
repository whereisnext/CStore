package com.coral.store.basic.dao;

import java.sql.*;
import java.util.List;
import com.coral.store.model.ImportStock;

/**
 * <p>Title: com.coral.store.basic.dao.IImportStockDao</p>
 * <p>Description: IImportStockDao interface </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-09-02 12:02 </p>
 */
public interface IImportStockDao {

	public ImportStock create(ImportStock entity) throws Exception;

	public void update(ImportStock entity) throws Exception;

	public void remove(String entityId) throws Exception;

	public ImportStock load(String entityId) throws Exception;

	public List<ImportStock> loadAll() throws Exception;

	public ImportStock fillEntity(ResultSet rs) throws Exception;
}

