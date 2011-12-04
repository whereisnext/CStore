/**
 * 
 */
package com.coral.store.ext;

import java.util.List;

import com.coral.store.model.Supplier;

/**
 * @author coral.ma
 *
 */
public interface IExtSupplierDao {

	public List<Supplier> abstractQuery(String condition, String pinyinCondition) throws Exception;
}
