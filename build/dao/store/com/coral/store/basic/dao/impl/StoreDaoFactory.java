package com.coral.store.basic.dao.impl;

import com.coral.store.basic.dao.ICustomerDao;
import com.coral.store.basic.dao.impl.CustomerDaoImpl;
import com.coral.store.basic.dao.ISupplierDao;
import com.coral.store.basic.dao.impl.SupplierDaoImpl;
import com.coral.store.basic.dao.IProductDao;
import com.coral.store.basic.dao.impl.ProductDaoImpl;
import com.coral.store.basic.dao.ISaleOrderSheetDao;
import com.coral.store.basic.dao.impl.SaleOrderSheetDaoImpl;
import com.coral.store.basic.dao.ISaleOrderProductDao;
import com.coral.store.basic.dao.impl.SaleOrderProductDaoImpl;
import com.coral.store.basic.dao.IPurchaseOrderSheetDao;
import com.coral.store.basic.dao.impl.PurchaseOrderSheetDaoImpl;
import com.coral.store.basic.dao.IPurchaseOrderProductDao;
import com.coral.store.basic.dao.impl.PurchaseOrderProductDaoImpl;
import com.coral.store.basic.dao.IStockDao;
import com.coral.store.basic.dao.impl.StockDaoImpl;
import com.coral.store.basic.dao.IImportStockDao;
import com.coral.store.basic.dao.impl.ImportStockDaoImpl;
import com.coral.store.basic.dao.IExportStockDao;
import com.coral.store.basic.dao.impl.ExportStockDaoImpl;

/**
 * <p>Title: com.coral.store.basic.dao.impl.StoreDaoFactory</p>
 * <p>Description: All system dao factory </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-09-02 12:02 </p>
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

	private static ISaleOrderSheetDao saleOrderSheetDao = new SaleOrderSheetDaoImpl();
	public static ISaleOrderSheetDao getSaleOrderSheetDao() {
		return saleOrderSheetDao;
	}

	private static ISaleOrderProductDao saleOrderProductDao = new SaleOrderProductDaoImpl();
	public static ISaleOrderProductDao getSaleOrderProductDao() {
		return saleOrderProductDao;
	}

	private static IPurchaseOrderSheetDao purchaseOrderSheetDao = new PurchaseOrderSheetDaoImpl();
	public static IPurchaseOrderSheetDao getPurchaseOrderSheetDao() {
		return purchaseOrderSheetDao;
	}

	private static IPurchaseOrderProductDao purchaseOrderProductDao = new PurchaseOrderProductDaoImpl();
	public static IPurchaseOrderProductDao getPurchaseOrderProductDao() {
		return purchaseOrderProductDao;
	}

	private static IStockDao stockDao = new StockDaoImpl();
	public static IStockDao getStockDao() {
		return stockDao;
	}

	private static IImportStockDao importStockDao = new ImportStockDaoImpl();
	public static IImportStockDao getImportStockDao() {
		return importStockDao;
	}

	private static IExportStockDao exportStockDao = new ExportStockDaoImpl();
	public static IExportStockDao getExportStockDao() {
		return exportStockDao;
	}

}

