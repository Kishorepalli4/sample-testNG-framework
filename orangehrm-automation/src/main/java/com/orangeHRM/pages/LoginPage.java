package com.orangeHRM.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

public class LoginPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public LoginPage(WebDriver  driver){
		this.driver= driver;
		wait= new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	
	public void waitForPageload() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));		
	}
	
	
	public void enterUsername(String username) {
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
	}
	
	public void enterPassword(String password) {
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
	}
	
	public void clickLogin() {
		driver.findElement(By.xpath("//button[@type='submit']")).submit();
		
	}

}
