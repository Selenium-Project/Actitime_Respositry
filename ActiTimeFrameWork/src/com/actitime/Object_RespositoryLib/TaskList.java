package com.actitime.Object_RespositoryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TaskList {
	@FindBy(xpath="//div[text()='Add New']")
	private WebElement addNewButton;
	@FindBy(xpath="//div[@class='item createNewCustomer ellipsis']")
	private WebElement newCustomerButton;
	
	//Xpath for verification of create customer
	@FindBy(xpath="//div[@class='navigationLinks']/following-sibling::div[1][@class='title ellipsis']")
	private WebElement CustomerVerificationName;

	public WebElement getCustomerVerificationName() {
		return CustomerVerificationName;
	}
	public void navigateToCreateCustomerNewPage()
	{
		addNewButton.click();
		newCustomerButton.click();
	}
	
	
	
	

}
