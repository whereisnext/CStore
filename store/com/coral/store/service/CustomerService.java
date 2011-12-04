/**
 * 
 */
package com.coral.store.service;

import java.util.List;

import com.coral.cstore.utils.StrUtils;
import com.coral.fundation.IDGenerater;
import com.coral.fundation.Log;
import com.coral.fundation.bean.BeanUtils;
import com.coral.fundation.utils.SqlUtils;
import com.coral.store.basic.dao.ICustomerDao;
import com.coral.store.basic.service.CustomerDS;
import com.coral.store.ext.IExtCustomerDao;
import com.coral.store.model.Customer;
import com.coral.store.utils.StoreUtils;

/**
 * @author coral.ma
 *
 */
public class CustomerService extends CustomerDS {
	
//	ICustomerDao customerDao = BeanUtils.getBean("customerDao", ICustomerDao.class);
	IExtCustomerDao extCustomerDao = BeanUtils.getBean("extCustomerDao", IExtCustomerDao.class);
/*	
	public Customer createCustomer(Customer cust) {
		try {
			cust.setCustomerId(IDGenerater.generate());
			StoreUtils.abstractCustomer(cust);
			customerDao.create(cust);	
		} catch (Exception e) {
			Log.error("Create customer error.", this.getClass(),e.getCause());
		}
		return cust;
	}
	
	public Customer updateCustomer(Customer cust) {
		try {
			StoreUtils.abstractCustomer(cust);
			customerDao.update(cust);	
		} catch (Exception e) {
			Log.error("Update customer error.", this.getClass(),e.getCause());
		}
		return cust;
	}
	
	public String deleteCustomer(Customer cust) {
		deleteCustomer(cust.getCustomerId());
		return StrUtils.empty;
	}
	public String deleteCustomer(String customerId) {
		try {
			customerDao.remove(customerId);	
		} catch (Exception e) {
			Log.error("Delete customer error.", this.getClass(),e.getCause());
		}
		return StrUtils.empty;
	}
	public Customer loadCustomer(String customerId) {
		Customer customer = null;
		try {
			customer = customerDao.load(customerId);
		} catch (Exception e) {
			Log.error("Load customer error.", this.getClass(),e.getCause());
		}
		return customer;
	}
	public List<Customer> loadAllCustomer() {
		List<Customer> customerList = null;
		try {
			customerList = customerDao.loadAll();
		} catch (Exception e) {
			Log.error("Load customer error.", this.getClass(),e.getCause());
		}
		return customerList;
	}
	*/
	public List<Customer> abstractQuery(String condition) {
		List<Customer> customerList = null;
		try {
			String abStr = SqlUtils.like(condition);
			String pinyinStr = SqlUtils.like(StoreUtils.cn2Spell(condition));
			customerList = extCustomerDao.abstractQuery(abStr, pinyinStr);
		} catch (Exception e) {
			Log.error("Abstract query customer error.", this.getClass(),e.getCause());
		}
		return customerList;
	}
}
