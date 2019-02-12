package com.crm.organization;
/*
 * @author: Bharti
 */

import java.io.IOException;
import java.util.Random;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;


//TC_01

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.genericLib.BaseClass;
import com.crm.objectrepositoryLib.CreateOrganization;
import com.crm.objectrepositoryLib.Home;
import com.crm.objectrepositoryLib.Organization;
@Listeners(com.crm.genericLib.ListenerImpClass.class)

public class CreateOrganisation extends BaseClass

{
	@Test
	public void createCustomerTest() throws Throwable, InvalidFormatException, IOException
	{		
	    // Test Data
		Random r= new Random();
	    String orgName= fLib.getExcelData("Sheet1", 1, 0)+ r.nextInt(100);
		SoftAssert s= new SoftAssert();
		
		// Verification: Home page should be displayed
	    Home hp= PageFactory.initElements(driver, Home.class);
		WebElement wbv2= hp.getHomePageVer();
		s.assertTrue(wbv2.isDisplayed());
		Reporter.log("Home Page is Displayed",true);
		
	   // Place the mouse cursor on the "Organization" button and click on it
	      hp.navigateToOrganization();
	   	        
	   // Verification: Organization" Page should be displayed
          Organization org = PageFactory.initElements(driver, Organization.class);
	      WebElement wbv3= org.getOrgPageVer();
          s.assertTrue(wbv3.isDisplayed());
          Reporter.log("Organization Page is Displayed");
	        
      // Place the mouse cursor on "+" symbol and click on it to create new organization
          org.navigateToCreateOrganization();

	  // Verification: "Creating New Organization" Page should be displayed
          CreateOrganization cOrg = PageFactory.initElements(driver, CreateOrganization.class);
          WebElement wbv4= cOrg.getCreateNewOrgVer();
          s.assertTrue(wbv4.isDisplayed());
          Reporter.log("Create new organization page is Displayed");
        	
        	
       // Create an organization with mandatory fields
          cOrg.createOrganization(orgName);
      	             
	   //  Verification:Organization should be created
	      String expmsg1= fLib.getExcelData("Sheet1", 7, 0);
	      String actmsg1= cOrg.getCreateNewOrgVer().getText();
	        
	      Assert.assertTrue(actmsg1.contains(expmsg1));
	      Reporter.log("Organization Created Successfully ==> Pass");
	     
	        s.assertAll();    

	      
	   /*  Navigate to Organization Page & delete organization
	      hp.navigateToOrganization();
	      org.deleteOrganization(orgName);
	        
	  //  Verification of Deleted Object
	      org.getSrcOrg().sendKeys(orgName);
	      WebElement wbd= org.getSrcDropDown();	          
	      Select sel= new Select(wbd);
	      
	      String srcDropDown = fLib.getExcelData("Sheet1", 9, 0);

	      sel.selectByVisibleText(srcDropDown);
	      org.getSrcBtn().click();
	    */  
	      
	         
	}

	@Test
	public void createOrganizationWithTypeFieldTest() throws Throwable
	{
		String orgName= fLib.getExcelData("Sheet1", 1, 0);
	    String accttype= fLib.getExcelData("Sheet1", 1, 7);
		SoftAssert s= new SoftAssert();
		
	 
	 	// Verification: Home page should be displayed
		    Home hp= PageFactory.initElements(driver, Home.class);
			WebElement wbv2= hp.getHomePageVer();
			s.assertTrue(wbv2.isDisplayed());
			Reporter.log("Home Page is Displayed",true);
			
	// Place the mouse cursor on the "Organization" button and click on it
	      hp.navigateToOrganization();
	        
   //  Verification: Organization" Page should be displayed
	      Organization org = PageFactory.initElements(driver, Organization.class);
	      WebElement wbv3= org.getOrgPageVer();
          s.assertTrue(wbv3.isDisplayed());
          Reporter.log("Organization Page is Displayed",true);

	        
   //  Place the mouse cursor on "+" symbol and click on it to create new organization
          org.navigateToCreateOrganization();

   //  Verification: "Creating New Organization" Page should be displayed
           CreateOrganization cOrg = PageFactory.initElements(driver, CreateOrganization.class);
           WebElement wbv4= cOrg.getCreateNewOrgVer();
           s.assertTrue(wbv4.isDisplayed());
           Reporter.log("Create new organization page is Displayed", true);

	        	
   // Create an organization with mandatory details and select the type of organization from "Type" dropdown menu 
	       cOrg.createOrganization(orgName, accttype); 
	       
   //  Verification:Organization should be created with Selected Type Field
	        
	        String actval=cOrg.getcreateOrgVer2().getText();
	        Assert.assertTrue(accttype.contains(actval));
	        Reporter.log("Organization Created Successfully ==>Pass",true);
	        
	        s.assertAll();    

	      	                   
	}


