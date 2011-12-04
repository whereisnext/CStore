/**
 * 
 */
package com.coral.cstore.view.biz.dialog;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import com.coral.cstore.Style;
import com.coral.cstore.utils.DataBindingUtils;
import com.coral.cstore.utils.LayoutUtils;
import com.coral.cstore.utils.MessageCenter;
import com.coral.cstore.utils.StrUtils;
import com.coral.cstore.utils.ValidateUtil;
import com.coral.cstore.utils.WidgetUtils;
import com.coral.cstore.view.TwoColumnDialogLayout;
import com.coral.cstore.view.TwoColumnViewLayout;
import com.coral.cstore.view.biz.table.ProductTable;
import com.coral.fundation.utils.MathUtils;
import com.coral.store.model.Customer;
import com.coral.store.model.Product;
import com.coral.store.service.ProductService;

/**
 * @author coral.ma
 *
 */
public class SaleOrderProductDialog extends TwoColumnDialogLayout {
//	Shell parentShell;
//	Shell shell;
	String[] values;
	String[] labels;
	Text searchText;
	Button searchBtn;
	Button showAllBtn;
	
	// read only controller.
	Text productNameInput;
	Text specInput;
	Text colorInput;
	Text singleInput;
	
	Text numberInput;
	Text salePriceInput;
	
	Table table;
	ProductService productService = new ProductService();
	
