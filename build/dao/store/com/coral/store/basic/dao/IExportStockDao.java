package com.coral.store.basic.dao;

import java.sql.*;
import java.util.List;
import com.coral.store.model.ExportStock;

/**
 * <p>Title: com.coral.store.basic.dao.IExportStockDao</p>
 * <p>Description: IExportStockDao interface </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-09-02 12:02 </p>
 */
public interface IExportStockDao {

	public ExportStock create(ExportStock entity) throws Exception;

	public void update(ExportStock entity) throws Exception;

	public void remove(String entityId) throws Exception;

	public ExportStock load(String entityId) throws Exception;

	public List<ExportStock> loadAll() throws Exception;

	public ExportStock fillEntity(ResultSet rs) throws Exception;
}

