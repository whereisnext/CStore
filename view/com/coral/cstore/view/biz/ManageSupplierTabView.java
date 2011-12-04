/**
 * 
 */
package com.coral.cstore.view.biz;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import com.coral.cstore.IView;
import com.coral.cstore.MvpController;
import com.coral.cstore.Style;
import com.coral.cstore.utils.DataBindingUtils;
import com.coral.cstore.utils.LayoutUtils;
import com.coral.cstore.utils.MessageCenter;
import com.coral.cstore.utils.StrUtils;
import com.coral.cstore.utils.WidgetUtils;
import com.coral.cstore.view.ViewList;
import com.coral.cstore.view.biz.dialog.CreateCustomerDialog;
import com.coral.cstore.view.biz.table.ProductTable;
import com.coral.fundation.utils.ExcelUtils;
import com.coral.store.model.Customer;
import com.coral.store.model.Product;
import com.coral.store.model.Supplier;
import com.coral.store.service.CustomerService;
import com.coral.store.service.SupplierService;

/**
 * @author coral.ma
 *
 */
public class ManageSupplierTabView implements IView {
	
	Shell shell;
	CTabItem item;
	Table table;
	Table productTable;
	MvpController controller;
	List<Supplier> supplierList;
	
	Button createBtn;
	Button updateBtn;
	Button deleteBtn;
	Button searchBtn;
	Button showAllBtn;
	Button importBtn;
	Button exportBtn;
//	ICustomerDao customerDao = StoreDaoFactory.getCustomerDao();
	SupplierService supplierService = new SupplierService();
	ExcelUtils excelUtils = new ExcelUtils();
	
//	tab.customer.customerName
	private static final String[] columnHead = {"supplierId",StrUtils.getResourceString("tab.supplier.supplierName"),
		StrUtils.getResourceString("tab.customer.contectPerson"),
		StrUtils.getResourceString("tab.customer.mobile"),
		StrUtils.getResourceString("tab.customer.phone"),
		StrUtils.getResourceString("tab.customer.fax"),
		StrUtils.getResourceString("tab.customer.address"),
		StrUtils.getResourceString("tab.customer.postcode"),
		StrUtils.getResourceString("tab.customer.url"),
		StrUtils.getResourceString("tab.customer.email"),
		StrUtils.getResourceString("tab.customer.accountBank"),
		StrUtils.getResourceString("tab.customer.accountNumber"),
		StrUtils.getResourceString("tab.customer.accountPerson"),
		StrUtils.getResourceString("tab.customer.mark")};
	
	private static String[] columnVariable = new String[]{"supplierId","supplierName",
		"contectPerson",
		"mobile",
		"phone",
		"fax",
		"address",
		"postcode",
		"url",
		"email",
		"accountBank",
		"accountNumber",
		"accountPerson",
		"mark"};
	
	
//	public static String[] productColumnHeads = CreateSupplierTabView.columnHeads;
//	public static String[] productColumnVariable = CreateSupplierTabView.columnVariable;
	
	public ManageSupplierTabView(Shell shell, MvpController controller) {
		this.controller = controller;
		this.shell = shell;
	}
	
