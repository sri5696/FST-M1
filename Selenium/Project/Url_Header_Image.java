import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Url_Header_Image {

	
WebDriver driver= new FirefoxDriver();
	
	@BeforeTest
	public void beforeTest() {
		
		driver.get("https://alchemy.hguy.co/jobs/");
				
	}
	
	@Test
	public void urlOfTheImage() {
		
		WebElement url =driver.findElement(By.xpath("//img[@class=\"attachment-large size-large wp-post-image\"]"));
		
		String imageurl =url.getAttribute("src");
		
		System.out.println("Sorce of the image:"+imageurl);
		
		
	}
	
	@AfterTest
	public void afterTest() {
		driver.close();
	}
	

	
}
