/**
 * 
 */
package com.coral.cstore.view.biz;

import java.util.ArrayList;
import java.util.List;

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
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import com.coral.cstore.IView;
import com.coral.cstore.Style;
import com.coral.cstore.utils.CodeTableUtils;
import com.coral.cstore.utils.DataBindingUtils;
import com.coral.cstore.utils.LayoutUtils;
import com.coral.cstore.utils.MessageCenter;
import com.coral.cstore.utils.StrUtils;
import com.coral.cstore.utils.ValidateUtil;
import com.coral.cstore.utils.WidgetUtils;
import com.coral.cstore.view.TwoColumnViewLayout;
import com.coral.cstore.view.ViewList;
import com.coral.cstore.view.biz.dialog.CreateCustomerDialog;
import com.coral.cstore.view.biz.dialog.CreateProductDialog;
import com.coral.cstore.view.biz.table.ProductTable;
import com.coral.fundation.Log;
import com.coral.store.model.Customer;
import com.coral.store.model.Product;
import com.coral.store.model.Supplier;
import com.coral.store.service.CustomerService;
import com.coral.store.service.SupplierService;

/**
 * @author Coral
 *
 */
public class CreateSupplierTabView extends TwoColumnViewLayout implements IView {
	SupplierService supplierService = new SupplierService();
	CTabItem item;
	Shell shell;
	Supplier value;
	Table table;
	Button createProductBtn;      
	Button updateProductBtn;      
	Button deleteProductBtn;     
	Button addSupplierBtn;
	Composite composite;
	
	public CreateSupplierTabView(Shell shell) {
		this.shell = shell;
	}
	
//	public static final String[] columnHeads = {"productId",StrUtils.getResourceString("tab.product.productCode"),
//		StrUtils.getResourceString("tab.product.productName"),
//		StrUtils.getResourceString("tab.product.brand"),
//		StrUtils.getResourceString("tab.product.unit"),
//		StrUtils.getResourceString("tab.product.spec"),
//		StrUtils.getResourceString("tab.product.color"),
//		StrUtils.getResourceString("tab.product.buyPrice"),
//		StrUtils.getResourceString("tab.product.mark")};
//	
//	public static String[] columnVariable = new String[]{"productId","productCode",
//		"productName",
//		"brand",
//		"unit",
//		"spec",
//		"color",
//		"buyPrice",
//		"mark"};
	
	
	public CTabItem asTabView(CTabFolder tabFolder) {
		item = WidgetUtils.createClosableCTabItem(tabFolder, StrUtils.getResourceString("tab.supplier.label"));
		item.setData(ViewList.viewName, viewName());
		item.setControl(getCompositePage(tabFolder,null));
		bind();
		return item;
	}
	
	public Composite getCompositePage(Composite parent, String pageId) {
//		int totalColumn =12,labelSize = 1,inputSize = 3,midEmpty = 1,endEmpty = 3;
		GridLayout gridLayout = new GridLayout(totalColumn,true);
		Style.gridLayoutUtils(gridLayout);
		
		composite = new Composite(parent,SWT.NONE);
		composite.setLayout(gridLayout);
		composite.setBackground(Style.white);

		GridData labelGD = LayoutUtils.createHBTFGridData(totalColumn);
		Label label = WidgetUtils.createTitleLabel(composite, StrUtils.getResourceString("tab.supplier.label"));
		label.setLayoutData(labelGD);
		
		GridData descData = LayoutUtils.createHBTFGridData(totalColumn);
		Label descLabel = WidgetUtils.createDescriptionLabel(composite, StrUtils.getResourceString("tab.supplier.description"));
		descLabel.setLayoutData(descData);

		// customerName controller.
		Label customerNameLabel = WidgetUtils.createLabel(composite, StrUtils.getResourceString("tab.supplier.supplierName"));
		customerNameLabel.setLayoutData(lLabelGD);
		Text customerNameInput = WidgetUtils.createText(composite);
		customerNameInput.setData("supplierName");
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
		
		//button 
		// controller of table.
		GridData btnGD = LayoutUtils.createBETFGridData(6);
		Composite btnComposite = LayoutUtils.createRowComposite(composite);
		btnComposite.setLayoutData(btnGD);
		createProductBtn = WidgetUtils.createButton(btnComposite, StrUtils.getResourceString("tab.product.createBtn"));
		updateProductBtn = WidgetUtils.createButton(btnComposite, StrUtils.getResourceString("tab.product.updateBtn"));
		deleteProductBtn = WidgetUtils.createButton(btnComposite, StrUtils.getResourceString("tab.product.deleteBtn"));

		GridData emptyGD = LayoutUtils.createEETFGridData(6);
		Label el = WidgetUtils.createEmptyLabel(composite);
		el.setLayoutData(emptyGD);
		
		// create customer table.
		GridData gridDate = new GridData(GridData.FILL, GridData.FILL, true, true);
		gridDate.horizontalSpan=9;
		gridDate.minimumHeight=110;
//		table = new Table(composite, SWT.SINGLE | SWT.BORDER | SWT.FULL_SELECTION);
//		table.setLayoutData(gridDate);
//		table.setHeaderVisible(true);
//		table.setLinesVisible(true);
//		
//		TableColumn idcolumn = new TableColumn(table, SWT.HIDE_SELECTION);
//		idcolumn.setText(columnHeads[0]);
//		idcolumn.setData(columnVariable[0]);
//		for(int i = 1; i < columnHeads.length; i++) {
//			TableColumn column = new TableColumn(table, SWT.NONE);
//			column.setText(columnHeads[i]);
//			column.setData(columnVariable[i]);
//			column.setWidth(80);
//		}
		ProductTable productTable = new ProductTable(composite);
		table = productTable.getTable();
		table.setLayoutData(gridDate);
		createEndEmpty(composite);
		
		addSupplierBtn = new Button(composite, SWT.PUSH);
		addSupplierBtn.setText(StrUtils.getResourceString("tab.supplier.label"));
		addSupplierBtn.setLayoutData(btn);		
		// set force to user name text
		return composite;
	}

