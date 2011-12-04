package com.coral.store.basic.service;

import java.util.Date;
import com.coral.store.basic.dao.IImportStockDao;
import com.coral.cstore.utils.StrUtils;
import com.coral.fundation.IDGenerater;
import com.coral.fundation.Log;
import com.coral.fundation.bean.BeanUtils;
import com.coral.fundation.utils.SqlUtils;
import com.coral.store.utils.StoreUtils;
import java.util.List;
import com.coral.store.model.ImportStock;
/**
 * <p>Title: com.coral.store.basic.service.ImportStockDS</p>
 * <p>Description: ImportStockDS entity </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-09-02 12:02 </p>
 */
public class ImportStockDS {

	IImportStockDao importStockDao = BeanUtils.getBean("importStockDao", IImportStockDao.class);

	public ImportStock createImportStock(ImportStock importStock) {
		try {
			importStock.setImportStockId(IDGenerater.generate());
			StoreUtils.abstractImportStock(importStock);
			importStockDao.create(importStock);
		} catch (Exception e) {
			Log.error("Create ImportStock error.", this.getClass(),e.getCause());
		}
		return importStock;
	}

	public ImportStock updateImportStock(ImportStock importStock) {
		try {
			StoreUtils.abstractImportStock(importStock);
			importStockDao.update(importStock);
		} catch (Exception e) {
			Log.error("Update ImportStock error.", this.getClass(),e.getCause());
		}
		return importStock;
	}

	public String deleteImportStock(ImportStock importStock) {
		deleteImportStock(importStock.getImportStockId());
		return StrUtils.empty;
	}

	public String deleteImportStock(String importStockId) {
		try {
			importStockDao.remove(importStockId);
		} catch (Exception e) {
			Log.error("Delete ImportStock error.", this.getClass(),e.getCause());
		}
		return StrUtils.empty;
	}

	public ImportStock loadImportStock(String importStockId) {
		ImportStock importStock= null;
		try {
			importStock = importStockDao.load(importStockId);
		} catch (Exception e) {
			Log.error("load ImportStock error.", this.getClass(),e.getCause());
		}
		return importStock;
	}

	public List<ImportStock> loadAllImportStock() {
		List<ImportStock> importStockList = null;
		try {
			importStockList = importStockDao.loadAll();
		} catch (Exception e) {
			Log.error("load ImportStock error.", this.getClass(),e.getCause());
		}
		return importStockList;
	}
}

