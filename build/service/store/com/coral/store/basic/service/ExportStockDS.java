package com.coral.store.basic.service;

import java.util.Date;
import com.coral.store.basic.dao.IExportStockDao;
import com.coral.cstore.utils.StrUtils;
import com.coral.fundation.IDGenerater;
import com.coral.fundation.Log;
import com.coral.fundation.bean.BeanUtils;
import com.coral.fundation.utils.SqlUtils;
import com.coral.store.utils.StoreUtils;
import java.util.List;
import com.coral.store.model.ExportStock;
/**
 * <p>Title: com.coral.store.basic.service.ExportStockDS</p>
 * <p>Description: ExportStockDS entity </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-09-02 12:02 </p>
 */
public class ExportStockDS {

	IExportStockDao exportStockDao = BeanUtils.getBean("exportStockDao", IExportStockDao.class);

	public ExportStock createExportStock(ExportStock exportStock) {
		try {
			exportStock.setExportStockId(IDGenerater.generate());
			StoreUtils.abstractExportStock(exportStock);
			exportStockDao.create(exportStock);
		} catch (Exception e) {
			Log.error("Create ExportStock error.", this.getClass(),e.getCause());
		}
		return exportStock;
	}

	public ExportStock updateExportStock(ExportStock exportStock) {
		try {
			StoreUtils.abstractExportStock(exportStock);
			exportStockDao.update(exportStock);
		} catch (Exception e) {
			Log.error("Update ExportStock error.", this.getClass(),e.getCause());
		}
		return exportStock;
	}

	public String deleteExportStock(ExportStock exportStock) {
		deleteExportStock(exportStock.getExportStockId());
		return StrUtils.empty;
	}

	public String deleteExportStock(String exportStockId) {
		try {
			exportStockDao.remove(exportStockId);
		} catch (Exception e) {
			Log.error("Delete ExportStock error.", this.getClass(),e.getCause());
		}
		return StrUtils.empty;
	}

	public ExportStock loadExportStock(String exportStockId) {
		ExportStock exportStock= null;
		try {
			exportStock = exportStockDao.load(exportStockId);
		} catch (Exception e) {
			Log.error("load ExportStock error.", this.getClass(),e.getCause());
		}
		return exportStock;
	}

	public List<ExportStock> loadAllExportStock() {
		List<ExportStock> exportStockList = null;
		try {
			exportStockList = exportStockDao.loadAll();
		} catch (Exception e) {
			Log.error("load ExportStock error.", this.getClass(),e.getCause());
		}
		return exportStockList;
	}
}

