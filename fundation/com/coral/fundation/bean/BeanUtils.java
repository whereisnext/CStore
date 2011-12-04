/**
 * 
 */
package com.coral.fundation.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author coral.ma
 * 
 */
public class BeanUtils {

	private static ApplicationContext context = new ClassPathXmlApplicationContext(
			new String[] { "store-bean.xml", "foundation-bean.xml" });

	public static <T> T getBean(String key, Class<T> cls) {
		return context.getBean(key, cls);
	}
}
