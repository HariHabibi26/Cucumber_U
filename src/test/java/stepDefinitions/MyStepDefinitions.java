package stepDefinitions;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;

public class MyStepDefinitions extends BaseClass {
	@org.junit.Before
	public void before() {
		System.out.println("before");
	}

//	@Before
//	public void beforeAll() {
//		System.out.println("beforeAll");
//	}

	@org.junit.After
	public void after() {
		System.out.println("after");
	}

//	@AfterAll
//	public void afterAll() {
//		System.out.println("afterAll");
//	}

	@Given("^User launch chrome Driver$")
	public void user_launch_chrome_driver() throws Throwable {
		logger = Logger.getLogger("SeleniumCucumber");
		PropertyConfigurator.configure("log4j.properties");

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		logger.info("*********Launching Browser**********");
		lp = new LoginPage(driver);
	}

	@When("^User opens URL \"([^\"]*)\"$")
	public void user_opens_url_something(String strArg1) throws Throwable {
		logger.info("*********Opening url**********");

		driver.get(strArg1);

		driver.manage().window().maximize();
	}

	@When("^User Click on Log out Link$")
	public void user_click_on_log_out_link() throws Throwable {
		lp.clickLogout();
		Thread.sleep(3000);
	}

	@Then("^Page title should be \"([^\"]*)\"$")
	public void page_title_should_be_something(String strArg1) throws Throwable {
		if (driver.getPageSource().contains("Login was unsuccessful.")) {

			driver.close();
			logger.info("*********Login Passed**********");

			org.junit.Assert.assertTrue(false);

		} else {
			logger.info("*********Login failed**********");

			Assert.assertEquals(strArg1, driver.getTitle());
		}
	}

	@And("^User Enters Email as \"([^\"]*)\"  and Password is \"([^\"]*)\"$")
	public void user_enters_email_as_something_and_password_is_something(String strArg1, String strArg2)
			throws Throwable {
		logger.info("*********Providing login Credentials**********");

		lp.setUserName(strArg1);

		lp.setPassword(strArg2);
	}

	@And("^Click on Login$")
	public void click_on_login() throws Throwable {
		logger.info("*********Started Login **********");

		lp.clickLogin();
	}

	@And("^Close Browser$")
	public void close_browser() throws Throwable {
		logger.info("*********Closing Browser**********");

		driver.quit();
	}

//	Customer Feature step Definitions............

	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
		addCust = new AddCustomerPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", addCust.getPageTitle());

	}

	@When("User click on Customers menu")
	public void user_click_on_customers_menu() throws Throwable {
		Thread.sleep(3000);
		addCust.clickOnCustomersMenu();
	}

	@When("click on Customers Menu Item")
	public void click_on_customers_menu_item() throws InterruptedException {
		Thread.sleep(2000);
		addCust.clickOnCustomersMenuItem();
	}

	@When("click on Add new button")
	public void click_on_add_new_button() throws InterruptedException {
		addCust.clickOnAddnew();
		Thread.sleep(2000);
	}

	@Then("USer can view Add new customer page")
	public void u_ser_can_view_add_new_customer_page() {
		Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getPageTitle());

	}

	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
		String email = randomestring() + "@gmail.com";
		addCust.setEmail(email);
		addCust.setPassword("Test123");

		addCust.setCustomerRoles("Guests");
		Thread.sleep(3000);

		addCust.setmanagerOfVendor("Vendor 2");
		addCust.setGender("Male");
		addCust.setFirstName("Hello");
		addCust.setLastName("Bye");
		addCust.setDOB("9/09/1999");
		addCust.setCompanyName("busyGuy");
		addCust.setAdminContent("This is for Intellectuals.....");

	}

	@When("click on save button")
	public void click_on_save_button() throws InterruptedException {
		addCust.clickonSave();
		Thread.sleep(2000);
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String msg) {
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains(msg));
	}
}