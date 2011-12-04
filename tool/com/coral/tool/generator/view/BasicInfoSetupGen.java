/**
 * 
 */
package com.coral.tool.generator.view;


/**
 * @author coral.ma
 *
 */
public class BasicInfoSetupGen extends AbstractGen {
	
	private static String[] twoColumns = new String[]{
		"companyName",
		"phone",
		"fax",
		"district",
		"deliverPostcode",
		"url",
		"email",
		"accountBank",
		"accountNumber",
		"accountPerson"};
	
	private static String[] oneColumns = new String[]{"deliverAddress"};

	public static String i18nTitle="tab.tab.basicInfo.";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BasicInfoSetupGen gen = new BasicInfoSetupGen();
		System.out.println(gen.generate(twoColumns,oneColumns,i18nTitle));
	}

}
