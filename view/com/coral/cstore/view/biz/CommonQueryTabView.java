/**
 * 
 */
package com.coral.cstore.view.biz;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;

import com.coral.cstore.IView;
import com.coral.cstore.MvpController;
import com.coral.cstore.Style;
import com.coral.cstore.utils.LayoutUtils;
import com.coral.cstore.utils.StrUtils;
import com.coral.cstore.utils.WidgetUtils;
import com.coral.cstore.view.ViewList;
import com.coral.cstore.view.biz.table.CustomerTable;
import com.coral.cstore.view.biz.table.SupplierTable;

/**
 * @author coral.ma
 *
 */
public class CommonQueryTabView implements IView {

	Shell shell;
	MvpController controller;
	CTabItem item;
	
	public CommonQueryTabView(Shell shell, MvpController controller) {
		this.controller = controller;
		this.shell = shell;
	}

	public CTabItem asTabView(CTabFolder tabFolder) {
		item = WidgetUtils.createClosableCTabItem(tabFolder, StrUtils.getResourceString("tab.query.label"));
		item.setData(ViewList.viewName, viewName());
		item.setControl(getCompositePage(tabFolder,null));
		bind();
		refresh();
		return item;
	}

	public Composite getCompositePage(Composite parent, String pageId) {
		GridLayout gridLayout = new GridLayout(12,true);
		Style.gridLayoutUtils(gridLayout);
		
		Composite composite = new Composite(parent,SWT.NONE);
		composite.setLayout(gridLayout);
		composite.setBackground(Style.white);

		GridData labelGD = new GridData(GridData.FILL, GridData.BEGINNING, true, false);
		labelGD.horizontalSpan=12;
		Label label = WidgetUtils.createTitleLabel(composite, StrUtils.getResourceString("tab.query.label"));
		label.setLayoutData(labelGD);
		
		GridData descData = new GridData(GridData.BEGINNING, GridData.BEGINNING, true, false);
		descData.horizontalSpan=12;
		Label descLabel = WidgetUtils.createDescriptionLabel(composite, StrUtils.getResourceString("tab.query.label"));
		descLabel.setLayoutData(descData);
		
		GridData queryTextData = LayoutUtils.createHBTFGridData(5);
		GridData queryBtnData = LayoutUtils.createHBTFGridData(2);
		GridData emptyGD = LayoutUtils.createFillGridData(5);
		Text searchText = WidgetUtils.createText(composite);
		searchText.setLayoutData(queryTextData);
		Button searchBtn = WidgetUtils.createButton(composite, StrUtils.getResourceString("group.search.button"));
		searchBtn.setLayoutData(queryBtnData);
		WidgetUtils.createEmptyLabel(composite).setLayoutData(emptyGD);
		
		GridData searchInputGD = LayoutUtils.createBETFGridData(8);
		Composite checkBtnComposite = LayoutUtils.createRowComposite(composite);
		checkBtnComposite.setLayoutData(searchInputGD);
//		GridData checkBtnData = LayoutUtils.createHBTFGridData(2);
		Button checkAll = WidgetUtils.createCheckBox(checkBtnComposite, StrUtils.getResourceString("tab.query.condition.all"));
		Button checkOrder = WidgetUtils.createCheckBox(checkBtnComposite, StrUtils.getResourceString("tab.query.condition.order"));
		Button checkCustomer = WidgetUtils.createCheckBox(checkBtnComposite, StrUtils.getResourceString("tab.query.condition.customer"));
		Button checkSupplier = WidgetUtils.createCheckBox(checkBtnComposite, StrUtils.getResourceString("tab.query.condition.supplier"));
//		checkAll.setLayoutData(checkBtnData);
//		checkOrder.setLayoutData(checkBtnData);
//		checkCustomer.setLayoutData(checkBtnData);
//		checkSupplier.setLayoutData(checkBtnData);
		GridData checkEmptyGD = LayoutUtils.createFillGridData(4);
		WidgetUtils.createEmptyLabel(composite).setLayoutData(checkEmptyGD);
		

		GridData searchResultGD = new GridData(GridData.FILL, GridData.BEGINNING, false, false);
		searchResultGD.horizontalSpan=12;
		Composite customerComposite = LayoutUtils.createVerticalRowComposite(composite);
		customerComposite.setLayoutData(searchResultGD);
		Label customerResultLabel = WidgetUtils.createBoldLabel(customerComposite, StrUtils.getResourceString("tab.query.result.customer"));
//		customerResultLabel.setLayoutData(labelGD);
		CustomerTable customerTable = new CustomerTable(customerComposite);
		Table custTable = customerTable.getSupplierTable();
//		custTable.setLayoutData(labelGD);
		
		Composite supplierComposite = LayoutUtils.createVerticalRowComposite(composite);
		supplierComposite.setLayoutData(searchResultGD);
		Label supplierResultLabel = WidgetUtils.createBoldLabel(supplierComposite, StrUtils.getResourceString("tab.query.result.supplier"));
//		supplierResultLabel.setLayoutData(labelGD);
		SupplierTable supplierTable = new SupplierTable(supplierComposite);
		Table table = supplierTable.getSupplierTable();
//		table.setLayoutData(labelGD);
		return composite;
	}
	
	public void bind() {
		
	}
	
	public void refresh() {
		// TODO Auto-generated method stub
		
	}

	public String viewName() {
		return ViewList.commonQuery;
	}

	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setModel(Object obj) {
		// TODO Auto-generated method stub
		
	}
	
	
}
