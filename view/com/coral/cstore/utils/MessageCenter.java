/**
 * 
 */
package com.coral.cstore.utils;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

/**
 * @author coral.ma
 *
 */
public class MessageCenter {

	public static MessageBox alertMessage(Shell shell, String s) {
		MessageBox messageBox = new MessageBox(shell, SWT.ICON_INFORMATION| SWT.YES);
	    messageBox.setMessage(s);
	    messageBox.setText(StrUtils.getResourceString("message.system.alert.title"));
		return messageBox;
	}
	
	public static MessageBox confirmMessage(Shell shell, String s) {
		MessageBox messageBox = new MessageBox(shell, SWT.ICON_INFORMATION| SWT.YES | SWT.NO);
	    messageBox.setMessage(s);
	    messageBox.setText(StrUtils.getResourceString("message.system.confirm.title"));
		return messageBox;
	}
}
