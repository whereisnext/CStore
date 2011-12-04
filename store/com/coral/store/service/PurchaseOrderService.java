/**
 * 
 */
package com.coral.store.service;

import java.util.List;

import com.coral.cstore.utils.StrUtils;
import com.coral.fundation.IDGenerater;
import com.coral.fundation.Log;
import com.coral.fundation.bean.BeanUtils;
import com.coral.store.basic.dao.IPurchaseOrderProductDao;
import com.coral.store.basic.dao.IPurchaseOrderSheetDao;
import com.coral.store.basic.service.PurchaseOrderProductDS;
import com.coral.store.basic.service.PurchaseOrderSheetDS;
import com.coral.store.model.PurchaseOrderProduct;
import com.coral.store.model.PurchaseOrderSheet;
import com.coral.store.utils.StoreUtils;

/**
 * @author coral.ma
 *
 */
public class PurchaseOrderService {
	
	PurchaseOrderSheetDS purchaseOrderSheetDS = new PurchaseOrderSheetDS();
	PurchaseOrderProductDS purchaseOrderProductDS = new PurchaseOrderProductDS();

	public PurchaseOrderSheet createPurchaseOrderSheet(PurchaseOrderSheet sheet) {
		purchaseOrderSheetDS.createPurchaseOrderSheet(sheet);
		List<PurchaseOrderProduct> productList = sheet.getProducts();
		if(productList != null) {
			for(PurchaseOrderProduct prdt : productList) {
				purchaseOrderProductDS.createPurchaseOrderProduct(prdt);

			}
		}
		return sheet;
	}
	
	public PurchaseOrderSheet updatePurchaseOrderSheet(PurchaseOrderSheet sheet) {
		purchaseOrderSheetDS.updatePurchaseOrderSheet(sheet);
		List<PurchaseOrderProduct> productList = sheet.getProducts();
		if(productList != null) {
			for(PurchaseOrderProduct prdt : productList) {
				purchaseOrderProductDS.updatePurchaseOrderProduct(prdt);
			}
		}
		return sheet;
	}

	public String deletePurchaseOrderSheet(PurchaseOrderSheet sheet) throws Exception {
		List<PurchaseOrderProduct> productList = sheet.getProducts();
		for(PurchaseOrderProduct prdt : productList) {
			purchaseOrderProductDS.deletePurchaseOrderProduct(prdt);
		}
		purchaseOrderSheetDS.deletePurchaseOrderSheet(sheet);
		return StrUtils.empty;
	}

	public PurchaseOrderSheet loadPurchaseOrderSheet(String purchaseOrderSheetId) {
		PurchaseOrderSheet purchaseOrderSheet= purchaseOrderSheetDS.loadPurchaseOrderSheet(purchaseOrderSheetId);
		return purchaseOrderSheet;
	}

	public List<PurchaseOrderSheet> loadAllPurchaseOrderSheet() {
		List<PurchaseOrderSheet> purchaseOrderSheetList= purchaseOrderSheetDS.loadAllPurchaseOrderSheet();
		return purchaseOrderSheetList;
	}
	
}
