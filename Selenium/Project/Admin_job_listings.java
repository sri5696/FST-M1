import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Admin_job_listings {

	
WebDriver driver= new FirefoxDriver();
	
	@BeforeTest
	public void beforeTest() {
		
		driver.get("https://alchemy.hguy.co/jobs/wp-login.php?loggedout=true&wp_lang=en_US");
				
	}
	
	/*@Test
	public void loginDetails() {
		
		driver.findElement(By.xpath("//input[@id=\"user_login\"]")).sendKeys("root");
		
		driver.findElement(By.xpath("//input[@id=\"user_pass\"]")).sendKeys("pa$$w0rd");
		
		driver.findElement(By.xpath("//input[@id=\"wp-submit\"]")).click();
	}*/
	
	@Test
	public void jobListings() {
		
		driver.findElement(By.id("user_login")).sendKeys("root");
	      driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
	      driver.findElement(By.id("wp-submit")).click();
	      driver.findElement(By.xpath("//div[@class='wp-menu-name'][contains(.,'Job Listings')]")).click();
	      driver.findElement(By.xpath("//a[contains(@class,'page-title-action')]")).click();
		
				
		//driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
	   // driver.findElement(By.xpath("//div[@class='wp-menu-name'][contains(.,'Job Listings')]")).click();
		
		//WebElement users = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.id("//li[@id='menu-posts-job_listing']")));
		//users.click();
		
	 //   WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(20));
	  // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='wp-menu-name'][contains(.,'Job Listings')]")));
		
		
	//	driver.findElement(By.xpath("//*[@id=\"wpbody-content\"]/div[4]/a")).click();
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//textarea[@id=\"post-title-0\"]")).sendKeys("Testing");
		
		//driver.findElement(By.xpath("//*[@id=\"editor-c6265bdc-e5ec-4869-aecc-edc32cdda71f\"]")).sendKeys("test Engineer");
		
		driver.findElement(By.xpath("//*[@id=\"editor\"]/div/div/div[1]/div/div[1]/div/div[2]/button[2]")).click();
		
		System.out.println("Passed the cases");
		
		driver.findElement(By.xpath("//*[@id=\"editor\"]/div/div/div[1]/div/div[2]/div[3]/div/div/div/div[1]/div/button")).click();
	
		driver.findElement(By.xpath("//*[@id=\"editor\"]/div/div/div[1]/div/div[2]/div[3]/div/div/div/div[2]/div/div[2]/div[2]/a")).click();
	
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

	
}
