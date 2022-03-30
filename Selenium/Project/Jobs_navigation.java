import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Test
public class Jobs_navigation {

WebDriver driver= new FirefoxDriver();
	
	@BeforeTest
	public void beforeTest() {
		
		driver.get("https://alchemy.hguy.co/jobs/");
				
	}
	
	@Test
	public void jobsNavigation() {
		
		driver.findElement(By.xpath("//*[@id=\"menu-item-24\"]/a")).click();
		
		String title_jobs=driver.getTitle();
		
		System.out.println("Jobs Title:"+title_jobs);
		
		
	}		

	
	
}
