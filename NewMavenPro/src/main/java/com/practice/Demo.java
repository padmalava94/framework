package com.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Demo {

	public static void main(String[] args) throws Exception {
		
		
		System.setProperty("webdriver.chrome.driver", "E://jars//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.stakers.com/en/");
		driver.findElement(By.xpath("//button[text()='Change']")).click();
		
		Thread.sleep(2000);
		//driver.findElement(By.id("registerEmail")).sendKeys("abc@gmail.com");

		driver.findElement(By.xpath("//li[@data-value='UK']/span")).click();
		
		
		driver.navigate().to("https://www.casimba.com/create-account/personal-details");
		Thread.sleep(7000);
		
		Select country= new Select(driver.findElement(By.xpath("//lib-input-country/div/select")));
		
		country.selectByIndex(1);
	}

}
