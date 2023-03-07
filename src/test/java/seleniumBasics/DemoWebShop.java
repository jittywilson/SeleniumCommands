package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoWebShop {

	public static void main(String[] args) {
			WebDriver driver = new ChromeDriver();
			driver.get("https://demowebshop.tricentis.com/");	
			driver.manage().window().maximize();	//to maximize the browser window
			System.out.println("Browser Maximised");
			driver.manage().deleteAllCookies();
			WebElement login = driver.findElement(By.className("ico-login"));
			login.click();
			WebElement email = driver.findElement(By.name("Email"));
			email.sendKeys("jittywilson04@gmail.com");
			WebElement password = driver.findElement(By.name("Password"));
			password.sendKeys("Jitty123");
			WebElement loginButton = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input"));
			loginButton.click();
			//driver.close();

	}

}
