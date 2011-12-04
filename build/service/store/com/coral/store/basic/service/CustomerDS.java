package com.coral.store.basic.service;

import java.util.Date;
import com.coral.store.basic.dao.ICustomerDao;
import com.coral.cstore.utils.StrUtils;
import com.coral.fundation.IDGenerater;
import com.coral.fundation.Log;
import com.coral.fundation.bean.BeanUtils;
import com.coral.fundation.utils.SqlUtils;
import com.coral.store.utils.StoreUtils;
import java.util.List;
import com.coral.store.model.Customer;
/**
 * <p>Title: com.coral.store.basic.service.CustomerDS</p>
 * <p>Description: CustomerDS entity </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-09-02 12:02 </p>
 */
public class CustomerDS {

	ICustomerDao customerDao = BeanUtils.getBean("customerDao", ICustomerDao.class);

	public Customer createCustomer(Customer customer) {
		try {
			customer.setCustomerId(IDGenerater.generate());
			StoreUtils.abstractCustomer(customer);
			customerDao.create(customer);
		} catch (Exception e) {
			Log.error("Create Customer error.", this.getClass(),e.getCause());
		}
		return customer;
	}

	public Customer updateCustomer(Customer customer) {
		try {
			StoreUtils.abstractCustomer(customer);
			customerDao.update(customer);
		} catch (Exception e) {
			Log.error("Update Customer error.", this.getClass(),e.getCause());
		}
		return customer;
	}

	public String deleteCustomer(Customer customer) {
		deleteCustomer(customer.getCustomerId());
		return StrUtils.empty;
	}

	public String deleteCustomer(String customerId) {
		try {
			customerDao.remove(customerId);
		} catch (Exception e) {
			Log.error("Delete Customer error.", this.getClass(),e.getCause());
		}
		return StrUtils.empty;
	}

	public Customer loadCustomer(String customerId) {
		Customer customer= null;
		try {
			customer = customerDao.load(customerId);
		} catch (Exception e) {
			Log.error("load Customer error.", this.getClass(),e.getCause());
		}
		return customer;
	}

	public List<Customer> loadAllCustomer() {
		List<Customer> customerList = null;
		try {
			customerList = customerDao.loadAll();
		} catch (Exception e) {
			Log.error("load Customer error.", this.getClass(),e.getCause());
		}
		return customerList;
	}
}

