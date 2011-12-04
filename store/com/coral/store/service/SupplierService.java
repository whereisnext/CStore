/**
 * 
 */
package com.coral.store.service;

import java.util.ArrayList;
import java.util.List;

import com.coral.fundation.IDGenerater;
import com.coral.fundation.Log;
import com.coral.fundation.bean.BeanUtils;
import com.coral.store.basic.dao.ICustomerDao;
import com.coral.store.basic.dao.IProductDao;
import com.coral.store.basic.dao.ISupplierDao;
import com.coral.store.basic.dao.impl.StoreDaoFactory;
import com.coral.store.ext.IExtProductDao;
import com.coral.store.ext.IExtSupplierDao;
import com.coral.store.ext.dao.impl.ExtStoreFactory;
import com.coral.store.model.Product;
import com.coral.store.model.Supplier;
import com.coral.store.utils.StoreUtils;

/**
 * @author coral.ma
 *
 */
public class SupplierService {

	ISupplierDao supplierDao = BeanUtils.getBean("supplierDao",ISupplierDao.class);
	IProductDao productDao = BeanUtils.getBean("productDao",IProductDao.class);
	IExtProductDao extProductDao = BeanUtils.getBean("extProductDao",IExtProductDao.class);
	IExtSupplierDao extSupplierDao = BeanUtils.getBean("extSupplierDao",IExtSupplierDao.class);
//	ICustomerDao dao = BeanUtils.getBean("customerDao", ICustomerDao.class);
	
	/**
	 * create Supplier and product.
	 * @param supplier
	 * @return Supplier
	 */
	public Supplier createSupplier(Supplier supplier) {
		
		try {
			supplier.setSupplierId(IDGenerater.generate());
			StoreUtils.abstractSupplier(supplier);
			supplierDao.create(supplier);
		} catch (Exception e) {
			Log.error("Create supplier error.", this.getClass(), e.getCause());
		}
		List<Product> productList=supplier.getProducts();
		if(productList != null) {
			for(Product prdt : productList) {
				try {
					prdt.setProductId(IDGenerater.generate());
					prdt.setSupplierId(supplier.getSupplierId());
					prdt.setSupplierName(supplier.getSupplierName());
					StoreUtils.abstractProduct(prdt);
					productDao.create(prdt);
				} catch (Exception e) {
					Log.error("Create supplier product error.", this.getClass(), e.getCause());
				}
			}
		}
		return supplier;
	}

	/**
	 * update Supplier and product.
	 * @param supplier
	 * @return Supplier
	 */
	public Supplier updateSupplier(Supplier supplier) {
		try {
			StoreUtils.abstractSupplier(supplier);
			supplierDao.update(supplier);
		} catch (Exception e) {
			Log.error("Update supplier error.", this.getClass(), e.getCause());
		}
		List<Product> productList=supplier.getProducts();
		if(productList != null) {
			for(Product prdt : productList) {
				try {
					productDao.update(prdt);
				} catch (Exception e) {
					Log.error("Update supplier product error.", this.getClass(), e.getCause());
				}
			}
		}
		return supplier;
	}

	/**
	 * delete Supplier and product.
	 * @param supplier
	 */
	public void deleteSupplier(Supplier supplier) {
		List<Product> productList=supplier.getProducts();
		if(productList != null) {
			for(Product prdt : productList) {
				try {
					productDao.remove(prdt.getProductId());
				} catch (Exception e) {
					Log.error("Delete supplier product error.", this.getClass(), e.getCause());
				}
			}
		}
		try {
			supplierDao.remove(supplier.getSupplierId());
		} catch (Exception e) {
			Log.error("Delete supplier error.", this.getClass(), e.getCause());
		}
	}

	/**
	 * load Supplier by id.
	 * @param supplierId
	 * @return Supplier
	 */
	public Supplier loadSupplier(String supplierId) {
		Supplier supplier = null;
		try {
			supplier = supplierDao.load(supplierId);
		} catch (Exception e) {
			Log.error("Load supplier product error.", this.getClass(), e.getCause());
		}
		if(supplier != null) {
			try {
				supplier.setProducts(extProductDao.loadSupplierProducts(supplier.getSupplierId()));
			} catch (Exception e) {
				Log.error("Load repated products error. the error Supplier is " + supplier.getSupplierName(), this.getClass(), e.getCause());
			}
		}
		return supplier;
	}
	
	/**
	 * Load all supplier.
	 * @return List<Supplier>
	 */
	public List<Supplier> loadAll() {
		List<Supplier> supplierList = new ArrayList<Supplier>();
		try {
			supplierList = supplierDao.loadAll();
		} catch (Exception e) {
			Log.error("Load all suppliers error.", this.getClass(), e.getCause());
		}
		
		for(Supplier supplier : supplierList) {
			try {
				supplier.setProducts(extProductDao.loadSupplierProducts(supplier.getSupplierId()));
			} catch (Exception e) {
				Log.error("Load repated products error. the error Supplier is " + supplier.getSupplierName(), this.getClass(), e.getCause());
			}
		}
		return supplierList;
	}
	
	/** 
	 * Supplier abstract query.
	 */
	public List<Supplier> abstractQuery(String condition) {
		List<Supplier> supplierList = new ArrayList<Supplier>();
		try {
			supplierList = supplierDao.loadAll();
		} catch (Exception e) {
			Log.error("Load all suppliers error.", this.getClass(), e.getCause());
		}
		
		for(Supplier supplier : supplierList) {
			try {
				supplier.setProducts(extProductDao.loadSupplierProducts(supplier.getSupplierId()));
			} catch (Exception e) {
				Log.error("Load repated products error. the error Supplier is " + supplier.getSupplierName(), this.getClass(), e.getCause());
			}
		}
		return supplierList;
	}
}
