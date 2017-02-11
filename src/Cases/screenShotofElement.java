package Cases;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class screenShotofElement {
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
	public void HeightWidth() throws IOException {
		wd.get("http://localhost:81/Default.aspx");
		wd.manage().window().maximize();
		WebElement logo = wd.findElement(By.xpath("//a[contains(text(),'urShop')]"));
		capturescreenshot_onlyElement(logo);
		capturescreenshot_complete();
	}

	public void capturescreenshot_onlyElement(WebElement element) throws IOException {

		int height = element.getSize().getHeight();
		int width = element.getSize().getWidth();
		Point point = element.getLocation();
		int xcord = point.getX();
		int ycord = point.getY();

		File screen = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
		BufferedImage image = ImageIO.read(screen); // Reading complete screeen
		// Cutting image
		BufferedImage dest = image.getSubimage(xcord, ycord, width, height);
		ImageIO.write(dest, "png", screen);
		FileUtils.copyFile(screen, new File("D:\\screenshot.png"));
	}

	public void capturescreenshot_complete() throws IOException {

		File screen = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File("D:\\screenshot1.png"));
	}

	@AfterMethod()
	public void end() {
		wd.quit();
	}

}
