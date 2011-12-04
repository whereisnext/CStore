/**
 * 
 */
package com.coral.cstore.zpoc;

import org.eclipse.swt.printing.PrintDialog;
import org.eclipse.swt.printing.Printer;
import org.eclipse.swt.printing.PrinterData;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * @author coral.ma
 * 
 */
public class PrintingExample {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		PrintDialog dlg = new PrintDialog(shell);
		dlg.setScope(PrinterData.SELECTION);
		PrinterData printerData = dlg.open();
		if (printerData != null) {
			Printer printer = new Printer(printerData);
			System.out.println(printer.getClientArea());
			printer.dispose();
		}
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}

}
