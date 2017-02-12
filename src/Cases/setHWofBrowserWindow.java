package Cases;

import java.io.IOException;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class setHWofBrowserWindow {

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

	@Test(priority = 1, enabled = false)
	public void setheightandwidth() throws IOException {
		// wd.get("http://localhost:81/Default.aspx");
		wd.manage().window().setSize(new Dimension(300, 500));

		// WebDriver getSize method used to get window width and height.
		System.out.println("Window height Is -> " + wd.manage().window().getSize().getHeight());
		System.out.println("Window width Is -> " + wd.manage().window().getSize().getWidth());

	}

	@Test(priority = 2)
	public void setbrowserposition() {
		wd.manage().window().setPosition(new Point(500, 500));
		wd.get("http://localhost:81/Default.aspx");
		System.out.println("Window X Position Is -> " + wd.manage().window().getPosition().getX());
		System.out.println("Window Y Position Is -> " + wd.manage().window().getPosition().getY());
	}

	@AfterMethod()
	public void end() {
		wd.quit();
	}

}
