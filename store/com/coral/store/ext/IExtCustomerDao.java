/**
 * 
 */
package com.coral.store.ext;

import java.util.List;

import com.coral.store.model.Customer;

/**
 * @author coral.ma
 *
 */
public interface IExtCustomerDao {

	public List<Customer> abstractQuery(String condition, String pinyinCondition) throws Exception;
}