	public SaleOrderProductDialog(Shell parent) {
		this.parentShell = parent;
		shell = new Shell (parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		shell.setText(StrUtils.getResourceString("tab.product.createBtn"));
		shell.setBackground(Style.white);
		shell.setLayout(new FillLayout());		
	}
	
	public void initWidget() {
		GridLayout gridLayout = new GridLayout(totalColumn,true);
		Style.gridLayoutUtils(gridLayout);
		
		Composite composite = new Composite(shell,SWT.NONE);
		composite.setLayout(gridLayout);
		composite.setBackground(Style.white);

		GridData labelGD = LayoutUtils.createHBTFGridData(totalColumn);
		Label label = WidgetUtils.createTitleLabel(composite, StrUtils.getResourceString("tab.orderProductSheet.label"));
		label.setLayoutData(labelGD);

		// supplierName controller.
		GridData searchInputGD = LayoutUtils.createBBTFGridData(12);
		Composite searchComposite = LayoutUtils.createRowComposite(composite);
		searchComposite.setLayoutData(searchInputGD);
		RowData textData = new RowData();
		textData.width=200;
		searchText = WidgetUtils.createText(searchComposite);
		searchText.setLayoutData(textData);
		searchBtn = WidgetUtils.createButton(searchComposite, StrUtils.getResourceString("tab.mangSupplier.searchBen"));
		showAllBtn = WidgetUtils.createButton(searchComposite, StrUtils.getResourceString("tab.mangSupplier.showAllBtn"));

		// productName controller.
		GridData gridDate = new GridData(GridData.FILL, GridData.BEGINNING, true, true);
		gridDate.horizontalSpan=11;
		gridDate.minimumHeight=110;
		ProductTable productTable = new ProductTable(composite);
		table = productTable.getTable();
		table.setLayoutData(gridDate);
		createEndEmpty(composite);
		
		Label productNameLabel = WidgetUtils.createLabel(composite, StrUtils.getResourceString("tab.orderProductSheet.productName"));
		productNameLabel.setLayoutData(lLabelGD);
		productNameInput = WidgetUtils.createText(composite);
		productNameInput.setData("productName");
		productNameInput.setLayoutData(lInputGD);
		productNameInput.setEditable(false);
		
		createMidEmpty(composite);

		// spec controller.
		Label specLabel = WidgetUtils.createLabel(composite, StrUtils.getResourceString("tab.orderProductSheet.spec"));
		specLabel.setLayoutData(lLabelGD);
		specInput = WidgetUtils.createText(composite);
		specInput.setData("spec");
		specInput.setLayoutData(lInputGD);
		specInput.setEditable(false);
		createEndEmpty(composite);

		// color controller.
		Label colorLabel = WidgetUtils.createLabel(composite, StrUtils.getResourceString("tab.orderProductSheet.color"));
		colorLabel.setLayoutData(lLabelGD);
		colorInput = WidgetUtils.createText(composite);
		colorInput.setData("color");
		colorInput.setLayoutData(lInputGD);
		colorInput.setEditable(false);
		createMidEmpty(composite);

		// single salePrice controller.
		Label singleSalePriceLabel = WidgetUtils.createLabel(composite, StrUtils.getResourceString("tab.orderProductSheet.singleSalePrice"));
		singleSalePriceLabel.setLayoutData(lLabelGD);
		singleInput = WidgetUtils.createText(composite);
		singleInput.setData("singleSalePrice");
		singleInput.setLayoutData(lInputGD);
		singleInput.setEditable(false);
		createEndEmpty(composite);
		
		// number controller.
		Label numberLabel = WidgetUtils.createLabel(composite, StrUtils.getResourceString("tab.orderProductSheet.number"));
		numberLabel.setLayoutData(lLabelGD);
		numberInput = WidgetUtils.createText(composite);
		numberInput.setData("number");
		numberInput.setLayoutData(lInputGD);
		createMidEmpty(composite);

		// salePrice controller.
		Label salePriceLabel = WidgetUtils.createLabel(composite, StrUtils.getResourceString("tab.orderProductSheet.salePrice"));
		salePriceLabel.setLayoutData(lLabelGD);
		salePriceInput = WidgetUtils.createText(composite);
		salePriceInput.setData("salePrice");
		salePriceInput.setLayoutData(lInputGD);
		createEndEmpty(composite);

		// mark controller.
		Label markLabel = WidgetUtils.createLabel(composite, StrUtils.getResourceString("tab.orderProductSheet.mark"));
		markLabel.setLayoutData(lLabelGD);
		Text markInput = WidgetUtils.createText(composite);
		markInput.setData("mark");
		markInput.setLayoutData(lCInputGD);
		createEndEmpty(composite);

		Button button = new Button(composite, SWT.PUSH);
		button.setText(StrUtils.getResourceString("tab.orderProductSheet.label"));
		button.setLayoutData(btn);		
	}
	
	public void bind() {
		table.addMouseListener(new MouseAdapter() {
			public void mouseUp(MouseEvent e) {
				TableItem selectedItem = getSelectedItem();
				fillInController(selectedItem);
			}
		});
		searchText.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				cleanController();
				if(e.character == SWT.CR) {
					abstractQuery();
				}
			}
		});
		searchBtn.addMouseListener(new MouseAdapter() {
			public void mouseUp(MouseEvent e) {
				cleanController();
				abstractQuery();
			}
		});
		showAllBtn.addMouseListener(new MouseAdapter() {
			public void mouseUp(MouseEvent e) {
				cleanController();
				tableFillData(productService.loadAllProduct());
			}
		});
		numberInput.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				String singlePrice = singleInput.getText();
				if(!StrUtils.empty.equals(ValidateUtil.notNullCheck(singlePrice))) {
					return;
				}
				String number = numberInput.getText();
				if(!MathUtils.isNumber(number)) {
					salePriceInput.setText("");
					return;
				} else {
					salePriceInput.setText(MathUtils.multiply(singlePrice,number));
				}
			}
		});
	}
	
	public void abstractQuery() {
		String condition = searchText.getText();
		String checkPcRs = ValidateUtil.notNullCheck(condition);
		if(!checkPcRs.equals(StrUtils.empty)) {
			MessageCenter.alertMessage(shell,checkPcRs);
			return;
		}
		List<Product> productList = productService.abstractQuery(condition);
		tableFillData(productList);
	}
	
	public void tableFillData(List<Product> productList) {
		table.removeAll();
		for(Product data : productList) {
			TableColumn[] headColumns = table.getColumns();
			String[] datas = DataBindingUtils.entityBindingColumn(headColumns,data);
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
	
	public void fillInController(TableItem selectedItem) {
		productNameInput.setText(selectedItem.getText(2));
		specInput.setText(selectedItem.getText(5));
		colorInput.setText(selectedItem.getText(6));
		singleInput.setText(selectedItem.getText(8));
	}
	
	public void cleanController() {
		productNameInput.setText("");
		specInput.setText("");
		colorInput.setText("");
		singleInput.setText("");
	}
	
	public String[] open() {
		initWidget();
		bind();
		shell.setSize (790, 400);
//		shell.open();
//		// Move the dialog to the center of the top level shell.
//        Rectangle shellBounds = parentShell.getBounds();
//        Point dialogSize = shell.getSize();
//
//        shell.setLocation(
//          shellBounds.x + (shellBounds.width - dialogSize.x) / 2,
//          shellBounds.y + (shellBounds.height - dialogSize.y) / 2);
//
//		Display display = shell.getDisplay();
//		while(!shell.isDisposed()){
//			if(!display.readAndDispatch())
//				display.sleep();
//		}
		openDialog();
		
		return getValues();
	}
	
	public String[] getValues() {
		return values;
	}

}
