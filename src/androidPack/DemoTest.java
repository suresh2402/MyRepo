package androidPack;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.android.AndroidDriver;

public class DemoTest {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities capabilities = DesiredCapabilities.android();		
		//DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");	// mandatory	
		capabilities.setCapability("platformVersion", "6.0.1");
		capabilities.setCapability("appActivity", "com.android.calendar.AllInOneActivity");
	    capabilities.setCapability("appPackage", "com.underwood.calendar_beta");	    
	    URL url= new URL("http://127.0.0.1:4723/wd/hub");
	    WebDriver driver = new AndroidDriver(url, capabilities);
		driver.get("https://the-internet.herokuapp.com/login");
		System.out.println("Title "+driver.getTitle());
		driver.findElement(By.name("username")).sendKeys("tomsmith");
		driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.className("radius")).click();
		Thread.sleep(5000);
		driver.quit();
	}
}