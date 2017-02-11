package Cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class getHeightWidth {

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
	public void getHeightWidth() {
		wd.get("http://localhost:81/Default.aspx");
		wd.manage().window().maximize();
		WebElement logo = wd.findElement(By.xpath("//a[contains(text(),'urShop')]"));

		int height = logo.getSize().getHeight();
		int width = logo.getSize().getWidth();

		System.out.println("Image height Is " + height + " pixels");
		System.out.println("Image width Is " + width + " pixels");

	}

	@AfterMethod()
	public void end() {
		wd.quit();
	}

}
