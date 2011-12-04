/**
 * 
 */
package com.coral.fundation.service.test;

import java.util.List;

import com.coral.fundation.model.ModelMenu;
import com.coral.fundation.service.RoleService;

import junit.framework.TestCase;

/**
 * @author coral.ma
 *
 */
public class RoleServiceTest extends TestCase {
	
	public void testLoadWholeMenu() {
		RoleService roleService = new RoleService();
		List<ModelMenu> modelMenus = roleService.loadWholeMenu();
		System.out.println(modelMenus);
	}
}
