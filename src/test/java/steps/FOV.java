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

public class FOV extends DriverInstance {

	static String module = "Friends of VKA (FOV)";
	
	@When("User navigates to FOV")
	public void userNavigatesToFOV() throws InterruptedException {
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
	@Then("FOV module should display")
	public void FOVModuleShouldDisplay() {
		WebElement header = null;

		try {
			header = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div[1]/div/div/p"));
			String getTitle = header.getText();

			if (getTitle.equals("Friends of VKA (FOV)")) {
				System.out.println(" - The FOV page is present");
				byte[] screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				Allure.addAttachment("Step", "image/png", new ByteArrayInputStream(screenshot1), "png");
			} else {
				Assert.assertEquals(getTitle, "Friends of VKA (FOV)");
				byte[] screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				Allure.addAttachment("Step ERROR", "image/png", new ByteArrayInputStream(screenshot1), "png");
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(header, "The FOV Page is not presented");
			System.out.println(" - The FOV page is not present");
		}
	}

	@When("User scroll down to the bottom of the page")
	public void userScrollDownToTheBottomOfThePage() {
		scrollDown();
		scrollDown();
	}
	@When("User clicks on the checkbox")
	public void userClicksOnTheCheckbox() throws InterruptedException {
		WebElement Button = null;
		try {
			Button = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[16]/div/div/label/span[1]"));
			Button.click();
			Thread.sleep(500);

		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.fail("User could not be able to click the disclaimer checkbox");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(500);
		}
	}
	@Then("The checkbox should be checked")
	public void theCheckboxShouldBeChecked() {
		allureScreenshot();
		// Locate the checkbox element
		WebElement checkbox = driver.findElement(By.cssSelector("svg[data-testid='CheckBoxIcon']"));

		// Check if the checkbox is clicked
		String dataTestId = checkbox.getAttribute("data-testid");

		if ("CheckBoxIcon".equals(dataTestId)) {
		    // The checkbox is clicked
		    System.out.println("Checkbox is clicked.");
		} else if ("CheckBoxOutlineBlankIcon".equals(dataTestId)) {
		    // The checkbox is not clicked
		    System.out.println("Checkbox is not clicked.");
		    Assert.fail("Checkbox is not clicked."); // You can fail the test using Assert.fail()
		}
	}
	
	@When("User clicks again to uncheck the checkbox")
	public void userClicksAgainToUncheckTheCheckbox() throws InterruptedException {
		WebElement Button = null;
		try {
			Button = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[16]/div/div/label/span[1]"));
			Button.click();
			Thread.sleep(500);

		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.fail("User could not be able to uncheck the disclaimer checkbox");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(500);
		}
	}
	@Then("The checkbox should be unchecked")
	public void theCheckboxShouldBeUnchecked() {
		allureScreenshot();
		// Locate the checkbox element
		WebElement checkbox = driver.findElement(By.cssSelector("svg[data-testid='CheckBoxOutlineBlankIcon']"));

		// Check if the checkbox is clicked
		String dataTestId = checkbox.getAttribute("data-testid");

		if ("CheckBoxIcon".equals(dataTestId)) {
		    Assert.fail("Checkbox is not unchecked."); // You can fail the test using Assert.fail()
		} else if ("CheckBoxOutlineBlankIcon".equals(dataTestId)) {
		    // The checkbox is clicked
		    System.out.println("Checkbox is unchecked.");		    
		}
	}

	//Terms of Use
	@When("User clicks on the Terms of Use")
	public void userClicksOnTheTermsOfUse() throws InterruptedException {
		WebElement Button = null;
		try {
			allureScreenshot();
			
			Button = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[16]/div/div/label/span[2]/a[2]"));
			Button.click();
			Thread.sleep(500);

		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.fail("User could not be able to click the Terms of Use hyperlink");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(500);
		}
	}
	@Then("New Tab should be shown with Terms of Use")
	public void newTabShouldBeShownWithTermsOfUse() {
	    allureScreenshotAnotherTab();
	}

	//Privacy Statement
	@When("User clicks on the Privacy Statement")
	public void userClicksOnThePrivacyStatement() throws InterruptedException {
		WebElement Button = null;
		try {
			allureScreenshot();
			
			Button = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[16]/div/div/label/span[2]/a[3]"));
			Button.click();
			Thread.sleep(500);

		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.fail("User could not be able to click the Privacy Statement hyperlink");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(500);
		}
	}
	@Then("New Tab should be shown with Privacy Statement")
	public void newTabShouldBeShownWithPrivacyStatement() {
		allureScreenshotAnotherTab();
	}

	//Legal Notes
	@When("User clicks on the Legal Notes")
	public void userClicksOnTheLegalNotes() throws InterruptedException {
		WebElement Button = null;
		try {
			allureScreenshot();
			
			Button = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[16]/div/div/label/span[2]/a[1]"));
			Button.click();
			Thread.sleep(500);

		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.fail("User could not be able to click the Legal Notes hyperlink");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(500);
		}
	}
	@Then("New Tab should be shown with Legal notes")
	public void newTabShouldBeShownWithLegalNotes() {
		allureScreenshotAnotherTab();
	}

	//Add
	//-----Individual
	@When("User chooses Entity Type as {string}")
	public void userChoosesEntityTypeAs(String entityType) throws InterruptedException {
		WebElement Button = null;
		WebElement Input = null;
		try {
			Button = driver.findElement(
					By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[1]/div/div/div/div[2]"));
			
			Button.click();
			Thread.sleep(500);			
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(Button, "User should be able to click the Entity Type dropdown");
			System.out.println(" - Nope = Entity Type dropdown"); // The div is not present
			Thread.sleep(500);
		}

		try {
			Input = driver.findElement(By.id("react-select-2-input"));
			Input.sendKeys(entityType);
			Thread.sleep(3000);
			Input.sendKeys(Keys.ENTER);
			Thread.sleep(500);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(Input, "User should be able to insert value in the dropdown input");
			System.out.println(" - Nope = dropdown input"); // The div is not present
			Thread.sleep(500);
		}
	}
	@When("User chooses Nationality as {string}")
	public void userChoosesNationalityAs(String nationality) throws InterruptedException {
		WebElement Button = null;
		WebElement Input = null;
		try {
			Button = driver.findElement(
					By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[2]/div/div/div/div[2]"));
			
			Button.click();
			Thread.sleep(500);			
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(Button, "User should be able to click the Nationality dropdown");
			System.out.println(" - Nope = Nationality dropdown"); // The div is not present
			Thread.sleep(500);
		}

		try {
			Input = driver.findElement(By.id("react-select-3-input"));
			Input.sendKeys(nationality);
			Thread.sleep(3000);
			Input.sendKeys(Keys.ENTER);
			Thread.sleep(500);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(Input, "User should be able to insert value in the dropdown input");
			System.out.println(" - Nope = dropdown input"); // The div is not present
			Thread.sleep(500);
		}
	}
	@When("User inserts value for Name as {string}")
	public void userInsertsValueForNameAs(String name) throws InterruptedException {
		WebElement input = null;
		
		try {
			input = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[3]/div/div/div/input"));		
			input.sendKeys(name);
//			Thread.sleep(500);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(input, "User could not be able to Insert Value to Name textbox");
			System.out.println(" - Nope = Name textbox"); // The div is not present
			Thread.sleep(500);
		}
	}
	@When("User inserts value for ID as {string}")
	public void userInsertsValueForNRICAs(String id) throws InterruptedException {
		WebElement input = null;
		
		try {
			input = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[4]/div/div/div/input"));		
			input.sendKeys(id);
//			Thread.sleep(500);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(input, "User could not be able to Insert Value to NRIC textbox");
			System.out.println(" - Nope = NRIC textbox"); // The div is not present
			Thread.sleep(500);
		}
	}
	@When("User inserts value for Contact Number as {string}")
	public void userInsertsValueForContactNumberAs(String contactNo) throws InterruptedException {
		WebElement input = null;
		
		try {
			input = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[5]/div/div/div/input"));
			
			input.sendKeys(contactNo);
//			Thread.sleep(500);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(input, "User could not be able to Insert Value to Contact Number textbox");
			System.out.println(" - Nope = Contact Number textbox"); // The div is not present
			Thread.sleep(500);
		}
	}
	@When("User inserts value for Email as {string}")
	public void userInsertsValueForEmailAs(String email) throws InterruptedException {
		WebElement input = null;
		
		try {
			input = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[6]/div/div/div/input"));
			
			input.sendKeys(email);
//			Thread.sleep(500);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(input, "User could not be able to Insert Value to Email textbox");
			System.out.println(" - Nope = Email textbox"); // The div is not present
			Thread.sleep(500);
		}
		allureScreenshot();
		scrollDown();
	}
	@When("User chooses Bank Name as {string}")
	public void userChoosesBankNameAs(String bankName) throws InterruptedException {
		WebElement Button = null;
		WebElement Input = null;
		try {
			Button = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[7]/div/div/div/div[2]"));
			
			Button.click();
			Thread.sleep(500);			
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(Button, "User should be able to click the Bank Name dropdown");
			System.out.println(" - Nope = Bank Name dropdown"); // The div is not present
			Thread.sleep(500);
		}

		try {
			Input = driver.findElement(By.id("react-select-4-input"));
			Input.sendKeys(bankName);
			Thread.sleep(3500);
			Input.sendKeys(Keys.ENTER);
			Thread.sleep(500);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(Input, "User should be able to insert value in the dropdown input");
			System.out.println(" - Nope = dropdown input"); // The div is not present
			Thread.sleep(500);
		}
	}
	@When("User inserts value for Bank Account as {string}")
	public void userInsertsValueForBankAccountAs(String accountNo) throws InterruptedException {
		WebElement input = null;
		
		try {
			input = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[8]/div/div/div/input"));
			input.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			input.sendKeys(accountNo);
//			Thread.sleep(500);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(input, "User could not be able to Insert Value to Bank Account textbox");
			System.out.println(" - Nope = Bank Account textbox"); // The div is not present
			Thread.sleep(500);
		}
	}
	@When("User inserts value for Line 1 as {string}")
	public void userInsertsValueForLineAs(String line1) throws InterruptedException {
		WebElement input = null;
		
		try {
			input = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[9]/div/div/div/input"));
			
			input.sendKeys(line1);
//			Thread.sleep(500);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(input, "User could not be able to Insert Value to Line 1 textbox");
			System.out.println(" - Nope = Designation textbox"); // The div is not present
			Thread.sleep(500);
		}
	}
	@When("User inserts value for Line 2 as {string}")
	public void userInsertsValueForLine2As(String line2) throws InterruptedException {
		WebElement input = null;
		
		try {
			input = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[10]/div/div/div/input"));
			
			input.sendKeys(line2);
//			Thread.sleep(500);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(input, "User could not be able to Insert Value to Line 2 textbox");
			System.out.println(" - Nope = Designation textbox"); // The div is not present
			Thread.sleep(500);
		}
	}
	@When("User chooses Postcode as {string}")
	public void userChoosesPostcodeAs(String postcode) throws InterruptedException {
		WebElement Button = null;
		WebElement Input = null;
		try {
			Button = driver.findElement(
					By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[11]/div/div/div/div[2]"));
			
			Button.click();
			Thread.sleep(500);			
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(Button, "User should be able to click the Postcode dropdown");
			System.out.println(" - Nope = Postcode dropdown"); // The div is not present
			Thread.sleep(500);
		}

		try {
			Input = driver.findElement(By.id(
					"react-select-5-input"));
			Input.sendKeys(postcode);
			Thread.sleep(3500);
			Input.sendKeys(Keys.ENTER);
			Thread.sleep(500);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(Input, "User should be able to insert value in the dropdown input");
			System.out.println(" - Nope = dropdown input"); // The div is not present
			Thread.sleep(500);
		}
	}
	@When("User inserts value in the Remark as {string}")
	public void userInsertsValueInTheRemarkAs(String remark) throws InterruptedException {
		WebElement input = null;
		
		try {
			input = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[15]/div/div/textarea[1]"));
			
			input.sendKeys(remark);
//			Thread.sleep(500);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(input, "User could not be able to Insert Value to Designation textbox");
			System.out.println(" - Nope = Designation textbox"); // The div is not present
			Thread.sleep(500);
		}
		allureScreenshot();
		scrollDown();
	}
	@When("User clicks on the Next button in FOV page")
	public void userClicksOnTheNextButtonInFOVPage() throws InterruptedException {
		WebElement Button = null;
		try {
			Button = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[2]/button"));
			Button.click();
			Thread.sleep(500);
            
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(Button, "User could not be able to click on the Next button");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(500);
		}
	}
	@Then("The next tab Documents should be shown")
	public void theNextTabDocumentsShouldBeShown() {
		WebElement header = null;

		try {
			header = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div[4]/p"));
			String getTitle = header.getText();

			if (getTitle.equals("Upload required documents")) {
				System.out.println(" - The Upload Document page is present");
				byte[] screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				Allure.addAttachment("Step", "image/png", new ByteArrayInputStream(screenshot1), "png");
			} else {
				Assert.assertEquals(getTitle, "Upload required documents");
				byte[] screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				Allure.addAttachment("Step ERROR", "image/png", new ByteArrayInputStream(screenshot1), "png");
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(header, "The Upload Document Page is not presented");
			System.out.println(" - The Upload Document page is not present");
		}
	}

	//-----Company
	@When("User inserts value for Company Name as {string}")
	public void userInsertsValueForCompanyNameAs(String compName) throws InterruptedException {
		WebElement input = null;
		
		try {
			input = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[2]/div/div/div/input"));	
			input.sendKeys(compName);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(input, "User could not be able to Insert Value to Company Name textbox");
			System.out.println(" - Nope = Company Name textbox"); // The div is not present
			Thread.sleep(500);
		}
	}
	@When("User inserts value for Business Registration No as {string}")
	public void userInsertsValueForBusinessRegistrationNoAs(String bussRegNo) throws InterruptedException {
		WebElement input = null;
		
		try {
			input = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[3]/div/div/div/input"));	
			input.sendKeys(bussRegNo);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(input, "User could not be able to Insert Value to Company Name textbox");
			System.out.println(" - Nope = Company Name textbox"); // The div is not present
			Thread.sleep(500);
		}
	}
	@When("User inserts value for Office Number as {string}")
	public void userInsertsValueForOfficeNumberAs(String contactNo) throws InterruptedException {
		WebElement input = null;
		
		try {
			input = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[4]/div/div/div/input"));	
			input.sendKeys(contactNo);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(input, "User could not be able to Insert Value to Contact Number textbox");
			System.out.println(" - Nope = Contact Number textbox"); // The div is not present
			Thread.sleep(500);
		}
	}
	@When("User inserts value for Email as {string} for company")
	public void userInsertsValueForEmailAsForCompany(String email) throws InterruptedException {
		WebElement input = null;
		
		try {
			input = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[5]/div/div/div/input"));			
			input.sendKeys(email);
//			Thread.sleep(500);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(input, "User could not be able to Insert Value to Email textbox");
			System.out.println(" - Nope = Email textbox"); // The div is not present
			Thread.sleep(500);
		}
		allureScreenshot();
		scrollDown();
	}
	@When("User chooses Nature of Business as {string}")
	public void userChoosesNatureOfBusinessAs(String natOfBuss) throws InterruptedException {
		WebElement Button = null;
		WebElement Input = null;
		try {
			Button = driver.findElement(
					By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[6]/div/div/div/div[2]"));
			
			Button.click();		
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(Button, "User should be able to click the Nature of Business dropdown");
			System.out.println(" - Nope = Entity Type dropdown"); // The div is not present
			Thread.sleep(500);
		}

		try {
			Input = driver.findElement(By.id("react-select-8-input"));
			Input.sendKeys(natOfBuss);
			Thread.sleep(4000);
			Input.sendKeys(Keys.ENTER);
			Thread.sleep(500);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(Input, "User should be able to insert value in the dropdown input");
			System.out.println(" - Nope = dropdown input"); // The div is not present
			Thread.sleep(500);
		}
		allureScreenshot();
		scrollDown();
	}

	//Upload Doc	
	//-----Malaysian
	@When("User uploads NRIC document")
	public void userUploadSNRICDocument() throws InterruptedException {
		WebElement file = driver.findElement(By.id("identity"));
		String filePath = "C:\\Users\\priya\\Downloads\\sample.pdf"; // Replace with the actual file path
		file.sendKeys(filePath);
		Thread.sleep(500);
		allureScreenshot();
	}
	@When("User Uploads Bank Statement document")
	public void userUploadsBankStatementDocument() throws InterruptedException {
		WebElement file = driver.findElement(By.id("bankStatement"));
		String filePath = "C:\\Users\\priya\\Downloads\\sample.pdf"; // Replace with the actual file path
		file.sendKeys(filePath);
		Thread.sleep(500);
		allureScreenshot();
	}
	@When("User Clicks Next button to complete FOV")
	public void userClicksNextButtonToCompleteFOV() throws InterruptedException {
		scrollDown();
		WebElement Button = null;
		try {
			allureScreenshot();
			
			Button = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[2]/button[2]"));
			Button.click();
			Thread.sleep(500);

		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.fail("User could not be able to click the Next Button");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(500);
		}
	}
	@Then("Application should be send to Backoffice")
	public void applicationShouldBeSendToBackoffice() {
		WebElement headerEn = driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/h1"));

		WebElement submitText = driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/p/span"));
		String EnStatement = submitText.getText();

		if (headerEn.getText().equals("Application Sent")) {
			System.out.println(" - " + EnStatement);
		} else {
			Assert.fail("User could not be able to add new FOV");
		}
	}
	
	//-----Foreigner
	@When("User uploads Passport document")
	public void userUploadSPassportDocument() throws InterruptedException {
		WebElement file = driver.findElement(By.id("identity"));
		String filePath = "C:\\Users\\priya\\Downloads\\sample.pdf"; // Replace with the actual file path
		file.sendKeys(filePath);
		Thread.sleep(500);
		allureScreenshot();
		scrollDown();
	}
	@When("User uploads VISA document")
	public void userUploadSVISADocument() throws InterruptedException {
		WebElement file = driver.findElement(By.id("visa"));
		String filePath = "C:\\Users\\priya\\Downloads\\sample.pdf"; // Replace with the actual file path
		file.sendKeys(filePath);
		Thread.sleep(500);
		allureScreenshot();
		scrollDown();
	}
	
	//-----Company
	@When("User uploads Form 24 document")
	public void userUploadSFormDocument() throws InterruptedException {
		WebElement file = driver.findElement(By.id("form24"));
		String filePath = "C:\\Users\\priya\\Downloads\\sample.pdf"; // Replace with the actual file path
		file.sendKeys(filePath);
		Thread.sleep(500);
		allureScreenshot();
		scrollDown();
	}
	@When("User uploads Authorization Letter document")
	public void userUploadSAuthorizationLetterDocument() throws InterruptedException {
		WebElement file = driver.findElement(By.id("authorisationLetter"));
		String filePath = "C:\\Users\\priya\\Downloads\\sample.pdf"; // Replace with the actual file path
		file.sendKeys(filePath);
		Thread.sleep(500);
		allureScreenshot();
		scrollDown();
	}
	
	
	//----------Validation--------------
	//====== Name =======
	@When("The Name textbox should not display the value")
	public void theTextboxShouldNotDisplayTheValue() {
		WebElement inputField = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[3]/div/div/div/input"));
		
		String fieldText = inputField.getAttribute("value");
		
		allureScreenshot();
		
		if(!fieldText.isEmpty()) {
			Assert.fail("System allows user to add numbers");
		} else {
			System.out.println(" - Value is not inserted");
		}	
	}
	@When("The Name textbox should not display the full value")
	public void theTextboxShouldNotDisplayTheFullValue() {
		WebElement inputField = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[3]/div/div/div/input"));
		
		String fieldText = inputField.getAttribute("value");
		
		allureScreenshot();
		
		if(!fieldText.matches("^[a-zA-Z]*$")) {
			Assert.fail("Name Input field should only accept alphabetic characters and not numbers or symbols.");
		} else {
			System.out.println(" - Value is inserted");
		}
	}
	@Then("The Name textbox should display the full value")
	public void theTextboxShouldDisplayTheFullValue() {
		WebElement inputField = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[3]/div/div/div/input"));
		
		String fieldText = inputField.getAttribute("value");
		
		allureScreenshot();
		
		if(fieldText.isEmpty()) {
			Assert.fail("System does not allow the user to insert value");
		} else {	
			System.out.println(" - Yes");			
		}	
	}
	@When("The Name textbox should throw validation error")
	public void theNameTextboxShouldThrowValidationError() {
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[3]/div/div/div/input")).sendKeys(Keys.chord(Keys.ENTER));
		
		allureScreenshot();
		
		String value =  null;
		try {
			WebElement validation = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[3]/div/div/p"));
			value = validation.getText();
			System.out.println(" - " + value);
		} catch (Exception e) {
			Assert.assertEquals(value, "This field is required.");
		}
	}
	
	//===== IC =====
	@When("The NRIC textbox should throw validation error")
	public void theNRICTextboxShouldThrowValidationError() {
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[4]/div/div/div/input")).sendKeys(Keys.chord(Keys.ENTER));
		
		allureScreenshot();
		
		try {
			WebElement validation = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[4]/div/div/p"));
			String value = validation.getText();
			System.out.println(" - " + value);
		} catch (Exception e) {
			Assert.fail("System allows user to enter NRIC lesser than 12 digits");
		}
	}
	@When("The NRIC textbox should not display the full value")
	public void theNRICTextboxShouldNotDisplayTheFullValue() {
		WebElement inputField = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[4]/div/div/div/input"));
		
		String fieldText = inputField.getAttribute("value");
		
		allureScreenshot();
		
		if(!fieldText.matches("^[0-9]*$")) {
			Assert.fail("NRIC Input field should only contains numbers.");
		} else {
			System.out.println(" - Value is inserted");
		}
	}
	@Then("The NRIC textbox should display the full value")
	public void theNRICTextboxShouldDisplayTheFullValue() {
		WebElement inputField = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[4]/div/div/div/input"));
		
		String fieldText = inputField.getAttribute("value");
		
		allureScreenshot();
		
		if(fieldText.isEmpty()) {
			Assert.fail("System does not allow the user to insert value");
		} else {	
			System.out.println(" - Yes");			
		}	
	}
	
	//===== Passport =====
	@When("The Passport textbox should not display the full value")
	public void thePassportTextboxShouldNotDisplayTheFullValue() {
		WebElement inputField = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[4]/div/div/div/input"));
		
		String fieldText = inputField.getAttribute("value");
		
		allureScreenshot();
		
		if(!fieldText.matches("^[a-zA-Z0-9]*$")) {
			Assert.fail("Passport Input field should only contains alphabets and numbers.");
		} else {
			System.out.println(" - Value is inserted");
		}
	}
	@Then("The Passport textbox should display the full value")
	public void thePassportTextboxShouldDisplayTheFullValue() {
		WebElement inputField = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[4]/div/div/div/input"));
		
		String fieldText = inputField.getAttribute("value");
		
		allureScreenshot();
		
		if(fieldText.isEmpty()) {
			Assert.fail("System does not allow the user to insert value");
		} else {	
			System.out.println(" - Yes");			
		}
	}
	@When("The Passport textbox should throw validation error")
	public void thePassportTextboxShouldThrowValidationError() {
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[4]/div/div/div/input")).sendKeys(Keys.chord(Keys.ENTER));
		
		allureScreenshot();
		
		String value =  null;
		try {
			WebElement validation = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[4]/div/div/p"));
			value = validation.getText();
			System.out.println(" - " + value);
		} catch (Exception e) {
			Assert.assertEquals(value, "This field is required.");
		}
	}
	
	//===== Contact Number =====
	@Then("The Contact Number textbox should display the full value")
	public void theContactNumberTextboxShouldDisplayTheFullValue() {
		WebElement inputField = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[5]/div/div/div/input"));
		
		String fieldText = inputField.getAttribute("value");
		
		allureScreenshot();
		
		if(fieldText.isEmpty()) {
			Assert.fail("System does not allow the user to insert value");
		} else {	
			System.out.println(" - Yes");			
		}
	}
	@When("The Contact Number textbox should not display the value")
	public void theContactNumberTextboxShouldNotDisplayTheValue() {
		WebElement inputField = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[5]/div/div/div/input"));
		
		String fieldText = inputField.getAttribute("value");
		
		allureScreenshot();
		
		if(!fieldText.isEmpty()) {
			Assert.fail("System allows user to add alphabets/ symbols");
		} else {
			System.out.println(" - Value is not inserted");
		}	
	}	
	@When("The Contact Number textbox should not display the full value")
	public void theContactNumberTextboxShouldNotDisplayTheFullValue() {
		WebElement inputField = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[5]/div/div/div/input"));
		
		String fieldText = inputField.getAttribute("value");
		
		allureScreenshot();
		
		if(!fieldText.matches("^[0-9]*$")) {
			Assert.fail("Contact Number Input field should only contains numbers.");
		} else {
			System.out.println(" - Value is inserted");
		}
	}
	@When("The Contact Number textbox should throw validation error")
	public void theContactNumberTextboxShouldThrowValidationError() {
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[5]/div/div/div/input")).sendKeys(Keys.chord(Keys.ENTER));
		
		allureScreenshot();
		
		String value =  null;
		try {
			WebElement validation = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[5]/div/div/p"));
			value = validation.getText();
			System.out.println(" - " + value);
			
		} catch (Exception e) {
			Assert.assertEquals(value, "This field must be 8-12 digits only*.");
		}
	}

	//===== Email =====	
	@When("The Email textbox should throw validation error")
	public void theEmailTextboxShouldThrowValidationError() {
	driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[6]/div/div/div/input")).sendKeys(Keys.chord(Keys.ENTER));
		
		allureScreenshot();
		
		String value =  null;
		try {
			WebElement validation = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[6]/div/div/p"));
			value = validation.getText();
			System.out.println(" - " + value);
			
		} catch (Exception e) {
			Assert.fail("System allows user to add email address without validation");
		}
	}
	@Then("The Email textbox should display the full value")
	public void theEmailTextboxShouldDisplayTheFullValue() {
		WebElement inputField = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[6]/div/div/div/input"));
		
		String fieldText = inputField.getAttribute("value");
		
		allureScreenshot();
		
		if(fieldText.isEmpty()) {
			Assert.fail("System does not allow the user to insert value");
		} else {	
			System.out.println(" - Yes");			
		}
	}
	
	//===== Bank =====	
	@When("User skips Bank Name")
	public void userSkipsBankName() {
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[8]/div/div/div/input")).sendKeys(Keys.chord(Keys.ENTER));
	}
	@When("The Bank Name dropdown list should throw validation error")
	public void theBankNameDropdownListShouldThrowValidationError() {		
		allureScreenshot();
		
		String value =  null;
		try {
			WebElement validation = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[7]/div/p"));
			value = validation.getText();
			System.out.println(" - " + value);
			
		} catch (Exception e) {
			Assert.fail("System allows user to add Bank Name without value");
		}
	}
	@When("The Bank Account Number should throw validation error")
	public void theBankAccountNumberShouldThrowValidationError() {
	driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[8]/div/div/div/input")).sendKeys(Keys.chord(Keys.ENTER));
		
		allureScreenshot();
		
		String value =  null;
		try {
			WebElement validation = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[8]/div/div/p"));
			value = validation.getText();
			System.out.println(" - " + value);
			
		} catch (Exception e) {
			Assert.assertEquals( value , "This field is required.");
		}
	}
	@When("The Account Number textbox should not display the full value")
	public void heAccountNumberTextboxShouldNotDisplayTheFullValue() {
		WebElement inputField = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[8]/div/div/div/input"));
		
		String fieldText = inputField.getAttribute("value");
		
		allureScreenshot();
		
		if(!fieldText.matches("^[0-9]*$")) {
			Assert.fail("Account Number Input field should only contains numbers.");
		} else {
			System.out.println(" - Value is inserted");
		}
	}
	@Then("The Account Number textbox should display the full value")
	public void theAccountNumberTextboxShouldDisplayTheFullValue() {
		WebElement inputField = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[8]/div/div/div/input"));
		
		String fieldText = inputField.getAttribute("value");
		
		allureScreenshot();
		
		if(fieldText.isEmpty()) {
			Assert.fail("System does not allow the user to insert value");
		} else {	
			System.out.println(" - Yes");			
		}
	}	
	
	//===== Address =====
		@When("The Line1 textbox should throw validation error")
	public void theLine1TextboxShouldThrowValidationError() {
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[9]/div/div/div/input")).sendKeys(Keys.chord(Keys.ENTER));
			
			allureScreenshot();
			
			String value =  null;
			try {
				WebElement validation = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[9]/div/div/p"));
				value = validation.getText();
				System.out.println(" - " + value);
				
			} catch (Exception e) {
				Assert.assertEquals( value , "This field is required.");
			}
	}
	@When("The Line2 textbox should throw validation error")
	public void theLine2TextboxShouldThrowValidationError() {
	driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[10]/div/div/div/input")).sendKeys(Keys.chord(Keys.ENTER));
		
		allureScreenshot();
		
		String value =  null;
		try {
			WebElement validation = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[10]/div/div/p"));
			value = validation.getText();
			System.out.println(" - " + value);
			
		} catch (Exception e) {
			Assert.assertEquals( value , "This field is required.");
		}
	}
	@When("User skips Postcode")
	public void userSkipsPostcode() {
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[10]/div/div/div/input")).sendKeys(Keys.chord(Keys.ENTER));
	}
	@When("The Postcode dropdown list should throw validation error")
	public void thePostcodeDropdownListShouldThrowValidationError() {
		allureScreenshot();
		
		String value =  null;
		try {
			WebElement validation = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[11]/div/p"));
			value = validation.getText();
			System.out.println(" - " + value);
			
		} catch (Exception e) {
			Assert.assertEquals( value , "This field is required min 5 digits.");
		}
	}

	//===== CHECKBOX =====
	@When("The Error pop up message should be displayed")
	public void theErrorPopUpMessageShouldBeDisplayed() {
		WebElement header = null;

		try {
			header = driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/h1"));
			String getTitle = header.getText();

			if (getTitle.equals("Error")) {
				System.out.println(" - The Disclaimer is not checked");
				byte[] screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				Allure.addAttachment("Step", "image/png", new ByteArrayInputStream(screenshot1), "png");
			} else {
				Assert.assertEquals(getTitle, "Error");
				byte[] screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				Allure.addAttachment("Step ERROR", "image/png", new ByteArrayInputStream(screenshot1), "png");
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(header, "The Error Alert message is not presented");
			System.out.println(" - The Error Alert message is not present");
		}
	}
		
	//===== Company Name =====
	@Then("The Company textbox should display the value")
	public void theCompanyTextboxTextboxShouldDisplayTheValue() {
		WebElement inputField = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[2]/div/div/div/input"));
		
		String fieldText = inputField.getAttribute("value");
		
		allureScreenshot();
		
		if(fieldText.isEmpty()) {
			Assert.fail("System does not allow the user to insert value");
		} else {	
			System.out.println(" - Yes");			
		}
	}
	@When("The Company Name textbox should not display the value")
	public void theCompanyNameTextboxShouldNotDisplayTheValue() {
		WebElement inputField = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[2]/div/div/div/input"));
		
		String fieldText = inputField.getAttribute("value");
		
		allureScreenshot();
		
		if(!fieldText.isEmpty()) {
			Assert.fail("System allows user to add unaccepted symbols");
		} else {
			System.out.println(" - Value is not inserted");
		}	
	}
	@When("The Company Name textbox should not display the full value")
	public void theCompanyNameTextboxShouldNotDisplayTheFullValue() {
		WebElement inputField = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[2]/div/div/div/input"));
		
		String fieldText = inputField.getAttribute("value");
		
		allureScreenshot();
		
		if(!fieldText.matches("^[a-zA-Z0-9()@&-]*$")) {
			Assert.fail("Name Input field should only accept alphanumberic and certain symbol characters only.");
		} else {
			System.out.println(" - Value is inserted");
		}
	}
	@When("The Company Name textbox should throw validation error")
	public void theCompanyNameTextboxShouldThrowValidationError() {
	driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[2]/div/div/div/input")).sendKeys(Keys.chord(Keys.ENTER));
		
		allureScreenshot();
		
		String value =  null;
		try {
			WebElement validation = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[2]/div/div/p"));
			value = validation.getText();
			System.out.println(" - " + value);
			
		} catch (Exception e) {
			Assert.assertEquals( value , "This field is required.");
		}
	}
	
	//===== Company RegNo =====
	@Then("The Business Registration No textbox should display the value")
	public void theBusinessRegistrationNoTextboxShouldDisplayTheValue() {
		WebElement inputField = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[3]/div/div/div/input"));
		
		String fieldText = inputField.getAttribute("value");
		
		allureScreenshot();
		
		if(fieldText.isEmpty()) {
			Assert.fail("System does not allow the user to insert value");
		} else {	
			System.out.println(" - Yes");			
		}
	}
	@When("The Business Registration No textbox should not display the value")
	public void theBusinessRegistrationNoTextboxShouldNotDisplayTheValue() {
		WebElement inputField = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[3]/div/div/div/input"));
		
		String fieldText = inputField.getAttribute("value");
		
		allureScreenshot();
		
		if(!fieldText.isEmpty()) {
			Assert.fail("System allows user to add unaccepted symbols");
		} else {
			System.out.println(" - Value is not inserted");
		}
	}
	@When("The Business Registration No textbox should not display the full value")
	public void theBusinessRegistrationNoTextboxShouldNotDisplayTheFullValue() {
		WebElement inputField = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[3]/div/div/div/input"));
		
		String fieldText = inputField.getAttribute("value");
		
		allureScreenshot();
		
		if(!fieldText.matches("^[a-zA-Z0-9-]*$")) {
			Assert.fail("Business Registration No Input field should only accept alphanumberic and '-' symbol characters only.");
		} else {
			System.out.println(" - Value is inserted");
		}
	}
	@When("The Business Registration No textbox should throw validation error")
	public void theBusinessRegistrationNoTextboxShouldThrowValidationError() {
	driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[3]/div/div/div/input")).sendKeys(Keys.chord(Keys.ENTER));
		
		allureScreenshot();
		
		String value =  null;
		try {
			WebElement validation = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[3]/div/div/p"));
			value = validation.getText();
			System.out.println(" - " + value);			
		} catch (Exception e) {
			Assert.assertEquals( value , "This field is required min 3 digits.");
		}
	}
	
	//===== Company ContactNo =====	
	@Then("The Company Contact Number textbox should display the full value")
	public void theCompanyContactNumberTextboxShouldDisplayTheFullValue() {
		WebElement inputField = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[4]/div/div/div/input"));
		
		String fieldText = inputField.getAttribute("value");
		
		allureScreenshot();
		
		if(fieldText.isEmpty()) {
			Assert.fail("System does not allow the user to insert value");
		} else {	
			System.out.println(" - Yes");			
		}
	}
	@When("The Company Contact Number textbox should not display the value")
	public void theCompanyContactNumberTextboxShouldNotDisplayTheValue() {
		WebElement inputField = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[4]/div/div/div/input"));
		
		String fieldText = inputField.getAttribute("value");
		
		allureScreenshot();
		
		if(!fieldText.isEmpty()) {
			Assert.fail("System allows user to add alphabets/ symbols");
		} else {
			System.out.println(" - Value is not inserted");
		}	
	}
	@When("The Company Contact Number textbox should not display the full value")
	public void theCompanyContactNumberTextboxShouldNotDisplayTheFullValue() {
		WebElement inputField = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[4]/div/div/div/input"));
		
		String fieldText = inputField.getAttribute("value");
		
		allureScreenshot();
		
		if(!fieldText.matches("^[0-9]*$")) {
			Assert.fail("Contact Number Input field should only contains numbers.");
		} else {
			System.out.println(" - Value is inserted");
		}
	}
	@When("The Company Contact Number textbox should throw validation error")
	public void theCompanyContactNumberTextboxShouldThrowValidationError() {
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[4]/div/div/div/input")).sendKeys(Keys.chord(Keys.ENTER));
		
		allureScreenshot();
		
		String value =  null;
		try {
			WebElement validation = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[4]/div/div/p"));
			value = validation.getText();
			System.out.println(" - " + value);		
		} catch (Exception e) {
			Assert.assertEquals(value, "This field must be 8-12 digits only*.");
		}
	}
	@Then("The Company Contact Number textbox should throw null validation error")
	public void theCompanyContactNumberTextboxShouldThrowNullValidationError() {
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[4]/div/div/div/input")).sendKeys(Keys.chord(Keys.ENTER));
		
		allureScreenshot();
		
		String value =  null;
		try {
			WebElement validation = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[4]/div/div/p"));
			value = validation.getText();
			System.out.println(" - " + value);		
		} catch (Exception e) {
			Assert.assertEquals(value, "This field is required.");
		}
	}
	
	//===== Company Email =====
	@Then("The Company Email textbox should display the full value")
	public void theCompanyEmailTextboxShouldDisplayTheFullValue() {
		WebElement inputField = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[5]/div/div/div/input"));
		
		String fieldText = inputField.getAttribute("value");
		
		allureScreenshot();
		
		if(fieldText.isEmpty()) {
			Assert.fail("System does not allow the user to insert value");
		} else {	
			System.out.println(" - Yes");			
		}
	}	
	@When("The Company Email textbox should throw validation error")
	public void theCompanyEmailTextboxShouldThrowValidationError() {
	driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[5]/div/div/div/input")).sendKeys(Keys.chord(Keys.ENTER));
		
		allureScreenshot();
		
		String value =  null;
		try {
			WebElement validation = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[5]/div/div/p"));
			value = validation.getText();
			System.out.println(" - " + value);
			
		} catch (Exception e) {
			Assert.fail("System supposed to throw - '" + value + "' error" );
		}
	}
	
	//===== Company Nature of Business =====
	@When("User skips Nature of Business")
	public void userSkipsNatureOfBusiness() {
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[5]/div/div/div/input")).sendKeys(Keys.chord(Keys.ENTER));
	}
	@When("The  Nature of Business dropdown list should throw validation error")
	public void theNatureOfBusinessDropdownListShouldThrowValidationError() {
		allureScreenshot();
		
		String value =  null;
		try {
			WebElement validation = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[6]/div/p"));
			value = validation.getText();
			System.out.println(" - " + value);
			
		} catch (Exception e) {
			Assert.assertEquals( value , "This field is required.");
		}
	}
	
	
	
	//===== UPLOAD DOCUMENT  =====
	@When("User uploads NRIC document more than 15MB")
	public void userUploadsNRICDocumentMoreThan15MB() throws InterruptedException {
		WebElement file = driver.findElement(By.id("identity"));
		String filePath = "C:\\Users\\priya\\Downloads\\sample video.mkv"; // Replace with the actual file path
		file.sendKeys(filePath);
		Thread.sleep(500);
		allureScreenshot();
	}
	@When("User Uploads Bank Statement document more than 15MB")
	public void userUploadsBankStatementDocumentMoreThan15MB() throws InterruptedException {
		WebElement file = driver.findElement(By.id("bankStatement"));
		String filePath = "C:\\Users\\priya\\Downloads\\sample video.mkv"; // Replace with the actual file path
		file.sendKeys(filePath);
		Thread.sleep(500);
		allureScreenshot();
		scrollDown();
	}
	
	@When("User uploads Passport document more than 15MB")
	public void userUploadsPassportDocumentMoreThan15MB() throws InterruptedException {
		WebElement file = driver.findElement(By.id("identity"));
		String filePath = "C:\\Users\\priya\\Downloads\\sample video.mkv"; // Replace with the actual file path
		file.sendKeys(filePath);
		Thread.sleep(500);
		allureScreenshot();
		scrollDown();
	}
	@When("User uploads VISA document more than 15MB")
	public void userUploadsVISADocumentMoreThan15MB() throws InterruptedException {
		WebElement file = driver.findElement(By.id("visa"));
		String filePath = "C:\\Users\\priya\\Downloads\\sample video.mkv"; // Replace with the actual file path
		file.sendKeys(filePath);
		Thread.sleep(500);
		allureScreenshot();
		scrollDown();
	}
	
	@When("User uploads Form 24 document more than 15MB")
	public void userUploadsFormDocumentMoreThan15MB() throws InterruptedException {
		WebElement file = driver.findElement(By.id("form24"));
		String filePath = "C:\\Users\\priya\\Downloads\\sample video.mkv"; // Replace with the actual file path
		file.sendKeys(filePath);
		Thread.sleep(500);
		allureScreenshot();
		scrollDown();
	}
	@When("User uploads Authorization Letter document more than 15MB")
	public void userUploadsAuthorizationLetterDocumentMoreThan15MB() throws InterruptedException {
		WebElement file = driver.findElement(By.id("authorisationLetter"));
		String filePath = "C:\\Users\\priya\\Downloads\\sample video.mkv"; // Replace with the actual file path
		file.sendKeys(filePath);
		Thread.sleep(500);
		allureScreenshot();
		scrollDown();
	}
	
	//===== - Local =====
	@When("Size Validation error for NRIC should be thrown")
	public void sizeValidationErrorForNRICShouldBeThrown() {
		allureScreenshot();
		
		String value =  null;
		try {
			WebElement validation = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[1]/label/div[2]/p/span[2]"));
			value = validation.getText();
			System.out.println(" - " + value);		
		} catch (Exception e) {
			Assert.assertEquals(value, "File Size is too large");
		}
	}
	@When("Size Validation error for local Individual Bank statement should be thrown")
	public void sizeValidationErrorForLocalIndividualBankStatementShouldBeThrown() {
		allureScreenshot();
		
		String value =  null;
		try {
			WebElement validation = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[2]/label/div[2]/p/span[2]"));
			value = validation.getText();
			System.out.println(" - " + value);		
		} catch (Exception e) {
			Assert.assertEquals(value, "File Size is too large");
		}
	}
	@Then("Null Validation error for NRIC should be thrown")
	public void nullValidationErrorForNRICShouldBeThrown() {
		allureScreenshot();
		
		String value =  null;
		try {
			WebElement validation = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/p[1]"));
			value = validation.getText();
			System.out.println(" - " + value);		
		} catch (Exception e) {
			Assert.assertEquals(value, "This field is required.");
		}
	}
	@When("Null Validation error for local Individual Bank statement should be thrown")
	public void nullValidationErrorForLocalIndividualBankStatementShouldBeThrown() {
		allureScreenshot();
		
		String value =  null;

		try {
			WebElement validation1 = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/p[2]"));
			value = validation1.getText();
			System.out.println(" - " + value);		
		} catch (Exception e) {
		    try {
		        WebElement validation2 = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/p"));
		        value = validation2.getText();
		        System.out.println(" - " + value);
		    } catch (NoSuchElementException e2) {
		    	Assert.assertEquals(value, "This field is required.");
		    }	
		}
	}
		
	//===== - Foreigner =====
	@When("Size Validation error for Passport should be thrown")
	public void sizeValidationErrorForPassportShouldBeThrown() {
		allureScreenshot();
		
		String value =  null;
		try {
			WebElement validation = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[1]/label/div[2]/p/span[2]"));
			value = validation.getText();
			System.out.println(" - " + value);		
		} catch (Exception e) {
			Assert.assertEquals(value, "File Size is too large");
		}
	}
	@When("Size Validation error for VISA should be thrown")
	public void sizeValidationErrorForVISAShouldBeThrown() {
		allureScreenshot();
		
		String value =  null;
		try {
			WebElement validation = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[2]/label/div[2]/p/span[2]"));
			value = validation.getText();
			System.out.println(" - " + value);		
		} catch (Exception e) {
			Assert.assertEquals(value, "File Size is too large");
		}
	}
	@When("Size Validation error for Foreigner Bank statement should be thrown")
	public void sizeValidationErrorForForeignerBankStatementShouldBeThrown() {
		allureScreenshot();
		
		String value =  null;
		try {
			WebElement validation = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[3]/label/div[2]/p/span[2]"));
			value = validation.getText();
			System.out.println(" - " + value);		
		} catch (Exception e) {
			Assert.assertEquals(value, "File Size is too large");
		}
	}
	@When("Null Validation error for Passport should be thrown")
	public void nullValidationErrorForPassportShouldBeThrown() {
		allureScreenshot();
		
		String value =  null;
		try {
			WebElement validation = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/p[1]"));
			value = validation.getText();
			System.out.println(" - " + value);		
		} catch (Exception e) {
			Assert.assertEquals(value, "This field is required.");
		} 
	}
	@When("Null Validation error for VISA should be thrown")
	public void nullValidationErrorForVISAShouldBeThrown() {
		allureScreenshot();
		
		String value =  null;

		try {
			WebElement validation1 = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/p[2]"));
			value = validation1.getText();
			System.out.println(" - " + value);		
		} catch (Exception e) {
		    try {
		        WebElement validation2 = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/p"));
		        value = validation2.getText();
		        System.out.println(" - " + value);
		    } catch (NoSuchElementException e2) {
		    	Assert.assertEquals(value, "This field is required.");
		    }	
		} 
	}
	@When("Null Validation error for Foreigner Bank statement should be thrown")
	public void nullValidationErrorForForeignerBankStatementShouldBeThrown() {
		allureScreenshot();
		
		String value =  null;
		try {
			WebElement validation = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/p[3]"));
			value = validation.getText();
			System.out.println(" - " + value);		
		} catch (Exception e) {
		    try {
		        WebElement validation2 = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/p[2]"));
		        value = validation2.getText();
		        System.out.println(" - " + value);
		    } catch (NoSuchElementException e2) {
			    try {
			        WebElement validation2 = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/p"));
			        value = validation2.getText();
			        System.out.println(" - " + value);
			    } catch (NoSuchElementException e3) {
			    	Assert.assertEquals(value, "This field is required.");
			    }
		    }	
		} 
	}
	
	//===== - Company =====
	@When("Size Validation error for Form 24 should be thrown")
	public void sizeValidationErrorForFormShouldBeThrown() {
		allureScreenshot();
		
		String value =  null;
		try {
			WebElement validation = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[1]/label/div[2]/p/span[2]"));
			value = validation.getText();
			System.out.println(" - " + value);		
		} catch (Exception e) {
			Assert.assertEquals(value, "File Size is too large");
		}
	}
	@When("Size Validation error for Authorization Letter should be thrown")
	public void sizeValidationErrorForAuthorizationLetterShouldBeThrown() {
		allureScreenshot();
		
		String value =  null;
		try {
			WebElement validation = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[2]/label/div[2]/p/span[2]"));
			value = validation.getText();
			System.out.println(" - " + value);		
		} catch (Exception e) {
			Assert.assertEquals(value, "File Size is too large");
		}
	}
	@When("Size Validation error for Company Bank statement should be thrown")
	public void sizeValidationErrorForCompanyBankStatementShouldBeThrown() {
		allureScreenshot();
		
		String value =  null;
		try {
			WebElement validation = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[3]/label/div[2]/p/span[2]"));
			value = validation.getText();
			System.out.println(" - " + value);		
		} catch (Exception e) {
			Assert.assertEquals(value, "File Size is too large");
		}
	}
	@When("Null Validation error for Form 24 should be thrown")
	public void nullValidationErrorForFormShouldBeThrown() {
		allureScreenshot();
		
		String value =  null;
		try {
			WebElement validation = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/p[1]"));
			value = validation.getText();
			System.out.println(" - " + value);		
		} catch (Exception e) {
			Assert.assertEquals(value, "This field is required.");
		} 
	}
	@When("Null Validation error for Authorization Letter should be thrown")
	public void nullValidationErrorForAuthorizationLetterShouldBeThrown() {
		allureScreenshot();
		
		String value =  null;

		try {
			WebElement validation1 = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/p[2]"));
			value = validation1.getText();
			System.out.println(" - " + value);		
		} catch (Exception e) {
		    try {
		        WebElement validation2 = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/p"));
		        value = validation2.getText();
		        System.out.println(" - " + value);
		    } catch (NoSuchElementException e2) {
		    	Assert.assertEquals(value, "This field is required.");
		    }	
		} 
	}
	@When("Null Validation error for Company Bank statement should be thrown")
	public void nullValidationErrorForCompanyBankStatementShouldBeThrown() {
		allureScreenshot();
		
		String value =  null;
		try {
			WebElement validation = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/p[3]"));
			value = validation.getText();
			System.out.println(" - " + value);		
		} catch (Exception e) {
		    try {
		        WebElement validation2 = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/p[2]"));
		        value = validation2.getText();
		        System.out.println(" - " + value);
		    } catch (NoSuchElementException e2) {
			    try {
			        WebElement validation2 = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/p"));
			        value = validation2.getText();
			        System.out.println(" - " + value);
			    } catch (NoSuchElementException e3) {
			    	Assert.assertEquals(value, "This field is required.");
			    }
		    }	
		} 
	}
	
	
	
	
}
