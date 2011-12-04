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
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;

import com.coral.cstore.IView;
import com.coral.cstore.Style;
import com.coral.cstore.utils.LayoutUtils;
import com.coral.cstore.utils.StrUtils;
import com.coral.cstore.utils.WidgetUtils;
import com.coral.cstore.view.TwoColumnViewLayout;
import com.coral.cstore.view.ViewList;
import com.coral.cstore.view.biz.dialog.SaleOrderProductDialog;

/**
 * @author Coral
 *
 */
public class CreatePurchaseOrderTabView extends TwoColumnViewLayout implements IView {
	CTabItem item;
	Shell shell;
	
	Button createBtn;      
	Button updateBtn;      
	Button deleteBtn;  
	Label totalPrice;
	
	private static final String[] columnNames = {StrUtils.getResourceString("tab.orderProductSheet.supplierName"),
		StrUtils.getResourceString("tab.orderProductSheet.productName"),
		StrUtils.getResourceString("tab.orderProductSheet.number"),
		StrUtils.getResourceString("tab.orderProductSheet.spec"),
		StrUtils.getResourceString("tab.orderProductSheet.color"),
		StrUtils.getResourceString("tab.orderProductSheet.salePrice"),
		StrUtils.getResourceString("tab.orderProductSheet.mark"),
};
	
	public CreatePurchaseOrderTabView(){}
	
	public CreatePurchaseOrderTabView(Shell shell){
		this.shell = shell;
	}
	
	public CTabItem asTabView(CTabFolder tabFolder) {
		item = WidgetUtils.createClosableCTabItem(tabFolder, StrUtils.getResourceString("tab.orderSheet.label"));
		item.setData(ViewList.viewName, viewName());
		item.setControl(getCompositePage(tabFolder,null));
		bind();
		return item;
	}
	
