/**
 * 
 */
package com.coral.cstore.view.admin;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.coral.cstore.IView;
import com.coral.cstore.Style;
import com.coral.cstore.utils.DataBindingUtils;
import com.coral.cstore.utils.LayoutUtils;
import com.coral.cstore.utils.MessageCenter;
import com.coral.cstore.utils.StrUtils;
import com.coral.cstore.utils.WidgetUtils;
import com.coral.cstore.view.TwoColumnViewLayout;
import com.coral.cstore.view.ViewList;
import com.coral.fundation.model.BasicInfo;
import com.coral.fundation.service.BasicInfoSetupService;

/**
 * @author Coral
 *
 */
public class BasicInfoSetupTabView extends TwoColumnViewLayout implements IView {

	CTabItem item;
	Shell shell;
	Composite composite;
	BasicInfo basicInfo;
	BasicInfoSetupService service = new BasicInfoSetupService();
	
//	public BasicInfoSetupTabView() {
//	}
	
	public BasicInfoSetupTabView(Shell shell) {
		this.shell = shell;
	}
	
	public CTabItem asTabView(CTabFolder tabFolder) {
		item = WidgetUtils.createClosableCTabItem(tabFolder, StrUtils.getResourceString("tab.basicInfo"));
		item.setData(ViewList.viewName, viewName());
		item.setControl(getCompositePage(tabFolder,null));
		bind();
		refresh();
		return item;
	}
	
