/**
 * 
 */
package com.coral.cstore.utils;

import com.coral.store.model.Customer;
import com.coral.store.model.Product;
import com.coral.store.model.Supplier;

/**
 * @author coral.ma
 *
 */
public class ValidateUtil {
	
	public static String validateSupplier(Supplier supplier) {
		return notNullCheck(supplier.getSupplierName());
	}
	
	public static String validateProduct(Product product) {
		String checkPcRs = ValidateUtil.notNullCheck(product.getProductCode());
		String checkPnRs = ValidateUtil.notNullCheck(product.getProductName());
		if(!checkPcRs.equals(StrUtils.empty) || !checkPnRs.equals(StrUtils.empty)) {
			return "Can not be null.";
		}
		return StrUtils.empty;
	}
	
	public static String validateCustomer(Customer customer) {
		return notNullCheck(customer.getCustomerName());
	}

	public static String notNullCheck(String pw) {
		if(pw == null || StrUtils.empty.equals(pw)) {
			return StrUtils.getResourceString("message.system.alert.notnull");
		}
		return StrUtils.empty;
	}
}
