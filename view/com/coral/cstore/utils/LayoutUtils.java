/**
 * 
 */
package com.coral.cstore.utils;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;

import com.coral.cstore.Style;
import com.coral.cstore.SysConstant;

/**
 * @author Coral
 *
 */
public class LayoutUtils {
	
	public static GridLayout createGridLayout(int totalColumn) { 
		GridLayout gridLayout = new GridLayout(totalColumn,true);
		Style.gridLayoutUtils(gridLayout);
		return gridLayout;
	}
	
	public static GridData createFFTTGridData(int horizontalSpan) {
		GridData gridData = new GridData(GridData.FILL, GridData.FILL, true, true);
		gridData.horizontalSpan=horizontalSpan;
		return gridData;
	}
	public static GridData createStatusBarGridData(int horizontalSpan) {
		GridData gridData = new GridData(GridData.FILL, GridData.END, true, false);
		gridData.horizontalSpan=horizontalSpan;
		gridData.heightHint=SysConstant.stautsBar;
		return gridData;
	}
	public static GridData createHBTFGridData() {
		GridData gridData = createHBTFGridData(1);
		return gridData;
	}
	public static GridData createHBTFGridData(int horizontalSpan) {
		GridData gridData = new GridData(GridData.FILL, GridData.BEGINNING, true, false);
		gridData.horizontalSpan=horizontalSpan;
		return gridData;
	}
	
	public static GridData createHFTTGridData(int horizontalSpan) {
		GridData gridData = new GridData(GridData.FILL, GridData.FILL, true, true);
		gridData.horizontalSpan=horizontalSpan;
		return gridData;
	}
	
	public static GridData createBBTFGridData() {
		GridData gridData = new GridData(GridData.BEGINNING, GridData.BEGINNING, true, false);
		return gridData;
	}
	public static GridData createBBTFGridData(int horizontalSpan) {
		GridData gridData = new GridData(GridData.BEGINNING, GridData.BEGINNING, true, false);
		gridData.horizontalSpan=horizontalSpan;
		return gridData;
	}
	public static GridData createBETFGridData(int horizontalSpan) {
		GridData gridData = new GridData(GridData.BEGINNING, GridData.CENTER, true, false);
		gridData.horizontalSpan=horizontalSpan;
		return gridData;
	}
	public static GridData createEETFGridData(int horizontalSpan) {
		GridData gridData = new GridData(GridData.END, GridData.CENTER, true, false);
		gridData.horizontalSpan=horizontalSpan;
		return gridData;
	}
//	public static GridData createEETTGridData(int horizontalSpan) {
//		GridData gridData = new GridData(GridData.END, GridData.CENTER, true, true);
//		gridData.horizontalSpan=horizontalSpan;
//		return gridData;
//	}
	
	public static GridData createFillGridData() {
		GridData gridData = new GridData(GridData.FILL, GridData.CENTER, false, false);
		return gridData;
	}
	
	public static GridData createFillGridData(int horizontalSpan) {
		GridData gridData = new GridData(GridData.FILL, GridData.CENTER, false, false);
		gridData.horizontalSpan = horizontalSpan;
		return gridData;
	}
	
	public static GridData createCenterGridData() {
		GridData gridData = new GridData(GridData.CENTER, GridData.CENTER, false, false);
		return gridData;
	}
	
	public static GridData createCenterGridData(int horizontalSpan) {
		GridData gridData = new GridData(GridData.CENTER, GridData.CENTER, false, false);
		gridData.horizontalSpan = horizontalSpan;
		return gridData;
	}
	
	public static GridData createCCTTGridData(int horizontalSpan) {
		GridData gridData = new GridData(GridData.CENTER, GridData.CENTER, true, true);
		gridData.horizontalSpan = horizontalSpan;
		return gridData;
	}

	public static Composite createRowComposite(Composite parent) {
		RowLayout layout =new RowLayout();
		layout.pack = true;
		layout.wrap= false;
		layout.justify=true;
		Composite btnComposite = new Composite(parent,SWT.NONE);
		btnComposite.setLayout(layout);
		btnComposite.setBackground(Style.white);
		return btnComposite;
	}
	
	public static Composite createVerticalRowComposite(Composite parent) {
		RowLayout layout =new RowLayout();
		layout.pack = true;
		layout.wrap= false;
		layout.justify=true;
//		layout.fill = true;
		layout.type = SWT.VERTICAL;
		Composite btnComposite = new Composite(parent,SWT.NONE);
		btnComposite.setLayout(layout);
		btnComposite.setBackground(Style.white);
		return btnComposite;
	}
	
	public static Composite createOneColumnGridLayout(Composite parent){
		GridLayout gridLayout = new GridLayout(1,true);
		Style.gridLayoutUtils(gridLayout);
		Composite composite = new Composite(parent,SWT.NONE);
		composite.setLayout(gridLayout);
		composite.setBackground(Style.white);
		return composite; 
	}
}
