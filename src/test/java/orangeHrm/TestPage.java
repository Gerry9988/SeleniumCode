package orangeHrm;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestPage {
	public static WebDriver driver;
	public static void main(String[] args) {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		WebElement uname=driver.findElement(By.xpath("//input[@name='username']"));
		uname.sendKeys("Admin");
		WebElement pswd=driver.findElement(By.xpath("//input[@name='password']"));
		pswd.sendKeys("admin123");
		driver.findElement(By.cssSelector("button.oxd-button.oxd-button--medium.oxd-button--main.orangehrm-login-button")).click();
	
		
		WebElement leaveLink=driver.findElement(By.xpath("//ul[@class='oxd-main-menu']/li[3]/a"));
		leaveLink.click();
		WebElement apply=driver.findElement(By.xpath("//div[@class='oxd-topbar-body']//ul/li/a"));
		apply.click();
		
		WebElement dropDown=driver.findElement(By.xpath("//form[@class='oxd-form']//div[@class='oxd-select-text--after']/i"));
		dropDown.click();
		
		//WebElement dropDownArrow=driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div/div[2]/i"));
		//dropDownArrow.click();

	}

}
