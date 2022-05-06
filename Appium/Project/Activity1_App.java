package appium_Project;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Activity1_App {
	AndroidDriver<MobileElement> driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void beforeClass() throws MalformedURLException{
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Swetha Appium Pie");
		caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.apps.tasks");
        caps.setCapability("appActivity", ".ui.TaskListsActivity");
        caps.setCapability("noReset", true);
        
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        wait = new WebDriverWait(driver, 10);
	}
	
	@Test
	public void googleTasks() {
		
		
		
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Create new task")));
		
		 driver.findElementByAccessibilityId("Create new task").click();
		
		// Wait for fields to load
	        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.EditText[@text='New task']")));
 
	     // Find the add task button
	        MobileElement newTask = driver.findElementByXPath("//android.widget.EditText[@text='New task']");
	       
	        // Enter the text in the fields
	        newTask.sendKeys("Complete Activity with Google tasks");
	        

	        // Save the task
	         driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.tasks:id/add_task_done\")")).click();
	       
	        // Wait for task bar to appear
	        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.tasks:id/multi_list_toolbar\")")));

	        //second task
	        driver.findElementByAccessibilityId("Create new task").click();
			
			// Wait for fields to load
		        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.EditText[@text='New task']")));
	 
		     // Find the add task button
		        MobileElement newTask2 = driver.findElementByXPath("//android.widget.EditText[@text='New task']");
		       
		        // Enter the text in the fields
		        newTask2.sendKeys("Complete Activity with Google keep");
		        

		        // Save the task
		         driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.tasks:id/add_task_done\")")).click();
		       
		        // Wait for task bar to appear
		        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.tasks:id/multi_list_toolbar\")")));

		        
		      //third task
		        driver.findElementByAccessibilityId("Create new task").click();
				
				// Wait for fields to load
			        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.EditText[@text='New task']")));
		 
			     // Find the add task button
			        MobileElement newTask3 = driver.findElementByXPath("//android.widget.EditText[@text='New task']");
			       
			        // Enter the text in the fields
			        newTask3.sendKeys("Complete the second Activity Google keep");
			        

			        // Save the task
			         driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.tasks:id/add_task_done\")")).click();
			       
			        // Wait for task bar to appear
			        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.tasks:id/multi_list_toolbar\")")));

	        // Assertion
	        //MobileElement mobileCard = driver.findElementById("toolbar_parent");
	        //Assert.assertTrue(mobileCard.isDisplayed());

	        String task1 = driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='Complete Activity with Google tasks']")).getText();
	        Assert.assertEquals(task1, "Complete Activity with Google tasks");
	        
	        String task2 = driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='Complete Activity with Google keep']")).getText();
	        Assert.assertEquals(task2, "Complete Activity with Google keep");
	        
	        String task3 = driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='Complete the second Activity Google keep']")).getText();;
	        Assert.assertEquals(task3, "Complete the second Activity Google keep");
	    }

			
	
	 @AfterClass
	    public void afterClass() {
	        driver.quit();
	    }

}
