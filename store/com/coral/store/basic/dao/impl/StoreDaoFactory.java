package com.coral.store.basic.dao.impl;

import com.coral.store.basic.dao.ICustomerDao;
import com.coral.store.basic.dao.IOrderSheetDao;
import com.coral.store.basic.dao.IProductDao;
import com.coral.store.basic.dao.ISupplierDao;
import com.coral.store.basic.dao.impl.CustomerDaoImpl;
import com.coral.store.basic.dao.impl.OrderSheetDaoImpl;
import com.coral.store.basic.dao.impl.ProductDaoImpl;
import com.coral.store.basic.dao.impl.SupplierDaoImpl;

/**
 * <p>Title: com.coral.store.basic.dao.impl.StoreDaoFactory</p>
 * <p>Description: All system dao factory </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-07-21 16:28 </p>
 */
public class StoreDaoFactory {

	private static ICustomerDao customerDao = new CustomerDaoImpl();
	public static ICustomerDao getCustomerDao() {
		return customerDao;
	}

	private static ISupplierDao supplierDao = new SupplierDaoImpl();
	public static ISupplierDao getSupplierDao() {
		return supplierDao;
	}

	private static IProductDao productDao = new ProductDaoImpl();
	public static IProductDao getProductDao() {
		return productDao;
	}

	private static IOrderSheetDao orderSheetDao = new OrderSheetDaoImpl();
	public static IOrderSheetDao getOrderSheetDao() {
		return orderSheetDao;
	}

}

