package practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chapter94 {

	public static void main(String[] args) {
		
		// 1: finding out links which has tagname as 'a'
		//2: Count of footer section
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//finding links in footer section       
		//--> here driver have access to each and every object so i will create subset or mini driver from main driver only for this footer section
		//when i say minidriver.find Elements by tagname a, it will go and check links in this section only (footer section)
		
		WebElement footerdriver = driver.findElement(By.id("gf-BIG"));  //limiting webdriver scope
		
		System.out.println(footerdriver.findElements(By.tagName("a")).size()); //links in footer section
		
		
		
		
		
	}

}
