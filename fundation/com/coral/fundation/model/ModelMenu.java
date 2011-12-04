package com.coral.fundation.model;

import java.util.ArrayList;
import java.util.List;
import com.coral.fundation.model.ModelMenu;

/**
 * <p>Title: com.coral.fundation.model.ModelMenu</p>
 * <p>Description: ModelMenu entity </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-07-21 16:28 </p>
 */
public class ModelMenu implements java.io.Serializable  {

	private Long menuId;
	private String menuName;
	private Long parentMenuId;
	private String viewName;
	private Long orderIndex;
	private List<ModelMenu> subMenus;

	public Long getMenuId() {
		return menuId;
	}
	public void setMenuId(Long menuId) {
		this.menuId=menuId;
	}

	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName=menuName;
	}

	public Long getParentMenuId() {
		return parentMenuId;
	}
	public void setParentMenuId(Long parentMenuId) {
		this.parentMenuId=parentMenuId;
	}

	public String getViewName() {
		return viewName;
	}
	public void setViewName(String viewName) {
		this.viewName=viewName;
	}

	public Long getOrderIndex() {
		return orderIndex;
	}
	public void setOrderIndex(Long orderIndex) {
		this.orderIndex=orderIndex;
	}

	public List<ModelMenu> getSubMenus() {
		return subMenus;
	}
	public void setSubMenus(List<ModelMenu> subMenus) {
		this.subMenus=subMenus;
	}

}