	@Test
	public void createOrganizationWithAnnualRevenueTest() throws Throwable
	{
		
	// Test Data
	    String orgName= fLib.getExcelData("Sheet1", 1, 0);
		String anualRevn= fLib.getExcelData("Sheet1", 1, 8);
		SoftAssert s= new SoftAssert();

				
	// Verification: Home page should be displayed
	    Home hp= PageFactory.initElements(driver, Home.class);
		WebElement wbv2= hp.getHomePageVer();
		s.assertTrue(wbv2.isDisplayed());
		Reporter.log("Home Page is Displayed",true);
		
		
	//  Place the mouse cursor on the "Organization" button and click on it
	    hp.navigateToOrganization();
	        
     // Verification: Organization" Page should be displayed
	    Organization org = PageFactory.initElements(driver, Organization.class);
	    WebElement wbv3= org.getOrgPageVer();
        s.assertTrue(wbv3.isDisplayed());
        Reporter.log("Organization Page is Displayed",true);
	        	
     //  Place the mouse cursor on "+" symbol and click on it to create new organization
        org.navigateToCreateOrganization();

     //  Verification: "Creating New Organization" Page should be displayed
        CreateOrganization cOrg = PageFactory.initElements(driver, CreateOrganization.class);
        WebElement wbv4= cOrg.getCreateNewOrgVer();
        s.assertTrue(wbv4.isDisplayed());
        Reporter.log("Create new organization page is Displayed", true);

            
     //  Enter the mandatory fields,annual revenue and click on save button
        cOrg.createOrganizationAnnlRevn(anualRevn, orgName);

	        
     //  Verification: Organization should be created with Annual revenue
         String actval=cOrg.getCreateOrgVer3().getText();
	     Assert.assertTrue(actval.contains(anualRevn));
	        
	     Reporter.log("Organization with Annual Revenue is created successfully ==> Pass",true);
	        s.assertAll();    
  
	        
      
	}

	
	@Test
	public void createOrganizationwithAssignedToAsGroupTest() throws Throwable
	{
		
		// Test Data
		String orgName= fLib.getExcelData("Sheet1", 1, 0);
		String assignTo= fLib.getExcelData("Sheet1", 1, 9);
		SoftAssert s= new SoftAssert();
	
		
	// Verification: Home page should be displayed
	    Home hp= PageFactory.initElements(driver, Home.class);
		WebElement wbv2= hp.getHomePageVer();
		s.assertTrue(wbv2.isDisplayed());
		Reporter.log("Home Page is Displayed",true);
		
     // Place the mouse cursor on the "Organization" button and click on it
	    hp.navigateToOrganization();
	        
	 // Verification: Organization" Page should be displayed
	    Organization org = PageFactory.initElements(driver, Organization.class);
	    WebElement wbv3= org.getOrgPageVer();
        s.assertTrue(wbv3.isDisplayed());
        Reporter.log("Organization Page is Displayed",true);

	        
	// Place the mouse cursor on "+" symbol and click on it to create new organization
        org.navigateToCreateOrganization();

	//  Verification: "Creating New Organization" Page should be displayed
        CreateOrganization cOrg = PageFactory.initElements(driver, CreateOrganization.class);
        WebElement wbv4= cOrg.getCreateNewOrgVer();
        s.assertTrue(wbv4.isDisplayed());
        Reporter.log("Create new organization page is Displayed", true);

    //  Enter the mandatory fields and click on "Group" radio button in "Assigned To" block 
	    cOrg.createOrganizationAsGroup(orgName, assignTo);	        
	      
	        
	//  Verification:Organization should be created With Assigned To Group
	        
	    String actval= cOrg.getCrateOrgVer4().getText();
        Assert.assertTrue(actval.contains(assignTo));
        Reporter.log("Organization With Assigned to group is Successfully Created ==> Pass",true);
        s.assertAll();    
	}

	
	@Test
	public void  createOrganizationWithDescriptionTest() throws Throwable
	{
		
   // Test Data
	  String orgName= fLib.getExcelData("Sheet1", 1, 0);
	  String desc= fLib.getExcelData("Sheet1", 1, 10);
		SoftAssert s= new SoftAssert();

   	
   // Verification: Home page should be displayed
	  Home hp= PageFactory.initElements(driver, Home.class);
	  WebElement wbv2= hp.getHomePageVer();
	  s.assertTrue(wbv2.isDisplayed());
	  Reporter.log("Home Page is Displayed",true);
		
		
   // Place the mouse cursor on the "Organization" button and click on it
	   hp.navigateToOrganization();
	        
   //  Verification: Organization" Page should be displayed
	   Organization org = PageFactory.initElements(driver, Organization.class);
	   WebElement wbv3= org.getOrgPageVer();
       s.assertTrue(wbv3.isDisplayed());
       Reporter.log("Organization Page is Displayed",true);

	        
   // Place the mouse cursor on "+" symbol and click on it to create new organization
      org.navigateToCreateOrganization();

   // Verification: "Creating New Organization" Page should be displayed
      CreateOrganization cOrg = PageFactory.initElements(driver, CreateOrganization.class);
      WebElement wbv4= cOrg.getCreateNewOrgVer();
      s.assertTrue(wbv4.isDisplayed());
      Reporter.log("Create new organization page is Displayed", true);

   // Enter the mandatory fields,some description and click on Save Button
      cOrg.createOrgnizationDesc(orgName, desc);
	        
   // Verification: Organization should be created with description
	  String actval=cOrg.getCreateOrgVer5().getText();
	  Assert.assertTrue(actval.contains(desc));
      Reporter.log("Organization with Description is Created Successfully ==> Pass", true);
      s.assertAll();
	}

	
}