	public Composite getCompositePage(Composite parent, String pageId) {
		GridLayout gridLayout = new GridLayout(totalColumn,true);
		Style.gridLayoutUtils(gridLayout);
		
		composite = new Composite(parent,SWT.NONE);
		composite.setLayout(gridLayout);
		composite.setBackground(Style.white);

		GridData labelGD = LayoutUtils.createHBTFGridData(totalColumn);
		Label label = WidgetUtils.createTitleLabel(composite, StrUtils.getResourceString("tab.basicInfo"));
		label.setLayoutData(labelGD);
		
		GridData descData = LayoutUtils.createHBTFGridData(totalColumn);
		Label descLabel = WidgetUtils.createDescriptionLabel(composite, StrUtils.getResourceString("tab.basicInfo.description"));
		descLabel.setLayoutData(descData);

		// companyName controller.
		Label companyNameLabel = WidgetUtils.createLabel(composite, StrUtils.getResourceString("tab.basicInfo.companyName"));
		companyNameLabel.setLayoutData(lLabelGD);
		Text companyNameInput = WidgetUtils.createText(composite);
		companyNameInput.setData("companyName");
		companyNameInput.setLayoutData(lInputGD);
		createMidEmpty(composite);

		// phone controller.
		Label phoneLabel = WidgetUtils.createLabel(composite, StrUtils.getResourceString("tab.basicInfo.phone"));
		phoneLabel.setLayoutData(lLabelGD);
		Text phoneInput = WidgetUtils.createText(composite);
		phoneInput.setData("phone");
		phoneInput.setLayoutData(lInputGD);
		createEndEmpty(composite);

		// fax controller.
		Label faxLabel = WidgetUtils.createLabel(composite, StrUtils.getResourceString("tab.basicInfo.fax"));
		faxLabel.setLayoutData(lLabelGD);
		Text faxInput = WidgetUtils.createText(composite);
		faxInput.setData("fax");
		faxInput.setLayoutData(lInputGD);
		createMidEmpty(composite);

		// district controller.
		Label districtLabel = WidgetUtils.createLabel(composite, StrUtils.getResourceString("tab.basicInfo.district"));
		districtLabel.setLayoutData(lLabelGD);
		Text districtInput = WidgetUtils.createText(composite);
		districtInput.setData("district");
		districtInput.setLayoutData(lInputGD);
		createEndEmpty(composite);
		
		// deliverAddress controller.
		Label deliverAddressLabel = WidgetUtils.createLabel(composite, StrUtils.getResourceString("tab.basicInfo.deliverAddress"));
		deliverAddressLabel.setLayoutData(lLabelGD);
		Text deliverAddressInput = WidgetUtils.createText(composite);
		deliverAddressInput.setData("deliverAddress");
		deliverAddressInput.setLayoutData(lCInputGD);
		createEndEmpty(composite);

		// deliverPostcode controller.
		Label deliverPostcodeLabel = WidgetUtils.createLabel(composite, StrUtils.getResourceString("tab.basicInfo.deliverPostcode"));
		deliverPostcodeLabel.setLayoutData(lLabelGD);
		Text deliverPostcodeInput = WidgetUtils.createText(composite);
		deliverPostcodeInput.setData("deliverPostcode");
		deliverPostcodeInput.setLayoutData(lInputGD);
		createMidEmpty(composite);

		// url controller.
		Label urlLabel = WidgetUtils.createLabel(composite, StrUtils.getResourceString("tab.basicInfo.url"));
		urlLabel.setLayoutData(lLabelGD);
		Text urlInput = WidgetUtils.createText(composite);
		urlInput.setData("url");
		urlInput.setLayoutData(lInputGD);
		createEndEmpty(composite);

		// email controller.
		Label emailLabel = WidgetUtils.createLabel(composite, StrUtils.getResourceString("tab.basicInfo.email"));
		emailLabel.setLayoutData(lLabelGD);
		Text emailInput = WidgetUtils.createText(composite);
		emailInput.setData("email");
		emailInput.setLayoutData(lInputGD);
		createMidEmpty(composite);

		// accountBank controller.
		Label accountBankLabel = WidgetUtils.createLabel(composite, StrUtils.getResourceString("tab.basicInfo.accountBank"));
		accountBankLabel.setLayoutData(lLabelGD);
		Text accountBankInput = WidgetUtils.createText(composite);
		accountBankInput.setData("accountBank");
		accountBankInput.setLayoutData(lInputGD);
		createEndEmpty(composite);

		// accountNumber controller.
		Label accountNumberLabel = WidgetUtils.createLabel(composite, StrUtils.getResourceString("tab.basicInfo.accountNumber"));
		accountNumberLabel.setLayoutData(lLabelGD);
		Text accountNumberInput = WidgetUtils.createText(composite);
		accountNumberInput.setData("accountNumber");
		accountNumberInput.setLayoutData(lInputGD);
		createMidEmpty(composite);

		// accountPerson controller.
		Label accountPersonLabel = WidgetUtils.createLabel(composite, StrUtils.getResourceString("tab.basicInfo.accountPerson"));
		accountPersonLabel.setLayoutData(lLabelGD);
		Text accountPersonInput = WidgetUtils.createText(composite);
		accountPersonInput.setData("accountPerson");
		accountPersonInput.setLayoutData(lInputGD);
		createEndEmpty(composite);

		Button button = new Button(composite, SWT.PUSH);
		button.setText(StrUtils.getResourceString("tab.basicInfo.saveButton"));
		button.setLayoutData(btn);		
		button.addMouseListener(new MouseAdapter() {
			public void mouseUp(MouseEvent e) {
				if(basicInfo == null) basicInfo = new BasicInfo();
				basicInfo = (BasicInfo)DataBindingUtils.dataBinding(composite.getChildren(), basicInfo, BasicInfo.class);
				service.saveBasicInfo(basicInfo);
				MessageCenter.alertMessage(shell, "Save basic information success.").open();
			}
		});
		
		return composite;
	}
	
	public void bind() {

	}
	
	public void refresh() {
		basicInfo = service.loadBasicInfo();
		if(basicInfo != null) {
			DataBindingUtils.bindingToComposite(basicInfo,composite);
		}
	}

	public String viewName() {
		return ViewList.basicInfoSetup;
	}

	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setModel(Object obj) {
		// TODO Auto-generated method stub
		
	}

}
