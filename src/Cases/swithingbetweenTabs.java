package Cases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class swithingbetweenTabs {
	WebDriver wd;

	@BeforeMethod
	public void start() {
		// To launch firefox browser
		System.setProperty("webdriver.gecko.driver", "D:\\Automation_Environment\\ChromeIE_Drivers\\geckodriver.exe");
		wd = new FirefoxDriver();
		// --------To launch chrome browser
		// System.setProperty("webdriver.chrome.driver",
		// "D:\\Automation_Environment\\ChromeIE_Drivers\\chromedriver.exe");
		// wd = new ChromeDriver();
		// --------To launch IE browser
		// System.setProperty("webdriver.ie.driver",
		// "D:\\Automation_Environment\\ChromeIE_Drivers\\IEDriverServer.exe");
		// wd = new InternetExplorerDriver();

	}

	@Test
	public void switchingtab() throws InterruptedException {
		wd.manage().window().maximize();
		wd.get("http://localhost:81/Default.aspx");
		wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		wd.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
		// Open URL In 2nd tab.
		wd.get("http://localhost:81/login.aspx");

	}

	public void switchtab() {
		wd.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "\t");
		wd.switchTo().defaultContent();

	}

	@AfterMethod()
	public void end() {
		// wd.quit();
	}

}
