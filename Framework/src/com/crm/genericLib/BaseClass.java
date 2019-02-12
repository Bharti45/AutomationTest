package com.crm.genericLib;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import com.crm.objectrepositoryLib.Home;
import com.crm.objectrepositoryLib.Login;


public class BaseClass 
{
	public static WebDriver driver;
	public FileUtilsExcel fLib=new FileUtilsExcel();
	public WebDriverUtils util= new WebDriverUtils();
	 @BeforeClass
	 public void configBC() throws Throwable
	 {
		 System.out.println("=====Launch Browser=====");
		 Properties pObj= fLib.getPropertiesFileObject();
		 String browserName= pObj.getProperty("browser");
		 if(browserName.equals("chrome"))
		 {
			 System.setProperty("webdriver.chrome.driver", "./resource/chomedriver.exe");
			 
			 driver= new ChromeDriver();
			 
		 }
		 else if (browserName.equals("firefox"))
		 {
			driver = new FirefoxDriver();
		 }
		 else if (browserName.equals("ie"))
		 {
			System.setProperty("webdriver.ie.driver", "./resource/IEDriverServer.exe");
			
			driver= new InternetExplorerDriver();
		  }
		 
		 driver.manage().window().maximize();
		 util.waitForPageToLoad(driver);
	 }
	 
	 @BeforeMethod
	 public void configBM() throws Throwable
	 {
		 System.out.println("login");
		 Properties pObj = fLib.getPropertiesFileObject();
		 String url= pObj.getProperty("url");
		 String username= pObj.getProperty("username");
		 String pwd= pObj.getProperty("password");
		 
		 driver.get(url);
			
	// Login to Application
    	Login l = PageFactory.initElements(driver, Login.class);
		l.login(username, pwd);
	   
	 }
	 
	 @AfterMethod
	 public void configAM() 
	 {
		 System.out.println("logout");
		// Click on Sign out
         Home hp= PageFactory.initElements(driver, Home.class);
         hp.logout();
         
      }
	 
	 @AfterClass
	 public void configAC()
	 {
		 System.out.println("=====Close Browser=====");
		 driver.close();
	 }

}
