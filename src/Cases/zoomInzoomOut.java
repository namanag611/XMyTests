package Cases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class zoomInzoomOut {

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
	public void zoominandout() throws IOException, InterruptedException {
		wd.get("http://localhost:81/Default.aspx");
		Thread.sleep(3000);
		// zoomIn();
		zoominrobot();
		zoomOut();
		set100();

	}

	public void zoomIn() {

		for (int i = 1; i < 4; i++) {
			wd.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, Keys.ADD));
		}

	}

	public void zoomOut() {
		for (int i = 1; i <= 4; i++) {
			wd.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		}
	}

	public void set100() {
		wd.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, "0"));
	}

	public void zoominrobot() {
		Robot r;
		try {
			r = new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_ADD);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@AfterMethod()
	public void end() {
		wd.quit();
	}

}
