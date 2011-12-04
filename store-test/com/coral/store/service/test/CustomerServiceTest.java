/**
 * 
 */
package com.coral.store.service.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.coral.fundation.bean.BeanUtils;
import com.coral.fundation.service.UserService;
import com.coral.fundation.test.RandomData;
import com.coral.store.model.Customer;
import com.coral.store.service.CustomerService;

/**
 * @author coral.ma
 *
 */
public class CustomerServiceTest extends TestCase {
	
//	CustomerService customerService = BeanUtils.getBean("customerService",CustomerService.class);
	CustomerService customerService = new CustomerService();
	
	public Customer createCustomer() {
		Customer customer = new Customer();
		customer.setCustomerName(RandomData.getRandomChineseCompany(4));
		String name = RandomData.getRandomChineseName(3);
		customer.setContectPerson(name);
		String district = RandomData.getRandomChineseDistrict();
		customer.setDistrict(district);
		customer.setAddress(district);
		customer.setPostcode(RandomData.getRandomNumber(6));
		customer.setMobile(RandomData.getRandomNumber(11));
		customer.setPhone(RandomData.getRandomNumber(8));
		customer.setEmail(RandomData.getRandomEmail());
		customer.setFax(RandomData.getRandomNumber(8));
		customer.setAccountBank(RandomData.getRandomBank());
		customer.setAccountNumber(RandomData.getRandomNumber(15));
		customer.setAccountPerson(name);
		return customerService.createCustomer(customer);
	}
	
	public Customer createSpecialCustomer() {
		Customer customer = new Customer();
		customer.setCustomerName("蒙奇D路飞");
		String name = RandomData.getRandomChineseName(3);
		customer.setContectPerson(name);
		String district = RandomData.getRandomChineseDistrict();
		customer.setDistrict(district);
		customer.setAddress(district);
		customer.setPostcode(RandomData.getRandomNumber(6));
		customer.setMobile("13812345678");
		customer.setPhone(RandomData.getRandomNumber(8));
		customer.setEmail(RandomData.getRandomEmail());
		customer.setFax(RandomData.getRandomNumber(8));
		customer.setAccountBank(RandomData.getRandomBank());
		customer.setAccountNumber(RandomData.getRandomNumber(15));
		customer.setAccountPerson(name);
		return customerService.createCustomer(customer);
	}
	
	public void deleteCustomer(Customer customer) {
		customerService.deleteCustomer(customer);
	}
	
	public void testUpdateCustomer() {
		Customer customer = createCustomer();
		customer.setCustomerName(RandomData.getRandomChineseCompany(5));
		customerService.updateCustomer(customer);
		deleteCustomer(customer);
	}
	
	public void testLoadCustomer() {
		Customer customer = createCustomer();
		Customer newCustomer = customerService.loadCustomer(customer.getCustomerId());
		assertEquals(customer.getCustomerName(), newCustomer.getCustomerName());
		deleteCustomer(customer);
	}
	
	public void testLoadAllCustomer() {
		for(int i=0;i<3;i++) {
			createCustomer();
		}
		List<Customer> newCustomers = customerService.loadAllCustomer();
		assertTrue(newCustomers.size()>2);
		for(Customer customer : newCustomers) {
			deleteCustomer(customer);
		}
	}
	
	public void testAbstractQuery() {
		List<Customer> removedCustomers = new ArrayList<Customer>();
		for(int i=0;i<3;i++) {
			removedCustomers.add(createCustomer());
		}
		Customer specCustomer = createSpecialCustomer();
		List<Customer> newCustomers = customerService.abstractQuery("路飞");
		assertTrue(newCustomers.size()>0);
		List<Customer> secCustomers = customerService.abstractQuery("123");
		assertTrue(secCustomers.size()>0);
		for(Customer customer : removedCustomers) {
			deleteCustomer(customer);
		}
		deleteCustomer(specCustomer);
	}
}
