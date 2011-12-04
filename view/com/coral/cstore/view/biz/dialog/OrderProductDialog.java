/**
 * 
 */
package com.coral.cstore.view.biz.dialog;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.coral.cstore.Style;
import com.coral.cstore.utils.LayoutUtils;
import com.coral.cstore.utils.StrUtils;
import com.coral.cstore.utils.TwoColumnDialogLayout;
import com.coral.cstore.utils.TwoColumnViewLayout;
import com.coral.cstore.utils.WidgetUtils;

/**
 * @author coral.ma
 *
 */
public class OrderProductDialog extends TwoColumnDialogLayout {
	Shell parentShell;
	Shell shell;
	String[] values;
	String[] labels;
	
	public OrderProductDialog(Shell parent) {
		this.parentShell = parent;
		shell = new Shell (parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		shell.setText(StrUtils.getResourceString("tab.product.createBtn"));
		shell.setBackground(Style.white);
		shell.setLayout(new FillLayout());		
	}
	
	public void initWidget() {
//		isDialog();
		GridLayout gridLayout = new GridLayout(totalColumn,true);
		Style.gridLayoutUtils(gridLayout);
		
		Composite composite = new Composite(shell,SWT.NONE);
		composite.setLayout(gridLayout);
		composite.setBackground(Style.white);

		GridData labelGD = LayoutUtils.createHBTFGridData(totalColumn);
		Label label = WidgetUtils.createTitleLabel(composite, StrUtils.getResourceString("tab.orderProductSheet.label"));
		label.setLayoutData(labelGD);
		
		// supplierName controller.
		Label supplierNameLabel = WidgetUtils.createLabel(composite, StrUtils.getResourceString("tab.orderProductSheet.supplierName"));
		supplierNameLabel.setLayoutData(lLabelGD);
		Text supplierNameInput = WidgetUtils.createText(composite);
		supplierNameInput.setData("supplierName");
		supplierNameInput.setLayoutData(lInputGD);
		createMidEmpty(composite);

		// productName controller.
		Label productNameLabel = WidgetUtils.createLabel(composite, StrUtils.getResourceString("tab.orderProductSheet.productName"));
		productNameLabel.setLayoutData(lLabelGD);
		Text productNameInput = WidgetUtils.createText(composite);
		productNameInput.setData("productName");
		productNameInput.setLayoutData(lInputGD);
		createEndEmpty(composite);

		// number controller.
		Label numberLabel = WidgetUtils.createLabel(composite, StrUtils.getResourceString("tab.orderProductSheet.number"));
		numberLabel.setLayoutData(lLabelGD);
		Text numberInput = WidgetUtils.createText(composite);
		numberInput.setData("number");
		numberInput.setLayoutData(lInputGD);
		createMidEmpty(composite);

		// spec controller.
		Label specLabel = WidgetUtils.createLabel(composite, StrUtils.getResourceString("tab.orderProductSheet.spec"));
		specLabel.setLayoutData(lLabelGD);
		Text specInput = WidgetUtils.createText(composite);
		specInput.setData("spec");
		specInput.setLayoutData(lInputGD);
		createEndEmpty(composite);

		// color controller.
		Label colorLabel = WidgetUtils.createLabel(composite, StrUtils.getResourceString("tab.orderProductSheet.color"));
		colorLabel.setLayoutData(lLabelGD);
		Text colorInput = WidgetUtils.createText(composite);
		colorInput.setData("color");
		colorInput.setLayoutData(lInputGD);
		createMidEmpty(composite);

		// salePrice controller.
		Label salePriceLabel = WidgetUtils.createLabel(composite, StrUtils.getResourceString("tab.orderProductSheet.salePrice"));
		salePriceLabel.setLayoutData(lLabelGD);
		Text salePriceInput = WidgetUtils.createText(composite);
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
	
	public String[] open() {
		initWidget();
		shell.setSize (790, 240);
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
