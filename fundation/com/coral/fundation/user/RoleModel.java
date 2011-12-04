/**
 * 
 */
package com.coral.fundation.user;

import java.util.List;

import com.coral.fundation.model.Role;
import com.coral.fundation.model.RoleMenu;
import com.coral.fundation.model.RoleShotCut;

/**
 * @author coral.ma
 *
 */
public class RoleModel {

	public Role role;
	public List<RoleMenu> roleMenus;
	public List<RoleShotCut> roleShotCuts;
	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}
	/**
	 * @return the roleMenus
	 */
	public List<RoleMenu> getRoleMenus() {
		return roleMenus;
	}
	/**
	 * @param roleMenus the roleMenus to set
	 */
	public void setRoleMenus(List<RoleMenu> roleMenus) {
		this.roleMenus = roleMenus;
	}
	/**
	 * @return the roleShotCuts
	 */
	public List<RoleShotCut> getRoleShotCuts() {
		return roleShotCuts;
	}
	/**
	 * @param roleShotCuts the roleShotCuts to set
	 */
	public void setRoleShotCuts(List<RoleShotCut> roleShotCuts) {
		this.roleShotCuts = roleShotCuts;
	}
	
}
