package com.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Fb {

	
	WebDriver driver;
	@BeforeMethod
	public void openapp(){
		
		System.setProperty("webdriver.chrome.driver", "E://jars//chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get("https://fb.com");
		
	}
	@Test(dataProvider="setdata")
	public void Login(String mob_no,String password){
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(mob_no);
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(password);
		driver.findElement(By.id("u_0_2")).click();
	}
	@DataProvider
	public Iterator<Object[]> setdata() throws IOException{
		
		ArrayList<Object[]>Al=new ArrayList<Object[]>();
		String path="C:\\Users\\Bapi\\git\\framework\\NewMavenPro\\src\\test\\java\\testdata\\fb.xlsx";
		FileInputStream fis=new FileInputStream(path);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet("fblogin");
		int last_row=sheet.getLastRowNum();
		
		for(int i=1 ; i<=last_row ;i++){
			
			XSSFRow row = sheet.getRow(i);
			
			XSSFCell cell0=row.getCell(0);
			XSSFCell cell1=row.getCell(1);
			
			String mobno=cell0.getStringCellValue();
			String password=cell1.getStringCellValue();
			
			Object[] obj={mobno,password};
			Al.add(obj);
			
		}
		
		return Al.iterator();
	}
	
	@AfterMethod
	public void teardown(){
		
		driver.close();
		
	}
}
