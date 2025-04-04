package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	WebDriver driver = null;
	
	public Properties prop;

	public WebDriver  InitializeBrowser() throws IOException {
		prop =new Properties();
		
		String propPath = System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties";
		
		FileInputStream fis =new FileInputStream(propPath);
		
		prop.load(fis);
	
	 String browsername =prop.getProperty("browser");
	 
	 if(browsername.equalsIgnoreCase("chrome"))
	 {
		 driver=new ChromeDriver();
	 }
	 else if ((browsername.equalsIgnoreCase("firefox"))) 
	 {
		 driver=new FirefoxDriver();
	 }
	 else if((browsername.equalsIgnoreCase("Edge")))
			 {
		 driver=new EdgeDriver();
			 }
	 
	 driver.manage().window().maximize();
	
	 
	 
	return driver;
	 
	 
}

public String takeScreenshot(String testName, WebDriver driver) throws IOException
{
	//these 3 lines are same in everywhere & here "testName" is taken as name of the file..
	// It is mandatory to copy these 3 lines for taking screenshot
	
	File SourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	String destinationFilePath = System.getProperty("user.dir")+"\\screenshots\\"+testName+".png";
	FileUtils.copyFile(SourceFile,new File(destinationFilePath));
	
	return destinationFilePath;
}

}
