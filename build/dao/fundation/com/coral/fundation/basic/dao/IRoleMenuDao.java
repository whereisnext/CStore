package com.coral.fundation.basic.dao;

import java.sql.*;
import java.util.List;
import com.coral.fundation.model.RoleMenu;

/**
 * <p>Title: com.coral.fundation.basic.dao.IRoleMenuDao</p>
 * <p>Description: IRoleMenuDao interface </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-09-02 12:02 </p>
 */
public interface IRoleMenuDao {

	public RoleMenu create(RoleMenu entity) throws Exception;

	public void update(RoleMenu entity) throws Exception;

	public void remove(String entityId) throws Exception;

	public RoleMenu load(String entityId) throws Exception;

	public List<RoleMenu> loadAll() throws Exception;

	public RoleMenu fillEntity(ResultSet rs) throws Exception;
}

