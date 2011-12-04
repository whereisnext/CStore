/**
 * 
 */
package com.coral.cstore.view.biz.dialog;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.coral.cstore.Style;
import com.coral.cstore.utils.DataBindingUtils;
import com.coral.cstore.utils.LayoutUtils;
import com.coral.cstore.utils.StrUtils;
import com.coral.cstore.utils.ValidateUtil;
import com.coral.cstore.view.AbstractDialog;
import com.coral.cstore.view.biz.CreateCustomerTabView;
import com.coral.store.model.Customer;

/**
 * @author Coral
 *
 */
public class CreateCustomerDialog extends AbstractDialog {

	CreateCustomerTabView view;
	Customer value;
	Composite composite;

	public CreateCustomerDialog(Shell parent, boolean isEdit) {
		super.parentShell = parent;
		super.isEdit = isEdit;
		shell = new Shell (parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		shell.setText(StrUtils.getResourceString("tab.product.createBtn"));
		shell.setBackground(Style.white);
		shell.setLayout(new FillLayout());		
		initWidget();
	}
	
	public void initWidget() {
		view = new CreateCustomerTabView();
//		view.isDialog();
		composite = view.getCompositePage(shell,"Dialog");
		GridData btn = LayoutUtils.createCenterGridData(9);
		Button button = new Button(composite, SWT.PUSH);
		if(isEdit) {
			button.setText(StrUtils.getResourceString("tab.mangCustomer.updateBtn"));
		} else {
			button.setText(StrUtils.getResourceString("tab.mangCustomer.createBtn"));
		}
		button.setLayoutData(btn);		
		button.addMouseListener(new MouseAdapter() {
			public void mouseUp(MouseEvent e) {
				Control[] children = composite.getChildren();
				if(value == null) {
					value = new Customer();
				}
				value = (Customer)DataBindingUtils.dataBinding(children, value, value.getClass());
				String checkRs = ValidateUtil.validateCustomer(value);
				if(!checkRs.equals(StrUtils.empty)) {
					return;
				}
				shell.close();
			}
		});
		
	}
	
	public void setValue(Customer customer) {
		this.value = customer;
		DataBindingUtils.bindingToComposite(customer,composite);
	}
	
	public Customer getValue() {
		return value;
	}
	
	public Customer open() {
		shell.setSize (800, 400);
		openDialog();	
		return getValue();
	}
}
