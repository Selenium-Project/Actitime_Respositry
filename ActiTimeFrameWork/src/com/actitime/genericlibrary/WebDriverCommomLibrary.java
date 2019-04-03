package com.actitime.genericlibrary;

import java.util.concurrent.TimeUnit;

public class WebDriverCommomLibrary extends BaseClass {
	public void waitForPageToLoad()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	
	     

}
