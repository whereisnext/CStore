/**
 * 
 */
package com.coral.cstore.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import com.coral.cstore.Style;
import com.coral.cstore.utils.LayoutUtils;
import com.coral.cstore.utils.StrUtils;
import com.coral.cstore.utils.WidgetUtils;

/**
 * @author coral.ma
 *
 */
public class TwoColumnViewLayout {

	/** 
	 * 	<----------------------------8------------------------------>
	 *	lLabelGD	lInputGD	midEGD	lLabelGD	lInputGD	endEGD
	 *		1			2		  1			1			2		  1
	 *	lLabelGD	lCInputGD									endEGD
	 *		1			6										  1
	 *
	 **/
	protected int totalColumn =8,labelSize = 1,inputSize = 2,midEmpty = 1,endEmpty = 1,centerButton=9;
	protected int croseColumnSize = 6;//,closeEndEmpty = 3;
	protected GridData lLabelGD = LayoutUtils.createFillGridData(labelSize);
	protected GridData lInputGD = LayoutUtils.createFillGridData(inputSize);
	protected GridData lCInputGD = LayoutUtils.createFillGridData(croseColumnSize);
	protected GridData midEGD = LayoutUtils.createFillGridData(midEmpty);
	protected GridData endEGD = LayoutUtils.createFillGridData(endEmpty);
	protected GridData btn = LayoutUtils.createCenterGridData(centerButton);
	
	protected void createMidEmpty(Composite composite) {
		WidgetUtils.createEmptyLabel(composite).setLayoutData(midEGD);
	}
	
	protected void createEndEmpty(Composite composite) {
		WidgetUtils.createEmptyLabel(composite).setLayoutData(endEGD);
	}
	
	protected void createEndEmpty(Composite composite, int size) {
		WidgetUtils.createEmptyLabel(composite).setLayoutData(LayoutUtils.createFillGridData(size));
	}
	
	protected Composite createComposite(Composite parent, String title, String desc) {
		GridLayout gridLayout = new GridLayout(totalColumn,true);
		Style.gridLayoutUtils(gridLayout);
		
		Composite composite = new Composite(parent,SWT.NONE);
		composite.setLayout(gridLayout);
		composite.setBackground(Style.white);
	
		GridData labelGD = LayoutUtils.createHBTFGridData(totalColumn);
		Label label = WidgetUtils.createTitleLabel(composite, StrUtils.getResourceString(title));
		label.setLayoutData(labelGD);
		
		GridData descData = LayoutUtils.createHBTFGridData(totalColumn);
		Label descLabel = WidgetUtils.createDescriptionLabel(composite, StrUtils.getResourceString(desc));
		descLabel.setLayoutData(descData);
		return composite;
	}
	
	
	
//	public void isDialog() {
//		totalColumn =12;
//		labelSize = 2;
//		inputSize = 3;
//		midEmpty = 1;
//		endEmpty = 1;
//		croseColumnSize=9;
//		centerButton = 10;
//		lLabelGD = LayoutUtils.createFillGridData(labelSize);
//		lInputGD = LayoutUtils.createFillGridData(inputSize);
//		lCInputGD = LayoutUtils.createFillGridData(croseColumnSize);
//		midEGD = LayoutUtils.createFillGridData(midEmpty);
//		endEGD = LayoutUtils.createFillGridData(endEmpty);
//		btn = LayoutUtils.createCenterGridData(centerButton);
//	}
}
