package com.coral.fundation.basic.dao;

import java.sql.*;
import java.util.List;
import com.coral.fundation.model.Role;

/**
 * <p>Title: com.coral.fundation.basic.dao.IRoleDao</p>
 * <p>Description: IRoleDao interface </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-09-02 12:02 </p>
 */
public interface IRoleDao {

	public Role create(Role entity) throws Exception;

	public void update(Role entity) throws Exception;

	public void remove(String entityId) throws Exception;

	public Role load(String entityId) throws Exception;

	public List<Role> loadAll() throws Exception;

	public Role fillEntity(ResultSet rs) throws Exception;
}

