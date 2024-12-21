package assignments;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHandling {
	// Program to handle alerts

	public static WebDriver driver;
	public static WebElement customerID;

	public static Alert alert;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://demo.guru99.com/test/delete_customer.php");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		customerID = driver.findElement(By.xpath("//input[@name='cusid']"));
		customerID.sendKeys("12345");
		driver.findElement(By.xpath("//input[@name='submit']")).submit();
		alert = driver.switchTo().alert();
		// Thread.sleep(5000);
		alert.accept();

		// enter data again and click on cancel.
		String winHandle = driver.getWindowHandle();
		driver.switchTo().window(winHandle); // switch drivr from alert to window
		customerID = driver.findElement(By.xpath("//input[@name='cusid']"));
		customerID.sendKeys("12345");
		driver.findElement(By.xpath("//input[@name='submit']")).submit();
		alert.dismiss();

		// print message of alert;
		customerID.sendKeys("12345");
		driver.findElement(By.xpath("//input[@name='submit']")).submit();
		alert = driver.switchTo().alert();
		String msg = alert.getText();
		System.out.println(msg);

	}

}
