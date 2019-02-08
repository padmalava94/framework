package com.practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindCoOrdinates {

	public static void main(String[] args) throws AWTException, InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "E:\\jars\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		//driver.get("https://google.com");
		
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.manage().window().setPosition(new Point(-2000, 0));
		//driver.manage().window().maximize();
		
		/*Robot rob= new Robot();
		
		rob.keyPress(KeyEvent.VK_WINDOWS);
		rob.keyPress(KeyEvent.VK_DOWN);*/
		
		WebElement ele=driver.findElement(By.xpath("//*[contains(text(),'Images')]"));
		
		Point point=ele.getLocation();
		int xcord=point.getX();
		int ycord=point.getY();
		System.out.println("x cord="+xcord+ ","+"ycord="+ycord);
		
		/*Robot r= new Robot();
		r.mouseMove(1164, 19);
		//r.mouseMove((int) 125.75,	36);
		r.mousePress(InputEvent.BUTTON1_MASK);
		r.mouseRelease(InputEvent.BUTTON1_MASK);*/
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("el=document.elementFromPoint(1164,19);el.click();");
		
		
		
		
		

	}

}