	public CTabItem asTabView(CTabFolder tabFolder) {
		item = WidgetUtils.createClosableCTabItem(tabFolder, StrUtils.getResourceString("tab.mangSupplier"));
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
		Label label = WidgetUtils.createTitleLabel(composite, StrUtils.getResourceString("tab.mangSupplier"));
		label.setLayoutData(labelGD);
		
		GridData descData = new GridData(GridData.BEGINNING, GridData.BEGINNING, true, false);
		descData.horizontalSpan=12;
		Label descLabel = WidgetUtils.createDescriptionLabel(composite, StrUtils.getResourceString("tab.mangSupplier.description"));
		descLabel.setLayoutData(descData);

		// controller of table.
		GridData btnGD = LayoutUtils.createBETFGridData(4);
		Composite btnComposite = LayoutUtils.createRowComposite(composite);
		btnComposite.setLayoutData(btnGD);
		createBtn = WidgetUtils.createButton(btnComposite, StrUtils.getResourceString("tab.mangSupplier.createBen"));
		updateBtn = WidgetUtils.createButton(btnComposite, StrUtils.getResourceString("tab.mangSupplier.updateBen"));
		deleteBtn = WidgetUtils.createButton(btnComposite, StrUtils.getResourceString("tab.mangSupplier.deleteBen"));

		GridData emptyGD = LayoutUtils.createEETFGridData(2);
		Label el = WidgetUtils.createEmptyLabel(composite);
		el.setLayoutData(emptyGD);
		
		GridData searchInputGD = LayoutUtils.createEETFGridData(6);
		Composite searchComposite = LayoutUtils.createRowComposite(composite);
		searchComposite.setLayoutData(searchInputGD);
		RowData textData = new RowData();
		textData.width=200;
		Text searchText = WidgetUtils.createText(searchComposite);
		searchText.setLayoutData(textData);
		searchBtn = WidgetUtils.createButton(searchComposite, StrUtils.getResourceString("tab.mangSupplier.searchBen"));
		showAllBtn = WidgetUtils.createButton(searchComposite, StrUtils.getResourceString("tab.mangSupplier.showAllBtn"));

		// create customer table.
		GridData gridDate = new GridData(GridData.FILL, GridData.FILL, true, true);
		gridDate.horizontalSpan=12;
		gridDate.heightHint=100;
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
		
//		productTable = new Table(composite, SWT.SINGLE | SWT.BORDER | SWT.FULL_SELECTION);
//		productTable.setLayoutData(gridDate);
//		productTable.setHeaderVisible(true);
//		productTable.setLinesVisible(true);
//		TableColumn prdtIdcolumn = new TableColumn(productTable, SWT.HIDE_SELECTION);
//		prdtIdcolumn.setText(productColumnHeads[0]);
//		prdtIdcolumn.setData(productColumnVariable[0]);
//		for(int i = 1; i < productColumnHeads.length; i++) {
//			TableColumn column = new TableColumn(productTable, SWT.NONE);
//			column.setText(productColumnHeads[i]);
//			column.setData(productColumnVariable[i]);
//			column.setWidth(80);
//		}
		ProductTable table = new ProductTable(composite);
		productTable = table.getTable();
		productTable.setLayoutData(gridDate);
		
		// export and import data button
		GridData dataPortGD = LayoutUtils.createEETFGridData(12);
		Composite dataPortComposite = LayoutUtils.createRowComposite(composite);
		dataPortComposite.setLayoutData(dataPortGD);
		importBtn = WidgetUtils.createButton(dataPortComposite, StrUtils.getResourceString("tab.mangSupplier.importBtn"));
		exportBtn = WidgetUtils.createButton(dataPortComposite, StrUtils.getResourceString("tab.mangSupplier.exportBtn"));
		return composite;
	}
	
	public void bind() {
		table.addMouseListener(new MouseAdapter() {
			public void mouseUp(MouseEvent e) {
				TableItem selectedItem = getSelectedItem();
				String selectedSupplierId = selectedItem.getText(0);
				if(supplierList != null) {
					for(Supplier supplier : supplierList) {
						if(supplier.getSupplierId().equals(selectedSupplierId)) {
							productTable.removeAll();
							List<Product> products = supplier.getProducts();
							for(Product product : products) {
								TableColumn[] headColumns = productTable.getColumns();
								String[] datas = DataBindingUtils.entityBindingColumn(headColumns,product);
								TableItem item = new TableItem(productTable, SWT.NONE);
								item.setText(datas);
							}
						}
					}
				}
			}
		});
		createBtn.addMouseListener(new MouseAdapter() {
			public void mouseDown(MouseEvent e) {
				controller.changeTabView(ViewList.createSupplier);
			}
		});
		deleteBtn.addMouseListener(new MouseAdapter() {
			public void mouseDown(MouseEvent e) {
				TableItem selectedItem = getSelectedItem();
//				TableItem[] selectedItem = table.getSelection();
//				if (selectedItem.length == 0) {
//					MessageCenter.alertMessage(shell, StrUtils.getResourceString("message.table.noselectRow")).open();
//					return;
//				}
				int rc = MessageCenter.confirmMessage(shell, StrUtils.getResourceString("message.table.deleteRowConfirm")).open();
				if(rc == SWT.YES) {
					// Delete customer Info
					//TODO ADD delete service.
//					customerService.deleteCustomer(selectedItem[0].getText(0));
					selectedItem.dispose();
					productTable.removeAll();
				}
			}
		});
		updateBtn.addMouseListener(new MouseAdapter() {
			public void mouseDown(MouseEvent e) {
				TableItem selectedItem = getSelectedItem();
				Supplier supplier = supplierService.loadSupplier(selectedItem.getText(0));
				controller.changeTabView(ViewList.createSupplier, supplier);
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
	}

	public void refresh() {
		table.clearAll();
		supplierList = supplierService.loadAll();
		for(Supplier supplier : supplierList) {
			TableColumn[] headColumns = table.getColumns();
			String[] datas = DataBindingUtils.entityBindingColumn(headColumns,supplier);
			TableItem item = new TableItem(table, SWT.NONE);
			item.setText(datas);
		}
	}
	
	public TableItem getSelectedItem() {
		TableItem[] selectedItem = table.getSelection();
		if (selectedItem.length == 0) {
			MessageCenter.alertMessage(shell, StrUtils.getResourceString("message.table.noselectRow")).open();
			return null;
		}
		return selectedItem[0];
	}

	public String viewName() {
		return ViewList.manageSupplier;
	}

	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setModel(Object obj) {
		// TODO Auto-generated method stub
		
	}

}
