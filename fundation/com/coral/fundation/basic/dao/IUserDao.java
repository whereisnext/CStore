package com.coral.fundation.basic.dao;

import java.sql.*;
import com.coral.fundation.model.User;

/**
 * <p>Title: com.coral.fundation.basic.dao.IUserDao</p>
 * <p>Description: IUserDao interface </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-07-21 15:52 </p>
 */
public interface IUserDao {

	public User create(User entity) throws Exception;

	public void update(User entity) throws Exception;

	public void remove(String entityId) throws Exception;

	public User load(String entityId) throws Exception;

	public User fillEntity(ResultSet rs) throws Exception;
}

