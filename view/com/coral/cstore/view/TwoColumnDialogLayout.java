/**
 * 
 */
package com.coral.cstore.view;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;

import com.coral.cstore.utils.LayoutUtils;
import com.coral.cstore.utils.WidgetUtils;

/**
 * @author coral.ma
 *
 */
public class TwoColumnDialogLayout extends AbstractDialog {

	protected int totalColumn =12,labelSize = 2,inputSize = 3,midEmpty = 1,endEmpty = 1,centerButton = 10;
	protected int croseColumnSize = 9,closeEndEmpty = 3;
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
}
