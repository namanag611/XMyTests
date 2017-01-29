package Cases;

import static org.monte.media.FormatKeys.EncodingKey;
import static org.monte.media.FormatKeys.FrameRateKey;
import static org.monte.media.FormatKeys.KeyFrameIntervalKey;
import static org.monte.media.FormatKeys.MIME_AVI;
import static org.monte.media.FormatKeys.MediaTypeKey;
import static org.monte.media.FormatKeys.MimeTypeKey;
import static org.monte.media.VideoFormatKeys.CompressorNameKey;
import static org.monte.media.VideoFormatKeys.DepthKey;
import static org.monte.media.VideoFormatKeys.ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE;
import static org.monte.media.VideoFormatKeys.QualityKey;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.util.concurrent.TimeUnit;

import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class testRecordVideo {

	public WebDriver Driver;
	private ScreenRecorder screenRecorder;

	@Test
	public void testGoogleSearch() throws Exception {

		testRecordVideo videoRecord = new testRecordVideo();
		videoRecord.startRecording();
		System.setProperty("webdriver.gecko.driver", "D:\\Automation_Environment\\ChromeIE_Drivers\\geckodriver.exe");
		Driver = new FirefoxDriver();
		Driver.get("http://localhost:81/Default.aspx");
		Driver.findElement(By.linkText("Login")).click();
		WebElement webelement = Driver.findElement(By.linkText("Create an Account"));
		Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Driver.findElement(By.linkText("Back to Previous Page")).click();
		Thread.sleep(7000);
		videoRecord.stopRecording();
	}

	@AfterMethod
	public void close() throws Exception {
		// Close the browser
		Driver.quit();
		// Call the stop method of ScreenRecorder to end the recording
	}

	public void startRecording() throws Exception {
		GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice()
				.getDefaultConfiguration();

		this.screenRecorder = new ScreenRecorder(gc, new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
				new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
						CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey, 24, FrameRateKey,
						Rational.valueOf(15), QualityKey, 1.0f, KeyFrameIntervalKey, 15 * 60),
				new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(30)),
				null);
		this.screenRecorder.start();
	}

	public void stopRecording() throws Exception {
		this.screenRecorder.stop();

	}

}
