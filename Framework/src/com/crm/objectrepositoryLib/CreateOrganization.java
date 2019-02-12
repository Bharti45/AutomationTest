package com.crm.objectrepositoryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CreateOrganization 
{
   // Initialization (Store all the WebElements Using @FindBy

	@FindBy(name="accountname")
	private WebElement orgName;
	
	@FindBy(xpath="//input[@accesskey='S']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//span[text()='Creating New Organization']")
	private WebElement createNewOrgVer;
	
	@FindBy(xpath="//span[@class='dvHeaderText']/..")
	private WebElement createOrgVer1;
	
	@FindBy(id="mouseArea_Type")
	private WebElement createOrgVer2;
	
	@FindBy(name="accounttype")
	private WebElement acttype;
	
	@FindBy(name="annual_revenue")
	private WebElement annualRev;
	
	@FindBy(id="mouseArea_Annual Revenue")
	private WebElement createOrgVer3;
	
	@FindBy(name="//input[@value='T']")
	private WebElement radButton;
	
	@FindBy(name="assigned_group_id")
	private WebElement assignId;
	
	@FindBy(id="mouseArea_Assigned To")
	private WebElement createOrgVer4;
	
	@FindBy(name="description")
    private WebElement desc;
	
	@FindBy(id="mouseArea_Description")
	private WebElement createOrgVer5;
	
	//Utilization 
	
	public void createOrganization(String orgName1)
	{
		orgName.sendKeys(orgName1);
		saveBtn.click();
	}
	
	public void createOrganization(String orgName1, String acttype1)
	{
		orgName.sendKeys(orgName1);
        Select sel= new Select(acttype);
	    sel.selectByVisibleText(acttype1);
	    saveBtn.click();
	}
	
	public void createOrganizationAnnlRevn(String anualRevn1, String orgName1)
	{
		orgName.sendKeys(orgName1);
		annualRev.sendKeys(anualRevn1);;
	    saveBtn.click();	
	}
	
	
	public void createOrganizationAsGroup(String orgName1, String assignTo1)
	{
		orgName.sendKeys(orgName1);
		radButton.click();
		Select sel= new Select(assignId);
        sel.selectByVisibleText(assignTo1);
	    saveBtn.click();	

	}
	
	public void createOrgnizationDesc(String OrgName1, String desc1)
	{
		orgName.sendKeys(OrgName1);
		desc.sendKeys(desc1);
	    saveBtn.click();	

		
	}
	public WebElement getCreateNewOrgVer()
	{
		return createNewOrgVer;
	}
	
	public WebElement getreateOrgVer()
	{
		return createOrgVer1;
		
	}
	
	public WebElement getcreateOrgVer2()
	{
		return createOrgVer2;
		
	}
	
	public WebElement getCreateOrgVer3()
	{
		return createOrgVer3;
	}
	
	public WebElement getCrateOrgVer4()
	{
		return createOrgVer4;
	}
	
	public WebElement getCreateOrgVer5()
	{
		return createOrgVer5;
	}
}
