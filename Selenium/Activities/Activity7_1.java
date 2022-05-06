import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity7_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver= new FirefoxDriver();
		
		driver.get("https://www.training-support.net/selenium/dynamic-attributes");
		
		String title= driver.getTitle();
		
		System.out.println("Page titel:"+ title);
		
		WebElement userName= driver.findElement(By.xpath("//input[starts-with(@class, 'username')]"));
		
		userName.sendKeys("Admin");
		
		WebElement passWord= driver.findElement(By.xpath("//input[starts-with(@class,'password')]"));
		
		passWord.sendKeys("password");
		
		driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
		
		String confirmation= driver.findElement(By.id("action-confirmation")).getText();
		
		System.out.println("Confirmation message:"+ confirmation);
		
		driver.close();
		

	}

}
