package com.coral.fundation.model;


/**
 * <p>Title: com.coral.fundation.model.RoleShotCut</p>
 * <p>Description: RoleShotCut entity </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-07-21 16:28 </p>
 */
public class RoleShotCut implements java.io.Serializable  {

	private String roleShotCutId;
	private String roleId;
	private String shotCutId;

	public String getRoleShotCutId() {
		return roleShotCutId;
	}
	public void setRoleShotCutId(String roleShotCutId) {
		this.roleShotCutId=roleShotCutId;
	}

	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId=roleId;
	}

	public String getShotCutId() {
		return shotCutId;
	}
	public void setShotCutId(String shotCutId) {
		this.shotCutId=shotCutId;
	}

}

