import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Admin_Page {

WebDriver driver= new FirefoxDriver();
	
	@BeforeTest
	public void beforeTest() {
		
		driver.get("https://alchemy.hguy.co/jobs/wp-login.php?loggedout=true&wp_lang=en_US");
				
	}
	
	@Test
	public void loginDetails() {
		
		driver.findElement(By.xpath("//input[@id=\"user_login\"]")).sendKeys("root");
		
		driver.findElement(By.xpath("//input[@id=\"user_pass\"]")).sendKeys("pa$$w0rd");
		
		driver.findElement(By.xpath("//input[@id=\"wp-submit\"]")).click();
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}
	
}
