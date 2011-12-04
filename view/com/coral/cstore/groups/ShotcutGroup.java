/**
 * 
 */
package com.coral.cstore.groups;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;

import com.coral.cstore.Style;
import com.coral.cstore.SysConstant;
import com.coral.cstore.utils.StrUtils;

/**
 * @author coral.ma
 *
 */
public class ShotcutGroup {
	
	public void initWidget(Shell shell) {
		GridData data = new GridData(GridData.FILL, GridData.FILL, true, false);
		// left size gird number of total grid number.
		data.horizontalSpan = 1;
		// the minimum size of left gird.
		data.minimumWidth =SysConstant.groupWidth;
		Group shotcutGroup = new Group(shell, SWT.SHADOW_IN);
		shotcutGroup.setLayoutData(data);
		shotcutGroup.setText(StrUtils.getResourceString("group.title.shotcut"));
	    shotcutGroup.setBackground(Style.milkWhite);
//	    shotcutGroup.setFont(Style.groupTitleFont);
		Style.group(shotcutGroup);
	}
}
