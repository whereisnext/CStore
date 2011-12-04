package com.coral.fundation.model;

import java.util.Date;

/**
 * <p>Title: com.coral.fundation.model.User</p>
 * <p>Description: User entity </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-09-02 12:02 </p>
 */
public class User implements java.io.Serializable  {

	private String userId;
	private String userName;
	private String password;
	private String roleName;
	private String roleId;
	private Role role;
	private Date insertDate = new Date();
	private String abstractUser;

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId=userId;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName=userName;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password=password;
	}

	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName=roleName;
	}

	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId=roleId;
	}

	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role=role;
	}

	public Date getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(Date insertDate) {
		this.insertDate=insertDate;
	}

	public String getAbstractUser() {
		return abstractUser;
	}
	public void setAbstractUser(String abstractUser) {
		this.abstractUser=abstractUser;
	}

}

