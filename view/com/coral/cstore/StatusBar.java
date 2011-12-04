/**
 * 
 */
package com.coral.cstore;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;

import com.coral.cstore.utils.LayoutUtils;
import com.coral.cstore.utils.WidgetUtils;

/**
 * @author Coral
 *
 */
public class StatusBar {
	public static ProgressBar bar;
	public static Label statusMsg; 
	
	public Composite initWidget(Shell shell) {
		GridData gridData = LayoutUtils.createStatusBarGridData(SysConstant.mainColumn);
		RowLayout layout = new RowLayout();
		layout.marginLeft=0;
		layout.marginTop=0;
//		layout.spacing
		Composite composite = new Composite(shell, SWT.BORDER);
		composite.setLayoutData(gridData);
		composite.setBackground(Style.milkWhite);
		composite.setLayout(layout);
		
		// left size gird number of total grid number.
		// the minimum size of left gird.
		RowData barData = new RowData();
		barData.width = SysConstant.groupWidth;
		bar = new ProgressBar(composite, /*SWT.INDETERMINATE*/SWT.SMOOTH);
		bar.setLayoutData(barData);
//		bar.setBackground(Style.extJsBlue);
		
		// left size gird number of total grid number.
		RowData msgData = new RowData();
		msgData.width = SysConstant.groupWidth;
		statusMsg = WidgetUtils.createNormalLabel(composite, " 查询结果：50条数据");
		statusMsg.setLayoutData(msgData);
		
//		RowData conMsgData = new RowData();
//		conMsgData.width = SysConstant.groupWidth;
//		statusMsg = WidgetUtils.createNormalLabel(composite, "数据库连接状态：本地数据库");
//		statusMsg.setLayoutData(conMsgData);
		return null;
	}
}
