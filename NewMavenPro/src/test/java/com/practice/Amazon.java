package com.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "E:\\jars\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("https://amazon.com");
		WebElement search_box=driver.findElement(By.xpath("//input[@name='field-keywords']"));
		search_box.sendKeys("Sony Xperia");
		String value =search_box.getAttribute("value");
		System.out.println(value);
	

	}

}
