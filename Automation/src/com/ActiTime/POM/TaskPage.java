package com.ActiTime.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskPage {
	
	//Declaration
	@FindBy(xpath= "//div[.='Add New']")
	private WebElement addnewbtn;
	
	@FindBy(xpath= "//div[.='+ New Customer']")
	private WebElement newCustomer;
	
	@FindBy(xpath="(//input[@placeholder='Enter Customer Name'])[2]")
	private WebElement customerName;
	
	@FindBy(xpath= "//textarea[@placeholder='Enter Customer Description']")
	private WebElement customerDescription;
	
	@FindBy(xpath= "//div[.='Create Customer']")
	private WebElement createCustomer;
	
	
	//Initialization
	public TaskPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	//Initialization
	public WebElement getAddnewbtn() {
		return addnewbtn;
	}


	public WebElement getNewCustomer() {
		return newCustomer;
	}


	public WebElement getCustomerName() {
		return customerName;
	}


	public WebElement getCustomerDescription() {
		return customerDescription;
	}


	public WebElement getCreateCustomer() {
		return createCustomer;
	}
	
	
}
