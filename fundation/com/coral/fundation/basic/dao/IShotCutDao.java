package com.coral.fundation.basic.dao;

import java.sql.*;
import com.coral.fundation.model.ShotCut;

/**
 * <p>Title: com.coral.fundation.basic.dao.IShotCutDao</p>
 * <p>Description: IShotCutDao interface </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-07-20 17:28 </p>
 */
public interface IShotCutDao {

	public ShotCut create(ShotCut entity) throws Exception;

	public void update(ShotCut entity) throws Exception;

	public void remove(String entityId) throws Exception;

	public ShotCut load(String entityId) throws Exception;

	public ShotCut fillEntity(ResultSet rs) throws Exception;
}

