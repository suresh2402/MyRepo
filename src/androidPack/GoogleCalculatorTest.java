package androidPack;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GoogleCalculatorTest {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities capabilities = DesiredCapabilities.android();		
		//DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");	// mandatory Android, iOS or FirefoxOS
		capabilities.setCapability("deviceName","42005e84d4ec144d"); //deviceName could be anything 42005e84d4ec144d
	    capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
	    capabilities.setCapability("appPackage", "com.google.android.calculator");
	    capabilities.setCapability("app","C:\\Users\\sshaw\\Desktop\\Android Test SetUp\\android-sdk\\platform-tools\\Calculator.apk");
	    
	    URL url= new URL("http://127.0.0.1:4723/wd/hub");
	    WebDriver driver = new RemoteWebDriver(url, capabilities);
	    Thread.sleep(5000);
		driver.findElement(By.id("digit_7")).click();
		driver.findElement(By.id("op_add")).click();
		driver.findElement(By.id("digit_9")).click();
		driver.findElement(By.id("eq")).click();
		
		Thread.sleep(5000);
		driver.quit();
	}
}