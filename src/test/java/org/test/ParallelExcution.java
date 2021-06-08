package org.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParallelExcution {
static WebDriver driver;
@BeforeClass
public static void launch(){
	
	System.setProperty("webdriver.chrome.driver", "E:\\Eclipse\\Browser\\lib\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.get("https://www.facebook.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);	
}
@Test(dataProvider="sanity")
public void test1(String s1,String s2)
{
	driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
	driver.findElement(By.id("email")).sendKeys(s1);
	driver.findElement(By.id("pass")).sendKeys(s2);

}
@Test(dataProvider="sanity")
public void test2(String s3,String s4)
{
	driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
	driver.findElement(By.id("email")).sendKeys(s3);
	driver.findElement(By.id("pass")).sendKeys(s4);

}
@DataProvider(name="sanity")
public static Object[][]data(){
	return new Object[][] {{"ruban","12345"},
		                   {"kumar","45678"},
		                    {"raj","45672"},{"kishore","45236"}};
	
	
}
@AfterClass
public static void quit() {
	driver.quit();
	
}
}
