/**
 * 
 */
package com.coral.cstore.view.biz;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.coral.cstore.IView;
import com.coral.cstore.Style;
import com.coral.cstore.utils.CodeTableUtils;
import com.coral.cstore.utils.DataBindingUtils;
import com.coral.cstore.utils.LayoutUtils;
import com.coral.cstore.utils.MessageCenter;
import com.coral.cstore.utils.StrUtils;
import com.coral.cstore.utils.WidgetUtils;
import com.coral.cstore.view.TwoColumnViewLayout;
import com.coral.cstore.view.ViewList;
import com.coral.store.model.Customer;
import com.coral.store.service.CustomerService;

/**
 * @author Coral
 *
 */
public class CreateCustomerTabView extends TwoColumnViewLayout implements IView {
	Customer customer = new Customer();
	CTabItem item;
	Composite composite;
	Shell shell;
	
	public CreateCustomerTabView() {
	}
	public CreateCustomerTabView(Shell shell) {
		this.shell = shell;
	}
	
	public CTabItem asTabView(CTabFolder tabFolder) {
		item = WidgetUtils.createClosableCTabItem(tabFolder, StrUtils.getResourceString("tab.customer.label"));
		item.setData(ViewList.viewName, viewName());
		item.setControl(getCompositePage(tabFolder, null));
		return item;
	}
	
