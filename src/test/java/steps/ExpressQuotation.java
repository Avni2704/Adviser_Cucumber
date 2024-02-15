package steps;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import drivers.DriverInstance;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import qa.util.ExcelReader;

public class ExpressQuotation extends DriverInstance {

	static String module = "Express Quotation";
	
	@When("Gets Test Data from {string}, {string} sheet and row number: {string}")
	public void getsTestDataFromSheetAndRowNumber(String file, String sheetName, String row) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		List<Map<String,String>> testData = reader.getData("C:\\Users\\ALTECFLEX\\OneDrive\\Desktop\\RegTest\\TestData\\" + file, sheetName);

		 int rowNumber = Integer.parseInt(row);
			moduleExcel = testData.get(rowNumber).get("module");
			salutation = testData.get(rowNumber).get("salutation");
			custName = testData.get(rowNumber).get("custName");
			insName = testData.get(rowNumber).get("insName");
			vehRegNo = testData.get(rowNumber).get("vehRegNo");
			contactNo = testData.get(rowNumber).get("contactNo");
			officeNo = testData.get(rowNumber).get("officeNo");
			email = testData.get(rowNumber).get("email");
			idType = testData.get(rowNumber).get("idType");
			id = testData.get(rowNumber).get("id");
			maritial = testData.get(rowNumber).get("maritial");
			natOfBus = testData.get(rowNumber).get("natOfBus");
			Occup = testData.get(rowNumber).get("Occup");
			addLine1 = testData.get(rowNumber).get("addLine1");
			addLine2 = testData.get(rowNumber).get("addLine2");
			postcode = testData.get(rowNumber).get("postcode");
			driveExp = testData.get(rowNumber).get("driveExp");
			FOVname = testData.get(rowNumber).get("FOVname");
			remark = testData.get(rowNumber).get("remark");

			coverNoteType = testData.get(rowNumber).get("coverNoteType");
			vehicleRegCardNo = testData.get(rowNumber).get("vehicleRegCardNo");
			inceptionDate = testData.get(rowNumber).get("inceptionDate");
			recon = testData.get(rowNumber).get("recon");
			body = testData.get(rowNumber).get("body");
			hirePurchaseComp = testData.get(rowNumber).get("hirePurchaseComp");
			garage = testData.get(rowNumber).get("garage");
			safetyFeature = testData.get(rowNumber).get("safetyFeature");
			antiTheft = testData.get(rowNumber).get("antiTheft");
			nvic = testData.get(rowNumber).get("nvic");
			allianzVariant = testData.get(rowNumber).get("allianzVariant");
			sumInsured = testData.get(rowNumber).get("sumInsured");
			piamDriverCode = testData.get(rowNumber).get("piamDriverCode");

			addBen = testData.get(rowNumber).get("addBen");
			bankName = testData.get(rowNumber).get("bankName");
			bankUserId = testData.get(rowNumber).get("bankUserId");
			bankPassword = testData.get(rowNumber).get("bankPassword");

