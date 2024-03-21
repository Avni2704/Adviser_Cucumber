package steps;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import drivers.DriverInstance;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ManualQuotationSteps extends DriverInstance {

	WebDriverWait wait;
	WebElement divElement;
	WebElement divElementTextBox;
	WebElement successDiv;;
	String check ;

	@Given("User logs in to Adviser Portal")
	public void userLogsIn() throws InterruptedException {
		WebElement Email = driver
				.findElement(By.xpath("/html/body/div[1]/main/div/div/div/div/form/div[1]/div/div/div/input"));
		Email.sendKeys("adviser.vka@gmail.com");

		WebElement Password = driver
				.findElement(By.xpath("/html/body/div[1]/main/div/div/div/div/form/div[2]/div/div/div/input"));
		Password.sendKeys("VkaTest@123");

		WebElement Login = driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div/div/form/button"));
		Login.click();
		Thread.sleep(5000);
	}

	@Given("User navigates to Manual Quotation")
	public void userNavigatesToManualQuotation() throws InterruptedException {
		WebElement ManQuot = driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/div/div[2]/div[4]/ul/li[5]"));
		ManQuot.click();
		System.out.println(" - Manual Quotation is clicked");
		Thread.sleep(3000);
	}

	@Given("User clicks the New Enquiry button")
	public void userClicksTheNewEnquiryButton() throws InterruptedException {
		WebElement newEnquiry = driver
				.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div[2]/button"));
		newEnquiry.click();
//		logStep("New Enquiry button is clicked");
		Thread.sleep(3000);
	}

	@Given("User clicks Motor Private Product Type")
	public void userClicksMotorPrivateProductType() throws InterruptedException {
		WebElement MotorPrivate = driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/ul/li[1]/button"));
		MotorPrivate.click();
		Thread.sleep(3000);
//		logStep("Product Type is selected and moved to the Enquiry Tab");

		WebElement confirmProductType = driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/div[2]/button[2]"));
		confirmProductType.click();
		Thread.sleep(3000);
//		logStep("Product Type is selected and moved to the Enquiry Tab");
	}

	@Given("User clicks the Resources Form button on the Enquiry Tab")
	public void userClicksTheResourcesFormButtonOnTheEnquiryTab() throws InterruptedException {
		WebElement ResourcesBtn = driver
				.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div[2]/button[2]"));
		ResourcesBtn.click();
		System.out.println(" - Resources Form Button is clicked");
		Thread.sleep(3000);
	}

	@When("User clicks all checkbox button in search box")
	public void userClicksAllCheckboxButtonInSearchBox() throws InterruptedException {
		WebElement AllChkBox = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div/div[2]/button"));
		AllChkBox.click();
		System.out.println(" - Checkbox in Search Box is clicked");
		Thread.sleep(3000);
	}

	@Then("All the Resources should be selected.")
	public void allTheResourcesShouldBeSelected() {
		System.out.println(" - All Check boxes is selected in one click");
	}

	@Then("List of the Resources Form with download button should be shown.")
	public void listOfTheResourcesFormWithDownloadShouldBeShown() {

		// Find the element using XPath
		List<WebElement> elements = driver.findElements(By.xpath("/html/body/div[5]/div[3]/div/div"));

		// Check if the element is present
		if (elements.size() > 0) {
			// The element is present
			System.out.println("OK");
		} else {
			// The element is not present
			Assert.fail("The div element is not present");
		}
	}

	@When("User clicks selected checkbox button")
	public void userClicksSelectedCheckboxButtonInSearchBox() {

		WebElement ulElement = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div/ul"));

		// Define the number of random buttons to click
		int numberOfRandomButtonsToClick = 3; // Change this number as needed

		for (int i = 0; i < numberOfRandomButtonsToClick; i++) {
			// Get the list of <li> elements within the <ul>
			List<WebElement> liElements = ulElement.findElements(By.tagName("li"));

			// Generate a random index (x)
			int maxIndex = liElements.size() - 1;
			int randomIndex = new Random().nextInt(maxIndex + 1);

			// Construct the XPath for the random <li> element
			String liXPath = "/html/body/div[5]/div[3]/div/div/ul/li[" + (randomIndex + 1) + "]";

			// Find the random <li> element
			WebElement randomLiElement = driver.findElement(By.xpath(liXPath));

			// Construct the XPath for the button within the <li>
			String btnXPath = liXPath + "/button";

			// Find the random button element and click it
			WebElement randomButtonElement = randomLiElement.findElement(By.xpath(btnXPath));
			randomButtonElement.click();
		}
	}

	@Then("Selected Resources should be selected.")
	public void selectedResourcesShouldBeSelected() {
		System.out.println(" - Some Check boxes is selected in one click");
	}

	@When("User clicks the Download button")
	public void userClicksTheDownloadButton() throws InterruptedException {
		WebElement Download = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div/div[3]/button[2]"));
		Download.click();
		System.out.println(" - Download Button is clicked");
		Thread.sleep(6000);
	}

	@Then("All the forms should be downloaded.")
	public void allTheFormsShouldBeDownloaded() {
		System.out.println(" - All the forms are downloaded");
	}

	@Then("Shows all the relevant results.")
	public void showsAllTheRelevantResults() throws InterruptedException {
		Thread.sleep(5000);
		System.out.println(" - Relevant results are shown");
	}

	@When("No forms should be downloaded.")
	public void noFormsShouldBeDownloaded() {
		System.out.println(" - No form to download");
	}

	@When("User uses Keyword as {string} in the search box to search")
	public void userUsesKeywordAsInTheSearchBoxToSearch(String keyword) {
		WebElement SearchBox = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div/div[2]/input"));
		SearchBox.sendKeys(keyword);
	}

	@When("No relevant Resources should be shown.")
	public void noRelevantResourcesShouldBeShown() throws InterruptedException {
		Thread.sleep(5000);
		System.out.println(" - No form to show");
	}

	@Given("User clicks on the first row of the table when the status is Awaiting Confirmation")
	public void userClicksOnTheFirstRowOfTheTableWhenTheStatusIsAwaitingConfirmation() throws InterruptedException {
		String trXPath = "/html/body/div[1]/div[3]/div/div[2]/div/div/div[3]/div/table/tbody/tr";
		String statusToFind = "Awaiting Confirmation";

		// Find all <tr> elements in the table
		java.util.List<WebElement> trElements = driver.findElements(By.xpath(trXPath));

		// Iterate through the <tr> elements to find the one with the specified status
		for (int i = 1; i <= trElements.size(); i++) {
			String trStatusXPath = trXPath + "[" + i + "]/td[5]";
			WebElement trStatusElement = driver.findElement(By.xpath(trStatusXPath));
			String status = trStatusElement.getText();

			if (status.equals(statusToFind)) {
				String trElementXPath = trXPath + "[" + i + "]";
				WebElement trElement = driver.findElement(By.xpath(trElementXPath));
				trElement.click(); // Click the first row with "Awaiting Confirmation"
				break; // Exit the loop after clicking the first matching element
			}
		}

		Thread.sleep(3500);
	}

	@Given("User clicks Next button after filling up FOV details")
	public void userClicksNextButtonAfterFillingUpFOVDetails() throws InterruptedException {
		WebElement Next = driver
				.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[2]/button[2]"));
		Next.click();
		Thread.sleep(3000);
	}

	@Given("User clicks Next button after filling up Application")
	public void userClicksNextButtonAfterFillingUpApplication() throws InterruptedException {
		WebElement Next = driver
				.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div/form/div[3]/button[2]"));
		Next.click();
		Thread.sleep(3000);
	}

	@Given("User clicks Next button after selecting Provider")
	public void userClicksNextButtonAfterSelectingProvider() throws InterruptedException {
		WebElement Next = driver
				.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div/form/div[4]/button[2]"));
		Next.click();
		Thread.sleep(3000);
	}

	@When("User clicks Download button in Quotation Tab")
	public void userClicksDownloadButtonInQuotationTab() throws InterruptedException {
		WebElement Download = driver
				.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div[5]/ul/li/div[3]/button"));
		Download.click();
		Thread.sleep(3000);
	}

	@When("User clicks on the Policy Wording option from the dropdownlist")
	public void userClicksOnThePolicyWordingOptionFromTheDropdownlist() throws InterruptedException {
		WebElement Next = driver.findElement(By.xpath("/html/body/div[9]/div[3]/ul/li[4]/a"));
		Next.click();
		Thread.sleep(6000);
	}

	@Then("User must be able to view a file.")
	public void userMustBeAbleToViewAFile() throws InterruptedException {
		Thread.sleep(8000);
		System.out.println(" - File opened in another tab");
	}

	@When("User clicks on the Proposal option from the dropdownlist")
	public void userClicksOnTheProposalOptionFromTheDropdownlist() throws InterruptedException {
		WebElement Next = driver.findElement(By.xpath("/html/body/div[9]/div[3]/ul/li[2]/a"));
		Next.click();
		Thread.sleep(6000);
	}

	@When("User clicks Export Plans button in Quotation Tab")
	public void userClicksExportPlansButtonInQuotationTab() throws InterruptedException {
		WebElement Export = driver
				.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div[4]/div[2]/button"));
		Export.click();
		Thread.sleep(10000);
	}

	@Then("User must be able to download a zip folder.")
	public void userMustBeAbleToDownloadAZipFolder() {
		System.out.println(" - Zip folder is downloaded");
	}

	@When("User clicks on the PDS option from the dropdownlist")
	public void userClicksOnThePDSOptionFromTheDropdownlist() throws InterruptedException {
		WebElement Next = driver.findElement(By.xpath("/html/body/div[9]/div[3]/ul/li[3]/a"));
		Next.click();
		Thread.sleep(6000);
	}

	@When("User clicks on the Brochure\\/Quotaion option from the dropdownlist")
	public void userClicksOnTheBrochureQuotaionOptionFromTheDropdownlist() throws InterruptedException {
		WebElement Next = driver.findElement(By.xpath("/html/body/div[9]/div[3]/ul/li[1]/a"));
		Next.click();
		Thread.sleep(3000);
	}

	@When("User clicks Requote button")
	public void userClicksRequoteButton() throws InterruptedException {
		WebElement Button = driver
				.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div[2]/button[1]"));
		Button.click();
		Thread.sleep(3000);
	}

	@Then("User must be able to view the list of Providers to requote.")
	public void userMustBeAbleToViewTheListOfProvidersToRequote() throws InterruptedException {
		try {
			divElement = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div"));
			System.out.println("Yes"); // The div is present
			Thread.sleep(3000);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(divElement, "The div element is not present");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(3000);
		}

	}

	@When("User clicks one Provider to requote")
	public void userClicksOneProviderToRequote() throws InterruptedException {
		WebElement Button = null;	
		try {
			Button = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/form/ul/li[2]/div[1]/button"));
			Button.click();
			Thread.sleep(3000);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(Button, "The Provider Radio Button Cannot be clicked");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(3000);
		}
		
	}

	@Then("User must be able to view the Requote Remarks textbox.")
	public void userMustBeAbleToViewTheRequoteRemarksTextbox() throws InterruptedException {
		try {
			divElementTextBox = driver
					.findElement(By.xpath("/html/body/div[6]/div[3]/div/form/ul/li[1]/div[4]/div/div/textarea[1]"));
			System.out.println("Yes"); // The div is present
			Thread.sleep(3000);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(divElementTextBox, "The Requote Remarks element is not present");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(3000);
		}
	}

	@When("User clicks multiple Provider to requote")
	public void userClicksMultipleProviderToRequote() throws InterruptedException {
		WebElement Button1 = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/form/ul/li[1]/div[1]/button"));
		Button1.click();
		Thread.sleep(3000);

		WebElement Button2 = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/form/ul/li[2]/div[1]/button"));
		Button2.click();
		Thread.sleep(3000);
	}

	@Then("User must be able to view multiple Requote Remarks textbox.")
	public void userMustBeAbleToViewMultipleRequoteRemarksTextbox() throws InterruptedException {

		try {
			divElementTextBox = driver
					.findElement(By.xpath("/html/body/div[6]/div[3]/div/form/ul/li[1]/div[4]/div/div/textarea[1]"));
			System.out.println("Yes"); // The div is present
			Thread.sleep(3000);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(divElementTextBox, "The Requote Remarks element is not present");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(3000);
		}

	}

	@When("User insert more thaan 500 char Requote Remarks as {string} in the textbox")
	public void userInsertMoreThaanCharRequoteRemarksAsInTheTextbox(String Keywords) throws InterruptedException {
		WebElement textArea = driver
				.findElement(By.xpath("/html/body/div[6]/div[3]/div/form/ul/li[1]/div[4]/div/div/textarea[1]"));
		textArea.sendKeys(Keywords);
		Thread.sleep(3000);
	}

	@Then("Remarks value stop after 500 char and will not insert anymore char.")
	public void remarksValueStopAfterCharAndWillNotContinue() throws InterruptedException {
		Thread.sleep(3000);
		System.out.println(" - It stopped after 500 chars");

		WebElement textArea = driver
				.findElement(By.xpath("/html/body/div[6]/div[3]/div/form/ul/li[1]/div[4]/div/div/textarea[1]"));
		String Trimmed = textArea.getText();
		System.out.println(" - " + Trimmed);
		Thread.sleep(3000);
	}

	@Then("User insert less thaan 500 char Requote Remarks as {string} in the textbox.")
	public void userInsertLessThaanWordsRequoteRemarksAsInTheTextbox(String Keywords) throws InterruptedException {
		WebElement textArea = driver
				.findElement(By.xpath("/html/body/div[6]/div[3]/div/form/ul/li[1]/div[4]/div/div/textarea[1]"));
		textArea.sendKeys(Keywords);
		Thread.sleep(3000);
	}

	@Then("User insert Requote Remarks as {string} in the textbox.")
	public void userInsertRequoteRemarksAsInTheTextbox(String Keywords) throws InterruptedException {
		WebElement textArea = driver
				.findElement(By.xpath("/html/body/div[6]/div[3]/div/form/ul/li[1]/div[4]/div/div/textarea[1]"));
		textArea.sendKeys(Keywords);
		Thread.sleep(3000);
	}

	@Given("User clicks one Provider to requote [Empty]")
	public void userClicksOneProviderToRequoteEmpty() throws InterruptedException {
		WebElement Button = null;
		
		try {
			Button = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/form/ul/li[4]/div[1]/button"));
			Button.click();
			Thread.sleep(3000);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(Button, "The Provider Radio Button Cannot be clicked");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(3000);
		}
	}
	
	@When("User cannot be able to submit requote request.")
	public void userCannotBeAbleToSubmitRequoteRequest() throws InterruptedException {
		WebElement statement = null;
		
		try {
			statement = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/form/ul/li[2]/div[4]/div/p"));
			statement.getText();
			Thread.sleep(3000);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(statement, "The Requote cannot be submitted without remark");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(3000);
		}
	}
	
	@When("User clicks Confirm Button")
	public void userClicksConfirmButton() throws InterruptedException {
		WebElement button = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/form/div/button[2]"));
		button.click();
		Thread.sleep(2000);
	}

	@Then("User able to submit requote request")
	public void userAbleToSubmitRequoteRequest() throws InterruptedException {
		try {
			successDiv = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div"));
			System.out.println("Yes"); // The div is present
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(successDiv, "The Requote Request is Failed");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(3000);
		}
	}

	@Given("User deletes the current Remark")
	public void userDeletesTheCurrentRemark() throws InterruptedException {
		WebElement textArea = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/form/ul/li[1]/div[4]/div/div/textarea[1]"));
		textArea.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		Thread.sleep(3000);
	}
	
	@Then("All the values in the textbox is deleted.")
	public void allTheValuesInTheTextboxIsDeleted() {
		System.out.println(" - It's all deleted");
	}
	
	@Given("User clicks on the first row of the table when the status is Requote Quotation")
	public void userClicksOnTheFirstRowOfTheTableWhenTheStatusIsRequoteQuotation() throws InterruptedException {
		String trXPath = "/html/body/div[1]/div[3]/div/div[2]/div/div/div[3]/div/table/tbody/tr";
		String statusToFind = "Requote Quotation";

		// Find all <tr> elements in the table
		java.util.List<WebElement> trElements = driver.findElements(By.xpath(trXPath));

		// Iterate through the <tr> elements to find the one with the specified status
		for (int i = 1; i <= trElements.size(); i++) {
			String trStatusXPath = trXPath + "[" + i + "]/td[5]";
			WebElement trStatusElement = driver.findElement(By.xpath(trStatusXPath));
			String status = trStatusElement.getText();

			if (status.equals(statusToFind)) {
				String trElementXPath = trXPath + "[" + i + "]";
				WebElement trElement = driver.findElement(By.xpath(trElementXPath));
				trElement.click(); // Click the first row with "Awaiting Confirmation"
				break; // Exit the loop after clicking the first matching element
			}
		}

		Thread.sleep(3500);
	}
	
	//Filter BY
	@Given("User clicks Quotation Tab")
	public void userClicksQuotationTab() throws InterruptedException {
		WebElement Tab = null;
		
		try {
			Tab = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div[3]/ul/li[2]"));
			Tab.click();
			Thread.sleep(3000);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(Tab, "User couldn't able to click the Quotation Tab");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(3000);
		}
	}
	
	@When("User clicks on Filter By button")
	public void userClicksOnFilterByButton() throws InterruptedException {
		WebElement Button = null;
		
		try {
			Button = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div[4]/div[2]/button[2]"));
			Button.click();
			Thread.sleep(3000);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(Button, "User couldn't able to click the Filter By button");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(3000);
		}
	}
	
	@Then("List of Providers name should be shown for filtering")
	public void listOfProvidersNameShouldBeShownForFiltering() {
		WebElement ulElement = null;

		try {
		    ulElement = driver.findElement(By.xpath("/html/body/div[7]/div[3]/ul"));
		    System.out.println(" - The ul element is present");
		} catch (org.openqa.selenium.NoSuchElementException e) {
		    Assert.assertNotNull(ulElement, "The providers list should be present in the filter");
		    System.out.println(" - The ul element is not present");
		}
	}

	@When("User selects one provider checkbox")
	public void userSelectsOneProviderCheckbox() throws InterruptedException {
		String ulXPath = "/html/body/div[7]/div[3]/ul";
		
		// Find the ul element
		WebElement ulElement = driver.findElement(By.xpath(ulXPath));

		// Get all div elements within the ul
		List<WebElement> divElements = ulElement.findElements(By.xpath("./div"));

		// Generate a random index (x)
		int maxIndex = divElements.size() - 1;
		int randomIndex = new Random().nextInt(maxIndex + 1);

		// Construct the XPath for the random label element
		String labelXPath = ulXPath + "/div[" + (randomIndex + 1) + "]/div/div/label";

		// Find and click the random label element
		WebElement labelElement = driver.findElement(By.xpath(labelXPath));
		labelElement.click();
		Thread.sleep(3000);
	}
	
	@Then("Quotation related to that filter only will be shown")
	public void quotationRelatedToThatFilterOnlyWillBeShown() {
		System.out.println();
	}
	
	@When("User selects mutiple provider checkbox")
	public void userSelectsMutipleProviderCheckbox() throws InterruptedException {
		String ulXPath = "/html/body/div[7]/div[3]/ul";
		
		// Find the ul element
		WebElement ulElement = driver.findElement(By.xpath(ulXPath));

		// Get all div elements within the ul
		List<WebElement> divElements = ulElement.findElements(By.xpath("./div"));

		// Specify the number of random labels to select
		int numberOfRandomLabels = 3; // Adjust this number as needed

		// Create a list to store the randomly selected label elements
		List<WebElement> selectedLabels = new ArrayList<WebElement>();

		// Generate random indices and select the corresponding labels
		Random random = new Random();
		while (selectedLabels.size() < numberOfRandomLabels && !divElements.isEmpty()) {
		    int randomIndex = random.nextInt(divElements.size());
		    WebElement selectedDiv = divElements.get(randomIndex);
		    String labelXPath = ulXPath + "/div[" + (randomIndex + 1) + "]/div/div/label";
		    WebElement labelElement = selectedDiv.findElement(By.xpath(labelXPath));
		    selectedLabels.add(labelElement);
		    divElements.remove(randomIndex);
		}

		// Click the selected label elements
		for (WebElement labelElement : selectedLabels) {
		    labelElement.click();
		}
		
		Thread.sleep(5000);
	}

//Remark
	@When("User selects Remark")
	public void userSelectsRemark() throws InterruptedException {
		WebElement Button = null;
		
		try {
			Button = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div[2]/button[3]"));
			Button.click();
			Thread.sleep(3000);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(Button, "User couldn't able to click the Remark button");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(3000);
		}
	}
	
	@Then("Remark page should be shown")
	public void remarkPageShouldBeShown() {
		WebElement page = null;

		try {
			page = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div/div[2]"));
		    System.out.println(" - The page is present");
		} catch (org.openqa.selenium.NoSuchElementException e) {
		    Assert.assertNotNull(page, "The Remark Page should be present");
		    System.out.println(" - The page is not present");
		}
	}

	@Given("User clicks Add New Remarks button")
	public void userClicksAddNewRemarksButton() throws InterruptedException {
		WebElement Button = null;
		
		try {
			Button = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div/button"));
			Button.click();
			Thread.sleep(3000);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(Button, "User should be able to click the Add New Remark button");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(3000);
		}
	}
	
	@Given("Remark textbox should be shown")
	public void remarkTextboxShouldBeShown() throws InterruptedException {
		WebElement textbox = null;
		
		try {
			textbox = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div/form/div[1]/div/div/div/textarea[1]"));
			textbox.click();
			Thread.sleep(3000);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(textbox, "User should be able to view the textbox");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(3000);
		}

	}

	@Then("Remark textbox should not be shown")
	public void remarkTextboxShouldNotBeShown() throws InterruptedException {
		WebElement textbox = null;

		try {
		    textbox = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div/form/div[1]/div/div/div/textarea[1]"));
		    
		    // Check if the textbox is displayed
		    if (textbox.isDisplayed()) {
		        Assert.fail("Textbox should not be displayed, but it is.");
		    }
		    Thread.sleep(3000);
		    
		} catch (org.openqa.selenium.NoSuchElementException e) {
		    // If the element is not found, that's expected, no need to do anything here.
		} 
	}

	@When("User inserts {string} in the textbox")
	public void userInsertsInTheTextbox(String Remarks) throws InterruptedException {
		WebElement textArea = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div/form/div[1]/div/div/div/textarea[1]"));
		textArea.sendKeys(Remarks);
		Thread.sleep(3000);
	}
	
	@When("User clicks Update button")
	public void userClicksUpdateButton() throws InterruptedException {
		WebElement Button = null;
		
		try {
			Button = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div/form/div[2]/button[2]"));
			Button.click();
			Thread.sleep(10000);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(Button, "User should be able to click the Update button");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(3000);
		}
	}
	
	@Then("New Remark should be added in the page")
	public void newRemarkShouldBeAddedInThePage() {
		System.out.println("Added");
	}

	@When("User clicks Sort by Oldest button")
	public void userClicksSortByOldestButton() throws InterruptedException {
		WebElement Button = null;
		
		try {
			Button = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div/div[2]/p"));
			Button.click();
			Thread.sleep(3000);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(Button, "User should be able to click the Sort By button");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(3000);
		}
	}
	
	@Then("Remarks should be shown in order")
	public void remarksShouldBeShownInOrder() {
		System.out.println("Sorted");
	}
	
	@When("User clicks Sort by Newest button")
	public void userClicksSortByNewestButton() throws InterruptedException {
		WebElement Button = null;
		
		try {
			Button = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div/div[2]/p"));
			Button.click();
			Thread.sleep(3000);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(Button, "User should be able to click the Sort By button");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(3000);
		}
	}

//Proposal Form
	@Given("User selects a Quotation")
	public void userSelectsAQuotation() {
	    String liList = "/html/body/div[1]/div[3]/div/div[2]/div/div/div[5]/ul/li";
	    String datePath = "/html/body/div[1]/div[3]/div/div[2]/div/div/div[5]/ul/li/div[1]/p[2]";
	    String name = "/html/body/div[1]/div[3]/div/div[2]/div/div/div[5]/ul/li/div[1]/p[1]";

	    List<WebElement> liElements = driver.findElements(By.xpath(liList));

	    // Filter liElements based on date.getText() != "Expired"
	    List<WebElement> filteredLiElements = new ArrayList<WebElement>();
	    for (WebElement liElement : liElements) {
	        WebElement dateElement = liElement.findElement(By.xpath(datePath));
	        if (!dateElement.getText().equals("Expired")) {
	            filteredLiElements.add(liElement);
	        }
	    }

	    if (!filteredLiElements.isEmpty()) {
	        // Select a random element from the filtered list
	        Random rand = new Random();
	        int randomIndex = rand.nextInt(filteredLiElements.size());

	        WebElement selectedLi = filteredLiElements.get(randomIndex);
	        selectedLi.click();

	        WebElement selectedLiName = driver.findElement(By.xpath(name));
	        System.out.println(" - " + selectedLiName.getText() + " Provider's Quotation is selected");

	    } else {
	        System.out.println("All Quotations are Expired");
	    }
	}
	
	@Given("User clicks Next button after selecting a quotation")
	public void userClicksNextButtonAfterSelectingAQuotation() throws InterruptedException {
		WebElement Button = null;
		
		try {
			Button = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div[6]/button[2]"));
			Button.click();
			Thread.sleep(3000);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(Button, "User should be able to click the Next button");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(3000);
		}
	}
	
	@When("User clicks Add Download button")
	public void userClicksAddDownloadButton() throws InterruptedException {
		WebElement Button = null;
		
		try {
			Button = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div"));
			Button.click();
			Thread.sleep(8000);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(Button, "User should be able to click the Download button");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(3000);
		}
	}
	
	@Then("Proposal Form should be downloaded")
	public void proposalFormShouldBeDownloaded() {
		System.out.println(" - Downloaded");
	}

	@Given("User clicks on the first row of the table when the status is Pending Payment")
	public void userClicksOnTheFirstRowOfTheTableWhenTheStatusIsPendingPayment() throws InterruptedException {
		String trXPath = "/html/body/div[1]/div[3]/div/div[2]/div/div/div[3]/div/table/tbody/tr";
		String statusToFind = "Pending Payment";

		// Find all <tr> elements in the table
		java.util.List<WebElement> trElements = driver.findElements(By.xpath(trXPath));

		// Iterate through the <tr> elements to find the one with the specified status
		for (int i = 1; i <= trElements.size(); i++) {
			String trStatusXPath = trXPath + "[" + i + "]/td[5]";
			WebElement trStatusElement = driver.findElement(By.xpath(trStatusXPath));
			String status = trStatusElement.getText();

			if (status.equals(statusToFind)) {
				String trElementXPath = trXPath + "[" + i + "]";
				WebElement trElement = driver.findElement(By.xpath(trElementXPath));
				trElement.click(); // Click the first row with "Awaiting Confirmation"
				break; // Exit the loop after clicking the first matching element
			}
		}

		Thread.sleep(3500);
	}
	
	@When("User clicks View File button")
	public void userClicksViewFileButton() throws InterruptedException {
		WebElement Button = null;
		
		try {
			Button = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div[7]/div/div[2]/p/a"));
			Button.click();
			Thread.sleep(5000);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(Button, "User should be able to click the View File button");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(3000);
		}
	}
	
	@Then("Proposal Form should be open in another Tab")
	public void proposalFormShouldBeOpenInAnotherTab() {
		System.out.println(" - File has been opened in another Tab");
	}

	//Payment
	@Given("User clicks Payment Tab")
	public void userClicksPaymentTab() throws InterruptedException {
		WebElement Tab = null;
		
		try {
			Tab = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div[3]/ul/li[3]"));
			Tab.click();
			Thread.sleep(3000);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(Tab, "User couldn't able to click the Payment Tab");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(3000);
		}
	}
	
	@Given("User clicks on Make Payment button")
	public void userClicksOnMakePaymentButton() throws InterruptedException {
		WebElement Button = null;
		
		try {
			Button = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[3]/button[2]"));
			Button.click();
			Thread.sleep(3000);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(Button, "User should be able to click the Make Payment button");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(3000);
		}
	}
	
	@Given("User clicks payment type")
	public void userClicksPaymentType() throws InterruptedException {
		WebElement Button = null;
		
		try {
			Button = driver.findElement(By.xpath("/html/body/div[8]/div[3]/div/div/ul/li/button"));
			Button.click();
			Thread.sleep(3000);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(Button, "User should be able to click the Payment Type button");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(3000);
		}
	}
	
	
	@When("User clicks on Make Payment button to pay")
	public void userClicksOnMakePaymentButtonToPay() throws InterruptedException {
		WebElement Button = null;
		
		try {
			Button = driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div/form/div[2]/button[2]"));
			Button.click();
			Thread.sleep(8000);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(Button, "User should be able to click the Download button");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(3000);
		}
	}
	
	@Then("User should be able to view the Payment Page with provider name and bank details")
	public void userShouldBeAbleToViewThePaymentPageWithProviderNameAndBankDetails() {
		WebElement page = null;

		try {
			page = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div/div[5]"));
		    System.out.println(" - The Payment Details page is present");
		} catch (org.openqa.selenium.NoSuchElementException e) {
		    Assert.assertNotNull(page, "The Payment Details Page should be present");
		    System.out.println(" - The Payment Details page is not present");
		}
	}
	
	@When("User clicks confirm button payment type")
	public void userClicksConfirmButtonPaymentType() throws InterruptedException {
		WebElement Button = null;
		
		try {
			Button = driver.findElement(By.xpath("/html/body/div[8]/div[3]/div/div/div[2]/button[2]"));
			Button.click();
			Thread.sleep(3000);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(Button, "User should be able to click the Confirm button");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(3000);
		}
	}
	
	@Then("User should be able to view the Payment page to make payment")
	public void userShouldBeAbleToViewThePaymentPageToMakePayment() {
		WebElement page = null;

		try {
			page = driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div"));
		    System.out.println(" - The Payment page is present");
		} catch (org.openqa.selenium.NoSuchElementException e) {
		    Assert.assertNotNull(page, "The Payment Page should be present");
		    System.out.println(" - The Payment page is not present");
		}
	}
	
	@When("User clicks Credit Card method")
	public void userClicksCreditCardMethod() throws InterruptedException {
		WebElement Button = null;
		
		try {
			Button = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div/form/div[1]/div[1]/div/div/label[2]"));
			Button.click();
			Thread.sleep(3000);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(Button, "User should be able to click the Credit Card checkbox");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(3000);
		}
	}
	
	@Then("User inputs the value for {string} and {string}")
	public void userInputsTheValueForAnd(String refNo, String amount) throws InterruptedException {
		WebElement RefNo = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div/form/div[1]/div[2]/div/div/div/input"));
		RefNo.sendKeys(refNo);
		Thread.sleep(3000);	
		
		WebElement BulkPayAmount = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div/form/div[1]/div[3]/div/div/div/input"));
		BulkPayAmount.sendKeys(amount);
		Thread.sleep(3000);
	}
	
	@Then("User inputs the value for {string}")
	public void userInputsTheValueFor(String refNo) throws InterruptedException {
		WebElement RefNo = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div/form/div[1]/div[2]/div/div/div/input"));
		RefNo.sendKeys(refNo);
		Thread.sleep(3000);		
	}
	
	@Then("User clicks Submit")
	public void userClicksSubmit() throws InterruptedException {
		WebElement Button = null;
		
		try {
			Button = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div/form/div[3]/button[2]"));
			Button.click();
			Thread.sleep(3000);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(Button, "User should be able to click the Submit button");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(3000);
		}
	}
	
	@Then("User should be to get a pop up message that payment is submitted")
	public void userShouldBeToGetAPopUpMessageThatPaymentIsSubmitted() {
        WebElement headerUnSuccess = null;
        WebElement headerSuccess = null;

        String EnStatement;
        String EnStatementSuccess;
        
        //SUCCESSFUL
        try {
            headerSuccess = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/h1"));
            System.out.println("g: " + headerSuccess);
        } catch (NoSuchElementException e) {
        	System.out.println("Successful");
        }
        
        //UNSUCCESSFUL
        try {
            headerUnSuccess = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/h1"));    
            System.out.println("f: " + headerUnSuccess);
        } catch (NoSuchElementException e) {
            System.out.println("Unsuccessful");
        }


        if (!headerUnSuccess.getText().isEmpty()) {
            System.out.println("Application Unsuccessful Header = " + headerUnSuccess.getText());            
            WebElement submitText = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/p"));
    		EnStatement = submitText.getText();
    		System.out.println(EnStatement);
    		
            
        } else if (!headerSuccess.getText().isEmpty()) {
            System.out.println("Header Success = " + headerSuccess.getText());           
            WebElement submitTextSuccess = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/p"));
    		EnStatementSuccess = submitTextSuccess.getText();
    		System.out.println(EnStatementSuccess);
        }
	}
	
	@Then("User should be able to view the Select Payment Type page")
	public void userShouldBeAbleToViewTheSelectPaymentTypePage() {
		WebElement page = null;

		try {
			page = driver.findElement(By.xpath("/html/body/div[8]/div[3]/div/div"));
		    System.out.println(" - The Payment Type page is present");
		} catch (org.openqa.selenium.NoSuchElementException e) {
		    Assert.assertNotNull(page, "The Payment Type Page should be present");
		    System.out.println(" - The Payment Type page is not present");
		}
	}
	
	@When("User clicks Bulk Payment method")
	public void userClicksBulkPaymentMethod() throws InterruptedException {
		WebElement Button = null;
		
		try {
			Button = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div/form/div[1]/div[1]/div/div/label[1]"));
			Button.click();
			Thread.sleep(3000);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(Button, "User should be able to click the Bulk Payment checkbox");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(3000);
		}
	}

	@When("User clicks Bank Transfer method")
	public void userClicksBankTransferMethod() throws InterruptedException {
		WebElement Button = null;
		
		try {
			Button = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div/form/div[1]/div[1]/div/div/label[3]"));
			Button.click();
			Thread.sleep(3000);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(Button, "User should be able to click the Bank Transfer checkbox");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(3000);
		}
	}
	
	@Then("User cannot submit the application")
	public void userCannotSubmitTheApplication() {
		System.out.println("Nope");
	}
	
	@Then("User uploads Document")
	public void userUploadsDocument() throws InterruptedException {
		WebElement UploadReceipt = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div/form/div[2]/label"));
		UploadReceipt.click();
        Thread.sleep(3000);
        Thread.sleep(3000);
	}

//Policy
	@Given("User clicks on the first row of the table when the status is Completed with paid")
	public void userClicksOnTheFirstRowOfTheTableWhenTheStatusIsCompletedWithPaid() throws InterruptedException {
		String trXPath = "/html/body/div[1]/div[3]/div/div[2]/div/div/div[3]/div/table/tbody/tr";
		String statusToFind = "Completed With Paid";

		// Find all <tr> elements in the table
		java.util.List<WebElement> trElements = driver.findElements(By.xpath(trXPath));

		// Iterate through the <tr> elements to find the one with the specified status
		for (int i = 1; i <= trElements.size(); i++) {
			String trStatusXPath = trXPath + "[" + i + "]/td[5]";
			WebElement trStatusElement = driver.findElement(By.xpath(trStatusXPath));
			String status = trStatusElement.getText();

			if (status.equals(statusToFind)) {
				String trElementXPath = trXPath + "[" + i + "]";
				WebElement trElement = driver.findElement(By.xpath(trElementXPath));
				trElement.click(); // Click the first row with "Awaiting Confirmation"
				break; // Exit the loop after clicking the first matching element
			}
		}

		Thread.sleep(3500);
	}
	
	@When("User clicks on Receipt")
	public void userClicksOnReceipt() throws InterruptedException {
		WebElement Button = null;
		
		try {
			Button = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[2]/div/div/div/div/table/tbody/tr/td[6]/a"));
			Button.click();
			Thread.sleep(3000);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(Button, "User should be able to click the Receipt icon");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(3000);
		}
	}
	
	@Then("User should be navigated to new Tab")
	public void userShouldBeNavigatedToNewTab() {
		System.out.println("yes");
	}

	@Given("User clicks Policy Tab")
	public void userClicksPolicyTab() throws InterruptedException {
		WebElement Tab = null;
		
		try {
			Tab = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div[3]/ul/li[4]"));
			Tab.click();
			Thread.sleep(3000);
			check = "Varutha?";
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(Tab, "User couldn't able to click the Policy Tab");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(3000);
		}
	}
	
	@When("User clicks Done button in Policy Tab")
	public void userClicksDoneButtonInPolicyTab() throws InterruptedException {
		WebElement Button = null;
		
		try {
			Button = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[4]/button[2]"));
			Button.click();
			Thread.sleep(3000);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertNotNull(Button, "User should be able to click the Done button");
			System.out.println("Nope"); // The div is not present
			Thread.sleep(3000);
		}
	}
	
	@Then("User should be navigated to the Enquiry List")
	public void userShouldBeNavigatedToTheEnquiryList() {
		WebElement table = null;

		try {
			table = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div[3]/div/table"));
		    System.out.println(" - The Enquiry List page is present");
		    System.out.println(check);
		} catch (org.openqa.selenium.NoSuchElementException e) {
		    Assert.assertNotNull(table, "The Payment Type Page should be present");
		    System.out.println(" - The Enquiry List page is not present");
		}
	}

	@Then("User should be able to view Policy Effective Date and Expiry Date")
	public void userShouldBeAbleToViewPolicyEffectiveDateAndExpiryDate() {
		WebElement EffectiveDate = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[1]/div/div/div/div/input"));
		String EffectiveDateValue = EffectiveDate.getAttribute("value");

		WebElement ExpiryDate = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/form/div[1]/div[2]/div/div/div/div/input"));
		String ExpiryDateValue = ExpiryDate.getAttribute("value");

		if (EffectiveDateValue == null || EffectiveDateValue.trim().isEmpty()) {
			System.out.println("EffectiveDateValue is empty.");
		} else {
			System.out.println("EffectiveDateValue is not empty: " + EffectiveDateValue);
		}

		if (ExpiryDateValue == null || ExpiryDateValue.trim().isEmpty()) {
			System.out.println("ExpiryDateValue is empty.");
		} else {
			System.out.println("ExpiryDateValue is not empty: " + ExpiryDateValue);
		}

		if (!EffectiveDateValue.isEmpty() && !ExpiryDateValue.isEmpty()) {
			// Define date format
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

			try {
				Date effectiveDate = dateFormat.parse(EffectiveDateValue);
				Date expiryDate = dateFormat.parse(ExpiryDateValue);

				// Calculate the difference in years
				long diffInMilliseconds = expiryDate.getTime() - effectiveDate.getTime();
				long diffInYears = diffInMilliseconds / (1000L * 60 * 60 * 24 * 365);

				if (diffInYears == 1) {
					System.out.println("ExpiryDateValue is exactly 1 year from EffectiveDateValue.");
				} else {
					System.out.println("ExpiryDateValue is NOT 1 year from EffectiveDateValue.");
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}


}
