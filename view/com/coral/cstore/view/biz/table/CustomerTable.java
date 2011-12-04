/**
 * 
 */
package com.coral.cstore.view.biz.table;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import com.coral.cstore.utils.StrUtils;
import com.coral.cstore.view.AbstractTable;

/**
 * @author coral.ma
 *
 */
public class CustomerTable extends AbstractTable {

	public static final String[] columnHead = {"customerId",StrUtils.getResourceString("tab.customer.customerName"),
		StrUtils.getResourceString("tab.customer.contectPerson"),
		StrUtils.getResourceString("tab.customer.mobile"),
		StrUtils.getResourceString("tab.customer.phone"),
		StrUtils.getResourceString("tab.customer.fax"),
		StrUtils.getResourceString("tab.customer.district"),
		StrUtils.getResourceString("tab.customer.address"),
		StrUtils.getResourceString("tab.customer.postcode"),
		StrUtils.getResourceString("tab.customer.url"),
		StrUtils.getResourceString("tab.customer.email"),
		StrUtils.getResourceString("tab.customer.accountBank"),
		StrUtils.getResourceString("tab.customer.accountNumber"),
		StrUtils.getResourceString("tab.customer.accountPerson"),
		StrUtils.getResourceString("tab.customer.mark")};
	
	public static String[] columnVariable = new String[]{"customerId","customerName",
		"contectPerson",
		"mobile",
		"phone",
		"fax",
		"district",
		"address",
		"postcode",
		"url",
		"email",
		"accountBank",
		"accountNumber",
		"accountPerson",
		"mark"};
	
	Table table;
	Composite composite;

	public CustomerTable(Composite composite) {
		this.composite = composite; 
	}
	
	public Table getSupplierTable() {
		table = new Table(composite, SWT.SINGLE | SWT.BORDER | SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		TableColumn idcolumn = new TableColumn(table, SWT.HIDE_SELECTION);
		idcolumn.setText(columnHead[0]);
		idcolumn.setData(columnVariable[0]);
		for(int i = 1; i < columnHead.length; i++) {
			TableColumn column = new TableColumn(table, SWT.NONE);
			column.setText(columnHead[i]);
			column.setData(columnVariable[i]);
			column.setWidth(80);
		}
		return table;
	}
	
}
