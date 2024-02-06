package com.ametek.generic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/*
 * This class is used to keep all the reusable methods
 * 
 * @author Rajesh Kumar
 */
public class Utils {
	
	public static String getValueFromPropFile(String key)
	{
		Properties prop= new Properties();
		try {
			FileInputStream fis = new FileInputStream("./src/test/resources/config.properties");
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop.getProperty(key);
	}
	public static void writeDataIntoExcelSheet(String sheetname, int row, int cell, String data) throws Exception {
		FileInputStream fis = new FileInputStream("./data/output.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
	    Sheet sh=wb.getSheet(sheetname); 
	    Row rw;
		if(sh.getRow(row)!= null)
	        rw = sh.getRow(row);     
	    else 
	        rw = sh.createRow(row);
	    rw.createCell(cell).setCellValue(data);
		FileOutputStream out = new FileOutputStream("./data/output.xlsx"); 
	    wb.write(out);
	}
	
	public static void switchToChildWindow(WebDriver driver) {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String mainWindow = it.next();
		String childWindow = it.next();
		driver.switchTo().window(childWindow);
	}
}
