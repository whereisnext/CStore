/**
 * 
 */
package com.coral.cstore.groups;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import com.coral.cstore.Style;
import com.coral.cstore.SysConstant;
import com.coral.cstore.utils.StrUtils;

/**
 * @author coral.ma
 *
 */
public class RemindGroup {

	public void initWidget(Shell shell) {
		GridData remindData = new GridData(GridData.FILL, GridData.BEGINNING, false, false);
		// left size gird number of total grid number.
		remindData.horizontalSpan = 1;
		// the minimum size of left gird.
		remindData.minimumWidth =SysConstant.groupWidth;
		
	    GridLayout remindLayout = new GridLayout();
	    remindLayout.verticalSpacing=10;
	    remindLayout.numColumns = 8;
	    
		Group remindGroup = new Group(shell, SWT.SHADOW_ETCHED_IN);
		remindGroup.setLayout(remindLayout);
		remindGroup.setLayoutData(remindData);
		remindGroup.setText(StrUtils.getResourceString("group.title.remind"));
//	    remindGroup.setBackground(Style.milkWhite);
//	    remindGroup.setFont(Style.groupTitleFont);
		Style.group(remindGroup);
	    
	    GridData remindLabelData = new GridData(GridData.BEGINNING, GridData.CENTER, true, true);
	    remindLabelData.horizontalSpan=6;
	    GridData remindNumberData = new GridData(GridData.BEGINNING, GridData.CENTER, true, true);
	    remindNumberData.horizontalSpan=1;
	    GridData remindBtnData = new GridData(GridData.CENTER, GridData.CENTER, true, true);
	    remindBtnData.horizontalSpan=1;
	    
	    Label needAudit = new Label(remindGroup, SWT.SHADOW_OUT);
	    needAudit.setText(StrUtils.getResourceString("group.remind.needAudit"));
	    needAudit.setBackground(Style.milkWhite);
	    needAudit.setLayoutData(remindLabelData);
	    Label needAuditNo = new Label(remindGroup, SWT.SHADOW_OUT);
	    needAuditNo.setText("0");
	    needAuditNo.setBackground(Style.milkWhite);
	    needAuditNo.setLayoutData(remindNumberData);
	    Button needAuditBtn = new Button(remindGroup, SWT.PUSH);
	    needAuditBtn.setText(StrUtils.getResourceString("group.remind.btn.handle"));
	    needAuditBtn.setLayoutData(remindBtnData);
	    
	    Label failAudit=new Label(remindGroup, SWT.SHADOW_OUT);
	    failAudit.setText(StrUtils.getResourceString("group.remind.failAudit"));
	    failAudit.setLayoutData(remindLabelData);
	    failAudit.setBackground(Style.milkWhite);
	    Label failAuditNo = new Label(remindGroup, SWT.SHADOW_OUT);
	    failAuditNo.setText("0");
	    failAuditNo.setBackground(Style.milkWhite);
	    failAuditNo.setLayoutData(remindNumberData);
	    Button failAuditBtn = new Button(remindGroup, SWT.PUSH);
	    failAuditBtn.setText(StrUtils.getResourceString("group.remind.btn.handle"));
	    failAuditBtn.setLayoutData(remindBtnData);
	    
	    Label handlingAudit=new Label(remindGroup, SWT.SHADOW_OUT);
	    handlingAudit.setText(StrUtils.getResourceString("group.remind.handlingAudit"));
	    handlingAudit.setBackground(Style.milkWhite);
	    handlingAudit.setLayoutData(remindLabelData);
	    Label handlingAuditNo = new Label(remindGroup, SWT.SHADOW_OUT);
	    handlingAuditNo.setText("0");
	    handlingAuditNo.setBackground(Style.milkWhite);
	    handlingAuditNo.setLayoutData(remindNumberData);
	    Button handlingAuditBtn = new Button(remindGroup, SWT.PUSH);
	    handlingAuditBtn.setText(StrUtils.getResourceString("group.remind.btn.view"));
	    handlingAuditBtn.setLayoutData(remindBtnData);
	    
	    Label finishedOrder=new Label(remindGroup, SWT.SHADOW_OUT);
	    finishedOrder.setText(StrUtils.getResourceString("group.remind.finishedOrder"));
	    finishedOrder.setBackground(Style.milkWhite);
	    finishedOrder.setLayoutData(remindLabelData);
	    Label finishedOrderNo = new Label(remindGroup, SWT.SHADOW_OUT);
	    finishedOrderNo.setText("0");
	    finishedOrderNo.setBackground(Style.milkWhite);
	    finishedOrderNo.setLayoutData(remindNumberData);
	    Button finishedOrderBtn = new Button(remindGroup, SWT.PUSH);
	    finishedOrderBtn.setText(StrUtils.getResourceString("group.remind.btn.view"));
	    finishedOrderBtn.setLayoutData(remindBtnData);
	}
}
