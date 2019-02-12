package com.crm.objectrepositoryLib;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.genericLib.BaseClass;

public class Organization extends BaseClass
{
	// Initialization (Store all the WebElements Using @FindBy

	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement addImg;
	
	@FindBy(xpath="//input[@value='Delete']")
	private WebElement deleteBtn;
	
	@FindBy(xpath="//td[@class='moduleName']/a[text()='Organizations']")
	private WebElement orgPageVer;
	//Utilization

	@FindBy(xpath="//table[@class='searchUIBasic small']/tbody/tr[*]/td[3]/input")
	private WebElement  srcOrg;
	
	@FindBy(xpath="//table[@class='searchUIBasic small']/tbody/tr[*]/td[5]/div/select")
	private WebElement srcDropDown;
	
	@FindBy(xpath="//input[@name='submit']")
	private WebElement srcBtn;
	
	public void navigateToCreateOrganization()
	{
		addImg.click();
	}
	
	public void deleteOrganization(String orgName)
	{
		
		WebElement wbd= driver.findElement(By.xpath("//a[text()='"+orgName+"']/../preceding-sibling::td[2]"));
		wbd.click();
		deleteBtn.click();
		
		Alert alt= driver.switchTo().alert();
        System.out.println(alt.getText());
        alt.accept();
		
	}
	
	public WebElement getOrgPageVer()
	{
		return orgPageVer;
	}
	
	public WebElement getSrcOrg()
	{
		return srcOrg;
	}
	
	public WebElement getSrcDropDown()
	{
		return srcDropDown;
	}
	
	public WebElement getSrcBtn()
	{
		return srcBtn;
	}
}
