package com.orangeHRM.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PIMpage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public PIMpage(WebDriver driver) {
		this.driver= driver;
		wait= new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public void clickAdd() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='orangehrm-header-container'])//button")));		
		driver.findElement(By.xpath("(//div[@class='orangehrm-header-container'])//button")).click();
	}
	
	public void enterFirstname(String firstName) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstName")));
		driver.findElement(By.name("firstName")).sendKeys(firstName);
	}
	
	public void enterMiddleName(String middleName) {
		driver.findElement(By.name("middleName")).sendKeys(middleName);
	}
	
	public void enterLastname(String lastName) {
		driver.findElement(By.name("lastName")).sendKeys(lastName);
	}
	
	public void clickCreateLoginSwitch() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='oxd-form-row user-form-header'])//span")));
		driver.findElement(By.xpath("(//div[@class='oxd-form-row user-form-header'])//span")).click();
	}
	
	public void enterUsername(String userName) {
		driver.findElement(By.xpath("(//label[.='Username'])//..//..//input")).sendKeys(userName);
	}
	
	public void enterPassword(String password) {
		driver.findElement(By.xpath("(//label[.='Password'])//..//..//input"))
						.sendKeys(password);
	}
	
	public void enterConfirmPassword(String confirmPassword) {
		driver.findElement(By.xpath("(//label[.='Confirm Password'])//..//..//input")).sendKeys(confirmPassword);
	}
	
	public void clickAddEmployeeSave() {
		driver.findElement(By.xpath("//button[.=' Save ']")).click();
	}
	
	public String fetchEmployeeName() {
		By membership= By.xpath("//a[.='Memberships']");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//h6[text()='Add Employee']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(membership));

		return driver.findElement(By.xpath("//input[@placeholder='First Name']")).getAttribute("value");
		
	}
	
	
}
