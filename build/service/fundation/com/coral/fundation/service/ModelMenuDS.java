package com.coral.fundation.service;

import java.util.ArrayList;
import java.util.List;
import com.coral.fundation.model.ModelMenu;
import com.coral.fundation.basic.dao.IModelMenuDao;
import com.coral.cstore.utils.StrUtils;
import com.coral.fundation.IDGenerater;
import com.coral.fundation.Log;
import com.coral.fundation.bean.BeanUtils;
import com.coral.fundation.utils.SqlUtils;
import com.coral.fundation.utils.FoundationUtils;
import java.util.List;
import com.coral.fundation.model.ModelMenu;
/**
 * <p>Title: com.coral.fundation.service.ModelMenuDS</p>
 * <p>Description: ModelMenuDS entity </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-09-02 12:02 </p>
 */
public class ModelMenuDS {

	IModelMenuDao modelMenuDao = BeanUtils.getBean("modelMenuDao", IModelMenuDao.class);

	public ModelMenu createModelMenu(ModelMenu modelMenu) {
		try {
			modelMenu.setModelMenuId(IDGenerater.generate());
			FoundationUtils.abstractModelMenu(modelMenu);
			modelMenuDao.create(modelMenu);
		} catch (Exception e) {
			Log.error("Create ModelMenu error.", this.getClass(),e.getCause());
		}
		return modelMenu;
	}

	public ModelMenu updateModelMenu(ModelMenu modelMenu) {
		try {
			FoundationUtils.abstractModelMenu(modelMenu);
			modelMenuDao.update(modelMenu);
		} catch (Exception e) {
			Log.error("Update ModelMenu error.", this.getClass(),e.getCause());
		}
		return modelMenu;
	}

	public String deleteModelMenu(ModelMenu modelMenu) {
		deleteModelMenu(modelMenu.getModelMenuId());
		return StrUtils.empty;
	}

	public String deleteModelMenu(String modelMenuId) {
		try {
			modelMenuDao.remove(modelMenuId);
		} catch (Exception e) {
			Log.error("Delete ModelMenu error.", this.getClass(),e.getCause());
		}
		return StrUtils.empty;
	}

	public ModelMenu loadModelMenu(String modelMenuId) {
		ModelMenu modelMenu= null;
		try {
			modelMenu = modelMenuDao.load(modelMenuId);
		} catch (Exception e) {
			Log.error("load ModelMenu error.", this.getClass(),e.getCause());
		}
		return modelMenu;
	}

	public List<ModelMenu> loadAllModelMenu() {
		List<ModelMenu> modelMenuList = null;
		try {
			modelMenuList = modelMenuDao.loadAll();
		} catch (Exception e) {
			Log.error("load ModelMenu error.", this.getClass(),e.getCause());
		}
		return modelMenuList;
	}
}

