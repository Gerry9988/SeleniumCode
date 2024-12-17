package assignments;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
	WebDriver driver;

	@BeforeMethod
	public void launchBrowser() {
		driver = new ChromeDriver(); // creating the object of ChromeDriver class by giving the reference of
										// WebDriver interface
		driver.manage().window().maximize(); // driver is maximizing the window
		driver.navigate().to("https://the-internet.herokuapp.com/"); // driver is navigating to given url
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000)); // driver will wait for a few soconds to
																				// get the all elements download
	}

	@AfterMethod
	public void tearDown() {
		driver.quit(); // driver will close all opened tabs of browser
	}

}
