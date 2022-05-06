import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Acitivity4_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver= new FirefoxDriver();
		
		driver.get("https://www.training-support.net");
		
		driver.getTitle();
		
		driver.findElement(By.xpath("//a [contains(text(),'About Us')]")).click();
		
		System.out.println("get titel :" + driver.getTitle());
		
		driver.close();
		
	
	}

}
