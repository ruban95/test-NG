package org.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowsere {
	static WebDriver driver;
	@Parameters({"browsername"})
    @Test
	public void fb(String name) {
		if(name.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "E:\\Eclipse\\Browser\\lib\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(name.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "E:\\Eclipse\\Browser\\lib\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("no match found");
		}
		
			driver.get("https://www.facebook.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(3000,	TimeUnit.SECONDS);	
		    driver.findElement(By.id("email")).sendKeys("rubankumar48@gmail.com");
		    driver.findElement(By.id("pass")).sendKeys("Bharathi48");
	}
}	


