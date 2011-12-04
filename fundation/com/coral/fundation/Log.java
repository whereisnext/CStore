/**
 * 
 */
package com.coral.fundation;

import org.apache.log4j.Logger;



/**
 * @author coral.ma
 *
 */
public class Log {
	
	public static void info(String s,Class cls) {
		Logger.getLogger(cls).info(s);
	}
	public static void error(String s,Class cls) {
		Logger.getLogger(cls).error(s);
	}
	public static void error(String s, Class cls, Throwable t) {
		Logger.getLogger(cls).info(s,t);
	}
	
}
