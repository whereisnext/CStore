/**
 * 
 */
package com.coral.cstore;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

import com.coral.cstore.groups.RemindGroup;
import com.coral.cstore.groups.SearchGroup;
import com.coral.cstore.groups.ShotcutGroup;
import com.coral.cstore.utils.ImageUtils;
import com.coral.cstore.utils.StrUtils;
import com.coral.cstore.view.UserTaskListTabView;
import com.coral.fundation.model.ModelMenu;
import com.coral.fundation.user.UserModel;

/**
 * @author coral.ma
 *
 */
public class CStore {
	
	private UserModel userModel;
//	private IconCache iconCache = new IconCache();
	private Display display; 
	private Shell shell;
	private CTabFolder tabFolder;
	private MvpController controller = new MvpController();
	
	

	/**
	 * Main page.
	 * @param args
	 */
	public static void main (String [] args) {
		CStore application = new CStore();
		Display display = new Display ();
		application.runCStore(display);
	}

	/**
	 * Run CStore.
	 */
	public void runCStore(Display display) {
		this.display = display;
		Shell shell = open();
		while (! shell.isDisposed()) {
			if (! display.readAndDispatch()) display.sleep();
		}
		display.dispose();
	}
	
	/**
	 * Opens the main program.
	 */
	public Shell open() {		
		// Create the window
//		iconCache.initResources(display);
		shell = new Shell();
		controller.setShell(shell);
//		shell.setMaximized(true);
		createShellContents();
		shell.setSize(1024,748);
		shell.open();
		return shell;
	}
	
	public void createShellContents() {
		shell.setText(StrUtils.getResourceString("Title"));
		shell.setImage(ImageUtils.getImage("shellIcon"));
		Menu bar = new Menu(shell, SWT.BAR);
		shell.setMenuBar(bar);
		shell.setBackground(Style.milkWhite);
		createMenu(bar);
		
		GridLayout layout = new GridLayout();
		// total grid number
		layout.numColumns = 8;
//		layout.makeColumnsEqualWidth = true;
		shell.setLayout(layout);
		
//		GridData data = new GridData(GridData.BEGINNING, GridData.FILL, true, false);
		// left size gird number of total grid number.
//		data.horizontalSpan = 1;
		// the minimum size of left gird.
//		data.minimumWidth =100;
//		data.widthHint =100;
	
		/*** Search Group start ***/
		SearchGroup searchGroup = new SearchGroup();
		searchGroup.initWidget(shell);
	    /*** Search Group end ***/

		/*** Main Tab page start ***/
	    GridData tableData = new GridData(GridData.FILL, GridData.FILL, true, true);
	    tableData.horizontalSpan = 7;
	    tableData.verticalSpan = 3;
//	    tableData.widthHint=800;
		createTab();
		tabFolder.setLayoutData(tableData);
		/*** Main Tab page end ***/
		
		/*** remind Group start***/
		RemindGroup remindGroup = new RemindGroup();
		remindGroup.initWidget(shell);
		/*** remind Group end***/
		
	    /*** shotcut Group start***/
		ShotcutGroup shotcutGroup = new ShotcutGroup();
		shotcutGroup.initWidget(shell);
		/*** shotcut Group end***/
		
		StatusBar statusBar = new StatusBar();
		statusBar.initWidget(shell);
	}
	
	/** 
	 * create menu. 
	 */
	private void createMenu(Menu parent) {
		List<ModelMenu> modelMenus = userModel.getMenus();
		for(ModelMenu modelMenu :modelMenus) {
			Menu menu = new Menu(parent);
			MenuItem header = new MenuItem(parent, SWT.CASCADE);
			header.setText(StrUtils.getResourceString(modelMenu.getMenuName()));
			header.setMenu(menu);
			
			if(modelMenu.getSubMenus() != null) {
				for(final ModelMenu subModelMenu : modelMenu.getSubMenus()) {
					MenuItem item = new MenuItem(menu, SWT.PUSH);
					item.setText(StrUtils.getResourceString(subModelMenu.getMenuName()));
					item.setImage(ImageUtils.getImage(subModelMenu.getIcon()));
					item.addSelectionListener(new SelectionAdapter () {
						public void widgetSelected(SelectionEvent e) {
							String view = subModelMenu.getViewName();
							if(view.equals("Close")) {
								shell.close();
							} else {
								controller.changeTabView(view);	
							}
						}
					});
				}
			}
		}

	}
	
	/**
	 * Create Tab.
	 */
	public void createTab() {
		tabFolder = new CTabFolder(shell,SWT.BORDER);
		controller.setContainer(tabFolder);
		tabFolder.setFocus();
		tabFolder.setBackground(Style.white);
		tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		tabFolder.setSimple(false);
		tabFolder.setUnselectedImageVisible(false);
		tabFolder.setUnselectedCloseVisible(false);
		tabFolder.setSelectionBackground(ImageUtils.getImage("menu"));
		// init user task list
		UserTaskListTabView listTabView = new UserTaskListTabView();
		listTabView.asTabView(tabFolder);
	}

	/**
	 * @return the userModel
	 */
	public UserModel getUserModel() {
		return userModel;
	}

	/**
	 * @param userModel the userModel to set
	 */
	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}
	
}
