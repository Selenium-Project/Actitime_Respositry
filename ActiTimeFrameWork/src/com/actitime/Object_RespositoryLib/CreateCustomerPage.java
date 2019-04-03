package com.actitime.Object_RespositoryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateCustomerPage {
@FindBy(id="customerLightBox_nameField")
private WebElement customerNameEdit;

@FindBy(id="customerLightBox_descriptionField")
private WebElement customerDescriptionEdit;
@FindBy(xpath="//span[text()='Create Customer']")
private WebElement createCustomerButton;
//Overloading Concept
public void createCustomer(String customerName)
{
	customerNameEdit.sendKeys(customerName);
	createCustomerButton.click();
	
}
public void createCustomer(String customerName,String description)
{
	customerNameEdit.sendKeys(customerName);
	customerDescriptionEdit.sendKeys(description);
	createCustomerButton.click();
	
}

}