	public Composite getCompositePage(Composite parent, String pageType) {
//		int totalColumn =12,labelSize = 1,inputSize = 3,midEmpty = 1,endEmpty = 3;
		GridLayout gridLayout = new GridLayout(totalColumn,true);
		Style.gridLayoutUtils(gridLayout);
		
		composite = new Composite(parent,SWT.NONE);
		composite.setLayout(gridLayout);
		composite.setBackground(Style.white);

		GridData labelGD = LayoutUtils.createHBTFGridData(totalColumn);
		Label label = WidgetUtils.createTitleLabel(composite, StrUtils.getResourceString("tab.customer.label"));
		label.setLayoutData(labelGD);
		
		GridData descData = LayoutUtils.createHBTFGridData(totalColumn);
		Label descLabel = WidgetUtils.createDescriptionLabel(composite, StrUtils.getResourceString("tab.customer.description"));
		descLabel.setLayoutData(descData);

		// customerName controller.
		Label customerNameLabel = WidgetUtils.createRequiredLabel(composite, StrUtils.getResourceString("tab.customer.customerName"));
		customerNameLabel.setLayoutData(lLabelGD);
		Text customerNameInput = WidgetUtils.createText(composite);
		customerNameInput.setData("customerName");
		customerNameInput.setLayoutData(lInputGD);
		customerNameInput.setFocus();
		createMidEmpty(composite);

		// contectPerson controller.
		Label contectPersonLabel = WidgetUtils.createLabel(composite, StrUtils.getResourceString("tab.customer.contectPerson"));
		contectPersonLabel.setLayoutData(lLabelGD);
		Text contectPersonInput = WidgetUtils.createText(composite);
		contectPersonInput.setData("contectPerson");
		contectPersonInput.setLayoutData(lInputGD);
		createEndEmpty(composite);
		
		// district controller.
		Label districtLabel = WidgetUtils.createLabel(composite, StrUtils.getResourceString("tab.customer.district"));
		districtLabel.setLayoutData(lLabelGD);
		Combo districtInput = WidgetUtils.createCombo(composite, CodeTableUtils.district);
		districtInput.setData("district");
		districtInput.setLayoutData(lInputGD);
		createMidEmpty(composite);
		
		// postcode controller.
		Label postcodeLabel = WidgetUtils.createLabel(composite, StrUtils.getResourceString("tab.customer.postcode"));
		postcodeLabel.setLayoutData(lLabelGD);
		Text postcodeInput = WidgetUtils.createText(composite);
		postcodeInput.setData("postcode");
		postcodeInput.setLayoutData(lInputGD);
		createEndEmpty(composite);

		// address controller.
		Label addressLabel = WidgetUtils.createLabel(composite, StrUtils.getResourceString("tab.customer.address"));
		addressLabel.setLayoutData(lLabelGD);
		Text addressInput = WidgetUtils.createText(composite);
		addressInput.setData("address");
		addressInput.setLayoutData(lCInputGD);
		createEndEmpty(composite);

		// mobile controller.
		Label mobileLabel = WidgetUtils.createLabel(composite, StrUtils.getResourceString("tab.customer.mobile"));
		mobileLabel.setLayoutData(lLabelGD);
		Text mobileInput = WidgetUtils.createText(composite);
		mobileInput.setData("mobile");
		mobileInput.setLayoutData(lInputGD);
		createMidEmpty(composite);

		// phone controller.
		Label phoneLabel = WidgetUtils.createLabel(composite, StrUtils.getResourceString("tab.customer.phone"));
		phoneLabel.setLayoutData(lLabelGD);
		Text phoneInput = WidgetUtils.createText(composite);
		phoneInput.setData("phone");
		phoneInput.setLayoutData(lInputGD);
		createEndEmpty(composite);

		// fax controller.
		Label faxLabel = WidgetUtils.createLabel(composite, StrUtils.getResourceString("tab.customer.fax"));
		faxLabel.setLayoutData(lLabelGD);
		Text faxInput = WidgetUtils.createText(composite);
		faxInput.setData("fax");
		faxInput.setLayoutData(lInputGD);
		createMidEmpty(composite);

		// url controller.
		Label urlLabel = WidgetUtils.createLabel(composite, StrUtils.getResourceString("tab.customer.url"));
		urlLabel.setLayoutData(lLabelGD);
		Text urlInput = WidgetUtils.createText(composite);
		urlInput.setData("url");
		urlInput.setLayoutData(lInputGD);
		createEndEmpty(composite);

		// email controller.
		Label emailLabel = WidgetUtils.createLabel(composite, StrUtils.getResourceString("tab.customer.email"));
		emailLabel.setLayoutData(lLabelGD);
		Text emailInput = WidgetUtils.createText(composite);
		emailInput.setData("email");
		emailInput.setLayoutData(lInputGD);
		createMidEmpty(composite);

		// accountBank controller.
		Label accountBankLabel = WidgetUtils.createLabel(composite, StrUtils.getResourceString("tab.customer.accountBank"));
		accountBankLabel.setLayoutData(lLabelGD);
		Text accountBankInput = WidgetUtils.createText(composite);
		accountBankInput.setData("accountBank");
		accountBankInput.setLayoutData(lInputGD);
		createEndEmpty(composite);

		// accountNumber controller.
		Label accountNumberLabel = WidgetUtils.createLabel(composite, StrUtils.getResourceString("tab.customer.accountNumber"));
		accountNumberLabel.setLayoutData(lLabelGD);
		Text accountNumberInput = WidgetUtils.createText(composite);
		accountNumberInput.setData("accountNumber");
		accountNumberInput.setLayoutData(lInputGD);
		createMidEmpty(composite);

		// accountPerson controller.
		Label accountPersonLabel = WidgetUtils.createLabel(composite, StrUtils.getResourceString("tab.customer.accountPerson"));
		accountPersonLabel.setLayoutData(lLabelGD);
		Text accountPersonInput = WidgetUtils.createText(composite);
		accountPersonInput.setData("accountPerson");
		accountPersonInput.setLayoutData(lInputGD);
		createEndEmpty(composite);

		// mark controller.
		Label markLabel = WidgetUtils.createLabel(composite, StrUtils.getResourceString("tab.customer.mark"));
		markLabel.setLayoutData(lLabelGD);
		Text markInput = WidgetUtils.createText(composite);
		markInput.setData("mark");
		markInput.setLayoutData(lCInputGD);
		createEndEmpty(composite);
		
		if(pageType == null) {
			Button button = new Button(composite, SWT.PUSH);
			button.setText(StrUtils.getResourceString("tab.customer.createCustomer"));
			button.setLayoutData(btn);		
			button.addMouseListener(new MouseAdapter() {
				public void mouseUp(MouseEvent e) {
					Control[] children = composite.getChildren();
					customer = (Customer)DataBindingUtils.dataBinding(children, customer, Customer.class);
					CustomerService custService = new CustomerService();
					custService.createCustomer(customer);
					customer = new Customer();
					refresh();
					MessageCenter.alertMessage(shell, "Create supplier success.").open();
				}
			});
		}
		// set force to user name text
		return composite;
	}

	public void refresh() {
		if(customer != null) {
			DataBindingUtils.bindingToComposite(customer,composite);
		}
	}

	public String viewName() {
		return ViewList.createCustomer;
	}

	public Object getModel() {
		return customer;
	}

	public void setModel(Object obj) {
		this.customer = (Customer)obj;
	}

}
