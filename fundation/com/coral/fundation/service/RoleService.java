/**
 * 
 */
package com.coral.fundation.service;

import java.util.List;

import com.coral.fundation.bean.BeanUtils;
import com.coral.fundation.ext.dao.IExtRoleModelMenuDao;
import com.coral.fundation.model.ModelMenu;
import com.coral.fundation.user.RoleModel;


/**
 * @author coral.ma
 *
 */
public class RoleService {
	
	private IExtRoleModelMenuDao extRuleModelMenuDao = BeanUtils.getBean("extRoleModelMenuDao", IExtRoleModelMenuDao.class);
	
	public void createRole(RoleModel roleModel) {
		
	}
	
	public List<RoleModel> loadAllRoleModel() {
		return null;
	}
	
	public List<ModelMenu> loadWholeMenu() {
		List<ModelMenu> mainMenu = extRuleModelMenuDao.loadFirstLevelModelMenu();
		mainMenu = querySubMenu(mainMenu);
		return mainMenu;
	}
	
	public List<ModelMenu> querySubMenu(List<ModelMenu> mainMenu) {
		for(ModelMenu menu : mainMenu) {
			List<ModelMenu> subMenus = extRuleModelMenuDao.loadSubLevelModelMenu(menu.getMenuId());
			subMenus = querySubMenu(subMenus);
			menu.setSubMenus(subMenus);
		}
		return mainMenu;
	}

}
