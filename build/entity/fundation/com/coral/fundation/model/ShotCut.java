package com.coral.fundation.model;


/**
 * <p>Title: com.coral.fundation.model.ShotCut</p>
 * <p>Description: ShotCut entity </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-09-02 12:02 </p>
 */
public class ShotCut implements java.io.Serializable  {

	private String shotCutId;
	private Long menuId;
	private String icon;
	private String shotCutName;
	private String viewName;
	private String abstractShotCut;

	public String getShotCutId() {
		return shotCutId;
	}
	public void setShotCutId(String shotCutId) {
		this.shotCutId=shotCutId;
	}

	public Long getMenuId() {
		return menuId;
	}
	public void setMenuId(Long menuId) {
		this.menuId=menuId;
	}

	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon=icon;
	}

	public String getShotCutName() {
		return shotCutName;
	}
	public void setShotCutName(String shotCutName) {
		this.shotCutName=shotCutName;
	}

	public String getViewName() {
		return viewName;
	}
	public void setViewName(String viewName) {
		this.viewName=viewName;
	}

	public String getAbstractShotCut() {
		return abstractShotCut;
	}
	public void setAbstractShotCut(String abstractShotCut) {
		this.abstractShotCut=abstractShotCut;
	}

}

