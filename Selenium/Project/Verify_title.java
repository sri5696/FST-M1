import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Verify_title {
	
	WebDriver driver= new FirefoxDriver();
	
	@BeforeTest
	public void beforeTest() {
		
		driver.get("https://alchemy.hguy.co/jobs/");
				
	}
	
	@Test
	public void titleOfThePage() {
		
		String title =driver.getTitle();
		
		if (title == "Alchemy Jobs – Job Board Application") {
			driver.close();
		}
		
	}
	
	/* @AfterTest
	public void afterTest() {
		driver.close();
	} */
	

}
