package com.coral.fundation.service;

import java.util.Date;
import com.coral.fundation.basic.dao.IUserDao;
import com.coral.cstore.utils.StrUtils;
import com.coral.fundation.IDGenerater;
import com.coral.fundation.Log;
import com.coral.fundation.bean.BeanUtils;
import com.coral.fundation.utils.SqlUtils;
import com.coral.fundation.utils.FoundationUtils;
import java.util.List;
import com.coral.fundation.model.User;
/**
 * <p>Title: com.coral.fundation.service.UserDS</p>
 * <p>Description: UserDS entity </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-09-02 12:02 </p>
 */
public class UserDS {

	IUserDao userDao = BeanUtils.getBean("userDao", IUserDao.class);

	public User createUser(User user) {
		try {
			user.setUserId(IDGenerater.generate());
			FoundationUtils.abstractUser(user);
			userDao.create(user);
		} catch (Exception e) {
			Log.error("Create User error.", this.getClass(),e.getCause());
		}
		return user;
	}

	public User updateUser(User user) {
		try {
			FoundationUtils.abstractUser(user);
			userDao.update(user);
		} catch (Exception e) {
			Log.error("Update User error.", this.getClass(),e.getCause());
		}
		return user;
	}

	public String deleteUser(User user) {
		deleteUser(user.getUserId());
		return StrUtils.empty;
	}

	public String deleteUser(String userId) {
		try {
			userDao.remove(userId);
		} catch (Exception e) {
			Log.error("Delete User error.", this.getClass(),e.getCause());
		}
		return StrUtils.empty;
	}

	public User loadUser(String userId) {
		User user= null;
		try {
			user = userDao.load(userId);
		} catch (Exception e) {
			Log.error("load User error.", this.getClass(),e.getCause());
		}
		return user;
	}

	public List<User> loadAllUser() {
		List<User> userList = null;
		try {
			userList = userDao.loadAll();
		} catch (Exception e) {
			Log.error("load User error.", this.getClass(),e.getCause());
		}
		return userList;
	}
}

