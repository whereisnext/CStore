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
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.coral.cstore.IView;
import com.coral.cstore.Style;
import com.coral.cstore.utils.DataBindingUtils;
import com.coral.cstore.utils.LayoutUtils;
import com.coral.cstore.utils.MessageCenter;
import com.coral.cstore.utils.StrUtils;
import com.coral.cstore.utils.WidgetUtils;
import com.coral.cstore.view.ViewList;
import com.coral.fundation.model.User;
import com.coral.fundation.rules.PasswordRule;
import com.coral.fundation.service.UserService;

/**
 * @author Coral
 *
 */
public class ChangePasswordTabView implements IView {
	Shell shell;
	User  user;
	Text oldPasswordText;
	CTabItem item;
	public ChangePasswordTabView(){}
	public ChangePasswordTabView(Shell shell){
		this.shell = shell;
	}
	
	public CTabItem asTabView(CTabFolder tabFolder) {
		item = new CTabItem(tabFolder, SWT.DEFAULT);
		item.setData(ViewList.viewName, ViewList.changePassword);
		item.setShowClose(true);
		item.setText(StrUtils.tabTitle(StrUtils.getResourceString("tab.changePassword")));
		item.setControl(getCompositePage(tabFolder,null));
		return item;
	}
	
	public Composite getCompositePage(Composite parent, String pageId) {
		GridLayout gridLayout = new GridLayout(8,true);
		Style.gridLayoutUtils(gridLayout);
		
		final Composite composite = new Composite(parent,SWT.NONE);
		composite.setLayout(gridLayout);
		composite.setBackground(Style.white);

		GridData labelGD = new GridData(GridData.FILL, GridData.BEGINNING, true, false);
		labelGD.horizontalSpan=8;
		Label label = new Label(composite, SWT.SHADOW_OUT);
		Style.tabTitleLabel(label);
		label.setText(StrUtils.getResourceString("tab.changePassword.label"));
		label.setLayoutData(labelGD);
		
		GridData descData = new GridData(GridData.BEGINNING, GridData.BEGINNING, true, false);
		descData.horizontalSpan=8;
		Label descLabel = new Label(composite, SWT.WRAP | SWT.SHADOW_OUT);
		Style.tabDescriptionLabel(descLabel);
		descLabel.setLayoutData(descData);
		descLabel.setText(StrUtils.getResourceString("tab.changePassword.description"));
		
		GridData lb = LayoutUtils.createFillGridData(1);
		GridData tb = LayoutUtils.createFillGridData(2);
		GridData hb = LayoutUtils.createFillGridData(5);
		GridData btn = LayoutUtils.createCenterGridData(3);

		// user name combine with label, text and empty label.
		Label oldPasswordLabel = WidgetUtils.createRequiredLabel(composite, StrUtils.getResourceString("tab.changePassword.oldPassword"));
		oldPasswordLabel.setLayoutData(lb);
		oldPasswordText = WidgetUtils.createText(composite);
		oldPasswordText.setLayoutData(tb);
		final Label oldPasswordTip = WidgetUtils.createEmptyLabel(composite);
		oldPasswordTip.setLayoutData(hb);
		
		// password
		Label passwordLabel = WidgetUtils.createRequiredLabel(composite, StrUtils.getResourceString("tab.changePassword.newPassword"));
		passwordLabel.setLayoutData(lb);
		final Text passwordText = WidgetUtils.createPassword(composite);
		passwordText.setLayoutData(tb);
		Label passwordTip = WidgetUtils.createEmptyLabel(composite);
		passwordTip.setLayoutData(hb);
		
		// repassword
		Label rePasswordLabel = WidgetUtils.createRequiredLabel(composite, StrUtils.getResourceString("tab.changePassword.reNewPassword"));
		rePasswordLabel.setLayoutData(lb);
		final Text rePasswordText = WidgetUtils.createPassword(composite);
		rePasswordText.setLayoutData(tb);
		Label rePasswordTip = WidgetUtils.createEmptyLabel(composite);
		rePasswordTip.setLayoutData(hb);
		
		Button changePasswordBtn = new Button(composite, SWT.PUSH);
		changePasswordBtn.setText(StrUtils.getResourceString("tab.changePassword"));
		changePasswordBtn.setLayoutData(btn);		
		changePasswordBtn.addMouseListener(new MouseAdapter() {
			public void mouseUp(MouseEvent e) {
				String result = PasswordRule.validatePassword(passwordText.getText(), rePasswordText.getText());
				if(!result.equals(PasswordRule.empty)) {
					MessageBox messageBox = MessageCenter.alertMessage(shell, result);
					messageBox.open();
					return;
				}
				Control[] children = composite.getChildren();
				user = (User)DataBindingUtils.dataBinding(children, user, User.class);
				UserService service = new UserService();
				service.updateUser(user);
			}
		});
		oldPasswordText.setFocus();
		return composite;
	}
	
	public void refresh() {
		oldPasswordText.setFocus();
	}

	public String viewName() {
		return ViewList.changePassword;
	}

	/**
	 * @return the item
	 */
	public CTabItem getItem() {
		return item;
	}

	/**
	 * @param item the item to set
	 */
	public void setItem(CTabItem item) {
		this.item = item;
	}

	public Object getModel() {
		return user;
	}

	public void setModel(Object obj) {
		this.user = (User)obj;
	}
}
