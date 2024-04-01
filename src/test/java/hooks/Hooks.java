package hooks;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import drivers.DriverInstance;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class Hooks extends DriverInstance {

	@BeforeStep
	public void beforeSteps(Scenario scenario) {
		//System.out.println(" - Before ID = " + scenario.getId());
		//.getId == either scenario or outline
		//.getLine == outline and scenario
		//.getUri == return the path of the feature file
		//.getSourceTagNames == return the tags in the scenario
		//.getStatus == return test result
		//System.out.println(" - After ID = " + scenario.getId());
	}
	
	@AfterStep
	public void afterSteps(Scenario scenario) {		
		byte[] screenshotAs = driver.getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshotAs, "image/png" , "Screenshot");
	}
	
	@Before
	public void beforeScenario(Scenario scenario) {
		System.out.println("Hello Portal");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Set the timeout duration here
		driver.get("https://vka.uat.adviser.lengzai.asia/auth/login/");
		driver.manage().window().maximize();
		
		String scenName = scenario.getName();
		System.out.println("Scenario Name: " + scenName);
	}
	
	@After
	public void afterScenario(Scenario scenario) {
		boolean failed = scenario.isFailed();
		System.out.println("Is Failed: " + failed);
		
		if (failed) {
			byte[] screenshotAs = driver.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshotAs, "image/png", "Error Screenshot");
		} else {
			byte[] screenshotAs = driver.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshotAs, "image/png", "Page Screenshot");
			driver.close();
		}
		
		System.out.println("============================================================================");
	}
}
