package com.ActiTime.TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.ActiTime.GenericLibrary.BaseClass;
import com.ActiTime.GenericLibrary.FileLibrary;
import com.ActiTime.POM.HomePage;
import com.ActiTime.POM.TaskPage;

public class Task_Test extends BaseClass {

	@Test
	public void CreateCustomer() throws EncryptedDocumentException, IOException {
		HomePage hp= new HomePage(driver);
		hp.getTasklnk().click();
		
		TaskPage tp= new TaskPage(driver);
		tp.getAddnewbtn().click();
		tp.getNewCustomer().click();
		
		FileLibrary f= new FileLibrary();
		String name = f.readDataFromExcelFile("Sheet1", 3, 1);
		System.out.println(name);
		tp.getCustomerName().sendKeys(name);
		String description = f.readDataFromExcelFile("Sheet1", 4, 2);
		tp.getCustomerDescription().sendKeys(description);
		tp.getCreateCustomer().click();
		
	}
}
