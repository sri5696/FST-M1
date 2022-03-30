import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Page_Header {
	
WebDriver driver= new FirefoxDriver();
	
	@BeforeTest
	public void beforeTest() {
		
		driver.get("https://alchemy.hguy.co/jobs/");
				
	}
	
	@Test
	public void headerOfThePage() {
		
		String header =driver.findElement(By.xpath("//h1 [@class ='entry-title']")).getText();
		
		System.out.println("header of the page:"+header);
		
		
		Assert.assertEquals(header, "Welcome to Alchemy Jobs");
		
		
			
			
		if (header == "Welcome to Alchemy Jobs") {
			
			System.out.println("Welcome to jobs");}
			
			else {System.out.println("Didnt navigate to jobs page");
		}
		
	}
	
	@AfterTest
	public void afterTest() {
		driver.close();
	} 
	


}
