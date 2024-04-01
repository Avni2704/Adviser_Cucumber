package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import drivers.DriverInstance;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends DriverInstance {

	// WebDriver driver;
	WebDriverWait wait;
	static boolean isEmail;
	static boolean isPassword;
	static String PASSWORD;
	static String EMAIL;

	@When("User click the Login button")
	public void userClickTheLoginButton() throws InterruptedException {
		WebElement Login = driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div/div/form/button"));
		Login.click();
	}

	@Then("Login should be successful")
	public void loginShouldBeSuccessful() throws InterruptedException {
		Thread.sleep(3000);
		WebElement UserName = driver
				.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[1]/div[2]/button/div[1]/p[1]"));
		String user = UserName.getText();
		System.out.println(user);

	}

	@When("Login should be fail")
	public void loginShouldBeFail() throws InterruptedException {
		WebElement element = null;
		String validation = null;
		Thread.sleep(1000);

		if (isEmail) {

			if (EMAIL.equals("adviser.vka@gmail.com")) {
				System.out.println(" - correct email");
			} else {
				try {
					element = driver
							.findElement(By.xpath("/html/body/div[1]/main/div/div/div/div/form/p"));
					validation = element.getText();
					System.out.println(" - validation = " + validation);
				} catch (Exception e) {
					allureScreenshot();
					Assert.assertEquals(validation, "Invalid email");
				}
			}

		} else {
			try {
				element = driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div/div/form/div[1]/div/div/p"));
				validation = element.getText();
				System.out.println(" - validation = " + validation);
			} catch (Exception e) {
				allureScreenshot();
				Assert.assertEquals(validation, "This field is required.");
			}
		}

		if (isPassword) {
			try {
				if (PASSWORD.equals("VkaTest@123")) {
					System.out.println(" - correct password");
				} else {
					Thread.sleep(1500);
					element = driver
							.findElement(By.xpath("/html/body/div[1]/main/div/div/div/div/form/p"));
					validation = element.getText();

					System.out.println(" - validation = " + validation);
				}
			} catch (Exception e) {
				allureScreenshot();
				Assert.assertEquals(validation, "Invalid password");
			}
		} else {
			try {
				element = driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div/div/form/div[2]/div/div/p"));
				validation = element.getText();
				System.out.println(" - validation = " + validation);
			} catch (Exception e) {
				allureScreenshot();
				Assert.assertEquals(validation, "This field is required.");
			}
		}

		allureScreenshot();
	}

	@Given("User enter email as {string}")
	public void userEnterEmailAs(String email) {
		if (!email.isEmpty()) {
			WebElement Email = driver
					.findElement(By.xpath("/html/body/div[1]/main/div/div/div/div/form/div[1]/div/div/div/input"));
			Email.sendKeys(email);
			EMAIL = email;
			isEmail = true;
		} else {
			isEmail = false;
		}
	}

	@Given("User enter password as {string}")
	public void userEnterPasswordAs(String password) {

		if (!password.isEmpty()) {
			WebElement Password = driver
					.findElement(By.xpath("/html/body/div[1]/main/div/div/div/div/form/div[2]/div/div/div/input"));
			Password.sendKeys(password);
			PASSWORD = password;
			isPassword = true;
		} else {
			isPassword = false;
		}

	}
}
