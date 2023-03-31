
package com.ActiTime.GenericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.ActiTime.POM.LoginPage;

public class BaseClass {
	
	public WebDriver driver;
	FileLibrary f= new FileLibrary();
	@BeforeSuite
	public void databaseConnection() {
		Reporter.log("Database Connected Successfully", true);
	}
	
	
	@AfterSuite
	public void databaseDisconnection() {
		Reporter.log("Database Disconnected Successfully", true);
	}
	
	
	@BeforeClass
	public void LaunchBrower() throws IOException {
		ChromeOptions option= new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		driver= new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		f= new FileLibrary();
		String url = f.readDataFromProperty("url");
		driver.get(url);
		Reporter.log("Launched Browser", true);
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.close();
		Reporter.log("Browser Closed", true);
	}
		
	
	@BeforeMethod
	public void Login() throws IOException {
		String un = f.readDataFromProperty("username");
		String pwd = f.readDataFromProperty("password");
		
		LoginPage lp= new LoginPage(driver);
		lp.getUbtx().sendKeys(un);
		lp.getPwtbx().sendKeys(pwd);
		lp.getLgbtn().click();
		Reporter.log("Login Successfully", true);
			
			
	}
	
	
	
}
