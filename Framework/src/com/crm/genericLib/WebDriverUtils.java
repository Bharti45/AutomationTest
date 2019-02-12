package com.crm.genericLib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtils 
{
		/*
		 * wait for page to load
		 */
		
		public void waitForPageToLoad(WebDriver driver)
		{
			driver.manage().timeouts().implicitlyWait(65, TimeUnit.SECONDS);
		}
		
		
		/*
		 * wait for any Element is available in UI
		 */
		
		public void waitForElementPresent(WebDriver driver, WebElement wb)
		{
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOf(wb));
			
			
		}
		
		
		/*
		 * wait For any Element is Completely available/ load in GUI
		 */
		
		public void waitForCompleteElementToLoad(WebElement wb) throws InterruptedException
		{
			int count=0;
			while(count<40)
			{
				try
				{
					wb.isDisplayed();
					break;
					
				}
				catch(Throwable t)
				{
					System.out.println("Handle The Exception & Continue");
					Thread.sleep(1000);
					count++;
					
				}
			}
		}
}
