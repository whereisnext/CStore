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
public class ProductTable extends AbstractTable {

	Table table;
	Composite composite;
	
	public ProductTable(Composite composite) {
		this.composite = composite; 
	}

	public static final String[] columnHeads = {"productId",StrUtils.getResourceString("tab.product.productCode"),
		StrUtils.getResourceString("tab.product.productName"),
		StrUtils.getResourceString("tab.product.brand"),
		StrUtils.getResourceString("tab.product.unit"),
		StrUtils.getResourceString("tab.product.spec"),
		StrUtils.getResourceString("tab.product.color"),
		StrUtils.getResourceString("tab.product.buyPrice"),
		StrUtils.getResourceString("tab.product.salePrice"),
		StrUtils.getResourceString("tab.product.mark")};
	
	public static String[] columnVariable = new String[]{"productId","productCode",
		"productName",
		"brand",
		"unit",
		"spec",
		"color",
		"buyPrice",
		"salePrice",
		"mark"};
	
	public Table getTable() {
		table = new Table(composite, SWT.SINGLE | SWT.BORDER | SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		TableColumn idcolumn = new TableColumn(table, SWT.HIDE_SELECTION);
		idcolumn.setText(columnHeads[0]);
		idcolumn.setData(columnVariable[0]);
		for(int i = 1; i < columnHeads.length; i++) {
			TableColumn column = new TableColumn(table, SWT.NONE);
			column.setText(columnHeads[i]);
			column.setData(columnVariable[i]);
			column.setWidth(80);
		}
		return table;
	}
}
