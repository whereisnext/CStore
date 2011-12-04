package com.coral.fundation.model;


/**
 * <p>Title: com.coral.fundation.model.RoleShotCut</p>
 * <p>Description: RoleShotCut entity </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-09-02 12:02 </p>
 */
public class RoleShotCut implements java.io.Serializable  {

	private String roleShotCutId;
	private String roleId;
	private String shotCutId;
	private Long orderIndex;
	private String abstractRoleShotCut;

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

	public Long getOrderIndex() {
		return orderIndex;
	}
	public void setOrderIndex(Long orderIndex) {
		this.orderIndex=orderIndex;
	}

	public String getAbstractRoleShotCut() {
		return abstractRoleShotCut;
	}
	public void setAbstractRoleShotCut(String abstractRoleShotCut) {
		this.abstractRoleShotCut=abstractRoleShotCut;
	}

}

