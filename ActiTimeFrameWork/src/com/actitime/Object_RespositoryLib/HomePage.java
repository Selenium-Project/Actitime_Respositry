package com.actitime.Object_RespositoryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	@FindBy(xpath="//a[@class='content tasks']")
	private WebElement taskImage;
	
	@FindBy(xpath="//div[text()='USERS']")
	private WebElement userImage;
	
	@FindBy(xpath="//a[@class='logout']")
	private WebElement logoutLink;
	
	//Business Logics
	public void navigateToTaskPage()
	{
		taskImage.click();
	}
	public void navigateToUserPage()
	{
		userImage.click();
	}
	public void logout()
	{
		logoutLink.click();
	}
	

}
