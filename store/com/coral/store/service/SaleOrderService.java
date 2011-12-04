/**
 * 
 */
package com.coral.store.service;

import java.util.List;

import com.coral.cstore.utils.StrUtils;
import com.coral.store.basic.service.SaleOrderProductDS;
import com.coral.store.basic.service.SaleOrderSheetDS;
import com.coral.store.model.SaleOrderProduct;
import com.coral.store.model.SaleOrderSheet;

/**
 * @author coral.ma
 *
 */
public class SaleOrderService {

	SaleOrderSheetDS saleOrderSheetDS = new SaleOrderSheetDS();
	SaleOrderProductDS orderProductDS = new SaleOrderProductDS();
	
	public SaleOrderSheet createSaleOrderSheet(SaleOrderSheet saleOrderSheet) {
		saleOrderSheet = saleOrderSheetDS.createSaleOrderSheet(saleOrderSheet);
		List<SaleOrderProduct> orderProducts = saleOrderSheet.getProducts();
		for(SaleOrderProduct orderProduct : orderProducts) {
			orderProduct.setSaleOrderSheetId(saleOrderSheet.getSaleOrderSheetId());
			orderProductDS.createSaleOrderProduct(orderProduct);
		}
		return saleOrderSheet;
	}

	public SaleOrderSheet updateSaleOrderSheet(SaleOrderSheet saleOrderSheet) {
		saleOrderSheetDS.updateSaleOrderSheet(saleOrderSheet);
		List<SaleOrderProduct> orderProducts = saleOrderSheet.getProducts();
		for(SaleOrderProduct orderProduct : orderProducts) {
			orderProductDS.updateSaleOrderProduct(orderProduct);
		}
		return saleOrderSheet;
	}

	public String deleteSaleOrderSheet(SaleOrderSheet saleOrderSheet) {
		List<SaleOrderProduct> orderProducts = saleOrderSheet.getProducts();
		for(SaleOrderProduct orderProduct : orderProducts) {
			orderProductDS.deleteSaleOrderProduct(orderProduct);
		}
		saleOrderSheetDS.deleteSaleOrderSheet(saleOrderSheet);
		return StrUtils.empty;
	}

	public SaleOrderSheet loadSaleOrderSheet(String saleOrderSheetId) {
		SaleOrderSheet saleOrderSheet= saleOrderSheetDS.loadSaleOrderSheet(saleOrderSheetId);
		return saleOrderSheet;
	}

	public List<SaleOrderSheet> loadAllSaleOrderSheet() {
		List<SaleOrderSheet> saleOrderSheetList = saleOrderSheetDS.loadAllSaleOrderSheet();
		return saleOrderSheetList;
	}
}
