package com.coral.store.basic.service;

import java.util.Date;
import com.coral.store.basic.dao.ISaleOrderProductDao;
import com.coral.cstore.utils.StrUtils;
import com.coral.fundation.IDGenerater;
import com.coral.fundation.Log;
import com.coral.fundation.bean.BeanUtils;
import com.coral.fundation.utils.SqlUtils;
import com.coral.store.utils.StoreUtils;
import java.util.List;
import com.coral.store.model.SaleOrderProduct;
/**
 * <p>Title: com.coral.store.basic.service.SaleOrderProductDS</p>
 * <p>Description: SaleOrderProductDS entity </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-09-02 12:02 </p>
 */
public class SaleOrderProductDS {

	ISaleOrderProductDao saleOrderProductDao = BeanUtils.getBean("saleOrderProductDao", ISaleOrderProductDao.class);

	public SaleOrderProduct createSaleOrderProduct(SaleOrderProduct saleOrderProduct) {
		try {
			saleOrderProduct.setSaleOrderProductId(IDGenerater.generate());
			StoreUtils.abstractSaleOrderProduct(saleOrderProduct);
			saleOrderProductDao.create(saleOrderProduct);
		} catch (Exception e) {
			Log.error("Create SaleOrderProduct error.", this.getClass(),e.getCause());
		}
		return saleOrderProduct;
	}

	public SaleOrderProduct updateSaleOrderProduct(SaleOrderProduct saleOrderProduct) {
		try {
			StoreUtils.abstractSaleOrderProduct(saleOrderProduct);
			saleOrderProductDao.update(saleOrderProduct);
		} catch (Exception e) {
			Log.error("Update SaleOrderProduct error.", this.getClass(),e.getCause());
		}
		return saleOrderProduct;
	}

	public String deleteSaleOrderProduct(SaleOrderProduct saleOrderProduct) {
		deleteSaleOrderProduct(saleOrderProduct.getSaleOrderProductId());
		return StrUtils.empty;
	}

	public String deleteSaleOrderProduct(String saleOrderProductId) {
		try {
			saleOrderProductDao.remove(saleOrderProductId);
		} catch (Exception e) {
			Log.error("Delete SaleOrderProduct error.", this.getClass(),e.getCause());
		}
		return StrUtils.empty;
	}

	public SaleOrderProduct loadSaleOrderProduct(String saleOrderProductId) {
		SaleOrderProduct saleOrderProduct= null;
		try {
			saleOrderProduct = saleOrderProductDao.load(saleOrderProductId);
		} catch (Exception e) {
			Log.error("load SaleOrderProduct error.", this.getClass(),e.getCause());
		}
		return saleOrderProduct;
	}

	public List<SaleOrderProduct> loadAllSaleOrderProduct() {
		List<SaleOrderProduct> saleOrderProductList = null;
		try {
			saleOrderProductList = saleOrderProductDao.loadAll();
		} catch (Exception e) {
			Log.error("load SaleOrderProduct error.", this.getClass(),e.getCause());
		}
		return saleOrderProductList;
	}
}

