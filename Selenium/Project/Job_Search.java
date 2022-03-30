import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Job_Search {
	
WebDriver driver= new FirefoxDriver();
	
	@BeforeTest
	public void beforeTest() {
		
		driver.get("https://alchemy.hguy.co/jobs/");
				
	}
	
	@Test (priority = 1)
	public void jobsNavigation() {
		
		driver.findElement(By.xpath("//*[@id=\"menu-item-24\"]/a")).click();
		
		String title_jobs=driver.getTitle();
		
		System.out.println("Jobs Title:"+title_jobs);
		
		
	}	
	
	@Test (priority = 2)
	public void jobSearch() {
		
		driver.findElement(By.xpath("//input[@id=\"search_keywords\"]")).sendKeys("banking");
		
		driver.findElement(By.xpath("//*[@id=\"post-7\"]/div/div/form/div[1]/div[4]/input")).click();
	}
	
	@Test (priority = 3)
	public void selectJob() {
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@id=\"post-7\"]/div/div/ul/li[1]/a/div[1]/h3")).click();
		
		//click on apply job
		
		driver.findElement(By.xpath("//*[@id=\"post-4475\"]/div/div/div/div[3]/input")).click();
		
		
		String mailid=driver.findElement(By.xpath("//a[contains(text(),'abhi')]")).getText();
		
		System.out.println("Mail Id: "+mailid);
		
		
		
	}
	
	
	@AfterTest
	public void afterTest() {
		driver.close();
	}


}
