package drivers;

import java.io.ByteArrayInputStream;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Allure;
import qa.util.Variables;

public class DriverInstance extends Variables {

	public static RemoteWebDriver driver;
	public static WebDriverWait wait;
	
	public void allureScreenshot() {
		byte[] screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		Allure.addAttachment("Step Screenshot", "image/png", new ByteArrayInputStream(screenshot1), "png");
	}
	
	public void allureScreenshotAnotherTab() {
	    // Capture the handles of all open tabs
	    Set<String> windowHandles = driver.getWindowHandles();

	    // Switch to the new tab (assuming it's the last one opened)
	    for (String handle : windowHandles) {
	        driver.switchTo().window(handle);
	    }

	    // Take a screenshot
	    byte[] screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	    Allure.addAttachment("New Tab Screenshot", "image/png", new ByteArrayInputStream(screenshot1), "png");

	    // Switch back to the original tab (assuming it's the first one opened)
	    driver.switchTo().window(windowHandles.iterator().next());
	}
	
	public void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0, 500);");
	}
	
	public static String forgotPasswordLink = "https://vka.uat.adviser.lengzai.asia/auth/reset-password?id=4c071eca2d7cb6de42c603f43682221c0ba7200dbcc9cd835f5c0b6d67729038";
}
