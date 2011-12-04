package com.coral.store.basic.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import com.coral.store.model.PurchaseOrderProduct;
import com.coral.store.basic.dao.IPurchaseOrderSheetDao;
import com.coral.cstore.utils.StrUtils;
import com.coral.fundation.IDGenerater;
import com.coral.fundation.Log;
import com.coral.fundation.bean.BeanUtils;
import com.coral.fundation.utils.SqlUtils;
import com.coral.store.utils.StoreUtils;
import java.util.List;
import com.coral.store.model.PurchaseOrderSheet;
/**
 * <p>Title: com.coral.store.basic.service.PurchaseOrderSheetDS</p>
 * <p>Description: PurchaseOrderSheetDS entity </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-09-02 12:02 </p>
 */
public class PurchaseOrderSheetDS {

	IPurchaseOrderSheetDao purchaseOrderSheetDao = BeanUtils.getBean("purchaseOrderSheetDao", IPurchaseOrderSheetDao.class);

	public PurchaseOrderSheet createPurchaseOrderSheet(PurchaseOrderSheet purchaseOrderSheet) {
		try {
			purchaseOrderSheet.setPurchaseOrderSheetId(IDGenerater.generate());
			StoreUtils.abstractPurchaseOrderSheet(purchaseOrderSheet);
			purchaseOrderSheetDao.create(purchaseOrderSheet);
		} catch (Exception e) {
			Log.error("Create PurchaseOrderSheet error.", this.getClass(),e.getCause());
		}
		return purchaseOrderSheet;
	}

	public PurchaseOrderSheet updatePurchaseOrderSheet(PurchaseOrderSheet purchaseOrderSheet) {
		try {
			StoreUtils.abstractPurchaseOrderSheet(purchaseOrderSheet);
			purchaseOrderSheetDao.update(purchaseOrderSheet);
		} catch (Exception e) {
			Log.error("Update PurchaseOrderSheet error.", this.getClass(),e.getCause());
		}
		return purchaseOrderSheet;
	}

	public String deletePurchaseOrderSheet(PurchaseOrderSheet purchaseOrderSheet) {
		deletePurchaseOrderSheet(purchaseOrderSheet.getPurchaseOrderSheetId());
		return StrUtils.empty;
	}

	public String deletePurchaseOrderSheet(String purchaseOrderSheetId) {
		try {
			purchaseOrderSheetDao.remove(purchaseOrderSheetId);
		} catch (Exception e) {
			Log.error("Delete PurchaseOrderSheet error.", this.getClass(),e.getCause());
		}
		return StrUtils.empty;
	}

	public PurchaseOrderSheet loadPurchaseOrderSheet(String purchaseOrderSheetId) {
		PurchaseOrderSheet purchaseOrderSheet= null;
		try {
			purchaseOrderSheet = purchaseOrderSheetDao.load(purchaseOrderSheetId);
		} catch (Exception e) {
			Log.error("load PurchaseOrderSheet error.", this.getClass(),e.getCause());
		}
		return purchaseOrderSheet;
	}

	public List<PurchaseOrderSheet> loadAllPurchaseOrderSheet() {
		List<PurchaseOrderSheet> purchaseOrderSheetList = null;
		try {
			purchaseOrderSheetList = purchaseOrderSheetDao.loadAll();
		} catch (Exception e) {
			Log.error("load PurchaseOrderSheet error.", this.getClass(),e.getCause());
		}
		return purchaseOrderSheetList;
	}
}

