package com.coral.fundation.basic.dao;

import java.sql.*;
import com.coral.fundation.model.RoleShotCut;

/**
 * <p>Title: com.coral.fundation.basic.dao.IRoleShotCutDao</p>
 * <p>Description: IRoleShotCutDao interface </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-07-20 17:28 </p>
 */
public interface IRoleShotCutDao {

	public RoleShotCut create(RoleShotCut entity) throws Exception;

	public void update(RoleShotCut entity) throws Exception;

	public void remove(String entityId) throws Exception;

	public RoleShotCut load(String entityId) throws Exception;

	public RoleShotCut fillEntity(ResultSet rs) throws Exception;
}

