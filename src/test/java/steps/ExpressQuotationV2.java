package steps;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import drivers.DriverInstance;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;

public class ExpressQuotationV2 extends DriverInstance {

	static String module = "Express Quotation V2";
	
	@When("User navigates to Express Quotation V2")
	public void userNavigatesToExpressQuotationV2() throws InterruptedException {
		String wholeDiv = "/html/body/div[4]/div[3]/div/div/div[2]";

		List<WebElement> smallDivElements = driver.findElements(By.xpath(wholeDiv + "/div"));
		int x = 1;

		for (WebElement smallDivElement : smallDivElements) {
		    String smallDiv = wholeDiv + "/div[" + x + "]";
		    
		    // Find the li elements within the current smallDiv starting from li[3]
		    List<WebElement> liElements = smallDivElement.findElements(By.xpath(smallDiv + "/ul/li[position() > 2]/p"));
		    
		    for (WebElement liElement : liElements) {
		        if (liElement.getText().contains(module)) {
		        	allureScreenshot();
		            liElement.click();
		            System.out.println(" - Clicked on '" + module +"' li element.");
		            return; 
		        }
		    }
		    x++;
		}
		Thread.sleep(500);
	}
	@Then("Express Quotation V2 module display")
	public void expressQuotationV2ModuleDisplay() {
		WebElement header = null;

		try {
			header = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div[1]/div/div/p[2]"));
			String getTitle = header.getText();

			if (getTitle.equals("Express Quotation V2")) {
				System.out.println(" - The Express Quotation V2 page is present");
				byte[] screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				Allure.addAttachment("Step", "image/png", new ByteArrayInputStream(screenshot1), "png");
			} else {
				Assert.assertEquals(getTitle, "Express Quotation V2");
				byte[] screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				Allure.addAttachment("Step ERROR", "image/png", new ByteArrayInputStream(screenshot1), "png");
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(header, "The Express Quotation V2 Page is not presented");
			System.out.println(" - The Express Quotation V2 page is not present");
		}
	}
	@Then("Basic Info page is shown")
	public void basicInfoPageIsShown() {
		WebElement header = null;

		try {
			header = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div[4]/h2"));
			String getTitle = header.getText();

			if (getTitle.equals("Basic Info")) {
				System.out.println(" - The Basic Info page is present");
				byte[] screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				Allure.addAttachment("Step", "image/png", new ByteArrayInputStream(screenshot1), "png");
			} else {
				Assert.assertEquals(getTitle, "Basic Info");
				byte[] screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				Allure.addAttachment("Step ERROR", "image/png", new ByteArrayInputStream(screenshot1), "png");
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(header, "The Basic Info Page is not presented");
			System.out.println(" - The Basic Info page is not present");
		}
	}
	@When("User inserts value for Vehicle Reg No. and chooses postcode")
	public void userInsertsValueForVehicleRegNoAndChoosesPostcode() throws InterruptedException {
		WebElement InputRegNo = null;
		
		try {
			InputRegNo = driver.findElement(By.name("verhicleRegistrationNo"));
			InputRegNo.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			InputRegNo.sendKeys(vehRegNo);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			allureScreenshot();
			Assert.assertNotNull(InputRegNo, "User could not be able to Insert Value to verhicle Registration No textbox");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(500);
		}

		WebElement Input = null;
		try {
			Input = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[4]/div/div/div/div[1]/div[2]/input"));
			Input.sendKeys(postcode);
			Thread.sleep(2500);
			Input.sendKeys(Keys.ENTER);
			Thread.sleep(500);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			allureScreenshot();
			Assert.assertNotNull(Input, "User should be able to insert value in the dropdown input");
			Thread.sleep(500);
		}
		allureScreenshot();
	}
	@When("User clicks disclaimer checkbox in Express Quotation V2")
	public void userClicksDisclaimerCheckboxInExpressQuotationV2() {
		scrollDown();
	    WebElement checkbox = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[5]/div/div/label/span[1]/input"));
	    checkbox.click();
	    allureScreenshot();    
	}
	
	@When("User inserts value for Vehicle Registration Card NO. and Body")
	public void userInsertsValueForVehicleRegistrationCardNOAndBody() throws InterruptedException {
		if (!vehicleRegCardNo.equals(null) && vehicleRegCardNo != "") {
			WebElement vehicleRegCardNoInput = null;			
			try {
				vehicleRegCardNoInput = driver.findElement(By.name("verhicleRegistrationCardNo"));
				vehicleRegCardNoInput.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
				vehicleRegCardNoInput.sendKeys(vehicleRegCardNo);
			} catch (org.openqa.selenium.NoSuchElementException e) {
				allureScreenshot();
				Assert.assertNotNull(vehicleRegCardNoInput, "User could not be able to Insert Value to vehicleRegCardNo textbox");
				System.out.println("Nope"); // The div is not present
				Thread.sleep(500);
			}
		}
		
		if (!body.equals(null) && body != "") {		
			WebElement bodyInput = null;
			try {
				bodyInput = driver.findElement(By.xpath(
						"/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[22]/div/div/div/div[1]/div[2]/input"));
				bodyInput.sendKeys(body);
				Thread.sleep(2500);
				bodyInput.sendKeys(Keys.ENTER);
				Thread.sleep(500);
			} catch (org.openqa.selenium.NoSuchElementException e) {
				allureScreenshot();
				Assert.assertNotNull(bodyInput, "User should be able to insert value in the dropdown input");
				Thread.sleep(500);
			}
		}
		allureScreenshot();
	}
	@When("User inserts value for Hire Purchase Company and Garage")
	public void userInsertsValueForHirePurchaseCompanAndGarage() throws InterruptedException {
		if (!hirePurchaseComp.equals(null) && hirePurchaseComp != "") {
			WebElement Input = null;
			try {
				Input = driver.findElement(By.name("hirePurchase"));
				Input.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
				Input.sendKeys(hirePurchaseComp);
			} catch (org.openqa.selenium.NoSuchElementException e) {
				allureScreenshot();
				Assert.assertNotNull(Input, "User could not be able to Insert Value to hirePurchase textbox");
				System.out.println("Nope"); // The div is not present
				Thread.sleep(500);
			}
		}
		
		if (!garage.equals(null) && garage != "") {
			WebElement garageInput = null;
			try {
				garageInput = driver.findElement(By.xpath(
						"/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[24]/div/div/div/div[1]/div[2]/input"));
				garageInput.sendKeys(garage);
				Thread.sleep(2500);
				garageInput.sendKeys(Keys.ENTER);
				Thread.sleep(500);
			} catch (org.openqa.selenium.NoSuchElementException e) {
				allureScreenshot();
				Assert.assertNotNull(garageInput, "User should be able to insert value in the dropdown input");
				Thread.sleep(500);
			}
		}
		
		allureScreenshot();
	}
	@When("User chooses Safety Features and Anti Theft")
	public void userChoosesSafetyFeaturesAndAntiTheft() throws InterruptedException {
		if (!safetyFeature.equals(null) && safetyFeature != "") {
			WebElement safetyFeatureInput = null;
			try {
				safetyFeatureInput = driver.findElement(By.xpath(
						"/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[25]/div/div/div/div[1]/div[2]/input"));
				safetyFeatureInput.sendKeys(safetyFeature);
				Thread.sleep(2500);
				safetyFeatureInput.sendKeys(Keys.ENTER);
				Thread.sleep(500);
			} catch (org.openqa.selenium.NoSuchElementException e) {
				allureScreenshot();
				Assert.assertNotNull(safetyFeatureInput, "User should be able to insert value in the dropdown input");
				Thread.sleep(500);
			}
		}

		if (!antiTheft.equals(null) && antiTheft != "") {
			WebElement antiTheftInput = null;
			try {
				antiTheftInput = driver.findElement(By.xpath(
						"/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[26]/div/div/div/div[1]/div[2]/input"));
				antiTheftInput.sendKeys(antiTheft);
				Thread.sleep(2500);
				antiTheftInput.sendKeys(Keys.ENTER);
				Thread.sleep(500);
			} catch (org.openqa.selenium.NoSuchElementException e) {
				allureScreenshot();
				Assert.assertNotNull(antiTheftInput, "User should be able to insert value in the dropdown input");
				Thread.sleep(500);
			}
		}
		allureScreenshot();
	}
	@When("User chooses Is Recon Car and Allianz Variant")
	public void userChoosesIsReconCarAndAllianzVariant() throws InterruptedException {
		scrollDown();
		
		if (!recon.equals(null) && recon != "") {
			WebElement reconInput = null;
			try {
				reconInput = driver.findElement(By.xpath(
						"/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[3]/div[3]/div/div/div/div[1]/div[2]/input"));
				reconInput.sendKeys(recon);
				Thread.sleep(2500);
				reconInput.sendKeys(Keys.ENTER);
				Thread.sleep(500);
			} catch (org.openqa.selenium.NoSuchElementException e) {
				allureScreenshot();
				Assert.assertNotNull(reconInput, "User should be able to insert value in the dropdown input");
				Thread.sleep(500);
			}
		}
		
		if (!allianzVariant.equals(null) && allianzVariant !="") {
			WebElement allianzVariantInput = null;
			try {
				allianzVariantInput = driver.findElement(By.xpath(
						"/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[3]/div[1]/div/div/div/div[1]/div[2]/input"));
				allianzVariantInput.sendKeys(allianzVariant);
				Thread.sleep(2500);
				allianzVariantInput.sendKeys(Keys.ENTER);
				Thread.sleep(500);
			} catch (org.openqa.selenium.NoSuchElementException e) {
				allureScreenshot();
				Assert.assertNotNull(allianzVariantInput, "User should be able to insert value in the dropdown input");
				Thread.sleep(500);
			}
		}
		scrollDown();
	}
	@When("User clicks on the Next button for Quotation")
	public void userClicksOnTheNextButtonForQuotation() throws InterruptedException {
		WebElement Button = null;
		try {	
			scrollDown();
			allureScreenshot();
			Button = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[4]/button[2]"));
			Button.click();
				Thread.sleep(25000);	           
		} catch (org.openqa.selenium.NoSuchElementException e) {
			allureScreenshot();
			Assert.assertNotNull(Button, "User could not be able to click on the Next button");
			Thread.sleep(500);		
		}
	}	
	@When("User clicks on the Next button for Payment")
	public void userClicksOnTheNextButtonForPayment() throws InterruptedException {
		WebElement Button = null;
		try {
			Button = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div[6]/button[2]"));
			Button.click();
			Thread.sleep(25000);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			allureScreenshot();
			Assert.assertNotNull(Button, "User could not be able to click on the Next button");
			Thread.sleep(500);
		}
	}
		
	@When("User clicks on the Product Info button")
	public void userClicksOnTheProductInfoButton() throws InterruptedException {
		WebElement Button = null;
		try {		
			Button = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div[5]/ul/li/div/div[3]/div/button[1]"));
			Button.click();
				Thread.sleep(2000);	           
		} catch (org.openqa.selenium.NoSuchElementException e) {
			allureScreenshot();
			Assert.assertNotNull(Button, "User could not be able to click on the Next button");
			Thread.sleep(500);		
		}
	}
	@Then("Product Info is shown")
	public void productInfoIsShown() {
	    allureScreenshot();
	}
	@When("User clicks on the Download button")
	public void userClicksOnTheDownloadButton() throws InterruptedException {
		WebElement Button = null;
		try {		
			Button = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div[5]/ul/li/div/div[3]/div/div/button"));
			Button.click();
				Thread.sleep(2000);	           
		} catch (org.openqa.selenium.NoSuchElementException e) {
			allureScreenshot();
			Assert.assertNotNull(Button, "User could not be able to click on the Next button");
			Thread.sleep(500);		
		}
	}
	@Then("List of formats to be downloaded is shown")
	public void listOfFormatsToBeDownloadedIsShown() {
		allureScreenshot();
	}
	@When("User clicks on the Policy Excess button for Payment")
	public void userClicksOnThePolicyExcessButtonForPayment() throws InterruptedException {
		WebElement Button = null;
		try {		
			Button = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div[5]/ul/li/div/div[3]/div/button[2]"));
			Button.click();
				Thread.sleep(2000);	           
		} catch (org.openqa.selenium.NoSuchElementException e) {
			allureScreenshot();
			Assert.assertNotNull(Button, "User could not be able to click on the Next button");
			Thread.sleep(500);		
		}
	}
	@Then("Policy Excess is shown")
	public void policyExcessIsShown() {
		allureScreenshot();
	}
	
	@Then("Personal Info page is shown")
	public void personalInfoPageIsShown() {
		WebElement header = null;

		try {
			header = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div[4]/h2"));
			String getTitle = header.getText();

			if (getTitle.equals("Personal Info")) {
				System.out.println(" - The Personal Info page is present");
				byte[] screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				Allure.addAttachment("Step", "image/png", new ByteArrayInputStream(screenshot1), "png");
			} else {
				Assert.assertEquals(getTitle, "Personal Info");
				byte[] screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				Allure.addAttachment("Step ERROR", "image/png", new ByteArrayInputStream(screenshot1), "png");
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(header, "The Personal Info Page is not presented");
			System.out.println(" - The Personal Info page is not present");
		}
	}
	@When("User inserts value for Contact No.")
	public void userInsertsValueForContactNo() throws InterruptedException {
		WebElement contactNoInput = null;
		
		try {
			contactNoInput = driver.findElement(By.name("contactNo"));
			contactNoInput.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			contactNoInput.sendKeys(contactNo);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			allureScreenshot();
			Assert.assertNotNull(contactNoInput, "User could not be able to Insert Value to contactNo textbox");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(500);
		}
	}
	@When("User inserts value for Driving Experience")
	public void userInsertsValueForDrivingExperience() throws InterruptedException {
		WebElement driveExpInput = null;
		
		try {
			driveExpInput = driver.findElement(By.name("ownerExperience"));
			driveExpInput.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			driveExpInput.sendKeys(driveExp);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			allureScreenshot();
			Assert.assertNotNull(driveExpInput, "User could not be able to Insert Value to ownerExperience textbox");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(500);
		}
	}
	@Then("Finalized Quotation Plan should be shown.")
	public void finalizedQuotationPlanShouldBeShown() {
		WebElement header = null;

		try {
			header = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div[4]/div[1]/h2"));
			String getTitle = header.getText();

			if (getTitle.equals("Finalized Quotation Plan")) {
				System.out.println(" - The Finalized Quotation Plan page is present");
				byte[] screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				Allure.addAttachment("Step", "image/png", new ByteArrayInputStream(screenshot1), "png");
			} else {
				Assert.assertEquals(getTitle, "Finalized Quotation Plan");
				byte[] screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				Allure.addAttachment("Step ERROR", "image/png", new ByteArrayInputStream(screenshot1), "png");
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(header, "The Finalized Quotation Plan Page is not presented");
			System.out.println(" - The Finalized Quotation Plan page is not present");
		}
	}
	
	@When("User clicks on the Payment Tab")
	public void userClicksOnThePaymentTab() {
	    WebElement button = null;
	    try {
	    	button = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div[3]/ul/li[3]"));
	    	button.click();
	    	Thread.sleep(1000);
	    } catch (Exception e) {
			Assert.fail("User couldn't able to click on the Policy Tab");
		}
	}
	@Then("User clicks on the receipt")
	public void userClicksOnTheReceipt() {
	   driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[2]/div/div/div/div/table/tbody/tr/td[6]/a")).click();
	   
	   allureScreenshotAnotherTab();
	}
	
	//Negative Scenarios
	@When("The Application Unsuccessful message should pop up.")
	public void theApplicationUnsuccessfulMessageShouldPopUp() {
		WebElement headerUnSuccess = null;
        String EnStatement;
		//UNSUCCESSFUL
        try {
            headerUnSuccess = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/h1"));    
            System.out.println(" - Application Unsuccessful Header = " + headerUnSuccess.getText());            
            WebElement submitText = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/p/span"));
    		EnStatement = submitText.getText();
    		System.out.println(EnStatement);
    		
        } catch (NoSuchElementException e) {
            allureScreenshot();
            Assert.fail("System should not continue with the Invalid Value");
        }    
	}
	@When("The Vehicle RegNo textbox should throw validation error.")
	public void theVehicleRegNoTextboxShouldThrowValidationError() throws InterruptedException {
		WebElement idInput = null;		
		try {
			idInput = driver.findElement(By.name("verhicleRegistrationNo"));
			idInput.sendKeys(Keys.chord(Keys.ENTER));
			allureScreenshot();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			allureScreenshot();
			Assert.assertNotNull(idInput, "The Vehicle RegNo textbox should throw validation error.");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(500);
		}
	}
	@When("The Vehicle RegNo textbox should not display the full value.")
	public void theVehicleRegNoTextboxShouldNotDisplayTheFullValue() throws InterruptedException {
		WebElement idInput = null;		
		try {
			idInput = driver.findElement(By.name("verhicleRegistrationNo"));
			idInput.sendKeys(Keys.chord(Keys.ENTER));
			allureScreenshot();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			allureScreenshot();
			Assert.assertNotNull(idInput, "The Vehicle RegNo textbox should display the full value.");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(500);
		}
	}
	
	
	
	
	
	
	
}
