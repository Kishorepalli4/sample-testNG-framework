package com.orangeHRM.tests;

import java.io.File;
import java.io.IOException;
import java.time.Instant;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.io.Files;
import com.orangeHRM.pages.HomePage;
import com.orangeHRM.pages.PIMpage;

public class Test2_AddEmployee extends Test1_Login {
	
	@DataProvider
	public Object[][] sampleData(){
		Object[][] data = new Object[3][4];
		
		data[0][0]="Chandler";data[0][1]="Bing";data[0][2]="Chandler06";data[0][3]="Test@01221234";
		data[1][0]="Joey";data[1][1]="Tribbiani";data[1][2]="Tribbiani05";data[1][3]="Test@01221234";
		data[2][0]="Ross";data[2][1]="Geller";data[2][2]="RossGeller06";data[2][3]="Test@01221234";
		return data;
		
	}
	
	
	@Test(dataProvider = "sampleData")
	//@Parameters({"empFirstName", "empLastName", "empUserName", "empPassword"})
	public void addEmployee(String empFirstName, String empLastName, String empUserName, String empPassword)  {
		HomePage homePage = new HomePage(driver);
		homePage.waitForPageload();
		homePage.clickPIMButton();
		
		System.out.println("Working with data: " + empFirstName + " " + empLastName);
		PIMpage pagePIM = new PIMpage(driver);
		pagePIM.clickAdd();
		pagePIM.enterFirstname(empFirstName);
		pagePIM.enterLastname(empLastName);
		pagePIM.clickCreateLoginSwitch();
		pagePIM.enterUsername(empUserName);
		pagePIM.enterPassword(empPassword);
		pagePIM.enterConfirmPassword(empPassword);
		pagePIM.clickAddEmployeeSave();
		System.out.println("Employee name is " + pagePIM.fetchEmployeeName());
	}
	
	@AfterMethod
	public void takeScreenshot(ITestResult testResult) {
		if(ITestResult.FAILURE == testResult.getStatus()) {
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File source = screenshot.getScreenshotAs(OutputType.FILE);
			
			Instant timestamp = Instant.now();
			String baseDir = System.getProperty("user.dir");
	        String screenshotsDir = baseDir + File.separator + "test-output" + File.separator + "screenshots";
	        String filePath = screenshotsDir + File.separator + "Error_screen_"+ timestamp.toString().replaceAll(":","-")
	        			+ ".png";
	        System.out.println(filePath);
	        
			File destination = new File(filePath);
			
			try {
				Files.copy(source, destination);
			}
			catch(IOException e ) {
				System.out.println("I/O exception when copying file");
				e.printStackTrace();
				
			}
		}	
	}
	
	
	
	@AfterClass
	public void teardownBrowser() {
		driver.quit();
	}

}
