/**
 * 
 */
package com.coral.fundation.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.coral.fundation.Log;

/**
 * @author coral.ma
 *
 */
public class ExcelUtils {
	
	static Map<String, String> fileMap = new HashMap<String, String>();
	
	static{
		fileMap.put("ManageCustomer", "customer.xls");
	}

	public void excelGenerate(String type, String[] handers,String[][] datas) {
		// TODO Auto-generated method stub
		try {
			// Create a New XL Document
			HSSFWorkbook wb = new HSSFWorkbook();
			// Make a worksheet in the XL document created
			HSSFSheet sheet = wb.createSheet("customer");
			// Create hand row at index zero ( Top Row)
			HSSFRow row = sheet.createRow(0);
			writeToRow(row,handers);
			// create data row
			for(int i=0;i<datas.length;i++) {
				String[] data = datas[i];
				HSSFRow subRow = sheet.createRow(i+1);
				writeToRow(subRow,data);
			}
			
			// The Output file is where the xls will be created
			FileOutputStream fOut = new FileOutputStream(fileMap.get(type));
			// Write the XL sheet
			wb.write(fOut);
			fOut.flush();
			// Done Deal..
			fOut.close();
			System.out.println("File Created ..");

		} catch (Exception e) {
			Log.error("Generate excel error.", this.getClass());
		}
	}

	private void writeToRow(HSSFRow row, String[] hander) {
		for(int i=0;i<hander.length;i++) {
			HSSFCell cell = row.createCell(i);
			// Lets make the cell a string type
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			// Type some content
			HSSFRichTextString value = new HSSFRichTextString(hander[i]);
			cell.setCellValue(value);
		}
	}
	
	public String[][] readExcel(String type, String path) {
		String[][] results = null;
		try{
			// Create a work book reference
			HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(path));
			// Refer to the sheet. Put the Name of the sheet to be referred from
			// Alternative you can also refer the sheet by index using getSheetAt(int index)
			HSSFSheet sheet = workbook.getSheet("customer");
			results = new String[sheet.getLastRowNum()][];
			//Reading the TOP LEFT CELL
			for (int i=0;i<sheet.getLastRowNum();i++) {
				HSSFRow row = sheet.getRow(i+1);
				String[] rowValue = new String[row.getLastCellNum()];
				 for (int y=0;y<row.getLastCellNum();y++) {
					 // Create a cell ate index zero ( Top Left)
					 HSSFCell cell = row.getCell(y);
					 // Type the content
					 rowValue[y] = cell.getRichStringCellValue().getString();
					 System.out.print(cell.getRichStringCellValue().getString()+"\t");
					 
				 }
				 results[i] = rowValue;
				 System.out.println("");
			}
		    
		}catch(Exception e) {
		    Log.error("Data Import error.", this.getClass());
		}
		return results;
	}
}
