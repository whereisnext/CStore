package com.coral.fundation.service;

import com.coral.fundation.basic.dao.IRoleShotCutDao;
import com.coral.cstore.utils.StrUtils;
import com.coral.fundation.IDGenerater;
import com.coral.fundation.Log;
import com.coral.fundation.bean.BeanUtils;
import com.coral.fundation.utils.SqlUtils;
import com.coral.fundation.utils.FoundationUtils;
import java.util.List;
import com.coral.fundation.model.RoleShotCut;
/**
 * <p>Title: com.coral.fundation.service.RoleShotCutDS</p>
 * <p>Description: RoleShotCutDS entity </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-09-02 12:02 </p>
 */
public class RoleShotCutDS {

	IRoleShotCutDao roleShotCutDao = BeanUtils.getBean("roleShotCutDao", IRoleShotCutDao.class);

	public RoleShotCut createRoleShotCut(RoleShotCut roleShotCut) {
		try {
			roleShotCut.setRoleShotCutId(IDGenerater.generate());
			FoundationUtils.abstractRoleShotCut(roleShotCut);
			roleShotCutDao.create(roleShotCut);
		} catch (Exception e) {
			Log.error("Create RoleShotCut error.", this.getClass(),e.getCause());
		}
		return roleShotCut;
	}

	public RoleShotCut updateRoleShotCut(RoleShotCut roleShotCut) {
		try {
			FoundationUtils.abstractRoleShotCut(roleShotCut);
			roleShotCutDao.update(roleShotCut);
		} catch (Exception e) {
			Log.error("Update RoleShotCut error.", this.getClass(),e.getCause());
		}
		return roleShotCut;
	}

	public String deleteRoleShotCut(RoleShotCut roleShotCut) {
		deleteRoleShotCut(roleShotCut.getRoleShotCutId());
		return StrUtils.empty;
	}

	public String deleteRoleShotCut(String roleShotCutId) {
		try {
			roleShotCutDao.remove(roleShotCutId);
		} catch (Exception e) {
			Log.error("Delete RoleShotCut error.", this.getClass(),e.getCause());
		}
		return StrUtils.empty;
	}

	public RoleShotCut loadRoleShotCut(String roleShotCutId) {
		RoleShotCut roleShotCut= null;
		try {
			roleShotCut = roleShotCutDao.load(roleShotCutId);
		} catch (Exception e) {
			Log.error("load RoleShotCut error.", this.getClass(),e.getCause());
		}
		return roleShotCut;
	}

	public List<RoleShotCut> loadAllRoleShotCut() {
		List<RoleShotCut> roleShotCutList = null;
		try {
			roleShotCutList = roleShotCutDao.loadAll();
		} catch (Exception e) {
			Log.error("load RoleShotCut error.", this.getClass(),e.getCause());
		}
		return roleShotCutList;
	}
}

