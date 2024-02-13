package steps;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import drivers.DriverInstance;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;

public class Dashboard extends DriverInstance{
	static String module = "Personal Result";
	
	@When("User clicks on Personal Result")
	public void userClicksOnPersonalResult() {
		String wholeDiv = "/html/body/div[4]/div[3]/div/div/div[2]";

		// Find the number of smallDiv elements
		List<WebElement> smallDivElements = driver.findElements(By.xpath(wholeDiv + "/div"));
		int x = 1;

		for (WebElement smallDivElement : smallDivElements) {
		    String smallDiv = wholeDiv + "/div[" + x + "]";
		    
		    // Find the li elements within the current smallDiv starting from li[3]
		    List<WebElement> liElements = smallDivElement.findElements(By.xpath(smallDiv + "/ul/li[position() > 2]/p"));
		    
		    for (WebElement liElement : liElements) {
		        if (liElement.getText().contains(module)) {
		            liElement.click();
		            System.out.println(" - Clicked on '" + module +"' li element.");
		            return; // If found and clicked, exit the loop
		        }
		    }
		    x++;
		}
	}
	
	@Then("Dashboard page should be displayed")
	public void dashboardPageShouldBeDisplayed() {
		WebElement header = null;

		try {
			header = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div[2]/div[1]/div[1]/p[1]"));
			String getTitle = header.getText();

			if (getTitle.equals("Total Customers")) {
				System.out.println(" - The Dashboard page is present");
				byte[] screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				Allure.addAttachment("Step", "image/png", new ByteArrayInputStream(screenshot1), "png");
			} else {
				Assert.assertEquals(getTitle, "Total Customers");
				byte[] screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				Allure.addAttachment("Step ERROR", "image/png", new ByteArrayInputStream(screenshot1), "png");
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(header, "The Dashboard Page is not presented");
			System.out.println(" - The Dashboard page is not present");
		}
	}
}
