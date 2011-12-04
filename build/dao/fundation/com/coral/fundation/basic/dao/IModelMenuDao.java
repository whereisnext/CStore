package com.coral.fundation.basic.dao;

import java.sql.*;
import java.util.List;
import com.coral.fundation.model.ModelMenu;

/**
 * <p>Title: com.coral.fundation.basic.dao.IModelMenuDao</p>
 * <p>Description: IModelMenuDao interface </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-09-02 12:02 </p>
 */
public interface IModelMenuDao {

	public ModelMenu create(ModelMenu entity) throws Exception;

	public void update(ModelMenu entity) throws Exception;

	public void remove(String entityId) throws Exception;

	public ModelMenu load(String entityId) throws Exception;

	public List<ModelMenu> loadAll() throws Exception;

	public ModelMenu fillEntity(ResultSet rs) throws Exception;
}

