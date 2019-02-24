package com.shoppingPortal;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestcaseProduct {

	WebDriver driver;

	@BeforeMethod
	public void setup() {
		// Launch Application
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver(); // Launch

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(3000, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);

		driver.get("https://www.bigbasket.com");
	}

	@Test(priority=1)
	public void searchitem() {
		driver.findElement(By.xpath("//input[@class='form-control ng-pristine ng-untouched ng-valid ng-empty']"))
				.sendKeys("sugar");
	}

	@Test(priority=2,dependsOnMethods="searchitem")
	public void getitem() {
		driver.findElement(By.xpath("//button[@class='btn btn-default bb-search']")).click();

	}

	@Test(priority=3,dependsOnMethods="getitem")
	public void launchitem() {
		driver.findElement(By.linkText("Refined Sugar")).click();
	}

	@Test(priority=4,dependsOnMethods="launchitem")
	public void addbasket() {
		driver.findElement(By.xpath("//button[@class='fade sc-bbmXgH cEBnvi']")).click();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
