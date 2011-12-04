/**
 * 
 */
package com.coral.cstore;


import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;

/**
 * @author coral.ma
 *
 */
public class Style {
	
	public static Color blue = new Color(null, 153, 186, 243);
//	public static Color extJsBlue = new Color(null, 102, 102, 102);
	public static Color extJsBlue = new Color(null, 67, 90, 110);
	public static Color titleGray = new Color(null, 67, 90, 110);
	public static Color white = new Color(null, 255, 255, 255);
	public static Color milkWhite = new Color(null, 242, 242, 242);
	public static Color black = new Color(null, 51, 51, 51);
	public static Color gray = new Color(null, 128, 128, 128);
	
	public static Font groupTitleFont = new Font(null, new FontData("宋体", 9, SWT.BOLD));
	public static Font tabTitleFont = new Font(null, new FontData("宋体", 12, SWT.BOLD));
	public static Font loginInputFont = new Font(null, new FontData("宋体", 12, SWT.NORMAL));
	
	public static void gridLayoutUtils(GridLayout gridLayout) {
		gridLayout.verticalSpacing=10;
		gridLayout.marginLeft = 10;
		gridLayout.marginTop=10;
		gridLayout.marginRight=10;
		gridLayout.marginBottom=10;
	}
	
	
	public static void tabTitleLabel(Label label) {
		label.setFont(Style.tabTitleFont);
		label.setBackground(Style.white);
		label.setForeground(extJsBlue);
	}
	
	public static void tabDescriptionLabel(Label label) {
		label.setForeground(Style.gray);
		label.setBackground(Style.white);
	}
	
	public static void label(Label label) {
		label.setBackground(Style.white);
	}
	
	public static void group(Group group){
		group.setBackground(Style.milkWhite);
		group.setFont(Style.groupTitleFont);
		group.setForeground(Style.extJsBlue);
	}
	
	public static FormData getTitleFormData() {
		return null;
	}
}
