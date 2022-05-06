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

public class Activity3_Reminder {
	AndroidDriver<MobileElement> driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void beforeClass() throws MalformedURLException{
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Swetha Appium Pie");
		caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.keep");
        caps.setCapability("appActivity", ".activities.BrowseActivity");
        caps.setCapability("noReset", true);
        
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        wait = new WebDriverWait(driver, 10);
	}
	
	@Test
	public void googleTasks() {
				
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("New text note")));
		
		 driver.findElementByAccessibilityId("New text note").click();

		
		// Wait for fields to load
	        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.EditText[@text='Title']")));
 
	     // Find the add task button
	        MobileElement title = driver.findElementByXPath("//android.widget.EditText[@text='Title']");
	        MobileElement note = driver.findElementByXPath("//android.widget.EditText[@text='Note']");
	       
	        // Enter the text in the fields
	        title.sendKeys("Activity3test");
	        note.sendKeys("Activity3note");
	        
	     // Click on Reminder
	        driver.findElementByAccessibilityId("Single-column view").click();
	        
	        //Wait for reminder to show
	        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.TextView[@text='Later today']")));
	        	        
	        //Add Reminder
	        MobileElement reminder = driver.findElementByXPath("//android.widget.TextView[@text='Later today']");
	        reminder.click();

	        // Save the task
	        driver.findElementByAccessibilityId("Open navigation drawer").click();
	       
	        // Wait for task bar to appear
	        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.keep:id/open_search_bar_text_view\")")));

	      //go to Reminder page
	        MobileElement reminderpage = driver.findElementByXPath("//android.widget.TextView[@text='Search your notes']");
	        reminderpage.click();
	        
	        //Click on Reminder
	        MobileElement reminderpage1 = driver.findElementById("zero_search_circle");
	        reminderpage1.click();
	        
	        // Wait for task bar to appear
	        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.keep:id/search_actionbar_query_text\")")));

	        
	         // Assertion
	        //MobileElement mobileCard = driver.findElementById("toolbar_parent");
	        //Assert.assertTrue(mobileCard.isDisplayed());

	        String noteadded = driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='Activity3test']")).getText();
	        Assert.assertEquals(noteadded, "Activity3test");
	        	        
	    }

	
	@AfterClass
    public void afterClass() {
        driver.quit();
    }


}