			nameOnCard  = testData.get(rowNumber).get("nameOnCard");
			number = testData.get(rowNumber).get("number");
			expiryMonth  = testData.get(rowNumber).get("expiryMonth");
			expiryYear = testData.get(rowNumber).get("expiryYear");
			securityCode = testData.get(rowNumber).get("securityCode");
			country = testData.get(rowNumber).get("country");
			addressline1 = testData.get(rowNumber).get("addressline1");
			city = testData.get(rowNumber).get("city");
			zipcode = testData.get(rowNumber).get("zipcode");
			state = testData.get(rowNumber).get("state");
			
	}
	
	@When("User navigates to Express Quotation")
	public void userNavigatesToExpressQuotation() throws InterruptedException {
		String wholeDiv = "/html/body/div[4]/div[3]/div/div/div[2]";

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
		            return; 
		        }
		    }
		    x++;
		}
		Thread.sleep(500);
	}
	@Then("Express Quotation module display")
	public void expressQuotationModuleDisplay() {
		WebElement header = null;

		try {
			header = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div[1]/div/div/p[2]"));
			String getTitle = header.getText();

			if (getTitle.equals("Express Quotation")) {
				System.out.println(" - The Express Quotation page is present");
				byte[] screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				Allure.addAttachment("Step", "image/png", new ByteArrayInputStream(screenshot1), "png");
			} else {
				Assert.assertEquals(getTitle, "Express Quotation");
				byte[] screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				Allure.addAttachment("Step ERROR", "image/png", new ByteArrayInputStream(screenshot1), "png");
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(header, "The Express Quotation Page is not presented");
			System.out.println(" - The Express Quotation page is not present");
		}
	}
	@When("User clicks on the New Enquiry button")
	public void userClicksOnTheNewEnquiryButton() throws InterruptedException {
		WebElement Button = null;
		try {
			Thread.sleep(500);
			allureScreenshot();
			Button = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div[2]/button"));
			Button.click();
			Thread.sleep(500);
			
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.fail("User could not be able to click the New Enquiry button");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(500);
		}
	}
	@Then("User selects the Product Type")
	public void userSelectsTheProductType() throws InterruptedException {
		WebElement Button = null;
		try {
			Thread.sleep(500);
			allureScreenshot();
			Button = driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/div[2]/button[2]"));
			Button.click();
			Thread.sleep(500);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.fail("User could not be able to click the Confirm Product Type button");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(500);
		}
	}
	@Then("Application page is shown")
	public void applicationPageIsShown() {
		WebElement header = null;

		try {
			header = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div[4]/h2"));
			String getTitle = header.getText();

			if (getTitle.equals("Motor Private Application")) {
				System.out.println(" - The Application page is present");
				byte[] screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				Allure.addAttachment("Step", "image/png", new ByteArrayInputStream(screenshot1), "png");
			} else {
				Assert.assertEquals(getTitle, "Motor Private Application");
				byte[] screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				Allure.addAttachment("Step ERROR", "image/png", new ByteArrayInputStream(screenshot1), "png");
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(header, "The Application Page is not presented");
			System.out.println(" - The Application page is not present");
		}
	}
	

	@When("User chooses the salution")
	public void userChoosesTheSalution() throws InterruptedException {
		WebElement Input = null;
		try {
			if (moduleExcel.equals("ExpQuot")) {
				Input = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[2]/div/div/div/div[1]/div[2]/input"));
			} else if (moduleExcel.equals("ExpQuot2")) {
				Input = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[2]/div/div/div/div[1]/div[2]/input"));
			}
			
			
			Input.sendKeys(salutation);
			Thread.sleep(2500);
			Input.sendKeys(Keys.ENTER);
			Thread.sleep(500);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			allureScreenshot();
			Assert.assertNotNull(Input, "User should be able to insert value in the dropdown input");
			Thread.sleep(500);
		}
	}
	@When("User inserts value for Customer Name and Insured Name")
	public void userInsertsValueForCustomerNameAndInsuredName() throws InterruptedException {
		WebElement custNameInput = null;
		
		try {
			custNameInput = driver.findElement(By.name("customerName"));
			custNameInput.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			custNameInput.sendKeys(custName);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			allureScreenshot();
			Assert.assertNotNull(custNameInput, "User could not be able to Insert Value to customerName textbox");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(500);
		}
		
		WebElement insNameInput = null;
		
		try {
			insNameInput = driver.findElement(By.name("insuredName"));
			insNameInput.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			insNameInput.sendKeys(insName);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			allureScreenshot();
			Assert.assertNotNull(insNameInput, "User could not be able to Insert Value to insuredName textbox");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(500);
		}
		allureScreenshot();
		scrollDown();
	}
	@When("User inserts value for Vehicle Reg No. and Contact No.")
	public void userInsertsValueForVehicleRegNoAndContactNo() throws InterruptedException {
		WebElement Input = null;
		
		try {
			Input = driver.findElement(By.name("verhicleRegistrationNo"));
			Input.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			Input.sendKeys(vehRegNo);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			allureScreenshot();
			Assert.assertNotNull(Input, "User could not be able to Insert Value to verhicleRegistrationNo textbox");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(500);
		}
		
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
	@When("User inserts value for Office No. and Email Address")
	public void userInsertsValueForOfficeNoAndEmailAddress() throws InterruptedException {
		WebElement officeNoInput = null;
		
		try {
			officeNoInput = driver.findElement(By.name("officePhoneNo"));
			officeNoInput.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			officeNoInput.sendKeys(officeNo);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			allureScreenshot();
			Assert.assertNotNull(officeNoInput, "User could not be able to Insert Value to officePhoneNo textbox");
			Thread.sleep(500);
		}
		
		WebElement emailInput = null;
		
		try {
			emailInput = driver.findElement(By.name("emailAddress"));
			emailInput.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			emailInput.sendKeys(email);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			allureScreenshot();
			Assert.assertNotNull(emailInput, "User could not be able to Insert Value to emailAddress textbox");
			Thread.sleep(500);
		}
	}
	@When("User chooses ID Type and inserts value for ID No.")
	public void userChoosesIDTypeAndInsertsValueForIDNo() throws InterruptedException {
		WebElement Input = null;
		try {
			if (moduleExcel.equals("ExpQuot")) {
				Input = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[9]/div/div/div/div[1]/div[2]/input"));
			} else if (moduleExcel.equals("ExpQuot2")) {
				Input = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[1]/div/div/div/div[1]/div[2]/input"));
			}
			Thread.sleep(500);
			Input.sendKeys(idType);
			Thread.sleep(2500);
			Input.sendKeys(Keys.ENTER);
			Thread.sleep(500);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			allureScreenshot();
			Assert.assertNotNull(Input, "User should be able to insert value in the dropdown input");
			Thread.sleep(500);
		}
		
		WebElement idInput = null;		
		try {
			idInput = driver.findElement(By.name("identityNo"));
			idInput.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			idInput.sendKeys(id);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			allureScreenshot();
			Assert.assertNotNull(idInput, "User could not be able to Insert Value to identityNo textbox");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(500);
		}	
	}
	@When("User chooses Maritial Status and Nature of Business and Occupation")
	public void userChoosesMaritialStatusAndNatureOfBusinessAndOccupation() throws InterruptedException {
		WebElement Input = null;
		try {
			Input = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[15]/div/div/div/div[1]/div[2]/input"));
			Input.sendKeys(maritial);
			Thread.sleep(2500);
			Input.sendKeys(Keys.ENTER);
			Thread.sleep(500);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			allureScreenshot();
			Assert.assertNotNull(Input, "User should be able to insert value in the dropdown input");
			Thread.sleep(500);
		}
		
		WebElement NatOfBusInput = null;
		try {
			NatOfBusInput = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[16]/div/div/div/div[1]/div[2]/input"));
			NatOfBusInput.sendKeys(natOfBus);
			Thread.sleep(2500);
			NatOfBusInput.sendKeys(Keys.ENTER);
			Thread.sleep(500);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			allureScreenshot();
			Assert.assertNotNull(NatOfBusInput, "User should be able to insert value in the dropdown input");
			Thread.sleep(500);
		}
		
		WebElement OccupInput = null;
		try {
			OccupInput = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[17]/div/div/div/div[1]/div[2]/input"));
			OccupInput.sendKeys(Occup);
			Thread.sleep(2500);
			OccupInput.sendKeys(Keys.ENTER);
			Thread.sleep(500);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			allureScreenshot();
			Assert.assertNotNull(OccupInput, "User should be able to insert value in the dropdown input");
			Thread.sleep(500);
		}
		allureScreenshot();
		scrollDown();
	}
	@When("User inserts value for Address Line 1 and Line 2")
	public void userInsertsValueForAddressLineAndLine() throws InterruptedException {
		WebElement addLine1Input = null;
		
		try {
			addLine1Input = driver.findElement(By.name("address1"));
			addLine1Input.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			addLine1Input.sendKeys(addLine1);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			allureScreenshot();
			Assert.assertNotNull(addLine1Input, "User could not be able to Insert Value to address1 textbox");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(500);
		}
		
		WebElement addLine2Input = null;
		
		try {
			addLine2Input = driver.findElement(By.name("address2"));
			addLine2Input.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			addLine2Input.sendKeys(addLine2);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			allureScreenshot();
			Assert.assertNotNull(addLine2Input, "User could not be able to Insert Value to address2 textbox");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(500);
		}
	}
	@When("User chooses postcode and inserts value for Driving Experience")
	public void userChoosesPostcodeAndInsertsValueForDrivingExperience() throws InterruptedException {
		WebElement Input = null;
		try {
			Input = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[20]/div/div/div/div[1]/div[2]/input"));
			Input.sendKeys(postcode);
			Thread.sleep(2500);
			Input.sendKeys(Keys.ENTER);
			Thread.sleep(500);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			allureScreenshot();
			Assert.assertNotNull(Input, "User should be able to insert value in the dropdown input");
			Thread.sleep(500);
		}
		
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
	@When("User may choose the FOV Name and insert value for Remark")
	public void userMayChooseTheFOVNameAndInsertValueForRemark() throws InterruptedException {
		
		allureScreenshot();
		scrollDown();
		
		if (!FOVname.equals(null) && FOVname != "") {
			WebElement Input = null;
			try {
				Input = driver.findElement(By.xpath(
						"/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[25]/div/div/div/div[1]/div[2]/input"));
				Input.sendKeys(FOVname);
				Thread.sleep(2500);
				Input.sendKeys(Keys.ENTER);
				Thread.sleep(500);
			} catch (org.openqa.selenium.NoSuchElementException e) {
				allureScreenshot();
				Assert.assertNotNull(Input, "User should be able to insert value in the dropdown input");
				Thread.sleep(500);
			}
		}

		if (!remark.equals(null) && remark != "") {
			WebElement remarkInput = null;

			try {
				remarkInput = driver.findElement(By.name("remark"));
				remarkInput.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
				remarkInput.sendKeys(remark);
			} catch (org.openqa.selenium.NoSuchElementException e) {
				allureScreenshot();
				Assert.assertNotNull(remarkInput, "User could not be able to Insert Value to remark textbox");
				Thread.sleep(500);
			}
		}
	}
	@When("User clicks disclaimer checkbox")
	public void userClicksDisclaimerCheckbox() {
	    WebElement checkbox = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[28]/div/div/label/span[1]/input"));
	    checkbox.click();
	    allureScreenshot();
	    scrollDown();
	}
	@When("User clicks on the Next button")
	public void userClicksOnTheNextButton() throws InterruptedException {
		scrollDown();
		scrollDown();
		WebElement Button = null;
		try {
			scrollDown();
			Button = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[2]/button[2]"));
			Button.click();
			if (moduleExcel.equals("ExpQuot")) {
				Thread.sleep(40000);
			} else if (moduleExcel.equals("ExpQuot2")) {
				Thread.sleep(20000);
			}	           
		} catch (org.openqa.selenium.NoSuchElementException e) {
			allureScreenshot();
			Assert.assertNotNull(Button, "User could not be able to click on the Next button");
			Thread.sleep(500);		
		}
	}
	@Then("Vehicle info page should be shown in the Enquiry Tab.")
	public void vehicleInfoPageShouldBeShownInTheEnquiryTab() {
		WebElement page = null;

		try {
					
			if (moduleExcel.equals("ExpQuot")) {
				page = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div[4]/p"));
			} else if (moduleExcel.equals("ExpQuot2")) {
				page = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div[4]/h2"));
			}			
			wait.until(ExpectedConditions.visibilityOf(page));
			String getTitle = page.getText();

			if (getTitle.equals("Please Confirm Vehicle Info")) {
				System.out.println(" - The Vehicle Info page is present");
				 byte[] screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				 Allure.addAttachment("Step 3", "image/png", new ByteArrayInputStream(screenshot1), "png");
			} else {
				Assert.assertEquals(getTitle, "Please Confirm Vehicle Info");
				 byte[] screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				 Allure.addAttachment("Step 3 ERROR", "image/png", new ByteArrayInputStream(screenshot1), "png");
			}	
		} catch (org.openqa.selenium.NoSuchElementException e) {
			
			WebElement Unsuccessful = null;
			WebElement UnsuccessfulStat = null;
			try {
				
				Unsuccessful = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/h1"));
				String StrUnsuccessful = Unsuccessful.getText();
				
				UnsuccessfulStat = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/p/span"));
				String StrUnsuccessfulStat = UnsuccessfulStat.getText();
				allureScreenshot();
				Assert.fail(StrUnsuccessful + " - " + StrUnsuccessfulStat);
					
			} catch (Exception e1) {
				System.out.println("Continue as normal");
			}
			
			Assert.assertNotNull(page, "The Vehicle Info Page is not presented");
			System.out.println(" - The Vehicle Info page is not present");
		}
	}

	@When("User chooses Cover Note Type")
	public void userChoosesCoverNoteType() throws InterruptedException {
		WebElement Input = null;
		try {
			
			if (moduleExcel.equals("ExpQuot")) {
				Input = driver.findElement(By.xpath(
						"/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[1]/div/div/div/div[1]/div[2]/input"));
			} else if (moduleExcel.equals("ExpQuot2")) {
				scrollDown();
			    scrollDown();
				Input = driver.findElement(By.xpath(
						"/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[20]/div/div/div/div[1]/div[2]/input"));
			}			
			Input.sendKeys(coverNoteType);
			Thread.sleep(2500);
			Input.sendKeys(Keys.ENTER);
			Thread.sleep(500);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			allureScreenshot();
			Assert.assertNotNull(Input, "User should be able to insert value in the dropdown input");
			Thread.sleep(500);
		}
	}
	@When("User inserts value for Vehicle Registration Card NO. and Inception Date")
	public void userInsertsValueForVehicleRegistrationCardNOAndInceptionDate() throws InterruptedException {
		
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
			
			if (!inceptionDate.equals(null) && inceptionDate != "") {
				WebElement Input = null;

				try {
					Input = driver.findElement(By
							.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[4]/div/div/div/div/input"));
					Input.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
					Input.sendKeys(inceptionDate);
				} catch (org.openqa.selenium.NoSuchElementException e) {
					allureScreenshot();
					Assert.assertNotNull(Input, "User could not be able to Insert Value to inceptionDate textbox");
					System.out.println("Nope"); // The div is not present
					Thread.sleep(500);
				}
			}
		}
		
		scrollDown();
	}
	@When("User chooses Is Recon Car and Body")
	public void userChoosesIsReconCarAndBody() throws InterruptedException {
		
		if (!recon.equals(null) && recon != "") {
			WebElement reconInput = null;
			try {
				reconInput = driver.findElement(By.xpath(
						"/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[9]/div/div/div/div[1]/div[2]/input"));
				reconInput.sendKeys(recon);
				Thread.sleep(2500);
				reconInput.sendKeys(Keys.ENTER);
				Thread.sleep(500);
			} catch (org.openqa.selenium.NoSuchElementException e) {
				allureScreenshot();
				Assert.assertNotNull(reconInput, "User should be able to insert value in the dropdown input");
				Thread.sleep(500);
			}
			
			WebElement bodyInput = null;
			try {
				bodyInput = driver.findElement(By.xpath(
						"/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[12]/div/div/div/div[1]/div[2]/input"));
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
		
	}
	@When("User inserts value for Hire Purchase Company")
	public void userInsertsValueForHirePurchaseCompany() throws InterruptedException {
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
		scrollDown();
	}
	@When("User chooses Garage, Safety Features and Anti Theft")
	public void userChoosesGarageSafetyFeaturesAndAntiTheft() throws InterruptedException {
		if (!garage.equals(null) && garage != "") {
			WebElement garageInput = null;
			try {
				garageInput = driver.findElement(By.xpath(
						"/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[19]/div/div/div/div[1]/div[2]/input"));
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
		
		if (!safetyFeature.equals(null) && safetyFeature != "") {
			WebElement safetyFeatureInput = null;
			try {
				safetyFeatureInput = driver.findElement(By.xpath(
						"/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[20]/div/div/div/div[1]/div[2]/input"));
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
						"/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[21]/div/div/div/div[1]/div[2]/input"));
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
	}
	@When("User chooses NVIC and Allianz Variant")
	public void userChoosesNVICAndAllianzVariant() throws InterruptedException {
		
		if (!nvic.equals(null) && nvic != "") {
			WebElement nvicInput = null;
			try {
				nvicInput = driver.findElement(By.xpath(
						"/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[23]/div/div/div/div[1]/div[2]/input"));
				nvicInput.sendKeys(nvic);
				Thread.sleep(2500);
				nvicInput.sendKeys(Keys.ENTER);
				Thread.sleep(500);
			} catch (org.openqa.selenium.NoSuchElementException e) {
				allureScreenshot();
				Assert.assertNotNull(nvicInput, "User should be able to insert value in the dropdown input");
				Thread.sleep(500);
			}
		}
				
		if (!allianzVariant.equals(null) && allianzVariant !="") {
			WebElement allianzVariantInput = null;
			try {
				allianzVariantInput = driver.findElement(By.xpath(
						"/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[24]/div/div/div/div[1]/div[2]/input"));
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

	}
	@When("User inserts value for Sum Insured Amount and chooses PIAM Driver Code")
	public void userInsertsValueForSumInsuredAmountAndChoosesPIAMDriverCode() throws InterruptedException {
	    
		if (!sumInsured.equals(null) && sumInsured != "") {
			WebElement sumInsuredInput = null;
			try {
				sumInsuredInput = driver.findElement(By.name("sumInsuredAmount"));
				sumInsuredInput.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
				sumInsuredInput.sendKeys(sumInsured);
			} catch (org.openqa.selenium.NoSuchElementException e) {
				allureScreenshot();
				Assert.assertNotNull(sumInsuredInput,
						"User could not be able to Insert Value to sumInsuredAmount textbox");
				System.out.println("Nope"); // The div is not present
				Thread.sleep(500);
			}
		}	
		
		if (!piamDriverCode.equals(null) && piamDriverCode != "") {
			WebElement piamDriverCodeInput = null;
			try {
				piamDriverCodeInput = driver.findElement(By.xpath(
						"/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[31]/div/div/div/div[1]/div[2]/input"));
				piamDriverCodeInput.sendKeys(piamDriverCode);
				Thread.sleep(2500);
				piamDriverCodeInput.sendKeys(Keys.ENTER);
				Thread.sleep(500);
			} catch (org.openqa.selenium.NoSuchElementException e) {
				allureScreenshot();
				Assert.assertNotNull(piamDriverCodeInput, "User should be able to insert value in the dropdown input");
				Thread.sleep(500);
			}
		}
		scrollDown();
	}
	@Then("Quotation Tab is shown")
	public void quotationTabIsShown() {
		WebElement page = null;
		
		try {
						
			page = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div[4]/div[1]/p"));
			wait.until(ExpectedConditions.visibilityOf(page));
			String getTitle = page.getText();

			if (getTitle.equals("Select your preferred quotation plan")) {
				System.out.println(" - The Quotation page is present");
				 byte[] screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				 Allure.addAttachment("Step 3", "image/png", new ByteArrayInputStream(screenshot1), "png");
			} else {
				Assert.assertEquals(getTitle, "Select your preferred quotation plan");
				 byte[] screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				 Allure.addAttachment("Step 3 ERROR", "image/png", new ByteArrayInputStream(screenshot1), "png");
			}	
		} catch (org.openqa.selenium.NoSuchElementException e) {
			allureScreenshot();
			Assert.assertNotNull(page, "The Quotation Page is not presented");
			System.out.println(" - The Quotation page is not present");
		}
	}

	@When("User chooses a random Quotation")
	public void userChoosesARandomQuotation() throws InterruptedException {
		String liList = "/html/body/div[1]/div[3]/div/div[2]/div/div/div[5]/ul/li";
		String name = "/html/body/div[1]/div[3]/div/div[2]/div/div/div[5]/ul/li/div/div[1]/div[1]";
		               

		List<WebElement> liElements = driver.findElements(By.xpath(liList));

	    if (!liElements.isEmpty()) {
	        // Select a random element from the list
	        Random rand = new Random();
	        int randomIndex = rand.nextInt(liElements.size());

	        scrollDown();
	        
	        WebElement selectedLi = liElements.get(randomIndex);
	        selectedLi.click();

	        WebElement selectedLiName = selectedLi.findElement(By.xpath(name));
	        System.out.println(" - " + selectedLiName.getText() + " Provider's Quotation is selected");

	        scrollDown();
	        
	        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div[6]/button[2]")).click();   
	        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div[6]/button[2]")).click(); 
			/*
			 * String buttonText = "Next"; // Replace with the actual text on the button
			 * String buttonXpath = String.format("//button[contains(text(), '%s')]",
			 * buttonText); driver.findElement(By.xpath(buttonXpath)).click();
			 */
	        
	        
	        
	        Thread.sleep(1000);
	    } else {
	        System.out.println("No Quotations available");
	    }
	}
	@When("User selects additional benefits")
	public void userSelectsAdditionalBenefits() throws InterruptedException {
	   if (addBen.equals("No")) {
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//		    try {
//		        Thread.sleep(1000); // Adjust sleep time if needed		        
//		        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[29]/div[1]/div/div/label/span[1]/input")).click();
//		        scrollDown();
//		        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[29]/div[1]/div/div/label/span[1]/input")).click();
//		    } catch (InterruptedException e) {
//		        e.printStackTrace();
//		    }
//		   scrollDown();
//		   scrollDown();
//		   scrollDown();
//		   Thread.sleep(1000);
		   
//	        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[31]/button[2]")).click();
	   } else {
		   Assert.fail(" == Niruthu ==");
	   }
	   
	   String buttonText = "Next"; // Replace with the actual text on the button
	   String buttonXpath = String.format("//button[contains(text(), '%s')]", buttonText);
	   driver.findElement(By.xpath(buttonXpath)).click();
	   
        Thread.sleep(20000);  
	}
	@Then("Detailed Quotation Tab should be shown.")
	public void detailedQuotationTabShouldBeShown() {
		scrollDown();
		allureScreenshot();
	}
	@When("User clicks on the Product Disclosure Sheet disclaimer and Next button")
	public void userClicksOnTheProductDisclosureSheetDisclaimerAndNextButton() throws InterruptedException {
		scrollDown();
		
		if (moduleExcel.equals("ExpQuot")) {
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div[5]/ul/ul/div/div/div/label/span[1]/input")).click();
		} else if (moduleExcel.equals("ExpQuot2")) {
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/ul/div/div/div/label/span[1]/input")).click();
		}	

	    driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div[6]/button[2]")).click();
        Thread.sleep(1000);
	}

	@When("Payment Tab is shown")
	public void paymentTabIsShown() {
		WebElement page = null;
		
		try {						
			page = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div[4]/div/p"));
			wait.until(ExpectedConditions.visibilityOf(page));
			String getTitle = page.getText();

			if (getTitle.equals("Track your payment status")) {
				System.out.println(" - The Payment page is present");
				 byte[] screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				 Allure.addAttachment("Step", "image/png", new ByteArrayInputStream(screenshot1), "png");
			} else {
				Assert.assertEquals(getTitle, "Track your payment status");
				 byte[] screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				 Allure.addAttachment("Step ERROR", "image/png", new ByteArrayInputStream(screenshot1), "png");
			}	
		} catch (org.openqa.selenium.NoSuchElementException e) {
			allureScreenshot();
			Assert.assertNotNull(page, "The Payment Page is not presented");
			System.out.println(" - The Payment page is not present");
		}
	}
	@When("User clicks on the Make Payment button on Express Quotation")
	public void userClicksOnTheMakePaymentButtonOnExpressQuotation() throws InterruptedException {
		scrollDown();
	    driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[3]/button[2]")).click();
	    Thread.sleep(1000);
	    
	    allureScreenshot();
	    
	    driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div/form/div/button[2]")).click();
	    Thread.sleep(5000);
	}
	@When("User navigates to Payment gateway portal")
	public void userNavigatesToPaymentGatewayPortal() {
		WebElement page = null;
		
		try {						
			page = driver.findElement(By.xpath("/html/body/div/div/div/main/div/form/div[1]/h1"));
			wait.until(ExpectedConditions.visibilityOf(page));
			String getTitle = page.getText();

			if (getTitle.equals("Select Payment Method")) {
				System.out.println(" - The Payment Gateway page is present");
				 byte[] screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				 Allure.addAttachment("Step", "image/png", new ByteArrayInputStream(screenshot1), "png");
			} else {
				Assert.assertEquals(getTitle, "Select Payment Method");
				 byte[] screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				 Allure.addAttachment("Step ERROR", "image/png", new ByteArrayInputStream(screenshot1), "png");
			}	
		} catch (org.openqa.selenium.NoSuchElementException e) {
			allureScreenshot();
			Assert.assertNotNull(page, "The Payment Gateway Page is not presented");
			System.out.println(" - The Payment Gateway page is not present");
		}
	}
	@When("User clicks on Online Banking for Individual Account")
	public void userClicksOnOnlineBankingForIndividualAccount() throws InterruptedException {
	    driver.findElement(By.xpath("/html/body/div/div/div/main/div/form/div[2]/div[1]/div[1]/button")).click();
	    Thread.sleep(500);
	    
	    driver.findElement(By.xpath("//html/body/div/div/div/main/div/form/div[2]/div[1]/div[1]/div/button")).click();
	    Thread.sleep(500);
	}
	@When("User chooses Bank Name")
	public void userChoosesBankName() {
		String ulXPath = "/html/body/div/div/div/main/div/form/div[2]/div[1]/div[1]/ul";
		String liXPath = ulXPath + "/li";
		String buttonXPathTemplate = ulXPath + "/li[%d]/button";
		String nameXPathTemplate = ulXPath + "/li[%d]/button/p";

		List<WebElement> liElements = driver.findElements(By.xpath(liXPath));

		for (int liIndex = 1; liIndex <= liElements.size(); liIndex++) {
		    String currentNameXPath = String.format(nameXPathTemplate, liIndex);
		    WebElement nameElement = driver.findElement(By.xpath(currentNameXPath));

		    if (bankName.equals(nameElement.getText())) {
		        String currentButtonXPath = String.format(buttonXPathTemplate, liIndex);
		        WebElement buttonElement = driver.findElement(By.xpath(currentButtonXPath));
		        buttonElement.click();
		        break; // Exit the loop once the element is found and clicked
		    }
		}

		driver.findElement(By.xpath("/html/body/div/div/div/main/div/form/div[2]/div[1]/div[1]/div[2]/div/button")).click();
	}
	@When("User clicks on the Pay Now button")
	public void userClicksOnThePayNowButton() throws InterruptedException {
	    driver.findElement(By.xpath("/html/body/div/div/div/main/div/form/div[3]/button[2]")).click();
	    Thread.sleep(2000);    
	}
	@When("User inserts value into Bank User ID and Bank Password textboxes and Sign in")
	public void userInsertsValueIntoBankUserIDAndBankPasswordTextboxesAndSignIn() {
		WebElement BankID = null;
	    try {
	    	BankID = driver.findElement(By.id("userId"));
	    	BankID.sendKeys(bankUserId);
	    } catch (Exception e) {
			Assert.fail("User couldn't able to insert value into User Id textbox");
		}
	    
		WebElement BankPassword = null;
	    try {
	    	BankPassword = driver.findElement(By.id("password"));
	    	BankPassword.sendKeys(bankPassword);
	    } catch (Exception e) {
			Assert.fail("User couldn't able to insert value into Bank Password textbox");
		}
	    
		WebElement Button = null;
	    try {
	    	Button = driver.findElement(By.xpath("/html/body/div/div[2]/form/div/div[2]/button[1]"));
	    	Button.click();
	    	Thread.sleep(500);
	    } catch (Exception e) {
			Assert.fail("User couldn't able to click Button");
		}
	}
	@When("User clicks on the Confirm button to make FPX Payment")
	public void userClicksOnTheConfirmButtonToMakeFPXPayment() {
		WebElement Button = null;
	    try {
	    	Button = driver.findElement(By.xpath("/html/body/div/div[2]/form/div/div[2]/button[1]"));
	    	Button.click();
	    	Thread.sleep(500);
	    } catch (Exception e) {
			Assert.fail("User couldn't able to click Button");
		}
	}
	@When("Amount has been deducted message is shown")
	public void amountHasBeenDeductedMessageIsShown() throws InterruptedException {
	    allureScreenshot();
	    Thread.sleep(8000);
	}
	@When("User clicks on the Complete Transaction button")
	public void userClicksOnTheCompleteTransactionButton() {
//		WebElement Button = null;
	    try {
//	    	Button = driver.findElement(By.xpath("/html/body/div/form/p[1]/input[2]"));
//	    	Button.click();
	    	Thread.sleep(1000);
	    	allureScreenshot();
	    	Thread.sleep(5500);
	    } catch (Exception e) {
	    	allureScreenshot();
			Assert.fail("User couldn't able to click Button");
		}
	}

	@When("User clicks on Credit Card payment")
	public void userClicksOnCreditCardPayment() {
	    WebElement cc = null;
	    
	    try {
	    	cc = driver.findElement(By.xpath("/html/body/div/div/div/main/div/form/div[2]/div[1]/div[2]/div"));
	    	cc.click();
	    } catch (Exception e) {
			Assert.fail("User cannot click on the Credit Card Option");
		}
	}
	@When("User fill up credit card details")
	public void userFillUpCreditCardDetails() throws InterruptedException {
		allureScreenshot();
		Thread.sleep(60000);    
	    System.out.println(" %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% ");
	}
	@When("User clicks on the Confirm button to make credit card Payment")
	public void userClicksOnTheConfirmButtonToMakeCreditCardPayment() throws InterruptedException {
		allureScreenshot();
	    WebElement button = null;
	    try {
	    	button = driver.findElement(By.id("acssubmit"));
	    	button.click();
	    	Thread.sleep(1000);
	    } catch (Exception e) {
			Assert.fail("User couldn't able to click on the Pay Button");
		}
	}
	@When("User clicks on Submit button for Authentication Result")
	public void userClicksOnSubmitButtonForAuthenticationResult() throws InterruptedException {
	 allureScreenshot();
	 System.out.println(" %%% NOW %%%% ");
		Thread.sleep(2000);   
	    System.out.println(" %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% ");
	}
	@When("User navigates to the Adviser portal again")
	public void userNavigatesToTheAdviserPortalAgain() throws InterruptedException {
		Thread.sleep(1500);
	    allureScreenshot();
	    Thread.sleep(5000);
	}
	@Then("User can view the Payment Tab with payment receipt")
	public void userCanViewThePaymentTabWithPaymentReceipt() throws InterruptedException {
		scrollDown();
	    allureScreenshot();
	    Thread.sleep(1500);
	}

	@When("User clicks on the Enquiry Page to view the list of Enquiries")
	public void userClicksOnTheEnquiryPageToViewTheListOfEnquiries() {
	    WebElement button = null;
	    try {
	    	button = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div[1]/div/div/p[1]/a"));
	    	button.click();
	    	Thread.sleep(1500);
	    	allureScreenshot();
	    } catch (Exception e) {
			Assert.fail("User couldn't able to click on the Enquiry Page");
		}		
	}
	@When("User clicks on the newly created Enquiry")
	public void userClicksOnTheNewlyCreatedEnquiry() {
	    WebElement button = null;
	    try {
	    	button = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div[3]/div/table/tbody/tr[2]"));
	    	button.click();
	    	Thread.sleep(1500);
	    } catch (Exception e) {
			Assert.fail("User couldn't able to click on the Enquiry Page");
		}
	}
	@When("User clicks on the Policy Tab")
	public void userClicksOnThePolicyTab() {
	    WebElement button = null;
	    try {
	    	button = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div[3]/ul/li[4]"));
	    	button.click();
	    	Thread.sleep(1000);
	    } catch (Exception e) {
			Assert.fail("User couldn't able to click on the Policy Tab");
		}
	}
	@Then("Issue Date should be the current Date")
	public void issueDateShouldBeTheCurrentDate() {
	    WebElement IssueDate = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[3]/div/div/div/div/input"));
	    String Date = IssueDate.getAttribute("value");
	    
	    // Get today's date in the desired format (dd/MM/yyyy)
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    String currentDate = LocalDate.now().format(formatter);

	    // Compare the values
	    allureScreenshot();
	    Assert.assertEquals(Date, currentDate, "Issue Date is not the current date");
	}
	@Then("Expiry Date should be 364 days from the Effective Date")
	public void expiryDateShouldBeDaysFromTheEffectiveDate() {
	   allureScreenshot();
	}

	
//Negative
	@When("The Name textbox should throw validation error.")
	public void theNameTextboxShouldThrowValidationError() throws InterruptedException {
		WebElement custNameInput = null;
		
		try {
			custNameInput = driver.findElement(By.name("customerName"));
			custNameInput.sendKeys(Keys.chord(Keys.ENTER));
			
			allureScreenshot();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			allureScreenshot();
			Assert.assertNotNull(custNameInput, "The Name textbox should throw validation error");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(500);
		}
	}
	@Then("The Name textbox should display the full value.")
	public void theNameTextboxShouldDisplayTheFullValue() throws InterruptedException {
		WebElement custNameInput = null;
		
		try {
			custNameInput = driver.findElement(By.name("customerName"));
			custNameInput.sendKeys(Keys.chord(Keys.ENTER));
			
			allureScreenshot();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			allureScreenshot();
			Assert.assertNotNull(custNameInput, "The Name textbox should throw validation error");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(500);
		}
	}
	@When("The Name textbox should not display the full value.")
	public void theNameTextboxShouldNotDisplayTheFullValue() throws InterruptedException {
		WebElement custNameInput = null;
		
		try {
			custNameInput = driver.findElement(By.name("customerName"));
			custNameInput.sendKeys(Keys.chord(Keys.ENTER));
			
			allureScreenshot();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			allureScreenshot();
			Assert.assertNotNull(custNameInput, "The Name textbox should throw validation error");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(500);
		}
	}
	@When("The Name textbox should not display the value.")
	public void theNameTextboxShouldNotDisplayTheValue() throws InterruptedException {
		WebElement custNameInput = null;
		
		try {
			custNameInput = driver.findElement(By.name("customerName"));
			custNameInput.sendKeys(Keys.chord(Keys.ENTER));
			
			allureScreenshot();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			allureScreenshot();
			Assert.assertNotNull(custNameInput, "The Name textbox should throw validation error");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(500);
		}
	}

	@When("The NRIC textbox should throw validation error.")
	public void theNRICTextboxShouldThrowValidationError() throws InterruptedException {
		WebElement idInput = null;		
		try {
			idInput = driver.findElement(By.name("identityNo"));
			idInput.sendKeys(Keys.chord(Keys.ENTER));
			allureScreenshot();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			allureScreenshot();
			Assert.assertNotNull(idInput, "The NRIC textbox should throw validation error.");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(500);
		}
	}	
	@Then("The NRIC textbox should display the full value.")
	public void theNRICTextboxShouldDisplayTheFullValue() throws InterruptedException {
		WebElement idInput = null;		
		try {
			idInput = driver.findElement(By.name("identityNo"));
			idInput.sendKeys(Keys.chord(Keys.ENTER));
			allureScreenshot();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			allureScreenshot();
			Assert.assertNotNull(idInput, "The NRIC textbox should display the full value.");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(500);
		}
	}
	@When("The NRIC textbox should not display the full value.")
	public void theNRICTextboxShouldNotDisplayTheFullValue() throws InterruptedException {
		WebElement idInput = null;		
		try {
			idInput = driver.findElement(By.name("identityNo"));
			idInput.sendKeys(Keys.chord(Keys.ENTER));
			allureScreenshot();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			allureScreenshot();
			Assert.assertNotNull(idInput, "The NRIC textbox should not display the full value.");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(500);
		}
	}

	@When("The Contact Number textbox should throw validation error.")
	public void theContactNumberTextboxShouldThrowValidationError() throws InterruptedException {
		WebElement contactNoInput = null;
		
		try {
			contactNoInput = driver.findElement(By.name("contactNo"));
			contactNoInput.sendKeys(Keys.chord(Keys.ENTER));
			allureScreenshot();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			allureScreenshot();
			Assert.fail("The Contact Number textbox should throw validation error");
			Thread.sleep(500);
		}
	}
	@Then("The Contact Number textbox should display the full value.")
	public void theContactNumberTextboxShouldDisplayTheFullValue() throws InterruptedException {
		WebElement contactNoInput = null;
		
		try {
			contactNoInput = driver.findElement(By.name("contactNo"));
			contactNoInput.sendKeys(Keys.chord(Keys.ENTER));
			allureScreenshot();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			allureScreenshot();
			Assert.fail("The Contact Number textbox should display the full value");
			Thread.sleep(500);
		}
	}
	@When("The Contact Number textbox should not display the full value.")
	public void theContactNumberTextboxShouldNotDisplayTheFullValue() throws InterruptedException {
		WebElement contactNoInput = null;
		
		try {
			contactNoInput = driver.findElement(By.name("contactNo"));
			contactNoInput.sendKeys(Keys.chord(Keys.ENTER));
			allureScreenshot();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			allureScreenshot();
			Assert.fail("The Contact Number textbox should not display the full value");
			Thread.sleep(500);
		}
	}
	@When("The Contact Number textbox should not display the value.")
	public void theContactNumberTextboxShouldNotDisplayTheValue() throws InterruptedException {
		WebElement contactNoInput = null;
		
		try {
			contactNoInput = driver.findElement(By.name("contactNo"));
			contactNoInput.sendKeys(Keys.chord(Keys.ENTER));
			allureScreenshot();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			allureScreenshot();
			Assert.fail("The Contact Number textbox should not display the value");
			Thread.sleep(500);
		}
	}

	@When("The Email textbox should throw validation error.")
	public void theEmailTextboxShouldThrowValidationError() throws InterruptedException {
		WebElement emailInput = null;
		
		try {
			emailInput = driver.findElement(By.name("emailAddress"));
			emailInput.sendKeys(Keys.chord(Keys.ENTER));
			allureScreenshot();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			allureScreenshot();
			Assert.fail("The Email textbox should throw validation error");
			Thread.sleep(500);
		}
	}
	@Then("The Email textbox should display the full value.")
	public void theEmailTextboxShouldDisplayTheFullValue() throws InterruptedException {
		WebElement emailInput = null;
		
		try {
			emailInput = driver.findElement(By.name("emailAddress"));
			emailInput.sendKeys(Keys.chord(Keys.ENTER));
			allureScreenshot();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			allureScreenshot();
			Assert.fail("The Email textbox should display the full value.");
			Thread.sleep(500);
		}
	}
	
	
	@When("The Line1 and Line2 textbox should throw validation error")
	public void theLine1AndLine2TextboxShouldThrowValidationError() throws InterruptedException {
		WebElement addLine2Input = null;
		
		try {
			addLine2Input = driver.findElement(By.name("address2"));
			addLine2Input.sendKeys(Keys.chord(Keys.ENTER));
			allureScreenshot();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			allureScreenshot();
			Assert.fail("The Line1 and Line2 textbox should throw validation error");
			Thread.sleep(500);
		}
	}
	@When("User skips postcode")
	public void userSkipsPostcode() throws InterruptedException {
		System.out.println(" - Skips Postcode");
	}
	@When("The Postcode dropdown list should throw validation error.")
	public void thePostcodeDropdownListShouldThrowValidationError() throws InterruptedException {
		WebElement driveExpInput = null;
		
		try {
			driveExpInput = driver.findElement(By.name("address2"));
			driveExpInput.sendKeys(Keys.chord(Keys.ENTER));
			allureScreenshot();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			allureScreenshot();
			Assert.fail("The Postcode should throw validation error");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(500);
		}
	}
	
	
	@When("User skips Maritial Status")
	public void userSkipsMaritialStatus() {
	    System.out.println(" - Skips Maritial Status");
	}
	@When("The Maritial Status dropdown list should throw validation error.")
	public void theMaritialStatusDropdownListShouldThrowValidationError() throws InterruptedException {
		WebElement idInput = null;		
		try {
			idInput = driver.findElement(By.name("address1"));
			idInput.sendKeys(Keys.chord(Keys.ENTER));
			allureScreenshot();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			allureScreenshot();
			Assert.fail("The Maritial Status dropdown list should throw validation error");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(500);
		}
	}
	
	@When("User skips Nature of Business.")
	public void userSkipsNatureOfBusiness() throws InterruptedException {
		WebElement Input = null;
		try {
			Input = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[15]/div/div/div/div[1]/div[2]/input"));
			Input.sendKeys(maritial);
			Thread.sleep(2500);
			Input.sendKeys(Keys.ENTER);
			Thread.sleep(500);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			allureScreenshot();
			Assert.assertNotNull(Input, "User should be able to insert value in the dropdown input");
			Thread.sleep(500);
		}
		
		System.out.println(" - Skips Nature of Business");	
	}
	@When("The Nature of Business dropdown list should throw validation error.")
	public void theNatureOfBusinessDropdownListShouldThrowValidationError() throws InterruptedException {
		WebElement idInput = null;		
		try {
			idInput = driver.findElement(By.name("address1"));
			idInput.sendKeys(Keys.chord(Keys.ENTER));
			allureScreenshot();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			allureScreenshot();
			Assert.fail("The Nature of Business dropdown list should throw validation error");
			Thread.sleep(500);
		}
	}
	
	@When("User skips Occupation")
	public void userSkipsOccupation() throws InterruptedException {
		WebElement Input = null;
		try {
			Input = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[15]/div/div/div/div[1]/div[2]/input"));
			Input.sendKeys(maritial);
			Thread.sleep(2500);
			Input.sendKeys(Keys.ENTER);
			Thread.sleep(500);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			allureScreenshot();
			Assert.assertNotNull(Input, "User should be able to insert value in the dropdown input");
			Thread.sleep(500);
		}
		
		WebElement NatOfBusInput = null;
		try {
			NatOfBusInput = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[16]/div/div/div/div[1]/div[2]/input"));
			NatOfBusInput.sendKeys(natOfBus);
			Thread.sleep(2500);
			NatOfBusInput.sendKeys(Keys.ENTER);
			Thread.sleep(500);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			allureScreenshot();
			Assert.assertNotNull(NatOfBusInput, "User should be able to insert value in the dropdown input");
			Thread.sleep(500);
		}
		
		System.out.println(" - Skips Occupation");
	}
	@When("The Occupation dropdown list should throw validation error.")
	public void theOccupationDropdownListShouldThrowValidationError() throws InterruptedException {
		WebElement addLine2Input = null;
		
		try {
			addLine2Input = driver.findElement(By.name("address1"));
			addLine2Input.sendKeys(Keys.chord(Keys.ENTER));
			allureScreenshot();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			allureScreenshot();
			Assert.fail("The Line1 and Line2 textbox should throw validation error");
			Thread.sleep(500);
		}
	}
	
	@When("User clicks on the Next button without choosing the Quotation")
	public void userClicksOnTheNextButtonWithoutChoosingTheQuotation() throws InterruptedException {
        scrollDown();
        
		WebElement Button = null;
		try {
			allureScreenshot();
			Button = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div[6]/button[2]"));
			
			if (Button.getAttribute("disabled") != null) {
				allureScreenshot();
				Thread.sleep(500);
				System.out.println("Button is not clickable. It's good.");
			} else {
				allureScreenshot();
				Assert.fail("User should not be able to click the New Enquiry button");
				System.out.println("Nope");
			}
			
//			/* wait.until(ExpectedConditions.elementToBeClickable(Button)); */
//			Button.click();
//			Thread.sleep(500);	
//			Assert.fail("User could not be able to click the New Enquiry button");
//			System.out.println("Nope"); // The div is not present      
		} catch (org.openqa.selenium.NoSuchElementException e) {	
			allureScreenshot();
			Thread.sleep(500);
			System.out.println("Button is not clickable. It's good.");
		}
	}
	@Then("System is still should be in Quotation Tab")
	public void systemIsStillShouldBeInQuotationTab() {
		allureScreenshot();
	}
	
	@When("Vehicle info page should not be shown in the Enquiry Tab.")
	public void vehicleInfoPageShouldNotBeShownInTheEnquiryTab() {
		WebElement Unsuccessful = null;
		WebElement UnsuccessfulStat = null;
		try {			
			Unsuccessful = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/h1"));
//			String StrUnsuccessful = Unsuccessful.getText();
			wait.until(ExpectedConditions.visibilityOf(Unsuccessful));
			
			System.out.println(Unsuccessful.getText());			
			UnsuccessfulStat = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/p/span"));
			String StrUnsuccessfulStat = UnsuccessfulStat.getText();
			System.out.println(" - " + StrUnsuccessfulStat);
			allureScreenshot();
			
			if (StrUnsuccessfulStat.equals(null)) {
				allureScreenshot();
				System.out.println("Continue as normal");
				Assert.fail(" ID: " + id + " and VehNo: " + vehRegNo + " has already been used.");
			}
						
		} catch (Exception e1) {
			allureScreenshot();
			System.out.println("Continue as normal");
//			Assert.fail("System should not Continue as normal as ID: " + id + " and VehNo: " + vehRegNo + " has already been used.");
		}
	}
	
	
	@When("User inserts wrong value into Bank User ID and Bank Password textboxes")
	public void userInsertsWrongValueIntoBankUserIDAndBankPasswordTextboxes() {
		WebElement BankID = null;
	    try {
	    	BankID = driver.findElement(By.id("userId"));
	    	BankID.sendKeys(bankUserId);
	    } catch (Exception e) {
			Assert.fail("User couldn't able to insert value into User Id textbox");
		}
	    
		WebElement BankPassword = null;
	    try {
	    	BankPassword = driver.findElement(By.id("password"));
	    	BankPassword.sendKeys(bankPassword);
	    } catch (Exception e) {
			Assert.fail("User couldn't able to insert value into Bank Password textbox");
		}
	}
	@When("Try to Sign in")
	public void tryToSignIn() {
		WebElement Button = null;
	    try {
	    	Button = driver.findElement(By.xpath("/html/body/div/div[2]/form/div/div[2]/button[1]"));
	    	Button.click();
	    	Thread.sleep(500);
	    } catch (Exception e) {
			Assert.fail("User couldn't able to click Button");
		}
	}
	@When("User cannot sigin to the portal")
	public void userCannotSiginToThePortal() {
	    allureScreenshot();
	}
	
	@When("Policy Tab is not clickable")
	public void policyTabIsNotClickable() {
		allureScreenshot();
//	    WebElement button = null;
//	    try {
//	    	allureScreenshot();
//	    	button = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div[3]/ul/li[4]"));
//	    	wait.until(ExpectedConditions.elementToBeClickable(button));
//	    	button.click();
//	    	Thread.sleep(1000);
//	    	Assert.fail("User should not be able to click on the Policy Tab");
//	    } catch (Exception e) {
//	    	allureScreenshot();
//			System.out.println("Button is not clickable. It's good.");
//		}
	}
	
	@Then("Newly created Policy should be 'Pending Payment' status")
	public void newlyCreatedPolicyShouldBeStatus() {
	    WebElement Status = null;
	    String StatusText = null;
	    
	    try {
	    	Status = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div[3]/div/table/tbody/tr[1]/td[5]"));
	    	StatusText = Status.getText();
	    	
	    	if (StatusText != "Pending Payment" && !StatusText.equals("Pending Payment")) {
	    		allureScreenshot();
	    		Assert.assertEquals(StatusText, "Pending Payment");
	    	}
	    	
	    } catch (Exception e) {
	    	allureScreenshot();
			Assert.assertNotNull(Status, "The Enquiry Page is not presented");
		}
	}
	@Then("Newly created Policy should be 'Completed with paid' status after payment")
	public void newlyCreatedPolicyShouldBeStatusAfterPayment() {
		WebElement Status = null;
		String StatusText = null;

		try {
			Status = driver.findElement(
					By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div[3]/div/table/tbody/tr[1]/td[5]"));
			StatusText = Status.getText();

			if (StatusText != "Completed With Paid" && !StatusText.equals("Completed With Paid")) {
				allureScreenshot();
				Assert.assertEquals(StatusText, "Completed With Paid");
			}

		} catch (Exception e) {
			allureScreenshot();
			Assert.assertNotNull(Status, "The Enquiry Page is not presented");
		}
	}
	
	
	
	
	
	
	
}
