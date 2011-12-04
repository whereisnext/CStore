package com.coral.fundation.basic.mysql.dao.impl;

import com.coral.fundation.basic.dao.IModelMenuDao;
import com.coral.fundation.basic.dao.IRoleDao;
import com.coral.fundation.basic.dao.IRoleMenuDao;
import com.coral.fundation.basic.dao.IRoleShotCutDao;
import com.coral.fundation.basic.dao.IShotCutDao;
import com.coral.fundation.basic.dao.IUserDao;
import com.coral.fundation.basic.mysql.dao.impl.ModelMenuDaoImpl;
import com.coral.fundation.basic.mysql.dao.impl.RoleDaoImpl;
import com.coral.fundation.basic.mysql.dao.impl.RoleMenuDaoImpl;
import com.coral.fundation.basic.mysql.dao.impl.RoleShotCutDaoImpl;
import com.coral.fundation.basic.mysql.dao.impl.ShotCutDaoImpl;
import com.coral.fundation.basic.mysql.dao.impl.UserDaoImpl;

/**
 * <p>Title: com.coral.fundation.basic.dao.impl.FundationDaoFactory</p>
 * <p>Description: All system dao factory </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-07-21 15:39 </p>
 */
public class FundationDaoFactory {

	private static IUserDao userDao = new UserDaoImpl();
	public static IUserDao getUserDao() {
		return userDao;
	}

	private static IRoleDao roleDao = new RoleDaoImpl();
	public static IRoleDao getRoleDao() {
		return roleDao;
	}

	private static IModelMenuDao modelMenuDao = new ModelMenuDaoImpl();
	public static IModelMenuDao getModelMenuDao() {
		return modelMenuDao;
	}

	private static IRoleMenuDao roleMenuDao = new RoleMenuDaoImpl();
	public static IRoleMenuDao getRoleMenuDao() {
		return roleMenuDao;
	}

	private static IShotCutDao shotCutDao = new ShotCutDaoImpl();
	public static IShotCutDao getShotCutDao() {
		return shotCutDao;
	}

	private static IRoleShotCutDao roleShotCutDao = new RoleShotCutDaoImpl();
	public static IRoleShotCutDao getRoleShotCutDao() {
		return roleShotCutDao;
	}

}

