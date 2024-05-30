package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\HarshavardhanSallepa\\Automation\\SeleniumCucumber2\\Features\\Customers.feature", glue = "stepDefinitions", dryRun = false, monochrome = true, plugin = {
		"pretty", "html:test-output" })
public class AdminLoginTestRunner {

}
