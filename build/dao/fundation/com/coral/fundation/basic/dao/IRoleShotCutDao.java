package com.coral.fundation.basic.dao;

import java.sql.*;
import java.util.List;
import com.coral.fundation.model.RoleShotCut;

/**
 * <p>Title: com.coral.fundation.basic.dao.IRoleShotCutDao</p>
 * <p>Description: IRoleShotCutDao interface </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-09-02 12:02 </p>
 */
public interface IRoleShotCutDao {

	public RoleShotCut create(RoleShotCut entity) throws Exception;

	public void update(RoleShotCut entity) throws Exception;

	public void remove(String entityId) throws Exception;

	public RoleShotCut load(String entityId) throws Exception;

	public List<RoleShotCut> loadAll() throws Exception;

	public RoleShotCut fillEntity(ResultSet rs) throws Exception;
}

