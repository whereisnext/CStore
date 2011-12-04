/**
 * 
 */
package com.coral.cstore.view;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * @author Coral
 *
 */
public class AbstractDialog {

	protected Shell parentShell;
	protected Shell shell;
	protected boolean isEdit;
	
	public void openDialog() {
//		shell.pack();
		shell.open();
		shell.setRedraw(true);
		// Move the dialog to the center of the top level shell.
        Rectangle shellBounds = parentShell.getBounds();
        Point dialogSize = shell.getSize();

        shell.setLocation(
          shellBounds.x + (shellBounds.width - dialogSize.x) / 2,
          shellBounds.y + (shellBounds.height - dialogSize.y) / 2);

		Display display = shell.getDisplay();
		while(!shell.isDisposed()){
			if(!display.readAndDispatch())
				display.sleep();
		}
	}
}
