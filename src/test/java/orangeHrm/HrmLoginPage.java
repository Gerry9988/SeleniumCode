package orangeHrm;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HrmLoginPage extends TestBase {
	String expectedCmpnyName="OrangeHRM";
	
	@Test(priority=1)
	public void login()
	{
		WebElement uname=driver.findElement(By.xpath("//input[@name='username']"));
		uname.sendKeys("Admin");
		WebElement pswd=driver.findElement(By.xpath("//input[@name='password']"));
		pswd.sendKeys("admin123");
		driver.findElement(By.cssSelector("button.oxd-button.oxd-button--medium.oxd-button--main.orangehrm-login-button")).click();
	}
	
	@Test(priority=2)
	public void clickDropDown()
	{
		WebElement dropDownLink = driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']//p"));
		dropDownLink.click();
		WebElement aboutLink=driver.findElement(By.xpath("//ul[@class='oxd-dropdown-menu']/li[1]/a[1]"));
		aboutLink.click();
		WebElement companyName=driver.findElement(By.xpath("//*[@id='app']/div[2]/div/div/div/div[2]/div[2]/p"));
		String actualCmpnyName = companyName.getText();
		Assert.assertEquals(actualCmpnyName,expectedCmpnyName);
		System.out.println("Company name is " + actualCmpnyName);
		WebElement closePopUpWindow=driver.findElement(By.xpath("//div[@id='app']/div[2]//button"));
		closePopUpWindow.click();
	}
	@Test(priority=3)
	public void Leave()
	{
		WebElement leaveLink=driver.findElement(By.xpath("//ul[@class='oxd-main-menu']/li[3]/a"));
		leaveLink.click();
		WebElement apply=driver.findElement(By.xpath("//div[@class='oxd-topbar-body']//ul/li/a"));
		apply.click();
	}
	@Test(priority=4)
	public void fillForm() throws InterruptedException
	{
		//Leave type CAN-FMLA
		driver.findElement(By.xpath("//form/div[1]/div/div[1]/div/div[2]")).click();
		driver.findElement(By.xpath("//span[text()='CAN - FMLA']")).click();
		

		//enter 'From Date'
		driver.findElement(By.xpath("//form/div[2]/div/div[1]/div/div[2]/div/div/input")).sendKeys("2024-28-12");

		//enter 'To Date'
		WebElement toDateEle = driver.findElement(By.xpath("//form/div[2]/div/div[2]/div/div[2]/div/div/input"));

		//clear'To Date' text field and enter date
		Actions act = new Actions(driver);
		act.click(toDateEle).keyDown(Keys.CONTROL).sendKeys("A" + "X").keyUp(Keys.CONTROL).sendKeys("2024-30-12").keyDown(Keys.TAB).perform();

		//enter comments in comments field
		WebElement cment=driver.findElement(By.xpath("//form/div[4]/div/div/div/div[2]/textarea"));
		cment.sendKeys("paid vacation");

		//click on 'Apply' button
		WebElement btn=driver.findElement(By.xpath("//button[@type='submit']"));
		btn.click();

		//verify pop up message
		String confirmMessage = driver.findElement(By.xpath("//p[contains(string(),'Failed to Submit:')]")).getText();
		Assert.assertEquals(confirmMessage, "Failed to Submit: No Working Days Selected");

	}

}
