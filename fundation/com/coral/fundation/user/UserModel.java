/**
 * 
 */
package com.coral.fundation.user;


import java.util.ArrayList;
import java.util.List;

import com.coral.fundation.model.ModelMenu;
import com.coral.fundation.model.ShotCut;
import com.coral.fundation.model.User;


/**
 * @author Coral
 *
 */
public class UserModel {
	
	public User user;
	public List<ModelMenu> menus;
	public List<ShotCut> shotCuts;
	/**
	 * @return the user
	 */
	public User getUser() {
		user = new User();
		user.setUserName("Coral");
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @return the menus
	 */
	public List<ModelMenu> getMenus() {
//		List<ModelMenu> menus = new ArrayList<ModelMenu>();
//		ModelMenu menu1 = createModelMenu(1, 0, "menu.File.text");
//		List<ModelMenu> subMenus1 = new ArrayList<ModelMenu>();
//		ModelMenu submenu1_1 = createModelMenu(1, 0, "menu.File.Close.text","Close");
//		subMenus1.add(submenu1_1);
//		menu1.setSubMenus(subMenus1);
//		menus.add(menu1);
//		
//		ModelMenu menu2 =createModelMenu(2,0,"menu.Biz.text");
//		List<ModelMenu> subMenus2 = new ArrayList<ModelMenu>();
//		ModelMenu submenu2_1 = createModelMenu(1, 0, "menu.Biz.createCustomer.text","CreateCustomer");
//		subMenus2.add(submenu2_1);
//		ModelMenu submenu2_3 = createModelMenu(1, 0, "menu.Biz.mangCustomer","ManageCustomer");
//		subMenus2.add(submenu2_3);
//		ModelMenu submenu2_2 = createModelMenu(2, 0, "menu.Biz.createSupplier.text","CreateSupplier");
//		subMenus2.add(submenu2_2);
//		ModelMenu submenu2_5 = createModelMenu(2, 0, "menu.Biz.mangSupplier","ManageSupplier");
//		subMenus2.add(submenu2_5);
//		ModelMenu submenu2_4 = createModelMenu(1, 0, "tab.saleorderSheet.label","CreateSaleOrderSheet");
//		subMenus2.add(submenu2_4);
//		ModelMenu submenu2_6 = createModelMenu(1, 0, "tab.query.label","commonQuery");
//		subMenus2.add(submenu2_6);
//		menu2.setSubMenus(subMenus2);
//		menus.add(menu2);
//		
//		ModelMenu menu3 = createModelMenu(3,0,"menu.Admin.text");
//		List<ModelMenu> subMenus3 = new ArrayList<ModelMenu>();
//		ModelMenu submenu3_1 = createModelMenu(1, 0, "menu.Admin.createUser.text","CreateUser");
//		subMenus3.add(submenu3_1);
//		ModelMenu submenu3_2 = createModelMenu(1, 0, "menu.Admin.changePassword.text","ChangePassword");
//		subMenus3.add(submenu3_2);
//		menu3.setSubMenus(subMenus3);
//		menus.add(menu3);
//		
//		ModelMenu menu4 = createModelMenu(4,0,"menu.Help.text");
//		List<ModelMenu> subMenus4 = new ArrayList<ModelMenu>();
//		ModelMenu submenu4_1 = createModelMenu(1, 0, "menu.Help.About.text","CreateUser");
//		subMenus4.add(submenu4_1);
//		menu4.setSubMenus(subMenus4);
//		menus.add(menu4);
		return menus;
	}
	
	public ModelMenu createModelMenu(long id, long pid, String text) {
		ModelMenu menu1 = new ModelMenu();
		menu1.setModelMenuId(String.valueOf(id));
		menu1.setMenuId(id);
		menu1.setParentMenuId(pid);
		menu1.setMenuName(text);
		return menu1;
	}
	public ModelMenu createModelMenu(long id, long pid, String text,String view) {
		ModelMenu menu1 = new ModelMenu();
		menu1.setModelMenuId(String.valueOf(id));
		menu1.setMenuId(id);
		menu1.setParentMenuId(pid);
		menu1.setMenuName(text);
		menu1.setViewName(view);
		return menu1;
	}
	/**
	 * @param menus the menus to set
	 */
	public void setMenus(List<ModelMenu> menus) {
		this.menus = menus;
	}
	/**
	 * @return the shotCuts
	 */
	public List<ShotCut> getShotCuts() {
		return shotCuts;
	}
	/**
	 * @param shotCuts the shotCuts to set
	 */
	public void setShotCuts(List<ShotCut> shotCuts) {
		this.shotCuts = shotCuts;
	}

}
