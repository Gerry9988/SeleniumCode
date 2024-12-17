package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AssignmentScriptswithTestNG  extends TestBase{
	//this class is inheriting the TestBase class
	String expectedTitle ="The Internet";
	String expectedErrorMessage = "Internal Server Error";
	
	
	
	//land on home page then click on forgot message then enter email and clik on button.
	@Test(priority=1)	
	public void enterEmail() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@id='content']/ul/li[20]/a")).click(); //find forgot password link and click on it
		Thread.sleep(5000); //driver will wait for 5 seconds before proceeding further
		WebElement email = driver.findElement(By.xpath("//input[@id='email']")); //find email webElement
		
		email.sendKeys("gurpreet@gmail.com");	//type email in textbox
		driver.findElement(By.xpath("//button[@id='form_submit']")).click(); //click on  retrieve password button
	}
	
	
	//land on home page and click on forgot page then find the title of navigated page and verify it.
	@Test(priority=2)	
	public void verifyTitle() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@id='content']/ul/li[20]/a")).click(); //find forgot password link and click on it
		Thread.sleep(5000); //driver will wait for 5 seconds before proceeding further
		String actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle); //It'll check if the actual title is equal to expected title and it'll return boolean(true or false).
		System.out.println("Title is verified");
	}
	
	
	
	//land on home page then click on forgot password. enter email then click on button. after that verify the error message.
	@Test(priority=3) 	
	public void verifyErrorMessage() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@id='content']/ul/li[20]/a")).click(); //find forgot password link and click on it
		Thread.sleep(5000); //driver will wait for 5 seconds before proceeding further
		WebElement email = driver.findElement(By.xpath("//input[@id='email']")); //find email webElement
		
		email.sendKeys("gurpreet@gmail.com");	//type email in textbox
		driver.findElement(By.xpath("//button[@id='form_submit']")).click(); //click on  retrieve password button
		
		String actualMessage=driver.findElement(By.xpath("//body/h1")).getText();
		Assert.assertEquals(actualMessage,expectedErrorMessage);
	}

}
