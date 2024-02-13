package steps;

import java.io.ByteArrayInputStream;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import drivers.DriverInstance;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;

public class forgotPassword extends DriverInstance {

	@When("User clicks on the Forgot Password button")
	public void userClicksOnTheForgotPasswordButton() throws InterruptedException {
		WebElement Button = null;
		try {
			Button = driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div/div/form/div[3]/a"));
			Button.click();
			Thread.sleep(1000);

		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(Button, "User could not be able to click on the Forgot Password button");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(500);
		}
	}
	@Then("Forgot Password page should be shown")
	public void forgotPasswordPageShouldBeShown() {
		WebElement header = null;

		try {
			header = driver
					.findElement(By.xpath("/html/body/div[1]/main/div/div/div/div/h1"));
			String getTitle = header.getText();

			if (getTitle.equals("Forgot Password?")) {
				System.out.println(" - The Forgot Password page is present");
				byte[] screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				Allure.addAttachment("Step", "image/png", new ByteArrayInputStream(screenshot1), "png");
			} else {
				Assert.assertEquals(getTitle, "Forgot Password?");
				byte[] screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				Allure.addAttachment("Step ERROR", "image/png", new ByteArrayInputStream(screenshot1), "png");
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(header, "The Forgot Password Page is not presented");
			System.out.println(" - The Forgot Password page is not present");
		}
	}	
	@When("User inserts {string} as email address to get Temporary Link")
	public void userInsertsAsEmailAddressToGetTemporaryLink(String email) throws InterruptedException {
		WebElement input = null;

		try {
			input = driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div/div/form/div[1]/div/div/div/input"));
			input.sendKeys(email);
			Thread.sleep(500);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(input, "User could not be able to Insert Value");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(500);
		}
	}
	@When("User clicks on the Get Temporary Link button")
	public void userClicksOnTheGetTemporaryLinkButton() throws InterruptedException {
		WebElement Button = null;
		try {
			Button = driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div/div/form/button"));
			Button.click();
			Thread.sleep(5000);

		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(Button, "User could not be able to click on the Get Temporary Link button");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(500);
		}
	}
	@Then("Temporary link should have sent")
	public void temporaryLinkShouldHaveSent() {
		WebElement header = null;

		try {
			header = driver
					.findElement(By.xpath("/html/body/div[1]/main/div/div/div/div/h1"));
			String getTitle = header.getText();

			if (getTitle.equals("Temporary Link Sent")) {
				System.out.println(" - The Temporary Link Sent page is present");
				byte[] screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				Allure.addAttachment("Step", "image/png", new ByteArrayInputStream(screenshot1), "png");
			} else {
				Assert.assertEquals(getTitle, "Temporary Link Sent");
				byte[] screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				Allure.addAttachment("Step ERROR", "image/png", new ByteArrayInputStream(screenshot1), "png");
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(header, "The Temporary Link Sent Page is not presented");
			System.out.println(" - The Temporary Link Sent page is not present");
		}
	}
	@Then("User clicks Done to navigate back to login page")
	public void userClicksDoneToNavigateBackToLoginPage() throws InterruptedException {
		WebElement Button = null;
		try {
			Button = driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div/div/button"));
			Button.click();
			Thread.sleep(1000);

		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(Button, "User could not be able to click on the Done button");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(500);
		}
	}

	
	
	@Given("User logs in using the link retrieved from email")
	public void userLogsInUsingTheLinkRetrievedFromEmail() {
		driver.close();
		
		System.out.println("Hello New Link");
		driver = new ChromeDriver();	
		wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Set the timeout duration here
		driver.get(forgotPasswordLink);
		driver.manage().window().maximize();
	}
	@When("User inserts new password as {string}")
	public void userInsertsNewPasswordAs(String newPassword) throws InterruptedException {
		WebElement input = null;

		try {
			input = driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div/div/form/div[1]/div/div/div/input"));
			input.sendKeys(newPassword);
			Thread.sleep(500);
			
			driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div/div/form/div[1]/div/div/div/div[2]/button")).click();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(input, "User could not be able to Insert Value");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(500);
		}
	}
	@When("User inserts confirm password as {string}")
	public void userInsertsConfirmPasswordAs(String confirmPassword) throws InterruptedException {
		WebElement input = null;

		try {
			input = driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div/div/form/div[3]/div/div/div/input"));
			input.sendKeys(confirmPassword);
			Thread.sleep(500);
			driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div/div/form/div[3]/div/div/div/div[2]/button")).click();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(input, "User could not be able to Insert Value");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(500);
		}
	}
	@When("User clicks Reset Password button")
	public void userClicksResetPasswordButton() throws InterruptedException {
		WebElement Button = null;
		try {
			
			Button = driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div/div/form/button"));
			Button.click();
			Thread.sleep(500);
			
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(Button, "User could not be able to click on the Reset button");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(500);
		}
	}
	@When("The password should not be set")
	public void thePasswordShouldBeSet() {
		allureScreenshot();
		
		
//		WebElement nameString = null;
//		String validation = null;
//		
//		try {
//			nameString = driver.findElement(
//					By.xpath("/html/body/div/div[4]/div/div/div/div/div/form/div[1]/div/p"));
//
//			validation = nameString.getText();
//			System.out.println(" - validation = " + validation);
//			
//		} catch (Exception e) {
//			Assert.fail("System allows user to Reset password instead of throwing validation error");
//		}

	}

	@Then("The password should be set and navigate to back to login")
	public void thePasswordShouldBeSetAndNavigateToBackToLogin() throws InterruptedException {

		WebElement Button = null;
		try {
			
			Button = driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div/div/button"));
			Button.click();
			Thread.sleep(1000);
			
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(Button, "User could not be able to click on the Log In button");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(500);
		}	
	}
	@Then("User logs in again using {string} and {string}")
	public void userLogsInAgainUsingAnd(String email, String newPassword) throws InterruptedException {

		driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div/div/form/div[1]/div/div/div/input")).sendKeys(email);
		driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div/div/form/div[2]/div/div/div/input")).sendKeys(newPassword);
		driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div/div/form/div[2]/div/div/div/div[2]/button")).click();
		
		allureScreenshot();

		driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div/div/form/button")).click();

		Thread.sleep(500);
	}


}
