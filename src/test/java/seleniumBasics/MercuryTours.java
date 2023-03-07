package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MercuryTours {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/");
		driver.manage().window().maximize(); // to maximize the browser window
		System.out.println("Browser Maximised");
		driver.manage().deleteAllCookies();
		WebElement register = driver.findElement(By.linkText("REGISTER"));
		register.click();
		WebElement firstName = driver.findElement(By.name("firstName"));
		firstName.sendKeys("Jitty");
		WebElement lastName = driver.findElement(By.name("lastName"));
		lastName.sendKeys("Wilson");
		WebElement phone = driver.findElement(By.name("phone"));
		phone.sendKeys("9526271040");
		WebElement email = driver.findElement(By.name("userName"));
		email.sendKeys("jittywilson04@gmail.com");
		WebElement address = driver.findElement(By.xpath(
				"/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[7]/td[2]/input"));
		address.sendKeys("Kalloor House");
		WebElement city = driver.findElement(By.xpath(
				"/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[8]/td[2]/input"));
		city.sendKeys("Vadanappalli");
		WebElement state = driver.findElement(By.xpath(
				"/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/input"));
		state.sendKeys("Kerala");
		WebElement postalCode = driver.findElement(By.xpath(
				"/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[10]/td[2]/input"));
		postalCode.sendKeys("680614");
		WebElement username = driver.findElement(By.cssSelector("#email"));
		username.sendKeys("JittyWilson");
		WebElement password = driver.findElement(By.cssSelector(
				"body > div:nth-child(5) > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > form > table > tbody > tr:nth-child(14) > td:nth-child(2) > input[type=password]"));
		password.sendKeys("Jitty123");
		WebElement confirmPassword = driver.findElement(By.cssSelector(
				"body > div:nth-child(5) > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > form > table > tbody > tr:nth-child(15) > td:nth-child(2) > input[type=password]"));
		confirmPassword.sendKeys("Jitty123");
		WebElement submitButton = driver.findElement(By.name("submit"));
		submitButton.click();

	}

}
