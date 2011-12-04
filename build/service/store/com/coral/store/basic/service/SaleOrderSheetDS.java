package com.coral.store.basic.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import com.coral.store.model.SaleOrderProduct;
import com.coral.store.basic.dao.ISaleOrderSheetDao;
import com.coral.cstore.utils.StrUtils;
import com.coral.fundation.IDGenerater;
import com.coral.fundation.Log;
import com.coral.fundation.bean.BeanUtils;
import com.coral.fundation.utils.SqlUtils;
import com.coral.store.utils.StoreUtils;
import java.util.List;
import com.coral.store.model.SaleOrderSheet;
/**
 * <p>Title: com.coral.store.basic.service.SaleOrderSheetDS</p>
 * <p>Description: SaleOrderSheetDS entity </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-09-02 12:02 </p>
 */
public class SaleOrderSheetDS {

	ISaleOrderSheetDao saleOrderSheetDao = BeanUtils.getBean("saleOrderSheetDao", ISaleOrderSheetDao.class);

	public SaleOrderSheet createSaleOrderSheet(SaleOrderSheet saleOrderSheet) {
		try {
			saleOrderSheet.setSaleOrderSheetId(IDGenerater.generate());
			StoreUtils.abstractSaleOrderSheet(saleOrderSheet);
			saleOrderSheetDao.create(saleOrderSheet);
		} catch (Exception e) {
			Log.error("Create SaleOrderSheet error.", this.getClass(),e.getCause());
		}
		return saleOrderSheet;
	}

	public SaleOrderSheet updateSaleOrderSheet(SaleOrderSheet saleOrderSheet) {
		try {
			StoreUtils.abstractSaleOrderSheet(saleOrderSheet);
			saleOrderSheetDao.update(saleOrderSheet);
		} catch (Exception e) {
			Log.error("Update SaleOrderSheet error.", this.getClass(),e.getCause());
		}
		return saleOrderSheet;
	}

	public String deleteSaleOrderSheet(SaleOrderSheet saleOrderSheet) {
		deleteSaleOrderSheet(saleOrderSheet.getSaleOrderSheetId());
		return StrUtils.empty;
	}

	public String deleteSaleOrderSheet(String saleOrderSheetId) {
		try {
			saleOrderSheetDao.remove(saleOrderSheetId);
		} catch (Exception e) {
			Log.error("Delete SaleOrderSheet error.", this.getClass(),e.getCause());
		}
		return StrUtils.empty;
	}

	public SaleOrderSheet loadSaleOrderSheet(String saleOrderSheetId) {
		SaleOrderSheet saleOrderSheet= null;
		try {
			saleOrderSheet = saleOrderSheetDao.load(saleOrderSheetId);
		} catch (Exception e) {
			Log.error("load SaleOrderSheet error.", this.getClass(),e.getCause());
		}
		return saleOrderSheet;
	}

	public List<SaleOrderSheet> loadAllSaleOrderSheet() {
		List<SaleOrderSheet> saleOrderSheetList = null;
		try {
			saleOrderSheetList = saleOrderSheetDao.loadAll();
		} catch (Exception e) {
			Log.error("load SaleOrderSheet error.", this.getClass(),e.getCause());
		}
		return saleOrderSheetList;
	}
}

