package com.coral.fundation.service;

import com.coral.fundation.basic.dao.IRoleDao;
import com.coral.cstore.utils.StrUtils;
import com.coral.fundation.IDGenerater;
import com.coral.fundation.Log;
import com.coral.fundation.bean.BeanUtils;
import com.coral.fundation.utils.SqlUtils;
import com.coral.fundation.utils.FoundationUtils;
import java.util.List;
import com.coral.fundation.model.Role;
/**
 * <p>Title: com.coral.fundation.service.RoleDS</p>
 * <p>Description: RoleDS entity </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-09-02 12:02 </p>
 */
public class RoleDS {

	IRoleDao roleDao = BeanUtils.getBean("roleDao", IRoleDao.class);

	public Role createRole(Role role) {
		try {
			role.setRoleId(IDGenerater.generate());
			FoundationUtils.abstractRole(role);
			roleDao.create(role);
		} catch (Exception e) {
			Log.error("Create Role error.", this.getClass(),e.getCause());
		}
		return role;
	}

	public Role updateRole(Role role) {
		try {
			FoundationUtils.abstractRole(role);
			roleDao.update(role);
		} catch (Exception e) {
			Log.error("Update Role error.", this.getClass(),e.getCause());
		}
		return role;
	}

	public String deleteRole(Role role) {
		deleteRole(role.getRoleId());
		return StrUtils.empty;
	}

	public String deleteRole(String roleId) {
		try {
			roleDao.remove(roleId);
		} catch (Exception e) {
			Log.error("Delete Role error.", this.getClass(),e.getCause());
		}
		return StrUtils.empty;
	}

	public Role loadRole(String roleId) {
		Role role= null;
		try {
			role = roleDao.load(roleId);
		} catch (Exception e) {
			Log.error("load Role error.", this.getClass(),e.getCause());
		}
		return role;
	}

	public List<Role> loadAllRole() {
		List<Role> roleList = null;
		try {
			roleList = roleDao.loadAll();
		} catch (Exception e) {
			Log.error("load Role error.", this.getClass(),e.getCause());
		}
		return roleList;
	}
}

