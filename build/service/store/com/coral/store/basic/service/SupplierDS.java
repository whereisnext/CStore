package com.coral.store.basic.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import com.coral.store.model.Product;
import com.coral.store.basic.dao.ISupplierDao;
import com.coral.cstore.utils.StrUtils;
import com.coral.fundation.IDGenerater;
import com.coral.fundation.Log;
import com.coral.fundation.bean.BeanUtils;
import com.coral.fundation.utils.SqlUtils;
import com.coral.store.utils.StoreUtils;
import java.util.List;
import com.coral.store.model.Supplier;
/**
 * <p>Title: com.coral.store.basic.service.SupplierDS</p>
 * <p>Description: SupplierDS entity </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-09-02 12:02 </p>
 */
public class SupplierDS {

	ISupplierDao supplierDao = BeanUtils.getBean("supplierDao", ISupplierDao.class);

	public Supplier createSupplier(Supplier supplier) {
		try {
			supplier.setSupplierId(IDGenerater.generate());
			StoreUtils.abstractSupplier(supplier);
			supplierDao.create(supplier);
		} catch (Exception e) {
			Log.error("Create Supplier error.", this.getClass(),e.getCause());
		}
		return supplier;
	}

	public Supplier updateSupplier(Supplier supplier) {
		try {
			StoreUtils.abstractSupplier(supplier);
			supplierDao.update(supplier);
		} catch (Exception e) {
			Log.error("Update Supplier error.", this.getClass(),e.getCause());
		}
		return supplier;
	}

	public String deleteSupplier(Supplier supplier) {
		deleteSupplier(supplier.getSupplierId());
		return StrUtils.empty;
	}

	public String deleteSupplier(String supplierId) {
		try {
			supplierDao.remove(supplierId);
		} catch (Exception e) {
			Log.error("Delete Supplier error.", this.getClass(),e.getCause());
		}
		return StrUtils.empty;
	}

	public Supplier loadSupplier(String supplierId) {
		Supplier supplier= null;
		try {
			supplier = supplierDao.load(supplierId);
		} catch (Exception e) {
			Log.error("load Supplier error.", this.getClass(),e.getCause());
		}
		return supplier;
	}

	public List<Supplier> loadAllSupplier() {
		List<Supplier> supplierList = null;
		try {
			supplierList = supplierDao.loadAll();
		} catch (Exception e) {
			Log.error("load Supplier error.", this.getClass(),e.getCause());
		}
		return supplierList;
	}
}

