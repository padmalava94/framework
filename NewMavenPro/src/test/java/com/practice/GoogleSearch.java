package com.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "E:\\jars\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://google.com");
		
		driver.findElement(By.name("q")).sendKeys("selenium");
		Thread.sleep(2000);
		driver.findElement(By.name("btnK")).click();
		
		List<WebElement>links=driver.findElements(By.xpath("//*[contains(text(),'https://')]"));
		

		for(WebElement ele:links){
			System.out.println(ele.getText());
		}
		
		
	}

}
