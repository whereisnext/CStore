package com.coral.store.basic.service;

import java.util.Date;
import com.coral.store.basic.dao.IProductDao;
import com.coral.cstore.utils.StrUtils;
import com.coral.fundation.IDGenerater;
import com.coral.fundation.Log;
import com.coral.fundation.bean.BeanUtils;
import com.coral.fundation.utils.SqlUtils;
import com.coral.store.utils.StoreUtils;
import java.util.List;
import com.coral.store.model.Product;
/**
 * <p>Title: com.coral.store.basic.service.ProductDS</p>
 * <p>Description: ProductDS entity </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-09-02 12:02 </p>
 */
public class ProductDS {

	IProductDao productDao = BeanUtils.getBean("productDao", IProductDao.class);

	public Product createProduct(Product product) {
		try {
			product.setProductId(IDGenerater.generate());
			StoreUtils.abstractProduct(product);
			productDao.create(product);
		} catch (Exception e) {
			Log.error("Create Product error.", this.getClass(),e.getCause());
		}
		return product;
	}

	public Product updateProduct(Product product) {
		try {
			StoreUtils.abstractProduct(product);
			productDao.update(product);
		} catch (Exception e) {
			Log.error("Update Product error.", this.getClass(),e.getCause());
		}
		return product;
	}

	public String deleteProduct(Product product) {
		deleteProduct(product.getProductId());
		return StrUtils.empty;
	}

	public String deleteProduct(String productId) {
		try {
			productDao.remove(productId);
		} catch (Exception e) {
			Log.error("Delete Product error.", this.getClass(),e.getCause());
		}
		return StrUtils.empty;
	}

	public Product loadProduct(String productId) {
		Product product= null;
		try {
			product = productDao.load(productId);
		} catch (Exception e) {
			Log.error("load Product error.", this.getClass(),e.getCause());
		}
		return product;
	}

	public List<Product> loadAllProduct() {
		List<Product> productList = null;
		try {
			productList = productDao.loadAll();
		} catch (Exception e) {
			Log.error("load Product error.", this.getClass(),e.getCause());
		}
		return productList;
	}
}

