/**
 * 
 */
package com.coral.store.service;

import java.util.List;

import com.coral.fundation.Log;
import com.coral.fundation.bean.BeanUtils;
import com.coral.fundation.utils.SqlUtils;
import com.coral.store.basic.service.ProductDS;
import com.coral.store.ext.IExtProductDao;
import com.coral.store.model.Product;
import com.coral.store.utils.StoreUtils;

/**
 * @author coral.ma
 *
 */
public class ProductService {

	IExtProductDao extProductDao = BeanUtils.getBean("extProductDao",IExtProductDao.class);
	
	public List<Product> abstractQuery(String condition) {
		List<Product> products = null;
		try {
			String abStr = SqlUtils.like(condition);
			String pinyinStr = SqlUtils.like(StoreUtils.cn2Spell(condition));
			products = extProductDao.abstractQuery(abStr, pinyinStr);
		} catch (Exception e) {
			Log.error("Abstract query Product error.", this.getClass(),e.getCause());
		}
		return products;
	}
	
	public List<Product> loadAllProduct() {
		List<Product> products = null;
		ProductDS ds = new ProductDS();
		products = ds.loadAllProduct();
		return products;
	}
}
