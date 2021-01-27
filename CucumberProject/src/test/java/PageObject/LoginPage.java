package PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
@FindBy(xpath="//a[@id='nav-link-accountList']")
WebElement loginbutton;
@FindBy(id="continue")
WebElement username;
@FindBy(id="ap_email")
WebElement password;
@FindBy(id="ap_passwod")
WebElement submitbutton;
public void flipkart() {
	username.sendKeys("9666603718");
	password.sendKeys("9666603718");
	submitbutton.click();
}
}

