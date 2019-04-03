package screenshotTest;

import java.io.File;

import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

import com.actitime.genericlibrary.BaseClass;

public class GetScreenShotForFailedTestScript extends BaseClass {

	@Test
	public void validationOfCustomer() throws InterruptedException, Throwable
	{
		EventFiringWebDriver fDriver=new EventFiringWebDriver(driver);
		File srcImg = fDriver.getScreenshotAs(OutputType.FILE);
		File dstFile=new File("./Screen/test.png");
		
		FileUtils.copyFile(srcImg, dstFile);
		
	    Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[text()='TASKS']/..")).click();
		driver.findElement(By.xpath("//div[text()='Add New']")).click();
		driver.findElement(By.xpath("//div[@class='item createNewCustomer ellipsis']")).click();
		driver.findElement(By.xpath("//input[@id='customerLightBox_nameField']")).sendKeys("PanjabBank0_1");
		driver.findElement(By.xpath("//span[text()='Create Customer']")).click();
		
	}
}
