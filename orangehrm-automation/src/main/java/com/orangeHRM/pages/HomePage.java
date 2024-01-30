package com.orangeHRM.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

public class HomePage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		wait= new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public void waitForPageload() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='client brand banner']")));
		
	}
	
	
	public void clickAdminButton() {
		driver.findElement(By.xpath("//span[text()='Admin']")).click();
	}
	
	public void clickPIMButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='PIM']")));
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
	}

	public void clickLeaveButton() {
		driver.findElement(By.xpath("//span[text()='Leave']")).click();
	}

	public void clickTimeButton() {
		driver.findElement(By.xpath("//span[text()='Time']")).click();
	}

	
	public void clickRecruitmentButton() {
		driver.findElement(By.xpath("//span[text()='Recruitment']")).click();
	}

	
	public void clickMyInfoButton() {
		driver.findElement(By.xpath("//span[text()='My Info']")).click();
	}

	public void clickPerformanceButton() {
		driver.findElement(By.xpath("//span[text()='Performance']")).click();
	}
	
	public void clickDashboardButton() {
		driver.findElement(By.xpath("//span[text()='Dashboard']")).click();
	}
	
	public void clickDirectoryButton() {
		driver.findElement(By.xpath("//span[text()='Directory']")).click();
	}
	
	public void clickMaintenanceButton() {
		driver.findElement(By.xpath("//span[text()='Maintenance']")).click();
	}
	
	public void clickClaimButton() {
		driver.findElement(By.xpath("//span[text()='Claim']")).click();
	}
	
	public void clickBuzzButton() {
		driver.findElement(By.xpath("//span[text()='Buzz']")).click();
	}
	

	

}
