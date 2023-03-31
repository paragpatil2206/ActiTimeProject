package com.ActiTime.GenericLibrary;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author parag
 *
 */
public class FileLibrary {

	private String value;

	/**
	 * This method is a non-static method which is used to read the data from Property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDataFromProperty(String key) throws IOException 
	{
	FileInputStream fis1=new FileInputStream("./TestData/CommonData.property");
		Properties p= new Properties();
		p.load(fis1);
		String value = p.getProperty(key);
		return value;
	}
	
	/**
	 * This method is a non-static method used to read the data from excel sheet
	 * @param SheetName
	 * @param row
	 * @param cell
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcelFile(String SheetName, int row, int cell) throws EncryptedDocumentException, IOException {

		FileInputStream fis2= new FileInputStream("./TestData/ActiTimeTestData.xlsx.xlsx");
		Workbook wb = WorkbookFactory.create(fis2);
		String value= wb.getSheet(SheetName).getRow(row).getCell(cell).getStringCellValue();
	
		return value;
	
	}
}
