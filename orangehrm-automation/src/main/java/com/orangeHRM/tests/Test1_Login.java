package com.orangeHRM.tests;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.orangeHRM.pages.LoginPage;

public class Test1_Login {
	
	protected WebDriver driver;
	private WebDriverWait wait; 
	
	@BeforeClass
	public void browserSetup() {
		driver= new ChromeDriver();	
	}
	
	
	@AfterClass
	public void teardownBrowser() {
		//driver.quit();
	}
	
	
	@Test
	@Parameters({"loginUserName", "loginPassword"})
	public void loginTest(String userName, String password) {
		LoginPage login = new LoginPage(driver);
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		System.out.println("Webpage title is " + driver.getTitle());
		System.out.println("Username and password are  " + userName + " , " + password);		
		
		login.waitForPageload();
		login.enterUsername(userName);
		login.enterPassword(password);
		login.clickLogin();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='client brand banner']")));	
	}
	
	

}
