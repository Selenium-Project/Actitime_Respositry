package TestScriptForCreateCustomer;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.Object_RespositoryLib.CreateCustomerPage;
import com.actitime.Object_RespositoryLib.HomePage;
import com.actitime.Object_RespositoryLib.TaskList;
import com.actitime.genericlibrary.BaseClass;
@Listeners(com.actitime.genericlibrary.ListenerTest.class)
public class CreateCustomerTest extends BaseClass {
	@Test
	public void createCustomerTest() throws Throwable
	{
		//Step1 Read Data from Excel File
		String customerName = fLib.getExcelData("Sheet1", 1, 1);
		//Step2 Click On TaskPage from HomePage
		HomePage hp=PageFactory.initElements(driver, HomePage.class);
		hp.navigateToTaskPage();
		//Step3 Navigate CreateCustomer Page
		TaskList t1= PageFactory.initElements(driver, TaskList.class);
		t1.navigateToCreateCustomerNewPage();
		//Step4 create new customer
		CreateCustomerPage cp= PageFactory.initElements(driver, CreateCustomerPage.class);
		cp.createCustomer(customerName);
		//Step Verify
		String actualCustomerName=t1.getCustomerVerificationName().getText();
		Thread.sleep(2000);
		Assert.assertEquals(actualCustomerName, customerName);
	}
	@Test
	public void createCustomerWithDescription() throws Throwable
	{
		String customerName = fLib.getExcelData("Sheet1", 2, 1);
		String customerDesc= fLib.getExcelData("Sheet1", 2, 2);
		//Step2 Click On TaskPage from HomePage
		HomePage hp=PageFactory.initElements(driver, HomePage.class);
		hp.navigateToTaskPage();
		//Step3 Navigate CreateCustomer Page
		TaskList t1= PageFactory.initElements(driver, TaskList.class);
		t1.navigateToCreateCustomerNewPage();
		//Step4 create new customer
		CreateCustomerPage cp= PageFactory.initElements(driver, CreateCustomerPage.class);
		cp.createCustomer(customerName, customerDesc);
		//Step Verify
		String actualCustomerName=t1.getCustomerVerificationName().getText();
		Assert.assertEquals(actualCustomerName, customerName);
		
	}

}
