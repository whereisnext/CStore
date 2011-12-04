/**
 * 
 */
package com.coral.cstore.groups;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.coral.cstore.Style;
import com.coral.cstore.SysConstant;
import com.coral.cstore.utils.ImageUtils;
import com.coral.cstore.utils.LayoutUtils;
import com.coral.cstore.utils.StrUtils;

/**
 * @author coral.ma
 *
 */
public class SearchGroup {
	
	Group searchGroup;
	
	public SearchGroup() {
	}
	
	public void initWidget(Shell shell) {
		GridData data = new GridData(GridData.FILL, GridData.BEGINNING, true, false);
		// left size gird number of total grid number.
		data.horizontalSpan = 1;
		// the minimum size of left gird.
		data.minimumWidth =SysConstant.groupWidth;
		searchGroup = new Group(shell, SWT.SHADOW_IN);
		searchGroup.setLayoutData(data);
		searchGroup.setText(StrUtils.getResourceString("group.title.search"));
		Style.group(searchGroup);
	    
	    // inside layout
		RowLayout rowLayout = new RowLayout(SWT.VERTICAL);
		rowLayout.spacing = SysConstant.spacing;
	    searchGroup.setLayout(rowLayout);

	    RowData rowData = new RowData();
	    rowData.width = SysConstant.groupWidth - 20;
	    
//	    // inside widgets
	    Label searchLabel = new Label(searchGroup,SWT.WRAP | SWT.SHADOW_OUT);
	    searchLabel.setText(StrUtils.getResourceString("group.search.label"));
	    searchLabel.setBackground(Style.milkWhite);
	    searchLabel.setForeground(Style.gray);
	    searchLabel.setLayoutData(rowData);
	    Text searchText = new Text(searchGroup,SWT.SINGLE | SWT.BORDER);
	    searchText.setLayoutData(rowData);
	    
	    // button
	    GridLayout searchLayout = new GridLayout();
	    searchLayout.numColumns = 1;
//	    searchLayout.verticalSpacing=10;
	    final Composite composite = new Composite(searchGroup,SWT.NONE);
		composite.setLayout(searchLayout);
		composite.setBackground(Style.milkWhite);
		composite.setLayoutData(rowData);
		GridData searchGridData = LayoutUtils.createCCTTGridData(1);
	    Button searchButton = new Button(composite, SWT.PUSH | SWT.CENTER);
	    searchButton.setImage(ImageUtils.getImage("Search"));
	    searchButton.setText(StrUtils.getResourceString("group.search.button"));
//	    searchButton.setLayoutData(searchButtonData);
	    searchButton.setLayoutData(searchGridData);
	}
}
