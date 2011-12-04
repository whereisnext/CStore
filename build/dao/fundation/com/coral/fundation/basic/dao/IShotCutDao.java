package com.coral.fundation.basic.dao;

import java.sql.*;
import java.util.List;
import com.coral.fundation.model.ShotCut;

/**
 * <p>Title: com.coral.fundation.basic.dao.IShotCutDao</p>
 * <p>Description: IShotCutDao interface </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-09-02 12:02 </p>
 */
public interface IShotCutDao {

	public ShotCut create(ShotCut entity) throws Exception;

	public void update(ShotCut entity) throws Exception;

	public void remove(String entityId) throws Exception;

	public ShotCut load(String entityId) throws Exception;

	public List<ShotCut> loadAll() throws Exception;

	public ShotCut fillEntity(ResultSet rs) throws Exception;
}

