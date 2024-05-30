package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRMSteps {
	WebDriver driver;

	@Given("^I launch chrome browser$")
	public void i_launch_chrome_browser() throws Throwable {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@When("^I opened OrangeHRM Homepage$")
	public void i_opened_orangehrm_homepage() throws Throwable {
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}

	@Then("^I verify logo present on Home Page$")
	public void i_verify_logo_present_on_home_page() throws Throwable {
		Thread.sleep(4000);
		boolean status = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[1]/img"))
				.isDisplayed();
		Assert.assertEquals(true, status);
	}

	@And("^close  browser$")
	public void close_browser() throws Throwable {
		driver.close();
	}
}
