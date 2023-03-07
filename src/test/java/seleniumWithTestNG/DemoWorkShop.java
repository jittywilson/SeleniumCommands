package seleniumWithTestNG;

	import java.io.File;
	import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.By;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.Assert;
	import org.testng.ITestResult;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

	public class DemoWorkShop {
		WebDriver driver;

		public void testInitialise(String browser) {
			if (browser.equals("chrome")) {
				driver = new ChromeDriver();
			} else if (browser.equals("firefox")) {
				driver = new FirefoxDriver();
			} else if (browser.equals("edge")) {
				driver = new EdgeDriver();
			} else {
				try {
					throw new Exception("Invalid browser");
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
		}
		@BeforeMethod
		public void setUp()
		{
			testInitialise("chrome");
		}
		@AfterMethod
		public void tearDown(ITestResult result) throws IOException {
			if (result.getStatus() == ITestResult.FAILURE) {
				TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
				File screenshot = takesScreenshot.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(screenshot, new File("./Screenshots/" + result.getName() + ".png"));
			}
//		    driver.close();
			driver.quit();
		}

		@Test
		public void TC_001_verifyObsquraTitle() {
	        driver.get("https://selenium.obsqurazone.com/index.php");
	        String actualTitle = driver.getTitle();                 /** Get title**/
	        String expectedTitle = "Obsqura Testing";
	        Assert.assertEquals(actualTitle, expectedTitle, "Invalid Title found");
	    }
		@Test
		public void TC_002_verifyLogin() {
			driver.get("https://demowebshop.tricentis.com/");
			WebElement loinMenu = driver.findElement(By.className("ico-login"));
	        loinMenu.click();
	        String mailId ="alby123@gmail.com";
			WebElement email=driver.findElement(By.name("Email"));
			email.sendKeys(mailId);
			WebElement password=driver.findElement(By.name("Password"));
			password.sendKeys("asd123");
			WebElement loginButton = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
	        loginButton.click();
	        WebElement userAccount = driver.findElement(By.xpath("(//a[@class='account'])[1]"));
	        String actMail = userAccount.getText();
	        Assert.assertEquals(mailId,actMail ,"Login failed");
		}
		@Test
		public void selectGender(String gen, List<WebElement> gender) {
	        for (int i = 0; i < gender.size(); i++) {
	            String genderValue = gender.get(i).getAttribute("value");
	            if (genderValue.equals(gen)) {
	                gender.get(i).click();

	            }
	        }
	    }
		@Test
		public void TC_004_verifyTitleFromExcelSheet() throws IOException {
			driver.get("https://demowebshop.tricentis.com/");
			String actualTitle = driver.getTitle();                 /** Get title**/
	        String excelPath = "\\src\\test\\resources\\TestData.xlsx";
	        String sheetName = "HomePage";
	        String expectedTitle = ExcelUtility.readStringData(excelPath, sheetName, 0, 1);
	        Assert.assertEquals(actualTitle, expectedTitle, "Invalid data found in the table");
		
		}
		@Test(dataProvider = "InvalidCredentials")
		public void TC_006_verifyLoginWithInvalidDatas(String userName, String pWord) {
			driver.get("https://demowebshop.tricentis.com/");
	        WebElement loinButton = driver.findElement(By.className("ico-login"));
	        loinButton.click();
	        WebElement email = driver.findElement(By.xpath("//input[@id='Email']"));
	        email.sendKeys(userName);
	        WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
	        password.sendKeys(pWord);
		WebElement loginButton = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        loginButton.click();
        WebElement errorMessage = driver.findElement(By.xpath("//div[@class='validation-summary-errors']//span"));
        String actualMessage = errorMessage.getText();
        String expectedMessage = "Login was unsuccessful. Please correct the errors and try again.";
        Assert.assertEquals(expectedMessage, actualMessage, "Invalid error message");
    }
		@DataProvider(name="InvalidCredentials")
		public Object[][] UserCredencials()
		{
			Object [][] data = {{"jittywilson04@gmail.com", "Jitty1234"}, {"jitty@gmail.com", "Jitty@1234"},{"jitty123@gmail.com", "hdifdf"}};
			return data;
		}
	
		
		public void TC_011_verifyRegisterPageFromExcelSheetAndMailAsRandomGenrator() throws IOException {
	        String actualTitle = driver.getTitle();
	        List<ArrayList<String>> data = ExcelUtility.excelDataReader("\\src\\test\\resources\\TestData.xlsx", "Register");
	        String expectedTitle = data.get(1).get(6);
	        Assert.assertEquals(actualTitle, expectedTitle, "Invalid Title found");
	        WebElement reg1 = driver.findElement(By.xpath("//a[@class='ico-register']"));
	        reg1.click();
	        List<WebElement> gender = driver.findElements(By.xpath("//input[@name='Gender']"));
	        selectGender("F", gender);
	        WebElement firstName = driver.findElement(By.id("FirstName"));
	        String fName= data.get(1).get(1);
	        firstName.sendKeys(fName);
	        WebElement lastName = driver.findElement(By.id("LastName"));
	        String lName = data.get(1).get(2);
	        lastName.sendKeys(lName);
	        WebElement emailField = driver.findElement(By.id("Email"));
	        String emailID = RandomDataUtility.getRandomEmail();
	        emailField.sendKeys(emailID);
	        WebElement passwordField = driver.findElement(By.id("Password"));
	        String pword= data.get(1).get(4);
	        passwordField.sendKeys(pword);
	        WebElement passwordConfirm = driver.findElement(By.id("ConfirmPassword"));
	        String confirmPword= data.get(1).get(4);
	        passwordConfirm.sendKeys(confirmPword);
	        WebElement register = driver.findElement(By.id("register-button"));
	        register.click();
	        WebElement userAccount = driver.findElement(By.xpath("//div[@class='header-links']//a[@class='account']"));
	        String actualEmail = userAccount.getText();
	        Assert.assertEquals(actualEmail, emailID, "Registration failed");
	        
		
	}
}


