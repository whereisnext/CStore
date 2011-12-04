package com.coral.store.basic.dao;

import java.sql.*;
import com.coral.store.model.OrderSheet;

/**
 * <p>Title: com.coral.store.basic.dao.IOrderSheetDao</p>
 * <p>Description: IOrderSheetDao interface </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-07-21 16:28 </p>
 */
public interface IOrderSheetDao {

	public OrderSheet create(OrderSheet entity) throws Exception;

	public void update(OrderSheet entity) throws Exception;

	public void remove(String entityId) throws Exception;

	public OrderSheet load(String entityId) throws Exception;

	public OrderSheet fillEntity(ResultSet rs) throws Exception;
}

