/**
 * 
 */
package com.coral.fundation.ext.dao;

import com.coral.fundation.model.User;

/**
 * @author coral.ma
 *
 */
public interface IExtUserDao {

	public User login(String userName, String password);
}
