/**
 * 
 */
package com.coral.store.service.test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import com.coral.fundation.test.RandomData;
import com.coral.store.model.Product;
import com.coral.store.model.Supplier;
import com.coral.store.service.ProductService;
import com.coral.store.service.SupplierService;

/**
 * @author coral.ma
 *
 */
public class SupplierServiceTest extends TestCase {
	
	SupplierService supplierService = new SupplierService();
	
	public Supplier createSupplier() {
		return createSupplier(false);
	}
	public Supplier createSupplier(boolean isSpec) {
		Supplier supplier = new Supplier();
		supplier.setSupplierName(RandomData.getRandomChineseCompany(4));
		String name = RandomData.getRandomChineseName(3);
		supplier.setContectPerson(name);
		String district = RandomData.getRandomChineseDistrict();
		supplier.setDistrict(district);
		supplier.setAddress(district);
		supplier.setPostcode(RandomData.getRandomNumber(6));
		supplier.setMobile(RandomData.getRandomNumber(11));
		if(isSpec) {
			supplier.setPhone(RandomData.getRandomNumber(8));
		} else {
			supplier.setPhone("13812345678");
		}
		supplier.setEmail(RandomData.getRandomEmail());
		supplier.setFax(RandomData.getRandomNumber(8));
		supplier.setAccountBank(RandomData.getRandomBank());
		supplier.setAccountNumber(RandomData.getRandomNumber(15));
		supplier.setAccountPerson(name);
		supplier.setProducts(createProduct(Integer.parseInt(RandomData.getRandomNumber(1))));
		return supplierService.createSupplier(supplier);
	}
	
	public List<Product> createProduct(int number) {
		List<Product> productList = new ArrayList<Product>();
		String productCode = RandomData.getRandomString(3);
		String brand = RandomData.getRandomChineseName(3);
		for(int i=0;i<number; i++) {
			Product product = new Product();
			product.setProductCode(productCode+RandomData.getRandomNumber(5));
			product.setProductName(RandomData.getRandomChineseName(4));
			product.setBrand(brand);
			product.setUnit(RandomData.getRandomUnit());
			product.setSpec(RandomData.getRandomChineseName(2));
			product.setColor(RandomData.getRandomColor());
			String buyP = RandomData.getRandomNumber(4);
			product.setBuyPrice(buyP);
			Long saleP = (long) (Long.parseLong(buyP) * 1.5);
			product.setSalePrice(saleP.toString());
			productList.add(product);
		}
		return productList;
	}
	
	public void deleteSupplier(Supplier customer) {
		supplierService.deleteSupplier(customer);
	}
	
	public void vtestUpdateSupplier() {
		Supplier customer = createSupplier();
		customer.setSupplierName(RandomData.getRandomChineseCompany(5));
		supplierService.updateSupplier(customer);
		deleteSupplier(customer);
	}
	
	public void vtestLoadSupplier() {
		Supplier customer = createSupplier();
		Supplier newCustomer = supplierService.loadSupplier(customer.getSupplierId());
		assertEquals(customer.getSupplierName(), newCustomer.getSupplierName());
		deleteSupplier(customer);
	}
	
	public void vtestLoadAllSupplier() {
		for(int i=0;i<30;i++) {
			createSupplier();
		}
		List<Supplier> newCustomers = supplierService.loadAll();
		assertTrue(newCustomers.size()>2);
		for(Supplier customer : newCustomers) {
			deleteSupplier(customer);
		}
	}
	
	public void testAbstractQuery() {
		for(int i=0;i<30;i++) {
			createSupplier();
		}
		createSupplier(true);
//		List<Supplier> newCustomers = supplierService.abstractQuery("123");
//		assertTrue(newCustomers.size() > 0);
//		for(Supplier customer : newCustomers) {
//			deleteSupplier(customer);
//		}
	}
	
//	public void testAbstractQueryProduct() {
//		for(int i=0;i<3;i++) {
//			createSupplier();
//		}
//		ProductService productService = new ProductService();
//		List<Product> products = productService.abstractQuery("1");
//		System.out.println(products);
//	}

}
