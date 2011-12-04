package com.coral.fundation.service;

import com.coral.fundation.basic.dao.IShotCutDao;
import com.coral.cstore.utils.StrUtils;
import com.coral.fundation.IDGenerater;
import com.coral.fundation.Log;
import com.coral.fundation.bean.BeanUtils;
import com.coral.fundation.utils.SqlUtils;
import com.coral.fundation.utils.FoundationUtils;
import java.util.List;
import com.coral.fundation.model.ShotCut;
/**
 * <p>Title: com.coral.fundation.service.ShotCutDS</p>
 * <p>Description: ShotCutDS entity </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-09-02 12:02 </p>
 */
public class ShotCutDS {

	IShotCutDao shotCutDao = BeanUtils.getBean("shotCutDao", IShotCutDao.class);

	public ShotCut createShotCut(ShotCut shotCut) {
		try {
			shotCut.setShotCutId(IDGenerater.generate());
			FoundationUtils.abstractShotCut(shotCut);
			shotCutDao.create(shotCut);
		} catch (Exception e) {
			Log.error("Create ShotCut error.", this.getClass(),e.getCause());
		}
		return shotCut;
	}

	public ShotCut updateShotCut(ShotCut shotCut) {
		try {
			FoundationUtils.abstractShotCut(shotCut);
			shotCutDao.update(shotCut);
		} catch (Exception e) {
			Log.error("Update ShotCut error.", this.getClass(),e.getCause());
		}
		return shotCut;
	}

	public String deleteShotCut(ShotCut shotCut) {
		deleteShotCut(shotCut.getShotCutId());
		return StrUtils.empty;
	}

	public String deleteShotCut(String shotCutId) {
		try {
			shotCutDao.remove(shotCutId);
		} catch (Exception e) {
			Log.error("Delete ShotCut error.", this.getClass(),e.getCause());
		}
		return StrUtils.empty;
	}

	public ShotCut loadShotCut(String shotCutId) {
		ShotCut shotCut= null;
		try {
			shotCut = shotCutDao.load(shotCutId);
		} catch (Exception e) {
			Log.error("load ShotCut error.", this.getClass(),e.getCause());
		}
		return shotCut;
	}

	public List<ShotCut> loadAllShotCut() {
		List<ShotCut> shotCutList = null;
		try {
			shotCutList = shotCutDao.loadAll();
		} catch (Exception e) {
			Log.error("load ShotCut error.", this.getClass(),e.getCause());
		}
		return shotCutList;
	}
}

