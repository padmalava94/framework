package com.practice;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {

	public static void main(String[] args)
	{
		
		System.setProperty("webdriver.chrome.driver", "E:\\jars\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
		driver.get("https://www.hdfcbank.com/");
		
		System.out.println("Parent window title : "+driver.getTitle());
		driver.findElement(By.xpath("//div[contains(text(),'NetBanking')]")).click();
		
		driver.findElement(By.xpath("//li[@id='netbanking']")).click();
		driver.findElement(By.xpath("//a[@id='loginsubmit']")).click();
		
		Set<String>handles=driver.getWindowHandles();
		
		Iterator<String>itr=handles.iterator();
		
		String parent_window=itr.next();
		String child_window=itr.next();
		
		driver.switchTo().window(child_window);
		System.out.println("Child window title : "+driver.getTitle());
		//driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[@class='container']/div/a[contains(text(),'Continue to NetBanking')]")).click();
		
		System.out.println("login page title :"+driver.getTitle());
		
		driver.switchTo().window(parent_window);
		//System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//a[text()='Customer Care']")).click();
		
		
	}
}
