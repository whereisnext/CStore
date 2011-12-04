/**
 * 
 */
package com.coral.cstore.view.biz;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.internal.win32.MSG;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import com.coral.cstore.IView;
import com.coral.cstore.Style;
import com.coral.cstore.utils.DataBindingUtils;
import com.coral.cstore.utils.LayoutUtils;
import com.coral.cstore.utils.MessageCenter;
import com.coral.cstore.utils.StrUtils;
import com.coral.cstore.utils.ValidateUtil;
import com.coral.cstore.utils.WidgetUtils;
import com.coral.cstore.view.ViewList;
import com.coral.cstore.view.biz.dialog.CreateCustomerDialog;
import com.coral.fundation.utils.ExcelUtils;
import com.coral.store.model.Customer;
import com.coral.store.service.CustomerService;

/**
 * @author coral.ma
 *
 */
public class ManageCustomerTabView implements IView {
	Shell shell;
	CTabItem item;
	Table table;
	Text searchText;
	
	Button createBtn;
	Button updateBtn;
	Button deleteBtn;
	Button searchBtn;
	Button showAllBtn;
	Button importBtn;
	Button exportBtn;
//	ICustomerDao customerDao = StoreDaoFactory.getCustomerDao();
	CustomerService customerService = new CustomerService();
	ExcelUtils excelUtils = new ExcelUtils();
	
//	tab.customer.customerName
	private static final String[] columnHead = {"customerId",StrUtils.getResourceString("tab.customer.customerName"),
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
	
	private static String[] columnVariable = new String[]{"customerId","customerName",
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
	
	public ManageCustomerTabView(Shell shell) {
		this.shell = shell;
	}
	
	public CTabItem asTabView(CTabFolder tabFolder) {
		item = WidgetUtils.createClosableCTabItem(tabFolder, StrUtils.getResourceString("tab.mangCustomer"));
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
		Label label = WidgetUtils.createTitleLabel(composite, StrUtils.getResourceString("tab.mangCustomer.label"));
		label.setLayoutData(labelGD);
		
		GridData descData = new GridData(GridData.BEGINNING, GridData.BEGINNING, true, false);
		descData.horizontalSpan=12;
		Label descLabel = WidgetUtils.createDescriptionLabel(composite, StrUtils.getResourceString("tab.mangCustomer.description"));
		descLabel.setLayoutData(descData);

		// controller of table.
		GridData btnGD = LayoutUtils.createBETFGridData(4);
		Composite btnComposite = LayoutUtils.createRowComposite(composite);
		btnComposite.setLayoutData(btnGD);
		createBtn = WidgetUtils.createButton(btnComposite, StrUtils.getResourceString("tab.mangCustomer.createBtn"));
		updateBtn = WidgetUtils.createButton(btnComposite, StrUtils.getResourceString("tab.mangCustomer.updateBtn"));
		deleteBtn = WidgetUtils.createButton(btnComposite, StrUtils.getResourceString("tab.mangCustomer.deleteBtn"));

		GridData emptyGD = LayoutUtils.createEETFGridData(2);
		Label el = WidgetUtils.createEmptyLabel(composite);
		el.setLayoutData(emptyGD);
		
		GridData searchInputGD = LayoutUtils.createEETFGridData(6);
		Composite searchComposite = LayoutUtils.createRowComposite(composite);
		searchComposite.setLayoutData(searchInputGD);
		RowData textData = new RowData();
		textData.width=200;
		searchText = WidgetUtils.createText(searchComposite);
		searchText.setLayoutData(textData);
		searchBtn = WidgetUtils.createButton(searchComposite, StrUtils.getResourceString("tab.mangCustomer.searchBtn"));
		showAllBtn = WidgetUtils.createButton(searchComposite, StrUtils.getResourceString("tab.mangCustomer.showAllBtn"));

		// create customer table.
		GridData gridDate = new GridData(GridData.FILL, GridData.FILL, true, true);
		gridDate.horizontalSpan=12;
		table = new Table(composite, SWT.SINGLE | SWT.BORDER | SWT.FULL_SELECTION);
		table.setLayoutData(gridDate);
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
		
		// export and import data button
		GridData dataPortGD = LayoutUtils.createEETFGridData(12);
		Composite dataPortComposite = LayoutUtils.createRowComposite(composite);
		dataPortComposite.setLayoutData(dataPortGD);
		importBtn = WidgetUtils.createButton(dataPortComposite, StrUtils.getResourceString("tab.mangCustomer.importBtn"));
		exportBtn = WidgetUtils.createButton(dataPortComposite, StrUtils.getResourceString("tab.mangCustomer.exportBtn"));
		return composite;
	}
	
	public void bind() {
		table.addMouseListener(new MouseAdapter() {
			public void mouseDoubleClick(MouseEvent e) {
				
			}
		});
		createBtn.addMouseListener(new MouseAdapter() {
			public void mouseDown(MouseEvent e) {
				CreateCustomerDialog dialog = new CreateCustomerDialog(shell,false);
				Customer data = dialog.open();
				// save customer info to DB
				if(data != null) {
					data = customerService.createCustomer(data);
					TableColumn[] headColumns = table.getColumns();
					String[] datas = DataBindingUtils.entityBindingColumn(headColumns,data);
					if (datas != null) {
						TableItem item = new TableItem(table, SWT.NONE);
						item.setText(datas);
					}
				}
			}
		});
		deleteBtn.addMouseListener(new MouseAdapter() {
			public void mouseDown(MouseEvent e) {
				TableItem[] selectedItem = table.getSelection();
				if (selectedItem.length == 0) {
					MessageCenter.alertMessage(shell, StrUtils.getResourceString("message.table.noselectRow")).open();
					return;
				}
				int rc = MessageCenter.confirmMessage(shell, StrUtils.getResourceString("message.table.deleteRowConfirm")).open();
				if(rc == SWT.YES) {
					// Delete customer Info
					customerService.deleteCustomer(selectedItem[0].getText(0));
					selectedItem[0].dispose();
				}
			}
		});
		updateBtn.addMouseListener(new MouseAdapter() {
			public void mouseDown(MouseEvent e) {
				TableItem[] items = table.getSelection();
				if (items.length == 0) {
					MessageCenter.alertMessage(shell, StrUtils.getResourceString("message.table.noselectRow"));
					return;
				}
				TableColumn[] headColumns = table.getColumns();
				Customer customer = customerService.loadCustomer(items[0].getText(0));
				CreateCustomerDialog dialog = new CreateCustomerDialog(shell,true);
				dialog.setValue(customer);
				customer = dialog.open();
				customerService.updateCustomer(customer);
				String[] datas = DataBindingUtils.entityBindingColumn(headColumns,customer);
				items[0].setText(datas);
			}
		});
		exportBtn.addMouseListener(new MouseAdapter() {
			public void mouseDown(MouseEvent e) {
				TableItem[] items = table.getItems();
				String[][] datas = new String[items.length][]; 
				for(int i=0;i<items.length;i++) {
					String[] data = new String[columnHead.length];
					for(int j=0;j<columnHead.length;j++) {
						data[j] = items[i].getText(j);
					}
					datas[i] = data;
				}
				excelUtils.excelGenerate(viewName(), columnHead, datas);
			}
		});
		importBtn.addMouseListener(new MouseAdapter() {
			public void mouseDown(MouseEvent e) {
				FileDialog dlg = new FileDialog(shell, SWT.OPEN);
			    String fileName = dlg.open();
			    if (fileName != null) {
			      System.out.println(fileName);
			      String[][] results = excelUtils.readExcel(viewName(), fileName);
			      table.clearAll();
			      for(int i=0;i<results.length;i++) {
				      TableItem item = new TableItem(table, SWT.NONE);
					  item.setText(results[i]);
			      }
			    }
			}
		});
		searchBtn.addMouseListener(new MouseAdapter() {
			public void mouseDown(MouseEvent e) {
				abstractQuery();
			}
		});
		searchText.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if(e.character == SWT.CR) {
					abstractQuery();
				}
			}
		});
		showAllBtn.addMouseListener(new MouseAdapter() {
			public void mouseDown(MouseEvent e) {
				searchText.setText(StrUtils.empty);
				refresh();
			}
		});
	}

	public void refresh() {
		List<Customer> customerList = customerService.loadAllCustomer();
		tableFillData(customerList);
	}
	
	public void tableFillData(List<Customer> customerList) {
		table.removeAll();
		for(Customer data : customerList) {
			TableColumn[] headColumns = table.getColumns();
			String[] datas = DataBindingUtils.entityBindingColumn(headColumns,data);
			TableItem item = new TableItem(table, SWT.NONE);
			item.setText(datas);
		}
	}
	
	public void abstractQuery() {
		String condition = searchText.getText();
		String checkPcRs = ValidateUtil.notNullCheck(condition);
		if(!checkPcRs.equals(StrUtils.empty)) {
			MessageCenter.alertMessage(shell,checkPcRs);
			return;
		}
		List<Customer> customerList = customerService.abstractQuery(condition);
		tableFillData(customerList);
	}

	public String viewName() {
		return ViewList.manageCustomer;
	}

	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setModel(Object obj) {
		// TODO Auto-generated method stub
		
	}

}
