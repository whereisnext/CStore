/**
 * 
 */
package com.coral.tool.generator.view;

/**
 * @author coral.ma
 *
 */
public class CreateOrderPrdtGen extends AbstractGen {

	public static String[] orderPrdtList = new String[]{"supplierName",
		"productName",
		"number",
		"spec",
		"color",
		"salePrice"};
	
	private static String[] oneColumns = new String[]{"mark"};
	
	public static String i18nTitle="tab.orderProductSheet.";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CreateOrderGen gen = new CreateOrderGen();
		System.out.println(gen.generate(orderPrdtList,oneColumns,i18nTitle));
	}

}
