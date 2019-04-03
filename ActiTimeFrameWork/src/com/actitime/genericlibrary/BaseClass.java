package com.actitime.genericlibrary;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.actitime.Object_RespositoryLib.HomePage;
import com.actitime.Object_RespositoryLib.LoginPage;

public class BaseClass {
	public static WebDriver driver ;
	public static FileLibrary fLib= new FileLibrary();
	 @BeforeSuite
		public void configBeforeSuit()
		{
			System.out.println("Connect to DataBase");
		}
		@BeforeClass
		public void configBeforeClass() throws Throwable
		{
			//get browser data from Property File
			String browserName=fLib.getPropertyKeyValue("browser");
			System.out.println(browserName);
			if(browserName.equals("firefox"))
			{
				driver=new FirefoxDriver();
				
			}
			else if (browserName.equals("chrome"))
			{
				 driver=new ChromeDriver();
				//Use below syntax when we dont have browser server
				//System.setProperty("Webdriver.chrome.driver", "./chromedriver.exe");
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			}
		@BeforeMethod
		public void configBeforeMethod() throws Throwable
		
		{
			String URL= fLib.getPropertyKeyValue("url");
			String USER= fLib.getPropertyKeyValue("username");
			String PASSWORD= fLib.getPropertyKeyValue("password");
			driver.get(URL);
			LoginPage ip= PageFactory.initElements(driver, LoginPage.class);
			ip.loginToApp(USER, PASSWORD);
			Thread.sleep(2000);
			
		}
		@AfterMethod
		public void confifAfterMethod() throws Throwable
		
		{
			Thread.sleep(2000);
			HomePage hp= PageFactory.initElements(driver, HomePage.class);
			hp.logout();
			
		}
		@AfterClass
		public void configAfterClass() throws Throwable
		
		{
			Thread.sleep(3000);
			System.out.println("Close Browser");
			driver.close();
		}

}
