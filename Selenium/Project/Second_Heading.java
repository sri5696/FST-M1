import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Second_Heading {
	
	
WebDriver driver= new FirefoxDriver();
	
	@BeforeTest
	public void beforeTest() {
		
		driver.get("https://alchemy.hguy.co/jobs/");
				
	}
	
	@Test
	public void headerOfThePage() {
		
		String header =driver.findElement(By.xpath("//*[@id=\"post-16\"]/div/h2")).getText();
		
		System.out.println("Second Heading:" + header);
		
		
		if (header == "Quia quis non") {
			driver.close();
		}
		
	}
	

}
