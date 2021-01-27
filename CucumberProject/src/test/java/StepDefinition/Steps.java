package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {
	static WebDriver driver;
	@Given("^I am on the Login page$")
	public void i_am_on_the_Login_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Desktop\\cucumber\\CucumberProject\\Drivers\\chromedriver.exe");
	    driver=new ChromeDriver();
	    driver.get("https://www.amazon.in/");
	    driver.manage().window().maximize();
	    Thread.sleep(10000);
	    driver.findElement(By.xpath("//a[@id='nav-link-accountList']")).click();
	    Thread.sleep(3000);
	   
	     
	}

	@When("^enter username$")
	public void enter_username() throws Throwable {
		 Thread.sleep(5000);
	driver.findElement(By.id("ap_email")).sendKeys("9666603718");
	
	driver.findElement(By.id("continue")).click();
	
	    
	     
	}

	@Then("^enter password$")
	public void enter_password() throws Throwable {
		driver.findElement(By.id("ap_password")).sendKeys("9666603718");	
		
	     
	}

	@Then("^enter submit$")
	public void enter_submit() throws Throwable {
		driver.findElement(By.id("continue")).click();
	    
	     
	}
}
