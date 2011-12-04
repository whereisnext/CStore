package com.coral.fundation.model;


/**
 * <p>Title: com.coral.fundation.model.RoleMenu</p>
 * <p>Description: RoleMenu entity </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-07-21 16:28 </p>
 */
public class RoleMenu implements java.io.Serializable  {

	private String roleMenuId;
	private String roleId;
	private String menuId;

	public String getRoleMenuId() {
		return roleMenuId;
	}
	public void setRoleMenuId(String roleMenuId) {
		this.roleMenuId=roleMenuId;
	}

	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId=roleId;
	}

	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId=menuId;
	}

}

