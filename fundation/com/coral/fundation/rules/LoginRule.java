/**
 * 
 */
package com.coral.fundation.rules;

/**
 * @author coral.ma
 *
 */
public class LoginRule {

	public static boolean isCorrectInput(String un, String pw) {
		if(!"".equals(un) && !"".equals(pw)) {
			return true;
		}
		return false;
	}
	
	public static void main(String args[]) {
		System.out.println(isCorrectInput("a",""));
		System.out.println(isCorrectInput("","b"));
		System.out.println(isCorrectInput("a","b"));
	}
}
