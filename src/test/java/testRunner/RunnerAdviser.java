package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions.SnippetType;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {
				"src/test/java/features/expressQuotationV2.feature"
				},
		//dryRun = true,
		glue = { "steps", "hooks" }, 
		snippets = SnippetType.CAMELCASE,	
		monochrome = true, // TO REMOVE JUNK CHARACTERS
		tags = " not @CC",
		plugin = { "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" })

public class RunnerAdviser extends AbstractTestNGCucumberTests {

}
