package Stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class loginstepdefinition {
	WebDriver driver;

	@Given("user navigate  to webpage")
	public void user_navigate_to_webpage() {
		// System.out.println("DataSet");
		driver = new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/");
		driver.manage().window().maximize();
	}

	@When("user enter proper username and password")
	public void user_enter_proper_username_and_password() throws InterruptedException {
		WebElement registerbutton = driver.findElement(By.xpath("//div[@class='login-btn']/a[text()='Register']"));
		registerbutton.click();
		Set<String> childwindows = driver.getWindowHandles();
		String parentWindow = driver.getWindowHandle();
		for (String childwindow : childwindows) {
			if (!childwindow.equalsIgnoreCase(parentWindow)) {
				driver.switchTo().window(childwindow);
			}
		}

		WebElement name = driver.findElement(By.xpath("//input[@id='name']"));
		name.sendKeys("Abhishek Basu");
		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
		email.sendKeys("infobasu96@gmail.com");
		WebElement chkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
		chkbox.click();
		WebElement sendCode = driver.findElement(By.xpath("//button[@id='otp-login-btn']/span[text()='Send code']"));
		sendCode.click();
		Thread.sleep(3000);
		WebElement login = driver.findElement(By.xpath("//a[@class='uni-ml-4 troubleShootBtn']"));
		login.click();

	}

	@When("user click on login button")
	public void user_click_on_login_button() {
		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
		email.sendKeys("infobasu96@gmail.com");
		WebElement loginButton = driver.findElement(By.xpath("//button[@id='otp-login-btn']"));
		loginButton.click();
	}

	@Then("check able to signin to the website successfully")
	public void check_able_to_signin_to_the_website_successfully() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Given("user click on logout button")
	public void user_click_on_logout_button() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	String data = null;
	Properties prp;

	@Given("navigate to properties file")
	public void navigate_to_properties_file() throws IOException {
		prp = new Properties();
		FileInputStream fls = new FileInputStream(
				"C:\\NewWorkspsce\\BddFrameWork\\src\\test\\java\\resources\\Proparty.properties");
		prp.load(fls);

	}

	@When("enter {string} to the property file")
	public void enter_to_the_property_file(String key) {
		data = prp.getProperty(key).toString();
		System.out.println("data---->" + data);
	}

	@Then("I validate URL contains {string}")
	public void i_validate_url_contains(String expectedcheck) {
		System.out.println("ABCD");
		String data2 = data;
		System.out.println("ABC");
		System.out.println("data2---->" + data2);
		System.out.println("expectedcheck---->" + expectedcheck);
		if (data2.contains(expectedcheck)) {
			System.out.println("data Printed");
		} else {
			System.out.println("Issue");
		}
	}

}
