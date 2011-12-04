/**
 * 
 */
package com.coral.cstore.view.admin;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import com.coral.cstore.IView;
import com.coral.cstore.utils.LayoutUtils;
import com.coral.cstore.utils.StrUtils;
import com.coral.cstore.utils.WidgetUtils;
import com.coral.cstore.view.TwoColumnViewLayout;
import com.coral.cstore.view.ViewList;
import com.coral.fundation.user.RoleModel;

/**
 * @author coral.ma
 *
 */
public class ManageRoleTabView extends TwoColumnViewLayout implements IView {

	Shell shell;
	Composite composite;
	CTabItem item;
	RoleModel currentRoleModel;
	List<RoleModel> roleModelList;
	
	int roleListLen= 1;
	int otherRoleLen= 7;
	
	public ManageRoleTabView() {}
	public ManageRoleTabView(Shell shell) {
		this.shell =  shell;
	}
	
	public CTabItem asTabView(CTabFolder tabFolder) {
		item = new CTabItem(tabFolder, SWT.DEFAULT);
		item.setData(ViewList.viewName, ViewList.manageRole);
		item.setShowClose(true);
		item.setText(StrUtils.tabTitle(StrUtils.getResourceString("tab.manageRole")));
		item.setControl(getCompositePage(tabFolder,null));
		return item;
	}

	public Composite getCompositePage(Composite parent, String pageId) {	
		composite = createComposite(parent,"tab.manageRole","tab.manageRole.description");
		// init role list
		GridData roleListGD = LayoutUtils.createHFTTGridData(roleListLen);
		roleListGD.verticalSpan = 4;
		Group roleGroup = WidgetUtils.createGroup(composite, "tab.manageRole.roleGroup");
		roleGroup.setLayoutData(roleListGD);
		
		GridLayout gridLayout = LayoutUtils.createGridLayout(totalColumn);
		// init role definition group
		GridData roleDefGD = LayoutUtils.createHBTFGridData(otherRoleLen);
		Group roleDefGroup = WidgetUtils.createGroup(composite, "tab.manageRole.roleDefGroup");
		roleDefGroup.setLayoutData(roleDefGD);
		roleDefGroup.setLayout(gridLayout);
		
		// init menu selection group
		GridData menuDefGD = LayoutUtils.createHBTFGridData(otherRoleLen);
		Group menuDefGroup = WidgetUtils.createGroup(composite, "tab.manageRole.menuDefGroup");
		menuDefGroup.setLayoutData(menuDefGD);
//		menuDefGroup.setLayout(gridLayout);
		menuDefGroup.setLayout(new FillLayout());
		
		// init shotcut selection group
		GridData shotCutDefGD = LayoutUtils.createHBTFGridData(otherRoleLen);
		Group shotCutDefGroup = WidgetUtils.createGroup(composite, "tab.manageRole.shotCutDefGroup");
		shotCutDefGroup.setLayoutData(shotCutDefGD);
		shotCutDefGroup.setLayout(gridLayout);

		// init main page def group
		GridData mainPageDefGD = LayoutUtils.createHBTFGridData(otherRoleLen);
		Group mainPageDefGroup = WidgetUtils.createGroup(composite, "tab.manageRole.mainPageDefGroup");
		mainPageDefGroup.setLayoutData(mainPageDefGD);
		mainPageDefGroup.setLayout(gridLayout);
		
		// impl role def group
		Label roleNameLabel = WidgetUtils.createLabel(roleDefGroup, StrUtils.getResourceString("tab.manageRole.roleName"));
		roleNameLabel.setLayoutData(lLabelGD);
		Text roleNameInput = WidgetUtils.createText(roleDefGroup);
		roleNameInput.setData("roleName");
		roleNameInput.setLayoutData(lInputGD);

		Button createNewRoleBtn = WidgetUtils.createButton(roleDefGroup, StrUtils.getResourceString("tab.manageRole.createNewRole"));
		createNewRoleBtn.setLayoutData(midEGD);
		createEndEmpty(roleDefGroup,4);
		
		Label roleDescLabel = WidgetUtils.createLabel(roleDefGroup, StrUtils.getResourceString("tab.manageRole.roleDesc"));
		roleDescLabel.setLayoutData(lLabelGD);
		Text roleDescInput = WidgetUtils.createText(roleDefGroup);
		roleDescInput.setData("roleDescription");
		roleDescInput.setLayoutData(lCInputGD);
		createEndEmpty(roleDefGroup);
		
		//menu group
//		menuDefGroup
//		GridData gridData = new GridData(GridData.FILL, GridData.BEGINNING, false, false);
//		gridData.horizontalSpan = 2;
//		gridData.heightHint=50;
		
		Tree tree = new Tree(menuDefGroup, SWT.CHECK | SWT.V_SCROLL | SWT.H_SCROLL);
//		tree.setLayoutData(gridData);
		tree.addListener(SWT.Selection, new Listener() {
	        public void handleEvent(Event event) {
	            if (event.detail == SWT.CHECK) {
	                TreeItem item = (TreeItem) event.item;
	                boolean checked = item.getChecked();
	                checkItems(item, checked);
	                checkPath(item.getParentItem(), checked, false);
	            }
	        }
	    });
//		Rectangle clientArea = menuDefGroup.getClientArea();
//	    tree.setBounds(clientArea.x, clientArea.y, 100, 100);
		TreeItem itemI = new TreeItem(tree, SWT.NONE);
		itemI.setExpanded(true);
		int i=1;
        itemI.setText("Item " + i);
        for (int j = 0; j < 4; j++) {
            TreeItem itemJ = new TreeItem(itemI, SWT.NONE);
            itemJ.setText("Item " + i + " " + j);
            for (int k = 0; k < 4; k++) {
                TreeItem itemK = new TreeItem(itemJ, SWT.NONE);
                itemK.setText("Item " + i + " " + j + " " + k);
            }
        }
		
		return composite;
	}
	
	public void loadRoleModelList() {
		
	}
	
	private void checkPath(TreeItem item, boolean checked, boolean grayed) {
	    if (item == null) return;
	    if (grayed) {
	        checked = true;
	    } else {
	        int index = 0;
	        TreeItem[] items = item.getItems();
	        while (index < items.length) {
	            TreeItem child = items[index];
	            if (child.getGrayed() || checked != child.getChecked()) {
	                checked = grayed = true;
	                break;
	            }
	            index++;
	        }
	    }
	    item.setChecked(checked);
	    item.setGrayed(grayed);
	    checkPath(item.getParentItem(), checked, grayed);
	}

	private void checkItems(TreeItem item, boolean checked) {
	    item.setGrayed(false);
	    item.setChecked(checked);
	    TreeItem[] items = item.getItems();
	    for (int i = 0; i < items.length; i++) {
	        checkItems(items[i], checked);
	    }
	}
	
	public void refresh() {
		
	}

	public String viewName() {
		return ViewList.manageRole;
	}

	public Object getModel() {
		return null;
	}

	public void setModel(Object obj) {
		
	}

}
