/**
 * 
 */
package com.coral.cstore;

import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;

/**
 * @author Coral
 *
 */
public interface IView {

	public CTabItem asTabView(CTabFolder tabFolder);
	public void refresh();
	public String viewName();
	public Object getModel();
	public void setModel(Object obj);
}
