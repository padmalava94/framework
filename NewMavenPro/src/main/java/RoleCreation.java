import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RoleCreation {
	
	
	WebDriver driver;
	@BeforeSuite
	public void LaunchApp() {
		
		System.setProperty("webdriver.chrome.driver","E:\\\\jars\\\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://srssprojects.in/home.aspx");
		
	}
	@BeforeMethod()
	//@Parameters({"username","password"})
	public void AdminLogin() throws InterruptedException {
		
		driver.findElement(By.name("txtuId")).sendKeys("Admin");
		driver.findElement(By.name("txtPword")).sendKeys("Admin");
		driver.findElement(By.name("login")).click();
		Thread.sleep(2000);
		
	}
	
	/*@DataProvider
	public Object[][] Getdata() {
		Object obj[][]=new Object[2][2];
		
		obj[0][0]="Padmanav";
		obj[0][1]=1;
		
		obj[1][0]="debansh";
		obj[1][1]=1;
		
		return obj;
	}
	*/
	
	@DataProvider
	public Iterator<Object[]> getdata() throws IOException {
		
		ArrayList<Object[]>mydata=new ArrayList<Object[]>();
		
		String path="E:\\workspacenew\\Restapitesting\\src\\main\\java\\com\\role\\test\\Roles.xlsx";
		FileInputStream fis= new FileInputStream(path);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = wb.getSheet("Rdata");
		int last_row=sheet.getLastRowNum();
		
		for(int i=1 ;i<=last_row; i++ ) {
			
			XSSFRow rows = sheet.getRow(i);
			
			XSSFCell cell01 = rows.getCell(0);
			XSSFCell cell02 = rows.getCell(1);
			
			String rolename=cell01.getStringCellValue();
			String roletype=cell02.getStringCellValue();
			
			mydata.add(new Object[] {rolename,roletype});
			

			
		}

		return mydata.iterator();
	}
	
	
	@Test(dataProvider="getdata")
	public void RoleCreation(String Rname,String Rtype) throws InterruptedException {
		
		driver.findElement(By.xpath(".//*[@id='Table_01']/tbody/tr[2]/td/table/tbody/tr[4]/td/a/img")).click();
		driver.findElement(By.xpath(".//*[@id='btnRoles']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='txtRname']")).sendKeys(Rname);
		
		Thread.sleep(1000);
		
		Select roletype = new Select(driver.findElement(By.xpath(".//*[@id='lstRtypeN']")));
		roletype.selectByVisibleText(Rtype);
		
		driver.findElement(By.xpath(".//*[@id='btninsert']")).click();
		Thread.sleep(2000);
		
		driver.switchTo().alert().accept();
		
	}

	@AfterMethod
	public void Adminlogout() {
		
		driver.findElement(By.xpath(".//*[@id='Table_01']/tbody/tr/td[3]/a/img")).click();
		
	}
	@AfterSuite
	public void TearDown() {
		driver.quit();
		
	}

}
