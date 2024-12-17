package MyAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstAutomation {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com");
		WebElement formAuth = driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[21]/a"));
		formAuth.click();
		WebElement uname = driver.findElement(By.xpath("//input[@id='username']"));
		uname.sendKeys("tomsmith");
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		pwd.sendKeys("SuperSecretPassword!");
		WebElement btn = driver.findElement(By.xpath("//button[@class='radius']/i"));
		btn.click();
		WebElement msg = driver.findElement(By.xpath("//*[@id=\"flash\"]/text()"));
		String logingMsg = msg.getText();
		if (logingMsg.contains("You logged into a secure area!")) {
			System.out.println("Login successful");
		} else {
			System.out.println("Login test failed");
		}
		driver.quit();

	}

}
