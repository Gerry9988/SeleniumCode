package assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

// Program to display the right click elements
public class MouseActions {
	public static WebDriver driver;
	public static Actions act;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://demo.guru99.com/test/simple_context_menu.html");

		WebElement rightClickOnMe = driver.findElement(By.cssSelector("span.context-menu-one.btn.btn-neutral"));
		act = new Actions(driver);
		act.contextClick(rightClickOnMe).build().perform();

		List<WebElement> elmnts = driver.findElements(By.cssSelector("ul.context-menu-list.context-menu-root"));
		System.out.println("The elements after right click are :");
		for (WebElement elist : elmnts) {
			System.out.println(elist.getText());
		}
	}

}
