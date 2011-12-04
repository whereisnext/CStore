/**
 * 
 */
package com.coral.cstore;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.widgets.Shell;

import com.coral.cstore.view.ViewList;
import com.coral.cstore.view.admin.BasicInfoSetupTabView;
import com.coral.cstore.view.admin.ChangePasswordTabView;
import com.coral.cstore.view.admin.CreateUserTabView;
import com.coral.cstore.view.admin.ManageRoleTabView;
import com.coral.cstore.view.biz.CommonQueryTabView;
import com.coral.cstore.view.biz.CreateCustomerTabView;
import com.coral.cstore.view.biz.CreatePurchaseOrderTabView;
import com.coral.cstore.view.biz.CreateSaleOrderTabView;
import com.coral.cstore.view.biz.CreateSupplierTabView;
import com.coral.cstore.view.biz.ManageCustomerTabView;
import com.coral.cstore.view.biz.ManageSupplierTabView;



/**
 * @author Coral
 *
 */
public class MvpController {
	
	CTabFolder container;
	Shell shell;
	Map<String,IView> viewMap = new HashMap<String,IView>();
	
	public void setShell(Shell shell) {
		this.shell = shell;
	}

	public void changeTabView(String tabViewName) {
		changeTabView(tabViewName, null);
	}
	
	public void changeTabView(String tabViewName, Object bo) {
		StatusBar.bar.setSelection(10);
		CTabItem[] existedViews = container.getItems();
		for(CTabItem existedView : existedViews) {
			StatusBar.bar.setSelection(50);
			String existedViewName = (String) existedView.getData(ViewList.viewName);
			if(existedViewName!=null && existedViewName.equals(tabViewName)) {
				IView view = viewMap.get(tabViewName);
				if(view != null) {
					view.refresh();
				}
				container.setSelection(existedView);
				StatusBar.bar.setSelection(100);
//				StatusBar.bar.setSelection(0);
				return;
			}
		}
		IView view = null;
		// initialize view
		StatusBar.bar.setSelection(30);
		view = getAdminView(tabViewName,view,bo);
		view = getBizView(tabViewName,view,bo);
		StatusBar.bar.setSelection(90);
		// display view
		if(view != null) {
			CTabItem item = view.asTabView(container);
			if(!viewMap.containsKey(view.viewName())) {
				viewMap.put(view.viewName(), view);
			}
			container.setSelection(item);
		}
		StatusBar.bar.setSelection(100);
//		StatusBar.bar.setSelection(0);
	}
	
	public IView getAdminView(String tabViewName,IView view, Object bo) {
		if(tabViewName.equals(ViewList.createUser)) {
			view = new CreateUserTabView(shell);
		}
		if(tabViewName.equals(ViewList.changePassword)) {
			view = new ChangePasswordTabView();
		}
		if(tabViewName.equals(ViewList.basicInfoSetup)) {
			view = new BasicInfoSetupTabView(shell);
		}
		if(tabViewName.equals(ViewList.manageRole)) {
			view = new ManageRoleTabView(shell);
		}
		
		return view;
	}
	
	public IView getBizView(String tabViewName,IView view, Object bo) {
		if(tabViewName.equals(ViewList.createCustomer)) {
			view = new CreateCustomerTabView(shell);
		}
		if(tabViewName.equals(ViewList.createSupplier)) {
			view = new CreateSupplierTabView(shell);
			view.setModel(bo);
		}
		if(tabViewName.equals(ViewList.manageCustomer)) {
			view = new ManageCustomerTabView(shell);
		}
		if(tabViewName.equals(ViewList.createSaleOrderSheet)) {
			view = new CreateSaleOrderTabView(shell);
		}
		if(tabViewName.equals(ViewList.createOrderSheet)) {
			view = new CreatePurchaseOrderTabView(shell);
		}
		if(tabViewName.equals(ViewList.manageSupplier)) {
			view = new ManageSupplierTabView(shell,this);
		}
		if(tabViewName.equals(ViewList.commonQuery)) {
			view = new CommonQueryTabView(shell,this);
		}
		return view;
	}

	/**
	 * @return the container
	 */
	public CTabFolder getContainer() {
		return container;
	}

	/**
	 * @param container the container to set
	 */
	public void setContainer(CTabFolder container) {
		this.container = container;
	}
}
