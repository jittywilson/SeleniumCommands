package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");	
		driver.manage().window().maximize();	//to maximize the browser window
		System.out.println("Browser Maximised");
		driver.manage().deleteAllCookies();
		WebElement textbox1 = driver.findElement(By.id("value-a"));
		textbox1.sendKeys("20");
		WebElement textbox2 = driver.findElement(By.id("value-b"));
		textbox2.sendKeys("10");
		WebElement totalButton = driver.findElement(By.id("button-two"));
		totalButton.click();
		WebElement getTotalText = driver.findElement(By.id("message-two"));
		String text = getTotalText.getText();
		System.out.println("Text = "+text);
		driver.close();
		
	}

}
