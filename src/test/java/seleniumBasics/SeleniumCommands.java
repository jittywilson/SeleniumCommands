package seleniumBasics;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SeleniumCommands {

	public static void main(String[] args) {
//		WebDriver driver = new ChromeDriver();
//		driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");	
//		driver.manage().window().maximize();
		
		WebDriver driver1 = new EdgeDriver();
		driver1.get("https://selenium.obsqurazone.com/simple-form-demo.php");	
		driver1.manage().window().maximize();

	}

}
