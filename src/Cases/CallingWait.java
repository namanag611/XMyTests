package Cases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class CallingWait {

	WebDriver Driver;

	@Test
	public void run1() throws InterruptedException {

		boolean result;
		// System.setProperty("webdriver.chrome.driver",
		// "D:\\Automation_Environment\\ChromeIE_Drivers\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "D:\\Automation_Environment\\ChromeIE_Drivers\\geckodriver.exe");
		// Driver = new ChromeDriver();
		Driver = new FirefoxDriver();
		Driver.get("http://localhost:81/Default.aspx");
		Driver.findElement(By.linkText("Login")).click();
		WebElement webelement = Driver.findElement(By.linkText("Create an Account"));
		Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Thread.sleep(7000);
		Driver.findElement(By.linkText("Back to Previous Page")).click();
		result = visibilityOfElementWait(webelement);
		if (result == true) {
			System.out.println("Element is visible.");
		} else {
			System.out.println("Element is not visible");

		}
	}

	@AfterMethod
	public void end() {
		Driver.quit();
	}

	public boolean visibilityOfElementWait(WebElement webElement) {
		if (webElement != null) {
			try {
				WebDriverWait wait = new WebDriverWait(Driver, 20);
				wait.until(ExpectedConditions.visibilityOf(webElement));
				return true;
			} catch (Exception e) {
				return false;
			}
		} else
			return false;
	}
}
