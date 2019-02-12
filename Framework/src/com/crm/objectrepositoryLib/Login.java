package com.crm.objectrepositoryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login 
{
	// Initialization (Store all the WebElements Using @FindBy
	
	@FindBy(xpath="//a[text()='vtiger']")
	private WebElement loginPageVer;
	
	@FindBy(name="user_name")
	private WebElement userNameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	
	
	//Utilization
	
	public WebElement getLoginPageVer() {
		return loginPageVer;
	}



	public WebElement getUserNameEdt() {
		return userNameEdt;
	}



	public WebElement getPasswordEdt() {
		return passwordEdt;
	}



	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public void login(String userName, String password)
	{
		userNameEdt.sendKeys(userName);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}
}
