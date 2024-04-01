package steps;

import java.io.ByteArrayInputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import drivers.DriverInstance;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;

public class MyProfile extends DriverInstance {


	@Given("User clicks on the Name dropdown to view the My Profile button")
	public void userClicksOnTheNameDropdownToViewTheMyProfileButton() throws InterruptedException {
		WebElement Button = null;
		try {
			Button = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[1]/div[2]/button"));
			Button.click();
			Thread.sleep(500);

			allureScreenshot();

		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.fail("User could not be able to click the Name dropdown to view My Profile button");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(500);
		}
	}
	@When("User clicks on the My Profile")
	public void userClicksOnTheMyProfile() throws InterruptedException {
		WebElement Button = null;
		try {
			Button = driver.findElement(By.xpath("/html/body/div[4]/div[3]/ul/li[1]"));
			Button.click();
			Thread.sleep(500);

		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.fail("User could not be able to click the My Profile button");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(500);
		}
	}
	@Then("My Profile page should shown")
	public void myProfilePageShouldShown() {
		WebElement header = null;

		try {
			header = driver
					.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div[3]/form/div[1]"));
			String getTitle = header.getText();

			if (getTitle.equals("Personal Details")) {
				System.out.println(" - The My Profile page is present");
				byte[] screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				Allure.addAttachment("Step 5", "image/png", new ByteArrayInputStream(screenshot1), "png");
			} else {
				Assert.assertEquals(getTitle, "Personal Details");
				byte[] screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				Allure.addAttachment("Step 5 ERROR", "image/png", new ByteArrayInputStream(screenshot1), "png");
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(header, "The My Profile Page is not presented");
			System.out.println(" - The My Profile page is not present");
		}
	}

	//Tabs
	@Given("User clicks other tab first")
	public void userClicksOtherTabFirst() throws InterruptedException {
		WebElement Button = null;
		try {
			Button = driver.findElement(By.id("course"));
			Button.click();
			Thread.sleep(500);
			
			allureScreenshot();

		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.fail("User could not be able to click the Course Tab in My Profile button");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(500);
		}
	}
	@When("User clicks on the Personal Details Tab")
	public void userClicksOnThePersonalDetailsTab() throws InterruptedException {
		WebElement Button = null;
		try {
			Button = driver.findElement(By.id("profile"));
			Button.click();
			Thread.sleep(500);
			
			allureScreenshot();

		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.fail("User could not be able to click the Personal Details Tab in My Profile button");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(500);
		}
	}
	@Then("List of Personal Details should be shown in the My Profile")
	public void listOfPersonalDetailsShouldBeShownInTheMyProfile() {
		WebElement header = null;

		try {
			header = driver
					.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div[3]/form/div[1]"));
			String getTitle = header.getText();

			if (getTitle.equals("Personal Details")) {
				System.out.println(" - The My Profile page is present");
				byte[] screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				Allure.addAttachment("Step", "image/png", new ByteArrayInputStream(screenshot1), "png");
			} else {
				Assert.assertEquals(getTitle, "Personal Details");
				byte[] screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				Allure.addAttachment("Step ERROR", "image/png", new ByteArrayInputStream(screenshot1), "png");
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(header, "The My Profile Page is not presented");
			System.out.println(" - The My Profile page is not present");
		}
	}
	
	@When("User clicks on the FOV Tab")
	public void userClicksOnTheFOVTab() throws InterruptedException {
		WebElement Button = null;
		try {
			Button = driver.findElement(By.id("fov"));
			Button.click();
			Thread.sleep(500);
			
			allureScreenshot();

		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.fail("User could not be able to click the FOV Tab in My Profile button");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(500);
		}
	}
	@Then("List of FOV should be shown in the My Profile")
	public void listOfFOVShouldBeShownInTheMyProfile()  throws InterruptedException {
		WebElement header = null;

		try {
			Thread.sleep(1500);
			header = driver
					.findElement(By.className("profile__tab-panel--title"));
			String getTitle = header.getText();

			if (getTitle.equals("FOV List")) {
				System.out.println(" - The FOV page is present");
				byte[] screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				Allure.addAttachment("Step", "image/png", new ByteArrayInputStream(screenshot1), "png");
			} else {
				Assert.assertEquals(getTitle, "FOV List");
				byte[] screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				Allure.addAttachment("Step ERROR", "image/png", new ByteArrayInputStream(screenshot1), "png");
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
			allureScreenshot();
			Assert.assertNotNull(header, "The FOV Page is not presented");
			System.out.println(" - The FOV page is not present");
		}
	}
	
	@When("User clicks on the My Course Tab")
	public void userClicksOnTheMyCourseTab() throws InterruptedException {
		WebElement Button = null;
		try {
			Button = driver.findElement(By.id("course"));
			Button.click();
			Thread.sleep(500);
			
			allureScreenshot();

		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.fail("User could not be able to click the Course Tab in My Profile button");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(500);
		}
	}
	@Then("List of My Course should be shown in the My Profile")
	public void listOfMyCourseShouldBeShownInTheMyProfile() throws InterruptedException {
		WebElement header = null;

		try {
			header = driver
					.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div[6]/div/div[2]/div/div[1]/div[1]/div"));
			Thread.sleep(1500);
			String getTitle = header.getText();

			if (getTitle.equals("BNM (CPD)")) {
				System.out.println(" - The My Course page is present");
				allureScreenshot();
			} else {
				Assert.assertEquals(getTitle, "BNM (CPD)");
				byte[] screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				Allure.addAttachment("Step ERROR", "image/png", new ByteArrayInputStream(screenshot1), "png");
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(header, "The My Course Page is not presented");
			System.out.println(" - The My Course page is not present");
		}
	}

	@When("User clicks on the My License Tab")
	public void userClicksOnTheMyLicenseTab() throws InterruptedException {
		WebElement Button = null;
		try {
			Button = driver.findElement(By.id("license"));
			Button.click();
			Thread.sleep(500);
			
			allureScreenshot();

		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.fail("User could not be able to click the My License Tab in My Profile button");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(500);
		}
	}
	@Then("List of My License should be shown in the My Profile")
	public void listOfMyLicenseShouldBeShownInTheMyProfile() {
		WebElement header = null;

		try {
			header = driver
					.findElement(By.className("license__title"));
			String getTitle = header.getText();

			if (getTitle.equals("License Type : BNM")) {
				System.out.println(" - The My License page is present");
				allureScreenshot();
			} else {
				Assert.assertEquals(getTitle, "License Type : BNM");
				byte[] screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				Allure.addAttachment("Step ERROR", "image/png", new ByteArrayInputStream(screenshot1), "png");
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(header, "The My License Page is not presented");
			System.out.println(" - The My License page is not present");
		}
	}

	//Profile Photo
	@When("User clicks on the Profile photo to change the image")
	public void userClicksOnTheProfilePhotoToChangeTheImage() throws InterruptedException {
		WebElement file = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/input"));
		String filePath = "C:\\Users\\ALTECFLEX\\OneDrive\\Pictures\\Planet9\\lala.jpg";

		// Use the sendKeys method to set the file path
		file.sendKeys(filePath);

		Thread.sleep(1000);
	}
	@Then("The profile photo updated to a new one")
	public void theProfilePhotoUpdatedToANewOne() {
		allureScreenshot();
	}


	//VKA2
	@When("User clicks on My License tab")
	public void userClicksOnMyLicenseTab() throws InterruptedException {
		WebElement Button = null;
		try {
			String buttonText = "My License"; // Replace with the actual text on the button
			String buttonXpath = String.format("//button[contains(., '%s')]", buttonText);
			Button = driver.findElement(By.xpath(buttonXpath));
			Button.click();
			allureScreenshot();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(Button, "User could not be able to click on the My License Tab");
			Thread.sleep(500);
		}
	}
	@Then("View the My License tab")
	public void viewTheMyLicenseTab() {
		WebElement header = null;

		try {
			header = driver.findElement(By.className("license__title"));
			String getTitle = header.getText();

			if (getTitle.equals("License Type : BNM")) {
				System.out.println(" - The License Type : BNM page is present");
				byte[] screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				Allure.addAttachment("Step", "image/png", new ByteArrayInputStream(screenshot1), "png");
			} else {
				Assert.assertEquals(getTitle, "License Type : BNM");
				byte[] screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				Allure.addAttachment("Step ERROR", "image/png", new ByteArrayInputStream(screenshot1), "png");
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(header, "The License Type : BNM Page is not presented");
			System.out.println(" - The License Type : BNM page is not present");
		}
	}
	@Then("View the My License tab under My Profile page")
	public void viewTheMyLicenseTabUnderMyProfilePage() {
		allureScreenshot();
	}
	@Then("View FAR Life Insurance Provider List under My License tab")
	public void viewFARLifeInsuranceProviderListUnderMyLicenseTab() {
		scrollDown();
		allureScreenshot();
	}
	@Then("View the IFAR section under My License tab")
	public void viewTheIFARSectionUnderMyLicenseTab() {
		scrollDown();
		scrollDown();
		allureScreenshot();
	}
	@Then("View IFAR Life Insurance Provider List under My License tab")
	public void viewIFARLifeInsuranceProviderListUnderMyLicenseTab() {
		scrollDown();
		scrollDown();
		allureScreenshot();
	}
	@Then("View the CMSRL section under My License tab")
	public void viewTheCMSRLSectionUnderMyLicenseTab() {
		scrollDown();
		scrollDown();
		scrollDown();
		allureScreenshot();
	}
	@Then("View CMSRL Life Insurance Provider List under My License tab")
	public void viewCMSRLLifeInsuranceProviderListUnderMyLicenseTab() {
		scrollDown();
		scrollDown();
		scrollDown();
		allureScreenshot();
	}
	@Then("View the UTSC section under My License tab")
	public void viewTheUTSCSectionUnderMyLicenseTab() {
		scrollDown();
		scrollDown();
		scrollDown();
		scrollDown();
		allureScreenshot();
	}
	@Then("View UTSC Life Insurance Provider List under My License tab")
	public void viewUTSCLifeInsuranceProviderListUnderMyLicenseTab() {
		scrollDown();
		scrollDown();
		scrollDown();
		scrollDown();
		allureScreenshot();
	}
	@Then("View the PRSC section under My License tab")
	public void viewThePRSCSectionUnderMyLicenseTab() {
		scrollDown();
		scrollDown();
		scrollDown();
		scrollDown();
		scrollDown();
		allureScreenshot();
	}
	@Then("View PRSC Life Insurance Provider List under My License tab")
	public void viewPRSCLifeInsuranceProviderListUnderMyLicenseTab() {
		scrollDown();
		scrollDown();
		scrollDown();
		scrollDown();
		scrollDown();
		allureScreenshot();
	}
}
