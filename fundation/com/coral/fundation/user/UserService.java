/**
 * 
 */
package com.coral.fundation.user;

import com.coral.fundation.IDGenerater;
import com.coral.fundation.Log;
import com.coral.fundation.basic.dao.IUserDao;
import com.coral.fundation.basic.mysql.dao.impl.FundationDaoFactory;
import com.coral.fundation.model.User;

/**
 * @author coral.ma
 *
 */
public class UserService {

	public String createUser(User user) {
		if(user.getUserId() != null) {
			return "User already existed";
		} else {
			user.setUserId(IDGenerater.generate());
		}
		IUserDao dao = FundationDaoFactory.getUserDao();
		try {
			dao.create(user);
		} catch (Exception e) {
			Log.error("Create User error.", this.getClass(), e.getCause());
		}
		return "";
	}
	
	public String updateUser(User user) {
		IUserDao dao = FundationDaoFactory.getUserDao();
		try {
			dao.update(user);
		} catch (Exception e) {
			Log.error("Create User error.", this.getClass(), e.getCause());
		}
		return "";
	}
}
