package com.coral.fundation.service;

import com.coral.fundation.basic.dao.IRoleMenuDao;
import com.coral.cstore.utils.StrUtils;
import com.coral.fundation.IDGenerater;
import com.coral.fundation.Log;
import com.coral.fundation.bean.BeanUtils;
import com.coral.fundation.utils.SqlUtils;
import com.coral.fundation.utils.FoundationUtils;
import java.util.List;
import com.coral.fundation.model.RoleMenu;
/**
 * <p>Title: com.coral.fundation.service.RoleMenuDS</p>
 * <p>Description: RoleMenuDS entity </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-09-02 12:02 </p>
 */
public class RoleMenuDS {

	IRoleMenuDao roleMenuDao = BeanUtils.getBean("roleMenuDao", IRoleMenuDao.class);

	public RoleMenu createRoleMenu(RoleMenu roleMenu) {
		try {
			roleMenu.setRoleMenuId(IDGenerater.generate());
			FoundationUtils.abstractRoleMenu(roleMenu);
			roleMenuDao.create(roleMenu);
		} catch (Exception e) {
			Log.error("Create RoleMenu error.", this.getClass(),e.getCause());
		}
		return roleMenu;
	}

	public RoleMenu updateRoleMenu(RoleMenu roleMenu) {
		try {
			FoundationUtils.abstractRoleMenu(roleMenu);
			roleMenuDao.update(roleMenu);
		} catch (Exception e) {
			Log.error("Update RoleMenu error.", this.getClass(),e.getCause());
		}
		return roleMenu;
	}

	public String deleteRoleMenu(RoleMenu roleMenu) {
		deleteRoleMenu(roleMenu.getRoleMenuId());
		return StrUtils.empty;
	}

	public String deleteRoleMenu(String roleMenuId) {
		try {
			roleMenuDao.remove(roleMenuId);
		} catch (Exception e) {
			Log.error("Delete RoleMenu error.", this.getClass(),e.getCause());
		}
		return StrUtils.empty;
	}

	public RoleMenu loadRoleMenu(String roleMenuId) {
		RoleMenu roleMenu= null;
		try {
			roleMenu = roleMenuDao.load(roleMenuId);
		} catch (Exception e) {
			Log.error("load RoleMenu error.", this.getClass(),e.getCause());
		}
		return roleMenu;
	}

	public List<RoleMenu> loadAllRoleMenu() {
		List<RoleMenu> roleMenuList = null;
		try {
			roleMenuList = roleMenuDao.loadAll();
		} catch (Exception e) {
			Log.error("load RoleMenu error.", this.getClass(),e.getCause());
		}
		return roleMenuList;
	}
}

