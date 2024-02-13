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
	public void listOfFOVShouldBeShownInTheMyProfile() {
		WebElement header = null;

		try {
			header = driver
					.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div[4]/div/div/table/thead/tr/th[1]/div"));
			String getTitle = header.getText();

			if (getTitle.equals("FOV Code")) {
				System.out.println(" - The FOV page is present");
				byte[] screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				Allure.addAttachment("Step", "image/png", new ByteArrayInputStream(screenshot1), "png");
			} else {
				Assert.assertEquals(getTitle, "FOV Code");
				byte[] screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				Allure.addAttachment("Step ERROR", "image/png", new ByteArrayInputStream(screenshot1), "png");
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
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
	public void listOfMyCourseShouldBeShownInTheMyProfile() {
		WebElement header = null;

		try {
			header = driver
					.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div[5]/div/div[2]/div/div[1]/div[1]/div"));
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
					.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div[6]/div/form/div/div/div[1]/label"));
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
		String filePath = "C:\\Users\\priya\\OneDrive\\Pictures\\Planet9\\main-qimg-bee0c8490c1daae843e0ab43209c2b15.webp"; 

		// Use the sendKeys method to set the file path
		file.sendKeys(filePath);

		Thread.sleep(1000);
	}
	@Then("The profile photo updated to a new one")
	public void theProfilePhotoUpdatedToANewOne() {
		allureScreenshot();
	}



}
