package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SelectWholeTextWithControlA {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");
		WebElement elmnt = driver.findElement(By.linkText("Form Authentication"));
		elmnt.click();

		WebElement uname = driver.findElement(By.xpath("//input[@name='username']"));
		uname.sendKeys("tomsmith");

		Actions action = new Actions(driver);
		// press control key
		action.moveToElement(uname).keyDown(Keys.CONTROL);

		// Press 'a' to select all
		action.moveToElement(uname).sendKeys("a");

		// Release control key
		action.moveToElement(uname).keyUp(Keys.CONTROL);

		action.moveToElement(uname).perform();

	}

}
