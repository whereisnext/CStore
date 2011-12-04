/**
 * 
 */
package com.coral.fundation.service.test;

import com.coral.fundation.service.UserService;

import junit.framework.TestCase;

/**
 * @author coral.ma
 *
 */
public class UserServiceTest extends TestCase {
	
	public void testLogin() {
		UserService service = new UserService();
		System.out.println(service.login("coral", "110"));
	}

}
