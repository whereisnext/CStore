/**
 * 
 */
package com.coral.store.service.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import junit.framework.TestCase;

import com.coral.fundation.test.RandomData;
import com.coral.store.model.Product;
import com.coral.store.model.SaleOrderProduct;
import com.coral.store.model.SaleOrderSheet;
import com.coral.store.service.ProductService;
import com.coral.store.service.SaleOrderService;

/**
 * @author coral.ma
 *
 */
public class SaleOrderServiceTest extends TestCase {
	
	SaleOrderService saleOrderService = new SaleOrderService();
	
	public SaleOrderSheet createSaleOrder() {
		SaleOrderSheet order = new SaleOrderSheet();
		order.setSaleOrderNo(RandomData.getRandomNumber(6));                
		order.setCustomerName(RandomData.getRandomChineseCompany(4));
		order.setReceivePerson(RandomData.getRandomChineseName(3));              
		order.setMobile(RandomData.getRandomNumber(11));
		String district = RandomData.getRandomChineseDistrict();
		order.setDistrict(district);
		order.setDeliverAddress(district);             
		order.setDeliverPostcode(RandomData.getRandomNumber(6));
		order.setDeliverDate(new Date());                
		order.setTotalPrice(RandomData.getRandomNumber(4));
		order.setStatus("1");                 
		order.setProducts(createProduct(Integer.parseInt(RandomData.getRandomNumber(1))));
		saleOrderService.createSaleOrderSheet(order);
		return order;
	}
	
	public List<SaleOrderProduct> createProduct(int number) {
		List<SaleOrderProduct> productList = new ArrayList<SaleOrderProduct>();
		for(int i=0;i<number; i++) {
			SaleOrderProduct product = new SaleOrderProduct();
			product.setProductName(RandomData.getRandomChineseName(4));
			product.setNumber(RandomData.getRandomNumber(2));
			product.setSpec(RandomData.getRandomChineseName(2));
			product.setColor(RandomData.getRandomColor());
			product.setSalePrice(RandomData.getRandomNumber(4));
			productList.add(product);
		}
		return productList;
	}
	
	public void deleteSaleOrder(SaleOrderSheet order) {
		saleOrderService.deleteSaleOrderSheet(order);
	}
	
	public void testUpdateSaleOrder() {
		SaleOrderSheet orderSheet = createSaleOrder();
		String newName = RandomData.getRandomChineseCompany(4);
		orderSheet.setCustomerName(newName);
		saleOrderService.updateSaleOrderSheet(orderSheet);
		SaleOrderSheet updatedOrder = saleOrderService.loadSaleOrderSheet(orderSheet.getSaleOrderSheetId());
		assertEquals(updatedOrder.getCustomerName(),newName);
		deleteSaleOrder(orderSheet);
	}
	
}
