/**
 * 
 */
package com.coral.cstore.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import com.coral.cstore.IView;
import com.coral.cstore.Style;
import com.coral.cstore.utils.ImageUtils;
import com.coral.cstore.utils.StrUtils;

/**
 * @author coral.ma
 *
 */
public class UserTaskListTabView implements IView {
	
	CTabItem item;
	private static final String[] columnNames = {StrUtils.getResourceString("tab.userTask.orderNo"),
		StrUtils.getResourceString("tab.userTask.customerName"),
		StrUtils.getResourceString("tab.userTask.totalPrice"),
		StrUtils.getResourceString("tab.userTask.orderDate"),
		StrUtils.getResourceString("tab.userTask.deliverDate"),
		StrUtils.getResourceString("tab.userTask.creator"),
		StrUtils.getResourceString("tab.userTask.status")};
	

	public CTabItem asTabView(CTabFolder tabFolder) {
		CTabItem item = new CTabItem(tabFolder, SWT.DEFAULT);
		item.setShowClose(false);
		item.setText(StrUtils.tabTitle(StrUtils.getResourceString("tab.mainBoard")));
//		createOperateTable(tabFolder);
		item.setControl(getCompositePage(tabFolder,null));
		return null;
	}

	public Composite getCompositePage(Composite parent, String pageId) {
		GridLayout gridLayout = new GridLayout(1,true);
		Style.gridLayoutUtils(gridLayout);
//		GridData gridLayout = new GridData(GridData.FILL, GridData.BEGINNING, true, false);
		Composite composite = new Composite(parent,SWT.NONE);
		composite.setLayout(gridLayout);
		composite.setBackground(Style.white);
		
		Label label = new Label(composite, SWT.SHADOW_OUT);
		label.setFont(Style.tabTitleFont);
		label.setBackground(Style.white);
		label.setText(StrUtils.getResourceString("tab.mainBoard.label",new String[]{"Coral"}));
		Label description = new Label(composite,  SWT.WRAP | SWT.SHADOW_OUT);
		description.setText(StrUtils.getResourceString("tab.mainBoard.description"));
		description.setBackground(Style.white);
		description.setForeground(Style.gray);
		description.setLayoutData(new GridData(GridData.BEGINNING, GridData.BEGINNING, true, false));
		createOperateTable(composite);
		return composite;
	}
	
	public void createOperateTable(Composite parent) {
		GridData gridDate = new GridData(GridData.FILL, GridData.FILL, true, true);
		Table table = new Table(parent, SWT.SINGLE | SWT.BORDER | SWT.FULL_SELECTION);
		table.setLayoutData(gridDate);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		for(int i = 0; i < columnNames.length; i++) {
			TableColumn column = new TableColumn(table, SWT.NONE);
			column.setText(columnNames[i]);
			column.setWidth(100);
		}
	}
	
	public void refresh() {
		// TODO Auto-generated method stub
		
	}

	public String viewName() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setModel(Object obj) {
		// TODO Auto-generated method stub
		
	}

	
}
