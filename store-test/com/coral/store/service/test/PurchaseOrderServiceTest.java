/**
 * 
 */
package com.coral.store.service.test;

import com.coral.fundation.test.RandomData;
import com.coral.store.model.Customer;
import com.coral.store.model.PurchaseOrderSheet;

import junit.framework.TestCase;

/**
 * @author coral.ma
 *
 */
public class PurchaseOrderServiceTest extends TestCase {

	public Customer createPurchaseOrder() {
		PurchaseOrderSheet sheet = new PurchaseOrderSheet();
//		sheet.setOrderNo(RandomData.getRandomChineseCompany(4));
		String name = RandomData.getRandomChineseName(3);
//		sheet.setContectPerson(name);
//		String district = RandomData.getRandomChineseDistrict();
//		sheet.setDistrict(district);
//		sheet.setAddress(district);
//		sheet.setPostcode(RandomData.getRandomNumber(6));
//		sheet.setMobile(RandomData.getRandomNumber(11));
//		sheet.setPhone(RandomData.getRandomNumber(8));
//		sheet.setEmail(RandomData.getRandomEmail());
//		sheet.setFax(RandomData.getRandomNumber(8));
//		sheet.setAccountBank(RandomData.getRandomBank());
//		sheet.setAccountNumber(RandomData.getRandomNumber(15));
//		sheet.setAccountPerson(name);
//		return customerService.createCustomer(sheet);
		return null;
	}
	
	public void testCreatePurchaseOrder() {
		
	}
}
