package com.coral.fundation.model;


/**
 * <p>Title: com.coral.fundation.model.Role</p>
 * <p>Description: Role entity </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-07-21 16:28 </p>
 */
public class Role implements java.io.Serializable  {

	private String roleId;
	private String roleName;

	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId=roleId;
	}

	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName=roleName;
	}

}

