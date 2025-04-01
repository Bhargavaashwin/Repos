package practise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class sample {
	WebDriver driver;

	@Test
	public void methodOn() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

		driver.get("https://demoqa.com/");

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement scrollupto = driver.findElement(By.xpath("//div[@class=\"card mt-4 top-card\"]//h5[text()=\"Elements\"]"));
		jse.executeScript("arguments[0].scrollIntoView(true);", scrollupto);
		driver.findElement(By.xpath("//div[@class=\"card mt-4 top-card\"]//h5[text()=\"Elements\"]")).click();

		driver.findElement(By.xpath("//span[text()='Text Box']")).click();
		 // Filling out the form
        driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("norol");
        driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("garu@mailinator.com");
	
        WebElement scrolluptosubmit = driver.findElement(By.id("submit"));
        jse.executeScript("arguments[0].scrollIntoView(true);", scrolluptosubmit);

        Thread.sleep(3000);
         driver.findElement(By.id("submit")).click();
      //  driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys("Explicabo");

        
        // Clicking submit button
     //   driver.findElement(By.xpath("//button[@id='submit']")).click();
		
		
		

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
