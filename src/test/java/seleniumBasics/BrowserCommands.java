package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserCommands {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");	
		driver.manage().window().maximize();	//to maximize the browser window
		System.out.println("Browser Maximised");
		driver.manage().deleteAllCookies();
		String url = driver.getCurrentUrl();
		System.out.println("URL is "+url);
		String title=driver.getTitle();
		System.out.println("Title is "+title);
		String pageSource=driver.getPageSource();
		System.out.println("Source Code is "+pageSource);
		WebElement messageField = driver.findElement(By.id("single-input-field"));
		messageField.sendKeys("Test");
		WebElement submitButton = driver.findElement(By.id("button-one"));
		submitButton.click();
		
		
		//driver.close();// to close the browser
	}

}
