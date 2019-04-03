package com.actitime.Object_RespositoryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	@FindBy(name="username")
	private WebElement userNameEdit;
	@FindBy(name="pwd")
	private WebElement passwordEdit;
	@FindBy(id="loginButton")
	private WebElement loginButtonEdit;
	public WebElement getUserNameEdit() {
		return userNameEdit;
	}
	public WebElement getPasswordEdit() {
		return passwordEdit;
	}
	public WebElement getLoginButtonEdit() {
		return loginButtonEdit;
	}
	
public void loginToApp(String username,String password)
{
	userNameEdit.sendKeys(username);
	passwordEdit.sendKeys(password);
	loginButtonEdit.click();
}

}
