package com.coral.store.basic.service;

import java.util.Date;
import com.coral.store.basic.dao.IPurchaseOrderProductDao;
import com.coral.cstore.utils.StrUtils;
import com.coral.fundation.IDGenerater;
import com.coral.fundation.Log;
import com.coral.fundation.bean.BeanUtils;
import com.coral.fundation.utils.SqlUtils;
import com.coral.store.utils.StoreUtils;
import java.util.List;
import com.coral.store.model.PurchaseOrderProduct;
/**
 * <p>Title: com.coral.store.basic.service.PurchaseOrderProductDS</p>
 * <p>Description: PurchaseOrderProductDS entity </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-09-02 12:02 </p>
 */
public class PurchaseOrderProductDS {

	IPurchaseOrderProductDao purchaseOrderProductDao = BeanUtils.getBean("purchaseOrderProductDao", IPurchaseOrderProductDao.class);

	public PurchaseOrderProduct createPurchaseOrderProduct(PurchaseOrderProduct purchaseOrderProduct) {
		try {
			purchaseOrderProduct.setPurchaseOrderProductId(IDGenerater.generate());
			StoreUtils.abstractPurchaseOrderProduct(purchaseOrderProduct);
			purchaseOrderProductDao.create(purchaseOrderProduct);
		} catch (Exception e) {
			Log.error("Create PurchaseOrderProduct error.", this.getClass(),e.getCause());
		}
		return purchaseOrderProduct;
	}

	public PurchaseOrderProduct updatePurchaseOrderProduct(PurchaseOrderProduct purchaseOrderProduct) {
		try {
			StoreUtils.abstractPurchaseOrderProduct(purchaseOrderProduct);
			purchaseOrderProductDao.update(purchaseOrderProduct);
		} catch (Exception e) {
			Log.error("Update PurchaseOrderProduct error.", this.getClass(),e.getCause());
		}
		return purchaseOrderProduct;
	}

	public String deletePurchaseOrderProduct(PurchaseOrderProduct purchaseOrderProduct) {
		deletePurchaseOrderProduct(purchaseOrderProduct.getPurchaseOrderProductId());
		return StrUtils.empty;
	}

	public String deletePurchaseOrderProduct(String purchaseOrderProductId) {
		try {
			purchaseOrderProductDao.remove(purchaseOrderProductId);
		} catch (Exception e) {
			Log.error("Delete PurchaseOrderProduct error.", this.getClass(),e.getCause());
		}
		return StrUtils.empty;
	}

	public PurchaseOrderProduct loadPurchaseOrderProduct(String purchaseOrderProductId) {
		PurchaseOrderProduct purchaseOrderProduct= null;
		try {
			purchaseOrderProduct = purchaseOrderProductDao.load(purchaseOrderProductId);
		} catch (Exception e) {
			Log.error("load PurchaseOrderProduct error.", this.getClass(),e.getCause());
		}
		return purchaseOrderProduct;
	}

	public List<PurchaseOrderProduct> loadAllPurchaseOrderProduct() {
		List<PurchaseOrderProduct> purchaseOrderProductList = null;
		try {
			purchaseOrderProductList = purchaseOrderProductDao.loadAll();
		} catch (Exception e) {
			Log.error("load PurchaseOrderProduct error.", this.getClass(),e.getCause());
		}
		return purchaseOrderProductList;
	}
}

