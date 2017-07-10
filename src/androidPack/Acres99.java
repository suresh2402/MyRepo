package androidPack;

import java.io.IOException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Acres99 {
	
	static AppiumDriverLocalService service;
	static AppiumServiceBuilder builder;
	@SuppressWarnings("rawtypes")
	static AndroidDriver driver;

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws InterruptedException, IOException {
		
		//Below code will start appium server with default setting/configuration/ service i.e. with IP 0.0.0.0 and port 4723
		//AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
		DesiredCapabilities cap = new DesiredCapabilities();
		//With AppiumServiceBuilder, you have the option to configure the Appium Server, where you can add a different address, port, capabilities and other server flags. 
		
		cap.setCapability("noReset", "false");
		builder = new AppiumServiceBuilder();
		builder.withCapabilities(cap);
		builder.usingPort(4723);
		builder.withIPAddress("127.0.0.1");
		//Start the server with the builder
		service = AppiumDriverLocalService.buildService(builder);
		service.start();
		
		//DesiredCapabilities capabilities = DesiredCapabilities.android();	
		DesiredCapabilities capabilities = new DesiredCapabilities();	
		capabilities.setCapability("device", "Android");
		capabilities.setCapability("platformName", "Android");	// mandatory Android, iOS or FirefoxOS
		capabilities.setCapability("deviceName","42005e84d4ec144d"); //deviceName could be anything 42005e84d4ec144d		
	    capabilities.setCapability("appActivity", "com.flipkart.android.activity.HomeFragmentHolderActivity");
	    capabilities.setCapability("appPackage", "com.flipkart.android");
	    capabilities.setCapability("app","C:\\Users\\sshaw\\Desktop\\Android_Test_SetUp\\android-sdk\\platform-tools\\Flipkart.apk");
	    
	    URL url= new URL("http://127.0.0.1:4723/wd/hub");	      	    
	    driver  = new AndroidDriver(url, capabilities);
	   
	    Thread.sleep(40000);
	    if(driver.isKeyboardShown()){
	    	driver.hideKeyboard();
	    }
		driver.findElement(By.id("search_widget_textbox")).click();
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='mobile']")).click();
		Thread.sleep(3000);
		driver.findElement(MobileBy.name("NOT NOW")).click();		
		Thread.sleep(5000);
		driver.quit();
		service.stop();		
	}	
}