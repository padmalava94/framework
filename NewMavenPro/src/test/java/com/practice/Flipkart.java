package com.practice;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Flipkart {

	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "E:\\jars\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("https://flipkart.com"); 
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='_2ISNhP _3AOFWO']/div/button")).click();
		Thread.sleep(2000);
		WebElement scrl_up_to=driver.findElement(By.xpath("//img[@class='_2VeolH _3I5S6S' and @alt='TV-WL-X3-VuTvs']"));
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",scrl_up_to);
		Thread.sleep(2000);
		scrl_up_to.click();
		
		Thread.sleep(5000);
		WebElement tv_to_buy=driver.findElement(By.xpath("//img[@alt='Vu Official Android 140cm (55 inch) Ultra HD (4K) LED Smart TV']"));
		JavascriptExecutor js1 = (JavascriptExecutor)driver;
		js1.executeScript("arguments[0].scrollIntoView(true);",tv_to_buy);
		Thread.sleep(2000);
		tv_to_buy.click();
		
		Set<String>handles=driver.getWindowHandles();
		
		Iterator<String>itr=handles.iterator();
		
		String home_tab=itr.next();
		String new_tab=itr.next();
		
		driver.switchTo().window(new_tab);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='pincodeInputId']")).sendKeys("752001");
		driver.findElement(By.xpath("//span[text()='Check']")).click();
		Thread.sleep(1000);
		
		WebElement tik_mark=driver.findElement(By.xpath("//div[@class='col col-1-12']/img"));
		boolean check=tik_mark.isDisplayed();
		Assert.assertTrue(check);
		
		driver.findElement(By.xpath("//li[@class='col col-6-12']/button")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class='_2AkmmA _14O7kc mrmU5i']")).click();
		driver.switchTo().window(home_tab);
		
	}

}
