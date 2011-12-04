/**
 * 
 */
package com.coral.cstore.utils;

import java.util.Date;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.coral.cstore.Style;
import com.coral.fundation.utils.DateUtils;

/**
 * @author Coral
 *
 */
public class WidgetUtils {

	/** Label. */
	public static Label createLabel(Composite composite,String text) {
		Label label = new Label(composite, SWT.NONE);
		label.setBackground(Style.white);
		label.setText(text + ":");
		return label;
	}
	
	public static Label createRequiredLabel(Composite composite,String text) {
		Label label = new Label(composite, SWT.NONE);
		label.setBackground(Style.white);
		label.setText(text + "*:");
		return label;
	}
	
	public static Label createEmptyLabel(Composite composite) {
		Label label = new Label(composite, SWT.NONE);
		label.setBackground(Style.white);
		return label;
	}
	
	public static Label createNormalLabel(Composite composite,String text) {
		Label label = new Label(composite, SWT.NONE);
		label.setBackground(Style.white);
		label.setText(text);
		return label;
	}
	
	public static Label createTitleLabel(Composite composite,String text) {
		Label label = new Label(composite, SWT.NONE);
		label.setBackground(Style.white);
		label.setFont(Style.tabTitleFont);
		label.setForeground(Style.extJsBlue);
		label.setText(text);
		return label;
	}
	
	public static Label createBoldLabel(Composite composite,String text) {
		Label label = new Label(composite, SWT.NONE);
		label.setBackground(Style.white);
		label.setText(text);
		label.setFont(Style.groupTitleFont);
		return label;
	}
	
	public static Label createDescriptionLabel(Composite composite,String text) {
		Label label = new Label(composite, SWT.WRAP | SWT.SHADOW_OUT);
		label.setBackground(Style.white);
		label.setForeground(Style.gray);
		label.setText(text);
		return label;
	}

	/** Text. */
	public static Text createText(Composite composite) {
		Text text = new Text(composite, SWT.SINGLE | SWT.BORDER);
		return text;
	}
	
	public static Text createPassword(Composite composite) {
		Text text = new Text(composite, SWT.PASSWORD | SWT.SINGLE | SWT.BORDER);
		return text;
	}
	
	/** Combo */
	public static Combo createCombo(Composite composite, String[] datas) {
		Combo combo = new Combo(composite, SWT.READ_ONLY | SWT.DROP_DOWN | SWT.SIMPLE);
		combo.setItems(datas);
		return combo;
	}
	
	/** Closable CTabItem */
	public static CTabItem createClosableCTabItem(CTabFolder tabFolder, String titleText) {
		CTabItem item = new CTabItem(tabFolder, SWT.DEFAULT);
		item.setShowClose(true);
		item.setText(StrUtils.tabTitle(titleText));
		return item;
	}
	
	/** create button*/
	public static Button createButton(Composite composite, String text) {
		Button btn = new Button(composite, SWT.PUSH);
		btn.setText(text);
		return btn;
	}
	
	public static Button createCheckBox(Composite composite, String text) {
		Button btn = new Button(composite, SWT.CHECK);
		btn.setText(text);
		btn.setBackground(Style.white);
		btn.setSelection(true);
		return btn;
	}
	
	
	/** Date time. */
	public static DateTime createDateTime(Composite composite) {
		DateTime dateTime = new DateTime(composite, SWT.DATE | SWT.DROP_DOWN | SWT.BORDER | SWT.LONG);
//		dateTime.setDate(DateUtils.getYear(date), DateUtils.getMonth(date), DateUtils.getDay(date));
		return dateTime;
	}
	
	public static Group createGroup(Composite composite,String title) {
		Group group = new Group(composite, SWT.NONE);
		group.setBackground(Style.white);
		group.setForeground(Style.titleGray);
		group.setText(StrUtils.getResourceString(title));
		return group;
	}
	
}
