import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Post_job {
	
WebDriver driver= new FirefoxDriver();
	
	@BeforeTest
	public void beforeTest() {
		
		driver.get("https://alchemy.hguy.co/jobs/");
				
	}
	
	@Test (priority = 1)
	public void jobsNavigation() {
		
		driver.findElement(By.xpath("//*[@id=\"menu-item-26\"]/a")).click();
		
		String title_jobs=driver.getTitle();
		
		System.out.println("Post Jobs Title:"+title_jobs);
		
		
	}	
	
	@Test (priority =2)
	
	public void postJobs() {
		
		driver.findElement(By.xpath("//input[@id=\"create_account_email\"]")).sendKeys("sreddy@gmail.com");
		
		driver.findElement(By.xpath("//input[@id=\"job_title\"]")).sendKeys("Testing");
		
		driver.findElement(By.xpath("//input[@id=\"job_location\"]")).sendKeys("India");
		
		driver.findElement(By.xpath("//input[@id=\"job_location\"]")).sendKeys("Full Time");
				
		driver.findElement(By.xpath("//*[@id=\"job_description_ifr\"]")).sendKeys("testing");
		
		driver.findElement(By.xpath("//input[@id=\"application\"]")).sendKeys("sreddy@gmail.com");
		
		driver.findElement(By.xpath("//input[@id=\"company_name\"]")).sendKeys("IBM");
		
		
		
		driver.findElement(By.xpath("//*[@id=\"submit-job-form\"]/p/input[4]")).click();
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@name=\"continue\"]")).click();
		
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
