package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class LoginTest extends Base {
	Logger log;
	
	public WebDriver driver;
	@Test(dataProvider= "getLoginData")
	public void login(String email, String password, String Expectedresult) throws IOException, InterruptedException
	{
	
		
		LandingPage landingpage =  new LandingPage(driver);
         landingpage.myAccountDropdown().click();	
         log.debug("Clicked on My accountdropdown");
         landingpage.LoginOption().click();
         log.debug("Clicked on loginoption");
         
         Thread.sleep(3000);
         
         LoginPage loginpage = new LoginPage(driver);
         loginpage.EmailAddress().sendKeys(email);
         log.debug("Email address got entered");
         loginpage.Password().sendKeys(password);
         log.debug("Password got entered");
         loginpage.Login().click();
         log.debug("login is clicked");
         
         AccountPage accountpage = new AccountPage(driver);
         
         String Actualresult = null;
         
         try {
        	 
        	 if(accountpage.Edityouraccountinformation().isDisplayed());
         Actualresult = "Sucessful";
         log.debug("user got looged in");
         
         } catch(Exception e)
         {
        	 Actualresult = "Failure"; 
        	 log.debug("user didn't logged in");
        	 }
         Assert.assertEquals(Actualresult,Expectedresult);
         log.info("Test got passed");
         }
	
	@BeforeMethod
	public void openapplication() throws IOException
	{
		log = LogManager.getLogger(LoginTest.class.getName());
		
		 driver = InitializeBrowser();
		log.debug("Browser got launched");
	    driver.get(prop.getProperty("url"));
	    log.debug("Navigated to the application url");
	}  
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
		log.debug("Broswer got closed");
	}
	
	@DataProvider
	public Object[][] getLoginData()
	{
		Object[][] data = {{"bhargava372@gmail.com","Bhargava#96","Sucessful"}};
		return data;
	}
}
	
/*note: if we have multiple sets of data then, we should not use data.properties Instead we can pass data
	 from  Data provider*/

/* if we have single data then we can use data.properties */



