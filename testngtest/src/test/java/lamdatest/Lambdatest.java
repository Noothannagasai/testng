//This is maven project

package lamdatest; //<your package name>

import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

public class Lambdatest {

  public RemoteWebDriver driver = null;
  String username = "nagasainoothan";
  String accessKey = "uTmgAnEONZ455NeaAYf6dk8i0k1qAQX7lRlnBHPbyfvxhrxhTW";
	
	@BeforeTest
	public void setUp() throws Exception {
	  DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("browserName", "Chrome");
    capabilities.setCapability("version", "92.0");
    capabilities.setCapability("platform", "Windows 10");
    capabilities.setCapability("resolution","1024x768");
	  capabilities.setCapability("build", "First Test");
	  capabilities.setCapability("name", "Sample Test");
	  capabilities.setCapability("network", true); // To enable network logs
	  capabilities.setCapability("visual", true); // To enable step by step screenshot
	  capabilities.setCapability("video", true); // To enable video recording
	  capabilities.setCapability("console", true); // To capture console logs

	  try {
	    driver = new RemoteWebDriver(new URL("https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub"), capabilities);
	  } catch (MalformedURLException e) {
	    System.out.println("Invalid grid URL");
	  }
	}

	@Test(enabled = true)
	public void testScript() throws Exception {
	  try {
	    driver.get("https://lambdatest.github.io/sample-todo-app/");
	    driver.findElement(By.name("li1")).click();
	    driver.findElement(By.name("li2")).click();
	    driver.findElement(By.id("sampletodotext")).clear();
	    driver.findElement(By.id("sampletodotext")).sendKeys("Yey, Let's add it to list");
	    driver.findElement(By.id("addbutton")).click();
	    driver.quit();
	  } catch (Exception e) {
	    System.out.println(e.getMessage());
	  }
	  
	  
	}
	
	
	@Test
	public void scenario1() {
		driver.get("https://www.lambdatest.com/selenium-playground\r\n"
				+ "");
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)", "");
		driver.findElement(By.xpath("//a[contains(text(),'Simple Form Demo')]")).click();
		String URL = driver.getCurrentUrl();
		URL.contains("simple-form-demo");
		String text  ="Welcome to LambdaTest";
		driver.findElement(By.xpath("(//input[@placeholder=\"Please enter your Message\"])[1]")).sendKeys(text);
		driver.findElement(By.xpath("//button[contains(text(),'Get Checked value')]")).click();
		String message = driver.findElement(By.xpath("//p[@id=\"message\"]")).getText();
		Assert.assertEquals(text, message);
	}
}