package com.coral.fundation.model;


/**
 * <p>Title: com.coral.fundation.model.ShotCut</p>
 * <p>Description: ShotCut entity </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-07-21 16:28 </p>
 */
public class ShotCut implements java.io.Serializable  {

	private String shotCutId;
	private String shotCutName;
	private String viewName;

	public String getShotCutId() {
		return shotCutId;
	}
	public void setShotCutId(String shotCutId) {
		this.shotCutId=shotCutId;
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

}

