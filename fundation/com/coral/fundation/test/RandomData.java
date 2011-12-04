/**
 * 
 */
package com.coral.fundation.test;

import java.util.Random;

/**
 * @author coral.ma
 *
 */
public class RandomData {
	
	static String chinese = "赵钱孙李周吴郑王冯陈褚卫蒋沈韩杨朱秦尤许何吕施张孔曹严华金魏陶姜戚谢邹喻柏水窦章云苏潘葛奚范彭郎鲁韦昌马苗凤花方俞任袁柳鲍史唐";
	public final static String[] district = new String[]{"北京市","天津市","重庆市","上海市","河北省","山西省","辽宁省","吉林省","黑龙江省","江苏省","浙江省","安徽省","福建省","江西省","山东省","河南省","湖北省","湖南省","广东省","海南省","四川省","贵州省","云南省","陕西省","甘肃省","青海省","台湾省","内蒙古自治区","广西壮族自治区","宁夏回族自治区","新疆维吾尔自治区","西藏自治区","香港特别行政区","澳门特别行政区"};
	public final static String[] banks = new String[]{"中国银行","农业银行","交通银行","建设银行","工商银行","浦发银行","光大银行",};
	public final static String[] units = new String[]{"吨","箱","千克","件"};
	public final static String[] colors = new String[]{"红色","橙色","黄色","绿色","蓝色","靛蓝","紫色","黑色"};
	public static String getRandomNumber(int length) {
	    String base = "123456789";
	    Random random = new Random();
	    StringBuffer sb = new StringBuffer();
	    for (int i = 0; i < length; i++) {
	      int number = random.nextInt(base.length());
	      sb.append(base.charAt(number));
	    }
	    return sb.toString();
	  }

	  public static String getRandomString(int length) {
	    String big = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    String base = "abcdefghijklmnopqrstuvwxyz";
	    Random random = new Random();
	    StringBuffer sb = new StringBuffer();
	    int n = random.nextInt(base.length());
	    sb.append(big.charAt(n));
	    for (int i = 0; i < (length - 1); i++) {
	      int number = random.nextInt(base.length());
	      sb.append(base.charAt(number));
	    }
	    return sb.toString();
	  }
	  
	  public static String getRandomChineseName(int length) {
	    Random random = new Random();
	    StringBuffer sb = new StringBuffer();
	    for (int i = 0; i < length; i++) {
		      int number = random.nextInt(chinese.length());
		      sb.append(chinese.charAt(number));
		    }
	    return sb.toString();
	  }
	  
	  public static String getRandomChineseCompany(int length) {
		  return getRandomChineseName(length)+ "有限公司";
	  }
	  
	  public static String getRandomChineseDistrict() {
		  Random random = new Random();
	      int number = random.nextInt(district.length);
 	      return district[number];
	  }
	  
	  public static String getRandomBank() {
		  Random random = new Random();
	      int number = random.nextInt(banks.length);
 	      return banks[number];
	  }
	  
	  public static String getRandomUnit() {
		  Random random = new Random();
	      int number = random.nextInt(units.length);
 	      return units[number];
	  }
	  
	  public static String getRandomColor() {
		  Random random = new Random();
	      int number = random.nextInt(colors.length);
 	      return colors[number];
	  }
	  
	  public static String getRandomEmail() {
		  return getRandomString(5) + "@gmail.com";
	  }
}
