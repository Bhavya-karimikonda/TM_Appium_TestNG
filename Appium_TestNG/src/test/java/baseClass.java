
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement ;

import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

// WORKING WITH LOCAL ENVIRONMENT FOR APP AUTOMATE

public class baseClass {
	
	 AndroidDriver driver;
	
	@BeforeTest
	public void setup() throws MalformedURLException, InterruptedException {
	

		DesiredCapabilities capabilities = new DesiredCapabilities() ;
		
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Device_B");
		
		capabilities.setCapability(MobileCapabilityType.APP, "./WikipediaSample.apk" );
		
		URL url = new URL("http://localhost:4723/wd/hub");
		
		driver = new AndroidDriver(url, capabilities);
		
		Thread.sleep(10000);
		
	}
	
	
	@Test
    public void openWikiSearch() throws InterruptedException {
	      
		WebElement searchSelector = driver.findElement(By.id("org.wikipedia.alpha:id/search_container"));
		 searchSelector.click();
		 
        }
	
	@Test
    public void searchBStack() throws InterruptedException {
	      
	            WebElement searchSelector = driver.findElement(By.id("org.wikipedia.alpha:id/search_container"));
	            searchSelector.click();
	            Thread.sleep(2000);
	            WebElement insertTextSelector = driver.findElement(By.id("org.wikipedia.alpha:id/search_src_text"));
	            insertTextSelector.sendKeys("BrowserStack");
	            Thread.sleep(1000);
	            List<WebElement> allProductsName = driver.findElements(By.className("android.widget.TextView"));
	            AssertJUnit.assertTrue(allProductsName.size() > 0);
        }
	
	@AfterTest
	public void teardown(){
		
		driver.quit();
	}
	

}