	/**
	 * Binding data.
	 */
	public void bind() {
		createProductBtn.addMouseListener(new MouseAdapter() {
			public void mouseUp(MouseEvent e) {
				initSupplier();
				CreateProductDialog prdtDialog = new CreateProductDialog(shell);
				Product product = prdtDialog.open();
				if (product != null) {
					TableColumn[] headColumns = table.getColumns();
					String[] datas = DataBindingUtils.entityBindingColumn(headColumns,product);
					TableItem item = new TableItem(table, SWT.NONE);
					item.setText(datas);
				}
			}
		});
		deleteProductBtn.addMouseListener(new MouseAdapter() {
			public void mouseDown(MouseEvent e) {
				int index = table.getSelectionIndex();
				TableItem selectedItem = getSelectedItem();
				int rc = MessageCenter.confirmMessage(shell, StrUtils.getResourceString("message.table.deleteRowConfirm")).open();
				if(rc == SWT.YES) {
					// Delete customer Info
					selectedItem.dispose();
					deleteProduct(index);
				}
			}
		});
		updateProductBtn.addMouseListener(new MouseAdapter() {
			public void mouseDown(MouseEvent e) {
				TableItem selectedItem = getSelectedItem();
				int index = table.getSelectionIndex();
				TableColumn[] headColumns = table.getColumns();
				Product product = new Product();
				product = (Product) DataBindingUtils.columnBindingEntity(headColumns, selectedItem, product);
				CreateProductDialog prdtDialog = new CreateProductDialog(shell);
				prdtDialog.setValue(product);
				product = prdtDialog.open();
				String[] datas = DataBindingUtils.entityBindingColumn(headColumns,product);
				selectedItem.setText(datas);
				updateProduct(product, index);
			}
		});
		addSupplierBtn.addMouseListener(new MouseAdapter() {
			public void mouseDown(MouseEvent e) {
				Control[] children = composite.getChildren();
				initSupplier();
				value = (Supplier)DataBindingUtils.dataBinding(children, value, value.getClass());
				String checkRs = ValidateUtil.validateSupplier(value);
				if(!checkRs.equals(StrUtils.empty)) {
					return;
				}
				supplierService.createSupplier(value);
				// reset Supplier page.
				value = new Supplier();
				refresh();
				MessageCenter.alertMessage(shell, "Create supplier success.").open();
			}
		});
	}
	
	public void initSupplier() {
		if(value == null) {
			value = new Supplier();
		}
	}
	
	public void addProduct(Product product) {
		initSupplier();
		if(value.getProducts() == null) {
			List<Product> productList = new ArrayList<Product>();
			productList.add(product);
			value.setProducts(productList);
		}
	}
	
	public void deleteProduct(int index) {
		value.getProducts().remove(index);
	}
	
	public void updateProduct(Product product, int index) {
		value.getProducts().set(index, product);
	}
	
	public TableItem getSelectedItem() {
		TableItem[] selectedItem = table.getSelection();
		if (selectedItem.length == 0) {
			MessageCenter.alertMessage(shell, StrUtils.getResourceString("message.table.noselectRow")).open();
			return null;
		}
		return selectedItem[0];
	}

	public void refresh() {
		table.clearAll();
		if(value != null) {
			DataBindingUtils.bindingToComposite(value,composite);
			if(value.getProducts() != null) {
				for(Product data : value.getProducts()) {
					TableColumn[] headColumns = table.getColumns();
					String[] datas = DataBindingUtils.entityBindingColumn(headColumns,data);
					TableItem item = new TableItem(table, SWT.NONE);
					item.setText(datas);
				}
			}
		}
	}

	public String viewName() {
		return ViewList.createSupplier;
	}

	public Object getModel() {
		return value;
	}

	public void setModel(Object obj) {
		this.value = (Supplier)obj;
	}

}
