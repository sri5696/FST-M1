package appium_Project;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity4_todo {
	
	WebDriverWait wait;
	AndroidDriver<MobileElement> driver = null;

	@BeforeClass
	public void setup() throws MalformedURLException {
	    // Set the Desired Capabilities
	    DesiredCapabilities caps = new DesiredCapabilities();
	    caps.setCapability("deviceName", "Swetha Appium Pie");
	    caps.setCapability("platformName", "Android");
	    caps.setCapability("automationName", "UiAutomator2");
	    caps.setCapability("appPackage", "com.android.chrome");
	    caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
	    caps.setCapability("noReset", true);

	    // Instantiate Appium Driver
	    driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
	    wait = new WebDriverWait(driver, 10);
	}
	@Test
	public void testSearchAppium() {
	    // Open page in browser
	    driver.get("https://www.training-support.net/selenium");
	    String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";

	 // wait for page to load
	    wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.Button[@text='Get Started!']")));
            
	    
	    /// Scroll to To do list
        driver.findElement(MobileBy.AndroidUIAutomator(UiScrollable + ".scrollForward(0).scrollIntoView(text(\"To-Do List\"))")).click();
        
        //MobileElement toDo = driver.findElement(MobileBy.xpath("//android.view.View[@text='To-Do List Elements get added at run time']"));
       

	    // Wait for new page to load
	    wait.until(ExpectedConditions.visibilityOfElementLocated(
	      MobileBy.xpath("//android.view.View[@text='To-Do List']")
	    ));

	    //Add task1
	    MobileElement task = driver.findElementById("taskInput");
	    task.sendKeys("Add tasks to list");
	    driver.findElementByXPath("//android.widget.Button[@text='Add Task']").click();
	    
	  //Add task2
	    MobileElement task2 = driver.findElementById("taskInput");
	    task2.sendKeys("Get number of tasks");
	    driver.findElementByXPath("//android.widget.Button[@text='Add Task']").click();
	    
	  //Add task3
	    MobileElement task3 = driver.findElementById("taskInput");
	    task3.sendKeys("Clear the list");
	    driver.findElementByXPath("//android.widget.Button[@text='Add Task']").click();
	    
	    //strike
	    MobileElement striketask1 = driver.findElementByXPath("//android.view.View[@text='Add tasks to list']");
	    striketask1.click();
	    
	    MobileElement striketask2 = driver.findElementByXPath("//android.view.View[@text='Get number of tasks']");
	    striketask2.click();
	    
	    MobileElement striketask3 = driver.findElementByXPath("//android.view.View[@text='Clear the list']");
	    striketask3.click();
	    
	    //Clearlist
	    MobileElement clearlist = driver.findElementByXPath("//android.view.View[@text='Clear List']");
	    clearlist.click();
	    
	    // Assertions
	                Assert.assertNotEquals(striketask1,"Add tasks to list");
         	    System.out.println("AssertNotEquals Test Passed\n");
	    
	    	}

	@AfterTest
	public void tearDown() {
	    driver.quit();
	}

}
