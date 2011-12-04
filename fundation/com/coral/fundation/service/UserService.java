/**
 * 
 */
package com.coral.fundation.service;

import java.util.List;

import com.coral.fundation.bean.BeanUtils;
import com.coral.fundation.ext.dao.IExtRoleModelMenuDao;
import com.coral.fundation.ext.dao.IExtRoleShotCutDao;
import com.coral.fundation.ext.dao.IExtUserDao;
import com.coral.fundation.model.ModelMenu;
import com.coral.fundation.model.User;
import com.coral.fundation.user.UserModel;

/**
 * @author coral.ma
 *
 */
public class UserService {
	
	private UserDS userDS = new UserDS();
	private RoleDS roleDS = new RoleDS();
	private IExtUserDao extUserDao = BeanUtils.getBean("extUserDao", IExtUserDao.class);
	private IExtRoleModelMenuDao extRuleModelMenuDao = BeanUtils.getBean("extRoleModelMenuDao", IExtRoleModelMenuDao.class);
	private IExtRoleShotCutDao extRoleShotCut = BeanUtils.getBean("extRoleShotCutDao", IExtRoleShotCutDao.class);
	
	public UserModel login(String userName, String password) {
		UserModel userModel = new UserModel();
		User user = extUserDao.login(userName, password);
		if(user == null) return null;
		String roleId = user.getRoleId();
		user.setRole(roleDS.loadRole(roleId));
		userModel.setUser(user);
		List<ModelMenu> mainMenu = extRuleModelMenuDao.loadFirstLevelModelMenuByRole(roleId);
		mainMenu = querySubMenu(mainMenu, roleId);
		userModel.setMenus(mainMenu);
		userModel.setShotCuts(extRoleShotCut.loadShotCutByRole(roleId));
		return userModel;
	}
	
	public List<ModelMenu> querySubMenu(List<ModelMenu> mainMenu, String roleId) {
		for(ModelMenu menu : mainMenu) {
			List<ModelMenu> subMenus = extRuleModelMenuDao.loadSubLevelModelMenuByRole(roleId, menu.getMenuId());
			subMenus = querySubMenu(subMenus,roleId);
			menu.setSubMenus(subMenus);
		}
		return mainMenu;
	}

	public User createUser(User user) {
		return userDS.createUser(user);
	}
	
	public User updateUser(User user) {
		return userDS.updateUser(user);
	}
}
