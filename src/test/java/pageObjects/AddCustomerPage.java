package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {
	public WebDriver driver;

	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	By lnkCustomers_menu = By.xpath("//a[@href='#']/*[contains(text(),'Customers')]");
	By lnkCustomers_menuitem = By.xpath(
			"//a[@href='#']/*[contains(text(),'Customers')]/../following-sibling::ul/li/a/*[contains(text(),'Customers')]");

	By btnAddnew = By.xpath("//a[@class='btn btn-primary']");

	By txtEmail = By.id("Email");
	By txtPassword = By.id("Password");

	By txtcustomerRoles = By.xpath("");

	By lstitemAdministrators = By.xpath("//li[contains(text(),'Administrators')]");
	By lstitemForumModerators = By.xpath("//li[contains(text(),'Forum Moderators')]");
	By lstitemRegistered = By.xpath("//li[contains(text(),'Registered')]");
	By lstitemGuests = By.xpath("//li[contains(text(),'Guests')]");
	By lstitemVendors = By.xpath("//li[contains(text(),'Vendors')]");

	By drpmgrofVendor = By.xpath("//*[@id='VendorId']");
	By rdMaleGender = By.id("Gender_Male");
	By rdFeMaleGender = By.id("Gender_Female");

	By txtFirstName = By.xpath("//input[@id='FirstName']");
	By txtLastName = By.xpath("//input[@id='LastName']");
	By txtDob = By.xpath("//input[@id='DateOfBirth']");
	By txtCompanyName = By.xpath("//input[@id='Company']");

	By txtAdminContent = By.xpath("//*[@id='AdminComment']");
	By btnsave = By.xpath("//*[@name='save']");

//	Action Methods

	public String getPageTitle() {
		return driver.getTitle();

	}

	public void clickOnCustomersMenu() {
		driver.findElement(lnkCustomers_menu).click();
	}

	public void clickOnCustomersMenuItem() {
		driver.findElement(lnkCustomers_menuitem).click();
	}

	public void clickOnAddnew() {
		driver.findElement(btnAddnew).click();
	}

	public void setEmail(String email) {
		driver.findElement(txtEmail).sendKeys(email);
	}

	public void setPassword(String pwd) {
		driver.findElement(txtEmail).sendKeys(pwd);
	}

	public void setCustomerRoles(String role) {
		if (!role.equals("Vendors")) {
			driver.findElement(By.xpath("//ul[@class='select2-selection__rendered']/li/span")).click();
		}
//		driver.findElement(txtcustomerRoles).click();
		WebElement listitem;

		if (role.equals("Administrators")) {
			listitem = driver.findElement(lstitemAdministrators);
		} else if (role.equals("Guests")) {
			listitem = driver.findElement(lstitemGuests);
		} else if (role.equals("Registered")) {
			listitem = driver.findElement(lstitemRegistered);
		} else if (role.equals("Vendors")) {
			listitem = driver.findElement(lstitemVendors);
		} else {
			listitem = driver.findElement(lstitemGuests);
		}
		listitem.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;

//		js.executeScript("arguments[0].click()", listitem);

	}

	public void setmanagerOfVendor(String value) {
		Select select = new Select(driver.findElement(drpmgrofVendor));
		select.selectByVisibleText(value);
	}

	public void setGender(String gender) {
		if (gender.equals("Male")) {
			driver.findElement(rdMaleGender).click();
		} else if (gender.equals("FeMale")) {
			driver.findElement(rdFeMaleGender).click();

		} else {
			driver.findElement(rdMaleGender).click();

		}

	}

	public void setFirstName(String firstName) {
		driver.findElement(txtFirstName).sendKeys(firstName);
	}

	public void setLastName(String lastName) {
		driver.findElement(txtFirstName).sendKeys(lastName);
	}

	public void setDOB(String dob) {
		driver.findElement(txtDob).sendKeys(dob);
	}

	public void setCompanyName(String comname) {
		driver.findElement(txtCompanyName).sendKeys(comname);
	}

	public void setAdminContent(String content) {
		driver.findElement(txtAdminContent).sendKeys(content);
	}

	public void clickonSave() {
		driver.findElement(btnsave).click();
		;
	}
}
