/**
 * 
 */
package com.coral.cstore.utils;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;

/**
 * @author coral.ma
 *
 */
public class TwoColumnViewLayout {

	protected int totalColumn =12,labelSize = 1,inputSize = 3,midEmpty = 1,endEmpty = 3,centerButton=9;
	protected int croseColumnSize = 8,closeEndEmpty = 3;
	protected GridData lLabelGD = LayoutUtils.createFillGridData(labelSize);
	protected GridData lInputGD = LayoutUtils.createFillGridData(inputSize);
	protected GridData lCInputGD = LayoutUtils.createFillGridData(croseColumnSize);
	protected GridData rLabelGD = LayoutUtils.createFillGridData(labelSize);
	protected GridData rInputGD = LayoutUtils.createFillGridData(inputSize);
	protected GridData midEGD = LayoutUtils.createFillGridData(midEmpty);
	protected GridData endEGD = LayoutUtils.createFillGridData(endEmpty);
	protected GridData btn = LayoutUtils.createCenterGridData(centerButton);
	
	protected void createMidEmpty(Composite composite) {
		WidgetUtils.createEmptyLabel(composite).setLayoutData(midEGD);
	}
	
	protected void createEndEmpty(Composite composite) {
		WidgetUtils.createEmptyLabel(composite).setLayoutData(endEGD);
	}
	
	public void isDialog() {
		totalColumn =12;
		labelSize = 2;
		inputSize = 3;
		midEmpty = 1;
		endEmpty = 1;
		croseColumnSize=9;
		centerButton = 10;
		lLabelGD = LayoutUtils.createFillGridData(labelSize);
		lInputGD = LayoutUtils.createFillGridData(inputSize);
		lCInputGD = LayoutUtils.createFillGridData(croseColumnSize);
		rLabelGD = LayoutUtils.createFillGridData(labelSize);
		rInputGD = LayoutUtils.createFillGridData(inputSize);
		midEGD = LayoutUtils.createFillGridData(midEmpty);
		endEGD = LayoutUtils.createFillGridData(endEmpty);
		btn = LayoutUtils.createCenterGridData(centerButton);
	}
}
