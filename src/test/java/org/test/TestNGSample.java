package org.test;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGSample {
	static WebDriver driver;
	@BeforeClass
	public static void launch()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Eclipse\\Browser\\lib\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000,	TimeUnit.SECONDS);
		
	}
	@BeforeMethod
	public void startTime()
	{
		Date d= new Date();
		System.out.println(d);
		
	}
	@AfterMethod
	public void endTime() {
		Date d =new Date();
		System.out.println(d);
		
	}
	@AfterClass
	public static void closs()
	{
		driver.quit();
	}
	@Parameters({"username","password"})
	@Test
	public void fb(String user,String pass) {
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);	
		driver.findElement(By.id("email")).sendKeys(user);
		driver.findElement(By.id("pass")).sendKeys(pass);
	}
}	
/*	@Test
	public void fb2()
{
		driver.findElement(By.id("pass")).sendKeys("Bharathi95");
		}
}*/
