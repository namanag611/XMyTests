package Cases;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class locateXYposition {

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
	public void locateXY() throws InterruptedException {
		wd.get("http://localhost:81/Default.aspx");
		wd.manage().window().maximize();
		WebElement logo = wd.findElement(By.xpath("//a[contains(text(),'urShop')]"));
		int Xcord = logo.getLocation().getX();
		System.out.println("X Position: " + Xcord);
		int Ycord = logo.getLocation().getY();
		System.out.println("Y Position: " + Ycord);

		// Using Point Class
		Point point = logo.getLocation();
		int xcord = point.getX();
		System.out.println("Element's Position from left side Is " + xcord + " pixels.");
		int ycord = point.getY();
		System.out.println("Element's Position from left side Is " + ycord + " pixels.");

	}

	@AfterMethod()
	public void end() {
		wd.quit();
	}

}
