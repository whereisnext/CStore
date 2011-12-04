package com.coral.fundation.basic.dao;

import java.sql.*;
import java.util.List;
import com.coral.fundation.model.BasicInfo;

/**
 * <p>Title: com.coral.fundation.basic.dao.IBasicInfoDao</p>
 * <p>Description: IBasicInfoDao interface </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-09-02 12:02 </p>
 */
public interface IBasicInfoDao {

	public BasicInfo create(BasicInfo entity) throws Exception;

	public void update(BasicInfo entity) throws Exception;

	public void remove(String entityId) throws Exception;

	public BasicInfo load(String entityId) throws Exception;

	public List<BasicInfo> loadAll() throws Exception;

	public BasicInfo fillEntity(ResultSet rs) throws Exception;
}

