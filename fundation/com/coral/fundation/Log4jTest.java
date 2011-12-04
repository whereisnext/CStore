/**
 * 
 */
package com.coral.fundation;

import org.apache.log4j.Logger;

/**
 * @author coral.ma
 * 
 */
public class Log4jTest {
	private static final Logger logger = (Logger) Logger
			.getLogger(Log4jTest.class.getName());

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			String str = "3d";
			logger.debug("str length:" + str.length());
			int num = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			logger.warn("字符串格式化错误！" + e);
			logger.error("字符串格式化错误！ error级别的！！！" + e.getMessage());
			logger.info("系统初始化！");
		}
	}

}
