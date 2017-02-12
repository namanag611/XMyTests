package Cases;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class scrollDownWebpage {
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
		wd.get("http://localhost:81/Default.aspx");
	}

	@Test(priority = 1)
	public void scrollpage() throws InterruptedException {

		wd.manage().window().maximize();
		JavascriptExecutor javascript = (JavascriptExecutor) wd;
		javascript.executeScript("window.scrollBy(0,600)", "");

		Thread.sleep(3000);

	}

	@Test(priority = 2)
	public void Scroll_Page() throws IOException, InterruptedException {
		// Scroll down to bottom of the page.
		JavascriptExecutor javascript = (JavascriptExecutor) wd;
		javascript.executeScript("window.scrollTo(0, document.body.scrollHeight)", "");
		Thread.sleep(3000);
	}

	@AfterMethod()
	public void end() {
		wd.quit();
	}

}
