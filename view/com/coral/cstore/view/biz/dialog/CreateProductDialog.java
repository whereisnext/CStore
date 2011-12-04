/**
 * 
 */
package com.coral.cstore.view.biz.dialog;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.coral.cstore.Style;
import com.coral.cstore.utils.DataBindingUtils;
import com.coral.cstore.utils.LayoutUtils;
import com.coral.cstore.utils.StrUtils;
import com.coral.cstore.utils.ValidateUtil;
import com.coral.cstore.utils.WidgetUtils;
import com.coral.cstore.view.TwoColumnDialogLayout;
import com.coral.cstore.view.TwoColumnViewLayout;
import com.coral.store.model.Customer;
import com.coral.store.model.Product;

/**
 * @author Coral
 *
 */
public class CreateProductDialog extends TwoColumnDialogLayout {
	
	Product value;
	String[] labels;
	Composite composite;
	
	public CreateProductDialog(Shell parent) {
		super.parentShell = parent;
//		shell = new Shell(parent, SWT.CLOSE | SWT.BORDER | SWT.DIALOG_TRIM | SWT.PRIMARY_MODAL);
		shell = new Shell (parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		shell.setText(StrUtils.getResourceString("tab.product.createBtn"));
		shell.setBackground(Style.white);
		shell.setLayout(new FillLayout());	
		initWidget();
	}
	
	public void initWidget() {
//		isDialog();
		GridLayout gridLayout = new GridLayout(totalColumn,true);
		Style.gridLayoutUtils(gridLayout);
		
		composite = new Composite(shell,SWT.NONE);
		composite.setLayout(gridLayout);
		composite.setBackground(Style.white);

		GridData labelGD = LayoutUtils.createHBTFGridData(totalColumn);
		Label label = WidgetUtils.createTitleLabel(composite, StrUtils.getResourceString("tab.product.createBtn"));
		label.setLayoutData(labelGD);
		
		
		// productCode controller.
		Label productCodeLabel = WidgetUtils.createLabel(composite, StrUtils.getResourceString("tab.product.productCode"));
		productCodeLabel.setLayoutData(lLabelGD);
		Text productCodeInput = WidgetUtils.createText(composite);
		productCodeInput.setData("productCode");
		productCodeInput.setLayoutData(lInputGD);
		createMidEmpty(composite);

		// productName controller.
		Label productNameLabel = WidgetUtils.createLabel(composite, StrUtils.getResourceString("tab.product.productName"));
		productNameLabel.setLayoutData(lLabelGD);
		Text productNameInput = WidgetUtils.createText(composite);
		productNameInput.setData("productName");
		productNameInput.setLayoutData(lInputGD);
		createEndEmpty(composite);

		// brand controller.
		Label brandLabel = WidgetUtils.createLabel(composite, StrUtils.getResourceString("tab.product.brand"));
		brandLabel.setLayoutData(lLabelGD);
		Text brandInput = WidgetUtils.createText(composite);
		brandInput.setData("brand");
		brandInput.setLayoutData(lInputGD);
		createMidEmpty(composite);

		// unit controller.
		Label unitLabel = WidgetUtils.createLabel(composite, StrUtils.getResourceString("tab.product.unit"));
		unitLabel.setLayoutData(lLabelGD);
		Text unitInput = WidgetUtils.createText(composite);
		unitInput.setData("unit");
		unitInput.setLayoutData(lInputGD);
		createEndEmpty(composite);

		// spec controller.
		Label specLabel = WidgetUtils.createLabel(composite, StrUtils.getResourceString("tab.product.spec"));
		specLabel.setLayoutData(lLabelGD);
		Text specInput = WidgetUtils.createText(composite);
		specInput.setData("spec");
		specInput.setLayoutData(lInputGD);
		createMidEmpty(composite);

		// color controller.
		Label colorLabel = WidgetUtils.createLabel(composite, StrUtils.getResourceString("tab.product.color"));
		colorLabel.setLayoutData(lLabelGD);
		Text colorInput = WidgetUtils.createText(composite);
		colorInput.setData("color");
		colorInput.setLayoutData(lInputGD);
		createEndEmpty(composite);

		// buyPrice controller.
		Label buyPriceLabel = WidgetUtils.createLabel(composite, StrUtils.getResourceString("tab.product.buyPrice"));
		buyPriceLabel.setLayoutData(lLabelGD);
		Text buyPriceInput = WidgetUtils.createText(composite);
		buyPriceInput.setData("buyPrice");
		buyPriceInput.setLayoutData(lInputGD);
		createMidEmpty(composite);

		// sale price controller.
		Label salePriceLabel = WidgetUtils.createLabel(composite, StrUtils.getResourceString("tab.product.salePrice"));
		salePriceLabel.setLayoutData(lLabelGD);
		Text salePriceInput = WidgetUtils.createText(composite);
		salePriceInput.setData("salePrice");
		salePriceInput.setLayoutData(lInputGD);
		createEndEmpty(composite);

		// mark controller.
		Label markLabel = WidgetUtils.createLabel(composite, StrUtils.getResourceString("tab.product.mark"));
		markLabel.setLayoutData(lLabelGD);
		Text markInput = WidgetUtils.createText(composite);
		markInput.setData("mark");
		markInput.setLayoutData(lCInputGD);
		createEndEmpty(composite);
		
		Button button = new Button(composite, SWT.PUSH);
		button.setText(StrUtils.getResourceString("tab.product.createBtn"));
		button.setLayoutData(btn);	
		button.addMouseListener(new MouseAdapter() {
			public void mouseUp(MouseEvent e) {
				Control[] children = composite.getChildren();
				if(value == null) {
					value = new Product();
				}
				value = (Product)DataBindingUtils.dataBinding(children, value, value.getClass());
				String checkPcRs = ValidateUtil.validateProduct(value);
				if(!checkPcRs.equals(StrUtils.empty)) {
					return;
				}
				shell.close();
			}
		});
	}
	
	public Product getValue() {
		return value;
	}
	
	public void setValue(Product product) {
		this.value = product;
		DataBindingUtils.bindingToComposite(product,composite);
	}
	
	public Product open() {
		shell.setSize (790, 250);
		openDialog();
		return getValue();
	}

}
