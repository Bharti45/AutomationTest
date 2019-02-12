package com.crm.objectrepositoryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.crm.genericLib.BaseClass;

public class Home extends BaseClass
{
   // Initialization (Store all the WebElements Using @FindBy


   @FindBy(xpath="//a[contains(text(),'Home')]")
   private WebElement homePageVer;
   
   
   @FindBy(linkText="Organizations")
   private WebElement orgLink;
   
   @FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
   private WebElement logoutImg;
   
   @FindBy(xpath="//a[text()='Sign Out']")
   private WebElement signOutLink;
   
   
   //Utilization

   public WebElement getHomePageVer()
   {
	   return homePageVer;
	   
   }
   
   public void navigateToOrganization()
   {
	   orgLink.click();
   }
   
   public void logout()
   {
	  
       
       Actions act= new Actions(driver);
       act.moveToElement(logoutImg).perform();
	       
       signOutLink.click();
       
       // Verification: "Login" Page Should Be Displayed
       Login l = PageFactory.initElements(driver, Login.class);
       WebElement wbv5= l.getLoginPageVer();
       Assert.assertTrue(wbv5.isDisplayed());
       Reporter.log("Login page is displayed",true);

      
   }
 
}
