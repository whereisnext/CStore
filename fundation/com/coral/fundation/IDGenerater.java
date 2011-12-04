/**
 * 
 */
package com.coral.fundation;

import java.util.UUID;

/**
 * @author coral.ma
 * 
 */
public class IDGenerater {

	public static String generate() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(IDGenerater.generate());
		System.out.println(IDGenerater.generate().length());
	}
}
