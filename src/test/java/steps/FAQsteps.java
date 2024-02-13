package steps;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import drivers.DriverInstance;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;

public class FAQsteps extends DriverInstance {

	//WebDriver driver;
	WebDriverWait wait;
	public int ddlNo;
	static String module = "FAQ";

	@Given("User should login as email as {string} and password as {string}")
	public void userShouldLoginAsEmailAsAndPasswordAs(String email, String password) throws InterruptedException {
		WebElement Email = driver
				.findElement(By.xpath("/html/body/div[1]/main/div/div/div/div/form/div[1]/div/div/div/input"));
		wait.until(ExpectedConditions.visibilityOf(Email));
		Email.sendKeys(email);
	
		WebElement Password = driver
				.findElement(By.xpath("/html/body/div[1]/main/div/div/div/div/form/div[2]/div/div/div/input"));
		Password.sendKeys(password);

		WebElement Login = driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div/div/form/button"));
		Login.click();
		Thread.sleep(5000);
	}

	@Given("User Navigates to Hamburger")
	public void userNavigatesToMenu() throws InterruptedException {
		// ************ MENU -start- ************		
		WebElement menu = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[1]/div[1]/button"));
		menu.click();
		System.out.println(" - MENU is clicked");
		Thread.sleep(1500);
		// ************ MENU -end- ************
	}

	@When("User navigates to FAQ")
	public void userNavigatesToFAQ() throws InterruptedException {
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
		Thread.sleep(500);
	}

	@Then("FAQ module display")
	public void faqModuleDisplay() throws InterruptedException {
		WebElement header = null;

		try {
			header = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div[1]/div/div/p"));
			String getTitle = header.getText();

			if (getTitle.equals("Frequently Asked Questions")) {
				System.out.println(" - The FAQ page is present");
				byte[] screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				Allure.addAttachment("Step", "image/png", new ByteArrayInputStream(screenshot1), "png");
			} else {
				Assert.assertEquals(getTitle, "Frequently Asked Questions");
				byte[] screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				Allure.addAttachment("Step ERROR", "image/png", new ByteArrayInputStream(screenshot1), "png");
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(header, "The FAQ Page is not presented");
			System.out.println(" - The FAQd page is not present");
		}
	}
	
	@Then("User can open and close the questions")
	public void userCanOpenAndCloseTheQuestions() throws InterruptedException {
		for (int J = 3; J < 7; J++) {
			// ************ ddl -start- ************

			ddlNo = J;
			System.out.println(" - ddlNo :" + ddlNo);

			WebElement open = driver.findElement(
					By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div[" + ddlNo + "]/div[1]/div[2]"));
			open.click();
			System.out.println(" - Question is clicked");
			Thread.sleep(500);
			allureScreenshot();

			// ************ ddl -end- ************

			WebElement close = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div[" + ddlNo + "]/div[1]/div[2]"));
			close.click();
			System.out.println(" - Question is clicked");
			Thread.sleep(500);
			allureScreenshot();

		}
	}

}
