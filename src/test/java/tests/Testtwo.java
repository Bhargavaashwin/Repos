package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import resources.Base;

public class Testtwo extends Base
{
	public WebDriver driver;
	@Test 
	public void teststwo() throws InterruptedException, IOException
	{ 
	driver = InitializeBrowser();
	driver.get("https://tutorialsninja.com/demo/");
	
	System.out.println("Testtwo");
	
	Thread.sleep(5000);
	
	Assert.assertTrue(false);
	
	}
	@AfterMethod
	public void closure()
	{
	 driver.close();
	}
}


