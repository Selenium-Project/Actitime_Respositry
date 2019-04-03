package listener;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.actitime.genericlibrary.BaseClass;

public class ListenerTest implements ITestListener {

	@Override
	public void onTestStart(ITestResult res) {
		String failedTestName= res.getMethod().getMethodName();
		EventFiringWebDriver eDriver=new EventFiringWebDriver(BaseClass.driver);
		File scrImg= eDriver.getScreenshotAs(OutputType.FILE);
		File dest= new File("./screenshot1/"+failedTestName+".png");
		try {
			FileUtils.copyFile(scrImg,dest);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	

}