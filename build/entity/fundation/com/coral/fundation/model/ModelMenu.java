package com.coral.fundation.model;

import java.util.ArrayList;
import java.util.List;
import com.coral.fundation.model.ModelMenu;

/**
 * <p>Title: com.coral.fundation.model.ModelMenu</p>
 * <p>Description: ModelMenu entity </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-09-02 12:02 </p>
 */
public class ModelMenu implements java.io.Serializable  {

	private String modelMenuId;
	private Long menuId;
	private String menuName;
	private Long parentMenuId;
	private String viewName;
	private String icon;
	private Long orderIndex;
	private List<ModelMenu> subMenus;
	private String abstractModelMenu;

	public String getModelMenuId() {
		return modelMenuId;
	}
	public void setModelMenuId(String modelMenuId) {
		this.modelMenuId=modelMenuId;
	}

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

	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon=icon;
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

	public String getAbstractModelMenu() {
		return abstractModelMenu;
	}
	public void setAbstractModelMenu(String abstractModelMenu) {
		this.abstractModelMenu=abstractModelMenu;
	}

}

