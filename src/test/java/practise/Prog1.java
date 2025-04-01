package practise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Prog1 {

	

		  public static void main(String[] args) {
		        WebDriver driver = new ChromeDriver();
		        driver.manage().window().maximize();
		        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		        driver.get("https://demoqa.com/");

		        // Clicking on the "Elements" card
		        driver.findElement(By.xpath("//div[@class=\"card mt-4 top-card\"]//h5[text()=\"Elements\"]")).click();
		        
		        
		        // Filling out the form
		        /*driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("norol");
		        driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("garu@mailinator.com");
		        driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys("Explicabo");

		        // Clicking submit button
		        driver.findElement(By.xpath("//button[@id='submit']")).click();

		        // Closing the browser after execution (optional)
		        driver.quit(); */
	}

}
