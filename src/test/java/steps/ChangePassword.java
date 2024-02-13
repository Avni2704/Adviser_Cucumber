package steps;

import java.io.ByteArrayInputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import drivers.DriverInstance;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;

public class ChangePassword extends DriverInstance {

	static String NewPassword;
	static String ConfirmPassword;
	
	@When("User clicks on the Change Password")
	public void userClicksOnTheChangePassword() throws InterruptedException {
		WebElement Button = null;
		try {
			Button = driver.findElement(By.xpath("/html/body/div[4]/div[3]/ul/li[2]"));
			Button.click();
			Thread.sleep(500);

		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.fail("User could not be able to click the Change Password button");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(500);
		}
	}
	@Then("Reset Password page should be displayed")
	public void resetPasswordPageShouldBeDisplayed() {
		WebElement header = null;

		try {
			header = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/h1"));
			String getTitle = header.getText();

			if (getTitle.equals("Reset Password")) {
				System.out.println(" - The Reset Password page is present");
				byte[] screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				Allure.addAttachment("Step", "image/png", new ByteArrayInputStream(screenshot1), "png");
			} else {
				Assert.assertEquals(getTitle, "Reset Password");
				byte[] screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				Allure.addAttachment("Step ERROR", "image/png", new ByteArrayInputStream(screenshot1), "png");
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(header, "The Reset Password Page is not presented");
			System.out.println(" - The Reset Password page is not present");
		}
	}
	
	@When("User inserts value for current password as {string}")
	public void userInsertsValueForCurrentPasswordAs(String password) throws InterruptedException {
		WebElement input = null;

		try {
			input = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/form/div[1]/div/div/div/input"));
			input.sendKeys(password);
			Thread.sleep(500);
			
			driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/form/div[1]/div/div/div/div[2]/button")).click();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(input, "User could not be able to Insert Value to current password textbox");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(500);
		}
	}
	@When("User inserts value for New Password as {string}")
	public void userInsertsValueForNewPasswordAs(String newPassword) throws InterruptedException {
		WebElement input = null;
		try {
			input = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/form/div[2]/div/div/div/input"));
			input.sendKeys(newPassword);
			NewPassword = newPassword;
			Thread.sleep(500);
			
			driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/form/div[2]/div/div/div/div[2]/button")).click();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(input, "User could not be able to Insert Value to new password textbox");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(500);
		}
	}
	@When("User inserts value for Confirm Password as {string}")
	public void userInsertsValueForConfirmPasswordAs(String confirmPassword) throws InterruptedException {
		WebElement input = null;

		try {
			input = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/form/div[4]/div/div/div/input"));
			input.sendKeys(confirmPassword);
			ConfirmPassword = confirmPassword;
			Thread.sleep(500);
			
			driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/form/div[4]/div/div/div/div[2]/button")).click();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(input, "User could not be able to Insert Value to confirm password textbox");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(500);
		}
	}
	@When("User Clicks Reset Password button")
	public void userClicksResetPasswordButton() throws InterruptedException {
		WebElement Button = null;
		try {
			Button = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/form/div[5]/button[2]"));
			Button.click();
			Thread.sleep(500);

		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(Button, "User could not be able to click on the Reset Password button");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(500);
		}
	}
	@When("The password should not be reset.")
	public void thePasswordShouldNotBeReset() {
		WebElement nameString = null;
		String validation = null;
		
	   if (NewPassword  == null) {
			try {
				nameString = driver.findElement(
						By.xpath("/html/body/div[3]/div[3]/div/form/div[2]/div/div/p"));
				validation = nameString.getText();
				System.out.println(" - validation = " + validation);
			} catch (Exception e) {
				Assert.assertEquals(validation, "This field is required.");
			}
		} else if (ConfirmPassword == null) {
			try {
				nameString = driver.findElement(
						By.xpath("/html/body/div[3]/div[3]/div/form/div[4]/div/div/p"));
				validation = nameString.getText();
				System.out.println(" - validation = " + validation);
			} catch (Exception e) {
				Assert.assertEquals(validation, "This field is required.");
			}   
	   } else if (!NewPassword.equals(ConfirmPassword)) {

			try {
				nameString = driver.findElement(
						By.xpath("/html/body/div[3]/div[3]/div/form/div[4]/div/div/p"));

				validation = nameString.getText();
				System.out.println(" - validation = " + validation);
			} catch (Exception e) {
				Assert.assertEquals(validation, "New Password are not matched");
				Assert.fail("System allows user to update password instead of throwing validation error");
			}

		}
		allureScreenshot();
	}
	
	@When("User skips Confirm New Password textbox")
	public void userSkipsConfirmNewPasswordTextbox() {
		ConfirmPassword = null;
	}
	@When("User skips New Password textbox")
	public void userSkipsNewPasswordTextbox() {
		NewPassword = null;
	}
	
	@Then("The password should be reset")
	public void thePasswordShouldBeReset() throws InterruptedException {
		WebElement Button = null;
		try {
			allureScreenshot();
			
			Button = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/button"));
			Button.click();
			Thread.sleep(500);

		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(Button, "User could not be able to click on the CLOSE button");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(500);
		}
	}
	@When("User logs in using new Password: {string}")
	public void userLogsInUsingNewPassword(String password) throws InterruptedException {
		WebElement Email = driver
				.findElement(By.xpath("/html/body/div[1]/main/div/div/div/div/form/div[1]/div/div/div/input"));
		Email.sendKeys("adviser.vka@gmail.com");

		WebElement Password = driver
				.findElement(By.xpath("/html/body/div[1]/main/div/div/div/div/form/div[2]/div/div/div/input"));
		Password.sendKeys(password);

		WebElement Login = driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div/div/form/button"));
		Login.click();
		Thread.sleep(5000);
	}
	
	//VkaTest@23
}
