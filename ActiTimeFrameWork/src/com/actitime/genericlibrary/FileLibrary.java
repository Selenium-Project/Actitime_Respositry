package com.actitime.genericlibrary;

import java.io.FileInputStream;

import java.io.FileOutputStream;

import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLibrary {
/**
 * it provide libraries to get the data from .Xlsx and properties
 * @author jyoti
 */

	
		/**
		 * get the keyvalue from the commonFile.properties File
		 * like URL,USERNAME,PASSWORD
		 * @parameter key
		 * @return value of the key
		 * @throws Throwable 
		
		 */
		
		public String getPropertyKeyValue(String Key) throws Throwable
		{
			String filePath="./CommonFile.properties";
			FileInputStream fis= new FileInputStream(filePath);
			Properties pObj= new Properties();
			pObj.load(fis);
			String value=pObj.getProperty(Key);
			return value;
			
		}
		
		/**
		 * Get the Data from from Excel WorkBook based user arugments
		 * @param SheetName
		 * @param rownum
		 * @return data
		 * @throws Throwable
		 */
	
	public String getExcelData(String SheetName,int rownum,int columnnum) throws Throwable
	{
		FileInputStream fibObj = new FileInputStream("C:\\Users\\jyoti\\Desktop\\TestData.xlsx");

		Workbook wb= WorkbookFactory.create(fibObj);
		Sheet sh =wb.getSheet(SheetName);
		Row row=sh.getRow(rownum); 
		Cell cel= row.getCell(columnnum);
		String data= cel.getStringCellValue();
		wb.close();
		return data;
	} 
	
	/**
	 * Used to set data back to the Excel WorkBook based on user argument
	 *@param SheetName
     * @param rownum
     * @return data
	 * @throws Throwable
	 */
	public void setExcelData(String SheetName,int rownum,int columnNum,String data) throws Throwable
	{
		FileInputStream fibObj = new FileInputStream("C:\\Users\\jyoti\\Desktop\\TestData.xlsx");

		Workbook wb= WorkbookFactory.create(fibObj);
		Sheet sh =wb.getSheet(SheetName);
		Row row=sh.getRow(rownum); 
		Cell cel= row.createCell(columnNum);
		cel.setCellValue(data);
		FileOutputStream fOs= new FileOutputStream("C:\\Users\\jyoti\\Desktop\\TestData.xlsx");
		wb.write(fOs);
		wb.close();
	}
		
}
