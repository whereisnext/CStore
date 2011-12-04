package com.coral.fundation.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import com.coral.fundation.model.Role;

/**
 * <p>Title: com.coral.fundation.model.User</p>
 * <p>Description: User entity </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-07-21 16:28 </p>
 */
public class User implements java.io.Serializable  {

	private String userId;
	private String userName;
	private String password;
	private String roleName;
	private List<Role> roles;
	private Date insertDate = new Date();

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

	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles=roles;
	}

	public Date getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(Date insertDate) {
		this.insertDate=insertDate;
	}

}

