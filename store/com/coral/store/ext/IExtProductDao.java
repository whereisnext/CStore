/**
 * 
 */
package com.coral.store.ext;

import java.util.List;

import com.coral.store.model.Product;
import com.coral.store.model.Supplier;

/**
 * @author coral.ma
 *
 */
public interface IExtProductDao {

	public List<Product> loadSupplierProducts(String supplierId) throws Exception;
	public List<Product> abstractQuery(String condition, String pinyinCondition) throws Exception;
}
