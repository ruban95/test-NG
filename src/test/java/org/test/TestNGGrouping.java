package org.test;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGGrouping {
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
	@Test
	public void test1() {
		
		System.out.println("test1");

}
	@Test(groups={"testrun"})
	public void test2() {
		
		System.out.println("test2");

}
	@Test
	public void test3() {
		
		System.out.println("test3");

}
	@Test(groups={"testrun"})
	public void test4() {
		
		System.out.println("test4");

}
	@Test
	public void test5() {
		
		System.out.println("test5");

}
	@Test
	public void test6() {
		
		System.out.println("test6");

}
	@Test(groups={"testrun"})
	public void test7() {
		
		System.out.println("test7");

}
}

