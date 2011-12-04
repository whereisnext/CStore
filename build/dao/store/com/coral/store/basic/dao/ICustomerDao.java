package com.coral.store.basic.dao;

import java.sql.*;
import java.util.List;
import com.coral.store.model.Customer;

/**
 * <p>Title: com.coral.store.basic.dao.ICustomerDao</p>
 * <p>Description: ICustomerDao interface </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-09-02 12:02 </p>
 */
public interface ICustomerDao {

	public Customer create(Customer entity) throws Exception;

	public void update(Customer entity) throws Exception;

	public void remove(String entityId) throws Exception;

	public Customer load(String entityId) throws Exception;

	public List<Customer> loadAll() throws Exception;

	public Customer fillEntity(ResultSet rs) throws Exception;
}