	public Composite getCompositePage(Composite parent, String pageId) {
		GridLayout gridLayout = new GridLayout(totalColumn,true);
		Style.gridLayoutUtils(gridLayout);
		
		Composite composite = new Composite(parent,SWT.NONE);
		composite.setLayout(gridLayout);
		composite.setBackground(Style.white);
		
		GridData labelGD = LayoutUtils.createHBTFGridData(totalColumn);
		Label label = WidgetUtils.createTitleLabel(composite, StrUtils.getResourceString("tab.orderSheet.label"));
		label.setLayoutData(labelGD);
		
		GridData descData = LayoutUtils.createHBTFGridData(totalColumn);
		Label descLabel = WidgetUtils.createDescriptionLabel(composite, StrUtils.getResourceString("tab.orderSheet.description"));
		descLabel.setLayoutData(descData);
		
		// orderNo controller.
		Label orderNoLabel = WidgetUtils.createLabel(composite, StrUtils.getResourceString("tab.orderSheet.orderNo"));
		orderNoLabel.setLayoutData(lLabelGD);
		Text orderNoInput = WidgetUtils.createText(composite);
		orderNoInput.setData("orderNo");
		orderNoInput.setLayoutData(lInputGD);
		createMidEmpty(composite);

		// customerName controller.
		Label customerNameLabel = WidgetUtils.createLabel(composite, StrUtils.getResourceString("tab.orderSheet.customerName"));
		customerNameLabel.setLayoutData(lLabelGD);
		Text customerNameInput = WidgetUtils.createText(composite);
		customerNameInput.setData("customerName");
		customerNameInput.setLayoutData(lInputGD);
		createEndEmpty(composite);

		// receivePerson controller.
		Label receivePersonLabel = WidgetUtils.createLabel(composite, StrUtils.getResourceString("tab.orderSheet.receivePerson"));
		receivePersonLabel.setLayoutData(lLabelGD);
		Text receivePersonInput = WidgetUtils.createText(composite);
		receivePersonInput.setData("receivePerson");
		receivePersonInput.setLayoutData(lInputGD);
		createMidEmpty(composite);

		// mobile controller.
		Label mobileLabel = WidgetUtils.createLabel(composite, StrUtils.getResourceString("tab.orderSheet.mobile"));
		mobileLabel.setLayoutData(lLabelGD);
		Text mobileInput = WidgetUtils.createText(composite);
		mobileInput.setData("mobile");
		mobileInput.setLayoutData(lInputGD);
		createEndEmpty(composite);

		// deliverAddress controller.
		Label deliverAddressLabel = WidgetUtils.createLabel(composite, StrUtils.getResourceString("tab.orderSheet.deliverAddress"));
		deliverAddressLabel.setLayoutData(lLabelGD);
		Text deliverAddressInput = WidgetUtils.createText(composite);
		deliverAddressInput.setData("deliverAddress");
		deliverAddressInput.setLayoutData(lCInputGD);
		createEndEmpty(composite);
		
		// deliverPostcode controller.
		Label deliverPostcodeLabel = WidgetUtils.createLabel(composite, StrUtils.getResourceString("tab.orderSheet.deliverPostcode"));
		deliverPostcodeLabel.setLayoutData(lLabelGD);
		Text deliverPostcodeInput = WidgetUtils.createText(composite);
		deliverPostcodeInput.setData("deliverPostcode");
		deliverPostcodeInput.setLayoutData(lInputGD);
		createMidEmpty(composite);

		// deliverDate controller.
		Label deliverDateLabel = WidgetUtils.createLabel(composite, StrUtils.getResourceString("tab.orderSheet.deliverDate"));
		deliverDateLabel.setLayoutData(lLabelGD);
		DateTime deliverDateInput = WidgetUtils.createDateTime(composite);
		deliverDateInput.setData("deliverDate");
		deliverDateInput.setLayoutData(lInputGD);
		createEndEmpty(composite);

		// mark controller.
		Label markLabel = WidgetUtils.createLabel(composite, StrUtils.getResourceString("tab.orderSheet.mark"));
		markLabel.setLayoutData(lLabelGD);
		Text markInput = WidgetUtils.createText(composite);
		markInput.setData("mark");
		markInput.setLayoutData(lCInputGD);
		createEndEmpty(composite);
		
		// controller of table.
		GridData btnGD = LayoutUtils.createBETFGridData(6);
		Composite btnComposite = LayoutUtils.createRowComposite(composite);
		btnComposite.setLayoutData(btnGD);
		createBtn = WidgetUtils.createButton(btnComposite, StrUtils.getResourceString("tab.orderProductSheet.createBtn"));
		updateBtn = WidgetUtils.createButton(btnComposite, StrUtils.getResourceString("tab.orderProductSheet.updateBtn"));
		deleteBtn = WidgetUtils.createButton(btnComposite, StrUtils.getResourceString("tab.orderProductSheet.deleteBtn"));

		GridData emptyGD = LayoutUtils.createEETFGridData(6);
		Label el = WidgetUtils.createEmptyLabel(composite);
		el.setLayoutData(emptyGD);
		
		// create customer table.
		GridData gridDate = LayoutUtils.createFFTTGridData(9);
		gridDate.minimumHeight=110;
		Table table = new Table(composite, SWT.SINGLE | SWT.BORDER | SWT.FULL_SELECTION);
		table.setLayoutData(gridDate);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		for(int i = 0; i < columnNames.length; i++) {
			TableColumn column = new TableColumn(table, SWT.NONE);
			column.setText(columnNames[i]);
			column.setWidth(80);
		}
		createEndEmpty(composite);
		
		//total price label
		Label totalPriceLabel = WidgetUtils.createLabel(composite, StrUtils.getResourceString("tab.orderSheet.totalPrice"));
		totalPrice = WidgetUtils.createNormalLabel(composite,"0");
		Label currencyLabel = WidgetUtils.createNormalLabel(composite, StrUtils.getResourceString("currency.yuan"));
		GridData totalPriceLabelGD = LayoutUtils.createEETFGridData(7);
		GridData totalPriceGD = LayoutUtils.createEETFGridData(1);
		GridData currencyGD = LayoutUtils.createBETFGridData(1);
		totalPriceLabel.setLayoutData(totalPriceLabelGD);
		totalPrice.setLayoutData(totalPriceGD);
		currencyLabel.setLayoutData(currencyGD);
		createEndEmpty(composite);
		
		Button button = new Button(composite, SWT.PUSH);
		button.setText(StrUtils.getResourceString("tab.supplier.label"));
		button.setLayoutData(btn);		

		return composite;
	}
	
	public void bind() {
		createBtn.addMouseListener(new MouseAdapter() {
			public void mouseUp(MouseEvent e) {
				SaleOrderProductDialog prdtDialog = new SaleOrderProductDialog(shell);
				prdtDialog.open();

			}
		});
	}

	public void refresh() {
		// TODO Auto-generated method stub
		
	}

	public String viewName() {
		return ViewList.createOrderSheet;
	}

	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setModel(Object obj) {
		// TODO Auto-generated method stub
		
	}

}
