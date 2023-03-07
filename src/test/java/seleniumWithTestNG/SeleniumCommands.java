package seleniumWithTestNG;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumCommands {
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
	public void tearDown()
	{
		//driver.close();
		driver.quit();
	}
	@Test
	public void tc_001_verifyObsquraTitle()
	{
		driver.get("https://selenium.obsqurazone.com/index.php");
	}
	@Test
	public void tc_006_verifySuccessfulFormSubmission()
	{
		driver.get("https://selenium.obsqurazone.com/form-submit.php");
		WebElement firstName = driver.findElement(By.xpath("//input[@id='validationCustom01']"));
		WebElement lastName = driver.findElement(By.xpath("//input[@id='validationCustom02']"));
		WebElement userName = driver.findElement(By.xpath("//input[@id='validationCustomUsername']"));
		WebElement city = driver.findElement(By.xpath("//input[@id='validationCustom03']"));
		WebElement state = driver.findElement(By.xpath("//input[@id='validationCustom04']"));
		WebElement zip = driver.findElement(By.xpath("//input[@id='validationCustom05']"));
		firstName.sendKeys("Jitty");
		lastName.sendKeys("Wilson");
		userName.sendKeys("jittywilson");
		city.sendKeys("Kochi");
		state.sendKeys("Kerala");
		zip.sendKeys("12255");
		WebElement checkbox = driver.findElement(By.xpath("//input[@class='form-check-input']"));
		checkbox.click();
		WebElement submitButton = driver.findElement(By.xpath("//button[text()='Submit form']"));
		submitButton.click();
		WebElement successMessage = driver.findElement(By.xpath("//div[@id='message-one']"));
		String actualMessage = successMessage.getText();
		String expectedMessage = "Form has been submitted successfully!";
		Assert.assertEquals(actualMessage, expectedMessage,"Invalid Message found");
	}
	@Test
	public void tc_007_Verify_RequestFormSuccessfullSubmission() throws InterruptedException
	{
		driver.get("https://phptravels.com/demo/");
		WebElement firstName = driver.findElement(By.xpath("//input[@class='first_name input mb1']"));
		firstName.sendKeys("Jitty");
		WebElement lastName = driver.findElement(By.xpath("//input[@class='last_name input mb1']"));
		lastName.sendKeys("Wilson");
		WebElement businessName =driver.findElement(By.xpath("//input[@class='business_name input mb1']"));
		businessName.sendKeys("Demo");
		WebElement email =driver.findElement(By.xpath("//input[@class='email input mb1']"));
		email.sendKeys("jitty@gmail.com");
		WebElement num1 = driver.findElement(By.xpath("//span[@id='numb1']"));
		String n1 = num1.getText();
		int number1 = Integer.parseInt(n1);
		WebElement num2 =driver.findElement(By.xpath("//span[@id='numb2']"));
		String n2 = num2.getText();
		int number2 = Integer.parseInt(n2);
		int sum = number1+number2;
		WebElement result = driver.findElement(By.xpath("//input[@id='number']"));
		String s = result.getText();
		int actualResult = Integer.parseInt(s);
		result.sendKeys(s);
		//Assert.assertEquals(actualResult, sum);
		JavascriptExecutor js =(JavascriptExecutor)driver;
	    js.executeScript("window.scrollBy(0,200)","");
		WebElement submitButton = driver.findElement(By.xpath("//button[text()='Submit']"));
		submitButton.click();
		
	}
	@Test
	public void tc_008_VerifyQuitandClose()
	{
		driver.get("https://demo.guru99.com/popup.php");
		WebElement clickButton = driver.findElement(By.xpath("//a[text()='Click Here']"));
		clickButton.click();
	}
	@Test
	public void tc_009_verify_NavigateTo()
	{
		driver.navigate().to("https://demowebshop.tricentis.com");
	}
	@Test
	public void tc_010_verifyAndRefresh()
	{
		driver.get("https://demowebshop.tricentis.com");
		WebElement email = driver.findElement(By.xpath("//input[@id='newsletter-email']"));
		email.sendKeys("jitty@gmail.com");
		driver.navigate().refresh();
	}
	@Test
	public void tc_011_verifyForwardAndBackwardNavigation() throws InterruptedException
	{
		driver.get("https://demowebshop.tricentis.com");
		WebElement loginButton = driver.findElement(By.xpath("//a[@class='ico-login']"));
		loginButton.click();
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
	}
	@Test
	public void tc_012_verify_IsEnabled()
	{
		driver.get("https://selenium.obsqurazone.com/ajax-form-submit.php");
        WebElement submitButton = driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
        boolean status = submitButton.isEnabled();
        System.out.println(status);
        Assert.assertTrue(status, "submit button not enabled");
        Point point = submitButton.getLocation();	
        System.out.println(point.x + "," + point.y);
        Dimension dim = submitButton.getSize();
        System.out.println(dim.height + "," + dim.width);
        String backgroundColor = submitButton.getCssValue("background-color");
        System.out.println(backgroundColor);
        WebElement element = driver.findElement(By.tagName("input"));
        System.out.println(element);
        List<WebElement> elements = driver.findElements(By.tagName("input"));
        System.out.println(elements);
        submitButton.submit();
	}
	@Test
	public void tc_013_verify_IsDisplayed()
	{
		driver.get("https://selenium.obsqurazone.com/ajax-form-submit.php");
		WebElement subjectTextBox = driver.findElement(By.xpath("//input[@id='subject']"));
		Boolean status = subjectTextBox.isDisplayed();
		System.out.println(status);
		Assert.assertTrue(status,"Subject field is not displayed");
	}
	@Test
	public void tc_014_verify_isSelected()
	{
		driver.get("https://selenium.obsqurazone.com/check-box-demo.php");
		WebElement checkbox = driver.findElement(By.xpath("//input[@id='gridCheck']"));
		Boolean beforeClick = checkbox.isSelected();
		System.out.println(beforeClick);
		Assert.assertFalse(beforeClick,"Check is selected");
		checkbox.click();
		Boolean afterClick = checkbox.isSelected();
		System.out.println(afterClick);
		Assert.assertTrue(afterClick,"Check is not selected");
		
	}
	@Test
	public void tc_015_verify_webElementCommands() throws InterruptedException
	{
		driver.get("https://selenium.obsqurazone.com/ajax-form-submit.php");
        WebElement subjectField = driver.findElement(By.xpath("//input[@id='subject']"));
        subjectField.sendKeys("Selenium");
        WebElement descriptionField = driver.findElement(By.xpath("//textarea[@id='description']"));
        descriptionField.sendKeys("Automation Testing");
        WebElement submitButton = driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
        subjectField.clear();
        String classAttributeValue = subjectField.getAttribute("class");
        System.out.println("test" + classAttributeValue);
        String TagNameValue = subjectField.getTagName();
        System.out.println("test" + TagNameValue);
        subjectField.sendKeys("Selenium Testing");
        submitButton.click();
        Thread.sleep(10000);
        WebElement successValidationMessage = driver.findElement(By.id("message-one"));
        String expectedValidationMessage = "Form has been submitted successfully!";
        Assert.assertEquals(successValidationMessage.getText(), expectedValidationMessage, "Invalid Message");
	}
	@Test
	public void tc_016_verify_assertion()
	{
		driver.get("https://demowebshop.tricentis.com/");
		WebElement email = driver.findElement(By.xpath("//input[@id='newsletter-email']"));
		email.sendKeys("Jitty@gmail.com");
		WebElement subscribeButton = driver.findElement(By.xpath("//input[@id='newsletter-subscribe-button']"));
		subscribeButton.click();
		WebElement actualMessage = driver.findElement(By.id("newsletter-result-block"));
		String successMessage = actualMessage.getText();
		System.out.println("********"+successMessage);
		String expectedMessage = "Thank you for signing up! A verification email has been sent. We appreciate your interest.";
		Assert.assertEquals(successMessage, expectedMessage,"Invalid message");
		
		
	}
	@Test
	public void tc_017_verify_isDisplayed()
	{
		driver.get("https://selenium.obsqurazone.com/ajax-form-submit.php");
        WebElement subjectField = driver.findElement(By.xpath("//input[@id='subject']"));
        subjectField.sendKeys("Selenium");
        boolean status = subjectField.isDisplayed();
        System.out.println(status);
        Assert.assertTrue(status, "Subject field is not displayed");
	}
	@Test
	public void tc_018_verify_isSelected()
	{
		driver.get("https://selenium.obsqurazone.com/check-box-demo.php");
        WebElement singleDemoCheckBox = driver.findElement(By.xpath("//input[@id='gridCheck']"));
        boolean statusBeforeClick = singleDemoCheckBox.isSelected();
        System.out.println(statusBeforeClick);
        Assert.assertFalse(statusBeforeClick, "Checkbox is selected");
        singleDemoCheckBox.click();
        boolean status = singleDemoCheckBox.isSelected();
        System.out.println(status);
        Assert.assertTrue(status, "Checkbox is not selected");
	}
	@Test
	public void tc_019_verify_isEnabled()
	{
		driver.get("https://selenium.obsqurazone.com/ajax-form-submit.php");
        WebElement submitButton = driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
        boolean status = submitButton.isEnabled();
        System.out.println(status);
        Assert.assertTrue(status, "submit button not enabled");
        //webelement commands
        Point point = submitButton.getLocation();
        System.out.println(point.x + "," + point.y);
        Dimension dim = submitButton.getSize();
        System.out.println(dim.height + "," + dim.width);
        String backgroundColor = submitButton.getCssValue("background-color");
        System.out.println(backgroundColor);
        // find element and find elements
        WebElement element = driver.findElement(By.tagName("input"));
        System.out.println(element);
        List<WebElement> elements = driver.findElements(By.tagName("input"));
        System.out.println(elements);
        submitButton.submit();
	}
	@Test
	public void tc_020_verify_MesageDisplayedInNewTab()
	{
		driver.get("https://demoqa.com/browser-windows");
        WebElement newTabButton = driver.findElement(By.id("tabButton"));
        boolean status = newTabButton.isEnabled();
        Assert.assertTrue(status, "submit button not enabled");
        newTabButton.click();
        driver.navigate().to("https://demoqa.com/sample");
        WebElement sampleHeading = driver.findElement(By.id("sampleHeading"));
        String actualMessage = sampleHeading.getText();
        String expectedText = "This is a sample page";
        Assert.assertEquals(actualMessage, expectedText, "Invalid message");
	}
	@Test
	public void tc_021_verify_MesageDisplayedInNewWindow()
	{
		driver.get("https://demoqa.com/browser-windows");
        String parentWindow = driver.getWindowHandle();
        System.out.println("parent window id =" + parentWindow);
        WebElement newWindowClickButton = driver.findElement(By.id("windowButton"));
        newWindowClickButton.click();
        Set<String> handles = driver.getWindowHandles();
        System.out.println(handles);
        Iterator<String> handleIds = handles.iterator();
        while (handleIds.hasNext()) 
        {
            String childWindow = handleIds.next();
            if (!childWindow.equals(parentWindow)) 
            {
                driver.switchTo().window(childWindow);
                WebElement simpleHeading = driver.findElement(By.id("sampleHeading"));
                String actualText = simpleHeading.getText();
                String expectedText = "This is a sample page";
                Assert.assertEquals(actualText, expectedText, "Message not found");
                driver.close();

            }
        }
        driver.switchTo().window(parentWindow);
    }
	@Test
	public void tc_021_verify_simpleAlert()
	{
		driver.get("https://selenium.obsqurazone.com/javascript-alert.php");
        WebElement clickMe = driver.findElement(By.xpath("//button[@class='btn btn-success']"));
        clickMe.click();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println(alertText);
        alert.accept();
	}
	@Test
	public void tc_022_verify_confirmAlert()
	{
		driver.get("https://selenium.obsqurazone.com/javascript-alert.php");
        WebElement clickMe = driver.findElement(By.xpath("//button[@class='btn btn-warning']"));
        clickMe.click();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println(alertText);
        alert.dismiss();
	}
	@Test
	public void tc_023_verify_promptAlert()
	{
		driver.get("https://selenium.obsqurazone.com/javascript-alert.php");
        WebElement clickMe = driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
        clickMe.click();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println(alertText);
        alert.sendKeys("Text message");
        alert.accept();
	}
	@Test
	public void tc_024_verify_textInaFrame()
	{
		driver.get("https://demoqa.com/frames");
        List<WebElement> frames = driver.findElements(By.tagName("iframe"));
        int numberofFrames = frames.size();
        System.out.println(numberofFrames);
//        driver.switchTo().frame(3); // using index
//        driver.switchTo().frame("frame1"); // using name or id
        // using web element
        WebElement frame = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(frame);
        WebElement heading = driver.findElement(By.id("sampleHeading"));
        String headingText = heading.getText();
        System.out.println(headingText);
//        driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();
	}
}