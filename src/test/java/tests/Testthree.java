package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;

public class Testthree extends Base {
	
	public WebDriver driver;
	
	@Test
	public void Threetest() throws IOException, InterruptedException
	{
	    driver = InitializeBrowser();
		   driver.get("https://tutorialsninja.com/demo/");
			   
		   System.out.println("Testthree");
	
		   Thread.sleep(5000);
		   
		   driver.close();
		   
	}

}
