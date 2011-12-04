/**
 * 
 */
package com.coral.fundation.rules;

import com.coral.cstore.utils.StrUtils;

/**
 * @author coral.ma
 *
 */
public class PasswordRule {

	public static String empty = "";
	
	public static String checkPasswordInput(String pw) {
		if(pw == null || "".equals(pw)) {
			return StrUtils.getResourceString("message.system.alert.notnull");
		}
		if(pw.length() < 3) {
			return StrUtils.getResourceString("message.user.shotPassword");
		}
		return empty;
	}
	
	public static String validatePassword(String pw, String repw) {
		String p1 = checkPasswordInput(pw);
		if(!empty.equals(p1)) {
			return p1;
		}
		String p2 = checkPasswordInput(repw);
		if(!empty.equals(p2)) {
			return p2;
		}
		if(!pw.equals(repw)) {
			return StrUtils.getResourceString("message.user.diffPassword");
		}
		return "";
	}
	
	public static void main(String[] args) {
		System.out.println("Test checkPasswordInput. The result is :" + checkPasswordInput(null));
		System.out.println("Test checkPasswordInput. The result is :" + checkPasswordInput(""));
		System.out.println("Test checkPasswordInput. The result is :" + checkPasswordInput("12"));
		System.out.println("Test checkPasswordInput. The result is :" + checkPasswordInput("123"));
		System.out.println("Test checkPasswordInput. The result is :" + checkPasswordInput("1234"));
		System.out.println("Test validatePassword. The result is :" + validatePassword("1234","12"));
		System.out.println("Test validatePassword. The result is :" + validatePassword("12","1234"));
		System.out.println("Test validatePassword. The result is :" + validatePassword("123","1234"));
		System.out.println("Test validatePassword. The result is :" + validatePassword("1234","1234"));
	}
}
