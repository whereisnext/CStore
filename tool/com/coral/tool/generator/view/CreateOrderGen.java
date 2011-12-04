/**
 * 
 */
package com.coral.tool.generator.view;

/**
 * @author coral.ma
 *
 */
public class CreateOrderGen extends AbstractGen {

	public static String[] orderList = new String[]{"orderNo",
			"customerName",
			"receivePerson",
			"mobile",
			"deliverPostcode",
			"deliverDate"};
	
	private static String[] oneColumns = new String[]{"deliverAddress","mark"};
	
	public static String i18nTitle="tab.orderSheet.";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CreateOrderGen gen = new CreateOrderGen();
		System.out.println(gen.generate(orderList,oneColumns,i18nTitle));
	}

}
