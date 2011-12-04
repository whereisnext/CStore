package com.coral.fundation.basic.dao;

import java.sql.*;
import com.coral.fundation.model.ModelMenu;

/**
 * <p>Title: com.coral.fundation.basic.dao.IModelMenuDao</p>
 * <p>Description: IModelMenuDao interface </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-07-20 17:28 </p>
 */
public interface IModelMenuDao {

	public ModelMenu create(ModelMenu entity) throws Exception;

	public void update(ModelMenu entity) throws Exception;

	public void remove(Long entityId) throws Exception;

	public ModelMenu load(Long entityId) throws Exception;

	public ModelMenu fillEntity(ResultSet rs) throws Exception;
}

